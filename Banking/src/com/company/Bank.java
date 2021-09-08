package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        Branch existBranch = findBranch(branchName);
        if (existBranch == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for (Branch branch: branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean displayTransaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());
            ArrayList<Customer> customers = branch.getCustomers();
            for (int i=0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                System.out.println("Customer: " + customer.getName() + "[" + (i+1) + "]");
                if (displayTransaction) {
                    ArrayList<Double> transactions = customer.getTransactions();
                    for(int j=0; j<transactions.size(); j++) {
                        System.out.println("["+(j+1)+"] Amount " + transactions.get(j));
                    }
                }
            }
        }
        return false;
    }
}