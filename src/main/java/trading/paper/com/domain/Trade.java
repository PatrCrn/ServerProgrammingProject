package trading.paper.com.domain;

public class Trade {
    private int id;
    private int day;
    private String month;
    private int year;
    private int amount;
    private double entryPrice;
    private double exitPrice;
	private int cryptocurrency;

    public Trade() {
    	this.id = 0;
		this.day = 0;
		this.month = null;
		this.year = 0;
		this.amount = 0;
		this.entryPrice = 0;
		this.exitPrice = 0;
		this.cryptocurrency = 0;
	}

	public Trade(int day, String month, int year, int amount, double entryPrice, double exitPrice, int cryptocurrency) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.amount = amount;
		this.entryPrice = entryPrice;
		this.exitPrice = exitPrice;
		this.cryptocurrency = cryptocurrency;
	}

	public int getId() {
		return id;
	}

	public int getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public int getAmount() {
		return amount;
	}

	public double getEntryPrice() {
		return entryPrice;
	}

	public double getExitPrice() {
		return exitPrice;
	}

	public int getCryptocurrency() {
		return cryptocurrency;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setEntryPrice(double entryPrice) {
		this.entryPrice = entryPrice;
	}

	public void setExitPrice(double exitPrice) {
		this.exitPrice = exitPrice;
	}

	public void setCryptocurrency(int cryptocurrency) {
		this.cryptocurrency = cryptocurrency;
	}

	@Override
	public String toString() {
		return "Trade number " + id + ", the " + day + " " + month + " of " + year + ", amount invested : " + amount
				+ ", crypto bought : " + cryptocurrency + ", entry price at " + entryPrice + " and exit at " + exitPrice + ".";
	}
}
