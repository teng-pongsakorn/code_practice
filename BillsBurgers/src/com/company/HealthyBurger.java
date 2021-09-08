package com.company;

public class HealthyBurger extends Hamburger{

    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy", meat, price, "Brown rye");
    }

    public void addHealthyAddition1(String name, double price) {
        if (healthyExtra1Name == null) {
            healthyExtra1Name = name;
            healthyExtra1Price = price;
        }
    }

    public void addHealthyAddition2(String name, double price) {
        if (healthyExtra2Name == null) {
            healthyExtra2Name = name;
            healthyExtra2Price = price;
        }
    }

    @Override
    public double itemizeHamburger() {
        double total =  super.itemizeHamburger();
        if (healthyExtra1Name != null) {
            System.out.println("Added " + healthyExtra1Name +
                    " for an extra " + healthyExtra1Price);
            total += healthyExtra1Price;
        }

        if (healthyExtra2Name != null) {
            System.out.println("Added " + healthyExtra2Name +
                    " for an extra " + healthyExtra2Price);
            total += healthyExtra2Price;
        }

        return total;
    }
}
