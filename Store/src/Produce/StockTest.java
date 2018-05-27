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
