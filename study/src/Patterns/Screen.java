package Patterns;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Screen {
    public static final int DIAMETER = 50;


    public static void main(String[] args) {
        drawSandBox();
    }

    public static void drawSandBox () {
//        drawTheHause();
        drawSnow();
    }

    private static void drawTheHause () {
        final String title = "Dream House";
        final int width = 1600;
        final int height = width / 16 * 9;

        //Creating the frame
        JFrame frame = getFrame(title, width, height);

        //Creating the canvas

        Color color = new Color(6, 1, 58);
        Canvas canvas = getCanvas(width, height, color);

        //Putting it all together
        frame.add(canvas);

        canvas.createBufferStrategy(3);

        boolean running = true;

        BufferStrategy bufferStrategy = canvas.getBufferStrategy();

        while (running) {
            Graphics graphics = bufferStrategy.getDrawGraphics();

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

            // draw the chimney
            choseColor(92, 75, 39, graphics);
            graphics.fillRect(460, 200, 50, 200);


            // draw the roof
            choseColor(134, 60, 57, graphics);

            for (int i = 0; i < 100; i++) {
                graphics.drawLine(400, 300 + i, 600, 400);
                graphics.drawLine(400, 300 + i, 200, 400);
            }

//            // draw the lawn
//            choseColor(0, 255, 0, graphics);
//            graphics.fillOval(100, 550, 600, 100);

            // draw the building
            choseColor(122, 95, 69, graphics);
            graphics.fillRect(230, 400, 340, 180);

            // draw the door
            choseColor(71, 58, 31, graphics);
            graphics.fillArc(375, 480, 50, 200, 0, 180);

            // draw windows
            choseColor(92, 75, 39, graphics);
            graphics.fillOval(260, 425, 80, 80);
            graphics.fillOval(460, 425, 80, 80);

            choseColor(82, 255, 233, graphics);
            graphics.fillOval(265, 430, 70, 70);
            graphics.fillOval(465, 430, 70, 70);

            choseColor(92, 75, 39, graphics);
            graphics.drawLine(300, 425, 300, 505);
            graphics.drawLine(460, 465, 540, 465);

            // draw smoke
            choseColor(160, 160, 160, graphics);

            for (int i = 0; i < 180; i+=50) {
                graphics.fillArc(465, 170 - i, 50 + i, 40 + i, -20, 160);
            }

            bufferStrategy.show(); // show our drawing on screen
        }
    }

    private static Canvas getCanvas(int width, int height, Color color) {
        Canvas canvas = new Canvas();

        canvas.setSize(width, height);
        canvas.setBackground(color);
        canvas.setVisible(true);
        canvas.setFocusable(false);

        return canvas;
    }

    private static JFrame getFrame(String title, int width, int height) {
        JFrame frame = new JFrame(title);

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        return frame;
    }

    private static void choseColor(int r, int g, int b, Graphics graphics) {
        Color color = new Color(r, g, b);
        graphics.setColor(color);
    }

    private static void drawSnow() {
        drawTheHause();
        final int width = 1600;
        final int height = width / 16 * 9;
        boolean running = true;
        long currentTime = System.currentTimeMillis();

        ArrayList<Drawable> arrayListDrawable = new ArrayList<>();
        // ArrayList для Animated
        ArrayList<Animated> arrayListAnimated = new ArrayList<>();
        ArrayList<AnimatedSnow> arrayListWind = new ArrayList<>();

        // создаем пул для снежинок
        SnowflakePool snowflakePool = new SnowflakePool();
        Thread threadSnowFlakePool = new Thread(snowflakePool);
        snowflakePool.init(arrayListDrawable, arrayListAnimated, arrayListWind);
        threadSnowFlakePool.start();

///////////////////////////////
        long counter = 0;


        while (running) {

            Graphics graphics = Display.getInstance().getGraphics(); //getting graphics (object, with which we can draw our objects)

            graphics.clearRect(0,0, width, height);  //  очистка

            /////////// время
            long newTime = System.currentTimeMillis();
            long timePast = newTime - currentTime;
            currentTime = newTime;

            counter = counter + timePast;

            //  динамические снежинки: вытаскивание снежинок из Пула snowflakePool.getSnowflake() и добавление в их в arrayListAnimated, arrayListDrawable и в arrayListWind
            for (int i=0; i<2; i++) {
                int xRandom =  (int)(1+(Math.random()*width));   // [a;b) : ( Math.random() * (b-a) ) + a
                int sizeRandom = (int) (2+(Math.random()*15));
                double vRandom = 0.03 + Math.random()/20; //  /50



                synchronized (arrayListAnimated) {
                    AnimatedSnow animatedSnow = snowflakePool.getSnowflake(); //вытаскивание снежинок из Пула snowflakePool.getSnowflake()
                    animatedSnow.reset(xRandom, 0, sizeRandom, vRandom);

                    arrayListAnimated.add(animatedSnow);
                    arrayListDrawable.add(animatedSnow);
                    arrayListWind.add(animatedSnow);
                }
            }

            synchronized (arrayListAnimated) {
                // рисуем динамич объекты
                for (Animated temp: arrayListAnimated) {
                    temp.update(timePast);
                    //temp.draw(graphics);
                }

                //  рисуем статич объекты
                for (Drawable temp: arrayListDrawable) {
                    temp.draw();
                }


                // применяем ветер
//            for (AnimatedSnow temp: arrayListWind) {
//                temp.applyWind(Environment.windSpeed, timePast);
//            }
            }




            Display.getInstance().show(); //showing our drawing on screen

        }  // end of while
    }
}
