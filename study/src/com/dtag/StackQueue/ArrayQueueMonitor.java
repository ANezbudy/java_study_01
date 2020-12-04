package com.dtag.StackQueue;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Map;

public class ArrayQueueMonitor {
    public static final int DIAMETER = 50;

    // parameters for tree layers
    final static int LAYER_HEIGHT = 100;
    final static int R = LAYER_HEIGHT - 10;
    final static int ONE_SLOT_LENGTH = LAYER_HEIGHT;

    public static void main(String[] args) {
        drawSandBox();
    }

    public static void drawSandBox () {

    }

    public static void drawQueue(ArrayQueue queue) {
        final String title = "Trie Graphics";
        final int width = 1600;
        final int height = width / 16 * 9;

        //Creating the frame
        JFrame frame = getFrame(title, width, height);

        //Creating the canvas

        Color backgroundColor = new Color(223, 214, 226);
        Canvas canvas = getCanvas(width, height, backgroundColor);

        //Putting it all together
        frame.add(canvas);

        canvas.createBufferStrategy(3);

//        boolean running = true;

        BufferStrategy bufferStrategy = canvas.getBufferStrategy();

        Graphics graphics = bufferStrategy.getDrawGraphics();


        Font font = new Font("Courier New", Font.PLAIN, 20);

        graphics.setFont(font);

        bufferStrategy.show();

        boolean nextIterationNeeded = true;
        choseColor(19, 12, 154, graphics);
        int y = LAYER_HEIGHT * 2;

        for (int i = 0; i < queue.getArray().length; i++) {

            int x = ONE_SLOT_LENGTH /2 + i * ONE_SLOT_LENGTH;

            graphics.setColor(backgroundColor);
            graphics.fillOval(x - R /3, y - LAYER_HEIGHT /2, R, R);
            choseColor(19, 12, 154, graphics);
            graphics.drawOval(x - R /3, y - LAYER_HEIGHT /2, R, R);
            graphics.drawString(queue.getArray()[i] == null ? "":queue.getArray()[i], x, y);
        }

//        graphics.drawLine(x, y, x - ONE_SLOT_LENGTH /4, y + LAYER_HEIGHT);


        for (int i = 0; i < 100; i++) {
            bufferStrategy.show();
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
}
