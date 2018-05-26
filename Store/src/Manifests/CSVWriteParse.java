package Manifests;

import Produce.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CSVWriteParse extends Manifest{

	private boolean checkTemp(int i) {
		if(objectNames.get(i).getTemperatureCel() < -0.1 || objectNames.get(i).getTemperatureCel() > 0.0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void writeManifest(Map<String, Integer> reorderAmount) {
		try {
			PrintWriter newLineWriter = new PrintWriter(new FileWriter("src\\CSV's\\manifest.csv"));
			System.out.println("Created Manifest");
			//how about sorting the temp and normal into two different Lists
			List<Item> normalItems = new ArrayList<Item>();
			List<Item> rItems = new ArrayList<Item>();
			StoreItems storeItems = StoreItems.getInstance();
			objectNames = storeItems.getObjectNames();
			Map<String, Integer> stockAmount = reorderAmount;
			int counter = 0;
			//first sort them into lists
			for(int i = 0; i < stockAmount.size(); i++) {
				if (checkTemp(i) == true) {
					rItems.add(objectNames.get(i));
					counter++;
					System.out.println(counter);
				} else if (checkTemp(i) == false) {
					normalItems.add(objectNames.get(i));
					counter++;
					System.out.println(counter);
				}
			}
			//print first list!
			//ordinary Truck
			newLineWriter.print("Ordinary Truck\n");
			newLineWriter.flush();
			for (Item normalItem : normalItems) {
				newLineWriter.print(normalItem.getName());
				newLineWriter.flush();
				newLineWriter.print("," + normalItem.getReorderAmount() + "\n");
				newLineWriter.flush();
			}
			//Refridgerated Truck
			newLineWriter.print("Refridgerated Truck\n");
			newLineWriter.flush();
			for(int h = 0; h < rItems.size(); h++) {
				newLineWriter.print(rItems.get(h).getName());
				newLineWriter.flush();
				newLineWriter.print("," + rItems.get(h).getReorderAmount());
				newLineWriter.flush();
				newLineWriter.print("," + rItems.get(h).getTemperatureCel() + "\n");
				System.out.println(rItems.get(h).getTemperatureCel());

			}
			newLineWriter.flush();
			newLineWriter.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readSalesLog(File salesLog) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(salesLog));
			String readTheLine = "";
			StoreItems storedItems = StoreItems.getInstance();
			LinkedHashMap<String, Integer> salesValues = new LinkedHashMap<>(storedItems.getObjectNames().size());
			while((readTheLine = reader.readLine()) != null){
				String[] tempValues = readTheLine.split("[,]+");
				int tempInt = Integer.parseInt(tempValues[1]);
				salesValues.put(tempValues[0],  tempInt);
			}
			storedItems.setQuantityValues(salesValues);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}


	public void readManifest(File delManifest) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader((delManifest)));
			String readTheLine = "";
			while((readTheLine = reader.readLine()) != null) {
				String[] tempValues = readTheLine.split("[,]+");
				String objectNameTemp = tempValues[0];
				int tempInt = Integer.parseInt(tempValues[1]);
				manifestValues.put(tempValues[0], tempInt);
			}
			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}


}
