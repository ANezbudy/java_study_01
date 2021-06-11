package Patterns;

import java.awt.*;

public class Door extends Construction{

    public Door(Building building, int r, int g, int b) {
        super(building.getX(), building.getY(), r, g, b);
    }

    @Override
    public void draw() {
        Graphics graphics = Display.getInstance().getGraphics();
        int x = super.getX();
        int y = super.getY();
        // draw the door
        graphics.setColor(super.getColor());
        graphics.fillArc(x + 140, y + 80, 50, 200, 0, 180);
    }
}
