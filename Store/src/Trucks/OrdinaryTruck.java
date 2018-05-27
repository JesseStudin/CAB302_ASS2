package Trucks;

import java.lang.Math;
public class OrdinaryTruck extends Truck {

	private int cargoCapacity;
	//create instance of Stock


	public double truckCost(double cargoTotal) {
		return 750 + (0.25 * (int)cargoTotal);
	}

	@Override
	public int cargoCapacity() {
		return this.cargoCapacity = 1000;
	}

	@Override
	public boolean cargoRestriction(String check) {
		if(check == "TempControlled") {
			return false;
		} else {
			return true;
		}
	}
}
