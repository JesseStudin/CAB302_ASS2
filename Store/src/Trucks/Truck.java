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
	public abstract double truckCost(double totalCargo);								//Create an Abstract double to store the truckCost.
	public abstract int cargoCapacity();												//Create an Abstract integer to store the cargoCapacity.
	public abstract boolean cargoRestriction(String check);								//Create an Abstract boolean to store the cargoRestriction.
}