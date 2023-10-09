package com.techelevator.view;

import com.techelevator.CashDrawer;
import com.techelevator.Inventory;
import com.techelevator.Item;
import com.techelevator.ReadFile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InventoryTest{




    @Test
    public void does_it_stock_on_startup(){
        Inventory inventory = new Inventory(new ReadFile());
        Map<String, Integer> testStockMap = new HashMap<>();

        testStockMap.put("A1",5);
        testStockMap.put("A2",5);
        testStockMap.put("A3",5);
        testStockMap.put("A4",5);
        testStockMap.put("B1",5);
        testStockMap.put("B2",5);
        testStockMap.put("B3",5);
        testStockMap.put("B4",5);
        testStockMap.put("C1",5);
        testStockMap.put("C2",5);
        testStockMap.put("C3",5);
        testStockMap.put("C4",5);
        testStockMap.put("D1",5);
        testStockMap.put("D2",5);
        testStockMap.put("D3",5);
        testStockMap.put("D4",5);


        Map<String, Integer> expected = testStockMap;
        Map<String, Integer> actual = inventory.returnInventoryMap();

        Assert.assertEquals(expected, actual);
    }


}
