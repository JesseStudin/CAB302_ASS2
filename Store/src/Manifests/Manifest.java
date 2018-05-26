package Manifests;

import Produce.Item;

import java.io.*;
import java.util.*;

public class Manifest {

	public List<Item> objectNames = new ArrayList<Item>();
	private StoreItems storedItems = StoreItems.getInstance();
	public LinkedHashMap<String, Integer> manifestValues = new LinkedHashMap<>(storedItems.getObjectNames().size());
	public List<String> salesNames = new ArrayList<String>();


	public List<Item> getItem() {
		return objectNames;
	}

	public void stockOrder(Map<String, Integer> reorderAmount){
		CSVWriteParse writer = new CSVWriteParse();
		writer.writeManifest(reorderAmount);
		writer = null;
	}
	
	public void salesLog(File salesLog) {
		CSVWriteParse writer = new CSVWriteParse();
		writer.salesLog(salesLog);
		writer = null;
	}
	
	public List<Item> getObjectList() {
		return this.objectNames;
	}

	public LinkedHashMap<String, Integer> openManifest(File delManifest) {
		CSVWriteParse reader = new CSVWriteParse();
		reader.openManifest(delManifest);
		for(int i = 0; i < manifestValues.size(); i++) {
			System.out.println(manifestValues.get(i));
		}
		reader = null;
		return manifestValues;
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
