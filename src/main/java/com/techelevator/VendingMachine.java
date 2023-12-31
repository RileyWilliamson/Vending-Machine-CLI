package com.techelevator;

import com.techelevator.Inventory;
import com.techelevator.Item;
import com.techelevator.ShoppingCart;
import com.techelevator.CashDrawer;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class VendingMachine {

    //Instance Variables
    private Inventory vendingMachineInventory;
    private com.techelevator.CashDrawer vendingMachineCoinBox;
    private ReadFile vendingMachineFileReader;
    private TransactionLog vendingMachineLogger;
    private ShoppingCart vendingMachineShoppingCart;


    //Constructors
    public VendingMachine(Inventory vendingMachineInventory) throws IOException {
        this.vendingMachineInventory = vendingMachineInventory;
        vendingMachineFileReader = new ReadFile();
        vendingMachineInventory = new Inventory(vendingMachineFileReader);
        vendingMachineCoinBox = new CashDrawer();
        vendingMachineLogger = new TransactionLog();
        vendingMachineShoppingCart = new ShoppingCart();
    }


    //Methods

    public void feedMoney(int billInserted) throws IOException {
        vendingMachineCoinBox.addMoney(billInserted);
        String billInsertedAsString = "$" + billInserted + ".00";
        vendingMachineLogger.logEvent("FEED MONEY:", billInsertedAsString, getBalanceAsString());
    }

    public void subtractMoney(String slotLocation) {
        int debit = vendingMachineInventory.vendingMachineStock().get(slotLocation).getPriceAsIntInPennies();
        vendingMachineCoinBox.withdrawMoney(debit);

    }

    public int getBalanceInPennies() {
        int balance = vendingMachineCoinBox.getBalanceInPennies();
        return balance;
    }

    public String getBalanceAsString() {
        String returnString = vendingMachineCoinBox.getBalanceAsString();
        return returnString;
    }

    public String returnChangeInCoins() throws IOException {
        vendingMachineLogger.logEvent("GIVE CHANGE:", getBalanceAsString(), "$0.00");
        String returnString = vendingMachineCoinBox.returnChangeAsCoins(getBalanceInPennies());
        return returnString;
    }

    public void subtractFromInventory(String slotLocation) {
        vendingMachineInventory.subtractFromInventory(slotLocation);
    }

    public List<String> getInventoryString() {
        Map<String, Item> returnMap = vendingMachineFileReader.createMapOfLocationAndItems();

        List<String> inventory = new ArrayList<>();

        for (Map.Entry<String, Item> entry : returnMap.entrySet()) {
            String inventoryValueToString = String
                    .valueOf(vendingMachineInventory.returnCurrentInventory(entry.getKey()));

            if (inventoryValueToString.contentEquals("0")) {
                inventoryValueToString = "Sold Out";
            }

            String formattedString = String.format("%-5s %-22s %-5s %-5s", entry.getKey(), entry.getValue().getName(),
                    entry.getValue().getPriceAsString(), inventoryValueToString);
            inventory.add(formattedString);

        }
        return inventory;
    }

    public List<String> returnMessages() {
        return vendingMachineShoppingCart.returnListOfReturnMessages();
    }

    //Updats balance and then checks the Inventory
    public String purchaseItem(String slotLocation) throws IOException {
        //This will tell if it's out of stock
        try {
            if (vendingMachineInventory.returnCurrentInventory(slotLocation) == 0) {
                return vendingMachineInventory.vendingMachineStock().get(slotLocation).getName() + " Sold Out \n";
            } else if (vendingMachineCoinBox.getBalanceInPennies() < vendingMachineInventory.vendingMachineStock()
                    .get(slotLocation).getPriceAsIntInPennies()) {
                return "Please Insert Additional Funds \n";
            } else {
                String balanceBeforePurchase = getBalanceAsString();
                subtractFromInventory(slotLocation);
                subtractMoney(slotLocation);
                String successfulPurchase = "Thank You For Purchasing "
                        + vendingMachineInventory.vendingMachineStock().get(slotLocation).getName() + "\n";
                vendingMachineShoppingCart
                        .addReturnMessageToList(vendingMachineInventory.vendingMachineStock().get(slotLocation).getReturnMessage());
                vendingMachineLogger.logEvent(
                        vendingMachineInventory.vendingMachineStock().get(slotLocation).getName() + "  " + slotLocation,
                        balanceBeforePurchase, getBalanceAsString());
                return successfulPurchase;
            }

        } catch (NullPointerException e) {
            return "Please Make A Valid Selection \n";
        }
    }
}