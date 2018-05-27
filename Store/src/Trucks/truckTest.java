package Trucks;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Produce.Item;

class truckTest {

	@Test
	void test() {
		OrdinaryTruck oTest = new OrdinaryTruck();
		int cargoTest = oTest.cargoCapacity();
		assertEquals(1000, cargoTest);
		
	}
	
	@Test
	void cargoRestrictionTest() {
		OrdinaryTruck oTest = new OrdinaryTruck();
		boolean cargoTest = oTest.cargoRestriction("TempControlled");
		assertEquals(false, cargoTest);
	}
	
	
	@Test
	void ordTruckCostTest() {
		OrdinaryTruck oTest = new OrdinaryTruck();
		String tempObjectName = "Banana";	
		Item Banana = new Item(tempObjectName, 444, 18.0, 22.0, 222, 450);
		Item Orange = new Item("Orange", 300, 18.0, 22.0, 222, 450);
		Item Manderine = new Item("Manderine", 444, 18.0, 22.0, 222, 450);
		int cargoSum = 0;
		cargoSum = cargoSum + Banana.getQuantity();
		cargoSum = cargoSum + Orange.getQuantity();
		cargoSum = cargoSum + Manderine.getQuantity();
		double sum = oTest.truckCost(cargoSum);
		assertEquals(1047.0, sum);
	}
	
	@Test
	void refTruckCostTest() {
		RefridgeratedTruck rTest = new RefridgeratedTruck();
		Item Banana = new Item("Banana", 444, 18.0, 22.0, 222, 450, 11);
		Item Orange = new Item("Orange", 300, 18.0, 22.0, 222, 450, 12.8);
		Item Manderine = new Item("Manderine", 444, 18.0, 22.0, 222, 450, 12.0);
		List<Item> itemNames = new ArrayList<>();
		itemNames.add(Banana);
		itemNames.add(Orange);
		itemNames.add(Manderine);
		double highestTemp = 0;
		for(int i = 0; i < itemNames.size(); i++) {
			if(itemNames.get(i).getTemperatureCel() > highestTemp) {
				highestTemp = itemNames.get(i).getTemperatureCel();
			}
		}
		double tempSum = rTest.truckCost(highestTemp);
		assertEquals((int)tempSum, 980);
	}
	
	
	
}
