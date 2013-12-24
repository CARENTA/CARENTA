import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

/* This is a simple test class used for testing that all the methods work! */

public class Controller {

	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); // Gets the current date!
	static Date date = new Date();
	static String currentDate = dateFormat.format(date);
	
	static int orderNbr = 0;

	static int currentDiscount = 0; // Current over all discount level, could be seasonal...

	static String enteredDate; // Variable containing entered rental date for order...
	static Warehouse selectedWarehouse; // Variable containing selected warehouse...
	static String selectedType; // Variable containing selected vehicle type...

	static CustomerRegistry customerRegistry = new CustomerRegistry(); // Creates registers!
	static WarehouseRegistry warehouseRegistry = new WarehouseRegistry();
	static OrderRegistry orderRegistry = new OrderRegistry();
	static VehicleRegistry vehicleRegistry = new VehicleRegistry();
	static AccessoryRegistry accessoryRegistry = new AccessoryRegistry();
	static EmployeeRegistry employeeRegistry = new EmployeeRegistry();
	
	public static void main(String[] args) {	
		
		customerRegistry = createCustomers(customerRegistry);
		warehouseRegistry = createWarehouses(warehouseRegistry);
		vehicleRegistry = createVehicles(vehicleRegistry, warehouseRegistry); // Creates objects and stores them in the registers!
		accessoryRegistry = createAccessories(accessoryRegistry);
		employeeRegistry = createEmployees(employeeRegistry);

		GUI mainGUI = new GUI(); // Creates the GUI!
			
	}

	/* -----------------------------------------------------------------------*/
	/* ----------------CALCULATE VEHICLE AVAILABILITY-------------------------*/
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
	/* --------------GET CURRENT VEHICLE TYPES -------------------------------*/
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
	/* ---------------------GET WAREHOUSE NAMES ------------------------------*/
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
	/* --------------GET SELECTED WAREHOUSE ----------------------------------*/
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
	/* ---------------FIND CUSTOMER ------------------------------------------*/
	/* -----------------------------------------------------------------------*/
	
	public String findCustomer(String enteredCustomerNbr) {
		
		for(int a = 0; a < customerRegistry.getCustomers().size(); a++) { // Check the entire registry...
			
			Customer customer = customerRegistry.getCustomer(a); // Put the current customer in an own variable...
			
			if(customer.getCustomerNbr().equals(enteredCustomerNbr)) { // If the given customer number is equal to an existing customers customer number...
				
				String customerResult = "Förnamn: " + customer.getFirstName() + "\n\n" + // Retrieve the customers information, put it together nicely and...
										"Efternamn: " + customer.getLastName() + "\n\n" +
										"Kundnummer: " + customer.getCustomerNbr() + "\n\n" +
										"Adress: " + customer.getAdress() + "\n\n" +
										"Stad: " + customer.getCity() + "\n\n" +
										"Postnummer: " + customer.getAreaCode() + "\n\n" +
										"Telefonnummer: " + customer.getPhoneNbr() + "\n\n" +
										"E-mail-adress: " + customer.getMailAdress() + "\n\n" +
										"Rabattnivå: " + customer.getDiscountLevel();
				
				return customerResult; // ... send it back!
				
			}
		}
		
		return "Kunden kunde inte hittas!"; // If there was no matching customer number!

	}
	
	/* -----------------------------------------------------------------------*/
	/* ----------------------CREATE ORDER NOT COMPLETED-----------------------*/
	/* -----------------------------------------------------------------------*/

