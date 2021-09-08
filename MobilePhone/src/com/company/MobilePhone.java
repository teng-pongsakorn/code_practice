package com.company;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String number) {
        this.myNumber = number;
        this.myContacts = new ArrayList<>();
    }

    public boolean addContact(Contact contact) {
        if (findContact(contact.getName()) == -1) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int idxOld = findContact(oldContact);
        int idxNew = findContact(newContact);
        if (idxOld != -1 && idxNew == -1) {
            myContacts.set(idxOld, newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact) {
        int idx = findContact(contact.getName());
        if (idx != -1) {
            myContacts.remove(idx);
            return true;
        }
        return false;
    }

    public Contact queryContact(String name) {
        int idx = findContact(name);
        if (idx != -1) {
            return myContacts.get(idx);
        }
        return null;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i+1) + ". " + myContacts.get(i));
        }
    }
}
