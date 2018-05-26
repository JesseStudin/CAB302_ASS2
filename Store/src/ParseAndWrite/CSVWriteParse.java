package ParseAndWrite;

import Produce.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Manifests.Manifest;
import Manifests.StoreItems;

public class CSVWriteParse {

	private boolean checkTemp(int i) {
		List<Item> objectNames = new ArrayList<Item>();
		StoreItems store = StoreItems.getInstance();
		objectNames = store.getObjectNames();
		if(objectNames.get(i).getTemperatureCel() < -0.1 || objectNames.get(i).getTemperatureCel() > 0.0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void writeManifest() {
		try {
			PrintWriter newLineWriter = new PrintWriter(new FileWriter("src\\CSV's\\manifest00.csv"));
			StoreItems storeitems = StoreItems.getInstance();
			List<Item> objectNames = new ArrayList<>();
			LinkedHashMap<String, Integer> reorderAmount = new LinkedHashMap<>();
			List<String> reorderNames = new ArrayList<>();
			objectNames = storeitems.getObjectNames();
			reorderAmount = storeitems.getReorderAmounts();
			reorderNames = storeitems.getReordernames();
			List<Item> reorderObjects = new ArrayList<Item>();
			List<Item> normalItems = new ArrayList<Item>();
			List<Item> rItems = new ArrayList<Item>();
			int counter = 0;
			for(int b = 0; b < reorderAmount.size(); b++) {
				for(int j = 0; j < objectNames.size(); j++) {
					if(objectNames.get(j).getName() == reorderNames.get(b)) {
						reorderObjects.add(objectNames.get(b));
						counter++;
					}
				}
			}
			System.out.println("ReorderObject Size = : " + reorderObjects.size());
			for(int i = 0; i < reorderObjects.size(); i++) {
				if (reorderObjects.get(i).getTemperatureCheck() == true) {
					rItems.add(reorderObjects.get(i));
					counter++;
					System.out.println(counter);
				} else if (reorderObjects.get(i).getTemperatureCheck() == false) {
					normalItems.add(reorderObjects.get(i));
					counter++;
					System.out.println(counter);
					}
				}
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
				storeitems.setNormalItems(normalItems);
				storeitems.setRItems(rItems);
				newLineWriter.flush();
				newLineWriter.close();
							
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readSalesLog(File salesLog) {
		System.out.println("Entered ReadSalesLog");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(salesLog));
			LinkedHashMap<String, Integer> salesValues = new LinkedHashMap<>();
			List<String> salesObjectNames = new ArrayList<String>();
			StoreItems store = StoreItems.getInstance();
			String readTheLine = "";
			while((readTheLine = reader.readLine()) != null) {
				String[] tempValues = readTheLine.split("[,]+");
				String objectNameTemp = tempValues[0];
				int tempInt = Integer.parseInt(tempValues[1]);
				salesValues.put(objectNameTemp, tempInt);
				salesObjectNames.add(objectNameTemp);
			}
			store.setSalesValues(salesValues);
			store.setSalesObjectNames(salesObjectNames);
			for(int i = 0; i < salesValues.size(); i++) {
				System.out.println("Sales ObjectNames = " + salesObjectNames.get(i) + " Sales Values = " + salesValues.get(salesObjectNames.get(i)));
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}


	public void readManifest(File delManifest) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader((delManifest)));
			LinkedHashMap<String, Integer> manifestValues = new LinkedHashMap<>();
			List<String> reorderNames = new ArrayList<>();
			StoreItems store = StoreItems.getInstance();
			String readTheLine = "";
			while((readTheLine = reader.readLine()) != null) {
				String[] tempValues = readTheLine.split("[,]+");
				String tempCheckHold = tempValues[0];
				System.out.println(tempCheckHold);
				if(readTheLine.contains("Ordinary Truck") || readTheLine.contains("Refridgerated Truck")) {
					System.out.println("This is true!");
					continue;
				}
				System.out.println(tempValues[0]);
				try {
					System.out.println(tempValues[1]);
				} catch (IndexOutOfBoundsException e) {
					System.err.println("Out of bounds here: " + e.getMessage());
					System.err.println((tempValues[0]));
				}
				String objectNameTemp = tempValues[0];
				int tempInt = Integer.parseInt(tempValues[1]);
				manifestValues.put(tempValues[0], tempInt);
				reorderNames.add(tempValues[0]);
			}
			store.setManifestValues(manifestValues);
			store.setReorderNames(reorderNames);
			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}


}