public static void createOrder(Customer customer, Vehicle vehicle, 
			ArrayList<Accessory> accessories, Employee employee, String bookDate) {

		orderNbr = orderNbr + 1;
		int totalPrice = vehicle.getPrice();
		Accessory accessory;
		boolean isAppropriate = true;
		boolean wasSatesfied = true;
		String latestUpdate = currentDate;
		int discount = currentDiscount;
		
		for(int a = 0; a < accessories.size(); a++) {
			accessory = accessories.get(a);
			totalPrice = totalPrice + accessory.getPrice();
		}
		
		
		Order order = new Order(orderNbr, discount, totalPrice,
								isAppropriate, wasSatesfied, latestUpdate,
								customer, vehicle, employee, accessories);
		
		orderRegistry.addOrder(order);
		customer.addPreviousOrder(order);
		
	}

	/* -----------------------------------------------------------------------*/
	/* ------------------------CREATE CUSTOMERS-----------------------------*/
	/* -----------------------------------------------------------------------*/

	public static CustomerRegistry createCustomers (CustomerRegistry customerRegistry) {
		
		CompanyCustomer companyCustomer1 = new CompanyCustomer(1, "123", "Itab AB", "Hejgatan 2", "Linköping", "45357", "070734958", "order@itab.se", 2); // Creates the customers...
		CompanyCustomer companyCustomer2 = new CompanyCustomer(2, "354", "Kaffesump AB", "Högersvängen 7", "Lund", "22200", "0702332434", "anders.l@live.se", 3);
		CompanyCustomer companyCustomer3 = new CompanyCustomer(3, "623","Vågade Pojkar INC", "Genvägen 2B", "Göteborg", "45692", "0703748294", "per.j@live.se", 1);
		CompanyCustomer companyCustomer4 = new CompanyCustomer(4, "477","Skånepartiet", "Slottsgatan 6", "Linköpig", "58000", "07347283939", "stina.s@live.se", 5);
		CompanyCustomer companyCustomer5 = new CompanyCustomer(5, "333","Odd & Nicklas", "Gårdsvägen 9A", "Lund", "23422", "0704221122", "lina.m@live.se", 10);
		
		PrivateCustomer privateCustomer6 = new PrivateCustomer(6, "8906453434", "Joachim","Karlsson", "Nissevägen 2A", "Linköping", "58343", "0704532326", "jonny.k@live.se", 1);
		PrivateCustomer privateCustomer7 = new PrivateCustomer(7, "8805032323", "Alexander","Steen", "Rakavägen 4", "Linköping", "58343", "0704532326", "jonny.k@live.se", 2);
		PrivateCustomer privateCustomer8 = new PrivateCustomer(8, "9205053434", "Peter","Forsberg", "Rakavägen 4", "Linköping", "58343", "0704532326", "jonny.k@live.se", 3);
		PrivateCustomer privateCustomer9 = new PrivateCustomer(9, "9111233114", "Mats","Sundin", "Rakavägen 4", "Linköping", "58343", "0704532326", "jonny.k@live.se", 2);
		PrivateCustomer privateCustomer10 = new PrivateCustomer(10, "7201014455", "Robert","Svensson", "Rakavägen 4", "Linköping", "58343", "0704532326", "jonny.k@live.se", 1);

		customerRegistry.addCustomer(companyCustomer1); // Adds the customers to the registry...
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
	/* ------------------------CREATE CUSTOMERS-----------------------------*/
	/* -----------------------------------------------------------------------*/

	public static CustomerRegistry createCustomers (CustomerRegistry customerRegistry) {

		CompanyCustomer companycustomer1 = new CompanyCustomer("Jonny","Karlsson", "1", "Rakavägen 4", "Linköping", "58343", "0704532326", "jonny.k@live.se", 10, null ,"3920303450"); // Creates the customer...
		CompanyCustomer companycustomer2 = new CompanyCustomer("Anders","Ljung", "2", "Högersvängen 7", "Lund", "22200", "0702332434", "anders.l@live.se", 10, null ,"3403034657");
		CompanyCustomer companycustomer3 = new CompanyCustomer("Per","Jonsson", "3", "Genvägen 2", "Göteborg", "45692", "0703748294", "per.j@live.se", 10, null ,"1263648485");
		CompanyCustomer companycustomer4 = new CompanyCustomer("Stina","Svensson", "4", "Slottsgatan 6", "Linköpig", "58000", "07347283939", "stina.s@live.se", 10, null ,"6040423323");
		CompanyCustomer companycustomer5 = new CompanyCustomer("Lina","Mellström", "5", "Gårdsvägen 9", "Lund", "23422", "0704221122", "lina.m@live.se", 10, null ,"5550304467");

		PrivateCustomer privatecustomer6 = new PrivateCustomer("Joachim","Karlsson", "6", "Nissevägen", "Linköping", "58343", "0704532326", "jonny.k@live.se", 10, null ,"8906453434");
		PrivateCustomer privatecustomer7 = new PrivateCustomer("Alexander","Steen", "7", "Rakavägen 4", "Linköping", "58343", "0704532326", "jonny.k@live.se", 10, null ,"8805032323");
		PrivateCustomer privatecustomer8 = new PrivateCustomer("Peter","Forsberg", "8", "Rakavägen 4", "Linköping", "58343", "0704532326", "jonny.k@live.se", 10, null ,"9205053434");
		PrivateCustomer privatecustomer9 = new PrivateCustomer("Mats","Sundin", "9", "Rakavägen 4", "Linköping", "58343", "0704532326", "jonny.k@live.se", 10, null ,"9111233114");
		PrivateCustomer privatecustomer10 = new PrivateCustomer("Robert","Svensson", "10", "Rakavägen 4", "Linköping", "58343", "0704532326", "jonny.k@live.se", 10, null ,"7201014455");

		customerRegistry.addCustomer(companycustomer1); // Adds the customers to the registry...
		customerRegistry.addCustomer(companycustomer2);
		customerRegistry.addCustomer(companycustomer3);
		customerRegistry.addCustomer(companycustomer4);
		customerRegistry.addCustomer(companycustomer5);

		customerRegistry.addCustomer(privatecustomer6);
		customerRegistry.addCustomer(privatecustomer7);
		customerRegistry.addCustomer(privatecustomer8);
		customerRegistry.addCustomer(privatecustomer9);
		customerRegistry.addCustomer(privatecustomer10);

		return customerRegistry;

	}

	/* -----------------------------------------------------------------------*/
	/* ---------------------------CREATE WAREHOUSES--------------------------------*/
	/* -----------------------------------------------------------------------*/

	public static WarehouseRegistry createWarehouses (WarehouseRegistry warehouseRegistry) {
		
		Warehouse warehouse1 = new Warehouse("Storgatan 1", "Lund", "22363"); // Creates warehouses!
		Warehouse warehouse2 = new Warehouse("Kråkvägen 2", "Linköping", "58437");
		Warehouse warehouse3 = new Warehouse("Plogvägen 4", "Göteborg", "40225");
		
		warehouseRegistry.addWarehouse(warehouse1);
		warehouseRegistry.addWarehouse(warehouse2);
		warehouseRegistry.addWarehouse(warehouse3);
		
		return warehouseRegistry;
		
	}
	
	/* -----------------------------------------------------------------------*/
	/* ---------------------------CREATE VEHICLES----------------------------*/
	/* -----------------------------------------------------------------------*/
	
	public static VehicleRegistry createVehicles (VehicleRegistry vehicleRegistry, WarehouseRegistry warehouseRegistry) {

		Vehicle vehicle1 = new Vehicle("ABC123", "Volvo V70", "Personbil", "B", 800,"5-sittsig och plats för 5 väskor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(2)); // Creates the vehicles...
		Vehicle vehicle2 = new Vehicle("GBY234", "Volvo V40", "Sportbil", "B", 700,"5-sittsig och plats för 3 väskor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(2));
		Vehicle vehicle3 = new Vehicle("JER456", "Volvo S80", "Personbil", "B", 700,"5-sittsig och plats för 2 väskor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(0));
		Vehicle vehicle4 = new Vehicle("SJF856", "Volvo V60", "Minibuss", "B", 700,"5-sittsig och plats för 4 väskor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(1));
		Vehicle vehicle5 = new Vehicle("HFY345", "Volvo S40", "Personbil", "B", 600,"5-sittsig och plats för 3 väskor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(2));
		Vehicle vehicle6 = new Vehicle("GJH876", "Volvo C30", "Personbil", "B", 600,"4-sittsig och plats för 2 väskor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(0));
		Vehicle vehicle7 = new Vehicle("SHD786", "Volvo V50", "Lastbil", "B", 600,"5-sittsig och plats för 4 väskor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(0));
		Vehicle vehicle8 = new Vehicle("DCG349", "Volvo XC90", "Lastbil", "B", 900,"7-sittsig och plats för 5 väskor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(1));
		Vehicle vehicle9 = new Vehicle("DVT234", "Volvo XC60", "Personbil", "B", 800,"5-sittsig och plats för 5 väskor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(1));
		Vehicle vehicle10 = new Vehicle("LOI765", "Volvo V70XC", "Sportbil", "B", 300,"5-sittsig och plats för 5 väskor i bagageluckan", true, "2014-13-12", warehouseRegistry.getWarehouse(2));

		vehicleRegistry.addVehicle(vehicle1); // Adds the created vehicle to the registry!
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
	/* ------------------------------CREATE ACCESSORY----------------------*/
	/* -----------------------------------------------------------------------*/   

	public static AccessoryRegistry createAccessories (AccessoryRegistry accessoryRegistry) {

		Accessory accessory1 = new Accessory(1, 100, "Vajer", "Bra att ha!"); // Creates the accessories...
		Accessory accessory2 = new Accessory(2, 200, "Prasselpresenning", "3x4 meter och Passar till stort släp");
		Accessory accessory3 = new Accessory(3, 150, "Prasselpresenning", "1,5x2 meter, Passar till litet släp!");
		Accessory accessory4 = new Accessory(4, 150, "Spännband", "4 meter");
		Accessory accessory5 = new Accessory(5, 100, "Spännband", "2 meter");
		Accessory accessory6 = new Accessory(6, 200, "Stödhjul", "Passar till alla släp");
		Accessory accessory7 = new Accessory(7, 300, "Stänkskärm", "Passar alla personbilar och säljes 4 st");
		Accessory accessory8 = new Accessory(8, 200, "Oljefilter", "Till volvomotorer");
		Accessory accessory9 = new Accessory(9, 100, "Kopplingkabel", "Passar alla fordon");
		Accessory accessory10 = new Accessory(10, 150, "Luftfilter motor", "Passar alla Volvo");

		accessoryRegistry.addAccessory(accessory1); // Adds the accessory to the registry!
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
	/* --------------------CREATE EMPLOYEES---------------------------------*/
	/* -----------------------------------------------------------------------*/    

	public static EmployeeRegistry createEmployees (EmployeeRegistry employeeRegistry) {

		PermanentEmployee employee1 = new PermanentEmployee("1", "8904304455", "Jonas", "Mellström", "Hjulvägen 2", "gdh1@live.com", "0703435223"); // Creates the employees...
		PermanentEmployee employee2 = new PermanentEmployee("2", "8804304455", "Malin", "Mellström", "Hjulvägen 2", "gdh2@live.com", "0703435221");
		PermanentEmployee employee3 = new PermanentEmployee("3", "8604304455", "Swante", "Mellström", "Hjulvägen 2", "gdh3@live.com", "0703435222");

		employeeRegistry.addEmployee(employee1); // Adds the employee to the registry!
		employeeRegistry.addEmployee(employee2);
		employeeRegistry.addEmployee(employee3);

		return employeeRegistry;

	}

	/* -----------------------------------------------------------------------*/
	/* -------------------------FIND ACCAESSORY-------------------------------*/
	/* -----------------------------------------------------------------------*/  
	public String findAccessory(int enteredProductNbr) {

		for(int a = 0; a < accessoryRegistry.getAccessories().size(); a++) { // Searching thru the registry

			Accessory accessory = accessoryRegistry.getAccessory(a); // Put the current accessory in an own variable...

			if(accessory.getProductNbr() == (enteredProductNbr)) { // If the given product number is equal to an existing accessories product number

				String accessoryResult = "Tillbehör: " + accessory.getName() + "\n\n" + // lists the accessory information
						"Produktnummer: " + accessory.getProductNbr() + "\n\n" +
						"Pris: " + accessory.getPrice() + "\n\n" +
						"Beskrivning: " + accessory.getInfo() + "\n\n" ;

				
								return accessoryResult; // ... send it back  

			}
		}

		return "Tillbehör kunde inte hittas!"; // If there was no matching customer number!

	}
}   
