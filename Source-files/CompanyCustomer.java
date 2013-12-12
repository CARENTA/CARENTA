/* This class describes a company customer with the following attributes and methods! */

public class CompanyCustomer extends Customer {

	private String orgNbr; // Identification variable! 

	public CompanyCustomer(String firstName, String lastName,
			String customerNbr, String adress, String city, String areaCode,
			String phoneNbr, String mailAdress, int discountLevel,
			Order previousOrder, String orgNbr) {
		
		super(firstName, lastName, customerNbr, adress, city, areaCode, phoneNbr, // Heritage...
				mailAdress, discountLevel);

		this.orgNbr = orgNbr; // Organizational number!
	}

	public String getOrgNbr() {
		return orgNbr;
	}

	public void setOrgNbr(String orgNbr) {
		this.orgNbr = orgNbr;
	}	
}
