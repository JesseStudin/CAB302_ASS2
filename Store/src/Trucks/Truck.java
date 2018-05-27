<<<<<<< HEAD
/**
 * @author Jesse Studin, Piece Thompson
=======
/*
 * Truck.Java
 * 
 * Written by: Jesse Studin and Pierce Thompson.
 * 
 * This file is the base for the other two truck files.
>>>>>>> 948a4f87e649f199f682f9c12a97f98946ef89b5
 */
package Trucks;

public abstract class Truck
{
<<<<<<< HEAD
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
=======
	public abstract double truckCost(double totalCargo);								//Create an Abstract double to store the truckCost.
	public abstract int cargoCapacity();												//Create an Abstract integer to store the cargoCapacity.
	public abstract boolean cargoRestriction(String check);								//Create an Abstract boolean to store the cargoRestriction.
>>>>>>> 948a4f87e649f199f682f9c12a97f98946ef89b5
}