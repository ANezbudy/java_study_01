package Patterns;

import java.awt.*;

public abstract class Drawable {
    public int getX() {
        return x;
    }

    public int x;
    public int y;
    public int size;

    public abstract void draw ();


    public double getY() {
        return y;
    }


}
