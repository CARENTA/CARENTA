/* This class describes a registry able to contain accessories within an array list! */ 

import java.util.ArrayList;

public class AccessoryRegistry {

	private ArrayList<Accessory> accessories;

	public AccessoryRegistry() {
		this.accessories = new ArrayList<Accessory>(); // Creates an empty array list...
	}

	public ArrayList<Accessory> getAccessories() { // Returns the list containing ALL accessories!
		return accessories;
	}

	public void setAccessories(ArrayList<Accessory> accessories) { // Sets a list containing accessories!
		this.accessories = accessories;
	}

	public void addAccessory(Accessory accessory) { // Adds a single accessory to the registry!
		accessories.add(accessory);
	}
	
	public Accessory getAccessory(int pos) { // Returns a single accessory from the position "pos" within the registry!
		return accessories.get(pos);
	}

	public void removeAccessory(Accessory accessory) { // Removes the accessory from the list!
		accessories.remove(accessory);
	}
}
