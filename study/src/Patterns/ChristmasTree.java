package Patterns;

import java.awt.*;
import java.util.ArrayList;

public class ChristmasTree {

    public static void main(String[] args) {
        drawSandBox();
    }


    public static void drawSandBox() {
        final String title = "Dream House";
        final int width = Display.getWidth();
        final int height = Display.getHeight();

        long currentTime = System.currentTimeMillis();

        boolean running = true;
        //массив для дома
        ArrayList<Construction> arrayListConstruction = new ArrayList<>();


        ArrayList<Drawable> arrayListDrawable = new ArrayList<>();
        ArrayList<Animated> arrayListAnimated = new ArrayList<>();
        ArrayList<AnimatedSnow> arrayListWind = new ArrayList<>();

        arrayListConstruction.add(new House(230, 400));

        // создаем пул для снежинок
        SnowflakePool snowflakePool = new SnowflakePool();
        Thread threadSnowflakePool = new Thread(snowflakePool);
        snowflakePool.init(arrayListDrawable, arrayListAnimated, arrayListWind);
        threadSnowflakePool.start();


        while (running) {
            Graphics graphics = Display.getInstance().getGraphics(); //getting graphics (object, with which we can draw our objects)

            graphics.clearRect(0,0, width, height);  //  очистка

            /////////// время
            long newTime = System.currentTimeMillis();
            long timePast = newTime - currentTime;
            currentTime = newTime;

            for (int i=0; i<5; i++) {
                int xRandom =  (int)(1+(Math.random()*width));   // [a;b) : ( Math.random() * (b-a) ) + a
                int sizeRandom = (int) (2+(Math.random()*15));
                double vRandom = 0.03 + Math.random()/20; //  /50

                synchronized (arrayListAnimated) {

                    AnimatedSnow animatedSnow = snowflakePool.getSnowflake(); //вытаскивание снежинок из Пула snowflakePool.getSnowflake()
//                    AnimatedSnow animatedSnow = new AnimatedSnow();
                    animatedSnow.reset(xRandom, 0, sizeRandom, vRandom);

                    arrayListAnimated.add(animatedSnow);
                    arrayListDrawable.add(animatedSnow);
                    arrayListWind.add(animatedSnow);

                }


            }

            // рисуем динамич объекты

            synchronized (arrayListAnimated) {

                for (Construction temp: arrayListConstruction) {
                    temp.draw();
                }

                //  рисуем статич объекты
                for (Drawable temp: arrayListDrawable) {
                    temp.draw();
                }



                for (Animated temp: arrayListAnimated) {
                    temp.update(timePast);
                    //temp.draw(graphics);
                }

                // применяем ветер
//            for (AnimatedSnow temp: arrayListWind) {
//                temp.applyWind(Environment.windSpeed, timePast);
//            }

            }
            Display.getInstance().show(); // show our drawing on screen
        }
    }
    //DONE to make all elements of the picture like an objects in object model
    //TODO implement the fabric pattern for objects
}
