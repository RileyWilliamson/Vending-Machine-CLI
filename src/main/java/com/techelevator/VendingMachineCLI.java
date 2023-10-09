package com.techelevator;

import java.io.IOException;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				menu.displayInventory();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				while (true) {
					String choice2 = (String) menu.getChoiceFromOptionsPurchaseMenu(PURCHASE_MENU_OPTIONS);

					if (choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						//Adds money (Defined in "Menu" class
						menu.feedMoney();

					} else if (choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						menu.selectProduct();
						System.out.println();
						//Displays the return message depending on the type of item
						menu.returnSoundMessages();
						System.out.println();
					} else if (choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						menu.finishTransaction();
						break;
					}
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.exit(0);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}