package com.techelevator.view;

import com.techelevator.Inventory;
import com.techelevator.ReadFile;
import com.techelevator.VendingMachine;
import java.io.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu  {

	private PrintWriter out;
	private Scanner in;
	private ReadFile vendingMachineFileReader = new ReadFile();
	private Inventory inventory = new Inventory(vendingMachineFileReader);
	private VendingMachine vendingMachine = new VendingMachine(inventory);

	public Menu(InputStream input, OutputStream output)throws IOException {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
		inventory.vendingMachineStock();

	}

	public Object getChoiceFromOptions(Object[] options) {
		//Sets to null because its empty first
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		//Returns the user's choice
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
		}
		if (choice == null) {
			//If user doesn't select one of the valid options, it will return this message
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}

	public Object getChoiceFromOptionsPurchaseMenu(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptionsPurchaseMenu(options);
			choice = getChoiceFromUserInputPurchaseMenu(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInputPurchaseMenu(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {

		}
		if (choice == null) {
			out.println("\n*** " + userInput + " Is Not A Valid Option ***\n");
		}
		return choice;
	}
	//Purchase menu options
	private void displayMenuOptionsPurchaseMenu(Object[] options) {

		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.println("Current Money Provided: " + displayCurrentBalance());
		out.print("\nPlease Choose An Option >>> ");
		out.flush();

	}

	//Displays each line in the inventory
	public void displayInventory() {
		for (String eachLine : vendingMachine.getInventoryString()) {
			System.out.println(eachLine);
		}
	}


	public void feedMoney() throws IOException {
		System.out.println("Please Insert A Valid Bill ($1, 2$, 5$, 10$, 20$, 50$, 100$");
		try {
			//defines moneyInserted as users next int value
			int moneyInserted = in.nextInt();
			in.nextLine();
			//Only allows accurate bill types to be entered in the machine
			if (moneyInserted == 1 || moneyInserted == 2 || moneyInserted == 5 || moneyInserted == 10
					|| moneyInserted == 20 || moneyInserted == 50 || moneyInserted == 100) {
				vendingMachine.feedMoney(moneyInserted);
				//Turns users int into a string that looks like "$2.00" instead of "2"
				System.out.println("Thank You For inserting $" + moneyInserted + ".00");
			} else {
				System.out.println("Please Insert Valid Currency");
			}
		} catch (InputMismatchException e) {
			System.out.println("Please Insert Valid Currency");
		}

	}

	public void selectProduct() throws IOException {
		System.out.println("Please Select Product");
		String userSelection = in.nextLine().toUpperCase();
		String returnString = vendingMachine.purchaseItem(userSelection);
		System.out.println(returnString);

	}

	public String displayCurrentBalance() {
		return vendingMachine.getBalanceAsString();

	}

	public void finishTransaction() throws IOException {
		System.out.println(vendingMachine.returnChangeInCoins());
	}

	public void returnSoundMessages() {
		for (String eachLine : vendingMachine.returnMessages()) {
			System.out.println(eachLine);
		}

	}
}