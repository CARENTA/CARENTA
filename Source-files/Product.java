/* This class, when implemented, will describe a product which consists of vehicles or
 * accessories. It will contain both vehicles and accessories in one array list making
 * the order class a lot more easy to follow! */

import java.util.ArrayList;

public class Product { 	

	private ArrayList<Product> products;
	int totalPrice; 

	public Product() {
		this.products = new ArrayList<Product>();
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	/* Methods for adding and removing things to the products.. */
	
	public void addVehicleProduct(Vehicle vehicle) {
		products.add(vehicle); // Add the vehicle to the list...
		totalPrice = totalPrice + vehicle.getPrice(); // ... and calculate its total price.
	}
	
	public void removeVehicleProduct(Vehicle vehicle) {
		products.remove(vehicle);
	}

	public void addAccessoryProduct(Accessory accessory) {
		products.add(accessory); // Add the accessory to the list...
		totalPrice = totalPrice + accessory.getPrice(); // ... and calculates its total price.
	}

	public void removeAccessoryProduct(Accessory accessory) {
		products.remove(accessory);
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}	
}
