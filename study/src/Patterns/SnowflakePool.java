package Patterns;

import Patterns.AnimatedSnow;

import java.util.ArrayList;

public class SnowflakePool implements Runnable {

    ArrayList<AnimatedSnow> freeSnowflakes = new ArrayList<>();
    ArrayList<AnimatedSnow> rentedSnowflakes = new ArrayList<>();
    private ArrayList<Animated> arrayListAnimated;
    private ArrayList<Drawable> arrayListDrawable;
    private ArrayList<AnimatedSnow> arrayListWind;

    private static final int SLEEP_TIME = 300;


    public AnimatedSnow getSnowflake() {
        AnimatedSnow animatedSnow;
        if (freeSnowflakes.size()>0) {
            animatedSnow = freeSnowflakes.get(0);
            freeSnowflakes.remove(0);

        } else {
            animatedSnow = new AnimatedSnow();
        }
        rentedSnowflakes.add(animatedSnow); // добавили
        return animatedSnow;
    }


    public void putSnowflake(AnimatedSnow animatedSnow){
        rentedSnowflakes.remove(animatedSnow);
        freeSnowflakes.add(animatedSnow);

    }

    //чтобы передать списки
    public void init(ArrayList<Drawable> arrayListDrawable, ArrayList<Animated> arrayListAnimated, ArrayList<AnimatedSnow> arrayListWind) {
        this.arrayListAnimated = arrayListAnimated;
        this.arrayListDrawable = arrayListDrawable;
        this.arrayListWind = arrayListWind;
    }


    @Override
    public void run() {
        while (! Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                break;
            }

            synchronized (arrayListAnimated) {
                for (int i=0; i<rentedSnowflakes.size();) {
                    AnimatedSnow temp = rentedSnowflakes.get(i);
                    if (temp.getY() > Environment.height + 30) {
                        arrayListAnimated.remove(temp);
                        arrayListWind.remove(temp);
                        arrayListDrawable.remove(temp);
                        putSnowflake(temp);
                    } else {
                        i++;
                    }
                }
            }
        }
    }
}

