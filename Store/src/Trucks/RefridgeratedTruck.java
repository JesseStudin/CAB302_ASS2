package Trucks;

public class RefridgeratedTruck extends Truck{

	@Override
	public double truckCost(double truckTemperature) {
		// TODO Auto-generated method stub
		System.out.println(900 + 200 * Math.pow(0.7, truckTemperature / 5));
		return 900 + 200 * Math.pow(0.7, truckTemperature / 5);
	}

	@Override
	public int cargoCapacity() {
		// TODO Auto-generated method stub
		return 800;
	}

	@Override
	public boolean cargoRestriction(String check) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
