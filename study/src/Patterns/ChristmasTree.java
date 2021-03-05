package Patterns;

import java.awt.*;
import java.util.ArrayList;

public class ChristmasTree {

    public static void main(String[] args) {
        drawSandBox();
    }


    public static void drawSandBox() {
        drawTheHause();
    }


    private static void drawTheHause() {
        final String title = "Dream House";
        final int width = Display.getWidth();
        final int height = Display.getHeight();


        boolean running = true;


        while (running) {
            Graphics graphics = Display.getInstance().getGraphics();

            // set personal print
            Font font = new Font("Arial", Font.PLAIN, 10);
            graphics.setFont(font);
            graphics.drawString("Nezbudii A", 10, 10);

            // draw moon
            choseColor(255, 255, 51, graphics);
            graphics.fillOval(1200, 100, 150, 100);


            // draw the land
            choseColor(255, 255, 255, graphics);
            for (int i = 0; i < 450; i++) {
                graphics.drawLine(0, 450 + i, 1600, 550 + i);
            }

            ArrayList<Construction> buildingConstructions = new ArrayList<>();

            Building building = new Building(230, 400, 122, 95, 69);
            buildingConstructions.add(building);

            Chimney chimney = new Chimney(building, 92, 75, 39);
            buildingConstructions.add(chimney);

            Roof roof = new Roof(building, 134, 60, 57);
            buildingConstructions.add(roof);

            Door door = new Door(building, 71, 58, 31);
            buildingConstructions.add(door);

            Window window_1 = new Window(260, 425, 82, 255, 233);
            Window window_2 = new Window(460, 425, 82, 255, 233);
            buildingConstructions.add(window_1);
            buildingConstructions.add(window_2);

            for (Construction b: buildingConstructions) {
                b.draw();
            }

            Display.getInstance().show(); // show our drawing on screen
        }
    }

    private static void choseColor(int r, int g, int b, Graphics graphics) {
        Color color = new Color(r, g, b);
        graphics.setColor(color);
    }

    //DONE to make all elements of the picture like an objects in object model
    //TODO implement the fabric pattern for objects

}
