import java.util.ArrayList;

public class VehicleRegistry {
	
	private ArrayList<Vehicle> vehicles;

	public VehicleRegistry(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public ArrayList<Vehicle> getvehicles() {
		return vehicles;
	}

	public void setvehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public void addvehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	public void removevehicle(Vehicle vehicle) {
		vehicles.remove(vehicle);
	}
}
