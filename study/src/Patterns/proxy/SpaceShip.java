package Patterns.proxy;

import Patterns.Display;
import Patterns.Drawable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Drawable implements Runnable {

    private Color color;
    private int radius;
    private boolean isFlying = false;
    private double speed = 15;

    private Planet destination;
    private double x;
    private double y;
    private static final double capacity = 20;
    private double load = 0;
    private String loadDescription;
    List<Planet> destinations =  new ArrayList<Planet>();


    public SpaceShip(double x, double y, int radius, int r, int g, int b) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = new Color(r, g, b);
    }

    @Override
    public void draw() {
        Graphics graphics = Display.getInstance().getGraphics();
        // draw the door
        graphics.setColor(color);
        graphics.fillArc((int)(x - radius/2), (int)(y - radius), radius, radius*2, 0, 360);
    }

    public void addPointToRoute(Planet planet) {
        destinations.add(planet);
    }

    public void flyToNextPoint() throws ShipHasNoDestinationException {
        if(destinations.isEmpty()) {
            throw new ShipHasNoDestinationException();
        }

        setCourse(destinations.remove(0));
    }

    public void undock() throws ShipHasNoDestinationException {
        flyToNextPoint();
    }


    public void setCourse(Planet destination) {
        this.destination = destination;
        isFlying = true;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
//            System.out.println("Ship load: " + load);
            if (isFlying) {
                if (Math.abs(x - destination.getPx()) <= speed && Math.abs(y - destination.getPy()) <= speed )  {
                    x = destination.getPx();
                    y = destination.getPy();
                    isFlying = !destination.dock(this);
                } else {
                    double dX = destination.getPx() - x;
                    double dY = destination.getPy() - y;

                    double k = Math.sqrt(dX * dX + dY * dY)/speed;
                    double vX = dX/k;
                    double vY = dY/k;

                    x = x + vX;
                    y = y + vY;

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        }
    }

    public void batchLoad(double batch) throws ShipOverloadedException {
        if(load + batch <= capacity) {
            load += batch;
        } else {
            throw new ShipOverloadedException();
        }
    }

    public double batchUnload(double batch) {
        if (load < batch) {
            double temp = load;
            load = 0;
            return temp;
        } else {
            load = load - batch;
            return batch;
        }
    }

    public double getFreeCapacity() {
        return capacity - load;
    }

    public double getLoad() {
        return load;
    }
}
