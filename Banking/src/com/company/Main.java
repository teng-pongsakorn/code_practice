package com.company;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("National Australia Bank");

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addTransaction("Adelaide", "Tim", 44.22);
        bank.addTransaction("Adelaide", "Tim", 12.44);
        bank.addTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers("Adelaide", true);
        System.out.println("===========================================");
        bank.listCustomers("Adelaide", false);
    }
}
