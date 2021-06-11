//package Trie;
//
//import com.dtag.GenericTree.BalancedTreeElementGen;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferStrategy;
//import java.util.Map;
//
//public class Screen {
//    public static final int DIAMETER = 50;
//
//    // parameters for tree layers
//    final static int LAYER_HEIGHT = 100;
//    final static int R = LAYER_HEIGHT - 10;
//    final static int ONE_SLOT_LENGTH = LAYER_HEIGHT;
//
//    public static void main(String[] args) {
//        drawSandBox();
//    }
//
//    public static void drawSandBox () {
//
//    }
//
//    public static void drawTree(TrieElement root) {
//        final String title = "Trie Graphics";
//        final int width = 1600;
//        final int height = width / 16 * 9;
//
//        //Creating the frame
//        JFrame frame = getFrame(title, width, height);
//
//        //Creating the canvas
//
//        Color backgroundColor = new Color(223, 214, 226);
//        Canvas canvas = getCanvas(width, height, backgroundColor);
//
//        //Putting it all together
//        frame.add(canvas);
//
//        canvas.createBufferStrategy(3);
//
////        boolean running = true;
//
//        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
//
//        Graphics graphics = bufferStrategy.getDrawGraphics();
//
//
//        Font font = new Font("Courier New", Font.PLAIN, 20);
//
//        graphics.setFont(font);
//
//        bufferStrategy.show();
//
//        BalancedTreeElementGen[] elementsOnLevel = new BalancedTreeElementGen[1];
////        elementsOnLevel[0] = root;
//
//        boolean nextIterationNeeded = true;
//        int layerNo = 1;
//        choseColor(19, 12, 154, graphics);
//
//
//        while (nextIterationNeeded) {
//            BalancedTreeElementGen[] elementsOnNextLevel = new BalancedTreeElementGen[elementsOnLevel.length*2];
//            nextIterationNeeded = false;
//
//            int y = LAYER_HEIGHT * layerNo;
//
//            for (int i = 0; i < elementsOnLevel.length; i++) {
//
//                BalancedTreeElementGen e = elementsOnLevel[i];
//                int x = ONE_SLOT_LENGTH /2 + i * ONE_SLOT_LENGTH;
//
//
//
//
//                if (e == null) {
////                    graphics.drawString("N", x, y);
//                    elementsOnNextLevel[2*i] = null;
//                    elementsOnNextLevel[2*i+1] = null;
//                } else {
//                    if (e.getLeftChildNode() != null) {
////                        graphics.drawLine(x, y, x + oneSlotLength/4, y + layerHeight);
//                        graphics.drawLine(x, y, x - ONE_SLOT_LENGTH /4, y + LAYER_HEIGHT);
//                    }
//
//                    if (e.getRightChildNode() != null) {
////                        graphics.drawLine(x, y, x - oneSlotLength/4, y + layerHeight);
//                        graphics.drawLine(x, y, x + ONE_SLOT_LENGTH /4, y + LAYER_HEIGHT);
//                    }
//                    graphics.setColor(backgroundColor);
//                    graphics.fillOval(x - R /3, y - LAYER_HEIGHT /2, R, R);
//                    choseColor(19, 12, 154, graphics);
//                    graphics.drawOval(x - R /3, y - LAYER_HEIGHT /2, R, R);
//                    graphics.drawString(e.getValue().toString(), x, y);
//                    elementsOnNextLevel[i*2] = e.getLeftChildNode();
//                    elementsOnNextLevel[i*2+1] = e.getRightChildNode();
//                    nextIterationNeeded = nextIterationNeeded || e.getLeftChildNode() != null || e.getRightChildNode() != null;
//                }
//                bufferStrategy.show();
//            }
//            elementsOnLevel = elementsOnNextLevel;
////            ONE_SLOT_LENGTH = ONE_SLOT_LENGTH /2;
//            layerNo++;
//        }
//        while (true) {
//            bufferStrategy.show();
//        }
//
//
//    }
//
////    private int drawElement(TrieElement element, char letter) {
////        int usedSpace = 0;
////        if (element.children.isEmpty()) {
////            usedSpace = ONE_SLOT_LENGTH;
////
////        } else {
////            for (Map.Entry<Character, TrieElement> child: element.children.entrySet()) {
////                usedSpace = usedSpace + drawElement(child.getValue(), child.getKey());
////            }
////        }
////    } // continue with this
//
//
//
//    private static Canvas getCanvas(int width, int height, Color color) {
//        Canvas canvas = new Canvas();
//
//        canvas.setSize(width, height);
//        canvas.setBackground(color);
//        canvas.setVisible(true);
//        canvas.setFocusable(false);
//
//        return canvas;
//    }
//
//    private static JFrame getFrame(String title, int width, int height) {
//        JFrame frame = new JFrame(title);
//
//        frame.setSize(width, height);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
//        frame.setVisible(true);
//        return frame;
//    }
//
//    private static void choseColor(int r, int g, int b, Graphics graphics) {
//        Color color = new Color(r, g, b);
//        graphics.setColor(color);
//    }
//}
