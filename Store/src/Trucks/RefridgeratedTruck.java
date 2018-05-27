/*
 * RefridgeratedTruck.Java
 * 
 * Written by: Jesse Studin and Pierce Thompson.
 * 
 * This file handles the refridgerated trucks.
 */
package Trucks;

public class RefridgeratedTruck extends Truck{

	@Override
	//This Function returns the cost of the Truck being used.
	public double truckCost(double truckTemperature) {
		// TODO Auto-generated method stub
		System.out.println(900 + 200 * Math.pow(0.7, truckTemperature / 5));
		return 900 + 200 * Math.pow(0.7, truckTemperature / 5);
	}

	@Override
	//This Function returns the capacity of the cargo.
	public int cargoCapacity() {
		// TODO Auto-generated method stub
		return 800;
	}

	@Override
	//This Function Returns whether or not the cargo has restrictions on it.
	public boolean cargoRestriction(String check) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
