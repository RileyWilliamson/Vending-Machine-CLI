package com.techelevator.view;

import com.techelevator.Gum;
import org.junit.Assert;
import org.junit.Test;

public class GumTest {
    @Test
    public void does_it_play_the_correct_sound(){
        String price = "";
        String name = "";
        Gum gum = new Gum(name,price);

        String expected ="\"Munch Munch, Yum!\"";
        String actual = gum.getReturnMessage();

        Assert.assertEquals(expected,actual);
    }
}
