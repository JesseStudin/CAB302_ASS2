/*
 * Manifest.Java
 * 
 * Written by: Jesse Studin and Pierce Thompson.
 * 
 * This file handles the creation, loading and exporting of Manifests and Sales Logs.
 */
package Manifests;

import Produce.Item;
import SuperMarket.Store;

import java.io.*;
import java.util.*;

import ParseAndWrite.CSVWriteParse;

public class Manifest {
	CSVWriteParse reader = new CSVWriteParse();										//Create a new Instance of the CSVWriteParse Script to be used in this script.
	public List<Item> objectNames = new ArrayList<Item>();							//Create a new List of Items to be used.
	public StoreItems storedItems = StoreItems.getInstance();						//Create a new Instance of the StoreItems Script to be used.
	public LinkedHashMap<String, Integer> manifestValues = new LinkedHashMap<>();	//Create a new LinkedHashMap for the Manifest Values.
	public LinkedHashMap<String, Integer> salesValues = new LinkedHashMap<>();		//Create a new LinkedHashMap for the Sales Values.

	//Write the Stock Order Manifest to a file via the CSVWriteParse Script.
	public void stockOrder(){
		reader.writeManifest();
	}
	
	//Read a Sales Log Via the CSVWriteParse Script.
	public void salesLog(File salesLog) {
		reader.readSalesLog(salesLog);
	}
	
	//Read a Manifest Via the CSVWriteParse Script.
	public void openManifest(File delManifest) {
		reader.readManifest(delManifest);
		reader = null;
	}

	//This Function will parse the manifest and update the manifest hash accordingly
	public List<Item> setInitialInvent(File inventProp) {
		//set the initial inventory!!
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(inventProp));	//Create a new Reader to read the inventory properties file.
			String readTheLine = "";
			while((readTheLine = reader.readLine()) != null) {
				String[] tempValues = readTheLine.split("[,]+");		//Split the string at every comma in the file and put it into an array.
				String ObjectNameTemp = tempValues[0];
				if(tempValues.length - 1 == 4) {						//This if statement will be used if a temperature is not required for the currently parsed item.
					int tempIntA = Integer.parseInt(tempValues[4]);
					double tempDoubleB = Integer.parseInt(tempValues[1]);
					double tempDoubleC = Double.parseDouble(tempValues[2]);
					int tempReorderPoint = Integer.parseInt(tempValues[3]);
					int tempReorderAmount = Integer.parseInt(tempValues[4]);
					Item objectNameTemp = new Item(tempValues[0], 0, tempDoubleB, tempDoubleC, tempReorderPoint, tempReorderAmount);	//Create a new item with all the required information.
					objectNames.add(objectNameTemp);					//Add the objectnames to the array.
				} else if(tempValues.length - 1 == 5) {					//This if statement will be used if a temperature is required for the currently parsed item.
					int tempQuantity = Integer.parseInt(tempValues[4]);
					double tempDoubleA = Double.parseDouble(tempValues[1]);
					double tempDoubleB = Double.parseDouble(tempValues[2]);
					int tempReorderPoint = Integer.parseInt(tempValues[3]);
					int tempReorderAmount = Integer.parseInt(tempValues[4]);
					double tempTemperature = Double.parseDouble(tempValues[5]);
					Item objectNameTemp = new Item(tempValues[0], 0, tempDoubleA, tempDoubleB, tempReorderPoint, tempReorderAmount, tempTemperature);	//Create a new item with all the required information.
					objectNames.add(objectNameTemp);//Add the objectnames to the array.
				}
			}
			reader.close();												//Close the current reader.
			StoreItems itemStore = StoreItems.getInstance();			//Create an instance of the StoreItems Script.
			Store store = Store.getInstance();							//Create an instance of the Store Script.
			itemStore.setObjectNames(objectNames);						//Add the new items to the Item Store.
			store.setInventoryNames(objectNames);						//Add the new items to the Store.
			return objectNames;											//Return the list to the desired script.
		} catch(IOException e) {
			e.printStackTrace();										//Throw an exception if required.
		}
		return objectNames;
	}
}