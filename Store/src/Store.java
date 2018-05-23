import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Store {

	//set private globals
	private Store firstInstance = null;
	private int storeCapital;
	private String name;


	private Store(String name, int Capital){
		this.name = name;
		this.storeCapital = storeCapital;
	}

	public Store getStore() {
		if(firstInstance == null) {
			firstInstance = new Store(name, storeCapital);
		}
		return firstInstance;
	}

	public int getStoreCapital() {
		return this.storeCapital;
	}

	public String getName() {
		return this.name;
	}

	public void getInventory(File manifest) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(manifest));
			String checkNull = reader.readLine();
			while((checkNull != null)) {
				List<String> inventValue = new ArrayList<String>();
				inventValue.add(reader.readLine());
				System.out.print(inventValue.get(0) + "=" +inventValue.get(1));
				if(checkNull != null) {
					System.out.print(", ");
				}
			}

		} catch(IOException e) {
			e.printStackTrace();
		}

	}

	public void setStoreInitialCapital(File manifest) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(manifest));
			double totalCost = 0;
			while((reader.readLine() != null)){
				List<String> tempHold = new ArrayList<String>();
				tempHold.add(reader.readLine());
				totalCost = Double.parseDouble(tempHold.get(1)) * Double.parseDouble(tempHold.get(4));
			}
			this.storeCapital -= totalCost;
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void setStoreSaleCapital(File saleManifest) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(saleManifest));
			double salesTotal = 0;
			int i = 0;
			while((reader.readLine() != null)){
				List<String> tempHold = new ArrayList<String>();
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
