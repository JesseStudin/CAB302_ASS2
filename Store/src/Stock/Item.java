package Stock;

public class Item {
//this will read the csv and set the data
	//some public variables
	private double manufacterCost, sellPrice, temperatureCel, reorderAmount, reorderPoint;
	private String productName;

	public Item(String productName){
		//default values for just productName
		//Used as a placeholder for a company??
		this.productName = productName;
		reorderAmount = 0;
		reorderPoint = 0;
		sellPrice = 0;
		manufacterCost = 0;
		sellPrice = 0;
		this.temperatureCel = 0.0;
	}

	public Item(String productName, double manufacterCost, double sellPrice, double reorderPoint, double reorderAmount) {
		this.productName = productName;
		this.manufacterCost = manufacterCost;
		this.sellPrice = sellPrice;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
		this.temperatureCel = 0.0;
	}

	public Item(String productName, double manufacterCost, double sellPrice, double reorderPoint, double reorderAmount, double temperatureCel) {
		this.productName = productName;
		this.manufacterCost = manufacterCost;
		this.sellPrice = sellPrice;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
		this.temperatureCel = temperatureCel;
	}

	//setters
	public void setProductName(String productName) {
		this.productName = productName;
	}


	public void setManufacterCost(double manufacterCost) {
		this.manufacterCost = manufacterCost;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public void setReorderAmount(double reorderAmount) {
		this.reorderAmount = reorderAmount;
	}

	public void setReorderPoint(double reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public void setTemperatureCel(double temperatureCel) {
		this.temperatureCel = temperatureCel;
	}
	//getters
	public String getProductName() {
		return this.productName;
	}

	public double getManufacterCost() {
		return this.manufacterCost;
	}

	public double getSellPrice() {
		return this.sellPrice;
	}

	public double getReorderAmount() {
		return this.reorderAmount;
	}

	public double getReorderPoint() {
		return this.reorderAmount;
	}

	public double getTemperatureCel() {
		return this.temperatureCel;
	}

}
