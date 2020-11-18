package com.dtag.StackQueue;

public class ListQueue {
    private ListElement tail;
    private ListElement head;

    public void put(String string) {
        ListElement element = new ListElement(null, string);
        if (tail != null) {
            tail.setNext(element);
        } else {
            head = element;
        }
        tail = element;
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
