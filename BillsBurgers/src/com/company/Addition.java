package com.company;

public class Addition {

    private String name;
    private double price;

    public Addition(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static Addition tomato = new Addition("tomato", 0.2);
    public static Addition lettuce = new Addition("lettuce", 0.1);
    public static Addition cheese = new Addition("cheese", 0.3);
    public static Addition bacon = new Addition("bacon", 0.25);
    public static Addition jelapeno = new Addition("jelapeno", 0.15);
    public static Addition beef = new Addition("beef", 0.75);
    public static Addition pork = new Addition("pork", 0.5);
    public static Addition chips = new Addition("chips", 0.5);
    public static Addition coke = new Addition("coke", 0.2);
}
