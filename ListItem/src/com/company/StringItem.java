package com.company;

public class StringItem extends ListItem{

    public StringItem(String value) {
        super(null);
        this.value = value;
    }

    @Override
    public int compareTo(ListItem other) {
        return ((String) this.value).compareTo((String) other.value);
    }

    @Override
    public ListItem previous() {
        return previous;
    }

    @Override
    public void setPrevious(ListItem item) {
        this.previous = item;
    }

    @Override
    public ListItem next() {
        return next;
    }

    @Override
    public void setNext(ListItem item) {
        this.next = item;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
