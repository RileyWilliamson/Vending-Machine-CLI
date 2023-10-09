package com.techelevator;

public class Candy extends Item {

    public Candy(String name, String price) {
        super(name, price);
    }

    @Override
    public String getReturnMessage() {
        return "\"Munch Munch, Yum!\"";
    }

}