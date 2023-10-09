package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    // The list of all purchased
    private List<String> itemsConsumed = new ArrayList<>();

    public void addReturnMessageToList(String itemReturnMessage) {
        itemsConsumed.add(itemReturnMessage);
    }

    public List<String> returnListOfReturnMessages() {
        List<String> returnList = itemsConsumed;
        itemsConsumed = new ArrayList<>();
        return returnList;

    }
}