/* This class describes a permanent employee with the following attributes and methods! */

public class PermanentEmployee extends Employee {
	
	private double monthlySalary;
	
	public PermanentEmployee(int employeeNbr, String personNbr,
			String firstName, String lastName, String email,
			String telephoneNbr, double monthlySalary) {
		
		super(employeeNbr, personNbr, firstName, lastName, email, telephoneNbr);
		
		this.monthlySalary = monthlySalary;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
}
