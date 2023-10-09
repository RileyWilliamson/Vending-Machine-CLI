package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {

    private static String fileName = "vendingmachine.csv";
    private static File inventoryFile = new File(fileName);

    public ReadFile() {
        this.fileName = "vendingmachine.csv";
    }

    public static List<String> getListOfAllLines() {
        List<String> listOfInputFileLines = new ArrayList<String>();
        try (Scanner fileScanner = new Scanner(inventoryFile)) {
            while (fileScanner.hasNextLine()) {
                listOfInputFileLines.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
        }
        return listOfInputFileLines;

    }

    public static List<String[]> inventoryAsArrayList() {

        List<String[]> inventoryArray = new ArrayList<String[]>();

        for (String currentString : getListOfAllLines()) {
            inventoryArray.add(currentString.split("\\|"));
        }
        return inventoryArray;

    }

    public static Map<String, Item> createMapOfLocationAndItems() {
        //Creates a new Map
        Map<String, Item> inventoryMap = new HashMap<>();

        //Loops through to get a list of items
        for (String currentString : getListOfAllLines()) {
            String[] tempSplitString = currentString.split("\\|");
            if (tempSplitString[3].equals("Candy")) {
                Candy candy = new Candy(tempSplitString[1], tempSplitString[2]);
                inventoryMap.put(tempSplitString[0], candy);
            } else if (tempSplitString[3].equals("Chip")) {
                Chip chip = new Chip(tempSplitString[1], tempSplitString[2]);
                inventoryMap.put(tempSplitString[0], chip);
            } else if (tempSplitString[3].equals("Drink")) {
                Drink drink = new Drink(tempSplitString[1], tempSplitString[2]);
                inventoryMap.put(tempSplitString[0], drink);
            } else if (tempSplitString[3].equals("Gum")) {
                Gum gum = new Gum(tempSplitString[1], tempSplitString[2]);
                inventoryMap.put(tempSplitString[0], gum);
            }
        }
        return inventoryMap;
    }

}