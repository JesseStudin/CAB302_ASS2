/*
 * Item.Java
 * 
 * Written by: Jesse Studin and Pierce Thompson.
 * 
 * This file handles the creation of an Item to be used within the rest of the program, and then eventually rendered on the GUI.
 */
package Produce;

public class Item {

	private String name;									//This Variable controls the name of the current instanced item.
	private double cost, sellPrice, temperaturecel;			//These doubles control the cost, saleprice and temperature of the instanced item.
	private int reorderPoint, reorderAmount, quantity;		//These integers control the reorderPoint, reorderAmount and quantity of the instanced item.
	private boolean temperatureCheck;						//This boolean is used to check if the instanced item requires a temperature to be stored.

	/*
	 * This function creates a new item for use that doesn't require a temperature value for the table.
	 */
	public Item(String name, int quantity, double cost, double sellPrice, int reorderPoint, int reorderAmount) {
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
		this.sellPrice = sellPrice;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
		this.temperatureCheck = false;
	}

	/*
	 * This function creates a new item for use that requires a temperature value for the table.
	 */
	public Item(String name,int quantity, double cost, double sellPrice, int reorderPoint, int reorderAmount, double temperaturecel) {
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
		this.sellPrice = sellPrice;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
		this.temperaturecel = temperaturecel;
		this.temperatureCheck = true;
	}

	/*
	 * Public Getters:
	 */
	
	//Returns the item's name.
	public String getName() {
		return this.name;
	}

	//Returns the quantity of the item.
	public int getQuantity() {
		return this.quantity;
	}

	//Returns the quantity of the item.
	public double getCost() {
		return this.cost;
	}

	//Returns the sale price of the item.
	public double getsellPrice() {
		return this.sellPrice;
	}

	//Returns the re-order point of the item.
	public int getReorderPoint() {
		return this.reorderPoint;
	}

	//Returns the re-order amount of the item.
	public int getReorderAmount() {
		return this.reorderAmount;
	}

	//Returns the temperature in degrees celsius required to store the item.
	public double getTemperatureCel() {
		return this.temperaturecel;
	}

	//Returns whether or not the item requires to be at a specific temperature.
	public boolean getTemperatureCheck() {
		return this.temperatureCheck;
	}

	/*
	 * Public Setters:
	 */
	
	//Sets the item's name.
	public void setName(String name) {
		this.name = name;
	}
	//reSetsturns the quantity of the item.
	public void setCost(double cost) {
		this.cost = cost;
	}
	//reSetsturns the quantity of the item.
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	//Sets the sale price of the item.
	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}
	//Sets the re-order point of the item.
	public void  setReorderAmount(int reorderAmount) {
		this.reorderAmount = reorderAmount;
	}
	//Sets the re-order amount of the item.
	public void setTemperatureCel(double temperaturecel) {
		this.temperaturecel = temperaturecel;
	}
	//Sets the temperature in degrees celsius required to store the item.
	public void setQuantitySale(int quantity) {
		this.quantity = this.quantity - quantity;
	}
	//Sets whether or not the item requires to be at a specific temperature.
	public void setQuantityManifest(int quantity) {
		this.quantity = this.quantity + quantity;
	}
}
