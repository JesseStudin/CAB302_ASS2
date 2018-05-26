package Produce;

import Manifests.Manifest;
import Manifests.StoreItems;
import SuperMarket.Store;
import Trucks.OrdinaryTruck;

import java.io.File;
import java.util.*;

public class Stock {

	private List<Item> item = new ArrayList<Item>();
	//reset this list every now and again
	private LinkedHashMap<String, Integer> updateStock = new LinkedHashMap<>();
	private LinkedHashMap<String, Integer> reorderAmounts = new LinkedHashMap<>();
	private Manifest maniTemp = new Manifest();
	private StoreItems storedItems = StoreItems.getInstance();
	private double cargoTotalOrd;
	private int ordCargo;
	private int refridgeCargo;
	private List<Item> objectNames = new ArrayList<Item>();

	public void storeInventory() {
		this.objectNames = storedItems.getObjectNames();
		for(int i = 0; i < objectNames.size(); i++) {
			objectNames.get(i).getName();
			objectNames.get(i).getQuantity();
			if(objectNames.get(i).getTemperatureCheck() == true) {
				objectNames.get(i).getTemperatureCel();
			}
		}
	}
	
	
	//this should return the show inventory
	//you'll probably need to run a for loop and 
	//and the function below returns the object amount to use a '
	//for(int i = 0; i < [functionbelow]
	
	public String[] showInventory(int i) {
		String[] holdValues = new String[objectNames.size()];
		holdValues[0] = objectNames.get(i).getName();
		holdValues[1] = Integer.toString(objectNames.get(i).getQuantity());
		holdValues[2] = Double.toString(objectNames.get(i).getCost());
		holdValues[3] = Double.toString(objectNames.get(i).getsellPrice());
		holdValues[4] = Integer.toString(objectNames.get(i).getReorderPoint());
		holdValues[5] = Integer.toString(objectNames.get(i).getReorderAmount());
		if(objectNames.get(i).getTemperatureCheck() == false) {
			holdValues[6] = Double.toString(0.0);
		} else {
			holdValues[6] = Double.toString(objectNames.get(i).getTemperatureCel());
		}
		return holdValues;
	}
	//use this to create all the objects! i is the 
	//current for loop counter in gui 
	public int getObjectAmount() {
		return objectNames.size();
	}
	
	//use this to initiliase
	public void initialise(File inventProp) {
		objectNames = maniTemp.setInitialInvent(inventProp);
		storedItems.setObjectNames(objectNames);
		List<Item> checkItWorked = new ArrayList<Item>();
		checkItWorked = storedItems.getObjectNames();
		System.out.println("Initialise Entered");
		for(int i = 0; i < checkItWorked.size(); i++) {
			System.out.println("Entered for loop");
			System.out.println(checkItWorked.get(i));
		}
		
		//current capital after prop
		double currentValue = 0;
		for(int i = 0; i < getObjectAmount(); i++) {
			currentValue = currentValue + ((double)objectNames.get(i).getCost() * objectNames.get(i).getQuantity());
		}
		Store store = Store.getInstance();
		store.setCapital(currentValue);
	}
	
	//stock value


	
	//create manifest for reorder!
	public void stockOrder() {
		//create instance of manifest
		//remove all current order Information with new information
		for(int i = 0; i < reorderAmounts.size(); i++) {
			reorderAmounts.remove(maniTemp.objectNames.get(i).getName());
		}
		List<String> reorderNames = new ArrayList();
		objectNames = storedItems.getObjectNames();
		for(int i = 0; i < objectNames.size(); i++) {
			System.out.println("Entered for loop in stockOrder");
			if(objectNames.get(i).getQuantity() <= objectNames.get(i).getReorderPoint()) {
				System.out.println("Values were correct");
				reorderAmounts.put(maniTemp.objectNames.get(i).getName(), maniTemp.objectNames.get(i).getReorderAmount());
				reorderNames.add(objectNames.get(i).getName());
			}
		}
		for(int i = 0; i < reorderNames.size(); i++) {
			System.out.println("First Name is: " + reorderNames.get(i));
		}
		maniTemp.stockOrder(reorderAmounts);
	}

	
	//this updates the store total
	//use this when reloading the manifest (delivered)
	public void manifestDelivered(File delManifest) {
		updateStock = maniTemp.openManifest(delManifest);
		double cargoSum = 0;
		for(int i = 0; i < updateStock.size(); i++) {
			objectNames.get(i).setQuantity(updateStock.get(objectNames.get(i).getName()));
			cargoSum += objectNames.get(i).getQuantity();
		}
		OrdinaryTruck ordTruck = new OrdinaryTruck();
		//haven't added refridgerated Truck Yet
		double cargoTot = ordTruck.truckCost(cargoSum);
		Store store = Store.getInstance();
		store.setCapital(cargoTot);

	}
	
	public void salesLog(File salesLog) {
		maniTemp.salesLog(salesLog);
		int capitalSum = 0;
		Store store = Store.getInstance();
		store.setCapital(capitalSum);
	}

	public double getCargoOrd() {
		return this.cargoTotalOrd;
	}

	private boolean tempChecker(int counter) {
		if(maniTemp.objectNames.get(counter).getTemperatureCheck() == true){
			return true;
		} else {
			return false;
		}
	}

	public int getCargoTotalOrd() {
		for(int i = 0; i < maniTemp.objectNames.size();i++){
			if(tempChecker(i) == false) {
				ordCargo = ordCargo +  reorderAmounts.get(maniTemp.objectNames.get(i).getName());
			}
		}
		return ordCargo;
	}

	public int getCargoTotalRef() {
		for(int i = 0; i < maniTemp.objectNames.size(); i++) {
			if(tempChecker(i) == true) {
				refridgeCargo = refridgeCargo + reorderAmounts.get(maniTemp.objectNames.get(i).getName());
			}
		}
		return refridgeCargo;
	}




}
