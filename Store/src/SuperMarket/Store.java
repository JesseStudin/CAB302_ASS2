/*
 * Store.Java
 * 
 * Written by: Jesse Studin and Pierce Thompson.
 * 
 * This file is used to hold the Store Capital values for use in this program.
 */
package SuperMarket;

import java.util.ArrayList;
import java.util.List;

import Produce.Item;

public class Store
{
	private List<Item> inventoryNames = new ArrayList<Item>();
	private double capital = 100000.00;					// Setting the Default Capital.
	private static final long serialVersionUID = 1L;	// Set the serial version ID.
	private static Store instance = new Store();		// Create a Static instance of this script.
	
	private Store() {}

	//This Function is used to get the instance of this script.
	public static Store getInstance()
	{
		return instance;
	}
	
	//This Function is used to retrieve the store's capital.
	public String getCapital()
	{
		String tempHold = String.format("%.2f", this.capital);
		return tempHold;
	}
	
	public List<Item> getInventoryNames() {
		return this.inventoryNames;
	}

	//This Function is used to set the store's capital.
	public void setCapital(double amount)
	{
		this.capital = this.capital - amount;
	}
	
	//This Function is used to set the store's capital profit.
	public void setCapitalProfit(double amount) {
		this.capital = this.capital + amount;
	}
	
	public void setInventoryNames(List<Item> inventoryNames) {
		this.inventoryNames = inventoryNames;
	}
}