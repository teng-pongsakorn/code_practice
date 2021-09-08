package com.company;

public class LinkedList {
    ListItem head;

    public void addItem(String s) {
        ListItem newItem = new StringItem(s);
        if (head == null) {
            head = newItem;
        }

        // insert at the head
        else if (s.compareTo((String) head.getValue()) < 0) {
            head.setPrevious(newItem);
            newItem.setNext(head);
            head = newItem;
        }

        else {
            ListItem current = head;
            while (current.next != null && (s.compareTo((String) current.getValue()) > 0)) {
                current = current.next;
            }
            if (current.next == null) {
                current.setNext(newItem);
                newItem.setPrevious(current);
            } else {
                ListItem nextItem = current.next();
                current.setNext(nextItem);
                newItem.setPrevious(current);
                newItem.setNext(nextItem);
                newItem.setPrevious(newItem);
            }
        }
    }
}
