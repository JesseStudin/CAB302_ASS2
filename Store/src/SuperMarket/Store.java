package SuperMarket;

public class Store
{
	//Miscellaneous:
	private double capital = 100000.00;
	private static final long serialVersionUID = 1L;
	private static Store instance = new Store();
	
	private Store() {	}

	public static Store getInstance()
	{
		return instance;
	}
	
	public String getCapital()
	{
		String tempHold = Double.toString(this.capital);
		return tempHold;
	}

	public void setCapital(double amount)
	{
		this.capital = this.capital - amount;
	}
	
	public void setCapitalProfit(double amount) {
		this.capital = this.capital + amount;
	}
}