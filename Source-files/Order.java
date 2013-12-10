public class Order {

	private String orderNbr; // Identification variable!
	private int discount; // Discount rate on the specific order!
	private int totalPrice; // Total price of the products!
	private boolean isAppropriate; // If the order is appropriate for the company!
	private boolean wasSatesfied; // If the customer was satisfied with the order!
	private String latestUpdate; // At what date when the order was last updated!
	private Vehicle vehicle; // The vehicle in question...
	private Accessory accessory; // The accessory in question...
	private Customer customer; // The customer in question...
	private Employee employee; // The employee administrating it...

	public Order(String orderNbr, int discount, int totalPrice,
			boolean isAppropriate, boolean wasSatesfied, String latestUpdate,
			Vehicle vehicle, Customer customer) {

		this.orderNbr = orderNbr;
		this.discount = discount;
		this.totalPrice = totalPrice;
		this.isAppropriate = isAppropriate;
		this.wasSatesfied = wasSatesfied;
		this.latestUpdate = latestUpdate;
		this.vehicle = vehicle;
		this.customer = customer;
	}

	public String getOrderNbr() {
		return orderNbr;
	}

	public void setOrderNbr(String orderNbr) {
		this.orderNbr = orderNbr;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getTotalPrice() {
		totalPrice = vehicle.getPrice() + accessory.getPrice();
		totalPrice = totalPrice - (totalPrice * discount);
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isAppropriate() {
		return isAppropriate;
	}

	public void setAppropriate(boolean isAppropriate) {
		this.isAppropriate = isAppropriate;
	}

	public boolean isWasSatesfied() {
		return wasSatesfied;
	}

	public void setWasSatesfied(boolean wasSatesfied) {
		this.wasSatesfied = wasSatesfied;
	}

	public String getLatestUpdate() {
		return latestUpdate;
	}

	public void setLatestUpdate(String latestUpdate) {
		this.latestUpdate = latestUpdate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
