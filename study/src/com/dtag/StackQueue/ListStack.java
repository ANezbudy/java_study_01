package com.dtag.StackQueue;

public class ListStack {
    ListElement head;

    public void push(String value) {
        ListElement element = new ListElement(head, value);
        head = element;
    }

    public String pop() {
        if (head != null) {
            ListElement element = head;
            head = element.getNext();
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
}
