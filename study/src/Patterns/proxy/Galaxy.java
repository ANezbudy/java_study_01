package Patterns.proxy;

import Patterns.*;

import java.awt.*;
import java.util.ArrayList;

public class Galaxy {

    //TODO test the Mine and create the Plant

    public static void main(String[] args) {
        drawSandBox();
    }


    public static void drawSandBox() {
        final String title = "Dream Galaxy";
        final int width = Display.getWidth();
        final int height = Display.getHeight();


        long currentTime = System.currentTimeMillis();

        boolean running = true;

        Planet gekata = new Planet(200, 150, 100, 89, 67, 70);
        Mine kali = new Mine(1100, 600, 200, 100, 100, 100);

        Thread kaliThread = new Thread(kali);
        kaliThread.start();
        SpaceShip ship = new SpaceShip(gekata.getPx(), gekata.getPy(), 30, 0, 255, 127);

        Thread shipThread = new Thread(ship);


        shipThread.start();


        ArrayList<Drawable> arrayListDrawable = new ArrayList<>();
        ArrayList<Animated> arrayListAnimated = new ArrayList<>();

        arrayListDrawable.add(gekata);
        arrayListDrawable.add(kali);
        arrayListDrawable.add(ship);

        ship.addPointToRoute(kali);
        ship.addPointToRoute(gekata);
        try {
            ship.undock();
        } catch (ShipHasNoDestinationException e) {
            e.printStackTrace();
        }

        while (running) {
            Graphics graphics = Display.getInstance().getGraphics(); //getting graphics (object, with which we can draw our objects)

            graphics.clearRect(0, 0, width, height);  //  очистка

            /////////// время
            long newTime = System.currentTimeMillis();
            long timePast = newTime - currentTime;
            currentTime = newTime;

            //  рисуем статич объекты
            for (Drawable temp : arrayListDrawable) {
                temp.draw();
            }

            for (Animated temp : arrayListAnimated) {
                temp.update(timePast);
                //temp.draw(graphics);
            }

            Display.getInstance().show(); // show our drawing on screen
        }
    }
    //DONE to make all elements of the picture like an objects in object model
    //TODO implement the fabric pattern for objects
}
