package Produce;

public class Item {

	private String name;
	private double cost, sellPrice, temperaturecel;
	private int reorderPoint, reorderAmount, quantity;
	private boolean temperatureCheck;

	public Item(String name, int quantity, double cost, double sellPrice, int reorderPoint, int reorderAmount) {
		this.name = name;
		this.quantity = reorderAmount;
		this.cost = cost;
		this.sellPrice = sellPrice;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
		this.temperatureCheck = false;
	}

	public Item(String name,int quantity, double cost, double sellPrice, int reorderPoint, int reorderAmount, double temperaturecel) {
		this.name = name;
		this.quantity = reorderAmount;
		this.cost = cost;
		this.sellPrice = sellPrice;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
		this.temperaturecel = temperaturecel;
		this.temperatureCheck = true;
	}

	//getters
	public String getName() {
		return this.name;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public double getCost() {
		return this.cost;
	}

	public double getsellPrice() {
		return this.sellPrice;
	}

	public int getReorderPoint() {
		return this.reorderPoint;
	}

	public int getReorderAmount() {
		return this.reorderAmount;
	}

	public double getTemperatureCel() {
		return this.temperaturecel;
	}

	public boolean getTemperatureCheck() {
		return this.temperatureCheck;
	}

	//setters
	public void setName(String name) {
		this.name = name;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public void  setReorderAmount(int reorderAmount) {
		this.reorderAmount = reorderAmount;
	}

	public void setTemperatureCel(double temperaturecel) {
		this.temperaturecel = temperaturecel;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	//OTHER CODE NOW


}
