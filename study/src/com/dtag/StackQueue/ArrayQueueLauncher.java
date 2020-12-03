package com.dtag.StackQueue;

public class ArrayQueueLauncher {
    public static void main(String[] args) {
        String[] string = "Java is a class-based, object-oriented programming language".split(" ");

        ArrayQueue queue = new ArrayQueue(10);
        for (int i = 0; i < 3; i++) {
            try {
                queue.put(string[i]);
            } catch (QueueOverflowException e) {
                System.out.println(e.getMessage() + " " + e.getStackTrace());
                break;
            }

        }

        for(int i = 0; i < 2; i++) {
            try{
                System.out.println(queue.get());
            } catch (EmptyQueueException e) {
                System.out.println(e.getMessage() + " " + e.getStackTrace());
                break;
            }

        }

        for (int i = 0; i < string.length; i++) {
            try {
                queue.put(string[i]);
            } catch (QueueOverflowException e) {
                System.out.println(e.getMessage() + " " + e.getStackTrace());
                break;
            }

        }

        for(int i = 0; i < string.length; i++) {
            try{
                System.out.println(queue.get());
            } catch (EmptyQueueException e) {
                System.out.println(e.getMessage() + " " + e.getStackTrace());
                break;
            }

        }
    }
}
