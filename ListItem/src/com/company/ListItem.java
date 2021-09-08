package com.company;

import java.util.Comparator;

public abstract class ListItem {
    protected ListItem previous;
    protected ListItem next;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public abstract int compareTo(ListItem other);
    public abstract ListItem previous();
    public abstract void setPrevious(ListItem previous);
    public abstract ListItem next();
    public abstract void setNext(ListItem next);
    public abstract Object getValue();
}
