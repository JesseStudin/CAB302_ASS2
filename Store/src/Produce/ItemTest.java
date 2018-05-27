package Produce;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {

	@Test
	void getterTest() {
		Item Banana = new Item("Banana", 450, 12.0, 18.0, 200, 450);
		Item Yogurt = new Item("Yogurt", 450, 12.0, 18.0, 200, 450, 12.0);
		Item Manderine = new Item("Manderine", 450, 12.0, 18.0, 200, 450);
		String getName = Banana.getName();
		int getQuantity = Yogurt.getQuantity();
		double getSellPrice = Manderine.getsellPrice();
		assertEquals(getName, Banana.getName());
		assertEquals(getQuantity, Yogurt.getQuantity());
		assertEquals(getSellPrice, Manderine.getsellPrice());
	}
	
	@Test
	void setterTest() {
		Item Banana = new Item("Banana", 450, 12.0, 18.0, 200, 450);
		Item Yogurt = new Item("Yogurt", 450, 12.0, 18.0, 200, 450, 12.0);
		Item Manderine = new Item("Manderine", 450, 12.0, 18.0, 200, 450);
		Banana.setName("Yellow");
		String setName = Banana.getName();
		Yogurt.setQuantityManifest(200);
		System.out.println(Yogurt.getQuantity());
		int setQuantity = Yogurt.getQuantity();
		Manderine.setSellPrice(40);
		double setSellPrice = Manderine.getsellPrice();
		assertEquals("Yellow", setName);
		assertEquals(650, setQuantity);
		assertEquals(40.0, setSellPrice);
	}

}
