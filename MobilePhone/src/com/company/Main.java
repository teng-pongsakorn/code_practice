package com.company;

import java.util.Scanner;

public class Main {

    public static MobilePhone mobilePhone = new MobilePhone("555555");
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
	    boolean quit = false;
	    while (!quit) {
	        printMenu();
            System.out.println("enter option: ");
	        int choice = scanner.nextInt();
	        switch (choice) {
                case 1:
                    displayContactList();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    private static void searchContact() {
        System.out.println("Enter contact name:");
        String name = scanner.next();
        Contact contact = mobilePhone.queryContact(name);
        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("Contact name `" + name + "` not found");
        }
    }

    private static void removeContact() {
        System.out.println("Enter contact name:");
        String name = scanner.next();
        Contact contact = mobilePhone.queryContact(name);
        if (contact != null) {
            if (mobilePhone.removeContact(contact)) {
                System.out.println("Successfully deleted");
            } else {
                System.out.println("Error deleting");
            }
        } else {
            System.out.println("Contact name `" + name + "` not found");
        }
    }

    private static void modifyContact() {
        System.out.println("Enter contact name:");
        String name = scanner.next();
        Contact oldContact = mobilePhone.queryContact(name);
        if (oldContact == null) {
            System.out.println("Contact name `" + name + "` not found");
            return;
        }

        System.out.println("Enter new contact name:");
        String newName = scanner.next();
        System.out.println("Enter new contact phone:");
        String newPhone = scanner.next();
        Contact newContact = Contact.createContact(newName, newPhone);
        if (mobilePhone.updateContact(oldContact, newContact)) {
            System.out.println("Successfully updating record");
        } else {
            System.out.println("Error updating record");
        }
    }

    private static void addNewContact() {
        System.out.println("Enter contact name:");
        String name = scanner.next();
        System.out.println("Enter contact phone number:");
        String phone = scanner.next();
        mobilePhone.addContact(new Contact(name, phone));
    }

    private static void displayContactList() {
        mobilePhone.printContacts();
    }

    private static void printMenu() {
        String menu = "\n1. display contacts\n" +
                "2. add new contact\n" +
                "3. update contact\n" +
                "4. delete contact\n" +
                "5. query contact\n" +
                "6. quit\n";
        System.out.println(menu);
    }
}
