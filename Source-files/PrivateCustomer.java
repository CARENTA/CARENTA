/* This class describes a private customer with the following attributes and methods! */

import java.util.ArrayList;

public class PrivateCustomer extends Customer {

	private String personNbr; // Identification variable! 
	private String firstName;
	private String lastName;
	
	public PrivateCustomer(int customerNbr, String personNbr, String firstName, 
			String lastName, String adress, String city, String areaCode,
			String phoneNbr, String mailAdress, int discountLevel) {
		
		super(customerNbr, adress, city, areaCode, phoneNbr,
				mailAdress, discountLevel);
		
		this.personNbr = personNbr;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	public String getPersonNbr() {
		return personNbr;
	}

	public void setPersonNbr(String personNbr) {
		this.personNbr = personNbr;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
