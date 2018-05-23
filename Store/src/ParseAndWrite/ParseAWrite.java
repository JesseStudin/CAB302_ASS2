package ParseAndWrite;
import Stock.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParseAWrite {

	public String[] objectNames;
	private int capitalInitialTotal;
	private int capitalSalesTotal;
	private int counter;

//called when create manifest is running
	public void writeInventoryValues(Item item, int counter) {
		try(FileWriter fw = new FileWriter("CSV's\\manifest.csv");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter manifestWriter = new PrintWriter(bw)) {
			if (counter == 0) {
				manifestWriter.print("Ordinary Truck");
			} else if(counter == 9) {
				manifestWriter.print("Refridgerated Truck");
			}
			manifestWriter.print(item.getProductName());
			manifestWriter.print(",");
			manifestWriter.print(item.getReorderAmount() + "\n");
			manifestWriter.close();
			manifestWriter.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void createManifest(String[] sortArray) {
		//we will create the variables by looping inside GUI and sending them through to this class!
		//This class will then sort set them into the "Item" class.!
		//this should work!!
		String setObjectName = sortArray[0];
		double[] setObjectDoubles = {};
		setObjectDoubles = new double[sortArray.length - 1];
		if(sortArray.length == 6) {
			for (int i = 0; i < sortArray.length - 1; i++) {
				double valueHold = Double.parseDouble(sortArray[i + 1]);
				setObjectDoubles[i] = valueHold;
				Item objectName = new Item(setObjectName, setObjectDoubles[0], setObjectDoubles[1], setObjectDoubles[2], setObjectDoubles[3], setObjectDoubles[4]);
				writeInventoryValues(objectName, counter);
			}
		} else if(sortArray.length == 5) {
			for (int i = 0; i < sortArray.length - 2; i++) {
				double valueHold = Double.parseDouble(sortArray[i + 1]);
				setObjectDoubles[i] = valueHold;
				Item objectName = new Item(setObjectName, setObjectDoubles[0], setObjectDoubles[1], setObjectDoubles[2], setObjectDoubles[3]);
				writeInventoryValues(objectName, counter);
			}
		}
		getObjectNames(setObjectName);
		counter++;
	}
	//this is useful so a for loop can print out objectNames and values for manifests later
	private void getObjectNames(String objectName) {
		if(objectNames.length == 0) {
			this.objectNames[0] = objectName;
		} else {
			this.objectNames[objectNames.length] = objectName;
		}
	}

	public int parseManifestSales(File manifest) {
		BufferedReader reader = null;
		capitalSalesTotal = 0;
		try {
			//Idea from Stack Overflow
			reader = new BufferedReader(new FileReader(manifest));
			String theLine;
			while((theLine = reader.readLine()) != null) {
				String[] tempHold = theLine.split("[,\\s]");
				if(tempHold[1] != null) {
					capitalSalesTotal = capitalSalesTotal + Integer.parseInt(tempHold[1]);
				}
			}
			return capitalSalesTotal;

		} catch(IOException e) {
			e.printStackTrace();
		}
		return capitalSalesTotal;
	}

	public int parseManifestInitialCapital(File manifest) {
		BufferedReader reader = null;
		try {
			capitalSalesTotal = 0;
			reader =  new BufferedReader(new FileReader(manifest));
			String theLine;
			while((theLine = reader.readLine()) != null){
				String[] tempHold = theLine.split("[,\\s]+");
				if(tempHold[1] != null) {
					capitalSalesTotal = capitalSalesTotal + Integer.parseInt(tempHold[1]);
				}
			}
			return capitalSalesTotal;
		} catch(IOException e){
			e.printStackTrace();
		}
		return capitalSalesTotal;
	}


}
