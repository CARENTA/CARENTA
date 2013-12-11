/* This class describes a registry able to contain employees within an array list! */ 

import java.util.ArrayList;

public class EmployeeRegistry {

	private ArrayList<Employee> employees;
	
	public EmployeeRegistry() {
		this.employees = new ArrayList<Employee>(); // Creates an empty array list...
	}
	
	public ArrayList<Employee> getEmployees() { // Returns the list containing ALL employees!
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) { // Sets a list containing employees!
		this.employees = employees;
	}

	public void addEmployee(Employee vehicle) { // Adds a single vehicle to the registry!
		employees.add(vehicle);
	}

	public Employee getEmployee(int pos) { // Returns a single vehicle from the position "pos" within the registry!
		return employees.get(pos);
	}
	
	public void removeEmployee(Employee vehicle) { // Removes the vehicle from the list!
		employees.remove(vehicle);
	}
	
}
