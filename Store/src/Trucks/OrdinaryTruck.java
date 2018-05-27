<<<<<<< HEAD
/**
 * @author Jesse Studin, Pierce Thompson
=======
/*
 * OrdinaryTruck.Java
 * 
 * Written by: Jesse Studin and Pierce Thompson.
 * 
 * This file handles the non-refridgerated trucks.
>>>>>>> 948a4f87e649f199f682f9c12a97f98946ef89b5
 */
package Trucks;

public class OrdinaryTruck extends Truck {

<<<<<<< HEAD
	
	private int cargoCapacity;
	//create instance of Stock

	@Override
=======
	private int cargoCapacity;										//Create a private integer to store the cargoCapacity.

	//This Function returns the cost of the Truck being used.
>>>>>>> 948a4f87e649f199f682f9c12a97f98946ef89b5
	public double truckCost(double cargoTotal) {
		return 750 + (0.25 * (int)cargoTotal);
	}

	@Override
	//This Function returns the capacity of the cargo.
	public int cargoCapacity() {
		return this.cargoCapacity = 1000;
	}

	@Override
	//This Function Returns whether or not the cargo has restrictions on it.
	public boolean cargoRestriction(String check) {
		if(check == "TempControlled") {
			return false;
		} else {
			return true;
		}
	}
}