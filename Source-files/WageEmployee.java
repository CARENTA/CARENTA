/* This class describes a wage employee with the following attributes and methods! */

public class WageEmployee extends Employee {
	
	private double hourlySalary;
	private double amountOfHours;

	public WageEmployee(int employeeNbr, String personNbr,
			String firstName, String lastName, String telephoneNbr,
			String email) {
		
		super(employeeNbr, personNbr, firstName, lastName, email, telephoneNbr);

		this.hourlySalary = hourlySalary;
		this.amountOfHours = amountOfHours;

	}

	public double getHourlySalary() {
		return hourlySalary;
	}

	public void setHourlySalary(double hourlySalary) {
		this.hourlySalary = hourlySalary;
	}

	public double getAmountOfHours() {
		return amountOfHours;
	}

	public void setAmountOfHours(double amountOfHours) {
		this.amountOfHours = amountOfHours;
	}
}
