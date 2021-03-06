package com.dtag.StackQueue;

import java.util.LinkedList;

public class ArrayQueue {
    private int size;
    private String[] array;
    private int headIndex;

    ArrayQueue(int capacity) {
        array = new String[capacity];
    }

    public String get() throws EmptyQueueException {
        if (size == 0) {
            throw new EmptyQueueException("The queue is empty!"); //TODO throw exception qeuIsEmpty
        }
        String toReturn = array[headIndex];
        headIndex = headIndex + 1;
        if (headIndex >= array.length) {
            headIndex = 0;
        }
        size--;
        return toReturn;
    }

    public void put(String value) throws QueueOverflowException {

        if (size >= array.length) {
            throw new QueueOverflowException("The queue is full!"); //TODO provide proper exception
        }

        if (size == 0) {
            array[headIndex] = value;
        } else {
            int indexOfTheElement = (headIndex + size) % array.length;
            array[indexOfTheElement] = value;
        }
        size += 1;
    }

    public String pick() throws EmptyQueueException {
        if (size == 0) {
            throw new EmptyQueueException("The queue is empty!"); //TODO throw exception qeuIsEmpty
        } else {
            return array[headIndex];
        }
    }

    public String[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    public int getHeadIndex() {
        return headIndex;
    }
}
