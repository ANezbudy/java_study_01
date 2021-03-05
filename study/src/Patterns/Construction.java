package Patterns;

import java.awt.*;

public class Construction {
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int x;
    private int y;

    public Color getColor() {
        return color;
    }

    private Color color;

    public Construction() {};

    public Construction(int bottomLeftX, int bottomLeftY, int r, int g, int b) {
        this.x = bottomLeftX;
        this.y = bottomLeftY;
        color = new Color(r, g, b);
    }

    public void draw() {
    }
}
