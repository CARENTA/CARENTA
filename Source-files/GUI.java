import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	public GUI() {

		final Controller controller = new Controller(); // Initiates link with the controller!
		
		final CardLayout cardLayout = new CardLayout();  // Sets current layout! 

		/* Creates the frame for the program which has the basic window features.*/
		
		final JFrame frame = new JFrame("CARENTA");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Creates a container that contains the panels. */
		
		final Container contentPane = frame.getContentPane();
		contentPane.setLayout(cardLayout);
		contentPane.setPreferredSize(new Dimension(500, 500));

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
		
		btnCustomer.setBounds(175, 100, 150, 50); // Set locations and set sizes...
		btnOrder.setBounds(175, 175, 150, 50);
		btnVehicle.setBounds(175, 250, 150, 50);
		btnAccessory.setBounds(175, 325, 150, 50);

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
		
		btnSearchCustomer.setBounds(175, 175, 150, 50);
		btnNewCustomer.setBounds(175, 250, 150, 50);
		btnBackCustomer.setBounds(10, 10, 100, 25);
		
		customerPanel.add(btnSearchCustomer);
		customerPanel.add(btnNewCustomer);
		customerPanel.add(btnBackCustomer);
		
		btnSearchCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerSearchPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerSearchPanel");
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

		btnSearchForCustomer.setBounds(175, 400, 150, 50);
		btnBackSearchCustomer.setBounds(10, 10, 100, 25);

		customerSearchPanel.add(btnSearchForCustomer);
		customerSearchPanel.add(btnBackSearchCustomer);

		final JTextField txtEnterCustomerNbr; // Creates search field where you input the customer number...
		txtEnterCustomerNbr = new JTextField();
		txtEnterCustomerNbr.setText("");
		txtEnterCustomerNbr.setBounds(150, 250, 250, 30);
		customerSearchPanel.add(txtEnterCustomerNbr);
		txtEnterCustomerNbr.setColumns(10);

		JTextArea txtrCustomerNbr = new JTextArea();
		txtrCustomerNbr.setBackground(SystemColor.menu);
		txtrCustomerNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrCustomerNbr.setText("Kundnummer");
		txtrCustomerNbr.setBounds(40, 203, 100, 25);
		customerSearchPanel.add(txtrCustomerNbr);

		final JTextField txtEnterPersonalNbr; // Creates search field where you input the personal number...
		txtEnterPersonalNbr = new JTextField();
		txtEnterPersonalNbr.setText("");
		txtEnterPersonalNbr.setBounds(150, 200, 250, 30);
		customerSearchPanel.add(txtEnterPersonalNbr);
		txtEnterCustomerNbr.setColumns(10);

		JTextArea txtrPersonalNbr = new JTextArea();  // Creates the text next to the search field.
		txtrPersonalNbr.setBackground(SystemColor.menu);
		txtrPersonalNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrPersonalNbr.setText("Personnummer");
		txtrPersonalNbr.setBounds(40, 253, 100, 27);
		customerSearchPanel.add(txtrPersonalNbr);


		/*final JTextPane paneCustomerResult = new JTextPane();
                paneCustomerResult.setBounds(125, 50, 250, 275);
                customerSearchPanel.add(paneCustomerResult);*/


		btnSearchForCustomer.addActionListener(new ActionListener() { // When search button is pressed...
			public void actionPerformed(ActionEvent e) {

				String enterdCustomerNbr = txtEnterCustomerNbr.getText(); // Get text from search field...
				String customerResult = controller.findCustomer(enterdCustomerNbr); // ... find the customer...
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

		final JPanel registerNewCustomerPanel = new JPanel();
		contentPane.add(registerNewCustomerPanel, "registerNewCustomerPanel");
		registerNewCustomerPanel.setLayout(null);
		
		JButton btnBackRegisterNewCustomer = new JButton("Tillbaka");
		JButton btnRegisterNewCustomer = new JButton("Registrera kund");
		
		btnBackRegisterNewCustomer.setBounds(10, 10, 100, 25);
		btnRegisterNewCustomer.setBounds(175, 460, 150, 25);
		
		registerNewCustomerPanel.add(btnBackRegisterNewCustomer);
		registerNewCustomerPanel.add(btnRegisterNewCustomer);
		
		final JTextField txtEnterFirstName; // Creates search field where you input the information about the customer...
		txtEnterFirstName = new JTextField();
		txtEnterFirstName.setText("");
		txtEnterFirstName.setBounds(175, 50, 250, 30);
		registerNewCustomerPanel.add(txtEnterFirstName);
		txtEnterFirstName.setColumns(10);
		
		JTextArea txtrFirstName = new JTextArea();  // Creates the text next to the input field.
		txtrFirstName.setBackground(SystemColor.menu);
		txtrFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrFirstName.setText("Förnamn");
		txtrFirstName.setBounds(75, 55, 100, 27);
		registerNewCustomerPanel.add(txtrFirstName);
		
		final JTextField txtEnterSecondName; // Creates search field where you input the information about the customer...
		txtEnterSecondName = new JTextField();
		txtEnterSecondName.setText("");
		txtEnterSecondName.setBounds(175, 100, 250, 30);
		registerNewCustomerPanel.add(txtEnterSecondName);
		txtEnterSecondName.setColumns(10);
		
		JTextArea txtrSecondName = new JTextArea();  // Creates the text next to the input field.
		txtrSecondName.setBackground(SystemColor.menu);
		txtrSecondName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrSecondName.setText("Efternamn");
		txtrSecondName.setBounds(75, 105, 100, 27);
		registerNewCustomerPanel.add(txtrSecondName);
		
		final JTextField txtEnterPersonalNumber; // Creates search field where you input the information about the customer...
		txtEnterPersonalNumber= new JTextField();
		txtEnterPersonalNumber.setText("");
		txtEnterPersonalNumber.setBounds(175, 150, 250, 30);
		registerNewCustomerPanel.add(txtEnterPersonalNumber);
		txtEnterPersonalNumber.setColumns(10);
		
		JTextArea txtrPersonalNumber = new JTextArea();  // Creates the text next to the input field.
		txtrPersonalNumber.setBackground(SystemColor.menu);
		txtrPersonalNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrPersonalNumber.setText("Personnummer");
		txtrPersonalNumber.setBounds(75, 155, 100, 27);
		registerNewCustomerPanel.add(txtrPersonalNumber);
		
		final JTextField txtEnterAddress; // Creates search field where you input the information about the customer...
		txtEnterAddress = new JTextField();
		txtEnterAddress.setText("");
		txtEnterAddress.setBounds(175, 200, 250, 30);
		registerNewCustomerPanel.add(txtEnterAddress);
		txtEnterFirstName.setColumns(10);
		
		JTextArea txtrAddress = new JTextArea();  // Creates the text next to the input field.
		txtrAddress.setBackground(SystemColor.menu);
		txtrAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrAddress.setText("Gatuadress");
		txtrAddress.setBounds(75, 205, 100, 27);
		registerNewCustomerPanel.add(txtrAddress);
		
		final JTextField txtEnterCity; // Creates search field where you input the information about the customer...
		txtEnterCity = new JTextField();
		txtEnterCity.setText("");
		txtEnterCity.setBounds(175, 250, 250, 30);
		registerNewCustomerPanel.add(txtEnterCity);
		txtEnterCity.setColumns(10);
		
		JTextArea txtrCity = new JTextArea();  // Creates the text next to the input field.
		txtrCity.setBackground(SystemColor.menu);
		txtrCity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrCity.setText("Stad");
		txtrCity.setBounds(75, 255, 100, 27);
		registerNewCustomerPanel.add(txtrCity);
		
		final JTextField txtZipCode; // Creates search field where you input the information about the customer...
		txtZipCode = new JTextField();
		txtZipCode.setText("");
		txtZipCode.setBounds(175, 300, 250, 30);
		registerNewCustomerPanel.add(txtZipCode);
		txtZipCode.setColumns(10);
		
		JTextArea txtrZipCode = new JTextArea();  // Creates the text next to the input field.
		txtrZipCode.setBackground(SystemColor.menu);
		txtrZipCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrZipCode.setText("Stad");
		txtrZipCode.setBounds(75, 305, 100, 27);
		registerNewCustomerPanel.add(txtrZipCode);
		
		final JTextField txtPhoneNumber; // Creates search field where you input the information about the customer...
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setText("");
		txtPhoneNumber.setBounds(175, 350, 250, 30);
		registerNewCustomerPanel.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		JTextArea txtrPhoneNumber = new JTextArea();  // Creates the text next to the input field.
		txtrPhoneNumber.setBackground(SystemColor.menu);
		txtrPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrPhoneNumber.setText("Telefonnummer");
		txtrPhoneNumber.setBounds(75, 355, 100, 27);
		registerNewCustomerPanel.add(txtrPhoneNumber);
		
		final JTextField txtEMail; // Creates search field where you input the information about the customer...
		txtEMail = new JTextField();
		txtEMail.setText("");
		txtEMail.setBounds(175, 400, 250, 30);
		registerNewCustomerPanel.add(txtEMail);
		txtEMail.setColumns(10);
		
		JTextArea txtrEMail = new JTextArea();  // Creates the text next to the input field.
		txtrEMail.setBackground(SystemColor.menu);
		txtrEMail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrEMail.setText("E-mail");
		txtrEMail.setBounds(75, 405, 100, 27);
		registerNewCustomerPanel.add(txtrEMail);
		
		btnBackRegisterNewCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerPanel");
			}
		});
		
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the ORDER panel! ------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */
		
		final JPanel orderPanel = new JPanel();

		orderPanel.setLayout(null);
		
		contentPane.add(orderPanel, "orderPanel");
		
		JButton btnSearchOrder = new JButton("Sök order");
		JButton btnNewOrder = new JButton("Registrera order");
		JButton btnBackOrder = new JButton("Tillbaka");
		
		btnSearchOrder.setBounds(175, 175, 150, 50);
		btnNewOrder.setBounds(175, 250, 150, 50);
		btnBackOrder.setBounds(10, 10, 100, 25);
		
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
		
		
		
		
		
		
		
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ------------------------------------------- Creates the NEW ORDER panel! ------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */
		
		final JPanel newOrderPanel = new JPanel();
		
		newOrderPanel.setLayout(null);
		
		contentPane.add(newOrderPanel, "newOrderPanel");
		
		final JButton btnEnterDate = new JButton("Välj datum!");
		final JButton btnChooseWarehouse = new JButton("Välj stad!");
		final JButton btnChooseVehicleType = new JButton("Välj fordonstyp!");
		final JButton btnChooseVehicle = new JButton("Välj bil!");
		final JButton btnChooseAccessory = new JButton("Gå vidare!");
		final JButton btnConfirmOrder = new JButton("Slutför order!");
		final JButton btnBackNewOrder = new JButton("Tillbaka");
		
		btnEnterDate.setBounds(175, 400, 150, 50);
		btnChooseWarehouse.setBounds(175, 400, 150, 50);
		btnChooseVehicleType.setBounds(175, 400, 150, 50);
		btnChooseVehicle.setBounds(175, 400, 150, 50);
		btnChooseAccessory.setBounds(175, 400, 150, 50);
		btnConfirmOrder.setBounds(175, 400, 150, 50);
		btnBackNewOrder.setBounds(10, 10, 100, 25);
		
		newOrderPanel.add(btnEnterDate);
		newOrderPanel.add(btnChooseWarehouse);
		newOrderPanel.add(btnChooseVehicleType);
		newOrderPanel.add(btnChooseVehicle);
		newOrderPanel.add(btnChooseAccessory);
		newOrderPanel.add(btnChooseWarehouse);
		newOrderPanel.add(btnBackNewOrder);
		
		btnChooseWarehouse.setVisible(false);
		btnChooseVehicleType.setVisible(false);
		btnChooseVehicle.setVisible(false);
		btnChooseAccessory.setVisible(false);
		btnConfirmOrder.setVisible(false);
		
		final JTextField txtEnterDate; // Creates search field where you input the customer number...
		txtEnterDate = new JTextField();
		txtEnterDate.setText("");
		txtEnterDate.setBounds(125, 225, 250, 30);
		newOrderPanel.add(txtEnterDate);
		txtEnterDate.setColumns(10);
		
		final JList warehouseList = new JList(controller.getWarehouseNames().toArray()); // Creates a list showing warehouses...
		warehouseList.setBounds(125, 50, 250, 285);
		newOrderPanel.add(warehouseList);
		warehouseList.setVisible(false);
		
		final JList vehicleTypeList = new JList();
		vehicleTypeList.setBounds(125, 50, 250, 285);
		newOrderPanel.add(vehicleTypeList);
		vehicleTypeList.setVisible(false);
		
		final JList vehicleList = new JList();
		vehicleList.setBounds(125, 50, 250, 285);
		newOrderPanel.add(vehicleList);
		vehicleList.setVisible(false);
		
		final JList accessoryList = new JList();
		accessoryList.setBounds(125, 50, 250, 285);
		newOrderPanel.add(accessoryList);

		btnEnterDate.addActionListener(new ActionListener() { // When clicked...
			public void actionPerformed(ActionEvent e) {

				txtEnterDate.setVisible(false);
				btnEnterDate.setVisible(false);
				
				String enterDate = txtEnterDate.getText(); // Retrieves data...
				
				warehouseList.setVisible(true); // Present next step...
				btnChooseWarehouse.setVisible(true);
				
			}
		});
		
		btnChooseWarehouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				warehouseList.setVisible(false);
				btnChooseWarehouse.setVisible(false);
				
				String warehouseChoice = warehouseList.getSelectedValue().toString();
				vehicleTypeList.setListData(controller.getCurrentVehicleTypes().toArray());
				
				vehicleTypeList.setVisible(true);
				btnChooseVehicleType.setVisible(true);
				
			}
		});
		
		btnChooseVehicleType.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {

				vehicleTypeList.setVisible(false);
				btnChooseVehicleType.setVisible(false);
				
				String typeChoice = vehicleTypeList.getSelectedValue().toString();
				controller.calculateVehicleAvailability("2013", "Lund", typeChoice);
				
				
				vehicleList.setVisible(true);
				btnChooseVehicle.setVisible(true);
				
			}
		});
		
		btnBackNewOrder.addActionListener(new ActionListener() { // When clicked, go back to order panel and...
			public void actionPerformed(ActionEvent e) {	
				cardLayout.show(contentPane, "orderPanel");
				
				btnEnterDate.setVisible(true); // RESET ALL DATA to prevent to stupid data problems, if you fail at making an order you'll have to re-do it!
				txtEnterDate.setVisible(true);
				txtEnterDate.setText("");
				
				btnChooseWarehouse.setVisible(false);
				btnChooseVehicleType.setVisible(false);
				btnChooseVehicle.setVisible(false);
				btnChooseAccessory.setVisible(false);
				btnConfirmOrder.setVisible(false);
				
				warehouseList.setVisible(false);
				vehicleTypeList.setVisible(false);
				vehicleList.setVisible(false);
				accessoryList.setVisible(false);
				
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
		
		btnSearchVehicle.setBounds(175, 175, 150, 50);
		btnNewVehicle.setBounds(175, 250, 150, 50);
		btnBackVehicle.setBounds(10, 10, 100, 25);
		
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
		
		btnSearchAccessory.setBounds(175, 175, 150, 50);
		btnNewAccessory.setBounds(175, 250, 150, 50);
		btnBackAccessory.setBounds(10, 10, 100, 25);
	
		accessoryPanel.add(btnSearchAccessory);
		accessoryPanel.add(btnNewAccessory);
		accessoryPanel.add(btnBackAccessory);
		
		btnBackAccessory.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
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
                btnBackSearchAccessory.setBounds(10, 10, 100, 25);
                
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
                
                JTextPane txtpnProduktnummer = new JTextPane();
                txtpnProduktnummer.setText("Produktnummer:");
                txtpnProduktnummer.setBounds(125, 364, -110, -11);
                accessorySearchPanel.add(txtpnProduktnummer);
                
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
