package com.dtag.StackQueue;

public class ListLauncher {

    public static void main(String[] args) {
        String[] string = "Java is a class-based, object-oriented programming language".split(" ");

        ListQueue queue = new ListQueue();
        for (int i = 0; i < string.length; i++) {
            queue.put(string[i]);
        }

        System.out.println(queue.getSize());

        String buffer = queue.get();
        System.out.println(queue.getSize());


        System.out.println(queue.peek());
        while (buffer != null) {
            System.out.println(buffer);
            buffer = queue.get();
        }

        System.out.println("***********************************");


        ListStack stack = new ListStack();
        for (int i = 0; i < string.length; i++) {
            stack.push(string[i]);
        }
        System.out.println(stack.getSize());

        String stackBuffer = stack.pop();

        System.out.println(stack.peek());
        while (stackBuffer != null) {
            System.out.println(stackBuffer);
            stackBuffer = stack.pop();
        }
        System.out.println(stack.getSize());

    }

    //TODO implement size method for the queue and stack


}
