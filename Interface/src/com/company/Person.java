package com.company;

import java.util.ArrayList;

public class Person implements ISavable {
    private String firstname;
    private String lastname;
    private int age;

    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    @Override
    public ArrayList<Object> save() {
        ArrayList<Object> fields = new ArrayList<>();
        fields.add(this.firstname);
        fields.add(this.lastname);
        fields.add(this.age);
        return fields;
    }

    @Override
    public void restore(ArrayList<Object> fields) {
        if (fields.size() != 3) {
            throw new IllegalArgumentException("invalid number of fields");
        }
        this.firstname = (String) fields.get(0);
        this.lastname = (String) fields.get(1);
        this.age = (int) fields.get(2);
    }
}
