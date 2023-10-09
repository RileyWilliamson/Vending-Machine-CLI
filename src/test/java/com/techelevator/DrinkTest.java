package com.techelevator.view;


import com.techelevator.Drink;
import org.junit.Assert;
import org.junit.Test;

public class DrinkTest {
    @Test
    public void does_it_play_the_correct_sound(){
        String price = "";
        String name = "";
        Drink drink = new Drink(name,price);

        String expected ="\"Glug Glug, Yum!\"";
        String actual = drink.getReturnMessage();

        Assert.assertEquals(expected,actual);
    }
}
