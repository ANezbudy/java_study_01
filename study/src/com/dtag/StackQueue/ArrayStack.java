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
            throw new StackOverflowNauException("StackOverflowException NAU");
        }

        stackStrings[headIndex + 1] = string;
        headIndex = headIndex + 1;
    }

    public String pop() throws StackOverflowNauException, EmptyStackException {
        if (headIndex >= 0) {
            int indexOfElement = headIndex;
            headIndex = headIndex--;
            return stackStrings[indexOfElement];
        } else {
            throw new EmptyStackException("The stack is empty!");
        }
    }

    public String pick() throws EmptyStackException {
        if (headIndex >= 0) {
            return stackStrings[headIndex];
        } else {
            throw new EmptyStackException("The stack is empty!");
        }
    }
}
