public class PrivateCustomer extends Customer {

	private String personNbr; // Identification variable! 
	
	public PrivateCustomer(String firstName, String lastName,
			String customerNbr, String adress, String city, String areaCode,
			String phoneNbr, String mailAdress, int discountLevel,
			Order previousOrder, String personNbr) {
		super(firstName, lastName, customerNbr, adress, city, areaCode, phoneNbr,
				mailAdress, discountLevel, previousOrder);
		
		this.personNbr = personNbr;	
	}

	public String getOrgNbr() {
		return personNbr;
	}

	public void setOrgNbr(String personNbr) {
		this.personNbr = personNbr;
	}	
}
