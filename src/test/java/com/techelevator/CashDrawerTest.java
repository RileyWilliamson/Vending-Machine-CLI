package com.techelevator.view;

import com.techelevator.CashDrawer;
import org.junit.Assert;
import org.junit.Test;

public class CashDrawerTest {
//Arrange
    //act
    //assert

    @Test
    public void correct_coins_test1(){
        CashDrawer cashDrawer= new CashDrawer();

        String expected ="Your change is 40 quarters, 0 dimes, and 0 nickels.";
        String actual = cashDrawer.returnChangeAsCoins(1000);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void correct_coins_test2(){
        CashDrawer cashDrawer= new CashDrawer();

        String expected ="Your change is 227 quarters, 1 dimes, and 0 nickels.";
        String actual = cashDrawer.returnChangeAsCoins(5685);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void does_balance_get_as_string1(){
        CashDrawer cashDrawer= new CashDrawer();
        cashDrawer.balance = 200;

        String expected ="$2.00";
        String actual = cashDrawer.getBalanceAsString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void does_balance_get_as_string2(){
        CashDrawer cashDrawer= new CashDrawer();
        cashDrawer.balance = 1923;

        String expected ="$19.23";
        String actual = cashDrawer.getBalanceAsString();

        Assert.assertEquals(expected, actual);
    }
}
