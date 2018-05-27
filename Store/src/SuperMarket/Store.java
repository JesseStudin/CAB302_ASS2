/**
 * @author Jesse Studin, Pierce Thompson
 */

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
	
	/**
	 * private constructor - Singleton Class
	 */
	private Store() {}

	//This Function is used to get the instance of this Class.
	/**
	 * Has only one version of this Class
	 * @return instance returns one instance of the class
	 */
	public static Store getInstance()
	{
		return instance;
	}
	
	//This Function is used to retrieve the store's capital.
	/**
	 * Returns the capital as a string to be implemented in GUI
	 * @return tempHold String value representing Capital as a double to 2 decimal places
	 */
	public String getCapital()
	{
		String tempHold = String.format("%.2f", this.capital);
		return tempHold;
	}
	
	/**
	 * Returns the inventory names in the form of a list
	 * @return inventoryNames Returns a List Item InventoryNames which contains all created objects
	 */
	public List<Item> getInventoryNames() {
		return this.inventoryNames;
	}

	//This Function is used to set the store's capital.
	/**
	 * Sets the capital amount when Manifest is delivered
	 * @param amount Substracts from current capital to get new capital representing Manifest Delivery
	 */
	public void setCapital(double amount)
	{
		this.capital = this.capital - amount;
	}
	
	//This Function is used to set the store's capital profit.
	/**
	 * Sets capital to represent that salesLog has delivered Profits
	 * @param amount the amount to be added to the capital. Represents profits made in SalesLog.csv's
	 */
	public void setCapitalProfit(double amount) {
		this.capital = this.capital + amount;
	}
	
	/**
	 * Sets the current inventoryNames - Used to store all inventory names or reset them if needed
	 * @param inventoryNames Used to store newly made inventory or Reset the inventory (Uses List Item  as Param)
	 */
	public void setInventoryNames(List<Item> inventoryNames) {
		this.inventoryNames = inventoryNames;
	}
}