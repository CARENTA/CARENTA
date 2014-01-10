package GUI;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument.Content;
import controller.Controller;
import objects.Accessory;
import objects.Customer;
import objects.Employee;
import objects.Order;
import objects.Product;
import objects.Vehicle;

public class OrderGUI {

	final CardLayout cardLayout;
	final Container contentPane;
	
	private ArrayList<Product> shoppingCart = new ArrayList<Product>(); // Will contain the selected products for each new order...
	private String enteredDate; // Will contain the entered date for each new order...
	private ArrayList<Vehicle> availableVehicles = new ArrayList<Vehicle>(); // Will contain the calculated available vehicles for each new order...
	private Vehicle selectedVehicle; // Will contain the selected vehicle for each new order...
	private Order order; // Used for keeping track of selected order...
	private String searchMode = null; // Used for defining search mode when searching for orders...
	
	private Controller controller;
	
	public OrderGUI(final Container contentPane, final CardLayout cardLayout, final Controller controller) {
		
		this.cardLayout = cardLayout;
		this.contentPane = contentPane;
		this.controller = controller;
		
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the ORDER panel! ------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/* ---- PANEL! ---- */

		final JPanel orderPanel = new JPanel();
		orderPanel.setLayout(null);
		contentPane.add(orderPanel, "orderPanel");

		/* ---- BUTTONS! ---- */

		JButton btnSearchOrder = new JButton("Sök order");
		btnSearchOrder.setBounds(200, 225, 300, 75);
		orderPanel.add(btnSearchOrder);

		JButton btnNewOrder = new JButton("Registrera order");
		btnNewOrder.setBounds(200, 350, 300, 75);
		orderPanel.add(btnNewOrder);

		JButton btnBackOrder = new JButton("Tillbaka");
		btnBackOrder.setBounds(10, 10, 150, 35);
		orderPanel.add(btnBackOrder);

		/* ---- ACTION LISTENERS! ---- */

		btnNewOrder.addActionListener(new ActionListener() { // When clicked, go back to new order panel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "newOrderPanel");
			}
		});

