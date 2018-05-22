package Stock;
import java.io.*;

public class inventoryLoad {

	public String[] objectNames;
	private int totalCapitalCost;
	private int counter;

	public void setInitialValues(String[] sortArray) {
		//we will create the variables by looping inside GUI and sending them through to this class!
		//This class will then sort set them into the "ProgramStock" class.!
		String setObjectName = sortArray[0];
		double[] setObjectDoubles = {};
		setObjectDoubles = new double[sortArray.length - 1];
		if(sortArray.length == 6) {
			for (int i = 0; i < sortArray.length - 1; i++) {
				double valueHold = Double.parseDouble(sortArray[i + 1]);
				setObjectDoubles[i] = valueHold;
			}
		} else if(sortArray.length == 5) {
			for (int i = 0; i < sortArray.length - 2; i++) {
				double valueHold = Double.parseDouble(sortArray[i + 1]);
				setObjectDoubles[i] = valueHold;
			}
		}
		if(sortArray.length == 6) {
			ProgramStock objectName = new ProgramStock(setObjectName, setObjectDoubles[0], setObjectDoubles[1], setObjectDoubles[2], setObjectDoubles[3], setObjectDoubles[4]);
			produceManifests(objectName, counter);
		} else {
			ProgramStock objectName = new ProgramStock(setObjectName, setObjectDoubles[0], setObjectDoubles[1], setObjectDoubles[2], setObjectDoubles[3]);
			produceManifests(objectName, counter);
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

	public void produceManifests(ProgramStock object, int truckCounter) {
		try(FileWriter fw = new FileWriter("CSV's\\manifest.csv");
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw)) {
			if(counter == 9) {
				out.println("Refrigerated Truck");
			} else if (counter == 0) {
				out.println("Ordinary Truck");
			}
			out.print(object.getProductName() + ",");
			out.print(object.getReorderAmount() + "\n");
			setTotalCapitalCost(object);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//set this variables TotalCapitalCost to deduct from above
	private void setTotalCapitalCost(ProgramStock stockObject) {
		this.totalCapitalCost = this.totalCapitalCost + (int)stockObject.getManufacterCost();
	}

}
