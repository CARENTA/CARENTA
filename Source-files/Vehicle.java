/* This class describes a vehicle with the following attributes and methods! */

import java.util.ArrayList;

public class Vehicle extends Product {

	private String regNbr; // Identification variable...
	private String type; // What kind of vehicle...
	private String licenseReq; // What license is required to drive it...
	private boolean hasHook; // If the vehicle is able to pull lorries...
	private String expiryDate; // When it should be sold!
	Warehouse warehouse; // Where the vehicle is located (in which warehouse)!
	private ArrayList<String> datesBooked = new ArrayList<String>(); // A list containing dates when it's booked...
	
	public Vehicle(String regNbr, String productName, String type,
				   String licenseReq, int price, String infoTxt, boolean hasHook,
				   String expiryDate, Warehouse warehouse) {
		
		super(productName, infoTxt, price); // Heritage...
		
		this.regNbr = regNbr;
		this.type = type;
		this.licenseReq = licenseReq;
		this.hasHook = hasHook;
		this.expiryDate = expiryDate;
		this.warehouse = warehouse;
	}
	
	public String getRegNbr() {
		return regNbr;
	}

	public void setRegNbr(String regNbr) {
		this.regNbr = regNbr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLicenseReq() {
		return licenseReq;
	}

	public void setLicenseReq(String licenseReq) {
		this.licenseReq = licenseReq;
	}

	public boolean hasHook() {
		return hasHook;
	}

	public void setHasHook(boolean hasHook) {
		this.hasHook = hasHook;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public ArrayList<String> getDatesBooked() {
		return datesBooked;
	}

	public void setDatesBooked(ArrayList<String> datesBooked) {
		this.datesBooked = datesBooked;
	}

	public boolean isBookable(String enteredDate) { // Method to check if a car is bookable!
		
		for(int a = 0; a < datesBooked.size(); a++) { // Checks the whole list...
			
			if(datesBooked.get(a).equals(enteredDate)) { // If there is a date which matches our date...
					
				return false; // ... it's not available for booking!
				
			}

		} 

		return true; // ... make it available for booking!

	}

	public void setBooked(String enteredDate) {
		datesBooked.add(enteredDate);
	}

	public void removeBooked(String enteredDate) {
		datesBooked.remove(enteredDate);
	}
}