		btnSearchOrder.addActionListener(new ActionListener() { // When clicked, go to search order panel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "searchOrderPanel");
			}
		});

		btnBackOrder.addActionListener(new ActionListener() { // When clicked, go back to main panel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ---------------------------------------- Creates the SEARCH ORDER panel! ------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/* ---- PANEL! ---- */

		final JPanel searchOrderPanel = new JPanel();
		searchOrderPanel.setLayout(null);
		contentPane.add(searchOrderPanel, "searchOrderPanel");

		/* ---- BUTTONS! ---- */

		final JButton btnSearchSpecificOrder = new JButton("Sök specifik order"); // Buttons...
		btnSearchSpecificOrder.setBounds(200, 100, 300, 75); // Set locations and set sizes...
		searchOrderPanel.add(btnSearchSpecificOrder); // Add them to the panel...

		final JButton btnSearchDatesOrders = new JButton("Sök ordrar utförda ett visst datum");
		btnSearchDatesOrders.setBounds(200, 225, 300, 75);
		searchOrderPanel.add(btnSearchDatesOrders);

		final JButton btnSearchCustomerOrders = new JButton("Sök ordrar utförda av specifik kund");
		btnSearchCustomerOrders.setBounds(200, 350, 300, 75);
		searchOrderPanel.add(btnSearchCustomerOrders);

		final JButton btnSearchProductOrders = new JButton("Sök ordrar innehållandes en viss produkt");
		btnSearchProductOrders.setBounds(200, 475, 300, 75);
		searchOrderPanel.add(btnSearchProductOrders);

		final JButton btnCommitSearch = new JButton("Sök"); // Button used for the actual search!
		btnCommitSearch.setBounds(200, 450, 300, 75);
		searchOrderPanel.add(btnCommitSearch);
		btnCommitSearch.setVisible(false);

		final JButton btnRemoveOrder = new JButton("Ta bort order"); // Button used for the actual search!
		btnRemoveOrder.setBounds(200, 490, 300, 75);
		searchOrderPanel.add(btnRemoveOrder);
		btnRemoveOrder.setVisible(false);

		final JButton btnBackSearchOrder = new JButton("Tillbaka");
		btnBackSearchOrder.setBounds(10, 10, 150, 35);
		searchOrderPanel.add(btnBackSearchOrder);

		/* ---- COMBO BOXES! ---- */

		final JComboBox yearSelectionSearch = new JComboBox(new String[]{"2014", "2015", "2016"}); // Creates a combobox with selections...
		yearSelectionSearch.setBounds(200, 180, 90, 30);
		searchOrderPanel.add(yearSelectionSearch);
		yearSelectionSearch.setVisible(false);

		final JComboBox monthSelectionSearch = new JComboBox(new String[]{"Januari", "Februari", "Mars", "April", "Maj", 
				"Juni", "Juli", "Augsuti", "Oktober", "November",
		"December"}); // Creates a combobox with selections...
		monthSelectionSearch.setBounds(290, 180, 130, 30);
		searchOrderPanel.add(monthSelectionSearch);
		monthSelectionSearch.setVisible(false);

		final JComboBox daySelectionSearch = new JComboBox(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19",
				"20", "21", "22", "23", "24", "25", "26", "28", "29",
				"30", "31"}); // Creates a combobox with selections...
		daySelectionSearch.setBounds(420, 180, 80, 30);
		searchOrderPanel.add(daySelectionSearch);
		daySelectionSearch.setVisible(false);

		/* ---- TEXT FIELDS! ---- */

		final JTextField inputSearchData;
		inputSearchData = new JTextField();
		inputSearchData.setText("");
		inputSearchData.setBounds(200, 308, 300, 30);
		searchOrderPanel.add(inputSearchData);
		inputSearchData.setColumns(10);
		inputSearchData.setVisible(false);

		final JTextArea fieldDateSearch = new JTextArea();
		fieldDateSearch.setText("Ange datum:");
		fieldDateSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fieldDateSearch.setEditable(false);
		fieldDateSearch.setBackground(SystemColor.window);
		fieldDateSearch.setBounds(109, 183, 94, 25);
		searchOrderPanel.add(fieldDateSearch);
		fieldDateSearch.setVisible(false);

		/* ---- MOUSE LISTENER ---- */

		inputSearchData.addMouseListener(new MouseAdapter() { // When the input search field is pressed, remove the user instruction... 
			public void mouseClicked(MouseEvent e){
				inputSearchData.setText("");
			}
		});

		/* ---- TABLES! ---- */

		String searchColumn[] = {"Ordernummer", "Datum", "Kundnummer", "Totalt pris"}; // Creates a table header...
		final DefaultTableModel searchModel = new DefaultTableModel(searchColumn, 0); // Creates the default table model which contains no rows and the header!
		final JTable searchTable = new JTable(searchModel); // Creates the table, it will contain the serach result data!
		searchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // ... sets the table to only allow selection of one row!
		searchTable.setVisible(false); // ... hide it!

		final JScrollPane searchScrollPane = new JScrollPane(); // Create a scrollPane, will allow table to be scrollable! 
		searchScrollPane.setBounds(10, 55, 680, 365); // ... bounds!
		searchOrderPanel.add(searchScrollPane); // ... add it to the panel!
		searchScrollPane.setVisible(false); // ... hide it!

		final JTextPane specificSearchPane = new JTextPane(); // Create a text pane area which will display info about a specific order search...
		specificSearchPane.setBounds(10, 55, 680, 365); // ... bounds!
		searchOrderPanel.add(specificSearchPane); // ... add it to the panel!
		specificSearchPane.setVisible(false); // ... hide it!

		/* ---- ACTION LISTENERS! ---- */

		btnSearchSpecificOrder.addActionListener(new ActionListener() { // When the specific search button is clicked...
			public void actionPerformed(ActionEvent e) {

				btnSearchSpecificOrder.setVisible(false);  // Hide the previous objects...
				btnSearchDatesOrders.setVisible(false);
				btnSearchCustomerOrders.setVisible(false);
				btnSearchProductOrders.setVisible(false);

				inputSearchData.setVisible(true); // Show the new objects...
				btnCommitSearch.setVisible(true);

				searchMode = "specific";  // Set search mode to "specific", it's used for determine which search function the user wants to use...
				inputSearchData.setText("Ange ordernummer"); // ... set the search instruction!

			}
		}); 

		btnSearchDatesOrders.addActionListener(new ActionListener() { // When the dates search buttons is clicked...
			public void actionPerformed(ActionEvent e) {

				btnSearchSpecificOrder.setVisible(false);
				btnSearchDatesOrders.setVisible(false);
				btnSearchCustomerOrders.setVisible(false);
				btnSearchProductOrders.setVisible(false);

				btnCommitSearch.setVisible(true);

				yearSelectionSearch.setVisible(true);
				monthSelectionSearch.setVisible(true);
				daySelectionSearch.setVisible(true);
				fieldDateSearch.setVisible(true);

				searchMode = "date";

			}
		});

		btnSearchCustomerOrders.addActionListener(new ActionListener() { // When the customer search button is clicked...
			public void actionPerformed(ActionEvent e) {

				btnSearchSpecificOrder.setVisible(false);
				btnSearchDatesOrders.setVisible(false);
				btnSearchCustomerOrders.setVisible(false);
				btnSearchProductOrders.setVisible(false);

				btnCommitSearch.setVisible(true);
				inputSearchData.setVisible(true);

				searchMode = "customer";
				inputSearchData.setText("Ange kundnummer");

			}
		}); 

		btnSearchProductOrders.addActionListener(new ActionListener() { // When the products search button is clicked...
			public void actionPerformed(ActionEvent e) {

				btnSearchSpecificOrder.setVisible(false);
				btnSearchDatesOrders.setVisible(false);
				btnSearchCustomerOrders.setVisible(false);
				btnSearchProductOrders.setVisible(false);

				btnCommitSearch.setVisible(true);
				inputSearchData.setVisible(true);

				searchMode = "product";
				inputSearchData.setText("Ange produktnamn");

			}
		});

		btnCommitSearch.addActionListener(new ActionListener() { // When clicked, perform the search!
			public void actionPerformed(ActionEvent e) {

				inputSearchData.setVisible(false); // Hide old objects...
				btnCommitSearch.setVisible(false);
				yearSelectionSearch.setVisible(false);
				monthSelectionSearch.setVisible(false);
				daySelectionSearch.setVisible(false);
				fieldDateSearch.setVisible(false);

				btnRemoveOrder.setVisible(true); // Show new objects...

				Order order;
				ArrayList<Order> orderRegistry = Controller.orderRegistry.getOrders(); // Retrieve the order registry...

				String searchVariable = inputSearchData.getText(); // Get the search variable input by the user...

				if(searchMode == "specific") { // If the specific search button was pressed... 

					order = Controller.orderRegistry.getOrder(Integer.parseInt(searchVariable)); // Retrieve the order...

					specificSearchPane.setText("Ordernummer: " + order.getOrderNbr() + "\n \n" +	// Put together the data form...
							"Beställare (namn och kundnummer): " + order.getCustomer().getCustomerNbr() + "\n \n" +
							"Produkter: " + "\n \n" +
							"Totalt pris:" + order.getTotalPrice() + "\n \n" +
							"Datum då ordern utfärdades: " + order.getLatestUpdate());

					specificSearchPane.setVisible(true);
				}

				if(searchMode == "date") { // If the dates search button was pressed...  

					enteredDate = yearSelectionSearch.getSelectedItem().toString() + "/" + Integer.toString(monthSelectionSearch.getSelectedIndex() + 1) + "/" + daySelectionSearch.getSelectedItem().toString();

					for(int a = 0; a < orderRegistry.size(); a++) { // Check the entire order registry...

						order = orderRegistry.get(a);

						if(enteredDate.equals(order.getLatestUpdate()))  { // If the search variable input equals the date...

							searchModel.addRow(new Object[]{order.getOrderNbr(), order.getLatestUpdate(), order.getCustomer().getCustomerNbr(), order.getTotalPrice()});
							// Add a row to the table containing the relevant information!

						}
					}

					enteredDate = null; // RESET!
					searchScrollPane.setViewportView(searchTable); // Make the scrollPane display the search table..
					searchScrollPane.setVisible(true);
					searchTable.setVisible(true);

				}

				if(searchMode == "customer") {  // If the customer search button was pressed...  !!!!!!!! DOES NOT WORK !!!!!!!!!!!!!

					Customer customer;

					for(int a = 0; a < orderRegistry.size(); a++) { 

						order = orderRegistry.get(a);
						customer = order.getCustomer();

						if(searchVariable.equals(Integer.toString(customer.getCustomerNbr())))  {

							searchModel.addRow(new Object[]{order.getOrderNbr(), order.getLatestUpdate(), order.getCustomer().getCustomerNbr(), order.getTotalPrice()});

						}
					}

					searchScrollPane.setViewportView(searchTable);
					searchScrollPane.setVisible(true);
					searchTable.setVisible(true);

				}

				if(searchMode == "product") {  // If the product search button was pressed... !!!!!!! DOES NOT WORK !!!!!!!!!

					ArrayList<Product> products;
					Product product;


					for(int a = 0; a < orderRegistry.size(); a++) {

						System.out.println("hämtar order" + a);


						order = orderRegistry.get(a);
						products = order.getProducts();

						for(int b = 0; b < products.size(); b++ ) {
							System.out.println("hämtar produkt" + b);
							product = products.get(b);
							if(searchVariable.equals(product.getProductName()))  {

								searchModel.addRow(new Object[]{order.getOrderNbr(), order.getLatestUpdate(), order.getCustomer().getCustomerNbr(), order.getTotalPrice()});

							}
						}
					}

					searchScrollPane.setViewportView(searchTable);
					searchScrollPane.setVisible(true);
					searchTable.setVisible(true);

				}

			}
		});

		btnRemoveOrder.addActionListener(new ActionListener() { // When clicked, remove the order... !!!!!!!!!!! DOES NOT WORK !!!!!!!!!!!!
			public void actionPerformed(ActionEvent e) {


				int removeSelection = JOptionPane.showConfirmDialog(null, "Du håller på att ta bort ordern, vill du det?",
						"Varning!", JOptionPane.YES_OPTION);

				if(removeSelection == 1) { // If the user doesn't want to remove the order...
					// ... do nothing!
				}

				else if(removeSelection == 0) { // If the user wants to remove the order...
					Controller.orderRegistry.removeOrder(order); // Remove it...

					btnCommitSearch.setVisible(false); // Hide all data forms or reset them...
					btnRemoveOrder.setVisible(false);
					inputSearchData.setVisible(false);
					searchTable.setVisible(false);
					searchScrollPane.setVisible(false);
					specificSearchPane.setVisible(false);
					searchMode = null;
					specificSearchPane.setText("");
					order = null;

					btnSearchSpecificOrder.setVisible(true); // Show the search selection buttons...
					btnSearchDatesOrders.setVisible(true);
					btnSearchCustomerOrders.setVisible(true);
					btnSearchProductOrders.setVisible(true);

					cardLayout.show(contentPane, "orderPanel");

				}

			}
		});

		btnBackSearchOrder.addActionListener(new ActionListener() { // When clicked, go back to main panel...
			public void actionPerformed(ActionEvent e) {

				btnCommitSearch.setVisible(false);
				btnRemoveOrder.setVisible(false);
				inputSearchData.setVisible(false);
				searchTable.setVisible(false);
				searchScrollPane.setVisible(false);
				specificSearchPane.setVisible(false);
				yearSelectionSearch.setVisible(false);
				monthSelectionSearch.setVisible(false);
				daySelectionSearch.setVisible(false);
				fieldDateSearch.setVisible(false);
				searchMode = null;
				specificSearchPane.setText("");
				order = null;
				searchModel.setRowCount(0); // Clear tables!

				btnSearchSpecificOrder.setVisible(true);
				btnSearchDatesOrders.setVisible(true);
				btnSearchCustomerOrders.setVisible(true);
				btnSearchProductOrders.setVisible(true);

				cardLayout.show(contentPane, "orderPanel");

			}
		});		

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ------------------------------------------- Creates the NEW ORDER panel! ------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/* ---- PANEL! ---- */

		final JPanel newOrderPanel = new JPanel();
		newOrderPanel.setLayout(null);
		contentPane.add(newOrderPanel, "newOrderPanel");

		/* ---- BUTTONS! ---- */

		final JButton btnEnteredDate = new JButton("Gå vidare");
		btnEnteredDate.setBounds(200, 540, 300, 75);
		newOrderPanel.add(btnEnteredDate);

		final JButton btnChooseVehicle = new JButton("Välj bil");
		btnChooseVehicle.setBounds(200, 540, 300, 75);
		newOrderPanel.add(btnChooseVehicle);
		btnChooseVehicle.setVisible(false);

		final JButton btnChooseAccessory = new JButton("Gå vidare");
		btnChooseAccessory.setBounds(200, 540, 300, 75);
		newOrderPanel.add(btnChooseAccessory);
		btnChooseAccessory.setVisible(false);

		final JButton btnMoreAccessory = new JButton("Lägg till ytterligare tillbehör");
		btnMoreAccessory.setBounds(200, 440, 300, 75);
		newOrderPanel.add(btnMoreAccessory);
		btnMoreAccessory.setVisible(false);

		final JButton btnViewOrder = new JButton("Granska order");
		btnViewOrder.setBounds(200, 540, 300, 75);
		newOrderPanel.add(btnViewOrder);
		btnViewOrder.setVisible(false);

		final JButton btnConfirmOrder = new JButton("Slutför order");
		btnConfirmOrder.setBounds(200, 540, 300, 75);
		newOrderPanel.add(btnConfirmOrder);
		btnConfirmOrder.setVisible(false);

		final JButton btnBackNewOrder = new JButton("Tillbaka");
		btnBackNewOrder.setBounds(10, 10, 150, 35);
		newOrderPanel.add(btnBackNewOrder);

		final JTextField fieldEnteredCustomer;
		fieldEnteredCustomer = new JTextField();
		fieldEnteredCustomer.setText("");
		fieldEnteredCustomer.setBounds(200, 440, 300, 30);
		newOrderPanel.add(fieldEnteredCustomer);
		fieldEnteredCustomer.setColumns(10);
		fieldEnteredCustomer.setVisible(false);

		/* ---- COMBO BOXES! ---- */

		final JComboBox yearSelection = new JComboBox(new String[]{"2014", "2015", "2016"}); // Creates a combobox with selections...
		yearSelection.setBounds(200, 180, 90, 30);
		newOrderPanel.add(yearSelection);

		final JComboBox monthSelection = new JComboBox(new String[]{"Januari", "Februari", "Mars", "April", "Maj", 
				"Juni", "Juli", "Augsuti", "Oktober", "November",
		"December"}); // Creates a combobox with selections...
		monthSelection.setBounds(290, 180, 130, 30);
		newOrderPanel.add(monthSelection);

		final JComboBox daySelection = new JComboBox(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19",
				"20", "21", "22", "23", "24", "25", "26", "28", "29",
				"30", "31"}); // Creates a combobox with selections...
		daySelection.setBounds(420, 180, 80, 30);
		newOrderPanel.add(daySelection);

		final JComboBox warehouseSelection = new JComboBox(new String[]{"Lund", "Linköping", "Göteborg"}); // Creates a combobox with selections...
		warehouseSelection.setBounds(200, 278, 300, 30);
		newOrderPanel.add(warehouseSelection);

		final JComboBox typeSelection = new JComboBox(new String[]{"Personbil", "Minibuss", "Lastbil", "Släpvagn"});
		typeSelection.setBounds(200, 378, 300, 30);
		newOrderPanel.add(typeSelection);

		final JComboBox employeeSelection = new JComboBox(new String[]{"Jonas", "Malin", "Swante"});
		employeeSelection.setBounds(200, 485, 300, 30);
		newOrderPanel.add(employeeSelection);
		employeeSelection.setVisible(false);

		/* ---- TEXT AREAS! ---- */

		final JTextArea fieldDate = new JTextArea();
		fieldDate.setText("Ange datum:");
		fieldDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fieldDate.setEditable(false);
		fieldDate.setBackground(SystemColor.window);
		fieldDate.setBounds(109, 183, 94, 25);
		newOrderPanel.add(fieldDate);

		final JTextArea fieldWarehouse = new JTextArea();
		fieldWarehouse.setText("Välj utlämningskontor:");
		fieldWarehouse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fieldWarehouse.setEditable(false);
		fieldWarehouse.setBackground(SystemColor.window);
		fieldWarehouse.setBounds(47, 282, 162, 26);
		newOrderPanel.add(fieldWarehouse);

		final JTextArea fieldType = new JTextArea();
		fieldType.setText("Välj fordonstyp:");
		fieldType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fieldType.setEditable(false);
		fieldType.setBackground(SystemColor.window);
		fieldType.setBounds(88, 382, 140, 26);
		newOrderPanel.add(fieldType);

		final JTextArea fieldSelCustomerNbr = new JTextArea();
		fieldSelCustomerNbr.setText("Ange kundnummer:");
		fieldSelCustomerNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fieldSelCustomerNbr.setEditable(false);
		fieldSelCustomerNbr.setBackground(SystemColor.window);
		fieldSelCustomerNbr.setBounds(63, 445, 140, 19);
		newOrderPanel.add(fieldSelCustomerNbr);
		fieldSelCustomerNbr.setVisible(false);

		final JTextArea fieldEmployee = new JTextArea();
		fieldEmployee.setText("Ange handläggare:");
		fieldEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fieldEmployee.setEditable(false);
		fieldEmployee.setBackground(SystemColor.window);
		fieldEmployee.setBounds(69, 491, 134, 19);
		newOrderPanel.add(fieldEmployee);
		fieldEmployee.setVisible(false);

		/* ---- TABLES! ---- */

		String vehicleColumn[] = {"Modell","Körkortskrav","Pris","Har krok","Regnummer"};
		final DefaultTableModel vehicleModel = new DefaultTableModel(vehicleColumn, 0);
		final JTable vehicleTable = new JTable(vehicleModel);
		vehicleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		String accessoryColumn[] = {"Namn", "Information", "Pris", "Produktnummer"};
		final DefaultTableModel accessoryModel = new DefaultTableModel(accessoryColumn, 0); 		
		final JTable accessoryTable = new JTable(accessoryModel);
		accessoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		String productsColumn[] = {"Produkt", "Information", "Pris", "Identifikation"};
		final DefaultTableModel productsModel = new DefaultTableModel(productsColumn, 0); 
		final JTable productsTable = new JTable(productsModel);
		productsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		productsTable.setRowSelectionAllowed(false);
		productsTable.setFocusable(false);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(10, 55);
		scrollPane.setSize(680, 365);
		newOrderPanel.add(scrollPane);
		scrollPane.setVisible(false);


		/* ---- ACTION LISTENERS!° ---- */

		btnEnteredDate.addActionListener(new ActionListener() { // When the date and other info has been entered (button clicked)...
			public void actionPerformed(ActionEvent e) {

				String enteredYear = yearSelection.getSelectedItem().toString(); // Retrieves data from the forms...				
				String enteredMonth = Integer.toString(monthSelection.getSelectedIndex() + 1);
				String enteredDay = daySelection.getSelectedItem().toString();
				enteredDate = enteredYear + "/" + enteredMonth + "/" + enteredDay;

				// !!!!!!!!!!!!!!!!!! FIX ERROR MESSAGE ABOUT BAD DATE INPUT !!!!!!!!!!!!!!!!!!!

				String selectedWarehouse = warehouseSelection.getSelectedItem().toString();
				String selectedType = typeSelection.getSelectedItem().toString();

				availableVehicles = controller.calculateVehicleAvailability(enteredDate, selectedWarehouse, selectedType); // Calculates vehicle availability with input data...                        

				if(availableVehicles.size() != 0) { // If there are available vehicles...

					yearSelection.setVisible(false); // Hides previous data forms...
					monthSelection.setVisible(false);
					daySelection.setVisible(false);

					fieldDate.setVisible(false);
					fieldWarehouse.setVisible(false);
					fieldType.setVisible(false);
					warehouseSelection.setVisible(false);
					typeSelection.setVisible(false);
					btnEnteredDate.setVisible(false);

					Vehicle vehicle; // Creates temporary variables in which to store information when rendering vehicle information...
					String vehicleModelName;
					String licenseReq;
					int price;
					String hasHook;

					for(int a = 0; a < availableVehicles.size(); a++) { // For each vehicle in the list...

						vehicle = availableVehicles.get(a); // Print the information...
						vehicleModelName = vehicle.getProductName();
						licenseReq = vehicle.getLicenseReq();
						price = vehicle.getPrice();

						/* We need to print the hasHook-argument in a more sensible way which is why we do this... */

						if(vehicle.hasHook()) {
							hasHook = "Ja";
						}
						else hasHook = "Nej";

						vehicleModel.addRow(new Object[]{vehicleModelName, licenseReq, price, hasHook}); // Add everything to the row and then add the row itself!

					}

					scrollPane.setVisible(true);
					scrollPane.setViewportView(vehicleTable); // Make sure that the scrollPane displays the correct table...
					vehicleTable.setVisible(true); // Show the new data forms!
					btnChooseVehicle.setVisible(true);

				}

				else { JOptionPane.showMessageDialog(null, "Inga tillgängliga bilar hittades!"); } // If there's no available vehicles...

			}
		});

		btnChooseVehicle.addActionListener(new ActionListener() { // When the vehicle is chosen (button clicked) ...
			public void actionPerformed(ActionEvent e) {

				int vehicleNumber = vehicleTable.getSelectedRow(); // Retrieve the vehicle in question...

				if(vehicleNumber > -1) { // If there is a vehicle selected...

					vehicleTable.setVisible(false); 
					btnChooseVehicle.setVisible(false);

					selectedVehicle = availableVehicles.get(vehicleNumber); // Get it from the available vehicle list...
					selectedVehicle.setBooked(enteredDate); // Set it as booked with the entered date!
					shoppingCart.add(selectedVehicle); // Add it to the shopping cart...

					Accessory accessory; 
					String name;
					String info;
					int price;
					int accessoryNbr;

					for(int a = 0; a < Controller.accessoryRegistry.getAccessories().size(); a++) { // Generate available accessories...

						accessory = Controller.accessoryRegistry.getAccessory(a);

						name = accessory.getProductName();
						info = accessory.getInfoTxt();
						price = accessory.getPrice();
						accessoryNbr = accessory.getProductNbr();

						accessoryModel.addRow(new Object[]{name, info, price, accessoryNbr});

					}

					btnMoreAccessory.setVisible(true);
					scrollPane.setViewportView(accessoryTable);
					accessoryTable.setVisible(true);
					btnViewOrder.setVisible(true);

				}

				else { JOptionPane.showMessageDialog(null, "Du måste välja ett fordon!"); }

			}
		});


		btnMoreAccessory.addActionListener(new ActionListener() {  // In order to add more accessories to the purchase...
			public void actionPerformed(ActionEvent e) {

				int accessoryNumber = accessoryTable.getSelectedRow(); // Get which accessory is selected...


				if(accessoryNumber > -1) {

					Accessory accessory;
					accessory = Controller.accessoryRegistry.getAccessory(accessoryNumber); // Retrieve the accessory...
					shoppingCart.add(accessory); // Add it to the current list!
					accessoryTable.clearSelection();

				}

				else { JOptionPane.showMessageDialog(null, "Du måste välja ett tillbehör!"); }

			}
		});

		btnViewOrder.addActionListener(new ActionListener() {  // When clicked, let's see the whole order... 
			public void actionPerformed(ActionEvent e) {

				int accessoryNumber = accessoryTable.getSelectedRow(); // Get which accessory is selected...

				if(accessoryNumber > -1) {

					Accessory accessory;
					accessory = Controller.accessoryRegistry.getAccessory(accessoryNumber); // Retrieve the accessory...
					shoppingCart.add(accessory); // Add it to the current list!

				}

				btnMoreAccessory.setVisible(false);
				accessoryTable.setVisible(false);
				btnViewOrder.setVisible(false);

				Product product = null; 
				String name = null;
				String info = null;
				int price = 0;
				int accessoryNbr = 0;

				for(int a = 0; a < shoppingCart.size(); a++) { // Add the accessories to the display table...

					product = shoppingCart.get(a);
					name = product.getProductName();
					info = product.getInfoTxt();
					price = product.getPrice();

					productsModel.addRow(new Object[]{name, info, price, accessoryNbr});

				}

				productsTable.setVisible(true);
				scrollPane.setViewportView(productsTable);
				fieldEnteredCustomer.setVisible(true);
				employeeSelection.setVisible(true);
				btnConfirmOrder.setVisible(true);
				fieldSelCustomerNbr.setVisible(true);
				fieldEmployee.setVisible(true);

			}
		});

		btnConfirmOrder.addActionListener(new ActionListener() {  // When clicked, create the order!
			public void actionPerformed(ActionEvent e) {


				int customerNbr = Integer.parseInt(fieldEnteredCustomer.getText()); // Retrieve more data...

				if(customerNbr < Controller.customerRegistry.getCustomers().size() && customerNbr > -1) {

					Customer customer = Controller.customerRegistry.getCustomer(customerNbr);

					productsTable.setVisible(false);
					btnConfirmOrder.setVisible(false);
					employeeSelection.setVisible(false);
					fieldEnteredCustomer.setVisible(false);
					fieldSelCustomerNbr.setVisible(false);
					fieldEmployee.setVisible(false);

					String employeeName = employeeSelection.getSelectedItem().toString();
					Employee employee;
					Employee selectedEmployee = null;
					for(int a = 0; a < Controller.employeeRegistry.getEmployees().size(); a++) { // Find the employee...
						employee = Controller.employeeRegistry.getEmployee(a);
						if(employeeName.equals(employee.getFirstName())) {
							selectedEmployee = employee;
						}
					}

					Controller.createOrder(customer, shoppingCart, selectedEmployee); // Call the Controller and creats the order...

					// Reset what's supposed to show for the next order input...
					fieldEnteredCustomer.setText("");
					yearSelection.setVisible(true); // Hides previous data forms...
					monthSelection.setVisible(true);
					daySelection.setVisible(true);
					fieldDate.setVisible(true);
					fieldWarehouse.setVisible(true);
					fieldType.setVisible(true);
					warehouseSelection.setVisible(true);
					typeSelection.setVisible(true);
					btnEnteredDate.setVisible(true);

					enteredDate = null; // Reset data...
					availableVehicles = null;
					selectedVehicle = null;
					shoppingCart.clear();

					vehicleModel.setRowCount(0); // Clear tables!

					accessoryModel.setRowCount(0);

					productsModel.setRowCount(0);

					scrollPane.setVisible(false);

					cardLayout.show(contentPane, "orderPanel"); // ... and return to the order menu!

					JOptionPane.showMessageDialog(null, "Ordern är utförd!"); // Tell the user that the order has been confirmed!

				}

				else { JOptionPane.showMessageDialog(null, "Du måste ange ett giltigt kundnummer!"); }

			}
		});

		btnBackNewOrder.addActionListener(new ActionListener() { // When clicked...
			public void actionPerformed(ActionEvent e) {        

				int goBackSelection = JOptionPane.showConfirmDialog(null, "Du håller på att avbryta beställningen, " // Warn the user of cancelation!
						+ "ingen data kommer att sparas! \n \n Vill du avbryta?", 
						"Varning!", JOptionPane.YES_OPTION);

				if(goBackSelection == 1) { // If the user doesn't want to cancel the order...
					// ... do nothing!
				}

				else if(goBackSelection == 0) { // If the user wants to cancel the order...

					cardLayout.show(contentPane, "orderPanel");

					// RESET ALL DATA to prevent stupid data problems, if you fail at making an order you'll have to re-do it!
					fieldEnteredCustomer.setText("");
					yearSelection.setVisible(true); // Show relevant data forms...
					monthSelection.setVisible(true);
					daySelection.setVisible(true);
					fieldDate.setVisible(true);
					fieldWarehouse.setVisible(true);
					fieldType.setVisible(true);
					warehouseSelection.setVisible(true);
					typeSelection.setVisible(true);
					btnEnteredDate.setVisible(true);

					if(selectedVehicle != null) { // If there is a selected vehicle...
						selectedVehicle.removeBooked(enteredDate); // Remove the booked date!
					}

					vehicleTable.setVisible(false);
					accessoryTable.setVisible(false);
					productsTable.setVisible(false);

					fieldEnteredCustomer.setVisible(false);

					fieldSelCustomerNbr.setVisible(false);
					fieldEmployee.setVisible(false);

					employeeSelection.setVisible(false);

					btnMoreAccessory.setVisible(false);
					btnChooseAccessory.setVisible(false);
					btnChooseVehicle.setVisible(false);        
					btnConfirmOrder.setVisible(false);

					scrollPane.setVisible(false);

					vehicleModel.setRowCount(0); // Clear tables!

					accessoryModel.setRowCount(0);

					productsModel.setRowCount(0);

					enteredDate = null;
					selectedVehicle = null;
					availableVehicles = null;
					shoppingCart.clear();

				}

			}
		});
		
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

	}

	public void showGUI() {
		
		cardLayout.show(contentPane, "orderPanel");
		
	}

	/* -------------------------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------------------------- */

}
