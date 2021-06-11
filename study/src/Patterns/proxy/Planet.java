package Patterns.proxy;

import Patterns.Display;
import Patterns.Drawable;

import java.awt.*;

public class Planet extends Drawable {
    private Color color;
    private int radius;
    SpaceShip dockedShip;


    public int getPx() {
        return x;
    }

    public int getPy() {
        return y;
    }


    public Planet(int x, int y, int radius, int r, int g, int b) {
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
        graphics.fillArc(x - radius, y - radius, radius*2, radius*2, 0, 360);
    }

    public synchronized boolean dock(SpaceShip ship) {
        if(dockedShip == null) {
            dockedShip = ship;
            return true;
        }
        return false;
    }


    public synchronized void undock() {
        if(dockedShip != null) {
            try {
                dockedShip.undock();
            } catch (ShipHasNoDestinationException e) {
                throw new EverythingGoesBadException();
            }
            dockedShip = null;
        }
    }
}
