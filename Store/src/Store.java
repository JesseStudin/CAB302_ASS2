import ParseAndWrite.ParseAWrite;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Store {

	//set private globals
	private Store firstInstance = null;
	private int storeCapital = 100000;
	private String name;
	private ParseAWrite parse = new ParseAWrite();


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

	public void setInventory(File inventProp) {
		double initialCost = parse.setInitialInvent(inventProp);
		this.storeCapital = this.storeCapital - (int)initialCost;
	}

	public int getCapital() {
		return this.storeCapital;
	}

	public void setCapital(int payment) {
		this.storeCapital = this.storeCapital + payment;
	}

}
