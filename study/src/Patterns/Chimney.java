package Patterns;

import java.awt.*;

public class Chimney extends Construction{

    public Chimney(Building building, int r, int g, int b) {
        super(building.getX(), building.getY(), r, g, b);
    }

    @Override
    public void draw() {
        Graphics graphics = Display.getInstance().getGraphics();;
        int x = super.getX();
        int y = super.getY();
        // draw the door
        graphics.setColor(super.getColor());
        graphics.fillRect(x + 230, y - 200, 50, 200);

        // draw smoke
        Color color = new Color(160, 160, 160);
        graphics.setColor(color);

        for (int i = 0; i < 180; i += 50) {
            graphics.fillArc(465, 170 - i, 50 + i, 40 + i, -20, 160);
        }
    }
}
