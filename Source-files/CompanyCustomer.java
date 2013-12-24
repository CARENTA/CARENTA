/* This class describes a company customer with the following attributes and methods! */

public class CompanyCustomer extends Customer {

	private String orgNbr; // Identification variable! 
	private String companyName;
	
	
	public CompanyCustomer(int customerNbr, String orgNbr, String companyName,
			String adress, String city, String areaCode,
			String phoneNbr, String mailAdress, int discountLevel) {
		
		super(customerNbr, adress, city, areaCode, phoneNbr,
				mailAdress, discountLevel);
		
		this.orgNbr = orgNbr; // Organizational number!
		this.companyName = companyName;
		
	}

	public String getOrgNbr() {
		return orgNbr;
	}

	public void setOrgNbr(String orgNbr) {
		this.orgNbr = orgNbr;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
