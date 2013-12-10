/* The class acts as a location tracker for vehicles! Vehicles uses the class as a definition
 * of where they are located! The accessories and the employees may in the 
 * future also use this service! */

public class Warehouse {

	private String adress;
	private String city;
	private String areaCode;
	
	public Warehouse(String adress, String city, String areaCode) {
		super();
		this.adress = adress;
		this.city = city;
		this.areaCode = areaCode;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}	
}
