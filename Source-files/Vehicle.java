/* This class describes a vehicle with the following attributes and methods! */

import java.util.ArrayList;

public class Vehicle extends Product {

	private String regNbr;
	private String model; 
	private String type; // What kind of vehicle...
	private String licenseReq; // What license is required to drive it...
	private int price; // Rental price per day...
	private String info; // General information about the vehicle
	private boolean hasHook; // If the vehicle is able to pull lorries...
	private String expiryDate; // When it should be sold!
	private Warehouse warehouse; // Where the vehicle is located!
	private ArrayList<String> datesBooked; // A list containing dates when it's booked...

	public Vehicle(String regNbr, String model, String type, String licenseReq,
				   int price, String info, boolean hasHook, 
				   String expiryDate, Warehouse warehouse) {
		
		this.regNbr = regNbr;
		this.model = model;
		this.type = type;
		this.licenseReq = licenseReq;
		this.price = price;
		this.info = info;
		this.hasHook = hasHook;
		this.expiryDate = expiryDate;
		this.warehouse = warehouse;
		this.datesBooked = new ArrayList<String>();
	}

	public String getRegNbr() {
		return regNbr;
	}

	public void setRegNbr(String regNbr) {
		this.regNbr = regNbr;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public boolean hasHook() {
		return hasHook;
	}

	public void setHasHook(boolean hasHook) {
		this.hasHook = hasHook;
	}

	public String getExpiryDate(){
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate){
		this.expiryDate = expiryDate;
	}
	
	public Warehouse getWarehouse(){
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse){
		this.warehouse = warehouse;
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
