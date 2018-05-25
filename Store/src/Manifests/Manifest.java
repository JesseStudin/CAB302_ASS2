package Manifests;

import Produce.Item;

import java.io.*;
import java.util.*;

public class Manifest {

	public List<Item> objectNames = new ArrayList<Item>();
	public LinkedHashMap<String, Integer> manifestValues = new LinkedHashMap<>(objectNames.size());
	public LinkedHashMap<String, Integer> salesValues = new LinkedHashMap<>(objectNames.size());


	public List<Item> getItem() {
		return objectNames;
	}

	public void stockOrder(){
		CSVWriteParse writer = new CSVWriteParse();
		writer.writeManifest();
		writer = null;
	}
	
	public void salesLog(File salesLog) {
		CSVWriteParse writer = new CSVWriteParse();
		writer.salesLog(salesLog);
	}
	
	public List<Item> getObjectList() {
		return this.objectNames;
	}

	public LinkedHashMap<String, Integer> openManifest(File delManifest) {
		CSVWriteParse reader = new CSVWriteParse();
		reader.openManifest(delManifest);
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
					objectNames.add(counter, objectNameTemp);
					counter++;
				} else if(tempValues.length - 1 == 5) {
					int tempQuantity = Integer.parseInt(tempValues[4]);
					double tempDoubleA = Double.parseDouble(tempValues[1]);
					double tempDoubleB = Double.parseDouble(tempValues[2]);
					int tempReorderPoint = Integer.parseInt(tempValues[3]);
					int tempReorderAmount = Integer.parseInt(tempValues[4]);
					double tempTemperature = Double.parseDouble(tempValues[5]);
					Item objectNameTemp = new Item(tempValues[0], tempQuantity, tempDoubleA, tempDoubleB, tempReorderPoint, tempReorderAmount, tempTemperature);
					objectNames.add(counter, objectNameTemp);
					counter++;
				}
			}	
			reader.close();
			return objectNames;
		
		} catch(IOException e) {
			e.printStackTrace();
		}
		return objectNames;
		
	}

	//sales manifest
	public void salesManifest() {

	}

	public Item getItem(int counter) {
		return objectNames.get(counter);
	}


}
