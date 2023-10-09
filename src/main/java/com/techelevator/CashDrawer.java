package com.techelevator;

public class CashDrawer {
    //Instance Variable
    public int balance;

    //Constructor
    public CashDrawer() {
        balance = 0;
    }

    //Methods
    public void addMoney(int amountToDeposit) {
        balance = balance + (amountToDeposit * 100);
    }

    public void withdrawMoney(int amountToWithdraw) {
        balance = balance - (amountToWithdraw);
    }

    public int getBalanceInPennies() {
        return balance;
    }

    // Adds "$" and a "." to the amount deposited to balance
    public String getBalanceAsString() {
        int currentBalanceAsInt = balance;
        double currentBalanceAsDouble = (currentBalanceAsInt / 100.00);
        String formattedDoubleAsString = "$" + String.format("%.2f", currentBalanceAsDouble);
        return formattedDoubleAsString;
    }

    //
    public String returnChangeAsCoins(int balance) {
        //Coin tracker to count each coin
        int tracker = balance;

        //Return Variables
        int totalQuartersToReturn = 0;
        int totalDimesToReturn = 0;
        int totalNickelsToReturn = 0;

        //Amount each coin equals
        int quarter = 25;
        int dime = 10;
        int nickel = 5;

        //Used to count how many coins we need
        while (tracker > 0) {
            if (tracker >= quarter) {
                totalQuartersToReturn++;
                tracker -= quarter;
            } else if (tracker >= dime) {
                totalDimesToReturn++;
                tracker -= dime;
            } else if (tracker >= nickel) {
                totalNickelsToReturn++;
                tracker -= nickel;
            }
        }
        //Sets the new balance to 0 after dispensing all coins
        this.balance = 0;

        String returnString = "Your change is " + totalQuartersToReturn + " quarters, " + totalDimesToReturn
                + " dimes, " + "and " + totalNickelsToReturn + " nickels.";
        return returnString;
    }

}