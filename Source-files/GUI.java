import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class GUI {

	private ArrayList<Vehicle> availableVehicles = new ArrayList<Vehicle>(); // These variables need to be accessed from different methods...
	private ArrayList<Product> shoppingCart = new ArrayList<Product>();
	private Vehicle selectedVehicle;
	private String enteredDate;

	private String searchMode = null; // Used for defining search mode when searching for orders...

	public GUI() {

		final Controller controller = new Controller(); // Initiates link with the controller!

		final CardLayout cardLayout = new CardLayout();  // Sets current layout! 

		/* Creates the frame for the program which has the basic window features.*/

		final JFrame frame = new JFrame("CARENTA");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,650);

		/* Creates a container that contains the panels. */

		final Container contentPane = frame.getContentPane();
		contentPane.setLayout(cardLayout);
		contentPane.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));


		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the MAIN panel! -------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel mainPanel = new JPanel(); // Panel...

		mainPanel.setLayout(null); // Standard layout...

		contentPane.add(mainPanel, "mainPanel"); // Adds the panel mainPanel to the container where "customerPanel" identifies it!

		JButton btnCustomer = new JButton("Kund"); // Buttons...
		btnCustomer.setBounds(200, 100, 300, 75); // Set locations and set sizes...
		mainPanel.add(btnCustomer); // Add them to the panel...

		JButton btnOrder = new JButton("Order");
		btnOrder.setBounds(200, 225, 300, 75);
		mainPanel.add(btnOrder);

		JButton btnVehicle = new JButton("Fordon");
		btnVehicle.setBounds(200, 350, 300, 75);
		mainPanel.add(btnVehicle);

		JButton btnAccessory = new JButton("Tillbehör");
		btnAccessory.setBounds(200, 475, 300, 75);
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
		btnSearchCustomer.setBounds(200, 225, 300, 75);
		customerPanel.add(btnSearchCustomer);

		JButton btnNewCustomer = new JButton("Registrera kund");
		btnNewCustomer.setBounds(200, 350, 300, 75);
		customerPanel.add(btnNewCustomer);

		JButton btnBackCustomer = new JButton("Tillbaka");
		btnBackCustomer.setBounds(10, 10, 150, 35);
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
		btnSearchForCustomer.setBounds(200, 475, 300, 75);
		customerSearchPanel.add(btnSearchForCustomer);

		JButton btnBackSearchCustomer = new JButton("Tillbaka");
		btnBackSearchCustomer.setBounds(10, 10, 150, 35);
		customerSearchPanel.add(btnBackSearchCustomer);

		JTextArea txtrCustomerNbr = new JTextArea();
		txtrCustomerNbr.setBounds(103, 205, 100, 19);
		txtrCustomerNbr.setText("Kundnummer:");
		txtrCustomerNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrCustomerNbr.setBackground(SystemColor.window);
		txtrCustomerNbr.setEditable(false);
		customerSearchPanel.add(txtrCustomerNbr);

		JTextArea txtrPersonalNbr = new JTextArea();
		txtrPersonalNbr.setBounds(93, 290, 110, 19);
		txtrPersonalNbr.setText("Personnummer:");
		txtrPersonalNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrPersonalNbr.setBackground(SystemColor.window);
		txtrPersonalNbr.setEditable(false);
		customerSearchPanel.add(txtrPersonalNbr);

		final JTextField txtEnterCustomerNbr;
		txtEnterCustomerNbr = new JTextField();
		txtEnterCustomerNbr.setText("");
		txtEnterCustomerNbr.setBounds(200, 285, 300, 30);
		customerSearchPanel.add(txtEnterCustomerNbr);
		txtEnterCustomerNbr.setColumns(10);

		final JTextField txtEnterPersonalNbr; 
		txtEnterPersonalNbr = new JTextField();
		txtEnterPersonalNbr.setText("");
		txtEnterPersonalNbr.setBounds(200, 200, 300, 30);
		customerSearchPanel.add(txtEnterPersonalNbr);
		txtEnterCustomerNbr.setColumns(10);

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
		btnRegisterNewCustomer.setBounds(200, 515, 300, 75);

		newCustomerPanel.add(btnBackNewCustomer);
		newCustomerPanel.add(btnRegisterNewCustomer);

		JTextArea textPersonNbr = new JTextArea();  // Creates the text next to the input field.
		textPersonNbr.setBackground(SystemColor.window);
		textPersonNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPersonNbr.setText("Personnummer:");
		textPersonNbr.setBounds(90, 100, 113, 19);
		newCustomerPanel.add(textPersonNbr);
		textPersonNbr.setEditable(false);

		JTextArea textFirstName = new JTextArea();
		textFirstName.setText("Förnamn:");
		textFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFirstName.setEditable(false);
		textFirstName.setBackground(SystemColor.window);
		textFirstName.setBounds(132, 150, 71, 16);
		newCustomerPanel.add(textFirstName);

		JTextArea textLastName = new JTextArea();
		textLastName.setText("Efternamn:");
		textLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textLastName.setEditable(false);
		textLastName.setBackground(SystemColor.window);
		textLastName.setBounds(122, 200, 81, 16);
		newCustomerPanel.add(textLastName);

		JTextArea textAdress = new JTextArea();
		textAdress.setText("Adress:");
		textAdress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAdress.setEditable(false);
		textAdress.setBackground(SystemColor.window);
		textAdress.setBounds(145, 250, 58, 16);
		newCustomerPanel.add(textAdress);

		JTextArea txtrCity = new JTextArea();
		txtrCity.setText("Stad:");
		txtrCity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrCity.setEditable(false);
		txtrCity.setBackground(SystemColor.window);
		txtrCity.setBounds(158, 300, 45, 16);
		newCustomerPanel.add(txtrCity);

		JTextArea txtrAreaCode = new JTextArea();
		txtrAreaCode.setText("Postkod:");
		txtrAreaCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrAreaCode.setEditable(false);
		txtrAreaCode.setBackground(SystemColor.window);
		txtrAreaCode.setBounds(137, 350, 66, 16);
		newCustomerPanel.add(txtrAreaCode);

		JTextArea txtrTelephoneNbr = new JTextArea();
		txtrTelephoneNbr.setText("Telefonnummer:");
		txtrTelephoneNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrTelephoneNbr.setEditable(false);
		txtrTelephoneNbr.setBackground(SystemColor.window);
		txtrTelephoneNbr.setBounds(82, 400, 121, 16);
		newCustomerPanel.add(txtrTelephoneNbr);

		JTextArea txtrMail = new JTextArea();
		txtrMail.setText("E-mail-adrress:");
		txtrMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrMail.setEditable(false);
		txtrMail.setBackground(SystemColor.window);
		txtrMail.setBounds(90, 450, 113, 16);
		newCustomerPanel.add(txtrMail);

		final JTextField txtEnterPersonNbr;
		txtEnterPersonNbr = new JTextField();
		txtEnterPersonNbr.setText("");
		txtEnterPersonNbr.setBounds(200, 95, 300, 30);
		newCustomerPanel.add(txtEnterPersonNbr);
		txtEnterPersonNbr.setColumns(10);

		final JTextField txtEnterFirstName;
		txtEnterFirstName = new JTextField();
		txtEnterFirstName.setText("");
		txtEnterFirstName.setBounds(200, 145, 300, 30);
		newCustomerPanel.add(txtEnterFirstName);
		txtEnterFirstName.setColumns(10);

		final JTextField txtEnterLastName; 
		txtEnterLastName= new JTextField();
		txtEnterLastName.setText("");
		txtEnterLastName.setBounds(200, 195, 300, 30);
		newCustomerPanel.add(txtEnterLastName);
		txtEnterLastName.setColumns(10);

		final JTextField txtEnterAddress; 
		txtEnterAddress = new JTextField();
		txtEnterAddress.setText("");
		txtEnterAddress.setBounds(200, 245, 300, 30);
		newCustomerPanel.add(txtEnterAddress);
		txtEnterPersonNbr.setColumns(10);

		final JTextField txtEnterCity; 
		txtEnterCity = new JTextField();
		txtEnterCity.setText("");
		txtEnterCity.setBounds(200, 295, 300, 30);
		newCustomerPanel.add(txtEnterCity);
		txtEnterCity.setColumns(10);

		final JTextField txtEnterAreaCode;
		txtEnterAreaCode = new JTextField();
		txtEnterAreaCode.setText("");
		txtEnterAreaCode.setBounds(200, 345, 300, 30);
		newCustomerPanel.add(txtEnterAreaCode);
		txtEnterAreaCode.setColumns(10);

		final JTextField txtEnterTelephoneNbr;
		txtEnterTelephoneNbr = new JTextField();
		txtEnterTelephoneNbr.setText("");
		txtEnterTelephoneNbr.setBounds(200, 395, 300, 30);
		newCustomerPanel.add(txtEnterTelephoneNbr);
		txtEnterTelephoneNbr.setColumns(10);

		final JTextField txtEnterMail; 
		txtEnterMail = new JTextField();
		txtEnterMail.setText("");
		txtEnterMail.setBounds(200, 445, 300, 30);
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
		btnSearchOrder.setBounds(200, 225, 300, 75);
		orderPanel.add(btnSearchOrder);

		JButton btnNewOrder = new JButton("Registrera order");
		btnNewOrder.setBounds(200, 350, 300, 75);
		orderPanel.add(btnNewOrder);

		JButton btnBackOrder = new JButton("Tillbaka");
		btnBackOrder.setBounds(10, 10, 150, 35);
		orderPanel.add(btnBackOrder);

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

		final JPanel searchOrderPanel = new JPanel();

		searchOrderPanel.setLayout(null);

		contentPane.add(searchOrderPanel, "searchOrderPanel");

		/* ---- Buttons... ---- */

		final JButton btnSearchSpecificOrder = new JButton("Sök specifik order"); // Buttons...
		btnSearchSpecificOrder.setBounds(200, 100, 300, 75); // Set locations and set sizes...
		searchOrderPanel.add(btnSearchSpecificOrder); // Add them to the panel...

		final JButton btnSearchDatesOrders = new JButton("Sök ordrar utförda ett visst datum");
		btnSearchDatesOrders.setBounds(200, 225, 300, 75);
		searchOrderPanel.add(btnSearchDatesOrders);

		final JButton btnSearchCustomerOrders = new JButton("Sök ordrar utförda av specifik kund");
		btnSearchCustomerOrders.setBounds(200, 475, 300, 75);
		searchOrderPanel.add(btnSearchCustomerOrders);

		final JButton btnSearchProductOrders = new JButton("Sök ordrar innehållandes en viss produkt");
		btnSearchProductOrders.setBounds(200, 350, 300, 75);
		searchOrderPanel.add(btnSearchProductOrders);

		final JButton btnCommitSearch = new JButton("Sök"); // Button used for the acutal search!
		btnCommitSearch.setBounds(200, 451, 300, 75);
		searchOrderPanel.add(btnCommitSearch);
		btnCommitSearch.setVisible(false);

		final JButton btnEditOrder = new JButton("Ändra order"); // Button used for the acutal search!
		btnEditOrder.setBounds(200, 539, 300, 75);
		searchOrderPanel.add(btnEditOrder);
		btnEditOrder.setVisible(false);


		final JButton btnBackSearchOrder = new JButton("Tillbaka");
		btnBackSearchOrder.setBounds(10, 10, 150, 35);
		searchOrderPanel.add(btnBackSearchOrder);

		/* ----- TextField... ------ */

		final JTextField inputSearchData;
		inputSearchData = new JTextField();
		inputSearchData.setText("");
		inputSearchData.setBounds(200, 308, 300, 30);
		searchOrderPanel.add(inputSearchData);
		inputSearchData.setColumns(10);
		inputSearchData.setVisible(false);

		inputSearchData.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				inputSearchData.setText("");
			}
		});

		/* ----- Tabulars... ---- */

		String searchColumn[] = {"Ordernummer", "Datum", "Kundnummer", "Totalt pris"};
		final DefaultTableModel searchModel = new DefaultTableModel(searchColumn, 0); 
		final JTable searchTable = new JTable(searchModel);
		searchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchTable.setVisible(false);

		final JScrollPane searchScrollPane = new JScrollPane();
		searchScrollPane.setLocation(10, 55);
		searchScrollPane.setSize(680, 364);
		searchOrderPanel.add(searchScrollPane);
		searchScrollPane.setVisible(false);

		/* ---- Action listeners... */


		btnSearchSpecificOrder.addActionListener(new ActionListener() { // When clicked, go back to main panel...
			public void actionPerformed(ActionEvent e) {

				btnSearchSpecificOrder.setVisible(false);
				btnSearchDatesOrders.setVisible(false);
				btnSearchCustomerOrders.setVisible(false);
				btnSearchProductOrders.setVisible(false);

				btnCommitSearch.setVisible(true);
				inputSearchData.setVisible(true);

				searchMode = "specific";
				inputSearchData.setText("Ange ordernummer");

			}
		}); 


		btnSearchDatesOrders.addActionListener(new ActionListener() { // When clicked, go back to main panel...
			public void actionPerformed(ActionEvent e) {

				btnSearchSpecificOrder.setVisible(false);
				btnSearchDatesOrders.setVisible(false);
				btnSearchCustomerOrders.setVisible(false);
				btnSearchProductOrders.setVisible(false);

				btnCommitSearch.setVisible(true);
				inputSearchData.setVisible(true);

				searchMode = "date";
				inputSearchData.setText("Ange ett datum på formen YYYY/MM/DD");

			}
		});

		btnSearchCustomerOrders.addActionListener(new ActionListener() { // When clicked, go back to main panel...
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


		btnSearchProductOrders.addActionListener(new ActionListener() { // When clicked, go back to main panel...
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

		btnCommitSearch.addActionListener(new ActionListener() { // When clicked, go back to main panel...
			public void actionPerformed(ActionEvent e) {

				btnEditOrder.setVisible(true);

				Order order;
				ArrayList<Order> orderRegistry = controller.orderRegistry.getOrders();

				String searchVariable = inputSearchData.getText();

				inputSearchData.setVisible(false);

				if(searchMode == "specific") {

					/* NOT IMPLEMENTED! */

				}

				if(searchMode == "date") {


					for(int a = 0; a < orderRegistry.size(); a++) {

						order = orderRegistry.get(a);

						if(searchVariable.equals(order.getLatestUpdate()))  {

							searchModel.addRow(new Object[]{order.getOrderNbr(), order.getLatestUpdate(), order.getCustomer().getCustomerNbr(), order.getTotalPrice()});

						}
					}

					searchScrollPane.setViewportView(searchTable);
					searchScrollPane.setVisible(true);
					searchTable.setVisible(true);

				}

				if(searchMode == "customer") {

					for(int a = 0; a < orderRegistry.size(); a++) {

						order = orderRegistry.get(a);

						if(searchVariable.equals(order.getCustomer().toString()))  {

							searchModel.addRow(new Object[]{order.getOrderNbr(), order.getLatestUpdate(), order.getCustomer().getCustomerNbr(), order.getTotalPrice()});

						}
					}

					searchScrollPane.setViewportView(searchTable);
					searchScrollPane.setVisible(true);
					searchTable.setVisible(true);

				}

				if(searchMode == "product") {

					ArrayList<Product> products;
					Product product;


					for(int a = 0; a < orderRegistry.size(); a++) {

						order = orderRegistry.get(a);
						products = order.getProducts();


						for(int b = 0; b < products.size(); b++ ) {
							product = products.get(a);

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

		btnEditOrder.addActionListener(new ActionListener() { // When clicked, go back to main panel...
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnBackSearchOrder.addActionListener(new ActionListener() { // When clicked, go back to main panel...
			public void actionPerformed(ActionEvent e) {

				cardLayout.show(contentPane, "orderPanel");

				btnCommitSearch.setVisible(false);
				btnEditOrder.setVisible(false);
				inputSearchData.setVisible(false);
				searchTable.setVisible(false);
				searchScrollPane.setVisible(false);

				btnSearchSpecificOrder.setVisible(true);
				btnSearchDatesOrders.setVisible(true);
				btnSearchCustomerOrders.setVisible(true);
				btnSearchProductOrders.setVisible(true);

				searchMode = null;

			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ------------------------------------------- Creates the NEW ORDER panel! ------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel newOrderPanel = new JPanel();

		newOrderPanel.setLayout(null);

		contentPane.add(newOrderPanel, "newOrderPanel");

		/* ------- Buttons... ------- */

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

		/* ------- Textfields... ------- */

		final JTextField txtEnteredDate;
		txtEnteredDate = new JTextField();
		txtEnteredDate.setText("YYYY/MM/DD");
		txtEnteredDate.setBounds(200, 178, 300, 30);
		newOrderPanel.add(txtEnteredDate);
		txtEnteredDate.setColumns(10);

		txtEnteredDate.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				txtEnteredDate.setText("");
			}
		});

		final JTextField txtEnteredCustomer;
		txtEnteredCustomer = new JTextField();
		txtEnteredCustomer.setText("");
		txtEnteredCustomer.setBounds(200, 440, 300, 30);
		newOrderPanel.add(txtEnteredCustomer);
		txtEnteredCustomer.setColumns(10);
		txtEnteredCustomer.setVisible(false);

		/* ------- Comboboxes... ------- */

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

		/* ------- Textfields... ------- */

		final JTextArea txtrDate = new JTextArea();
		txtrDate.setText("Ange datum:");
		txtrDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrDate.setEditable(false);
		txtrDate.setBackground(SystemColor.window);
		txtrDate.setBounds(109, 183, 94, 25);
		newOrderPanel.add(txtrDate);

		final JTextArea txtrWarehouse = new JTextArea();
		txtrWarehouse.setText("Välj utlämningskontor:");
		txtrWarehouse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrWarehouse.setEditable(false);
		txtrWarehouse.setBackground(SystemColor.window);
		txtrWarehouse.setBounds(47, 282, 162, 26);
		newOrderPanel.add(txtrWarehouse);

		final JTextArea txtrType = new JTextArea();
		txtrType.setText("Välj fordonstyp:");
		txtrType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrType.setEditable(false);
		txtrType.setBackground(SystemColor.window);
		txtrType.setBounds(88, 382, 140, 26);
		newOrderPanel.add(txtrType);

		final JTextArea txtrSelCustomerNbr = new JTextArea();
		txtrSelCustomerNbr.setText("Ange kundnummer:");
		txtrSelCustomerNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrSelCustomerNbr.setEditable(false);
		txtrSelCustomerNbr.setBackground(SystemColor.window);
		txtrSelCustomerNbr.setBounds(63, 445, 140, 19);
		newOrderPanel.add(txtrSelCustomerNbr);
		txtrSelCustomerNbr.setVisible(false);

		final JTextArea txtrEmployee = new JTextArea();
		txtrEmployee.setText("Ange handläggare:");
		txtrEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrEmployee.setEditable(false);
		txtrEmployee.setBackground(SystemColor.window);
		txtrEmployee.setBounds(69, 491, 134, 19);
		newOrderPanel.add(txtrEmployee);
		txtrEmployee.setVisible(false);

		/* ------- Tabulars... ------- */

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
		scrollPane.setSize(680, 364);
		newOrderPanel.add(scrollPane);
		scrollPane.setVisible(false); 


		/* --------- Action listeners... --------- */

		btnEnteredDate.addActionListener(new ActionListener() { // When the date and other info has been entered (button clicked)...
			public void actionPerformed(ActionEvent e) {

				enteredDate = txtEnteredDate.getText(); // Retrieves data from the forms...				

				if(!enteredDate.equals("")) {

					// Error message, wrong format or illegal date input...

					String selectedWarehouse = warehouseSelection.getSelectedItem().toString();
					String selectedType = typeSelection.getSelectedItem().toString();

					availableVehicles = controller.calculateVehicleAvailability(enteredDate, selectedWarehouse, selectedType); // Calculates vehicle availability with input data...                        

					if(availableVehicles.size() != 0) { // If there are available vehicles...

						txtEnteredDate.setVisible(false); // Hides previous data forms...
						txtrDate.setVisible(false);
						txtrWarehouse.setVisible(false);
						txtrType.setVisible(false);
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

				else { JOptionPane.showMessageDialog(null, "Du måste ange ett giltigt datum!"); }

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

					for(int a = 0; a < controller.accessoryRegistry.getAccessories().size(); a++) { // Generate available accessories...

						accessory = controller.accessoryRegistry.getAccessory(a);

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
					accessory = controller.accessoryRegistry.getAccessory(accessoryNumber); // Retrieve the accessory...
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
					accessory = controller.accessoryRegistry.getAccessory(accessoryNumber); // Retrieve the accessory...
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
				txtEnteredCustomer.setVisible(true);
				employeeSelection.setVisible(true);
				btnConfirmOrder.setVisible(true);
				txtrSelCustomerNbr.setVisible(true);
				txtrEmployee.setVisible(true);

			}
		});

		btnConfirmOrder.addActionListener(new ActionListener() {  // When clicked, create the order!
			public void actionPerformed(ActionEvent e) {


				int customerNbr = Integer.parseInt(txtEnteredCustomer.getText()); // Retrieve more data...

				if(customerNbr < controller.customerRegistry.getCustomers().size() && customerNbr > -1) {

					Customer customer = controller.customerRegistry.getCustomer(customerNbr);
					
					productsTable.setVisible(false);
					btnConfirmOrder.setVisible(false);
					employeeSelection.setVisible(false);
					txtEnteredCustomer.setVisible(false);
					txtrSelCustomerNbr.setVisible(false);
					txtrEmployee.setVisible(false);

					String employeeName = employeeSelection.getSelectedItem().toString();
					Employee employee;
					Employee selectedEmployee = null;
					for(int a = 0; a < controller.employeeRegistry.getEmployees().size(); a++) { // Find the employee...
						employee = controller.employeeRegistry.getEmployee(a);
						if(employeeName.equals(employee.getFirstName())) {
							selectedEmployee = employee;
						}
					}

					Controller.createOrder(customer, shoppingCart, selectedEmployee); // Call the controller and create the order...

					txtEnteredDate.setText(""); // Reset what's supposed to show for the next order input...
					txtEnteredDate.setVisible(true);
					txtrDate.setVisible(true);
					txtrWarehouse.setVisible(true);
					txtrType.setVisible(true);
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

					txtEnteredDate.setText(""); // RESET ALL DATA to prevent stupid data problems, if you fail at making an order you'll have to re-do it!
					txtEnteredCustomer.setText("");
					txtEnteredDate.setVisible(true);
					txtrDate.setVisible(true);
					txtrWarehouse.setVisible(true);
					txtrType.setVisible(true);
					warehouseSelection.setVisible(true);
					typeSelection.setVisible(true);
					btnEnteredDate.setVisible(true);

					if(selectedVehicle != null) { // If there is a selected vehicle...
						selectedVehicle.removeBooked(enteredDate); // Remove the booked date!
					}

					vehicleTable.setVisible(false);
					accessoryTable.setVisible(false);
					productsTable.setVisible(false);

					txtEnteredDate.setText("YYYY/MM/DD");

					txtEnteredCustomer.setVisible(false);

					txtrSelCustomerNbr.setVisible(false);
					txtrEmployee.setVisible(false);

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

		btnSearchAccessory.addActionListener(new ActionListener() { // When clicked, go to accessorySearchPanel
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "accessorySearchPanel");
			}
		});

		btnNewAccessory.addActionListener(new ActionListener() { // When clicked, go to registerNewAccessoryPanel
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "registerNewAccessoryPanel");
			}
		});



		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ---------------------------------------- Creates the SEARCH ACCESSORY panel! --------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel accessorySearchPanel = new JPanel();

		accessorySearchPanel.setLayout(null);

		contentPane.add(accessorySearchPanel, "accessorySearchPanel");

		JButton btnSearchForAccessory = new JButton("Sök tillbehör");
		JButton btnBackSearchAccessory = new JButton("Tillbaka");

		btnBackSearchAccessory.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "accessoryPanel");
			}
		}); 


		btnSearchForAccessory.setBounds(200, 475, 300, 75);
		btnBackSearchAccessory.setBounds(10, 10, 150, 35);

		accessorySearchPanel.add(btnSearchForAccessory);
		accessorySearchPanel.add(btnBackSearchAccessory);

		final JTextField txtEnterProductNbr; // Creates search field where you input the product number...
		txtEnterProductNbr = new JTextField();
		txtEnterProductNbr.setText("");
		txtEnterProductNbr.setBounds(200, 420, 300, 30);
		accessorySearchPanel.add(txtEnterProductNbr);
		txtEnterProductNbr.setColumns(10);

		final JTextPane paneAccessoryResult = new JTextPane();
		paneAccessoryResult.setBounds(158, 55, 400, 335);
		accessorySearchPanel.add(paneAccessoryResult);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(123, 364, -99, -11);
		accessorySearchPanel.add(textPane);

		JButton btnChangeAccessory = new JButton("Ändra tillbehör");
		btnChangeAccessory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChangeAccessory.setBounds(200, 569, 300, 75);
		accessorySearchPanel.add(btnChangeAccessory);

		btnSearchForAccessory.addActionListener(new ActionListener() { // When search button is pressed...
			public void actionPerformed(ActionEvent e) {

				int enterdProductNbr = Integer.parseInt(txtEnterProductNbr.getText()); // Get text from search field...
				String accessoryResult = controller.findAccessory(enterdProductNbr); // ... find the accessory...

				paneAccessoryResult.setText(accessoryResult); // ... and print the text

			}
		});


		/* -------------------------------------------------------------------------------------------------------------------- */
		/* --------------------------------------- Creates the NEW ACCESSORY panel! ------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel registerNewAccessoryPanel = new JPanel();
		contentPane.add(registerNewAccessoryPanel, "registerNewAccessoryPanel");
		registerNewAccessoryPanel.setLayout(null);

		JButton btnBackRegisterNewAccessory = new JButton("Tillbaka");
		JButton btnRegisterNewAccessory = new JButton("Registrera tillbehör");

		btnBackRegisterNewAccessory.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "accessoryPanel");
			}
		}); 

		btnBackRegisterNewAccessory.setBounds(10, 10, 150, 35);
		btnRegisterNewAccessory.setBounds(200, 485, 300, 75);

		registerNewAccessoryPanel.add(btnBackRegisterNewAccessory);
		registerNewAccessoryPanel.add(btnRegisterNewAccessory);

		final JTextField txtEnterAccessoryName; // Creates search field where you input the information about the customer...
		txtEnterAccessoryName = new JTextField();
		txtEnterAccessoryName.setText("");
		txtEnterAccessoryName.setBounds(225, 74, 250, 30);
		registerNewAccessoryPanel.add(txtEnterAccessoryName);
		txtEnterAccessoryName.setColumns(10);

		JTextArea txtrAccessoryName = new JTextArea();
		txtrAccessoryName.setEditable(false);
		txtrAccessoryName.setBackground(SystemColor.window);
		txtrAccessoryName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrAccessoryName.setText("Namn");
		txtrAccessoryName.setBounds(130, 81, 100, 27);
		registerNewAccessoryPanel.add(txtrAccessoryName);

		final JTextField txtEnterAccessoryProductNbr; // Creates search field where you input the information about the customer...
		txtEnterAccessoryProductNbr = new JTextField();
		txtEnterAccessoryProductNbr.setText("");
		txtEnterAccessoryProductNbr.setBounds(225, 144, 250, 30);
		registerNewAccessoryPanel.add(txtEnterAccessoryProductNbr);
		txtEnterAccessoryProductNbr.setColumns(10);

		JTextArea txtrAccessoryProductNbr = new JTextArea();
		txtrAccessoryProductNbr.setEditable(false);
		txtrAccessoryProductNbr.setBackground(SystemColor.window);
		txtrAccessoryProductNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrAccessoryProductNbr.setText("Produktnummer");
		txtrAccessoryProductNbr.setBounds(130, 151, 100, 27);
		registerNewAccessoryPanel.add(txtrAccessoryProductNbr);

		final JTextField txtEnterNewAccessoryPrice; // Creates search field where you input the information about the customer...
		txtEnterNewAccessoryPrice= new JTextField();
		txtEnterNewAccessoryPrice.setText("");
		txtEnterNewAccessoryPrice.setBounds(225, 210, 250, 30);
		registerNewAccessoryPanel.add(txtEnterNewAccessoryPrice);
		txtEnterNewAccessoryPrice.setColumns(10);

		JTextArea txtrNewAccessoryPrice = new JTextArea();  // Creates the text next to the input field.
		txtrNewAccessoryPrice.setEditable(false);
		txtrNewAccessoryPrice.setBackground(SystemColor.window);
		txtrNewAccessoryPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrNewAccessoryPrice.setText("Pris");
		txtrNewAccessoryPrice.setBounds(130, 217, 100, 27);
		registerNewAccessoryPanel.add(txtrNewAccessoryPrice);

		final JTextField txtEnterAccessoryInfo; // Creates search field where you input the information about the customer...
		txtEnterAccessoryInfo = new JTextField();
		txtEnterAccessoryInfo.setText("");
		txtEnterAccessoryInfo.setBounds(225, 276, 250, 30);
		registerNewAccessoryPanel.add(txtEnterAccessoryInfo);
		txtEnterAccessoryInfo.setColumns(10);

		JTextArea txtrAccessoryInfo = new JTextArea();  // Creates the text next to the input field.
		txtrAccessoryInfo.setEditable(false);
		txtrAccessoryInfo.setBackground(SystemColor.window);
		txtrAccessoryInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrAccessoryInfo.setText("Beskrivning");
		txtrAccessoryInfo.setBounds(130, 283, 100, 27);
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
