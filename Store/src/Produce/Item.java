/*
 * Item.Java
 * 
 * Written by: Jesse Studin and Pierce Thompson.
 * 
 * This file handles the creation of an Item to be used within the rest of the program, and then eventually rendered on the GUI.
 */
package Produce;

/**
 * 
 * @author Jesse Studin, Pierce Thompson
 *
 */
public class Item {

	private String name;									//This Variable controls the name of the current instanced item.
	private double cost, sellPrice, temperaturecel;			//These doubles control the cost, saleprice and temperature of the instanced item.
	private int reorderPoint, reorderAmount, quantity;		//These integers control the reorderPoint, reorderAmount and quantity of the instanced item.
	private boolean temperatureCheck;						//This boolean is used to check if the instanced item requires a temperature to be stored.

	/*
	 * This function creates a new item for use that doesn't require a temperature value for the table.
	 */
	/**
	 * The Item Constructor, used when the item does not contain a temperature value
	 * @param name String variable to represent item name
	 * @param quantity int variable, used to represent current item quantity
	 * @param cost double variable, used to represent item Cost
	 * @param sellPrice double variable, used to represent item selling price
	 * @param reorderPoint int variable, used to represent item reordering point
	 * @param reorderAmount int variable, represents reorderAmount
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
	/**
	 * Creates an Item Object with a temperature (double temperatureCel)
	 * @param name String variable, represents the object Name
	 * @param quantity int variable, represents the item quantity
	 * @param cost double variable, represents the items cost
	 * @param sellPrice double variable, represents the items selling price 
	 * @param reorderPoint int variable, represents the items value of when to reorder
	 * @param reorderAmount int variable, represents the items reorderamount
	 * @param temperaturecel double variable, represents the temperature the item should be cooled at
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
	/**
	 * Gets the Object Name 
	 * @return String Returns the Name as a String
	 */
	public String getName() {
		return this.name;
	}

	//Returns the quantity of the item.
	/**
	 * Gets the quantity value of the item
	 * @return quantity gets the quantity value of the object
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Gets the Cost value of the item
	 * @return cost returns cost value
	 */
	public double getCost() {
		return this.cost;
	}

	//Returns the sale price of the item.
	/**
	 * gets the items current selling price
	 * @return sellPrice returns current item sellprice (.sellPrice())
	 */
	public double getsellPrice() {
		return this.sellPrice;
	}

	//Returns the re-order point of the item.
	/**
	 * Gets the current ReorderPoint value(int)
	 * @return reorderPoint returns the current reorderPoint 
	 */
	public int getReorderPoint() {
		return this.reorderPoint;
	}

	//Returns the re-order amount of the item.
	/**
	 * gets the current item reorderAmount
	 * @return reorderAmount returns current reorderAmount(.reorderAmount())
	 */
	public int getReorderAmount() {
		return this.reorderAmount;
	}

	//Returns the temperature in degrees celsius required to store the item.
	/**
	 * Gets current Temperature in Celsius
	 * @return temperatureCel Returns current temperatureCel
	 */
	public double getTemperatureCel() {
		return this.temperaturecel;
	}

	//Returns whether or not the item requires to be at a specific temperature.
	/**
	 * Returns true if the Item contains a temperature value, false if it does not
	 * @return temperatureCheck Returns true or false depending if item contain temperatureCel variable.
	 */
	public boolean getTemperatureCheck() {
		return this.temperatureCheck;
	}

	/*
	 * Public Setters:
	 */
	
	//Sets the item's name.
	/**
	 * Sets the name according to the parameter argument
	 * @param name returns name set by argument passed in parameter
	 */
	public void setName(String name) {
		this.name = name;
	}
	//reSetsturns the quantity of the item.
	/**
	 * Sets the cost according to parameter value
	 * @param cost parameter value is what cost will be
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	//reSetsturns the quantity of the item.
	/**
	 * Sets current SellPrice according to Parameter value
	 * @param sellPrice Sets the item selling price
	 */
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	//Sets the sale price of the item.
	/**
	 * Sets the reorderPoint according to parameter value
	 * @param reorderPoint sets the item reorderPoint
	 */
	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}
	//Sets the re-order point of the item.
	/**
	 * sets the item reorderAmount according to parameter
	 * @param reorderAmount sets the item reorderAmount
	 */
	public void  setReorderAmount(int reorderAmount) {
		this.reorderAmount = reorderAmount;
	}
	//Sets the re-order amount of the item.
	/**
	 * Sets the temperatureCel value according to parameter argument
	 * @param temperaturecel sets the item temperature cel
	 */
	public void setTemperatureCel(double temperaturecel) {
		this.temperaturecel = temperaturecel;
	}
	//Sets the temperature in degrees celsius required to store the item.
	/**
	 * decreases the quantity value if sold
	 * @param quantity Subtracts quantity value from quantity to get a new value
	 * representative of the sale
	 */
	public void setQuantitySale(int quantity) {
		this.quantity = this.quantity - quantity;
	}
	/**
	 * Sets the quantityManifest value, this increases stock if manifest delivered
	 * @param quantity gets added onto current quantity value to represent manifest delivery
	 */
	public void setQuantityManifest(int quantity) {
		this.quantity = this.quantity + quantity;
	}
}
