package com.dtag.StackQueue;

import java.lang.reflect.Array;

public class ArrayStack {
    private String[] stackStrings;
    private int headIndex = -1;

    public ArrayStack(int size) {
        stackStrings = new String[size];
    }


    public void push(String string) throws StackOverflowNauException {
        if (headIndex + 1 >= stackStrings.length) {
//            throw new StackOverflowError(); //TODO to create our own StackOverflowExeption
            throw new StackOverflowNauException();
        }

        stackStrings[headIndex + 1] = string;
        headIndex = headIndex + 1;
    }

    public String pop() {
        return "";
    }

    public String peek() {
        return "";
    }
}
