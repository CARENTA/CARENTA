/* This class describes an order. It contains a lot of different elements and is one of the 
 * core class functions. It keeps track of all other objects involved in a booking event
 * and is essential for the program! */

import java.util.ArrayList;

public class Order {

	private int orderNbr; // Identification variable!
	private int discount; // Discount rate on the specific order! Could be seasonal 10% etcetera...
	private int totalPrice; // Total price of the products!
	private boolean isAppropriate; // If the order is appropriate for the company!
	private boolean wasSatesfied; // If the customer was satisfied with the order!
	private String latestUpdate; // At what date when the order was last updated!	
	private Customer customer; // The customer administrating it...
	private Employee employee; // The vehicle administrating it...
	private Vehicle vehicle; // The employee administrating it...
	private ArrayList<Accessory> accessories; // The products in the order...
	
	public Order(int orderNbr, int discount, int totalPrice,
				 boolean isAppropriate, boolean wasSatesfied, String latestUpdate,
				 Customer customer, Vehicle vehicle, Employee employee, ArrayList<Accessory> accessories) {

		this.orderNbr = orderNbr;
		this.discount = discount;
		this.totalPrice = totalPrice;
		this.isAppropriate = isAppropriate;
		this.wasSatesfied = wasSatesfied;
		this.latestUpdate = latestUpdate;
		this.customer = customer;
		this.employee = employee;
		this.vehicle = vehicle;
		this.accessories = accessories;
	}

	public int getOrderNbr() {
		return orderNbr;
	}

	public void setOrderNbr(int orderNbr) {
		this.orderNbr = orderNbr;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
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
	
	public Customer getCustomer() {
		return customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public ArrayList<Accessory> getAccessories() {
		return accessories;
	}

	public void setAccessories(ArrayList<Product> products) {
		this.accessories = accessories;
	}
}
