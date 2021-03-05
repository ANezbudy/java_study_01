package Patterns;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display {
    public static int getWidth() {
        return width;
    }

    private final static int width = 1600;

    public static int getHeight() {
        return height;
    }

    private final static int height = width / 16 * 9;
    private static String title;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private JFrame frame;
    private Canvas canvas;

    private static Display instance;

    private Display() {
        initialize();
    }

    public static Display getInstance() {
        if (instance == null) {
            instance = new Display();
        }
        return instance;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setBackgroundColor(Color color) {
        canvas.setBackground(color);
    }

    private void initialize() {

        //Creating the frame
        frame = getFrame(title, width, height);

        //Creating the canvas
        canvas = getCanvas(width, height);

        //Putting it all together
        frame.add(canvas);
        canvas.createBufferStrategy(3);

        bufferStrategy = canvas.getBufferStrategy();

        graphics = bufferStrategy.getDrawGraphics();
    }

    public void show() {
        bufferStrategy.show();
        graphics.dispose();
        graphics = bufferStrategy.getDrawGraphics();
    }

    private static Canvas getCanvas(int width, int height) {
        Canvas canvas = new Canvas();

        canvas.setSize(width, height);
//        canvas.setBackground(color);
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

}
