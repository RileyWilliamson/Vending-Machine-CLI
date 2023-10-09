package com.techelevator;

public class Gum extends Item {

    public Gum(String name, String price) {
        super(name, price);
    }

    @Override
    public String getReturnMessage() {
        return "\"Chew Chew, Yum!\"";
    }

}