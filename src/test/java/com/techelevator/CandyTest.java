package com.techelevator.view;

import com.techelevator.Candy;
import org.junit.Assert;
import org.junit.Test;

public class CandyTest {


    @Test
    public void does_it_play_the_correct_sound(){
        String price = "";
        String name = "";
        Candy candy = new Candy(name,price);

        String expected ="\"Munch Munch, Yum!\"";
        String actual = candy.getReturnMessage();

        Assert.assertEquals(expected,actual);
    }
}
