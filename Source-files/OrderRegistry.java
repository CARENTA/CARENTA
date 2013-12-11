/* This class describes a registry able to contain orders within an array list! */ 

import java.util.ArrayList;

public class OrderRegistry {

	private ArrayList<Order> orders;
	
	public OrderRegistry() {
		this.orders = new ArrayList<Order>(); // Creates an empty array list...
	}
	
	public ArrayList<Order> getOrders() { // Returns the list containing ALL orders!
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) { // Sets a list containing orders!
		this.orders = orders;
	}

	public void addOrder(Order order) { // Adds a single order to the registry!
		orders.add(order);
	}

	public Order getOrder(int pos) { // Returns a single order from the position "pos" within the registry!
		return orders.get(pos);
	}
	
	public void removeOrder(Order order) { // Removes the order from the list!
		orders.remove(order);
	}
	
}
