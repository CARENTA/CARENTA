/* This class describes a registry able to contain customers within an array list! */ 

import java.util.ArrayList;

public class CustomerRegistry {

	private ArrayList<Customer> customers;

	public CustomerRegistry() {
		this.customers = new ArrayList<Customer>(); // Creates an empty array list..
	}

	public ArrayList<Customer> getCustomers() { // Returns the list containing ALL customers!
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) { // Sets a list containing customers!
		this.customers = customers;
	}

	public void addCustomer(Customer customer) { // Adds a single customer to the registry!
		customers.add(customer);
	}

	public Customer getCustomer(int pos) { // Returns a single customer from the position "pos" within the registry!
		return customers.get(pos);
	}
	
	public void removeCustomer(Customer customer) { // Removes the customer from the list!
		customers.remove(customer);
	}
}
