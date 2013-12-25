import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Color;

public class GUI {

	private ArrayList<Vehicle> availableVehicles = new ArrayList<Vehicle>(); // These variables need to be accessed from different methods...
	private ArrayList<Accessory> accessories = new ArrayList<Accessory>();
	private Vehicle selectedVehicle;
	private String enteredDate;

	public GUI() {

		final Controller controller = new Controller(); // Initiates link with the controller!

		final CardLayout cardLayout = new CardLayout();  // Sets current layout! 

		/* Creates the frame for the program which has the basic window features.*/

		final JFrame frame = new JFrame("CARENTA");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Creates a container that contains the panels. */

		final Container contentPane = frame.getContentPane();
		contentPane.setLayout(cardLayout);
		contentPane.setPreferredSize(new Dimension(700, 650));

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the MAIN panel! -------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel mainPanel = new JPanel(); // Panel...

		mainPanel.setLayout(null); // Standard layout...

		contentPane.add(mainPanel, "mainPanel"); // Adds the panel mainPanel to the container where "customerPanel" identifies it!

		JButton btnCustomer = new JButton("Kund"); // Buttons...
		JButton btnOrder = new JButton("Order");
		JButton btnVehicle = new JButton("Fordon");
		JButton btnAccessory = new JButton("Tillbehör");

		btnCustomer.setBounds(200, 100, 300, 75); // Set locations and set sizes...
		btnOrder.setBounds(200, 225, 300, 75);
		btnVehicle.setBounds(200, 350, 300, 75);
		btnAccessory.setBounds(200, 475, 300, 75);

		mainPanel.add(btnCustomer); // Add them to the panel...
		mainPanel.add(btnOrder);
		mainPanel.add(btnVehicle);
		mainPanel.add(btnAccessory);

		btnCustomer.addActionListener(new ActionListener() { // When clicked, switch to customerPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerPanel");
			}
		});

