package com.techelevator;

public abstract class Item {

    private String name;
    private String price;

    //Constructor
    public Item(String name, String price) {
        this.name = name;
        this.price = price;
    }


    //Getters
    public abstract String getReturnMessage();

    public String getName() {
        return name;
    }

    public String getPriceAsString() {
        return price;
    }

    //Replaces the price as pennies
    public int getPriceAsIntInPennies() {
        price = price.replace("$", "").replace(".", "");
        return Integer.parseInt(price);
    }
}