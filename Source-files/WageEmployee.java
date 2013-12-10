
public class WageEmployee extends Employee {
	private double hourlySalary;
	private double amountOfHours;
// Two different variables which is existing in the UML code.
	public WageEmployee(String employeeNbr, String personalNbr,
			String firstName, String lastName, String adress, String email,
			String telephoneNbr) {
		super(employeeNbr, personalNbr, firstName, lastName, adress, email,
				telephoneNbr);
// Creating constructors for the class.
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
// Creating getter and setter for the class.
}
