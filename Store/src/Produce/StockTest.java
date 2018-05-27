package Produce;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Manifests.StoreItems;

class StockTest {

	@Test
	void testStoreInventory() {
		fail("Not yet implemented");
	}

	@Test
	void testShowInventory() {
		Stock stockTest = new Stock();
		StoreItems storeditems = StoreItems.getInstance();
		List<Item> objectNames = new ArrayList<>();
		Item Banana = new Item("Banana", 450, 12.0, 18.0, 200, 450);
		Item Yogurt = new Item("Yogurt", 450, 12.0, 18.0, 200, 450, 12.0);
		Item Manderine = new Item("Manderine", 450, 12.0, 18.0, 200, 450);
		for(int i = 0; i < 3; i++) {
			if(i == 0) {
				objectNames.add(Banana);
			} else if(i == 1) {
				objectNames.add(Yogurt);
			} else if(i == 2) {
				objectNames.add(Manderine);
			}
		}
		storeditems.setObjectNames(objectNames);
		System.out.println(stockTest.showInventory(0));
	}

	@Test
	void testGetObjectAmount() {
		fail("Not yet implemented");
	}

	@Test
	void testInitialise() {
		fail("Not yet implemented");
	}

	@Test
	void testStockOrder() {
		fail("Not yet implemented");
	}

	@Test
	void testManifestDelivered() {
		fail("Not yet implemented");
	}

	@Test
	void testSalesLog() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCargoOrd() {
		fail("Not yet implemented");
	}

}
