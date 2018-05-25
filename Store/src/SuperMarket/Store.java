package SuperMarket;

public class Store {

	//create object
	private static Store instance = new Store();

	private Store(){}

	public static Store getInstance() {
		return instance;
	}

	private double capital = 100000.00;

	public String getCapital() {
		String tempHold = Double.toString(this.capital);
		return tempHold;
	}

	public void setCapital(double amount) {
		this.capital = this.capital - amount;
	}




}
