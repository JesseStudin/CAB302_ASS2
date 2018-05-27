package Produce;

import Manifests.Manifest;
import Manifests.StoreItems;
import SuperMarket.Store;
import Trucks.OrdinaryTruck;
import Trucks.RefridgeratedTruck;

import java.io.File;
import java.util.*;

public class Stock {

	//reset this list every now and again
	private double cargoTotalOrd;
	private List<Item> objectNames = new ArrayList<Item>();

//	public void storeInventory() {
//		this.objectNames = storedItems.getObjectNames();
//		for(int i = 0; i < objectNames.size(); i++) {
//			objectNames.get(i).getName();
//			objectNames.get(i).getQuantity();
//			if(objectNames.get(i).getTemperatureCheck() == true) {
//				objectNames.get(i).getTemperatureCel();
//			}
//		}
//	}
	
	
	//this should return the show inventory
	//you'll probably need to run a for loop and 
	//and the function below returns the object amount to use a '
	//for(int i = 0; i < [functionbelow]
	
	public String[] showInventory(int i) {
		Store store = Store.getInstance();
		objectNames = store.getInventoryNames();
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
		StoreItems storedItems = StoreItems.getInstance();
		Manifest initialManifest = new Manifest();
		objectNames = initialManifest.setInitialInvent(inventProp);
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
	//This function is used when the manage wants to restock the supermarket
	public void stockOrder() {
		//create instances of objects used later on
		StoreItems storeitems = StoreItems.getInstance();
		//Create the variables that will be used throughout this function
		LinkedHashMap<String, Integer> reorderAmounts = new LinkedHashMap<>();
		storeitems.setReorderAmounts(reorderAmounts);
		List<String> reorderNames = new ArrayList<>();
		List<Item> ObjectNames = new ArrayList<>();
		Manifest openManifest = new Manifest();
		ObjectNames = storeitems.getObjectNames(); 
		for(int y = 0; y < ObjectNames.size(); y++) {
			System.out.println("entering first for loop");
			System.out.println("No overflow yet" + ObjectNames.get(y).getName());
		}
		for(int i = 0; i < ObjectNames.size(); i++) {
			System.out.println("Entered for loop in stockOrder");
			if(ObjectNames.get(i).getQuantity() <= ObjectNames.get(i).getReorderPoint()) {
				System.out.println("Values were correct");
				reorderAmounts.put(ObjectNames.get(i).getName(), ObjectNames.get(i).getReorderAmount());
				System.out.println("\n" + "ReorderNames = " + ObjectNames.get(i).getName());
				reorderNames.add(ObjectNames.get(i).getName());
			}
		}
		System.out.println("Stock order reorderNames .size() " + reorderNames.size());
		storeitems.setReorderAmounts(reorderAmounts);
		storeitems.setReorderNames(reorderNames);
		for(int i = 0; i < reorderNames.size(); i++) {
			System.out.println("Reorder First Name is: " + reorderNames.get(i));
		}
		
		openManifest.stockOrder();
		List<Item> normalItems = new ArrayList<>();
		List<Item> rItems = new ArrayList<>();
		normalItems = storeitems.getNormalItems();
		rItems = storeitems.getrItems();
		double currentGreatestTemp = 0.0;
		for(int h = 0; h < rItems.size(); h++) {
			if(rItems.get(h).getTemperatureCel() > currentGreatestTemp) {
				currentGreatestTemp = rItems.get(h).getTemperatureCel();
			}
		}
		int oCargo = 0;
		for(int y = 0; y < normalItems.size(); y++) {
			oCargo = oCargo + normalItems.get(y).getQuantity();
		}
		
	}

	
	//this updates the store total
	//use this when reloading the manifest (delivered)
	public void manifestDelivered(File delManifest) {
		System.out.println("Entered Manifest Delivered");
		StoreItems storeitems = StoreItems.getInstance();
		Manifest deliverManifest = new Manifest();
		Store store = Store.getInstance();
		deliverManifest.openManifest(delManifest);
		LinkedHashMap<String, Integer> manifestValues = new LinkedHashMap<String, Integer>();
		List<Item> normalItems = new ArrayList<Item>();
		List<Item> rItems = new ArrayList<Item>();
		List<Item> objectNames = new ArrayList<Item>();
		List<String> reorderNames = new ArrayList<String>();
		objectNames = storeitems.getObjectNames();
		manifestValues = storeitems.getManifestValues();
		reorderNames = storeitems.getReordernames();
		rItems = storeitems.getrItems();
		normalItems = storeitems.getNormalItems();
		
		for(int i = 0; i < manifestValues.size(); i++) {
			System.out.println("Entered temp checker?!?!  and rItems.size" + rItems.size());
			for(int j = 0; j < objectNames.size(); j++) {
				if(objectNames.get(j).getName() == reorderNames.get(i)) {
					if(objectNames.get(i).getTemperatureCheck() == true) {
						rItems.add(objectNames.get(i));
					} else {
						normalItems.add(objectNames.get(i));
					}
				}
			}
		}//end for loop
		double highestTemp = 0.0;
		for(int a = 0; a < rItems.size(); a++) {
			if(rItems.get(a).getTemperatureCel() > highestTemp) {
				highestTemp = rItems.get(a).getTemperatureCel();
			}
		}//end for loop
		double cargoSize = 0;
		for(int s = 0; s < normalItems.size(); s++) {
			cargoSize = cargoSize + manifestValues.get(normalItems.get(s).getName());
		}//end for loop
		OrdinaryTruck ordTruck = new OrdinaryTruck();
		RefridgeratedTruck rTruck = new RefridgeratedTruck();
		double rCost = rTruck.truckCost(highestTemp);
		double oCost = ordTruck.truckCost(cargoSize);
		double capitalLoss = rCost + oCost;
		store.setCapital(capitalLoss);
		//update stock now for both refridgerated and ordinary
		//rItems first
		for(int i = 0; i < rItems.size(); i++) {
			String manifestKey = rItems.get(i).getName();
			rItems.get(i).setQuantityManifest(manifestValues.get(manifestKey));
		}
		for(int z = 0; z < normalItems.size(); z++) {
			System.out.println("Quantity before: " + normalItems.get(z).getQuantity());
			String manifestKey = normalItems.get(z).getName();
			normalItems.get(z).setQuantityManifest(manifestValues.get(manifestKey));
			System.out.println("Quantity After: " + normalItems.get(z).getQuantity());
		}
		
	}
	
	public void salesLog(File salesLog) {
		Manifests.Manifest work = new Manifests.Manifest();
		StoreItems store = StoreItems.getInstance();
		work.salesLog(salesLog);
		LinkedHashMap<String, Integer> salesValues = new LinkedHashMap<String, Integer>();
		List<String> salesObjectNames = new ArrayList<String>();
		List<Item> objectNames = new ArrayList<Item>();
		salesValues = store.getSalesValues();
		salesObjectNames = store.getSalesObjectNames();
		objectNames = store.getObjectNames();
		for(int j = 0; j < salesValues.size(); j++) {
			System.out.println("Sales name = " + salesObjectNames.get(j) + ", Quantity = " + salesValues.get(salesObjectNames.get(j)));
			
		}
		double capitalSum = 0;
		for(int i = 0; i < salesValues.size(); i++) {
			String tempHold = objectNames.get(i).getName();
			if(salesValues.containsKey(tempHold) == true) {
				objectNames.get(i).setQuantitySale(salesValues.get(salesObjectNames.get(i)));
				capitalSum = capitalSum + (objectNames.get(i).getCost() * objectNames.get(i).getQuantity());
				System.out.println("Actual Object Item ObjectName = " + objectNames.get(i).getName() + ", Quantity = " + objectNames.get(i).getQuantity());
			}
		}
		Store supermarket = Store.getInstance();
		supermarket.setCapitalProfit(capitalSum);
		
		
		
	}

	public double getCargoOrd() {
		return this.cargoTotalOrd;
	}

	private boolean tempChecker(int counter) {
		Manifest maniTemp = new Manifest();
		if(maniTemp.objectNames.get(counter).getTemperatureCheck() == true){
			return true;
		} else {
			return false;
		}
	}

}
