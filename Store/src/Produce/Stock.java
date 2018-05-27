/**
 * @author Jesse Studin
 * @version 1.0
 * 
 */

/*
 * Stock.Java
 * 
 * Written by: Jesse Studin and Pierce Thompson.
 * 
 * This file handles the stock based functions, including generating an inventory for the front end, stock ordering and manifest delivering.
 */
package Produce;

import Manifests.Manifest;
import Manifests.StoreItems;
import SuperMarket.Store;
import Trucks.OrdinaryTruck;
import Trucks.RefridgeratedTruck;

import java.io.File;
import java.util.*;

public class Stock {


	private List<Item> objectNames = new ArrayList<Item>();													//Create a new ArrayList for the objectNames.

	//this should return the show inventory
	//you'll probably need to run a for loop and 
	//and the function below returns the object amount to use a '
	//for(int i = 0; i < [functionbelow]
	
	//This Function is called from the frontend to fill the table with information.
	/**
	 * This function shows the latest inventory found by using the parameter 
	 * argument int i. This is passed through from the GUI "SuperMarket" class
	 * and returns a String[] Array
	 * @param i int i to pick which object
	 * @return String[] String[] Array returned
	 */
	public String[] showInventory(int i) {
		//Define Variables to be used.
		
		Store store = Store.getInstance();																	//Get an instance of Store.
		objectNames = store.getInventoryNames();															//Ensure the objectNames are consistent.
		String[] holdValues = new String[objectNames.size()];												//Create a new String Array to hold the values used below.
		
		holdValues[0] = objectNames.get(i).getName();
		holdValues[1] = Integer.toString(objectNames.get(i).getQuantity());
		holdValues[2] = Double.toString(objectNames.get(i).getCost());
		holdValues[3] = Double.toString(objectNames.get(i).getsellPrice());
		holdValues[4] = Integer.toString(objectNames.get(i).getReorderPoint());
		holdValues[5] = Integer.toString(objectNames.get(i).getReorderAmount());
		
		//Does the current item / value require a certain temperature?
		if(objectNames.get(i).getTemperatureCheck() == false) {
			holdValues[6] = Double.toString(0.0);															//If not set to 0.0.
		} else {
			holdValues[6] = Double.toString(objectNames.get(i).getTemperatureCel());						//If it does then set it to the required temperature.
		}
		return holdValues;																					//Return the value requested.
	}
	//use this to create all the objects! i is the 
	//current for loop counter in gui 
	
	//This Function is used to retrieve the required amount of objects.
	/**
	 * This returns the current inventory total (size()). This is used
	 * In the GUI to sort through the ShowInventory(int counter) function
	 * @return objectNameSize.size() returns the current inventory size
	 */
	public int getObjectAmount() {
		
		List<Item> objectNamesSize = new ArrayList<Item>();													//Create a new ArrayList for the Items.
		Store store = Store.getInstance();																	//Get an instance of the Store Script.
		objectNamesSize = store.getInventoryNames();														//Ensure Consistancy.
		return objectNamesSize.size();																		//Return the requested value.
	}
	
	//use this to initiliase
	
	//This Function is used to initialize a file that is parsed.
	/**
	 * This function is fed the inventProp and is used to 
	 * initialise the supermarket with its items set to the
	 * quantity values of 0.
	 * @param inventProp used to create the objects
	 */
	public void initialise(File inventProp) {
		
		StoreItems storedItems = StoreItems.getInstance();													//Create an instance of StoreItems.
		Manifest initialManifest = new Manifest();															//Create a new Manifest.
		objectNames = initialManifest.setInitialInvent(inventProp);											//Set the initialInventory of the manifest.
		storedItems.setObjectNames(objectNames);															//Set the stored items object names.																	//Set the Current Capital.
	}

