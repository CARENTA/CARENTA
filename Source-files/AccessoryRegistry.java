import java.util.ArrayList;

public class AccessoryRegistry {
	
	private ArrayList<Accessory> accessories;

	public AccessoryRegistry(ArrayList<Accessory> accessories) {
		this.accessories = accessories;
	}

	public ArrayList<Accessory> getvehicles() {
		return accessories;
	}

	public void setvehicles(ArrayList<Accessory> accessories) {
		this.accessories = accessories;
	}
	
	public void addvehicle(Accessory vehicle) {
		accessories.add(vehicle);
	}
	
	public void removevehicle(Accessory vehicle) {
		accessories.remove(vehicle);
	}
}
