package objects;

import java.util.ArrayList;

public class Order {

	private int orderNbr; // Identification variable!
	private Customer customer; // The customer administrating it...
	private ArrayList<Product> products; // The products in the order;
	private Employee employee; // The vehicle administrating it...
	private int totalPrice; // Total price of the products!
	private int discount; // Discount rate on the specific order! Could be seasonal 10% etcetera...
	private String claimDate; // Date for when the get the vehicle...
	private boolean isAppropriate; // If the order is appropriate for the company!
	private boolean wasSatesfied; // If the customer was satisfied with the order!
	private String latestUpdate; // At what date when the order was last updated!	
	
	public Order(int orderNbr, Customer customer, ArrayList<Product> products,
				 Employee employee, int totalPrice, int discount, String claimDate, 
				 boolean isAppropriate, boolean wasSatesfied, String latestUpdate) {

		this.orderNbr = orderNbr;
		this.customer = customer;
		this.products = new ArrayList<Product>(products);
		this.employee = employee;
		this.totalPrice = totalPrice;
		this.discount = discount;
		this.claimDate = claimDate;
		this.isAppropriate = isAppropriate;
		this.wasSatesfied = wasSatesfied;
		this.latestUpdate = latestUpdate;

	}

	public String getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	public int getOrderNbr() {
		return orderNbr;
	}

	public void setOrderNbr(int orderNbr) {
		this.orderNbr = orderNbr;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public boolean getIsAppropriate() {
		return isAppropriate;
	}

	public void setAppropriate(boolean isAppropriate) {
		this.isAppropriate = isAppropriate;
	}

	public boolean getWasSatesfied() {
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
	
}
