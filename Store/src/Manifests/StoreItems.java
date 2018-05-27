/*
 * StoreItems.Java
 * 
 * Written by: Jesse Studin and Pierce Thompson.
 * 
 * This file is used to store all the created items in one convenient place to be used throughout the program.
 */
package Manifests;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import Produce.Item;

public class StoreItems {
	
	private static StoreItems storeitems = new StoreItems();	//Create a new static instance of this script.
	
	private StoreItems() {}
	
	//This Function is used to get the instance of this script.
	public static StoreItems getInstance() {
		return storeitems;
	}
	
	private List<Item> objectNames = new ArrayList<Item>();											//This Array stores the created Items.
	private List<String> theNames = new ArrayList<String>();										//This Array stores names of the created Items.
	private List<String> salesObjectNames = new ArrayList<String>();								//This Array stores the sales object Names.
	private List<String> reorderNames = new ArrayList<>();											//This Array stores the reorder Names.
	private LinkedHashMap<String, Integer> quantityValues = new LinkedHashMap<String, Integer>();	//This HashMap stores the quantity values for Items.
	private LinkedHashMap<String, Integer> manifestValues = new LinkedHashMap<String, Integer>();	//This HashMap stores the manifest values for Items.
	private LinkedHashMap<String, Integer> salesValues = new LinkedHashMap<String, Integer>();		//This HashMap stores the sales values for Items.
	private LinkedHashMap<String, Integer> reorderAmounts = new LinkedHashMap<String, Integer>();	//This HashMap stores the re-order amount for items.
	private List<Item> normalItems = new ArrayList<Item>();											//This List stores an ArrayList of Items.
	private List<Item> rItems = new ArrayList<Item>();												//This List stores an ArrayList of Items.
	
	//This Function sets the normalItems.
	public void setNormalItems(List<Item> normalItems) {
		this.normalItems = normalItems;
	}
	
	//This Function sets the RItems.
	public void setRItems(List<Item> rItems) {
		this.rItems = rItems;
	}
	
	//This Function sets the ObjectNames.
	public void setObjectNames(List<Item> objectNames) {
		this.objectNames = objectNames;
	}
	
	//This Function sets the ReorderNames.
	public void setReorderNames(List<String> reorderNames) {
		this.reorderNames = reorderNames;
	}
	
	//This Function sets the ReorderAmounts.
	public void setReorderAmounts(LinkedHashMap<String, Integer> reorderAmounts) {
		this.reorderAmounts = reorderAmounts;
	}
	
	//This Function sets the SalesObjectNames.
	public void setSalesObjectNames(List<String> salesObjectNames) {
		this.salesObjectNames = salesObjectNames;
	}
	
	//This Function sets the SalesValues.
	public void setSalesValues(LinkedHashMap<String, Integer> salesValues) {
		this.salesValues = salesValues;
	}
	
	//This Function sets the ManifestValues.
	public void setManifestValues(LinkedHashMap<String, Integer> manifestValues) {
		this.manifestValues = manifestValues;
	}
	
	//This Function sets the Names.
	public void setTheNames(List<String> theNames) {
		this.theNames = theNames;
	}
	
	//This Function sets the QuantityValues.
	public void setQuantityValues(LinkedHashMap<String, Integer> quantityValues) {
		this.quantityValues = quantityValues;
	}
	
	//This Function gets the NormalItems.
	public List<Item> getNormalItems() {
		return this.normalItems;
	}
	
	//This Function gets the RItems.
	public List<Item> getrItems() {
		return this.rItems;
	}
	
	//This Function gets the ReorderNames.
	public List<String> getReordernames() {
		return this.reorderNames;
	}
	
	//This Function gets the ReorderAmounts.
	public LinkedHashMap<String, Integer> getReorderAmounts() {
		return this.reorderAmounts;
	}
	
	//This Function gets the SalesObjectNames.
	public List<String> getSalesObjectNames() {
		return this.salesObjectNames;
	}
	
	//This Functions gets the ManifestValues.
	public LinkedHashMap<String, Integer> getManifestValues() {
		return this.manifestValues;
	}
	
	//This Function gets the SalesValues.
	public LinkedHashMap<String, Integer> getSalesValues() {
		return this.salesValues;
	}
	
	//This Function gets the ObjectNames.
	public List<Item> getObjectNames() {
		return this.objectNames;
	}
	
	//This Function gets the Names.
	public List<String> getTheNames() {
		return this.theNames;
	}
	
	//This Function gets the QuantityValues.
	public LinkedHashMap<String, Integer> getQuantityValues() {
		return this.quantityValues;
	}
}
