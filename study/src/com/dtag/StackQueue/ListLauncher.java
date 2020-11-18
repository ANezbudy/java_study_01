package com.dtag.StackQueue;

public class ListLauncher {

    public static void main(String[] args) {
        String[] string = "Java is a class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible".split(" ");

        ListQueue queue = new ListQueue();
        for (int i = 0; i < string.length; i++) {
            queue.put(string[i]);
        }

//        String buffer = queue.get();
//
//        System.out.println(queue.peek());
//        while (buffer != null) {
//            System.out.println(buffer);
//            buffer = queue.get();
//        }


        ListStack stack = new ListStack();
        for (int i = 0; i < string.length; i++) {
            stack.push(string[i]);
        }

        String buffer = stack.pop();

        System.out.println(stack.peek());
        while (buffer != null) {
            System.out.println(buffer);
            buffer = stack.pop();
        }
    }

    //TODO implement size method for the queue and stack


}
