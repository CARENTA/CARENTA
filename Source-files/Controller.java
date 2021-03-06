package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import objects.Accessory;
import objects.CompanyCustomer;
import objects.Customer;
import objects.Employee;
import objects.Order;
import objects.PermanentEmployee;
import objects.PrivateCustomer;
import objects.Product;
import objects.Vehicle;
import objects.Warehouse;
import registries.AccessoryRegistry;
import registries.CustomerRegistry;
import registries.EmployeeRegistry;
import registries.OrderRegistry;
import registries.VehicleRegistry;
import registries.WarehouseRegistry;
import GUI.MainGUI;

/* This is a simple test class used for testing that all the methods work! */

public class Controller {

	static DateFormat dateFormat = new SimpleDateFormat("YYYY/M/D"); // Gets the current date!
	static Date date = new Date();
	static String currentDate = dateFormat.format(date);

	static int productNbr = 0;
	static int orderNbr = 0;
	static int customerNbr = 0;

	static int currentDiscount = 0; // Current over all discount level, could be seasonal...

	static String enteredDate; // Variable containing entered rental date for order...
	static Warehouse selectedWarehouse; // Variable containing selected warehouse...
	static String selectedType; // Variable containing selected vehicle type...

	public static CustomerRegistry customerRegistry = new CustomerRegistry(); // Creates registers!
	static WarehouseRegistry warehouseRegistry = new WarehouseRegistry();
	public static OrderRegistry orderRegistry = new OrderRegistry();
	public static VehicleRegistry vehicleRegistry = new VehicleRegistry();
	public static AccessoryRegistry accessoryRegistry = new AccessoryRegistry();
	public static EmployeeRegistry employeeRegistry = new EmployeeRegistry();

	public static void main(String[] args) {	

		customerRegistry = createCustomers(customerRegistry);
		warehouseRegistry = createWarehouses(warehouseRegistry);
		vehicleRegistry = createVehicles(vehicleRegistry, warehouseRegistry); // Creates objects and stores them in the registers!
		accessoryRegistry = createAccessories(accessoryRegistry);
		employeeRegistry = createEmployees(employeeRegistry);
		orderRegistry = createOrders(orderRegistry);

		MainGUI mainGUI = new MainGUI(); // Creates the GUI!
		
	}
	
	/* -----------------------------------------------------------------------*/
	/* ---------------------------- FIND VEHICLE! ------------------------------*/
	/* -----------------------------------------------------------------------*/
	
	public Vehicle findVehicle (String regNbr) {
		
		Vehicle vehicle;
		
		for(int a = 0; a < vehicleRegistry.getVehicles().size(); a++) {
			
			vehicle = vehicleRegistry.getVehicle(a);
			
			if(vehicle.getRegNbr().equals(regNbr)) {
				return vehicle;
			}	
		}
		
		return null;
		
	}
	
	/* -----------------------------------------------------------------------*/
	/* ---------------------------- FIND ORDER! ------------------------------*/
	/* -----------------------------------------------------------------------*/

	public Order findOrder(String orderNbr) {
		
		Order order;
		
		for(int a = 0; a < orderRegistry.getOrders().size(); a++) {
			
			order = orderRegistry.getOrder(a);
			
			if(Integer.toString(order.getOrderNbr()).equals(orderNbr)) {

				return order;
					
			}
		}

		return null;
		
	}
		
	/* -----------------------------------------------------------------------*/
	/* ---------------- CALCULATE VEHICLE AVAILABILITY! ----------------------*/
	/* -----------------------------------------------------------------------*/

	public ArrayList<Vehicle> calculateVehicleAvailability(String enteredDate, String selectedWarehouse, String selectedType) {

		ArrayList<Vehicle> availableVehicles = new ArrayList<Vehicle>(); // Create a list which will contain the available vehicles...
		Vehicle vehicle;
		String vehicleWarehouse;
		String vehicleType;

		for(int a = 0; a < vehicleRegistry.getVehicles().size(); a++) { // Search the entire vehicle registry...

			vehicle = vehicleRegistry.getVehicle(a); 
			vehicleWarehouse = vehicle.getWarehouse().getCity();
			vehicleType = vehicle.getType();


			if(selectedWarehouse.equals(vehicleWarehouse) && selectedType.equals(vehicleType) && vehicle.isBookable(enteredDate)) { // If the vehicle matches desired warehouse, type and if it's bookable...

				availableVehicles.add(vehicle); // Add it to the list!

			}
		}

		return availableVehicles; // Return the list!

	}

