package com.JesseStudin.Manifests;

import com.JesseStudin.Produce.Item;

import java.io.*;
import java.util.*;

public class Manifest {

	public List<Item> objectNames = new ArrayList<Item>();
	public LinkedHashMap<String, Integer> manifestValues = new LinkedHashMap<>(objectNames.size());


	public List<Item> getItem() {
		return objectNames;
	}

	public void stockOrder(){
		CSVWriteParse writer = new CSVWriteParse();
		writer.writeManifest();
		writer = null;
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


	public double setInitialInvent(File inventProp) {
		//set the initial inventory!!
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(inventProp));
			String readTheLine = "";
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
				} else if(tempValues.length - 1 == 5) {
					int tempQuantity = Integer.parseInt(tempValues[4]);
					double tempDoubleA = Double.parseDouble(tempValues[1]);
					double tempDoubleB = Double.parseDouble(tempValues[2]);
					int tempReorderPoint = Integer.parseInt(tempValues[3]);
					int tempReorderAmount = Integer.parseInt(tempValues[4]);
					double tempTemperature = Double.parseDouble(tempValues[5]);
					Item objectNameTemp = new Item(tempValues[0], tempQuantity, tempDoubleA, tempDoubleB, tempReorderPoint, tempReorderAmount, tempTemperature);
					objectNames.add(objectNameTemp);
				}
			}
			int total =  0;
			for(int i = 0; i < objectNames.size(); i++) {
				total = total + (int)((int)objectNames.get(i).getCost() * (int)objectNames.get(i).getReorderAmount());
			}
			return (int)total;

		} catch(IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	//sales manifest
	public void salesManifest() {

	}

	public Item getItem(int counter) {
		return objectNames.get(counter);
	}


}
