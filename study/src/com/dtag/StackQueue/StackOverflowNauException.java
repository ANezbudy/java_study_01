package com.dtag.StackQueue;

public class StackOverflowNauException extends Exception {
    public StackOverflowNauException(String message) {
        super(message);
    }
    //TODO rewrite the exception via constructor
    @Override
    public String toString() {
        return "StackOverflowException NAU";
    }
}
