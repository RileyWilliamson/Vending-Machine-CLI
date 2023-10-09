package com.techelevator;

public class Drink extends Item {

    public Drink(String name, String price) {
        super(name, price);
    }

    @Override
    public String getReturnMessage() {
        return "\"Glug Glug, Yum!\"";
    }

}