	//This function is used when the manage wants to restock the supermarket
	/**
	 * This creates a stockorder, the stockorder is where the current amounts of stock need to be
	 * reorderd determined by if the quantity is less than currently set reorderPoints.
	 */
	public void stockOrder() {
		
		//create instances of objects used later on
		StoreItems storeitems = StoreItems.getInstance();													//Create an instance of StoreItems.
		Store store = Store.getInstance();					
		//Get an instance of Store.
		//Create the variables that will be used throughout this function
		LinkedHashMap<String, Integer> reorderAmounts = new LinkedHashMap<>();								//Create a new LinkedHashMap for the reorderAmounts.
		LinkedHashMap<String, Integer> tempreorderAmounts = new LinkedHashMap<>();							//Create a new LinkedHashMap for the temporary reorderAmounts.
		storeitems.setReorderAmounts(reorderAmounts);														
		tempreorderAmounts = storeitems.getReorderAmounts();												//Set the temporary reorderAmounts to the required re-order amounts.
		List<String> reorderNames = new ArrayList<>();														//Create a new ArrayList for reorderNames.
		List<Item> ObjectNames = new ArrayList<>();															//Create a new ArrayList for ObjectNames.
		Manifest openManifest = new Manifest();																//Create a new Manifest called openManifest.
		ObjectNames = store.getInventoryNames();															//Set the Object Names.
//		for(int y = 0; y < ObjectNames.size(); y++) {
//			System.out.println("entering first for loop");
//			System.out.println("No overflow yet" + ObjectNames.get(y).getName());
//		}
		//The Stock Order Loop.
		for(int i = 0; i < ObjectNames.size(); i++) {
//			System.out.println("Entered for loop in stockOrder");
			if(ObjectNames.get(i).getQuantity() <= ObjectNames.get(i).getReorderPoint()) {
//				System.out.println("Values were correct");
				reorderAmounts.put(ObjectNames.get(i).getName(), ObjectNames.get(i).getReorderAmount());
//				System.out.println("\n" + "ReorderNames = " + ObjectNames.get(i).getName());
				reorderNames.add(ObjectNames.get(i).getName());
			}
		}
//		System.out.println("Stock order reorderNames .size() " + reorderNames.size());
		storeitems.setReorderAmounts(reorderAmounts);														//Set the final ReorderAmounts.
		storeitems.setReorderNames(reorderNames);															//Set the Final ReorderNames.
//		for(int i = 0; i < reorderNames.size(); i++) {
//			System.out.println("Reorder First Name is: " + reorderNames.get(i));
//		}
		openManifest.stockOrder();																			//Call the Stock Order Function.
	}
	
