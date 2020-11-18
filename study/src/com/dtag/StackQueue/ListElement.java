package com.dtag.StackQueue;

public class ListElement {

    private ListElement next;
    private String value;

    public ListElement(ListElement next, String value) {
        setNext(next);
        setValue(value);
    }
    // comment

    public ListElement getNext() {
        return next;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