	/* -----------------------------------------------------------------------*/
	/* -------------------- GET CURRENT VEHICLE TYPES! -----------------------*/
	/* -----------------------------------------------------------------------*/  

	public ArrayList<String> getCurrentVehicleTypes() {

		ArrayList<String> vehicleTypes = new ArrayList<String>(10);

		vehicleTypes.add("Personbil");
		vehicleTypes.add("Sportbil");
		vehicleTypes.add("Minibuss");
		vehicleTypes.add("Lastbil");

		return vehicleTypes;

	}

	/* -----------------------------------------------------------------------*/
	/* --------------------- GET WAREHOUSE NAMES! ----------------------------*/
	/* -----------------------------------------------------------------------*/

	public static Warehouse findWarehouse(String warehouseName) {
		
		Warehouse warehouse;
		
		for(int a = 0; a < warehouseRegistry.getWarehouses().size(); a++) {
			
			warehouse = warehouseRegistry.getWarehouse(a);
			
			if(warehouse.getCity().equals(warehouseName)) {
				return warehouse;
			}
			
		}
		
		return null;
		
	}
	
	/* -----------------------------------------------------------------------*/
	/* --------------------- GET WAREHOUSE NAMES! ----------------------------*/
	/* -----------------------------------------------------------------------*/

	public static ArrayList<String> getWarehouseNames () {

		ArrayList<String> warehouseNames = new ArrayList<String>();

		for(int a = 0; a < warehouseRegistry.getWarehouses().size(); a++) {
			Warehouse warehouse = warehouseRegistry.getWarehouse(a);
			warehouseNames.add(warehouse.getCity());
		}

		return warehouseNames;

	}


	/* -----------------------------------------------------------------------*/
	/* -------------------------- CREATE VEHICLE! ----------------------------*/
	/* -----------------------------------------------------------------------*/ 

	public static void createVehicle(String regNbr, String model, String type, String licenseReq, int price,
									 String info, String expiryDate, String warehouseCity, String hook) {
		
		Warehouse warehouse = findWarehouse(warehouseCity);
		boolean hasHook;
		
		if(hook.equals("Ja")) {
			hasHook = true;
		}
		else {
			hasHook = false;
		}
		
		Vehicle vehicle = new Vehicle(regNbr, model, type, licenseReq, price, info, hasHook, expiryDate, warehouse); 
		vehicleRegistry.addVehicle(vehicle);
			
	}
	
	/* -----------------------------------------------------------------------*/
	/* ------------------------ CREATE ACCESSORY! ----------------------------*/
	/* -----------------------------------------------------------------------*/ 


	public static String createAccessory(String inputName, int inputPrice, String inputInfo, int inputProductNbr) {

		if(inputProductNbr == 0) {
			productNbr = productNbr+1;
			Accessory accessory = new Accessory(productNbr, inputName, inputPrice, inputInfo);
			accessoryRegistry.addAccessory(accessory); // Adds the accessory to the registry!
			String confirmation = "Produkten skapad med produktnummer " + productNbr + ".";
			return confirmation;
		}
		else {
			Accessory accessory = new Accessory(inputProductNbr, inputName, inputPrice, inputInfo);
			accessoryRegistry.addAccessory(accessory); // Adds the accessory to the registry!
			String confirmation = "Produkten skapad med produktnummer " + inputProductNbr + ".";
			return confirmation;
		}
	}

	/* -----------------------------------------------------------------------*/
	/* ----------------------- GET SELECTED WAREHOUSE! -----------------------*/
	/* -----------------------------------------------------------------------*/

	public static Warehouse getSelectedWarehouse (String warehouseChoice) {

		for(int a = 0; a < warehouseRegistry.getWarehouses().size(); a++) {
			Warehouse warehouse = warehouseRegistry.getWarehouse(a);

			if(warehouseChoice.equals(warehouse.getCity())) { 

				return warehouse;

			}
		}

		return null;

	}

