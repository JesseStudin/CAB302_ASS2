package Manifests;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import Produce.Item;

public class StoreItems {
	
	private static StoreItems storeitems = new StoreItems();
	
	private StoreItems() {}
	
	public static StoreItems getInstance() {
		return storeitems;
	}
	
	private List<Item> objectNames = new ArrayList<Item>();
	private List<String> theNames = new ArrayList<String>();
	private List<String> salesObjectNames = new ArrayList<String>();
	private List<String> reorderNames = new ArrayList<>();
	private LinkedHashMap<String, Integer> quantityValues = new LinkedHashMap<String, Integer>();
	private LinkedHashMap<String, Integer> manifestValues = new LinkedHashMap<String, Integer>();
	private LinkedHashMap<String, Integer> salesValues = new LinkedHashMap<String, Integer>();
	private LinkedHashMap<String, Integer> reorderAmounts = new LinkedHashMap<String, Integer>();
	private List<Item> normalItems = new ArrayList<Item>();
	private List<Item> rItems = new ArrayList<Item>();
	
	public void setNormalItems(List<Item> normalItems) {
		this.normalItems = normalItems;
	}
	
	public void setRItems(List<Item> rItems) {
		this.rItems = rItems;
	}
	
	public void setObjectNames(List<Item> objectNames) {
		this.objectNames = objectNames;
	}
	
	public void setReorderNames(List<String> reorderNames) {
		this.reorderNames = reorderNames;
	}
	
	public void setReorderAmounts(LinkedHashMap<String, Integer> reorderAmounts) {
		this.reorderAmounts = reorderAmounts;
	}
	
	public void setSalesObjectNames(List<String> salesObjectNames) {
		this.salesObjectNames = salesObjectNames;
	}
	
	public void setSalesValues(LinkedHashMap<String, Integer> salesValues) {
		this.salesValues = salesValues;
	}
	
	public void setManifestValues(LinkedHashMap<String, Integer> manifestValues) {
		this.manifestValues = manifestValues;
	}
	
	public void setTheNames(List<String> theNames) {
		this.theNames = theNames;
	}
	
	public void setQuantityValues(LinkedHashMap<String, Integer> quantityValues) {
		this.quantityValues = quantityValues;
	}
	
	public List<Item> getNormalItems() {
		return this.normalItems;
	}
	
	public List<Item> getrItems() {
		return this.rItems;
	}
	
	public List<String> getReordernames() {
		return this.reorderNames;
	}
	
	public LinkedHashMap<String, Integer> getReorderAmounts() {
		return this.reorderAmounts;
	}
	
	public List<String> getSalesObjectNames() {
		return this.salesObjectNames;
	}
	
	public LinkedHashMap<String, Integer> getManifestValues() {
		return this.manifestValues;
	}
	
	public LinkedHashMap<String, Integer> getSalesValues() {
		return this.salesValues;
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
