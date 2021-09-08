package com.company;

public class Main {

    public static void main(String[] args) {

	    // base burger
        Hamburger burger = new Hamburger("Basic", "Sausage", 3.56, "White");
        burger.addHamburgerAddition1("Tomato", 0.27);
        burger.addHamburgerAddition2("Lettuce", 0.75);
        burger.addHamburgerAddition3("Cheese", 1.13);
        System.out.println("Total Burger price is " + burger.itemizeHamburger());

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.67);
        healthyBurger.addHamburgerAddition1("Egg", 5.43);
        healthyBurger.addHealthyAddition1("Lentils", 3.41);
        System.out.println("Total Burger price is " + healthyBurger.itemizeHamburger());

        DeluxeBurger db = new DeluxeBurger();
        db.addHamburgerAddition3("Should not do this", 50.53);
        System.out.println("Total Burger price is " + db.itemizeHamburger());
    }
}
