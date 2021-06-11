package Patterns;

import java.awt.*;

public class AnimatedSnow extends Animated {
    private int size;
    private double vY;
    private double vX;
    private double x;
    private double y;
    private double airDynamic = 1 - 0.5*Math.random();

//    public AnimatedSnow(int x, int y, int size, double v) {
//        this.x = x;
//        this.y = y;
//        this.size = size;
//        this.vY = v;
//    }

    @Override
    public double getY() {
        return y;
    }

    public void reset(int x, int y, int size, double v) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.vY = v;
    }

    @Override
    public void update(long millisecont) {
        if (y<Environment.height+30) {
            double shift = 0.5 - Math.random();
            //this.x = (x + shift + millisecont* vY);
            this.vX = vX + shift*millisecont/1000;

            this.x = x + millisecont*vX;
            this.y = y + millisecont*vY;
        }
    }

    @Override
    public void draw() {
        Graphics graphics = Display.getInstance().getGraphics();
        graphics.setColor(new Color(255, 255, 255));
        int sizeD = (int)(size*0.71);

        graphics.drawLine((int)x - size, (int)y, (int)x + size, (int)y );
        graphics.drawLine((int)x , (int)y-size, (int)x , (int)y +size);
        graphics.drawLine((int)x-sizeD , (int)y-sizeD, (int)x+sizeD , (int)y +sizeD);
        graphics.drawLine((int)x-sizeD , (int)y+sizeD, (int)x+sizeD , (int)y -sizeD);
    }

    public void applyWind (double windSpeed, long millisecond){
        x = x - windSpeed * airDynamic * millisecond;
    }


}
