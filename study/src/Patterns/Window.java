package Patterns;

import java.awt.*;

public class Window extends Construction{

    public Window(int x, int y, int r, int g, int b) {
        super(x, y, r, g, b);
    }


    @Override
    public void draw() {
        Graphics graphics = Display.getInstance().getGraphics();;
        int x = super.getX();
        int y = super.getY();

        graphics.setColor(new Color(92, 75, 39));
        graphics.fillOval(x, y, 80, 80);

        graphics.setColor(super.getColor());
        graphics.fillOval(x + 5, y + 5, 70, 70);

        graphics.setColor(new Color(92, 75, 39));
        graphics.drawLine(x + 40, y, x + 40, y + 80);
    }
}
