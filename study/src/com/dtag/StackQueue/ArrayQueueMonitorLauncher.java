package com.dtag.StackQueue;

public class ArrayQueueMonitorLauncher {
    public static void main(String[] args) {
        String[] string = "J i a c o p l".split(" ");

        ArrayQueue queue = new ArrayQueue(10);
        for (int i = 0; i < string.length; i++) {
            try {
                queue.put(string[i]);
            } catch (QueueOverflowException e) {
                System.out.println(e.getMessage() + " " + e.getStackTrace());
                break;
            }

        }

        ArrayQueueMonitor.drawQueue(queue);
    }
}