	/* -----------------------------------------------------------------------*/
	/* --------------------------- FIND ACCESSORY! ---------------------------*/
	/* -----------------------------------------------------------------------*/

	public Accessory findAccessory(int enteredProductNbr) {

		for(int a = 0; a < accessoryRegistry.getAccessories().size(); a++) { // Searching thru the registry

			Accessory accessory = accessoryRegistry.getAccessory(a); // Put the current accessory in an own variable...

			if(accessory.getProductNbr() == (enteredProductNbr)) { // If the given product number is equal to an existing accessories product number
				return accessory;
			}

		}

		return null;

	}

	/* -----------------------------------------------------------------------*/
	/* ------------------------ CREATE COMPANY  CUSTOMER! --------------------*/
	/* -----------------------------------------------------------------------*/

	public void createCompanyCustomer(String orgNbr, String name, String adress, String city,
			String areaCode, String phoneNbr, String mailAdress) {

		customerNbr = customerNbr + 1;

		CompanyCustomer newCustomer = new CompanyCustomer(customerNbr, orgNbr, name, adress, city, areaCode, phoneNbr, mailAdress, 1);

		customerRegistry.addCustomer(newCustomer);

	}

	/* -----------------------------------------------------------------------*/
	/* ------------------------ CREATE PRIVATE  CUSTOMER! --------------------*/
	/* -----------------------------------------------------------------------*/

	public void createPrivateCustomer(String personalNbr, String firstName, String lastName, String address, 
			String city, String areaCode, String telephoneNbr, String mail) {

		customerNbr = customerNbr + 1;

		PrivateCustomer newCustomer = new PrivateCustomer(customerNbr, personalNbr, firstName, lastName, address, 
				city, areaCode, telephoneNbr, mail, 1);

		customerRegistry.addCustomer(newCustomer);

	}

	/* -----------------------------------------------------------------------*/
	/* ---------------------------- FIND CUSTOMER! ---------------------------*/
	/* -----------------------------------------------------------------------*/

	public Customer findCustomer(String enteredCustomerNbr, String enteredIdentificationNbr) {

		Customer customer;

		for(int a = 0; a < customerRegistry.getCustomers().size(); a++) {

			customer = customerRegistry.getCustomer(a);

			if(Integer.toString(customer.getCustomerNbr()).equals(enteredCustomerNbr) || customer.getIDNbr().equals(enteredIdentificationNbr)  ) {
				return customer;
			}

		}

		return null;

	}

	/* -----------------------------------------------------------------------*/
	/* --------------------- CREATE ORDER NOT COMPLETED! ---------------------*/
	/* -----------------------------------------------------------------------*/

	public void createOrder(Customer customer, ArrayList<Product> shoppingCart, String claimDate, Employee employee) {

		orderNbr = orderNbr + 1;
		int totalPrice = 0;
		Product product;
		boolean isAppropriate = true; // MUST BE FIXED!!!!!
		boolean wasSatisfied = true; // MUST BE FIXED!!!!
		String latestUpdate = currentDate;
		int discount = currentDiscount;

		for(int a = 0; a < shoppingCart.size(); a++) {
			product = shoppingCart.get(a);
			totalPrice = totalPrice + product.getPrice();
		}

		Order order = new Order(orderNbr, customer,
				shoppingCart, employee, totalPrice, discount, 
				claimDate, isAppropriate, wasSatisfied, latestUpdate);

		orderRegistry.addOrder(order);
		customer.addPreviousOrder(order);
		
	}

	/* -----------------------------------------------------------------------*/
	/* ------------------------ CREATE CUSTOMERS! ----------------------------*/
	/* -----------------------------------------------------------------------*/

	/* This method creates five (5) company customers and five(5) private customers and adds them to the 
	 * customer registry, they are created for testing purposes and are to be considered as the companys' existing clients! */
	
