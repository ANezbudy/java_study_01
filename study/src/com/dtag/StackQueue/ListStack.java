package com.dtag.StackQueue;

public class ListStack {
    ListElement head;
    private int size = 0;

    public void push(String value) {
        ListElement element = new ListElement(head, value);
        head = element;
        size++;
    }

    public String pop() {
        if (head != null) {
            ListElement element = head;
            head = element.getNext();
            size--;
            return element.getValue();
        }
        return null;
    }

    public String peek() {
        if(head == null) {
            return null;
        }
        return head.getValue();
    }

    public int getSize() {
        return size;
    }
}
