/**
 * @author Jesse Studin, Pierce Thompson
 */

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
	/**
	 * Returns an instance of the StoreItems class
	 * @return storeitems The Created Instance
	 */
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
	/** 
	 * Sets the normalItems variable (normalItems is a List Item)
	 * @param normalItems used to set the normalItems variable
	 */
	public void setNormalItems(List<Item> normalItems) {
		this.normalItems = normalItems;
	}
	
	//This Function sets the RItems.
	/**
	 * Used to set the rItems variable according to parameter argument
	 * @param rItems the value to set rItems to
	 */
	public void setRItems(List<Item> rItems) {
		this.rItems = rItems;
	}
	
	//This Function sets the ObjectNames.
	/**
	 * Used to set the objectName, alternative to using Inventory in Store
	 * @param objectNames Sets the objectNames 
	 */
	public void setObjectNames(List<Item> objectNames) {
		this.objectNames = objectNames;
	}
	
	//This Function sets the ReorderNames.
	/**
	 * Sets reorderName variables as List String. 
	 * @param reorderNames sets the List String reordernames values
	 */
	public void setReorderNames(List<String> reorderNames) {
		this.reorderNames = reorderNames;
	}
	
	//This Function sets the ReorderAmounts.
	/**
	 * Sets reorderAmounts according to LinkedHashMap String, Integer parameter argument
	 * @param reorderAmounts sets reorderAmounts value
	 */
	public void setReorderAmounts(LinkedHashMap<String, Integer> reorderAmounts) {
		this.reorderAmounts = reorderAmounts;
	}
	
	//This Function sets the SalesObjectNames.
	/**
	 * Sets salesObjectNames value according to parameter argument
	 * @param salesObjectNames Sets salesObjectNames value according to parameter value
	 */
	public void setSalesObjectNames(List<String> salesObjectNames) {
		this.salesObjectNames = salesObjectNames;
	}
	
	//This Function sets the SalesValues.
	/**
	 * set salesValue according to parameter argument
	 * @param salesValues salesValues is set according to param argument
	 */
	public void setSalesValues(LinkedHashMap<String, Integer> salesValues) {
		this.salesValues = salesValues;
	}
	
	//This Function sets the ManifestValues.
	/**
	 * sets ManifestValues according to Param Argument
	 * @param manifestValues sets the manifestValues
	 */
	public void setManifestValues(LinkedHashMap<String, Integer> manifestValues) {
		this.manifestValues = manifestValues;
	}
	
	//This Function sets the Names.
	/**
	 * sets theNames value according to param argument
	 * @param theNames sets value according to param argument
	 */
	public void setTheNames(List<String> theNames) {
		this.theNames = theNames;
	}
	
	//This Function sets the QuantityValues.
	/**
	 * sets quantity values according to param Argument
	 * @param quantityValues sets quantityValues according to param argument
	 */
	public void setQuantityValues(LinkedHashMap<String, Integer> quantityValues) {
		this.quantityValues = quantityValues;
	}
	
	//This Function gets the NormalItems.
	/**
	 * gets the current normalItems value
	 * @return normalItems List Item normalItems currently stored
	 */
	public List<Item> getNormalItems() {
		return this.normalItems;
	}
	
	//This Function gets the RItems.
	/**
	 * Returns the current rItems values stored
	 * @return rItems List Item rItems currently stored
	 */
	public List<Item> getrItems() {
		return this.rItems;
	}
	
	//This Function gets the ReorderNames.
	/**
	 * Returns the current reorderNames stored
	 * @return reorderNames List String reorderNames returned
	 */
	public List<String> getReordernames() {
		return this.reorderNames;
	}
	
	//This Function gets the ReorderAmounts.
	/**
	 * Returns curent reorderAmounts stored
	 * @return reorderAmounts LinkedHashMap String, Integer  reorderAmounts currently stored
	 */
	public LinkedHashMap<String, Integer> getReorderAmounts() {
		return this.reorderAmounts;
	}
	
	//This Function gets the SalesObjectNames.
	/**
	 * returns current salesObjectNames
	 * @return salesObjectNames List String salesObjectNames currently stored
	 */
	public List<String> getSalesObjectNames() {
		return this.salesObjectNames;
	}
	
	//This Functions gets the ManifestValues.
	/**
	 * returns current manifestValues stored
	 * @return manifestValues LinkedHashMap String, Integer manifestValues stored
	 */
	public LinkedHashMap<String, Integer> getManifestValues() {
		return this.manifestValues;
	}
	
	//This Function gets the SalesValues.
	/**
	 * returns current salesValues
	 * @return salesValues LinkedHashMap String, Integer salesValues currently stored
	 */
	public LinkedHashMap<String, Integer> getSalesValues() {
		return this.salesValues;
	}
	
	//This Function gets the ObjectNames.
	/**
	 * returns current ObjectNames (Alternative to inventory names in store.java) (Useful for multiple objectName storage)
	 * @return objectNames List Item objectNames currently stored
	 */
	public List<Item> getObjectNames() {
		return this.objectNames;
	}
	
	//This Function gets the Names.
	/**
	 * Returns the theNames value
	 * @return theNames List String theNames currently stored
	 */
	public List<String> getTheNames() {
		return this.theNames;
	}
	
	//This Function gets the QuantityValues.
	/**
	 * Returns current quantityValues values
	 * @return quantityValues LinkedHashMap String, Integer quantityValues currently stored
	 */
	public LinkedHashMap<String, Integer> getQuantityValues() {
		return this.quantityValues;
	}
}