	//This Function is used then reloading / loading the manifest, and updates the store total.
	/**
	 * The Created Manifest is selected by user in the GUI
	 * and is used as a parameter to use openManifest(file) in 
	 * Manifest.Manifest. After this takes the stored Parameters
	 * in the instanced class StoreItems.java and uses them to find
	 * the costs to the company for the manifest delivery
	 * @param delManifest Loading the Created Manifest
	 */
	public void manifestDelivered(File delManifest) {
		
//		System.out.println("Entered Manifest Delivered");
		
		//create instances of objects used later on
		StoreItems storeitems = StoreItems.getInstance();													//Create an instance of StoreItems.
		Manifest deliverManifest = new Manifest();															//Create a new Manifest.
		Store store = Store.getInstance();																	//Create an Instance of Store.
		
		//Create the variables that will be used throughout this function
		deliverManifest.openManifest(delManifest);															//Open the Parsed Manifest.
		LinkedHashMap<String, Integer> manifestValues = new LinkedHashMap<String, Integer>();				//Create a new LinkedHashMap for manifestValues.
		
		//Create Multiple new Lists of Items.
		List<Item> normalItems = new ArrayList<Item>();
		List<Item> rItems = new ArrayList<Item>();
		List<Item> objectNames = new ArrayList<Item>();
		List<String> reorderNames = new ArrayList<String>();
		
		//Set the Above defined variables.
		objectNames = store.getInventoryNames();
		manifestValues = storeitems.getManifestValues();
		reorderNames = storeitems.getReordernames();
		rItems = storeitems.getrItems();
		normalItems = storeitems.getNormalItems();
		
		//Check Names and Items.
		for(int i = 0; i < manifestValues.size(); i++) {
//			System.out.println("Entered temp checker?!?!  and rItems.size" + rItems.size());
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
		
		//Check Temperature Values.
		for(int a = 0; a < rItems.size(); a++) {
			if(rItems.get(a).getTemperatureCel() < highestTemp) {
				highestTemp = rItems.get(a).getTemperatureCel();
			}
		}//end for loop
		
		double cargoSize = 0;
		
		//Check Cargosize.
		for(int s = 0; s < normalItems.size(); s++) {
			cargoSize = cargoSize + manifestValues.get(normalItems.get(s).getName());
		}//end for loop
		
		OrdinaryTruck ordTruck = new OrdinaryTruck();															//Create a new Ordinary Truck.
		RefridgeratedTruck rTruck = new RefridgeratedTruck();													//Create a new Refridgerated Truck.
		
		//System.out.println("Cargo Size = " + cargoSize);
		//System.out.println("HighestTemperature" + highestTemp);
		
		//Define Multiple Variables to be used.
		double rCost = rTruck.truckCost(highestTemp);
		double oCost = ordTruck.truckCost(cargoSize);
		double capitalLoss = rCost + oCost;
		
		//get the manufacturing costs!
		//First Normal Items
		double manuCostSum = 0;
		for(int f = 0; f < normalItems.size(); f++) {
			manuCostSum = manuCostSum + (normalItems.get(f).getCost() * manifestValues.get(normalItems.get(f).getName()));
		}
		//same for rItems
		for(int d = 0; d < rItems.size(); d++) {
			manuCostSum = manuCostSum + (rItems.get(d).getCost() * manifestValues.get(rItems.get(d).getName()));
		}
		
		double totalLoss = capitalLoss + manuCostSum;
		System.out.println("Capital Loss = " + totalLoss);
		store.setCapital(totalLoss);																			//Store the capital.
		
		//update stock now for both refridgerated and ordinary
		//rItems first
		for(int i = 0; i < rItems.size(); i++) {
			String manifestKey = rItems.get(i).getName();
			rItems.get(i).setQuantityManifest(manifestValues.get(manifestKey));
		}
		
		for(int z = 0; z < normalItems.size(); z++) {
			String manifestKey = normalItems.get(z).getName();
			normalItems.get(z).setQuantityManifest(manifestValues.get(manifestKey));
			System.out.println("Quantity After: " + normalItems.get(z).getQuantity());
		}
		
	}
	
	//This Function Handles the SalesLog workings.
	/**
	 * This is used to read the saleslog.csv's. The .csv is passed 
	 * as an argumnent which is fed through to manifest then CSVParse 
	 * respectively. After the values stored from other classes
	 * are used to find the total profit the company made over the sales period.
	 * @param salesLog The SalesLog.csv to read
	 */
	public void salesLog(File salesLog) {
		
		//Create Instances and New Manifests.
		Manifests.Manifest work = new Manifests.Manifest();
		StoreItems store = StoreItems.getInstance();
		
		work.salesLog(salesLog);																					//Set a Sales Log.
		
		//Create Variables Required for this Function.
		LinkedHashMap<String, Integer> salesValues = new LinkedHashMap<String, Integer>();
		List<String> salesObjectNames = new ArrayList<String>();
		List<Item> objectNames = new ArrayList<Item>();
		
		//Set the Variables.
		salesValues = store.getSalesValues();
		salesObjectNames = store.getSalesObjectNames();
		objectNames = store.getObjectNames();
		/*
		for(int j = 0; j < salesValues.size(); j++) {
			System.out.println("Sales name = " + salesObjectNames.get(j) + ", Quantity = " + salesValues.get(salesObjectNames.get(j)));
			
		}
		*/
		double capitalSum = 0;
		
		//Set the Quantity, salesValues, ObjectNames and CapitalSum.
		for(int i = 0; i < salesValues.size(); i++) {
			String tempHold = objectNames.get(i).getName();
			if(salesValues.containsKey(tempHold) == true) {
				objectNames.get(i).setQuantitySale(salesValues.get(salesObjectNames.get(i)));
				capitalSum = capitalSum + (objectNames.get(i).getsellPrice() * salesValues.get(objectNames.get(i).getName()));
				//System.out.println("Actual Object Item ObjectName = " + objectNames.get(i).getName() + ", Quantity = " + salesValues.get(objectNames.get(i).getName() + " Cost = " + objectNames.get(i).getsellPrice()));
			}
		}
		
		Store supermarket = Store.getInstance();																	//Create an Instance of the Store Script.
		supermarket.setCapitalProfit(capitalSum);																	//Set the Capital Profit.

	}
}