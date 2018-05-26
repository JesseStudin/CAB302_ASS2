package Manifests;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import Produce.Item;

public class StoreItems {
	
	private static StoreItems instance = new StoreItems();
	
	private StoreItems() {}
	
	public static StoreItems getInstance() {
		return instance;
	}
	
	private List<Item> objectNames = new ArrayList<Item>();
	private List<String> theNames = new ArrayList<String>();
	private LinkedHashMap<String, Integer> quantityValues = new LinkedHashMap<String, Integer>();
	
	public void setObjectNames(List<Item> objectNames) {
		this.objectNames = objectNames;
	}
	
	public void setTheNames(List<String> theNames) {
		this.theNames = theNames;
	}
	
	public void setQuantityValues(LinkedHashMap<String, Integer> quantityValues) {
		this.quantityValues = quantityValues;
	}
	
	public List<Item> getObjectNames() {
		return this.objectNames;
	}
	
	public List<String> getTheNames() {
		return this.theNames;
	}
	
	public LinkedHashMap<String, Integer> getQuantityValues() {
		return this.quantityValues;
	}
	
}
