
public class Customer {

	private String firstName;
	private String lastName;
	private String customerNbr; // Identification variable!
	private String adress;
	private String city;
	private String areaCode;
	private String phoneNbr;
	private String mailAdress;
	private int discountLevel; // What level of discount the customer has (10%, 20% ...)!
	private Order previousOrder; // 
	
	public Customer(String firstName, String lastName, String customerNbr,
			String adress, String city, String areaCode, String phoneNbr,
			String mailAdress, int discountLevel, Order previousOrder) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerNbr = customerNbr;
		this.adress = adress;
		this.city = city;
		this.areaCode = areaCode;
		this.phoneNbr = phoneNbr;
		this.mailAdress = mailAdress;
		this.discountLevel = discountLevel;
		this.previousOrder = previousOrder;
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

	public String getCustomerNbr() {
		return customerNbr;
	}

	public void setCustomerNbr(String customerNbr) {
		this.customerNbr = customerNbr;
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

	public String getPhoneNbr() {
		return phoneNbr;
	}

	public void setPhoneNbr(String phoneNbr) {
		this.phoneNbr = phoneNbr;
	}

	public String getMailAdress() {
		return mailAdress;
	}

	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}

	public int getDiscountLevel() {
		return discountLevel;
	}

	public void setDiscountLevel(int discountLevel) {
		this.discountLevel = discountLevel;
	}
	
	public Order getPreviousOrder(Order previousOrder) {
		return previousOrder;
	}
	
	public void setPreviousOrder(Order previousOrder) {
		this.previousOrder = previousOrder;
	}
}
