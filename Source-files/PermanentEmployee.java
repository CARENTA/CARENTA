/* This class describes a permanent employee with the following attributes and methods! */

public class PermanentEmployee extends Employee {
	
	private double monthlySalary;

	public PermanentEmployee(String employeeNbr, String personalNbr,
			String firstName, String lastName, String adress, String email,
			String telephoneNbr) {
		
		super(employeeNbr, personalNbr, firstName, lastName, adress, email, // Heritage...
				telephoneNbr);
		
		this.monthlySalary = monthlySalary;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
}
