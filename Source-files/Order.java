/* This class describes an order. It contains a lot of different elements and is one of the 
 * core class functions. It keeps track of all other objects involved in a booking event
 * and is essential for the program! */

import java.util.ArrayList;

public class Order {

	private String orderNbr; // Identification variable!
	private int discount; // Discount rate on the specific order! Could be seasonel 10% etcetera...
	private int totalPrice; // Total price of the products!
	private boolean isAppropriate; // If the order is appropriate for the company!
	private boolean wasSatesfied; // If the customer was satisfied with the order!
	private String latestUpdate; // At what date when the order was last updated!	
	private PrivateCustomer privateCustomer; // The private customer in question...
	private CompanyCustomer companyCustomer; // The company customer in question...
	private Employee employee; // The employee administrating it...
	private ArrayList<Product> products; // The products in the order...
	
	public Order(String orderNbr, int discount, int totalPrice,
				 boolean isAppropriate, boolean wasSatesfied, String latestUpdate,
				 PrivateCustomer privateCustomer, CompanyCustomer companyCustomer, 
				 Employee employee, ArrayList<Product> products) {

		this.orderNbr = orderNbr;
		this.discount = discount;
		this.totalPrice = totalPrice;
		this.isAppropriate = isAppropriate;
		this.wasSatesfied = wasSatesfied;
		this.latestUpdate = latestUpdate;
		this.privateCustomer = privateCustomer;
		this.companyCustomer = companyCustomer;
		this.employee = employee;
		this.products = products;
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

	public Customer getPrivateCustomer() {
		return privateCustomer;
	}

	public void setPrivateCustomer(PrivateCustomer privateCustomer) {
		this.privateCustomer = privateCustomer;
	}
	
	public Customer getComapnyCustomer() {
		return companyCustomer;
	}

	public void setCompanyCustomer(CompanyCustomer companyCustomer) {
		this.companyCustomer = companyCustomer;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
}
