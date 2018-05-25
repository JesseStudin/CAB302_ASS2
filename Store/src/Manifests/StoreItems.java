package Manifests;
import java.util.ArrayList;
import java.util.List;

import Produce.Item;

public class StoreItems {
	
	private static StoreItems instance = new StoreItems();
	
	private StoreItems() {}
	
	public static StoreItems getInstance() {
		return instance;
	}
	
	private List<Item> objectNames = new ArrayList<Item>();
	
	public void setObjectNames(List<Item> objectNames) {
		this.objectNames = objectNames;
	}
	
	public List<Item> getObjectNames() {
		return this.objectNames;
	}
	
}
