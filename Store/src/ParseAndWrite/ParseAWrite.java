package ParseAndWrite;
import Stock.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParseAWrite {

	private List<Item> objectNames = new ArrayList<Item>();
	private int capitalInitialTotal;
	private int capitalSalesTotal;
	private int counter;


	private boolean checkTemp(int i) {
		if(objectNames.get(i).getTemperatureCel() < -0.1 || objectNames.get(i).getTemperatureCel() > 0.0) {
			return true;
		} else {
			return false;
		}
	}

	private void writeManifest() {
		try {
			PrintWriter newLineWriter = new PrintWriter(new FileWriter("manifest.csv"));
			//how about sorting the temp and normal into two different Lists
			List<Item> normalItems = new ArrayList<Item>();
			List<Item> rItems = new ArrayList<Item>();
			int counter = 0;
			//first sort them into lists
			for(int i = 0; i < objectNames.size(); i++) {
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
			for(int j = 0; j < normalItems.size(); j++) {
				newLineWriter.print(normalItems.get(j).getProductName());
				newLineWriter.flush();
				newLineWriter.print("," + normalItems.get(j).getReorderAmount() + "\n");
				newLineWriter.flush();
			}
			//Refridgerated Truck
			newLineWriter.println("Refridgerated Truck\n");
			newLineWriter.flush();
			for(int h = 0; h < rItems.size(); h++) {
				newLineWriter.print(rItems.get(h).getProductName());
				newLineWriter.flush();
				newLineWriter.print("," + rItems.get(h).getReorderAmount());
				newLineWriter.flush();
				newLineWriter.print("," + rItems.get(h).getTemperatureCel() + "\n");
				System.out.println(rItems.get(h).getTemperatureCel());
			}

		} catch(IOException e) {
			e.printStackTrace();
		}

	}

	public void setInitialInvent(File inventProp) {
		//set the initial inventory!!
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("CSV's\\manifest.csv"));
			String readTheLine = "";
			while((readTheLine = reader.readLine()) != null) {
				String[] tempValues = readTheLine.split("[,]+");
				String ObjectNameTemp = tempValues[0];
				if(tempValues.length - 1 == 4) {
					double tempDoubleA = Double.parseDouble(tempValues[1]);
					double tempDoubleB = Double.parseDouble(tempValues[2]);
					double tempDoubleC = Double.parseDouble(tempValues[3]);
					double tempDoubleD = Double.parseDouble(tempValues[4]);
					Item objectNameTemp = new Item(tempValues[0], tempDoubleA, tempDoubleB, tempDoubleC, tempDoubleD);
					objectNames.add(objectNameTemp);
				} else if(tempValues.length - 1 == 5) {
					double tempDoubleA = Double.parseDouble(tempValues[1]);
					double tempDoubleB = Double.parseDouble(tempValues[2]);
					double tempDoubleC = Double.parseDouble(tempValues[3]);
					double tempDoubleD = Double.parseDouble(tempValues[4]);
					double tempDoubleE = Double.parseDouble(tempValues[5]);
					Item objectNameTemp = new Item(tempValues[0], tempDoubleA, tempDoubleB, tempDoubleC, tempDoubleD, tempDoubleE);
					objectNames.add(objectNameTemp);
				}
			}

		} catch(IOException e) {
			e.printStackTrace();
		}


	}

}
