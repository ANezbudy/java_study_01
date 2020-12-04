package com.dtag.StackQueue;

public class ArrayStackLauncher {
    public static void main(String[] args) {
        String[] string = "Java is a class-based, object-oriented programming language".split(" ");

        ArrayStack stack = new ArrayStack(3);
        for (int i = 0; i < string.length; i++) {
            try {
                stack.push(string[i]);
            } catch (StackOverflowNauException e) {
                System.out.println("Exception: " + e.toString());
                break;
            }

        }

        System.out.println(0%4);
    }
}
