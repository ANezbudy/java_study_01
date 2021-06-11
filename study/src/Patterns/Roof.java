package Patterns;

import java.awt.*;

public class Roof extends Construction{

    public Roof(Building building, int r, int g, int b) {
        super(building.getX(), building.getY(), r, g, b);
    }

    @Override
    public void draw() {
        Graphics graphics = Display.getInstance().getGraphics();
        int x = super.getX();
        int y = super.getY();

        // draw the roof
        graphics.setColor(super.getColor());

        for (int i = 0; i < 100; i++) {
            graphics.drawLine(x + 170, y - 100 + i, x + 370, y);
            graphics.drawLine(x + 170, y - 100 + i, x - 30, y);
        }
    }
}
