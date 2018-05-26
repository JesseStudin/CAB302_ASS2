package Manifests;

import Produce.Item;

import java.io.*;
import java.util.*;

import ParseAndWrite.CSVWriteParse;

public class Manifest {
	CSVWriteParse reader = new CSVWriteParse();
	public List<Item> objectNames = new ArrayList<Item>();
	public StoreItems storedItems = StoreItems.getInstance();
	public LinkedHashMap<String, Integer> manifestValues = new LinkedHashMap<>();
	public LinkedHashMap<String, Integer> salesValues = new LinkedHashMap<>();


	public List<Item> getItem() {
		return objectNames;
	}

	public void stockOrder(){
		reader.writeManifest();
	}
	
	public void salesLog(File salesLog) {
		System.out.println("Entered Manifest");
		reader.readSalesLog(salesLog);
	}
	
	public List<Item> getObjectList() {
		return this.objectNames;
	}

	public void openManifest(File delManifest) {
		reader.readManifest(delManifest);
		reader = null;
		
	}

	public void updateStock(){

	}


	//this will parse the manifest and update the manifest hash accordingly


	public List<Item> setInitialInvent(File inventProp) {
		//set the initial inventory!!
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(inventProp));
			String readTheLine = "";
			int counter = 0;
			while((readTheLine = reader.readLine()) != null) {
				String[] tempValues = readTheLine.split("[,]+");
				String ObjectNameTemp = tempValues[0];
				if(tempValues.length - 1 == 4) {
					int tempIntA = Integer.parseInt(tempValues[4]);
					double tempDoubleB = Integer.parseInt(tempValues[1]);
					double tempDoubleC = Double.parseDouble(tempValues[2]);
					int tempReorderPoint = Integer.parseInt(tempValues[3]);
					int tempReorderAmount = Integer.parseInt(tempValues[4]);
					Item objectNameTemp = new Item(tempValues[0], tempIntA, tempDoubleB, tempDoubleC, tempReorderPoint, tempReorderAmount);
					objectNames.add(objectNameTemp);
					counter++;
				} else if(tempValues.length - 1 == 5) {
					int tempQuantity = Integer.parseInt(tempValues[4]);
					double tempDoubleA = Double.parseDouble(tempValues[1]);
					double tempDoubleB = Double.parseDouble(tempValues[2]);
					int tempReorderPoint = Integer.parseInt(tempValues[3]);
					int tempReorderAmount = Integer.parseInt(tempValues[4]);
					double tempTemperature = Double.parseDouble(tempValues[5]);
					Item objectNameTemp = new Item(tempValues[0], tempQuantity, tempDoubleA, tempDoubleB, tempReorderPoint, tempReorderAmount, tempTemperature);
					objectNames.add(objectNameTemp);
					counter++;
				}
			}
			reader.close();
			StoreItems itemStore = StoreItems.getInstance();
			itemStore.setObjectNames(objectNames);
			return objectNames;
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Shouldn't be here");
		return objectNames;
		
	}

	//sales manifest
	public void salesManifest() {

	}

	public Item getItem(int counter) {
		return objectNames.get(counter);
	}


}
