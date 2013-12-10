
public class PermanentEmployee extends Employee {
	private double monthlySalary;
// Creating one variable wich is mentioned in the UML.
	public PermanentEmployee(String employeeNbr, String personalNbr,
			String firstName, String lastName, String adress, String email,
			String telephoneNbr) {
		super(employeeNbr, personalNbr, firstName, lastName, adress, email,
				telephoneNbr);
 // Creating a constructor for the class.
		this.monthlySalary = monthlySalary;


	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
// Creating getter and setter.

	}
	





