
public class Employee {
	// Klassen Employee består av anställda på kontoret för att kunna logga vad olika anställda har för info
	// och kunna registrera vad de anställda har gjort för affärer.
	private String employeeNbr;
	private String personalNbr;
	private String firstName;
	private String lastName;
	private String adress;
	private String email;
	private String telephoneNbr;
	// Ange vilka variablar vi använder. Se UML diagram för klassen och variablar.
	
	public Employee(String employeeNbr, String personalNbr, String firstName, String lastName, String adress,
			String email, String telephoneNbr){
		this.setEmployeeNbr(employeeNbr);
		this.setPersonalNbr(personalNbr);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAdress(adress);
		this.setEmail(email);
		this.setTelephoneNbr(telephoneNbr);
	}

	public String getEmployeeNbr() {
		return employeeNbr;
	}

	public void setEmployeeNbr(String employeeNbr) {
		this.employeeNbr = employeeNbr;
	}

	public String getPersonalNbr() {
		return personalNbr;
	}

	public void setPersonalNbr(String personalNbr) {
		this.personalNbr = personalNbr;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephoneNbr() {
		return telephoneNbr;
	}

	public void setTelephoneNbr(String telephoneNbr) {
		this.telephoneNbr = telephoneNbr;
	}
	// Skapar setter och getter för Employee klassen.
	

}