		btnOrder.addActionListener(new ActionListener() { // When clicked, switch to orderPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "orderPanel");
			}
		});

		btnVehicle.addActionListener(new ActionListener() { // When clicked, switch to vehiclePanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "vehiclePanel");
			}
		});

		btnAccessory.addActionListener(new ActionListener() { // When clicked, switch to accessoryPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "accessoryPanel");
			}
		});                

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the CUSTOMER panel! ---------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel customerPanel = new JPanel();

		customerPanel.setLayout(null);

		contentPane.add(customerPanel, "customerPanel");

		JButton btnSearchCustomer = new JButton("Sök kund");
		JButton btnNewCustomer = new JButton("Registrera kund");
		JButton btnBackCustomer = new JButton("Tillbaka");

		btnSearchCustomer.setBounds(200, 225, 300, 75);
		btnNewCustomer.setBounds(200, 350, 300, 75);
		btnBackCustomer.setBounds(10, 10, 150, 35);

		customerPanel.add(btnSearchCustomer);
		customerPanel.add(btnNewCustomer);
		customerPanel.add(btnBackCustomer);

		btnSearchCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerSearchPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerSearchPanel");
			}
		});

		btnNewCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerSearchPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "newCustomerPanel");
			}
		});

		btnBackCustomer.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------- Creates the CUSTOMER SEARCH panel! --------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel customerSearchPanel = new JPanel();

		customerSearchPanel.setLayout(null);

		contentPane.add(customerSearchPanel, "customerSearchPanel");

		JButton btnSearchForCustomer = new JButton("Sök kund");
		JButton btnBackSearchCustomer = new JButton("Tillbaka");

		btnSearchForCustomer.setBounds(200, 475, 300, 75);
		btnBackSearchCustomer.setBounds(10, 10, 150, 35);

		customerSearchPanel.add(btnSearchForCustomer);
		customerSearchPanel.add(btnBackSearchCustomer);

		final JTextField txtEnterCustomerNbr; // Creates search field where you input the customer number...
		txtEnterCustomerNbr = new JTextField();
		txtEnterCustomerNbr.setText("");
		txtEnterCustomerNbr.setBounds(200, 285, 300, 30);
		customerSearchPanel.add(txtEnterCustomerNbr);
		txtEnterCustomerNbr.setColumns(10);
		txtEnterCustomerNbr.setOpaque(false);

		JTextArea txtrCustomerNbr = new JTextArea();
		txtrCustomerNbr.setBackground(SystemColor.menu);
		txtrCustomerNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrCustomerNbr.setText("Kundnummer:");
		txtrCustomerNbr.setBounds(103, 207, 100, 16);
		customerSearchPanel.add(txtrCustomerNbr);
		txtrCustomerNbr.setEditable(false);   //Set the JTextArea uneditable.

		final JTextField txtEnterPersonalNbr; // Creates search field where you input the personal number...
		txtEnterPersonalNbr = new JTextField();
		txtEnterPersonalNbr.setText("");
		txtEnterPersonalNbr.setBounds(200, 200, 300, 30);
		customerSearchPanel.add(txtEnterPersonalNbr);
		txtEnterCustomerNbr.setColumns(10);

		JTextArea txtrPersonalNbr = new JTextArea();  // Creates the text next to the search field.
		txtrPersonalNbr.setEditable(false);
		txtrPersonalNbr.setBackground(Color.WHITE);
		txtrPersonalNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrPersonalNbr.setText("Personnummer:");
		txtrPersonalNbr.setBounds(103, 292, 100, 16);
		customerSearchPanel.add(txtrPersonalNbr);


		/*final JTextPane paneCustomerResult = new JTextPane();
                paneCustomerResult.setBounds(125, 50, 250, 275);
                customerSearchPanel.add(paneCustomerResult);*/


		btnSearchForCustomer.addActionListener(new ActionListener() { // When search button is pressed...
			public void actionPerformed(ActionEvent e) {

				String enterdCustomerNbr = txtEnterCustomerNbr.getText(); // Get text from search field...
				//                             String customerResult = controller.findCustomer(enterdCustomerNbr); // ... find the customer...
				/* paneCustomerResult.setText(customerResult); // ... and print the text!*/

			}
		});

		btnBackSearchCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerPanel");
			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------- Creates the NEW CUSTOMER panel! ------------------------------------------ */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel newCustomerPanel = new JPanel();
		contentPane.add(newCustomerPanel, "newCustomerPanel");
		newCustomerPanel.setLayout(null);

		JButton btnBackNewCustomer = new JButton("Tillbaka");
		JButton btnRegisterNewCustomer = new JButton("Registrera kund");

		btnBackNewCustomer.setBounds(10, 10, 150, 35);
		btnRegisterNewCustomer.setBounds(199, 525, 300, 75);

		newCustomerPanel.add(btnBackNewCustomer);
		newCustomerPanel.add(btnRegisterNewCustomer);

		JTextArea textPersonNbr = new JTextArea();  // Creates the text next to the input field.
		textPersonNbr.setBackground(SystemColor.menu);
		textPersonNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPersonNbr.setText("Personnummer:");
		textPersonNbr.setBounds(89, 115, 113, 16);
		newCustomerPanel.add(textPersonNbr);
		textPersonNbr.setEditable(false);
		
		JTextArea textFirstName = new JTextArea();
		textFirstName.setText("Förnamn:");
		textFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFirstName.setEditable(false);
		textFirstName.setBackground(Color.WHITE);
		textFirstName.setBounds(89, 165, 113, 16);
		newCustomerPanel.add(textFirstName);
		
		JTextArea textLastName = new JTextArea();
		textLastName.setText("Efternamn:");
		textLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textLastName.setEditable(false);
		textLastName.setBackground(Color.WHITE);
		textLastName.setBounds(89, 215, 113, 16);
		newCustomerPanel.add(textLastName);
		
		JTextArea textAdress = new JTextArea();
		textAdress.setText("Adress:");
		textAdress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAdress.setEditable(false);
		textAdress.setBackground(Color.WHITE);
		textAdress.setBounds(89, 265, 113, 16);
		newCustomerPanel.add(textAdress);
		
		JTextArea txtrCity = new JTextArea();
		txtrCity.setText("Stad:");
		txtrCity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrCity.setEditable(false);
		txtrCity.setBackground(Color.WHITE);
		txtrCity.setBounds(89, 315, 113, 16);
		newCustomerPanel.add(txtrCity);
		
		JTextArea txtrAreaCode = new JTextArea();
		txtrAreaCode.setText("Postkod:");
		txtrAreaCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrAreaCode.setEditable(false);
		txtrAreaCode.setBackground(Color.WHITE);
		txtrAreaCode.setBounds(89, 365, 113, 16);
		newCustomerPanel.add(txtrAreaCode);
		
		JTextArea txtrTelephoneNbr = new JTextArea();
		txtrTelephoneNbr.setText("Telefonnummer:");
		txtrTelephoneNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrTelephoneNbr.setEditable(false);
		txtrTelephoneNbr.setBackground(Color.WHITE);
		txtrTelephoneNbr.setBounds(89, 415, 113, 16);
		newCustomerPanel.add(txtrTelephoneNbr);
		
		JTextArea txtrMail = new JTextArea();
		txtrMail.setText("E-mail-adrress:");
		txtrMail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrMail.setEditable(false);
		txtrMail.setBackground(Color.WHITE);
		txtrMail.setBounds(89, 465, 113, 16);
		newCustomerPanel.add(txtrMail);
		
		final JTextField txtEnterPersonNbr; // Creates search fields where you input the information about the customer...
		txtEnterPersonNbr = new JTextField();
		txtEnterPersonNbr.setText("");
		txtEnterPersonNbr.setBounds(199, 108, 300, 30);
		newCustomerPanel.add(txtEnterPersonNbr);
		txtEnterPersonNbr.setColumns(10);

		final JTextField txtEnterFirstName;
		txtEnterFirstName = new JTextField();
		txtEnterFirstName.setText("");
		txtEnterFirstName.setBounds(199, 158, 300, 30);
		newCustomerPanel.add(txtEnterFirstName);
		txtEnterFirstName.setColumns(10);

		final JTextField txtEnterLastName; 
		txtEnterLastName= new JTextField();
		txtEnterLastName.setText("");
		txtEnterLastName.setBounds(199, 208, 300, 30);
		newCustomerPanel.add(txtEnterLastName);
		txtEnterLastName.setColumns(10);

		final JTextField txtEnterAddress; 
		txtEnterAddress = new JTextField();
		txtEnterAddress.setText("");
		txtEnterAddress.setBounds(199, 258, 300, 30);
		newCustomerPanel.add(txtEnterAddress);
		txtEnterPersonNbr.setColumns(10);

		final JTextField txtEnterCity; 
		txtEnterCity = new JTextField();
		txtEnterCity.setText("");
		txtEnterCity.setBounds(199, 308, 300, 30);
		newCustomerPanel.add(txtEnterCity);
		txtEnterCity.setColumns(10);

		final JTextField txtEnterAreaCode;
		txtEnterAreaCode = new JTextField();
		txtEnterAreaCode.setText("");
		txtEnterAreaCode.setBounds(199, 358, 300, 30);
		newCustomerPanel.add(txtEnterAreaCode);
		txtEnterAreaCode.setColumns(10);

		final JTextField txtEnterTelephoneNbr;
		txtEnterTelephoneNbr = new JTextField();
		txtEnterTelephoneNbr.setText("");
		txtEnterTelephoneNbr.setBounds(199, 408, 300, 30);
		newCustomerPanel.add(txtEnterTelephoneNbr);
		txtEnterTelephoneNbr.setColumns(10);

		final JTextField txtEnterMail; 
		txtEnterMail = new JTextField();
		txtEnterMail.setText("");
		txtEnterMail.setBounds(199, 458, 300, 30);
		newCustomerPanel.add(txtEnterMail);
		txtEnterMail.setColumns(10);
		
		btnBackNewCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerPanel");
			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------- Creates the EDIT CUSTOMER panel! ------------------------------------------ */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the ORDER panel! ------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel orderPanel = new JPanel();

		orderPanel.setLayout(null);

		contentPane.add(orderPanel, "orderPanel");

		JButton btnSearchOrder = new JButton("Sök order");
		JButton btnNewOrder = new JButton("Registrera order");
		JButton btnBackOrder = new JButton("Tillbaka");

		btnSearchOrder.setBounds(200, 225, 300, 75);
		btnNewOrder.setBounds(200, 350, 300, 75);
		btnBackOrder.setBounds(10, 10, 150, 35);

		orderPanel.add(btnSearchOrder);
		orderPanel.add(btnNewOrder);
		orderPanel.add(btnBackOrder);

		btnNewOrder.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "newOrderPanel");
			}
		});

		btnBackOrder.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ---------------------------------------- Creates the SEARCH ORDER panel! ------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel searchOrderPanel = new JPanel();

		searchOrderPanel.setLayout(null);

		contentPane.add(searchOrderPanel, "searchOrderPanel");

		final JButton btnSearchForOrder = new JButton("Sök order");
		btnSearchForOrder.setBounds(175, 400, 150, 50);
		searchOrderPanel.add(btnSearchForOrder);

		final JTextField txtEnteredOrder;
		txtEnteredOrder = new JTextField();
		txtEnteredOrder.setText("");
		txtEnteredOrder.setBounds(125, 358, 250, 30);
		searchOrderPanel.add(txtEnteredOrder);
		txtEnteredOrder.setColumns(10);

		String columnsSearchOrder[] = {"Order"};
		final DefaultTableModel modelSearchOrder = new DefaultTableModel(columnsSearchOrder,0);
		final JTable searchOrderTable = new JTable(modelSearchOrder);
		searchOrderTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		searchOrderTable.setFillsViewportHeight(true);
		searchOrderTable.setBounds(125, 75, 250, 275);
		searchOrderPanel.add(searchOrderTable);

		btnSearchForOrder.addActionListener(new ActionListener() { // When clicked, go to new order panel...
			public void actionPerformed(ActionEvent e) {

				int orderNbr = Integer.parseInt(txtEnteredOrder.getText());

				Order order = controller.orderRegistry.getOrder(orderNbr);

				modelSearchOrder.addRow(new Object[]{order.getOrderNbr()}); 
				modelSearchOrder.addRow(new Object[]{order.getDiscount()}); 
				modelSearchOrder.addRow(new Object[]{order.getTotalPrice()}); 
				modelSearchOrder.addRow(new Object[]{order.getIsAppropriate()}); 
				modelSearchOrder.addRow(new Object[]{order.getWasSatesfied()}); 
				modelSearchOrder.addRow(new Object[]{order.getLatestUpdate()}); 
				modelSearchOrder.addRow(new Object[]{order.getCustomer()}); // Add everything to the row and then add the row itself!
				modelSearchOrder.addRow(new Object[]{order.getLatestUpdate()});
				modelSearchOrder.addRow(new Object[]{order.getEmployee()});
				modelSearchOrder.addRow(new Object[]{order.getVehicle()});
				modelSearchOrder.addRow(new Object[]{order.getAccessories()});

			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ------------------------------------------- Creates the NEW ORDER panel! ------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel newOrderPanel = new JPanel();

		newOrderPanel.setLayout(null);

		contentPane.add(newOrderPanel, "newOrderPanel");

		final JButton btnEnteredDate = new JButton("Gå vidare");
		final JButton btnChooseVehicle = new JButton("Välj bil");
		final JButton btnChooseAccessory = new JButton("Gå vidare");
		final JButton btnMoreAccessory = new JButton("Lägg till ytterligare tillbehör");
		final JButton btnViewOrder = new JButton("Granska order");
		final JButton btnConfirmOrder = new JButton("Slutför order");
		final JButton btnBackNewOrder = new JButton("Tillbaka");

		btnEnteredDate.setBounds(175, 400, 150, 50);
		btnChooseVehicle.setBounds(175, 400, 150, 50);
		btnChooseAccessory.setBounds(175, 400, 150, 50);
		btnMoreAccessory.setBounds(150, 10, 200, 50);
		btnViewOrder.setBounds(175, 400, 150, 50);
		btnConfirmOrder.setBounds(175, 450, 150, 50);
		btnBackNewOrder.setBounds(10, 10, 150, 35);

		newOrderPanel.add(btnEnteredDate);
		newOrderPanel.add(btnChooseVehicle);
		newOrderPanel.add(btnChooseAccessory);
		newOrderPanel.add(btnMoreAccessory);
		newOrderPanel.add(btnViewOrder);
		newOrderPanel.add(btnConfirmOrder);
		newOrderPanel.add(btnBackNewOrder);

		btnChooseVehicle.setVisible(false);
		btnChooseAccessory.setVisible(false);
		btnMoreAccessory.setVisible(false);
		btnViewOrder.setVisible(false);
		btnConfirmOrder.setVisible(false);

		final JTextField txtEnteredDate; // Creates search field where you input text data...
		txtEnteredDate = new JTextField();
		txtEnteredDate.setText("");
		txtEnteredDate.setBounds(125, 125, 250, 30);
		newOrderPanel.add(txtEnteredDate);
		txtEnteredDate.setColumns(10);

		final JTextField txtEnteredCustomer;
		txtEnteredCustomer = new JTextField();
		txtEnteredCustomer.setText("");
		txtEnteredCustomer.setBounds(125, 358, 250, 30);
		newOrderPanel.add(txtEnteredCustomer);
		txtEnteredCustomer.setColumns(10);
		txtEnteredCustomer.setVisible(false);

		final JComboBox warehouseSelection = new JComboBox(new String[]{"Lund", "Linköping", "Göteborg"}); // Creates a combobox with selections...
		warehouseSelection.setBounds(125, 200, 250, 27);
		newOrderPanel.add(warehouseSelection);

		final JComboBox typeSelection = new JComboBox(new String[]{"Personbil", "Minibuss", "Lastbil", "Släpvagn"});
		typeSelection.setBounds(125, 275, 250, 27);
		newOrderPanel.add(typeSelection);

		final JComboBox employeeSelection = new JComboBox(new String[]{"Jonas", "Malin", "Swante"});
		employeeSelection.setBounds(125, 400, 250, 27);
		newOrderPanel.add(employeeSelection);
		employeeSelection.setVisible(false);

		/* Creates tabular fields... */

		String columnsVehicle[] = {"Modell", "Körkortskrav", "Pris", "Har krok"}; // Sets column names...
		final DefaultTableModel modelVehicle = new DefaultTableModel(columnsVehicle,0); // Creates the default tabular model...
		final JTable vehicleTable = new JTable(modelVehicle); // Creates a JTAble which will display available vehicles...
		vehicleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		vehicleTable.setFillsViewportHeight(true);
		vehicleTable.setBounds(125, 75, 250, 275);
		newOrderPanel.add(vehicleTable);
		vehicleTable.setVisible(false);

		String columnsAccessory[] = {"Namn", "Information", "Pris", "Produktnummer"};
		final DefaultTableModel modelAccessory = new DefaultTableModel(columnsAccessory,0);
		final JTable accessoryTable = new JTable(modelAccessory);
		accessoryTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		accessoryTable.setFillsViewportHeight(true);
		accessoryTable.setBounds(125, 75, 250, 275);
		newOrderPanel.add(accessoryTable);
		accessoryTable.setVisible(false);

		String columnsProducts[] = {"Namn", "Information", "Pris", "Övrigt"}; 
		final DefaultTableModel modelProducts = new DefaultTableModel(columnsProducts,0);
		final JTable productsTable = new JTable(modelProducts);
		productsTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		productsTable.setFillsViewportHeight(true);
		productsTable.setBounds(125, 75, 250, 275);
		newOrderPanel.add(productsTable);
		productsTable.setVisible(false);

		btnEnteredDate.addActionListener(new ActionListener() { // When the date and other info has been entered (button clicked)...
			public void actionPerformed(ActionEvent e) {

				txtEnteredDate.setVisible(false); // Hides previous data forms...
				warehouseSelection.setVisible(false);
				typeSelection.setVisible(false);
				btnEnteredDate.setVisible(false);

				enteredDate = txtEnteredDate.getText(); // Retrieves data from the forms...
				String selectedWarehouse = warehouseSelection.getSelectedItem().toString();
				String selectedType = typeSelection.getSelectedItem().toString();

				availableVehicles = controller.calculateVehicleAvailability(enteredDate, selectedWarehouse, selectedType); // Calculates vehicle availability with input data...                        

				Vehicle vehicle;
				String vehicleModel; // Creates temporary variables in which to store information when rendering vehicle information...
				String licenseReq;
				int price;
				String hasHook;

				for(int a = 0; a < availableVehicles.size(); a++) { // For each vehicle in the list...

					vehicle = availableVehicles.get(a); // Print the information...
					vehicleModel = vehicle.getModel();
					licenseReq = vehicle.getLicenseReq();
					price = vehicle.getPrice();

					/* We need to print the hasHook-argument in a more sensible way which is why we do this... */

					if(vehicle.hasHook()) {
						hasHook = "Ja";
					}
					else hasHook = "Nej";

					modelVehicle.addRow(new Object[]{vehicleModel, licenseReq, price, hasHook}); // Add everything to the row and then add the row itself!

				}

				vehicleTable.setVisible(true); // Show the new data forms!
				btnChooseVehicle.setVisible(true);

			}
		});

		btnChooseVehicle.addActionListener(new ActionListener() { // When the vehicle is chosen (button clicked) ...
			public void actionPerformed(ActionEvent e) {

				vehicleTable.setVisible(false); 
				btnChooseVehicle.setVisible(false);

				int vehicleNumber = vehicleTable.getSelectedRow(); // Retrieve the vehicle in question...
				selectedVehicle = availableVehicles.get(vehicleNumber); // Get it from the available vehicle list...
				selectedVehicle.setBooked(enteredDate); // Set it as booked with the entered date!

				Accessory accessory; 
				String name;
				String info;
				int price;
				int accessoryNbr;

				for(int a = 0; a < controller.accessoryRegistry.getAccessories().size(); a++) { // Generate available accessories...

					accessory = controller.accessoryRegistry.getAccessory(a);

					name = accessory.getName();
					info = accessory.getInfo();
					price = accessory.getPrice();
					accessoryNbr = accessory.getProductNbr();

					modelAccessory.addRow(new Object[]{name, info, price, accessoryNbr});

				}

				btnMoreAccessory.setVisible(true); 
				accessoryTable.setVisible(true);
				btnViewOrder.setVisible(true);

			}
		});


		btnMoreAccessory.addActionListener(new ActionListener() {  // In order to add more accessories to the purchase...
			public void actionPerformed(ActionEvent e) {

				int accessoryNumber = accessoryTable.getSelectedRow(); // Get which accessory is selected...

				Accessory accessory;
				accessory = controller.accessoryRegistry.getAccessory(accessoryNumber); // Retrieve the accessory...
				accessories.add(accessory); // Add it to the current list!

			}
		});

		btnViewOrder.addActionListener(new ActionListener() {  // When clicked, let's see the whole order... 
			public void actionPerformed(ActionEvent e) {

				btnMoreAccessory.setVisible(false);
				accessoryTable.setVisible(false);
				btnViewOrder.setVisible(false);

				modelProducts.addRow(new Object[]{selectedVehicle.getModel(), selectedVehicle.getLicenseReq(), selectedVehicle.getPrice(), selectedVehicle.hasHook()}); // Add the vehicle to the display table...

				Accessory accessory = null; 
				String name = null;
				String info = null;
				int price = 0;
				int accessoryNbr = 0;

				for(int a = 0; a < accessories.size(); a++) { // Add the accessories to the display table...

					accessory = accessories.get(a);
					name = accessory.getName();
					info = accessory.getInfo();
					price = accessory.getPrice();
					accessoryNbr = accessory.getProductNbr();

					modelProducts.addRow(new Object[]{name, info, price, accessoryNbr});

				}

				productsTable.setVisible(true);
				txtEnteredCustomer.setVisible(true);
				employeeSelection.setVisible(true);
				btnConfirmOrder.setVisible(true);

			}
		});

		btnConfirmOrder.addActionListener(new ActionListener() {  // When clicked, create the order!
			public void actionPerformed(ActionEvent e) {

				productsTable.setVisible(false);
				btnConfirmOrder.setVisible(false);
				employeeSelection.setVisible(false);
				txtEnteredCustomer.setVisible(false);

				int customerNbr = Integer.parseInt(txtEnteredCustomer.getText()); // Retrieve more data...
				Customer customer = controller.customerRegistry.getCustomer(customerNbr);

				String employeeName = employeeSelection.getSelectedItem().toString();
				Employee employee;
				Employee selectedEmployee = null;
				for(int a = 0; a < controller.employeeRegistry.getEmployees().size(); a++) { // Find the employee...
					employee = controller.employeeRegistry.getEmployee(a);
					if(employeeName.equals(employee.getFirstName())) {
						selectedEmployee = employee;
					}
				}

				controller.createOrder(customer, selectedVehicle, accessories, selectedEmployee, enteredDate); // Call the controller and create the order...

				JOptionPane.showMessageDialog(null, "Ordern är utförd!"); // Tell the user that the order has been confirmed!

				txtEnteredDate.setText(""); // Reset what's supposed to show for the next order input...
				txtEnteredDate.setVisible(true);
				warehouseSelection.setVisible(true);
				typeSelection.setVisible(true);
				btnEnteredDate.setVisible(true);

				enteredDate = null; // Reset data...
				availableVehicles = null;
				selectedVehicle = null;
				accessories.clear();

				modelVehicle.setRowCount(0); // Clear tables!

				modelAccessory.setRowCount(0);

				modelProducts.setRowCount(0);

				cardLayout.show(contentPane, "orderPanel"); // ... and return to the order menu!

			}
		});



		btnBackNewOrder.addActionListener(new ActionListener() { // When clicked, go back to order panel and...
			public void actionPerformed(ActionEvent e) {        
				cardLayout.show(contentPane, "orderPanel");

				txtEnteredDate.setText(""); // RESET ALL DATA to prevent stupid data problems, if you fail at making an order you'll have to re-do it!
				txtEnteredDate.setVisible(true);
				warehouseSelection.setVisible(true);
				typeSelection.setVisible(true);
				btnEnteredDate.setVisible(true);

				vehicleTable.setVisible(false);
				accessoryTable.setVisible(false);
				productsTable.setVisible(false);

				txtEnteredCustomer.setVisible(false);

				employeeSelection.setVisible(false);

				btnMoreAccessory.setVisible(false);
				btnChooseAccessory.setVisible(false);
				btnChooseVehicle.setVisible(false);        
				btnConfirmOrder.setVisible(false);

				DefaultTableModel modelVehicle = (DefaultTableModel) vehicleTable.getModel();
				modelVehicle.setRowCount(0);

				DefaultTableModel modelAccessory = (DefaultTableModel) accessoryTable.getModel();
				modelAccessory.setRowCount(0);

				DefaultTableModel modelProducts = (DefaultTableModel) vehicleTable.getModel();
				modelProducts.setRowCount(0);

				enteredDate = null;
				selectedVehicle = null;
				availableVehicles = null;
				accessories.clear();

			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the VEHICLE panel! ----------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel vehiclePanel = new JPanel();

		vehiclePanel.setLayout(null);

		contentPane.add(vehiclePanel, "vehiclePanel");

		JButton btnSearchVehicle = new JButton("Sök fordon");
		JButton btnNewVehicle = new JButton("Registrera fordon");
		JButton btnBackVehicle = new JButton("Tillbaka");

		btnSearchVehicle.setBounds(200, 225, 300, 75);
		btnNewVehicle.setBounds(200, 350, 300, 75);
		btnBackVehicle.setBounds(10, 10, 150, 35);

		vehiclePanel.add(btnSearchVehicle);
		vehiclePanel.add(btnNewVehicle);
		vehiclePanel.add(btnBackVehicle);

		btnBackVehicle.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ---------------------------------------- Creates the SEARCH VEHICLE panel! ----------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */




		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ------------------------------------------- Creates the NEW VEHICLE panel! ----------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */


		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ---------------------------------------------- Creates the ACCESSORY panel! ---------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel accessoryPanel = new JPanel();

		accessoryPanel.setLayout(null);

		contentPane.add(accessoryPanel, "accessoryPanel");

		JButton btnSearchAccessory = new JButton("Sök tillbehör");
		JButton btnNewAccessory = new JButton("Registrera tillbehör");
		JButton btnBackAccessory = new JButton("Tillbaka");

		btnSearchAccessory.setBounds(200, 225, 300, 75);
		btnNewAccessory.setBounds(200, 350, 300, 75);
		btnBackAccessory.setBounds(10, 10, 150, 35);

		accessoryPanel.add(btnSearchAccessory);
		accessoryPanel.add(btnNewAccessory);
		accessoryPanel.add(btnBackAccessory);

		btnBackAccessory.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});

		btnSearchAccessory.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "accessorySearchPanel");
			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ---------------------------------------- Creates the SEARCH ACCESSORY panel! --------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel accessorySearchPanel = new JPanel();

		accessorySearchPanel.setLayout(null);

		contentPane.add(accessorySearchPanel, "accessorySearchPanel");

		JButton btnSearchForAccessory = new JButton("Sök tillbehör!");
		JButton btnBackSearchAccessory = new JButton("Tillbaka");

		btnSearchForAccessory.setBounds(175, 400, 150, 50);
		btnBackSearchAccessory.setBounds(10, 10, 150, 35);

		accessorySearchPanel.add(btnSearchForAccessory);
		accessorySearchPanel.add(btnBackSearchAccessory);

		final JTextField txtEnterProductNbr; // Creates search field where you input the product number...
		txtEnterProductNbr = new JTextField();
		txtEnterProductNbr.setText("");
		txtEnterProductNbr.setBounds(125, 350, 250, 30);
		accessorySearchPanel.add(txtEnterProductNbr);
		txtEnterProductNbr.setColumns(10);

		final JTextPane paneAccessoryResult = new JTextPane();
		paneAccessoryResult.setBounds(125, 50, 250, 275);
		accessorySearchPanel.add(paneAccessoryResult);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(123, 364, -99, -11);
		accessorySearchPanel.add(textPane);

		btnSearchForAccessory.addActionListener(new ActionListener() { // When search button is pressed...
			public void actionPerformed(ActionEvent e) {

				int enterdProductNbr = Integer.parseInt(txtEnterProductNbr.getText()); // Get text from search field...
				String accessoryResult = controller.findAccessory(enterdProductNbr); // ... find the accessory...

				paneAccessoryResult.setText(accessoryResult); // ... and print the text

			}
		});
		btnBackSearchAccessory.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "accessoryPanel");
			}
		}); 




		/* -------------------------------------------------------------------------------------------------------------------- */
		/* --------------------------------------- Creates the NEW ACCESSORY panel! ------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel registerNewAccessoryPanel = new JPanel();
		contentPane.add(registerNewAccessoryPanel, "registerNewAccessoryPanel");
		registerNewAccessoryPanel.setLayout(null);

		JButton btnBackRegisterNewAccessory = new JButton("Tillbaka");
		JButton btnRegisterNewAccessory = new JButton("Registrera kund");

		btnBackRegisterNewAccessory.setBounds(10, 10, 150, 35);
		btnRegisterNewAccessory.setBounds(175, 460, 150, 25);

		registerNewAccessoryPanel.add(btnBackRegisterNewAccessory);
		registerNewAccessoryPanel.add(btnRegisterNewAccessory);

		final JTextField txtEnterAccessoryName; // Creates search field where you input the information about the customer...
		txtEnterAccessoryName = new JTextField();
		txtEnterAccessoryName.setText("");
		txtEnterAccessoryName.setBounds(175, 50, 250, 30);
		registerNewAccessoryPanel.add(txtEnterAccessoryName);
		txtEnterAccessoryName.setColumns(10);

		JTextArea txtrAccessoryName = new JTextArea();
		txtrAccessoryName.setBackground(SystemColor.window);
		txtrAccessoryName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrAccessoryName.setText("Namn");
		txtrAccessoryName.setBounds(75, 55, 100, 27);
		registerNewAccessoryPanel.add(txtrAccessoryName);

		final JTextField txtEnterAccessoryProductNbr; // Creates search field where you input the information about the customer...
		txtEnterAccessoryProductNbr = new JTextField();
		txtEnterAccessoryProductNbr.setText("");
		txtEnterAccessoryProductNbr.setBounds(175, 100, 250, 30);
		registerNewAccessoryPanel.add(txtEnterAccessoryProductNbr);
		txtEnterAccessoryProductNbr.setColumns(10);

		JTextArea txtrAccessoryProductNbr = new JTextArea();  // Creates the text next to the input field.
		txtrAccessoryProductNbr.setBackground(SystemColor.window);
		txtrAccessoryProductNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrAccessoryProductNbr.setText("Produktnummer");
		txtrAccessoryProductNbr.setBounds(75, 105, 100, 27);
		registerNewAccessoryPanel.add(txtrAccessoryProductNbr);

		final JTextField txtEnterNewAccessoryPrice; // Creates search field where you input the information about the customer...
		txtEnterNewAccessoryPrice= new JTextField();
		txtEnterNewAccessoryPrice.setText("");
		txtEnterNewAccessoryPrice.setBounds(175, 150, 250, 30);
		registerNewAccessoryPanel.add(txtEnterNewAccessoryPrice);
		txtEnterNewAccessoryPrice.setColumns(10);

		JTextArea txtrNewAccessoryPrice = new JTextArea();  // Creates the text next to the input field.
		txtrNewAccessoryPrice.setBackground(SystemColor.window);
		txtrNewAccessoryPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrNewAccessoryPrice.setText("Pris");
		txtrNewAccessoryPrice.setBounds(75, 155, 100, 27);
		registerNewAccessoryPanel.add(txtrNewAccessoryPrice);

		final JTextField txtEnterAccessoryInfo; // Creates search field where you input the information about the customer...
		txtEnterAccessoryInfo = new JTextField();
		txtEnterAccessoryInfo.setText("");
		txtEnterAccessoryInfo.setBounds(175, 200, 250, 30);
		registerNewAccessoryPanel.add(txtEnterAccessoryInfo);
		txtEnterAccessoryInfo.setColumns(10);

		JTextArea txtrAccessoryInfo = new JTextArea();  // Creates the text next to the input field.
		txtrAccessoryInfo.setBackground(SystemColor.window);
		txtrAccessoryInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrAccessoryInfo.setText("Beskrivning");
		txtrAccessoryInfo.setBounds(75, 205, 100, 27);
		registerNewAccessoryPanel.add(txtrAccessoryInfo);


		/* -------------------------------------------------------------------------------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/*Standard frame settings. */

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

	}
}
