/* This class describes a registry able to contain vehicles within an array list! */ 

import java.util.ArrayList;

public class VehicleRegistry {

	private ArrayList<Vehicle> vehicles;
	
	public VehicleRegistry() {
		this.vehicles = new ArrayList<Vehicle>(); // Creates an empty array list...
	}
	
	public ArrayList<Vehicle> getVehicles() { // Returns the list containing ALL vehicles!
		return vehicles;
	}

	public void setVehicles(ArrayList<Vehicle> vehicles) { // Sets a list containing vehicles!
		this.vehicles = vehicles;
	}

	public void addVehicle(Vehicle vehicle) { // Adds a single vehicle to the registry!
		vehicles.add(vehicle);
	}

	public Vehicle getVehicle(int pos) { // Returns a single vehicle from the position "pos" within the registry!
		return vehicles.get(pos);
	}
	
	public void removeVehicle(Vehicle vehicle) { // Removes the vehicle from the list!
		vehicles.remove(vehicle);
	}
	
}
