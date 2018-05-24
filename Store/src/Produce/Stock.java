package com.JesseStudin.Produce;

import com.JesseStudin.Manifests.Manifest;
import com.JesseStudin.SuperMarket.Store;
import com.JesseStudin.Trucks.OrdinaryTruck;

import java.io.File;
import java.util.*;

public class Stock {

	private List<Item> item = new ArrayList<Item>();
	//reset this list every now and again
	private LinkedHashMap<String, Integer> updateStock = new LinkedHashMap<>();
	private Map<String, Integer> reorderAmounts = new HashMap();
	private Manifest maniTemp = new Manifest();
	private Map inventStore = new HashMap();
	private double cargoTotalOrd;
	private int ordCargo;
	private int refridgeCargo;
	private List<Item> objectNames = new ArrayList<Item>();

	public void storeInventory() {
		this.objectNames = maniTemp.getItem();
		for(int i = 0; i < objectNames.size(); i++) {
			objectNames.get(i).getName();
			objectNames.get(i).getQuantity();
			if(objectNames.get(i).getTemperatureCheck() == true) {
				objectNames.get(i).getTemperatureCel();
			}
		}
	}

	//stock value


	public void stockOrder() {
		//create instance of manifest
		//remove all current order Information with new information
		for(int i = 0; i < reorderAmounts.size(); i++) {
			reorderAmounts.remove(maniTemp.objectNames.get(i).getName());
		}
		for(int i = 0; i < maniTemp.objectNames.size(); i++) {
			if(maniTemp.objectNames.get(i).getQuantity() <= maniTemp.objectNames.get(i).getReorderPoint()) {
				reorderAmounts.put(maniTemp.objectNames.get(i).getName(), maniTemp.objectNames.get(i).getReorderAmount());
			}
		}
		maniTemp.stockOrder();
	}

	public double manifestDelivered(File delManifest) {
		updateStock = maniTemp.openManifest(delManifest);
		double cargoSum = 0;
		for(int i = 0; i < updateStock.size(); i++) {
			objectNames.get(i).setQuantity(updateStock.get(objectNames.get(i).getName()));
			cargoSum += objectNames.get(i).getQuantity();
		}
		OrdinaryTruck ordTruck = new OrdinaryTruck();
		//haven't added refridgerated Truck Yet
		double cargoTot = ordTruck.truckCost(cargoSum);
		return cargoTot;

	}

	public double getCargoOrd() {
		return this.cargoTotalOrd;
	}

	private boolean tempChecker(int counter) {
		if(maniTemp.objectNames.get(counter).getTemperatureCheck() == true){
			return true;
		} else {
			return false;
		}
	}

	public int getCargoTotalOrd() {
		for(int i = 0; i < maniTemp.objectNames.size();i++){
			if(tempChecker(i) == false) {
				ordCargo = ordCargo +  reorderAmounts.get(maniTemp.objectNames.get(i).getName());
			}
		}
		return ordCargo;
	}

	public int getCargoTotalRef() {
		for(int i = 0; i < maniTemp.objectNames.size(); i++) {
			if(tempChecker(i) == true) {
				refridgeCargo = refridgeCargo + reorderAmounts.get(maniTemp.objectNames.get(i).getName());
			}
		}
		return refridgeCargo;
	}




}
