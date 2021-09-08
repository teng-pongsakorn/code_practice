package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> saveValues() {
        ArrayList<String> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose option\n1. enter string\n0. quit");
        while (!quit) {
            System.out.println("Choose an option:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter a string:");
                    String value = scanner.nextLine();
                    values.add(index, value);
                    index++;
                    break;
                case 0:
                    quit = true;
                    break;
            }
        }
        return values;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
