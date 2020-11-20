package com.dtag.StackQueue;

public class ListQueue {
    private ListElement tail;
    private ListElement head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void put(String string) {
        ListElement element = new ListElement(null, string);
        if (tail != null) {
            tail.setNext(element);
        } else {
            head = element;
        }
        tail = element;
        size++;
    }

    public String get() {
        if(head == null) {
            return null;
        }

        String result = head.getValue();
        head = head.getNext();

        if(head == null) {
            tail = null;
        }
        size--;
        return result;
    }
    //comment

    public String peek() {
        if(head == null) {
            return null;
        }
        return head.getValue();
    }
}
