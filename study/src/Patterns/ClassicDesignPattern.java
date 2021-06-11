//package main.pattern;
//
//import main.Trie.*;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferStrategy;
//import java.util.ArrayList;
//
//public class ClassicDesignPattern {
//
//    public static void drawSandbox() {
//        final String title = "Display as singleton";
//        final int width = Display.getWidth();
//        final int height = Display.getHeight();
//
//        boolean running = true;
//
//        //Graphics graphics = Display.getInstance().getGraphics(); //getting graphics (object, with which we can draw our objects)
//
//
//        /////////////////////////////
//        int x = width/2-500;
//        int y = height/2;
//        long currentTime = System.currentTimeMillis();
//
//
//
//        // ArrayList для  статич объектов
//        ArrayList<Drawable> arrayListDrawable = new ArrayList<>();
////        // ArrayList для Animated
//        ArrayList<Animated> arrayListAnimated = new ArrayList<>();
//        ArrayList<AnimatedSnow> arrayListWind = new ArrayList<>();
//
//        // Луна создаем (динамич)
//        Moon moon = new Moon(Environment.width/2,Environment.height/8, 100);
//        arrayListAnimated.add(moon);
//        arrayListDrawable.add(moon);
//
//        // ёлки статич
//        arrayListDrawable.add(new Tree(width/2-600, height-700, 80));
//        arrayListDrawable.add(new Tree(width/2-300, height-750, 50));
//        arrayListDrawable.add(new Tree(width/2-100, height-200, 50));
//        arrayListDrawable.add(new Tree(width/2+100, height-500, 30));
//        arrayListDrawable.add(new Tree(width/2+200, height-600, 40));
//        arrayListDrawable.add(new Tree(width/2+650, height-600, 20));
//
//        //  дома статич
//        arrayListDrawable.add(new House(width/2-500, height/2+100, 350));
//        arrayListDrawable.add(new House(width/2-100, height/2-200, 200));
//        arrayListDrawable.add(new House(width/2+300, height/2-300, 100));
//        arrayListDrawable.add(new House(width/2+500, height/2-350, 80));
//
//        arrayListDrawable.add(new House(width/2+100, height-200, 180));
//        arrayListDrawable.add(new House(width/2+400, height-300, 90));
//        arrayListDrawable.add(new House(width/2+600, height-350, 60));
//        arrayListDrawable.add(new House(width/2+700, height-500, 30));
//
//
//
//
//        // создаем пул для снежинок
//        SnowflakePool snowflakePool = new SnowflakePool();
//
//
//
//
/////////////////////////////////
//        long counter = 0;
//
//        while (running) {
//
//            Graphics graphics = Display.getInstance().getGraphics(); //getting graphics (object, with which we can draw our objects)
//
//            graphics.clearRect(0,0, width, height);  //  очистка
//
//            /////////// время
//            long newTime = System.currentTimeMillis();
//            long timePast = newTime - currentTime;
//            currentTime = newTime;
//
//            counter = counter + timePast;
//
//            if (counter>100) {
//                //  проверяем на список со снежинками, если снежинка уже оказалась за пределами холста, то
//                //  мы удаляем ее из списков  arrayListAnimated, arrayListWind и кладем ее в наш пул snowflakePool
//                for (int i=0; i<arrayListAnimated.size(); ) {
//                    System.out.println(arrayListAnimated.getClass().getSimpleName());
//                    if (arrayListAnimated.get(i).getClass()==AnimatedSnow.class) {
//                        AnimatedSnow temp = (AnimatedSnow) arrayListAnimated.get(i);
//                        if (temp.getY()>Environment.height+30) {
//                            arrayListAnimated.remove(i);
//                            arrayListWind.remove(temp);
//                            arrayListDrawable.remove(temp);
//                            snowflakePool.putSnowflake(temp);
//                        } else {
//                            i++;
//                        }
//                    } else {
//                        i++;
//                    }
//                }
//                // один варинат - держать снежинк в отдельно аррэй листе и смотреть только их
//
//                counter = 0;
//            }
//
//
//            //  динамические снежинки: вытаскивание снежинок из Пула snowflakePool.getSnowflake() и добавление в их в arrayListAnimated, arrayListDrawable и в arrayListWind
//            for (int i=0; i<2; i++) {
//                int xRandom =  (int)(1+(Math.random()*width));   // [a;b) : ( Math.random() * (b-a) ) + a
//                int sizeRandom = (int) (2+(Math.random()*15));
//                double vRandom = 0.03 + Math.random()/20; //  /50
//
//                AnimatedSnow animatedSnow = snowflakePool.getSnowflake(); //вытаскивание снежинок из Пула snowflakePool.getSnowflake()
//                animatedSnow.reset(xRandom, 0, sizeRandom, vRandom);
//
//                arrayListAnimated.add(animatedSnow);
//                arrayListDrawable.add(animatedSnow);
//                arrayListWind.add(animatedSnow);
//            }
//
//
//            // рисуем динамич объекты
//            for (Animated temp: arrayListAnimated) {
//                temp.update(timePast);
//                //temp.draw(graphics);
//            }
//
//            //  рисуем статич объекты
//            for (Drawable temp: arrayListDrawable) {
//                temp.draw(graphics);
//            }
//
//
//            // применяем ветер
////            for (AnimatedSnow temp: arrayListWind) {
////                temp.applyWind(Environment.windSpeed, timePast);
////            }
//
//
//            Display.getInstance().show(); //showing our drawing on screen
//
//        }  // end of while
//
//    }  // end of drawSandbox() method
//
//}
