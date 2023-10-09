package com.techelevator;

public class Chip extends Item {

    public Chip(String name, String price) {
        super(name, price);
    }

    //Spits out the return message
    @Override
    public String getReturnMessage() {
        return "\"Crunch Crunch, Yum!\"";
    }

}