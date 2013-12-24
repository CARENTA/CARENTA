/* This class describes an employee with the following attributes and methods! The employee class
 * is abstract as the employee needs to be either a wage employee or a permanent employee. All
 * variables and methods which define the employee and are inherited! */

public abstract class Employee {

	private String employeeNbr;
	private String personNbr;
	private String firstName;
	private String lastName;
	private String telephoneNbr;
	private String email;

	public Employee(String employeeNbr, String personNbr, String firstName, 
					String lastName, String adress, String email, String telephoneNbr) {
		
		this.employeeNbr = employeeNbr;
		this.personNbr = personNbr;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.telephoneNbr = telephoneNbr;
	}

	public String getEmployeeNbr() {
		return employeeNbr;
	}

	public void setEmployeeNbr(String employeeNbr) {
		this.employeeNbr = employeeNbr;
	}

	public String getPersonalNbr() {
		return personNbr;
	}

	public void setPersonalNbr(String personalNbr) {
		this.personNbr = personalNbr;
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

	public String getTelephoneNbr() {
		return telephoneNbr;
	}

	public void setTelephoneNbr(String telephoneNbr) {
		this.telephoneNbr = telephoneNbr;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
