package com.techelevator.view;

import com.techelevator.Chip;
import org.junit.Assert;
import org.junit.Test;

public class ChipTest {
    @Test
    public void does_it_play_the_correct_sound(){
        String price = "";
        String name = "";
        Chip chip = new Chip(name,price);

        String expected ="\"Munch Munch, Yum!\"";
        String actual = chip.getReturnMessage();

        Assert.assertEquals(expected,actual);
    }
}
