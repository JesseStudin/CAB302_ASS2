
/**
 * @author Jesse Studin, Piece Thompson
*/
/*
 * Truck.Java
 * 
 * Written by: Jesse Studin and Pierce Thompson.
 * 
 * This file is the base for the other two truck files.
 */
package Trucks;

public abstract class Truck
{

	/**
	 * Sets the cargoPrice when finding capital loss from Manifest Delivery
	 * @param totalCargo The Argumment will be either the Cargo Total or the Highest Temperature
	 * @return double returns a double value which will be the truckCost
	 */
	public abstract double truckCost(double totalCargo);
	/**
	 * 
	 * @return int returns the cargo capacity
	 */
	public abstract int cargoCapacity();
	/**
	 * Returns the current cargoRestriction true or false
	 * @param check Check is the argument passed that says whether checked or not
	 * @return boolean returns true or false
	 */
	public abstract boolean cargoRestriction(String check);


}