	public static CustomerRegistry createCustomers (CustomerRegistry customerRegistry) {

		CompanyCustomer companyCustomer1 = new CompanyCustomer(customerNbr = customerNbr + 1, "123", "Itab AB", "Hejgatan 2", "Link��ping", "45357", "070734958", "order@itab.se", 2);
		CompanyCustomer companyCustomer2 = new CompanyCustomer(customerNbr = customerNbr + 1, "354", "Kaffesump AB", "H��gersv��ngen 7", "Lund", "22200", "0702332434", "anders.l@live.se", 3);
		CompanyCustomer companyCustomer3 = new CompanyCustomer(customerNbr = customerNbr + 1, "623","V��gade Pojkar INC", "Genv��gen 2B", "G��teborg", "45692", "0703748294", "per.j@live.se", 1);
		CompanyCustomer companyCustomer4 = new CompanyCustomer(customerNbr = customerNbr + 1, "477","Sk��nepartiet", "Slottsgatan 6", "Link��pig", "58000", "07347283939", "stina.s@live.se", 5);
		CompanyCustomer companyCustomer5 = new CompanyCustomer(customerNbr = customerNbr + 1, "333","Odd & Nicklas INC", "G��rdsv��gen 9A", "Lund", "23422", "0704221122", "lina.m@live.se", 10);

		PrivateCustomer privateCustomer6 = new PrivateCustomer(customerNbr = customerNbr + 1, "8906453434", "Joachim","Karlsson", "Nissev��gen 2A", "Link��ping", "58343", "0704532326", "jonny.k@live.se", 1);
		PrivateCustomer privateCustomer7 = new PrivateCustomer(customerNbr = customerNbr + 1, "8805032323", "Alexander","Steen", "Rakav��gen 4", "Link��ping", "58343", "0704532326", "jonny.k@live.se", 2);
		PrivateCustomer privateCustomer8 = new PrivateCustomer(customerNbr = customerNbr + 1, "9205053434", "Peter","Forsberg", "Rakav��gen 4", "Link��ping", "58343", "0704532326", "jonny.k@live.se", 3);
		PrivateCustomer privateCustomer9 = new PrivateCustomer(customerNbr = customerNbr + 1, "9111233114", "Mats","Sundin", "Rakav��gen 4", "Link��ping", "58343", "0704532326", "jonny.k@live.se", 2);
		PrivateCustomer privateCustomer10 = new PrivateCustomer(customerNbr = customerNbr + 1, "7201014455", "Robert","Svensson", "Rakav��gen 4", "Link��ping", "58343", "0704532326", "jonny.k@live.se", 1);

		customerRegistry.addCustomer(companyCustomer1);
		customerRegistry.addCustomer(companyCustomer2);
		customerRegistry.addCustomer(companyCustomer3);
		customerRegistry.addCustomer(companyCustomer4);
		customerRegistry.addCustomer(companyCustomer5);
		customerRegistry.addCustomer(privateCustomer6);
		customerRegistry.addCustomer(privateCustomer7);
		customerRegistry.addCustomer(privateCustomer8);
		customerRegistry.addCustomer(privateCustomer9);
		customerRegistry.addCustomer(privateCustomer10);

		return customerRegistry;

	}
	
	/* -----------------------------------------------------------------------*/
	/* ------------------------- CREATE ORDERS! ------------------------------*/
	/* -----------------------------------------------------------------------*/    

	/* This method creates five (5) orders and adds them to the order registry,
	 * they are created for testing purposes and are to be considered as the companys' existing orders! */
	
	public static OrderRegistry createOrders (OrderRegistry orderRegistry) {

		ArrayList<Product> productsTemplate = new ArrayList<Product>();
		productsTemplate.add(accessoryRegistry.getAccessory(0));
		
		Order order1 = new Order(orderNbr = orderNbr + 1, customerRegistry.getCustomer(3), productsTemplate, employeeRegistry.getEmployee(1), 1100, 0, currentDate, true, true, currentDate);
		Order order2 = new Order(orderNbr = orderNbr + 1, customerRegistry.getCustomer(1), productsTemplate, employeeRegistry.getEmployee(2), 5000, 0, currentDate, true, true, currentDate);
		Order order3 = new Order(orderNbr = orderNbr + 1, customerRegistry.getCustomer(9), productsTemplate, employeeRegistry.getEmployee(0), 300, 0, currentDate, true, true, currentDate);
		Order order4 = new Order(orderNbr = orderNbr + 1, customerRegistry.getCustomer(3), productsTemplate, employeeRegistry.getEmployee(1), 1100, 0, currentDate, true, true, currentDate);
		Order order5 = new Order(orderNbr = orderNbr + 1, customerRegistry.getCustomer(3), productsTemplate, employeeRegistry.getEmployee(2), 21100, 0, currentDate, true, true, currentDate);

		orderRegistry.addOrder(order1);
		orderRegistry.addOrder(order2);
		orderRegistry.addOrder(order3);
		orderRegistry.addOrder(order4);
		orderRegistry.addOrder(order5);

		return orderRegistry;

	}
	
