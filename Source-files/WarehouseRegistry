/* This class describes a registry able to contain warehouses within an array list! */ 

import java.util.ArrayList;

public class WarehouseRegistry {

	private ArrayList<Warehouse> warehouses;
	
	public WarehouseRegistry() {
		this.warehouses = new ArrayList<Warehouse>(); // Creates an empty array list...
	}
	
	public ArrayList<Warehouse> getWarehouses() { // Returns the list containing ALL warehouses!
		return warehouses;
	}

	public void setWarehouses(ArrayList<Warehouse> warehouses) { // Sets a list containing warehouses!
		this.warehouses = warehouses;
	}

	public void addWarehouse(Warehouse warehouse) { // Adds a single warehouse to the registry!
		warehouses.add(warehouse);
	}

	public Warehouse getWarehouse(int pos) { // Returns a single warehouse from the position "pos" within the registry!
		return warehouses.get(pos);
	}
	
	public void removeWarehouse(Warehouse warehouse) { // Removes the warehouse from the list!
		warehouses.remove(warehouse);
	}
}
