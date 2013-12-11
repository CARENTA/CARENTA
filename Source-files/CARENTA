/* This is a simple test class used for testing that all the methods work! */

public class CARENTA {

	static int orderNbr = 0;
	static int customerNbr = 0;
	static int currentDiscount = 0; 
	static String todaysDate = "2013-04-06";

	public static void main(String[] args) {		

		String bookDate1 = "2013-04-06";
		String bookDate2 = "2013-04-07";

		CustomerRegistry customerRegistry = new CustomerRegistry(); // Creates registers!
		VehicleRegistry vehicleRegistry = new VehicleRegistry();
		AccessoryRegistry accessoryRegistry = new AccessoryRegistry();
		EmployeeRegistry employeeRegistry = new EmployeeRegistry();
		OrderRegistry orderRegistry = new OrderRegistry();

		vehicleRegistry = createVehicles(vehicleRegistry); // Creates objects and stores them in the registers!
		accessoryRegistry = createAccessories(accessoryRegistry);
		customerRegistry = createCustomers(customerRegistry);
		employeeRegistry = createEmployees(employeeRegistry);

		Order order1 = createOrder(customerRegistry.getCustomer(3), vehicleRegistry.getVehicle(0), accessoryRegistry.getAccessory(3), employeeRegistry.getEmployee(0), orderRegistry, bookDate1); // Create order!
		Order order2 = createOrder(customerRegistry.getCustomer(6), vehicleRegistry.getVehicle(0), accessoryRegistry.getAccessory(2), employeeRegistry.getEmployee(2), orderRegistry, bookDate1);
		Order order3 = createOrder(customerRegistry.getCustomer(9), vehicleRegistry.getVehicle(0), accessoryRegistry.getAccessory(7), employeeRegistry.getEmployee(1), orderRegistry, bookDate2);

	}

	/* -----------------------------------------------------------------------*/
	/* -----------------------------------------------------------------------*/
	/* -----------------------------------------------------------------------*/

	public static Order createOrder(Customer customer, Vehicle vehicle, 
			Accessory accessory, Employee employee,
			OrderRegistry orderRegistry, String bookDate) {

		System.out.println("Checking if car is available...");

		if (vehicle.isBookable(bookDate)) { // If the car is available for booking at this date...

			orderNbr = orderNbr + 1; // Calculates order number!
			Product product = new Product(); // Creates the product list!
			product.addVehicleProduct(vehicle); // Adds the vehicle to the list!
			product.addAccessoryProduct(accessory); // Adds the accessory to the list!

			Order order = new Order(orderNbr, currentDiscount, product.getTotalPrice(),  // Creates the actual order...
					true, true, todaysDate, customer,
					employee, product.getProducts());

			orderRegistry.addOrder(order); // Adds the order to the order registry!
			customer.addPreviousOrder(order); // Adds this order to the customers previous orders list!
			System.out.println("Car booked! Total price is: " + product.getTotalPrice() + " and order number  is " + orderNbr +".");
			return order;
		}

		System.out.println("The car is not available!"); // If it's not available...
		return null;

	}


	/* -----------------------------------------------------------------------*/
	/* -----------------------------------------------------------------------*/
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
	/* -----------------------------------------------------------------------*/
	/* -----------------------------------------------------------------------*/

	public static VehicleRegistry createVehicles (VehicleRegistry vehicleRegistry) {

		Warehouse warehouse1 = new Warehouse("Storgatan 1", "Lund", "22363"); // Creates warehouses!
		Warehouse warehouse2 = new Warehouse("Kråkvägen 2", "Linköping", "58437");
		Warehouse warehouse3 = new Warehouse("Plogvägen 4", "Göteborg", "40225");

		Vehicle vehicle1 = new Vehicle("ABC123", "Volvo V70", "Personbil", "B", 800,"5-sittsig och plats för 5 väskor i bagageluckan", true, "2014-13-12", warehouse1); // Creates the vehicles...
		Vehicle vehicle2 = new Vehicle("GBY234", "Volvo V40", "Personbil", "B", 700,"5-sittsig och plats för 3 väskor i bagageluckan", true, "2014-13-12", warehouse2);
		Vehicle vehicle3 = new Vehicle("JER456", "Volvo S80", "Personbil", "B", 700,"5-sittsig och plats för 2 väskor i bagageluckan", true, "2014-13-12", warehouse3);
		Vehicle vehicle4 = new Vehicle("SJF856", "Volvo V60", "Personbil", "B", 700,"5-sittsig och plats för 4 väskor i bagageluckan", true, "2014-13-12", warehouse1);
		Vehicle vehicle5 = new Vehicle("HFY345", "Volvo S40", "Personbil", "B", 600,"5-sittsig och plats för 3 väskor i bagageluckan", true, "2014-13-12", warehouse2);
		Vehicle vehicle6 = new Vehicle("GJH876", "Volvo C30", "Personbil", "B", 600,"4-sittsig och plats för 2 väskor i bagageluckan", true, "2014-13-12", warehouse3);
		Vehicle vehicle7 = new Vehicle("SHD786", "Volvo V50", "Personbil", "B", 600,"5-sittsig och plats för 4 väskor i bagageluckan", true, "2014-13-12", warehouse1);
		Vehicle vehicle8 = new Vehicle("DCG349", "Volvo XC90", "Personbil", "B", 900,"7-sittsig och plats för 5 väskor i bagageluckan", true, "2014-13-12", warehouse2);
		Vehicle vehicle9 = new Vehicle("DVT234", "Volvo XC60", "Personbil", "B", 800,"5-sittsig och plats för 5 väskor i bagageluckan", true, "2014-13-12", warehouse3);
		Vehicle vehicle10 = new Vehicle("LOI765", "Volvo V70XC", "Personbil", "B", 300,"5-sittsig och plats för 5 väskor i bagageluckan", true, "2014-13-12", warehouse1);

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
	/* -----------------------------------------------------------------------*/
	/* -----------------------------------------------------------------------*/   

	public static AccessoryRegistry createAccessories (AccessoryRegistry accessoryRegistry) {

		Accessory accessory1 = new Accessory("1", 100, "Vajer", "Bra att ha!"); // Creates the accessories...
		Accessory accessory2 = new Accessory("2", 200, "Prasselpresenning", "3x4 meter och Passar till stort släp");
		Accessory accessory3 = new Accessory("3", 150, "Prasselpresenning", "1,5x2 meter, Passar till litet släp!");
		Accessory accessory4 = new Accessory("4", 150, "Spännband", "4 meter");
		Accessory accessory5 = new Accessory("5", 100, "Spännband", "2 meter");
		Accessory accessory6 = new Accessory("6", 200, "Stödhjul", "Passar till alla släp");
		Accessory accessory7 = new Accessory("7", 300, "Stänkskärm", "Passar alla personbilar och säljes 4 st");
		Accessory accessory8 = new Accessory("8", 200, "Oljefilter", "Till volvomotorer");
		Accessory accessory9 = new Accessory("9", 100, "Kopplingkabel", "Passar alla fordon");
		Accessory accessory10 = new Accessory("10", 150, "Luftfilter motor", "Passar alla Volvo");

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
	/* -----------------------------------------------------------------------*/
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
	/* -----------------------------------------------------------------------*/
	/* -----------------------------------------------------------------------*/  

}   