	/* -----------------------------------------------------------------------*/
	/* ------------------------CREATE WAREHOUSES! ----------------------------*/
	/* -----------------------------------------------------------------------*/

	/* This method creates the three (3) warehouses of the company and adds them to the warehouse registry! 
	 * The warehouse is used for keeping track of where the vehicle is located! */
	
	public static WarehouseRegistry createWarehouses (WarehouseRegistry warehouseRegistry) {

		Warehouse warehouse1 = new Warehouse("Storgatan 1", "Lund", "22363"); // Creates warehouses!
		Warehouse warehouse2 = new Warehouse("Kr��kv��gen 2", "Link��ping", "58437");
		Warehouse warehouse3 = new Warehouse("Plogv��gen 4", "G��teborg", "40225");

		warehouseRegistry.addWarehouse(warehouse1);
		warehouseRegistry.addWarehouse(warehouse2);
		warehouseRegistry.addWarehouse(warehouse3);

		return warehouseRegistry;

	}
	
	/* -----------------------------------------------------------------------*/
	/* -------------------------- CREATE VEHICLES! ---------------------------*/
	/* -----------------------------------------------------------------------*/
	
	/* This method creates ten (10) vehicles and adds them to the vehicle registry,
	 * they are created for testing purposes and are to be considered as the companys' existing vehicles! */

