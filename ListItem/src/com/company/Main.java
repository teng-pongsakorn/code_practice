package com.company;

public class Main {

    public static void main(String[] args) {
        String stringData = "Darwin Brisbane Perth MElbourne Canberra Adelaide Sydney Canberra";
        String[] data = stringData.split(" ");
        LinkedList myList = new LinkedList();
        for (String s: data) {
            myList.addItem(s);
        }
    }
}
