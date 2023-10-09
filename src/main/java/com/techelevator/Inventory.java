package com.techelevator;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


public class Inventory {

    //Instance Variables
    private ReadFile fileReaderObject = new ReadFile();
    private Map<String, Integer> inventoryList = new HashMap<>();


    //Constructor
    public Inventory(ReadFile fileReaderObject) {
        this.fileReaderObject = fileReaderObject;
        stocksVendingMachineAtStartup();
    }


    //Methods


    public void stocksVendingMachineAtStartup() {
        //Found in "ReadFile" Class
        for (String[] item : fileReaderObject.inventoryAsArrayList()) {
            int initialStock = 5;
            inventoryList.put(item[0], initialStock);
        }
    }

    public Map<String, Item> vendingMachineStock() {
        return fileReaderObject.createMapOfLocationAndItems();
    }

    public void subtractFromInventory(String slotLocation) {
        inventoryList.put(slotLocation, inventoryList.get(slotLocation) - 1);
    }

    //Getters
    public int returnCurrentInventory(String slotLocation) {
        return inventoryList.get(slotLocation);
    }

    public Map<String, Integer> returnInventoryMap() {
        return inventoryList;
    }
}