	public static VehicleRegistry createVehicles (VehicleRegistry vehicleRegistry, WarehouseRegistry warehouseRegistry) {

		Vehicle vehicle1 = new Vehicle("ABC123", "Volvo V70", "Personbil", "B", 800,"5-sittsig och plats f��r 5 v��skor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(2));
		Vehicle vehicle2 = new Vehicle("GBY234", "Volvo V40", "Sportbil", "B", 700,"5-sittsig och plats f��r 3 v��skor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(2));
		Vehicle vehicle3 = new Vehicle("JER456", "Volvo S80", "Personbil", "B", 700,"5-sittsig och plats f��r 2 v��skor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(0));
		Vehicle vehicle4 = new Vehicle("SJF856", "Volvo V60", "Minibuss", "B", 700,"5-sittsig och plats f��r 4 v��skor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(1));
		Vehicle vehicle5 = new Vehicle("HFY345", "Volvo S40", "Personbil", "B", 600,"5-sittsig och plats f��r 3 v��skor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(2));
		Vehicle vehicle6 = new Vehicle("GJH876", "Volvo C30", "Personbil", "B", 600,"4-sittsig och plats f��r 2 v��skor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(0));
		Vehicle vehicle7 = new Vehicle("SHD786", "Volvo V50", "Lastbil", "B", 600,"5-sittsig och plats f��r 4 v��skor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(0));
		Vehicle vehicle8 = new Vehicle("DCG349", "Volvo XC90", "Lastbil", "B", 900,"7-sittsig och plats f��r 5 v��skor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(1));
		Vehicle vehicle9 = new Vehicle("DVT234", "Volvo XC60", "Personbil", "B", 800,"5-sittsig och plats f��r 5 v��skor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(1));
		Vehicle vehicle10 = new Vehicle("LOI765", "Volvo V70XC", "Sportbil", "B", 300,"5-sittsig och plats f��r 5 v��skor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(2));

		vehicleRegistry.addVehicle(vehicle1);
		vehicleRegistry.addVehicle(vehicle2);
		vehicleRegistry.addVehicle(vehicle3);
		vehicleRegistry.addVehicle(vehicle4);
		vehicleRegistry.addVehicle(vehicle5);
		vehicleRegistry.addVehicle(vehicle6);
		vehicleRegistry.addVehicle(vehicle7);
		vehicleRegistry.addVehicle(vehicle8);
		vehicleRegistry.addVehicle(vehicle9);
		vehicleRegistry.addVehicle(vehicle10);

		return vehicleRegistry;

	}

	/* -----------------------------------------------------------------------*/
	/* ------------------------- CREATE ACCESSORIES! -------------------------*/
	/* -----------------------------------------------------------------------*/   

	/* This method creates ten (10) accessories and adds them to the accessory registry,
	 * they are created for testing purposes and are to be considered as the companys' existing accessories! */
	
	public static AccessoryRegistry createAccessories (AccessoryRegistry accessoryRegistry) {

		Accessory accessory1 = new Accessory(productNbr = productNbr + 1, "Vajer", 100, "Bra att ha!");
		Accessory accessory2 = new Accessory(productNbr = productNbr + 1, "Prasselpresenning", 200, "3x4 meter och Passar till stort sl��p");
		Accessory accessory3 = new Accessory(productNbr = productNbr + 1, "Prasselpresenning", 150, "1,5x2 meter, Passar till litet sl��p!");
		Accessory accessory4 = new Accessory(productNbr = productNbr + 1, "Sp��nnband", 150, "4 meter");
		Accessory accessory5 = new Accessory(productNbr = productNbr + 1, "Sp��nnband", 100, "2 meter");
		Accessory accessory6 = new Accessory(productNbr = productNbr + 1, "St��dhjul", 200, "Passar till alla sl��p");
		Accessory accessory7 = new Accessory(productNbr = productNbr + 1, "St��nksk��rm", 300, "Passar alla personbilar och s��ljes 4 st");
		Accessory accessory8 = new Accessory(productNbr = productNbr + 1, "Oljefilter", 200, "Till volvomotorer");
		Accessory accessory9 = new Accessory(productNbr = productNbr + 1, "Kopplingkabel", 100, "Passar alla fordon");
		Accessory accessory10 = new Accessory(productNbr = productNbr + 1, "Luftfilter motor", 150, "Passar alla Volvo");

		accessoryRegistry.addAccessory(accessory1);
		accessoryRegistry.addAccessory(accessory2);
		accessoryRegistry.addAccessory(accessory3);
		accessoryRegistry.addAccessory(accessory4);
		accessoryRegistry.addAccessory(accessory5);
		accessoryRegistry.addAccessory(accessory6);
		accessoryRegistry.addAccessory(accessory7);
		accessoryRegistry.addAccessory(accessory8);
		accessoryRegistry.addAccessory(accessory9);
		accessoryRegistry.addAccessory(accessory10);

		return accessoryRegistry;

	}

	/* -----------------------------------------------------------------------*/
	/* ----------------------- CREATE EMPLOYEES! -----------------------------*/
	/* -----------------------------------------------------------------------*/    

	/* This method creates three (3) employees and adds them to the employee registry,
	 * they are created for testing purposes and are to be considered as the companys' existing employees! */
	
	public static EmployeeRegistry createEmployees (EmployeeRegistry employeeRegistry) {

		PermanentEmployee employee1 = new PermanentEmployee(1, "8904304455", "Jonas", "Mellstr��m", "0703435223", "gdh1@live.com", 20000);
		PermanentEmployee employee2 = new PermanentEmployee(2, "8804304455", "Malin", "Mellstr��m", "0703435221", "gdh2@live.com", 20000);
		PermanentEmployee employee3 = new PermanentEmployee(3, "8604304455", "Swante", "Mellstr��m", "0703435222", "gdh3@live.com", 20000);

		employeeRegistry.addEmployee(employee1);
		employeeRegistry.addEmployee(employee2);
		employeeRegistry.addEmployee(employee3);

		return employeeRegistry;

	}
	
	/* -----------------------------------------------------------------------*/
	/* -----------------------------------------------------------------------*/
	/* -----------------------------------------------------------------------*/  

}

