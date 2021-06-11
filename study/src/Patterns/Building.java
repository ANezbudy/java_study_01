package Patterns;

import java.awt.*;

public class Building extends Construction {
    Graphics graphics = Display.getInstance().getGraphics();

    public Building(int bottomLeftX, int bottomLeftY, int r, int g, int b) {
        super(bottomLeftX, bottomLeftY, r, g, b);
    }

    @Override
    public void draw() {
        int x = super.getX();
        int y = super.getY();

        // draw the building
        graphics.setColor(super.getColor());
        graphics.fillRect(x, y, 340, 180);
    }

    //TODO think about hte superclass
}
