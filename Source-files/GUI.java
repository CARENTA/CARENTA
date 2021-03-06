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
	private Accessory accessory;
	private Vehicle vehicle;
	
	private String searchMode = null; // Used for defining search mode when searching for orders...
	private Order order;
	
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

		btnSearchCustomer.addActionListener(new ActionListener() { // When clicked, go to customerSearchPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerSearchPanel");
			}
		});

		btnNewCustomer.addActionListener(new ActionListener() { // When clicked, go to customerSearchPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "chooseCustomerPanel");
			}
		});

		btnBackCustomer.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------- Creates the EDIT CUSTOMER panel! ------------------------------------------ */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel  editCustomerPanel = new JPanel();
		editCustomerPanel.setLayout(null);
		contentPane.add(editCustomerPanel, "editCustomerPanel");

		final JButton btnBackEditCustomer = new JButton("Tillbaka");
		final JButton btnEditCustomer = new JButton("Ändra kund");
		JButton btnDeleteCustomer = new JButton("Ta bort kund");
		final JButton btnSaveCustomer = new JButton("Spara kund");

		btnBackEditCustomer.setBounds(10, 10, 100, 25);
		btnEditCustomer.setBounds(230, 470, 270, 60);
		btnDeleteCustomer.setBounds(230, 560, 270, 60);
		btnSaveCustomer.setBounds(230, 470, 270, 60);

		editCustomerPanel.add(btnBackEditCustomer);
		editCustomerPanel.add(btnEditCustomer);
		editCustomerPanel.add(btnDeleteCustomer);
		editCustomerPanel.add(btnSaveCustomer);

		btnSaveCustomer.setVisible(false);

		final JTextField txtEditPersonalNumber; // Creates search field where you input the information about the customer...
		txtEditPersonalNumber= new JTextField();
		txtEditPersonalNumber.setText("");
		txtEditPersonalNumber.setBounds(246, 146, 250, 30);
		editCustomerPanel.add(txtEditPersonalNumber);
		txtEditPersonalNumber.setColumns(10);
		txtEditPersonalNumber.setVisible(false);
		txtEditPersonalNumber.setEditable(false);

		final JTextField txtEditFirstName; // Creates search field where you input the information about the customer...
		txtEditFirstName = new JTextField();
		txtEditFirstName.setText("");
		txtEditFirstName.setBounds(246, 54, 250, 30);
		editCustomerPanel.add(txtEditFirstName);
		txtEditFirstName.setColumns(10);
		txtEditFirstName.setVisible(false);
		txtEditFirstName.setEditable(false);

		final JTextField txtEditLastName; // Creates search field where you input the information about the customer...
		txtEditLastName = new JTextField();
		txtEditLastName.setText("");
		txtEditLastName.setBounds(246, 100, 250, 30);
		editCustomerPanel.add(txtEditLastName);
		txtEditLastName.setColumns(10);
		txtEditLastName.setVisible(false);
		txtEditLastName.setEditable(false);

		final JTextField txtEditAddress; // Creates search field where you input the information about the customer...
		txtEditAddress = new JTextField();
		txtEditAddress.setText("");
		txtEditAddress.setBounds(246, 199, 250, 30);
		editCustomerPanel.add(txtEditAddress);
		txtEditFirstName.setColumns(10);
		txtEditAddress.setEditable(false);

		final JTextField txtEditCity; // Creates search field where you input the information about the customer...
		txtEditCity = new JTextField();
		txtEditCity.setText("");
		txtEditCity.setBounds(246, 250, 250, 30);
		editCustomerPanel.add(txtEditCity);
		txtEditCity.setColumns(10);
		txtEditCity.setEditable(false);

		final JTextField txtEditAreaCode; // Creates search field where you input the information about the customer...
		txtEditAreaCode = new JTextField();
		txtEditAreaCode.setText("");
		txtEditAreaCode.setBounds(246, 299, 250, 30);
		editCustomerPanel.add(txtEditAreaCode);
		txtEditAreaCode.setColumns(10);
		txtEditAreaCode.setEditable(false);

		final JTextField txtEditPhoneNumber; // Creates search field where you input the information about the customer...
		txtEditPhoneNumber = new JTextField();
		txtEditPhoneNumber.setText("");
		txtEditPhoneNumber.setBounds(246, 349, 250, 30);
		editCustomerPanel.add(txtEditPhoneNumber);
		txtEditPhoneNumber.setColumns(10);
		txtEditPhoneNumber.setEditable(false);


		final JTextField txtEditEMail; // Creates search field where you input the information about the customer...
		txtEditEMail = new JTextField();
		txtEditEMail.setText("");
		txtEditEMail.setBounds(246, 395, 250, 30);
		editCustomerPanel.add(txtEditEMail);
		txtEditEMail.setColumns(10);
		txtEditEMail.setEditable(false);

		final JTextField txtEnterCompanyOrgNbrEdit;
		txtEnterCompanyOrgNbrEdit = new JTextField();
		txtEnterCompanyOrgNbrEdit.setText("");
		txtEnterCompanyOrgNbrEdit.setBounds(246, 146, 250, 30);
		editCustomerPanel.add(txtEnterCompanyOrgNbrEdit);
		txtEnterCompanyOrgNbrEdit.setColumns(10);
		txtEnterCompanyOrgNbrEdit.setVisible(false);
		txtEnterCompanyOrgNbrEdit.setEditable(false);

		final JTextField txtEnterCompanyNameEdit;
		txtEnterCompanyNameEdit = new JTextField();
		txtEnterCompanyNameEdit.setText("");
		txtEnterCompanyNameEdit.setBounds(246, 100, 250, 30);
		editCustomerPanel.add(txtEnterCompanyNameEdit);
		txtEnterCompanyNameEdit.setColumns(10);
		txtEnterCompanyNameEdit.setVisible(false);
		txtEnterCompanyNameEdit.setEditable(false);

		final JTextArea txtrEnterCompanyOrgNbr = new JTextArea();
		txtrEnterCompanyOrgNbr.setBackground(SystemColor.menu);
		txtrEnterCompanyOrgNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrEnterCompanyOrgNbr.setText("Organisationsnummer");
		txtrEnterCompanyOrgNbr.setBounds(93, 152, 138, 27);
		editCustomerPanel.add(txtrEnterCompanyOrgNbr);
		txtrEnterCompanyOrgNbr.setEditable(false);
		txtrEnterCompanyOrgNbr.setVisible(false);

		final JTextArea txtrEnterCompanyName = new JTextArea();
		txtrEnterCompanyName.setBackground(SystemColor.menu);
		txtrEnterCompanyName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrEnterCompanyName.setText("Företagsnamn");
		txtrEnterCompanyName.setBounds(145, 106, 86, 27);
		editCustomerPanel.add(txtrEnterCompanyName);
		txtrEnterCompanyName.setEditable(false);
		txtrEnterCompanyName.setVisible(false);

		final JTextArea txtrEditPersonalNbr = new JTextArea();  // Creates the text next to the input field.
		txtrEditPersonalNbr.setBackground(SystemColor.menu);
		txtrEditPersonalNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrEditPersonalNbr.setText("Personnummer");
		txtrEditPersonalNbr.setBounds(128, 152, 100, 27);
		editCustomerPanel.add(txtrEditPersonalNbr);
		txtrEditPersonalNbr.setEditable(false);     //Set the JTextArea uneditable.
		txtrEditPersonalNbr.setVisible(false);

		final JTextArea txtrEditFirstName = new JTextArea();  // Creates the text next to the input field.
		txtrEditFirstName.setBackground(SystemColor.menu);
		txtrEditFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrEditFirstName.setText("Förnamn");
		txtrEditFirstName.setBounds(157, 60, 74, 27);
		editCustomerPanel.add(txtrEditFirstName);
		txtrEditFirstName.setEditable(false);    //Set the JTextArea uneditable.
		txtrEditFirstName.setVisible(false);

		final JTextArea txtrEditLastName = new JTextArea();  // Creates the text next to the input field.
		txtrEditLastName.setBackground(SystemColor.menu);
		txtrEditLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrEditLastName.setText("Efternamn");
		txtrEditLastName.setBounds(157, 106, 74, 27);
		editCustomerPanel.add(txtrEditLastName);
		txtrEditLastName.setEditable(false);    //Set the JTextArea uneditable.
		txtrEditLastName.setVisible(false);

		JTextArea txtrEditAddress = new JTextArea();  // Creates the text next to the input field.
		txtrEditAddress.setBackground(SystemColor.menu);
		txtrEditAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrEditAddress.setText("Gatuadress");
		txtrEditAddress.setBounds(157, 205, 74, 27);
		editCustomerPanel.add(txtrEditAddress);
		txtrEditAddress.setEditable(false);    //Set the JTextArea uneditable.

		JTextArea txtrEditCity = new JTextArea();  // Creates the text next to the input field.
		txtrEditCity.setBackground(SystemColor.menu);
		txtrEditCity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrEditCity.setText("Stad");
		txtrEditCity.setBounds(181, 256, 47, 27);
		editCustomerPanel.add(txtrEditCity);
		txtrEditCity.setEditable(false);     //Set the JTextArea uneditable.

		JTextArea txtrEditAreaCode = new JTextArea();  // Creates the text next to the input field.
		txtrEditAreaCode.setBackground(SystemColor.menu);
		txtrEditAreaCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrEditAreaCode.setText("Postnummer");
		txtrEditAreaCode.setBounds(145, 305, 86, 27);
		editCustomerPanel.add(txtrEditAreaCode);
		txtrEditAreaCode.setEditable(false);    //Set the JTextArea uneditable.

		JTextArea txtrEditPhoneNumber = new JTextArea();  // Creates the text next to the input field.
		txtrEditPhoneNumber.setBackground(SystemColor.menu);
		txtrEditPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrEditPhoneNumber.setText("Telefonnummer");
		txtrEditPhoneNumber.setBounds(128, 355, 100, 27);
		editCustomerPanel.add(txtrEditPhoneNumber);
		txtrEditPhoneNumber.setEditable(false);     //Set the JTextArea uneditable.

		JTextArea txtrEditEMail = new JTextArea();  // Creates the text next to the input field.
		txtrEditEMail.setBackground(SystemColor.menu);
		txtrEditEMail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrEditEMail.setText("E-mail");
		txtrEditEMail.setBounds(184, 401, 47, 27);
		editCustomerPanel.add(txtrEditEMail);
		txtrEditEMail.setEditable(false);     //Set the JTextArea uneditable.



		btnEditCustomer.addActionListener(new ActionListener() { // When clicked, makes the TextFields editable.
			public void actionPerformed(ActionEvent e) {

				btnSaveCustomer.setVisible(true);
				btnEditCustomer.setVisible(false);

				txtEditPersonalNumber.setEditable(true);
				txtEditFirstName.setEditable(true);
				txtEditLastName.setEditable(true);
				txtEditAddress.setEditable(true);
				txtEditCity.setEditable(true);
				txtEditAreaCode.setEditable(true);
				txtEditPhoneNumber.setEditable(true);
				txtEditEMail.setEditable(true);
				txtEnterCompanyOrgNbrEdit.setEditable(true);
				txtEnterCompanyNameEdit.setEditable(true);


			}
		});
		btnBackEditCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerPanel");

				btnSaveCustomer.setVisible(false);

				txtEditPersonalNumber.setText("");
				txtEditFirstName.setText("");
				txtEditLastName.setText("");
				txtEditAddress.setText("");
				txtEditCity.setText("");
				txtEditAreaCode.setText("");
				txtEditPhoneNumber.setText("");
				txtEditEMail.setText("");
				txtEnterCompanyOrgNbrEdit.setText("");
				txtEnterCompanyNameEdit.setText("");


				txtEditPersonalNumber.setEditable(false);
				txtEditFirstName.setEditable(false);
				txtEditLastName.setEditable(false);
				txtEditAddress.setEditable(false);
				txtEditCity.setEditable(false);
				txtEditAreaCode.setEditable(false);
				txtEditPhoneNumber.setEditable(false);
				txtEditEMail.setEditable(false);
				txtEnterCompanyOrgNbrEdit.setEditable(false);
				txtEnterCompanyNameEdit.setEditable(false);

			}
		});

		btnSaveCustomer.addActionListener(new ActionListener() { // When clicked, makes the TextFields editable.
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerPanel");


				if (customer instanceof PrivateCustomer){

					PrivateCustomer privateCustomer = (PrivateCustomer)customer;

					privateCustomer.setIDNbr(txtEditPersonalNumber.getText());
					privateCustomer.setFirstName(txtEditFirstName.getText());
					privateCustomer.setLastName(txtEditLastName.getText());
					privateCustomer.setAdress(txtEditAddress.getText());
					privateCustomer.setCity(txtEditCity.getText());
					privateCustomer.setAreaCode(txtEditAreaCode.getText());
					privateCustomer.setPhoneNbr(txtEditPhoneNumber.getText());
					privateCustomer.setMailAdress(txtEditEMail.getText());

				}

				if (customer instanceof CompanyCustomer){

					CompanyCustomer companyCustomer = (CompanyCustomer)customer;

					companyCustomer.setIDNbr(txtEnterCompanyOrgNbrEdit.getText());
					companyCustomer.setCompanyName(txtEnterCompanyNameEdit.getText());
					companyCustomer.setAdress(txtEditAddress.getText());
					companyCustomer.setCity(txtEditCity.getText());
					companyCustomer.setAreaCode(txtEditAreaCode.getText());
					companyCustomer.setPhoneNbr(txtEditPhoneNumber.getText());
					companyCustomer.setMailAdress(txtEditEMail.getText());
				}

				txtEditPersonalNumber.setEditable(false);
				txtEditFirstName.setEditable(false);
				txtEditLastName.setEditable(false);
				txtEditAddress.setEditable(false);
				txtEditCity.setEditable(false);
				txtEditAreaCode.setEditable(false);
				txtEditPhoneNumber.setEditable(false);
				txtEditEMail.setEditable(false);
				txtEnterCompanyOrgNbrEdit.setEditable(false);
				txtEnterCompanyNameEdit.setEditable(false);

				btnEditCustomer.setVisible(true);
				btnSaveCustomer.setVisible(false);

				JOptionPane.showMessageDialog(null, "Ändringarna är sparande"); // Tell the user that the changes have been saved.
			}
		});

		btnDeleteCustomer.addActionListener(new ActionListener() { // When delete button is pressed...
			public void actionPerformed(ActionEvent e){

				controller.customerRegistry.removeCustomer(customer);
				cardLayout.show(contentPane, "customerPanel");

				txtEditPersonalNumber.setText("");
				txtEditFirstName.setText("");
				txtEditLastName.setText("");
				txtEditAddress.setText("");
				txtEditCity.setText("");
				txtEditAreaCode.setText("");
				txtEditPhoneNumber.setText("");
				txtEditEMail.setText("");
				txtEnterCompanyOrgNbrEdit.setText("");
				txtEnterCompanyNameEdit.setText("");

				JOptionPane.showMessageDialog(null, "Kunden är borttagen"); // Tell the user that the customer has been removed.

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

		JTextArea txtrIdentificationNbr = new JTextArea();
		txtrIdentificationNbr.setBounds(47, 204, 138, 19);
		txtrIdentificationNbr.setText("Org/personnummer:");
		txtrIdentificationNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrIdentificationNbr.setBackground(SystemColor.window);
		txtrIdentificationNbr.setEditable(false);
		customerSearchPanel.add(txtrIdentificationNbr);

		JTextArea txtrCustomerNbr = new JTextArea();
		txtrCustomerNbr.setBounds(93, 290, 110, 19);
		txtrCustomerNbr.setText("Kundnummer:");
		txtrCustomerNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrCustomerNbr.setBackground(SystemColor.window);
		txtrCustomerNbr.setEditable(false);
		customerSearchPanel.add(txtrCustomerNbr);

		final JTextField txtEnterCustomerNbr;
		txtEnterCustomerNbr = new JTextField();
		txtEnterCustomerNbr.setText("");
		txtEnterCustomerNbr.setBounds(200, 285, 300, 30);
		customerSearchPanel.add(txtEnterCustomerNbr);
		txtEnterCustomerNbr.setColumns(10);

		final JTextField txtrEnterIdentificationNbr; 
		txtrEnterIdentificationNbr = new JTextField();
		txtrEnterIdentificationNbr.setText("");
		txtrEnterIdentificationNbr.setBounds(200, 200, 300, 30);
		customerSearchPanel.add(txtrEnterIdentificationNbr);
		txtrEnterIdentificationNbr.setColumns(10);

		btnSearchForCustomer.addActionListener(new ActionListener() { // When search button is pressed...
			public void actionPerformed(ActionEvent e) {

				String enteredIdentificationNbr = txtrEnterIdentificationNbr.getText(); // Get text from search field...
				String enteredCustomerNbr = txtEnterCustomerNbr.getText();
				
				customer = controller.findCustomer(enteredCustomerNbr, enteredIdentificationNbr);


				if (customer instanceof PrivateCustomer){

					PrivateCustomer privateCustomer = (PrivateCustomer)customer;

					txtEditPersonalNumber.setText(privateCustomer.getIDNbr());
					txtEditFirstName.setText(privateCustomer.getFirstName());
					txtEditLastName.setText(privateCustomer.getLastName());
					txtEditPersonalNumber.setVisible(true);
					txtEditFirstName.setVisible(true);
					txtEditLastName.setVisible(true);
					txtrEditPersonalNbr.setVisible(true);
					txtrEditFirstName.setVisible(true);
					txtrEditLastName.setVisible(true);

					txtEditAddress.setText(privateCustomer.getAdress());
					txtEditCity.setText(privateCustomer.getCity());
					txtEditAreaCode.setText(privateCustomer.getAreaCode());
					txtEditPhoneNumber.setText(privateCustomer.getPhoneNbr());
					txtEditEMail.setText(privateCustomer.getMailAdress());

					txtEnterCompanyOrgNbrEdit.setVisible(false);
					txtEnterCompanyNameEdit.setVisible(false);
					txtrEnterCompanyOrgNbr.setVisible(false);
					txtrEnterCompanyName.setVisible(false);

				}

				if (customer instanceof CompanyCustomer){

					CompanyCustomer companyCustomer = (CompanyCustomer)customer;

					txtEnterCompanyOrgNbrEdit.setText(companyCustomer.getIDNbr()); 
					txtEnterCompanyNameEdit.setText(companyCustomer.getCompanyName());
					txtEnterCompanyOrgNbrEdit.setVisible(true);
					txtEnterCompanyNameEdit.setVisible(true);
					txtrEnterCompanyOrgNbr.setVisible(true);
					txtrEnterCompanyName.setVisible(true);

					txtEditAddress.setText(companyCustomer.getAdress());
					txtEditCity.setText(companyCustomer.getCity());
					txtEditAreaCode.setText(companyCustomer.getAreaCode());
					txtEditPhoneNumber.setText(companyCustomer.getPhoneNbr());
					txtEditEMail.setText(companyCustomer.getMailAdress());


					txtEditPersonalNumber.setVisible(false);
					txtEditFirstName.setVisible(false);
					txtEditLastName.setVisible(false);
					txtrEditPersonalNbr.setVisible(false);
					txtrEditFirstName.setVisible(false);
					txtrEditLastName.setVisible(false);
				}

				cardLayout.show(contentPane, "editCustomerPanel");

				txtEnterCustomerNbr.setText("");   // Resets the JTextField to be empty for the next registration.	
				txtrEnterIdentificationNbr.setText("");
				btnEditCustomer.setVisible(true);

			}
		});

		btnBackSearchCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerPanel");

				txtEnterCustomerNbr.setText("");  // Resets the JTextField to be empty for the next registration.
				txtrEnterIdentificationNbr.setText("");
			}
		});


		/* -------------------------------------------------------------------------------------------------------------------- ------*/
		/* ----------------------------------------- Creates the CHOOSE WICH CUSTOMER panel! --------------------------------------- */
		/* ------------------------------------------------------------------------------------------------------------------------ */

		final JPanel chooseCustomerPanel = new JPanel();

		chooseCustomerPanel.setLayout(null);

		contentPane.add(chooseCustomerPanel, "chooseCustomerPanel");

		JButton btnBackChooseCustomer = new JButton("Tillbaka");
		btnBackChooseCustomer.setBounds(10, 10, 150, 35);
		chooseCustomerPanel.add(btnBackChooseCustomer);

		JButton btnPrivateCustomer = new JButton("Privatkund");
		btnPrivateCustomer.setBounds(200, 225, 300, 75);
		chooseCustomerPanel.add(btnPrivateCustomer);

		JButton btnCompanyCustomer = new JButton("Företagskund");
		btnCompanyCustomer.setBounds(200, 350, 300, 75);
		chooseCustomerPanel.add(btnCompanyCustomer);

		btnBackChooseCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerPanel");
			}
		});

		btnPrivateCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "newPrivateCustomerPanel");
			}
		});

		btnCompanyCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "newCompanyCustomerPanel");
			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------- Creates the NEW PRIVATE CUSTOMER panel! ------------------------------------------ */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel newPrivateCustomerPanel = new JPanel();
		contentPane.add(newPrivateCustomerPanel, "newPrivateCustomerPanel");
		newPrivateCustomerPanel.setLayout(null);

		JButton btnBackNewPrivateCustomer = new JButton("Tillbaka");
		JButton btnRegisterPrivateNewCustomer = new JButton("Registrera kund");

		newPrivateCustomerPanel.add(btnBackNewPrivateCustomer);
		newPrivateCustomerPanel.add(btnRegisterPrivateNewCustomer);

		btnBackNewPrivateCustomer.setBounds(10, 10, 150, 35);
		btnRegisterPrivateNewCustomer.setBounds(200, 555, 300, 75);

		JTextArea textPersonalNbr = new JTextArea();  // Creates the text next to the input field.
		textPersonalNbr.setBackground(SystemColor.window);
		textPersonalNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPersonalNbr.setText("Personnummer:");
		textPersonalNbr.setBounds(90, 100, 113, 19);
		newPrivateCustomerPanel.add(textPersonalNbr);
		textPersonalNbr.setEditable(false);

		JTextArea textFirstName = new JTextArea();
		textFirstName.setText("Förnamn:");
		textFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFirstName.setEditable(false);
		textFirstName.setBackground(SystemColor.window);
		textFirstName.setBounds(132, 150, 71, 16);
		newPrivateCustomerPanel.add(textFirstName);

		JTextArea textLastName = new JTextArea();
		textLastName.setText("Efternamn:");
		textLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textLastName.setEditable(false);
		textLastName.setBackground(SystemColor.window);
		textLastName.setBounds(122, 200, 81, 16);
		newPrivateCustomerPanel.add(textLastName);

		JTextArea textAdress = new JTextArea();
		textAdress.setText("Adress:");
		textAdress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAdress.setEditable(false);
		textAdress.setBackground(SystemColor.window);
		textAdress.setBounds(145, 250, 58, 16);
		newPrivateCustomerPanel.add(textAdress);

		JTextArea txtrCity = new JTextArea();
		txtrCity.setText("Stad:");
		txtrCity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrCity.setEditable(false);
		txtrCity.setBackground(SystemColor.window);
		txtrCity.setBounds(158, 300, 45, 16);
		newPrivateCustomerPanel.add(txtrCity);

		JTextArea txtrAreaCode = new JTextArea();
		txtrAreaCode.setText("Postkod:");
		txtrAreaCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrAreaCode.setEditable(false);
		txtrAreaCode.setBackground(SystemColor.window);
		txtrAreaCode.setBounds(137, 350, 66, 16);
		newPrivateCustomerPanel.add(txtrAreaCode);

		JTextArea txtrTelephoneNbr = new JTextArea();
		txtrTelephoneNbr.setText("Telefonnummer:");
		txtrTelephoneNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrTelephoneNbr.setEditable(false);
		txtrTelephoneNbr.setBackground(SystemColor.window);
		txtrTelephoneNbr.setBounds(82, 400, 121, 16);
		newPrivateCustomerPanel.add(txtrTelephoneNbr);

		JTextArea txtrMail = new JTextArea();
		txtrMail.setText("E-mail-adress:");
		txtrMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrMail.setEditable(false);
		txtrMail.setBackground(SystemColor.window);
		txtrMail.setBounds(90, 450, 113, 16);
		newPrivateCustomerPanel.add(txtrMail);

		JTextArea txtrDiscountLevel = new JTextArea();
		txtrDiscountLevel.setText("Rabatt:");
		txtrDiscountLevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrDiscountLevel.setEditable(false);
		txtrDiscountLevel.setBackground(SystemColor.window);
		txtrDiscountLevel.setBounds(137, 499, 66, 16);
		newPrivateCustomerPanel.add(txtrDiscountLevel);

		final JTextField txtEnterPersonalNbr;
		txtEnterPersonalNbr = new JTextField();
		txtEnterPersonalNbr.setText(txtEnterPersonalNbr.getText()); ;
		txtEnterPersonalNbr.setBounds(200, 95, 300, 30);
		newPrivateCustomerPanel.add(txtEnterPersonalNbr);
		txtEnterPersonalNbr.setColumns(10);

		final JTextField txtEnterFirstName;
		txtEnterFirstName = new JTextField();
		txtEnterFirstName.setText("");
		txtEnterFirstName.setBounds(200, 145, 300, 30);
		newPrivateCustomerPanel.add(txtEnterFirstName);
		txtEnterFirstName.setColumns(10);

		final JTextField txtEnterLastName; 
		txtEnterLastName= new JTextField();
		txtEnterLastName.setText("");
		txtEnterLastName.setBounds(200, 195, 300, 30);
		newPrivateCustomerPanel.add(txtEnterLastName);
		txtEnterLastName.setColumns(10);

		final JTextField txtEnterAddress; 
		txtEnterAddress = new JTextField();
		txtEnterAddress.setText("");
		txtEnterAddress.setBounds(200, 245, 300, 30);
		newPrivateCustomerPanel.add(txtEnterAddress);
		txtEnterPersonalNbr.setColumns(10);

		final JTextField txtEnterCity; 
		txtEnterCity = new JTextField();
		txtEnterCity.setText("");
		txtEnterCity.setBounds(200, 295, 300, 30);
		newPrivateCustomerPanel.add(txtEnterCity);
		txtEnterCity.setColumns(10);

		final JTextField txtEnterAreaCode;
		txtEnterAreaCode = new JTextField();
		txtEnterAreaCode.setText("");
		txtEnterAreaCode.setBounds(200, 345, 300, 30);
		newPrivateCustomerPanel.add(txtEnterAreaCode);
		txtEnterAreaCode.setColumns(10);

		final JTextField txtEnterTelephoneNbr;
		txtEnterTelephoneNbr = new JTextField();
		txtEnterTelephoneNbr.setText("");
		txtEnterTelephoneNbr.setBounds(200, 395, 300, 30);
		newPrivateCustomerPanel.add(txtEnterTelephoneNbr);
		txtEnterTelephoneNbr.setColumns(10);

		final JTextField txtEnterMail; 
		txtEnterMail = new JTextField();
		txtEnterMail.setText("");
		txtEnterMail.setBounds(200, 445, 300, 30);
		newPrivateCustomerPanel.add(txtEnterMail);
		txtEnterMail.setColumns(10);

		final JTextField txtEnterDiscountLevel; 
		txtEnterDiscountLevel = new JTextField();
		txtEnterDiscountLevel.setText("");
		txtEnterDiscountLevel.setBounds(200, 495, 300, 30);
		newPrivateCustomerPanel.add(txtEnterDiscountLevel);
		txtEnterDiscountLevel.setColumns(10);

		btnBackNewPrivateCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "chooseCustomerPanel");

				txtEnterPersonalNbr.setText("");  // Resets the JTextField to be empty for the next registration.
				txtEnterFirstName.setText("");
				txtEnterLastName.setText("");
				txtEnterAddress.setText("");
				txtEnterCity.setText("");
				txtEnterAreaCode.setText("");
				txtEnterTelephoneNbr.setText("");
				txtEnterMail.setText("");
				txtEnterDiscountLevel.setText("");

			}
		});

		btnRegisterPrivateNewCustomer.addActionListener(new ActionListener() { // When clicked, new customer i registered!
			public void actionPerformed(ActionEvent e) {


				if(txtEnterPersonalNbr.getText().equals("") || txtEnterFirstName.getText().equals("") || txtEnterLastName.getText().equals("") ||
						txtEnterAddress.getText().equals("") || txtEnterCity.getText().equals("") || txtEnterAreaCode.getText().equals("") ||
						txtEnterTelephoneNbr.getText().equals("") || txtEnterMail.getText().equals("")){

					JOptionPane.showMessageDialog(null, "Vänligen fyll i alla fält för registrering");
				}

					else{
					String txtEnteredPersonalNbr = txtEnterPersonalNbr.getText();
					String txtEnteredFirstName = txtEnterFirstName.getText();
					String txtEnteredLastName = txtEnterLastName.getText();
					String txtEnteredAddress = txtEnterAddress.getText();
					String txtEnteredCity = txtEnterCity.getText();
					String txtEnteredAreaCode = txtEnterAreaCode.getText();
					String txtEnteredTelephoneNbr = txtEnterTelephoneNbr.getText();
					String txtEnteredMail = txtEnterMail.getText();

					controller.createPrivateCustomer(txtEnteredPersonalNbr, txtEnteredFirstName, txtEnteredLastName, 
							txtEnteredAddress, txtEnteredCity, txtEnteredAreaCode, txtEnteredTelephoneNbr, txtEnteredMail);



					cardLayout.show(contentPane, "customerPanel"); // ... and return to the customer menu!

					JOptionPane.showMessageDialog(null, "Kunden är registrerad!"); // Tell the user that the customer has been registered!

					txtEnterPersonalNbr.setText("");// Resets the JTextField to be empty for the next registration.
					txtEnterFirstName.setText("");
					txtEnterLastName.setText("");
					txtEnterAddress.setText("");
					txtEnterCity.setText("");
					txtEnterAreaCode.setText("");
					txtEnterTelephoneNbr.setText("");
					txtEnterMail.setText("");
					txtEnterDiscountLevel.setText("");
					}
				}
			});




		/* ---------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------- Creates the NEW COMPANY CUSTOMER panel! ------------------------------------- */
		/* ------------------------------------------------------------------------------------------------------------------------ */

		final JPanel newCompanyCustomerPanel = new JPanel();

		newCompanyCustomerPanel.setLayout(null);

		contentPane.add(newCompanyCustomerPanel, "newCompanyCustomerPanel");

		JButton btnBackNewCompanyCustomer = new JButton("Tillbaka");
		btnBackNewCompanyCustomer.setBounds(10, 10, 150, 35);
		newCompanyCustomerPanel.add(btnBackNewCompanyCustomer);

		JButton btnRegisterNewCompanyCustomer = new JButton("Registrera kund");
		btnRegisterNewCompanyCustomer.setBounds(200, 550, 300, 75);
		newCompanyCustomerPanel.add(btnRegisterNewCompanyCustomer);

		JTextArea textCompanyOrgNbr = new JTextArea();
		textCompanyOrgNbr.setText("Organisationsnummer:");
		textCompanyOrgNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCompanyOrgNbr.setEditable(false);
		textCompanyOrgNbr.setBackground(SystemColor.window);
		textCompanyOrgNbr.setBounds(32, 100, 150, 16);
		newCompanyCustomerPanel.add(textCompanyOrgNbr);

		JTextArea textCompanyName = new JTextArea();
		textCompanyName.setText("Företagsnamn:");
		textCompanyName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCompanyName.setEditable(false);
		textCompanyName.setBackground(SystemColor.window);
		textCompanyName.setBounds(80, 150, 102, 16);
		newCompanyCustomerPanel.add(textCompanyName);

		JTextArea textCompanyAdress = new JTextArea();
		textCompanyAdress.setText("Adress:");
		textCompanyAdress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCompanyAdress.setEditable(false);
		textCompanyAdress.setBackground(SystemColor.window);
		textCompanyAdress.setBounds(129, 200, 53, 16);
		newCompanyCustomerPanel.add(textCompanyAdress);

		JTextArea textCompanyCity = new JTextArea();
		textCompanyCity.setText("Stad:");
		textCompanyCity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCompanyCity.setEditable(false);
		textCompanyCity.setBackground(SystemColor.window);
		textCompanyCity.setBounds(135, 250, 47, 16);
		newCompanyCustomerPanel.add(textCompanyCity);

		JTextArea textCompanyAreaCode = new JTextArea();
		textCompanyAreaCode.setText("Postnummer:");
		textCompanyAreaCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCompanyAreaCode.setEditable(false);
		textCompanyAreaCode.setBackground(SystemColor.window);
		textCompanyAreaCode.setBounds(90, 300, 92, 16);
		newCompanyCustomerPanel.add(textCompanyAreaCode);

		JTextArea textCompanyPhoneNbr = new JTextArea();
		textCompanyPhoneNbr.setText("Telefonnummer:");
		textCompanyPhoneNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCompanyPhoneNbr.setEditable(false);
		textCompanyPhoneNbr.setBackground(SystemColor.window);
		textCompanyPhoneNbr.setBounds(69, 350, 113, 16);
		newCompanyCustomerPanel.add(textCompanyPhoneNbr);

		JTextArea textCompanyMailAdress = new JTextArea();
		textCompanyMailAdress.setText("E-mail adress:");
		textCompanyMailAdress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCompanyMailAdress.setEditable(false);
		textCompanyMailAdress.setBackground(SystemColor.window);
		textCompanyMailAdress.setBounds(80, 400, 102, 16);
		newCompanyCustomerPanel.add(textCompanyMailAdress);

		final JTextField txtEnterCompanyOrgNbr; 
		txtEnterCompanyOrgNbr = new JTextField();
		txtEnterCompanyOrgNbr.setText("");
		txtEnterCompanyOrgNbr.setBounds(200, 95, 300, 30);
		newCompanyCustomerPanel.add(txtEnterCompanyOrgNbr);
		txtEnterCompanyOrgNbr.setColumns(10);

		final JTextField txtEnterCompanyName; 
		txtEnterCompanyName = new JTextField();
		txtEnterCompanyName.setText("");
		txtEnterCompanyName.setBounds(200, 145, 300, 30);
		newCompanyCustomerPanel.add(txtEnterCompanyName);
		txtEnterCompanyName.setColumns(10);

		final JTextField txtEnterCompanyAdress; 
		txtEnterCompanyAdress = new JTextField();
		txtEnterCompanyAdress.setText("");
		txtEnterCompanyAdress.setBounds(200, 195, 300, 30);
		newCompanyCustomerPanel.add(txtEnterCompanyAdress);
		txtEnterCompanyAdress.setColumns(10);

		final JTextField txtEnterCompanyCity; 
		txtEnterCompanyCity = new JTextField();
		txtEnterCompanyCity.setText("");
		txtEnterCompanyCity.setBounds(200, 245, 300, 30);
		newCompanyCustomerPanel.add(txtEnterCompanyCity);
		txtEnterCompanyCity.setColumns(10);

		final JTextField txtEnterCompanyAreaCode; 
		txtEnterCompanyAreaCode = new JTextField();
		txtEnterCompanyAreaCode.setText("");
		txtEnterCompanyAreaCode.setBounds(200, 295, 300, 30);
		newCompanyCustomerPanel.add(txtEnterCompanyAreaCode);
		txtEnterCompanyAreaCode.setColumns(10);

		final JTextField txtEnterCompanyPhoneNbr; 
		txtEnterCompanyPhoneNbr = new JTextField();
		txtEnterCompanyPhoneNbr.setText("");
		txtEnterCompanyPhoneNbr.setBounds(200, 345, 300, 30);
		newCompanyCustomerPanel.add(txtEnterCompanyPhoneNbr);
		txtEnterCompanyPhoneNbr.setColumns(10);

		final JTextField txtEnterCompanyMailAdress; 
		txtEnterCompanyMailAdress = new JTextField();
		txtEnterCompanyMailAdress.setText("");
		txtEnterCompanyMailAdress.setBounds(200, 395, 300, 30);
		newCompanyCustomerPanel.add(txtEnterCompanyMailAdress);
		txtEnterCompanyMailAdress.setColumns(10);

		btnRegisterNewCompanyCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				if(txtEnterCompanyOrgNbr.getText().equals("") || txtEnterCompanyName.getText().equals("") || txtEnterCompanyAdress.getText().equals("") 
						|| txtEnterCompanyCity.getText().equals("") || txtEnterCompanyAreaCode.getText().equals("") ||
						txtEnterCompanyPhoneNbr.getText().equals("") || txtEnterCompanyMailAdress.getText().equals("")){

					JOptionPane.showMessageDialog(null, "Vänligen fyll i alla fält för registrering");
				}

				else{
				String txtEnteredCompanyOrgNbr = txtEnterCompanyOrgNbr.getText();
				String txtEnteredCompanyName = txtEnterCompanyName.getText();
				String txtEnteredCompanyAdress = txtEnterCompanyAdress.getText();
				String txtEnteredCompanyCity = txtEnterCompanyCity.getText();
				String txtEnteredCompanyAreaCode = txtEnterCompanyAreaCode.getText();
				String txtEnteredCompanyPhoneNbr = txtEnterCompanyPhoneNbr.getText();
				String txtEnteredCompanyMailAdress = txtEnterCompanyMailAdress.getText();


				controller.createCompanyCustomer(txtEnteredCompanyOrgNbr, txtEnteredCompanyName, txtEnteredCompanyAdress, txtEnteredCompanyCity,
						txtEnteredCompanyAreaCode, txtEnteredCompanyPhoneNbr, txtEnteredCompanyMailAdress);

				cardLayout.show(contentPane, "customerPanel");
				JOptionPane.showMessageDialog(null, "Kunden är registrerad!"); // Tell the user that the customer has been registered!

				txtEnterCompanyOrgNbr.setText(""); // Resets the JTextField to be empty for the next registration.
				txtEnterCompanyName.setText("");
				txtEnterCompanyAdress.setText("");
				txtEnterCompanyCity.setText("");
				txtEnterCompanyAreaCode.setText(""); 
				txtEnterCompanyPhoneNbr.setText("");
				txtEnterCompanyMailAdress.setText("");
				}
			}
		});

		btnBackNewCompanyCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "chooseCustomerPanel");

				txtEnterCompanyOrgNbr.setText(""); // Resets the JTextField to be empty for the next registration.
				txtEnterCompanyName.setText("");
				txtEnterCompanyAdress.setText("");
				txtEnterCompanyCity.setText("");
				txtEnterCompanyAreaCode.setText(""); 
				txtEnterCompanyPhoneNbr.setText("");
				txtEnterCompanyMailAdress.setText("");

			}
		});

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

		final JButton btnCommitSearch = new JButton("Sök"); // Button used for the actual search!
		btnCommitSearch.setBounds(200, 451, 300, 75);
		searchOrderPanel.add(btnCommitSearch);
		btnCommitSearch.setVisible(false);

		final JButton btnRemoveOrder = new JButton("Ta bort order"); // Button used for the actual search!
		btnRemoveOrder.setBounds(200, 539, 300, 75);
		searchOrderPanel.add(btnRemoveOrder);
		btnRemoveOrder.setVisible(false);

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
		searchScrollPane.setSize(680, 365);
		searchOrderPanel.add(searchScrollPane);
		searchScrollPane.setVisible(false);

		final JTextPane specificSearchPane = new JTextPane();
		specificSearchPane.setBounds(10, 55, 680, 365);
		searchOrderPanel.add(specificSearchPane);
		specificSearchPane.setVisible(false);
		
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

				btnRemoveOrder.setVisible(true);

				Order order;
				ArrayList<Order> orderRegistry = controller.orderRegistry.getOrders();

				String searchVariable = inputSearchData.getText();

				inputSearchData.setVisible(false);

				if(searchMode == "specific") {

					order = controller.orderRegistry.getOrder(Integer.parseInt(searchVariable));
					
					specificSearchPane.setText("Ordernummer: " + order.getOrderNbr() + "\n \n" +
											   "Beställare (kundnummer): " + order.getCustomer().getCustomerNbr() + "\n \n" +
											   "Produkter: " + "\n \n" +
											   "Totalt pris:" + order.getTotalPrice() + "\n \n" +
											   "Datum då ordern utfärdades: " + order.getLatestUpdate());
							
					specificSearchPane.setVisible(true);

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

		btnRemoveOrder.addActionListener(new ActionListener() { // When clicked, go back to main panel...
			public void actionPerformed(ActionEvent e) {

				
				int goRemoveSelection = JOptionPane.showConfirmDialog(null, "Du håller på att ta bort ordern, vill du det?",
																			"Varning!", JOptionPane.YES_OPTION);

				if(goRemoveSelection == 1) { // If the user doesn't want to cancel the order...
					// ... do nothing!
				}

				else if(goRemoveSelection == 0) { // If the user wants to cancel the order...
					controller.orderRegistry.removeOrder(order.getOrderNbr() - 1);
					order = null;
					
					btnCommitSearch.setVisible(false);
					btnRemoveOrder.setVisible(false);
					inputSearchData.setVisible(false);
					searchTable.setVisible(false);
					searchScrollPane.setVisible(false);
					specificSearchPane.setVisible(false);
					
					btnSearchSpecificOrder.setVisible(true);
					btnSearchDatesOrders.setVisible(true);
					btnSearchCustomerOrders.setVisible(true);
					btnSearchProductOrders.setVisible(true);
					
					searchMode = null;
					specificSearchPane.setText("");
					
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

				btnSearchSpecificOrder.setVisible(true);
				btnSearchDatesOrders.setVisible(true);
				btnSearchCustomerOrders.setVisible(true);
				btnSearchProductOrders.setVisible(true);
				
				cardLayout.show(contentPane, "orderPanel");
				
				order = null;
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
		scrollPane.setSize(680, 365);
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

                /*------------- PANEL-------------*/

                final JPanel vehiclePanel = new JPanel();
                vehiclePanel.setLayout(null);
                contentPane.add(vehiclePanel, "vehiclePanel");
                
                /*------------- BUTTONS-------------*/

                final JButton btnSearchVehicle = new JButton("Sök fordon");
                btnSearchVehicle.setBounds(200, 225, 300, 75);
                vehiclePanel.add(btnSearchVehicle);
                
                final JButton btnNewVehicle = new JButton("Registrera fordon");
                btnNewVehicle.setBounds(200, 350, 300, 75);
                vehiclePanel.add(btnNewVehicle);
                
                final JButton btnBackVehicle = new JButton("Tillbaka");
                btnBackVehicle.setBounds(10, 10, 150, 35);
                vehiclePanel.add(btnBackVehicle);

                /*------------- ACTION LISTENER-------------*/

                btnBackVehicle.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
                        public void actionPerformed(ActionEvent e) {
                                cardLayout.show(contentPane, "mainPanel");
                        }
                });
                
        	btnSearchVehicle.addActionListener(new ActionListener() { // To come in to the search button
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "vehicleSearchPanel");
						
			}
				});
        		
        	btnNewVehicle.addActionListener(new ActionListener() { // To come in to the registerVehicle button
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "registerNewVehiclePanel");
			}
				});
        		


                /* -------------------------------------------------------------------------------------------------------------------- */
                /* ---------------------------------------- Creates the SEARCH VEHICLE panel! ----------------------------------------- */
                /* -------------------------------------------------------------------------------------------------------------------- */
                
                
        		/*------------- PANEL-------------*/
        		
        		final JPanel vehicleSearchPanel = new JPanel();
        		vehicleSearchPanel.setLayout(null);
        		contentPane.add(vehicleSearchPanel, "vehicleSearchPanel");

        		/*------------- BUTTONS-------------*/
        		
        		final JButton btnBackSearchVehicle = new JButton("Tillbaka");
        		btnBackSearchVehicle.setBounds(10, 10, 100, 25);
        		vehicleSearchPanel.add(btnBackSearchVehicle);
        		btnBackSearchVehicle.setVisible(true);
        		
        		final JButton btnSearchForVehicle = new JButton("Sök fordon");
        		btnSearchForVehicle.setBounds(100, 534, 206, 38);
        		vehicleSearchPanel.add(btnSearchForVehicle);
        		btnSearchForVehicle.setVisible(true);
        		
        		final JButton btnChangeVehicle = new JButton ("Ändra fordon");
        		btnChangeVehicle.setBounds (562, 485, 128, 38);
        		vehicleSearchPanel.add(btnChangeVehicle);
        		btnChangeVehicle.setVisible(true);
                
        		final JButton btnDeleteVehicle = new JButton ("Ta bort fordon");
        		btnDeleteVehicle.setBounds (562, 534, 128, 38);
        		vehicleSearchPanel.add(btnDeleteVehicle);
        		btnDeleteVehicle.setVisible(true);
        		
                	final JButton btnSaveChangeForVehicle = new JButton("Spara ändring");             
                	btnSaveChangeForVehicle.setBounds(100, 534, 206, 38);
                	btnSaveChangeForVehicle.setVisible(false);
                	vehicleSearchPanel.add(btnSaveChangeForVehicle);
                	btnSaveChangeForVehicle.setVisible(false);


        		
        		/*------------- TEXT FIELDS // Creates search field where you input the information about the vehicle-------------*/

        		final JTextField txtEnterRegNbr = new JTextField();
        		txtEnterRegNbr.setText("");
        		txtEnterRegNbr.setBounds(328, 538, 200, 30);
        		vehicleSearchPanel.add(txtEnterRegNbr);
        		txtEnterRegNbr.setColumns(10);
        		
        		final JTextField txtEnterVehicleRegNbr = new JTextField();
        		txtEnterVehicleRegNbr.setText("");
        		txtEnterVehicleRegNbr.setBounds(327, 61, 166, 20);
        		vehicleSearchPanel.add(txtEnterVehicleRegNbr);
        		txtEnterVehicleRegNbr.setColumns(10);
        		txtEnterVehicleRegNbr.setEditable(false);
        		
        		final JTextField txtEnterVehicleModel = new JTextField();
        		txtEnterVehicleModel.setText("");
        		txtEnterVehicleModel.setBounds(328, 116, 166, 20);
        		vehicleSearchPanel.add(txtEnterVehicleModel);
        		txtEnterVehicleModel.setColumns(10);
        		txtEnterVehicleModel.setEditable(false);
        		
        		final JTextField txtEnterVehicleType = new JTextField();
        		txtEnterVehicleType.setText("");
        		txtEnterVehicleType.setBounds(328, 157, 166, 20);
        		vehicleSearchPanel.add(txtEnterVehicleType);
        		txtEnterVehicleType.setColumns(10);
        		txtEnterVehicleType.setEditable(false);
        		
        		final JTextField txtEnterVehicleLicenseReq = new JTextField();
        		txtEnterVehicleLicenseReq.setText("");
        		txtEnterVehicleLicenseReq.setBounds(328, 208, 165, 20);
        		vehicleSearchPanel.add(txtEnterVehicleLicenseReq);
        		txtEnterVehicleLicenseReq.setColumns(10);
        		txtEnterVehicleLicenseReq.setEditable(false);
        		
        		final JTextField txtEnterVehiclePrice = new JTextField();
        		txtEnterVehiclePrice.setText("");
        		txtEnterVehiclePrice.setColumns(10);
        		txtEnterVehiclePrice.setBounds(328, 255, 166, 20);
        		vehicleSearchPanel.add(txtEnterVehiclePrice);
        		txtEnterVehiclePrice.setEditable(false);
        		
        		final JTextField txtEnterVehicleInfo = new JTextField();
        		txtEnterVehicleInfo.setText("");
        		txtEnterVehicleInfo.setColumns(10);
        		txtEnterVehicleInfo.setBounds(327, 297, 166, 54);
        		vehicleSearchPanel.add(txtEnterVehicleInfo);
        		txtEnterVehicleInfo.setEditable(false);
        		
        		final JTextField txtEnterVehicleHasHook = new JTextField();
        		txtEnterVehicleHasHook.setText("");
        		txtEnterVehicleHasHook.setColumns(10);
        		txtEnterVehicleHasHook.setBounds(327, 384, 166, 20);
        		vehicleSearchPanel.add(txtEnterVehicleHasHook);
        		txtEnterVehicleHasHook.setEditable(false);
        		
        		final JTextField txtEnterVehicleExpiryDate = new JTextField();
        		txtEnterVehicleExpiryDate.setText("");
        		txtEnterVehicleExpiryDate.setColumns(10);
        		txtEnterVehicleExpiryDate.setBounds(328, 440, 165, 20);
        		vehicleSearchPanel.add(txtEnterVehicleExpiryDate);
        		txtEnterVehicleExpiryDate.setEditable(false);
        		
        		final JTextField txtEnterVehicleWarehouse = new JTextField();
        		txtEnterVehicleWarehouse.setText("");
        		txtEnterVehicleWarehouse.setColumns(10);
        		txtEnterVehicleWarehouse.setBounds(327, 485, 166, 20);
        		vehicleSearchPanel.add(txtEnterVehicleWarehouse);
        		txtEnterVehicleWarehouse.setEditable(false);
        		
        		
        		/*------------- TEXT AREAS // Creates the text next to the input field.-------------*/
        		
        		final JTextArea textVehicleRegNbr = new JTextArea();
        		textVehicleRegNbr.setText ("Registreringsnummer");
        		textVehicleRegNbr.setBounds(140, 59, 166, 22);
        		vehicleSearchPanel.add(textVehicleRegNbr);
        		textVehicleRegNbr.setFont(new Font("Tahama", Font.PLAIN,13));
        		textVehicleRegNbr.setBackground(SystemColor.window);
        		textVehicleRegNbr.setEditable(false);
        		
        		final JTextArea textVehicleModel = new JTextArea();
        		textVehicleModel.setText ("Modell");
        		textVehicleModel.setBounds(206, 114, 59, 22);
        		vehicleSearchPanel.add(textVehicleModel);
        		textVehicleModel.setFont(new Font("Tahama", Font.PLAIN,13));
        		textVehicleModel.setBackground(SystemColor.window);
        		textVehicleModel.setEditable(false);
        		
        		final JTextArea textVehicleType = new JTextArea();
        		textVehicleType.setText ("Fordonstyp");
        		textVehicleType.setBounds(206, 155, 90, 22);
        		vehicleSearchPanel.add(textVehicleType);
        		textVehicleType.setFont(new Font("Tahama", Font.PLAIN,13));
        		textVehicleType.setBackground(SystemColor.window);
        		textVehicleType.setEditable(false);
	
        		final JTextArea textVehicleLicenseReq = new JTextArea();
        		textVehicleLicenseReq.setText ("Körkortskrav");
        		textVehicleLicenseReq.setBounds(206, 206, 107, 22);
        		vehicleSearchPanel.add(textVehicleLicenseReq);
        		textVehicleLicenseReq.setFont(new Font("Tahama", Font.PLAIN,13));
        		textVehicleLicenseReq.setBackground(SystemColor.window);
        		textVehicleLicenseReq.setEditable(false);
        		
        		final JTextArea textVehiclePrice = new JTextArea();
        		textVehiclePrice.setSelectedTextColor(Color.WHITE);
        		textVehiclePrice.setText ("Pris");
        		textVehiclePrice.setBounds(206, 253, 44, 22);
        		vehicleSearchPanel.add(textVehiclePrice);
        		textVehiclePrice.setFont(new Font("Tahama", Font.PLAIN,13));
        		textVehiclePrice.setBackground(SystemColor.window);
        		textVehiclePrice.setEditable(false);
        		
        		final JTextArea textVehicleInfo = new JTextArea();
        		textVehicleInfo.setText ("Beskrivning");
        		textVehicleInfo.setBounds(206, 312, 100, 22);
        		vehicleSearchPanel.add(textVehicleInfo);
        		textVehicleInfo.setFont(new Font("Tahama", Font.PLAIN,13));
        		textVehicleInfo.setBackground(SystemColor.window);
        		textVehicleInfo.setEditable(false);
        		
        		final JTextArea textVehicleHasHook = new JTextArea();
        		textVehicleHasHook.setText ("Dragkrok");
        		textVehicleHasHook.setBounds(206, 382, 75, 22);
        		vehicleSearchPanel.add(textVehicleHasHook);
        		textVehicleHasHook.setFont(new Font("Tahama", Font.PLAIN,13));
        		textVehicleHasHook.setBackground(SystemColor.window);
        		textVehicleHasHook.setEditable(false);
        		
        		final JTextArea textVehicleExpiryDate = new JTextArea();
        		textVehicleExpiryDate.setText ("Utgångsdatum");
        		textVehicleExpiryDate.setBounds(206, 438, 107, 22);
        		vehicleSearchPanel.add(textVehicleExpiryDate);
        		textVehicleExpiryDate.setFont(new Font("Tahama", Font.PLAIN,13));
        		textVehicleExpiryDate.setBackground(SystemColor.window);
        		textVehicleExpiryDate.setEditable(false);
        		
        		final JTextArea textVehicleWarehouse = new JTextArea();
        		textVehicleWarehouse.setText ("Filial/lager");
        		textVehicleWarehouse.setBounds(206, 485, 81, 22);
        		vehicleSearchPanel.add(textVehicleWarehouse);
        		textVehicleWarehouse.setFont(new Font("Tahama", Font.PLAIN,13));
        		textVehicleWarehouse.setBackground(SystemColor.window);
        		textVehicleWarehouse.setEditable(false);
       		
        		
        		/*------------- ACTION LISTENER-------------*/
        		
        		btnBackSearchVehicle.addActionListener(new ActionListener() { // When clicked, go back to vehiclePanel...
        			
        			public void actionPerformed(ActionEvent e) {
        				
        					cardLayout.show(contentPane, "vehiclePanel");
        				
                        txtEnterVehicleRegNbr.setText("");
                        txtEnterVehicleModel.setText("");
                        txtEnterVehicleType.setText("");
                        txtEnterVehicleLicenseReq.setText("");
                        txtEnterVehiclePrice.setText("");
                        txtEnterVehicleInfo.setText("");
                        txtEnterVehicleExpiryDate.setText("");
                        txtEnterVehicleWarehouse.setText("");
                        txtEnterVehicleHasHook.setText("");
                        txtEnterRegNbr.setText("");
        				
        			}
        			
        		});

        		btnSearchForVehicle.addActionListener(new ActionListener() { // When search button is pressed...
        			
        			public void actionPerformed(ActionEvent e) {
        				String enteredRegNbr = txtEnterRegNbr.getText().toUpperCase();
        				
        				
        				vehicle = controller.findVehicle(enteredRegNbr);


        		txtEnterVehicleRegNbr.setText(vehicle.getRegNbr());	 // Prints the correct information to the fields
				
				txtEnterVehicleModel.setText(vehicle.getProductName());	
				
				txtEnterVehicleType.setText(vehicle.getType());	
				
				txtEnterVehicleLicenseReq.setText(vehicle.getLicenseReq());	
				
				txtEnterVehiclePrice.setText(Integer.toString(vehicle.getPrice()));	
				
				txtEnterVehicleInfo.setText(vehicle.getInfoTxt());	
				
				
				txtEnterVehicleExpiryDate.setText(vehicle.getExpiryDate());
				
				txtEnterVehicleWarehouse.setText(vehicle.warehouse.getCity());
				
				 String hasHook;
                	/* We need to print the hasHook-argument in a more sensible way which is why we do this... */

        		 if(vehicle.getHasHook()) {
                		hasHook = "Ja";
        		}
                        
                        
                	else { hasHook = "Nej";
        		}

                
                	txtEnterVehicleHasHook.setText(hasHook);
                
                
        				}
        			
        		});
        		
        		
                btnChangeVehicle.addActionListener(new ActionListener() { // When change button is pressed...
                    public void actionPerformed(ActionEvent e){
                    	
                    	btnChangeVehicle.setVisible(false);
                    	btnDeleteVehicle.setVisible(false);
                    	btnSaveChangeForVehicle.setVisible(true);                    	
                    	btnSearchForVehicle.setVisible(false);
                    	
                    	txtEnterRegNbr.setVisible(false);
                    	
                    	txtEnterVehicleRegNbr.setEditable(true);
                    	txtEnterVehicleModel.setEditable(true);
                    	txtEnterVehicleType.setEditable(true);
                    	txtEnterVehicleLicenseReq.setEditable(true);
                    	txtEnterVehiclePrice.setEditable(true);
                    	txtEnterVehicleInfo.setEditable(true);
                    	txtEnterVehicleExpiryDate.setEditable(true);
                    	txtEnterVehicleWarehouse.setEditable(true);
                    	txtEnterVehicleHasHook.setEditable(true);


                    }
                }); 
                
                btnSaveChangeForVehicle.addActionListener(new ActionListener() { // When change button is pressed...
                    public void actionPerformed(ActionEvent e){
                            
                            if(txtEnterVehicleRegNbr.getText().equals("") || 
                            		txtEnterVehicleModel.getText().equals("") || 
                            		txtEnterVehicleType.getText().equals("") || 
                            		txtEnterVehicleLicenseReq.getText().equals("") ||
                            		txtEnterVehiclePrice.getText().equals("") ||
                            		txtEnterVehicleInfo.getText().equals("") ||
                            		txtEnterVehicleExpiryDate.getText().equals("") ||
                            		txtEnterVehicleWarehouse.getText().equals("") ||
                            		txtEnterVehicleHasHook.getText().equals("")){
                                    
                                    JOptionPane.showMessageDialog(null, "Alla fält måste var ifyllda");                           
                            }
                            
                            else{
                            cardLayout.show(contentPane, "VehiclePanel");
                            vehicle.setRegNbr(txtEnterVehicleRegNbr.getText());
                            vehicle.setProductName(txtEnterVehicleModel.getText());
                            vehicle.setType(txtEnterVehicleType.getText());
                            vehicle.setLicenseReq(txtEnterVehicleLicenseReq.getText());
                            vehicle.setPrice(Integer.parseInt(txtEnterVehiclePrice.getText()));
                            vehicle.setInfoTxt(txtEnterVehicleInfo.getText());
                            vehicle.setExpiryDate(txtEnterVehicleExpiryDate.getText());
                            vehicle.warehouse.setCity(txtEnterVehicleWarehouse.getText());
                          /*  vehicle.setHasHook (txtEnterVehicleHasHook.getText());//...info text					*/
                            
                            JOptionPane.showMessageDialog(null, "Ändring sparad");
                            
                            cardLayout.show(contentPane, "vehiclePanel");
                            
                            txtEnterVehicleRegNbr.setText("");
                            txtEnterVehicleModel.setText("");
                            txtEnterVehicleType.setText("");
                            txtEnterVehicleLicenseReq.setText("");
                            txtEnterVehiclePrice.setText("");
                            txtEnterVehicleInfo.setText("");
                            txtEnterVehicleExpiryDate.setText("");
                            txtEnterVehicleWarehouse.setText("");
                            txtEnterVehicleHasHook.setText("");
                            txtEnterRegNbr.setText("");
                        	
                            txtEnterVehicleRegNbr.setEditable(false);
                            txtEnterVehicleModel.setEditable(false);
                            txtEnterVehicleType.setEditable(false);
                            txtEnterVehicleLicenseReq.setEditable(false);
                            txtEnterVehiclePrice.setEditable(false);
                            txtEnterVehicleInfo.setEditable(false);
                            txtEnterVehicleExpiryDate.setEditable(false);
                            txtEnterVehicleWarehouse.setEditable(false);
                            txtEnterVehicleHasHook.setEditable(false);
                            
                        	btnChangeVehicle.setVisible(true);
                        	btnDeleteVehicle.setVisible(true);
                        	btnSaveChangeForVehicle.setVisible(false);
                        	btnSearchForVehicle.setVisible(true);
                        	
                        	txtEnterRegNbr.setVisible(true);

                            }                            
                    }
                });
                
                btnDeleteVehicle.addActionListener(new ActionListener() { // When delete button is pressed...
                    public void actionPerformed(ActionEvent e){
                            
                            controller.vehicleRegistry.removeVehicle(vehicle);
                            
                            JOptionPane.showMessageDialog(null, "Borttaget");
                            
                            cardLayout.show(contentPane, "vehiclePanel");
                            
                            txtEnterVehicleRegNbr.setText("");
                            txtEnterVehicleModel.setText("");
                            txtEnterVehicleType.setText("");
                            txtEnterVehicleLicenseReq.setText("");
                            txtEnterVehiclePrice.setText("");
                            txtEnterVehicleInfo.setText("");
                            txtEnterVehicleExpiryDate.setText("");
                            txtEnterVehicleWarehouse.setText("");
                            txtEnterVehicleHasHook.setText("");
                            txtEnterRegNbr.setText("");
                            
                            txtEnterVehicleRegNbr.setEditable(false);
                            txtEnterVehicleModel.setEditable(false);
                            txtEnterVehicleType.setEditable(false);
                            txtEnterVehicleLicenseReq.setEditable(false);
                            txtEnterVehiclePrice.setEditable(false);
                            txtEnterVehicleInfo.setEditable(false);
                            txtEnterVehicleExpiryDate.setEditable(false);
                            txtEnterVehicleWarehouse.setEditable(false);
                            txtEnterVehicleHasHook.setEditable(false);
                            
                            
                    }
                });

        		
                
                /* -------------------------------------------------------------------------------------------------------------------- */
                /* ------------------------------------------- Creates the NEW VEHICLE panel! ----------------------------------------- */
                /* -------------------------------------------------------------------------------------------------------------------- */
                
                final JPanel registerNewVehiclePanel = new JPanel();
                contentPane.add(registerNewVehiclePanel, "registerNewVehiclePanel");
                registerNewVehiclePanel.setLayout(null);
                
                
                /*------------- BUTTONS-------------*/
                
                final JButton btnBackRegisterNewVehicle = new JButton("Tillbaka");
                btnBackRegisterNewVehicle.setBounds(10, 10, 150, 35);
                registerNewVehiclePanel.add(btnBackRegisterNewVehicle);
                btnBackRegisterNewVehicle.setVisible(true);
                
                final JButton btnRegisterNewVehicle = new JButton("Registrera fordon");
                btnRegisterNewVehicle.setBounds(200, 485, 300, 75);
                registerNewVehiclePanel.add(btnRegisterNewVehicle);
                btnRegisterNewVehicle.setVisible(true);

                
        		
                /*------------- ACTION LISTENER-------------*/

                btnBackRegisterNewVehicle.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
                        public void actionPerformed(ActionEvent e) {
                                cardLayout.show(contentPane, "vehiclePanel");
                        }
                });

                
                /*------------- TEXT FIELDS // Creates search field where you input the information about the vehicle-------------*/

                final JTextField txtEnterNewVehicleRegNbr = new JTextField();
                txtEnterNewVehicleRegNbr.setBounds(225, 74, 250, 30);
                registerNewVehiclePanel.add(txtEnterNewVehicleRegNbr);
                txtEnterNewVehicleRegNbr.setColumns(10);
                txtEnterNewVehicleRegNbr.setEditable(true);
                
                final JTextField txtEnterNewVehicleModel = new JTextField(); 
                txtEnterNewVehicleModel.setText("");
                txtEnterNewVehicleModel.setBounds(225, 120, 250, 30);
                registerNewVehiclePanel.add(txtEnterNewVehicleModel);
                txtEnterNewVehicleModel.setColumns(10);
                txtEnterNewVehicleModel.setEditable(true);
                
                final JTextField txtEnterNewVehicleType = new JTextField();
                txtEnterNewVehicleType.setText("");
                txtEnterNewVehicleType.setBounds(225, 166, 250, 30);
                registerNewVehiclePanel.add(txtEnterNewVehicleType);
                txtEnterNewVehicleType.setColumns(10);
                txtEnterNewVehicleType.setEditable(true);
                
                final JTextField txtEnterNewVehicleLicenseReq = new JTextField(); 
                txtEnterNewVehicleLicenseReq.setText("");
                txtEnterNewVehicleLicenseReq.setBounds(225, 212, 250, 30);
                registerNewVehiclePanel.add(txtEnterNewVehicleLicenseReq);
                txtEnterNewVehicleLicenseReq.setColumns(10);
                txtEnterNewVehicleLicenseReq.setEditable(true);
                
                final JTextField txtEnterNewVehiclePrice = new JTextField(); 
                txtEnterNewVehiclePrice.setText("");
                txtEnterNewVehiclePrice.setBounds(225, 258, 250, 30);
                registerNewVehiclePanel.add(txtEnterNewVehiclePrice);
                txtEnterNewVehiclePrice.setColumns(10);
                txtEnterNewVehiclePrice.setEditable(true);
                
                final JTextField txtEnterNewVehicleInfo = new JTextField(); 
                txtEnterNewVehicleInfo.setText("");
                txtEnterNewVehicleInfo.setBounds(225, 304, 250, 30);
                registerNewVehiclePanel.add(txtEnterNewVehicleInfo);
                txtEnterNewVehicleInfo.setColumns(10);
                txtEnterNewVehicleInfo.setEditable(true);
                
                final JTextField txtEnterNewVehicleHasHook = new JTextField();
                txtEnterNewVehicleHasHook.setText("");
                txtEnterNewVehicleHasHook.setBounds(225, 350, 250, 30);
                registerNewVehiclePanel.add(txtEnterNewVehicleHasHook);
                txtEnterNewVehicleHasHook.setColumns(10);
                txtEnterNewVehicleHasHook.setEditable(true);
                
                final JTextField txtEnterNewVehicleExpiryDate = new JTextField(); 
                txtEnterNewVehicleExpiryDate.setText("");
                txtEnterNewVehicleExpiryDate.setBounds(225, 396, 250, 30);
                registerNewVehiclePanel.add(txtEnterNewVehicleExpiryDate);
                txtEnterNewVehicleExpiryDate.setColumns(10);
                txtEnterNewVehicleExpiryDate.setEditable(true);                
                
                final JTextField txtEnterNewVehicleWarehouse = new JTextField();
                txtEnterNewVehicleWarehouse.setText("");
                txtEnterNewVehicleWarehouse.setBounds(225, 442, 250, 30);
                registerNewVehiclePanel.add(txtEnterNewVehicleWarehouse);
                txtEnterNewVehicleWarehouse.setColumns(10);
                txtEnterNewVehicleWarehouse.setEditable(true);
                
                
                /*------------- TEXT AREAS // Creates the text next to the input field.-------------*/

                final JTextArea txtrNewVehicleRegNbr = new JTextArea();
                txtrNewVehicleRegNbr.setEditable(false);
                txtrNewVehicleRegNbr.setBackground(SystemColor.window);
                txtrNewVehicleRegNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
                txtrNewVehicleRegNbr.setText("Registreringsnummer");
                txtrNewVehicleRegNbr.setBounds(90, 81, 130, 27);
                registerNewVehiclePanel.add(txtrNewVehicleRegNbr);
                
                final JTextArea txtrNewVehicleModel = new JTextArea();
                txtrNewVehicleModel.setEditable(false);
                txtrNewVehicleModel.setBackground(SystemColor.window);
                txtrNewVehicleModel.setFont(new Font("Tahoma", Font.PLAIN, 13));
                txtrNewVehicleModel.setText("Modell");
                txtrNewVehicleModel.setBounds(130, 123, 100, 27);
                registerNewVehiclePanel.add(txtrNewVehicleModel);

                final JTextArea txtrNewVehicleType = new JTextArea();
                txtrNewVehicleType.setEditable(false);
                txtrNewVehicleType.setBackground(SystemColor.window);
                txtrNewVehicleType.setFont(new Font("Tahoma", Font.PLAIN, 13));
                txtrNewVehicleType.setText("Fordonstyp");
                txtrNewVehicleType.setBounds(130, 170, 100, 27);
                registerNewVehiclePanel.add(txtrNewVehicleType);

                final JTextArea txtrNewVehicleLicenseReq = new JTextArea();  
                txtrNewVehicleLicenseReq.setEditable(false);
                txtrNewVehicleLicenseReq.setBackground(SystemColor.window);
                txtrNewVehicleLicenseReq.setFont(new Font("Tahoma", Font.PLAIN, 13));
                txtrNewVehicleLicenseReq.setText("Körkortskrav");
                txtrNewVehicleLicenseReq.setBounds(130, 216, 100, 27);
                registerNewVehiclePanel.add(txtrNewVehicleLicenseReq);
                
                final JTextArea txtrNewVehiclePrice = new JTextArea();
                txtrNewVehiclePrice.setEditable(false);
                txtrNewVehiclePrice.setBackground(SystemColor.window);
                txtrNewVehiclePrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
                txtrNewVehiclePrice.setText("Pris");
                txtrNewVehiclePrice.setBounds(130, 262, 100, 27);
                registerNewVehiclePanel.add(txtrNewVehiclePrice);
                
                final JTextArea txtrNewVehicleInfo = new JTextArea();
                txtrNewVehicleInfo.setEditable(false);
                txtrNewVehicleInfo.setBackground(SystemColor.window);
                txtrNewVehicleInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
                txtrNewVehicleInfo.setText("Beskrivning");
                txtrNewVehicleInfo.setBounds(130, 308, 100, 27);
                registerNewVehiclePanel.add(txtrNewVehicleInfo);             
                
                final JTextArea txtrNewVehicleHasHook = new JTextArea();
                txtrNewVehicleHasHook.setEditable(false);
                txtrNewVehicleHasHook.setBackground(SystemColor.window);
                txtrNewVehicleHasHook.setFont(new Font("Tahoma", Font.PLAIN, 13));
                txtrNewVehicleHasHook.setText("Dragkrok");
                txtrNewVehicleHasHook.setBounds(130, 354, 100, 27);
                registerNewVehiclePanel.add(txtrNewVehicleHasHook);
                
                final JTextArea txtrNewVehicleExpiryDate = new JTextArea();
                txtrNewVehicleExpiryDate.setEditable(false);
                txtrNewVehicleExpiryDate.setBackground(SystemColor.window);
                txtrNewVehicleExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
                txtrNewVehicleExpiryDate.setText("Utgångsdatum");
                txtrNewVehicleExpiryDate.setBounds(130, 400, 100, 27);
                registerNewVehiclePanel.add(txtrNewVehicleExpiryDate);     
                
                final JTextArea txtrNewVehicleWarehouse = new JTextArea();
                txtrNewVehicleWarehouse.setEditable(false);
                txtrNewVehicleWarehouse.setBackground(SystemColor.window);
                txtrNewVehicleWarehouse.setFont(new Font("Tahoma", Font.PLAIN, 13));
                txtrNewVehicleWarehouse.setText("Filial/lager");
                txtrNewVehicleWarehouse.setBounds(130, 447, 100, 27);
                registerNewVehiclePanel.add(txtrNewVehicleWarehouse);


                /* -------------------------------------------------------------------------------------------------------------------- */
                /* ---------------------------------------------- Creates the ACCESSORY panel! ---------------------------------------- */
                /* -------------------------------------------------------------------------------------------------------------------- */

                final JPanel accessoryPanel = new JPanel();
                accessoryPanel.setLayout(null);
                contentPane.add(accessoryPanel, "accessoryPanel");

                //*******Buttons*******//
                
                JButton btnSearchAccessory = new JButton("Sök tillbehör");
                btnSearchAccessory.setBounds(200, 225, 300, 75);
                accessoryPanel.add(btnSearchAccessory);

                
                JButton btnNewAccessory = new JButton("Registrera tillbehör");
                btnNewAccessory.setBounds(200, 350, 300, 75);
                accessoryPanel.add(btnNewAccessory);

              
                JButton btnBackAccessory = new JButton("Tillbaka");
                btnBackAccessory.setBounds(10, 10, 150, 35);
                accessoryPanel.add(btnBackAccessory);

                //*******Action listeners*******//

                btnBackAccessory.addActionListener(new ActionListener() { // When clicked, go back to mainPanel
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

                
                //**********Text fields***********//

                final JTextField fieldEnterProductNbr = new JTextField();
                fieldEnterProductNbr.setBounds(225, 421, 250, 30);
                accessorySearchPanel.add(fieldEnterProductNbr);
               
                
                final JTextField fieldSearchAccessoryProductNbr = new JTextField();
                fieldSearchAccessoryProductNbr.setBounds(225, 150, 250, 30);
                fieldSearchAccessoryProductNbr.setEditable(false);
                fieldSearchAccessoryProductNbr.setText("");
                accessorySearchPanel.add(fieldSearchAccessoryProductNbr);
                
      
                final JTextField fieldSearchAccessoryName = new JTextField();
                fieldSearchAccessoryName.setEditable(false);
                fieldSearchAccessoryName.setBounds(225, 83, 250, 30);
                fieldSearchAccessoryName.setText("");
                accessorySearchPanel.add(fieldSearchAccessoryName);               
              
                
                final JTextField fieldSearchAccessoryPrice = new JTextField();
                fieldSearchAccessoryPrice.setEditable(false);
                fieldSearchAccessoryPrice.setBounds(225, 215, 250, 30);
                fieldSearchAccessoryPrice.setText("");
                accessorySearchPanel.add(fieldSearchAccessoryPrice);

                final JTextField fieldSearchAccessoryInfo = new JTextField();
                fieldSearchAccessoryInfo.setEditable(false);
                fieldSearchAccessoryInfo.setBounds(225, 283, 250, 50);
                fieldSearchAccessoryInfo.setText("");
                accessorySearchPanel.add(fieldSearchAccessoryInfo);
               
                //*********Text areas********//
                
                JTextArea txtrEnterProductNbr = new JTextArea();
                txtrEnterProductNbr.setText("Ange produktnummer");
                txtrEnterProductNbr.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
                txtrEnterProductNbr.setEditable(false);
                txtrEnterProductNbr.setBackground(SystemColor.window);
                txtrEnterProductNbr.setBounds(43, 428, 145, 23);
                accessorySearchPanel.add(txtrEnterProductNbr);
                
                JTextArea txtrSearchAccessoryProductNbr = new JTextArea();
                txtrSearchAccessoryProductNbr.setText("Produktnummer");
                txtrSearchAccessoryProductNbr.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
                txtrSearchAccessoryProductNbr.setEditable(false);
                txtrSearchAccessoryProductNbr.setBackground(SystemColor.window);
                txtrSearchAccessoryProductNbr.setBounds(100, 157, 113, 23);
                accessorySearchPanel.add(txtrSearchAccessoryProductNbr);
                
                JTextArea txtrSearchAccessoryName = new JTextArea();
                txtrSearchAccessoryName.setEditable(false);
                txtrSearchAccessoryName.setText("Namn");
                txtrSearchAccessoryName.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
                txtrSearchAccessoryName.setBackground(SystemColor.window);
                txtrSearchAccessoryName.setBounds(100, 90, 113, 23);
                accessorySearchPanel.add(txtrSearchAccessoryName);
                
                JTextArea txtrSearchAccessoryPrice = new JTextArea();
                txtrSearchAccessoryPrice.setText("Pris");
                txtrSearchAccessoryPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
                txtrSearchAccessoryPrice.setEditable(false);
                txtrSearchAccessoryPrice.setBackground(SystemColor.window);
                txtrSearchAccessoryPrice.setBounds(100, 222, 113, 23);
                accessorySearchPanel.add(txtrSearchAccessoryPrice);
                
                JTextArea txtrSearchAccessoryInfo = new JTextArea();
                txtrSearchAccessoryInfo.setText("Beskrivning");
                txtrSearchAccessoryInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
                txtrSearchAccessoryInfo.setEditable(false);
                txtrSearchAccessoryInfo.setBackground(SystemColor.window);
                txtrSearchAccessoryInfo.setBounds(100, 283, 103, 23);
                accessorySearchPanel.add(txtrSearchAccessoryInfo);
                
                
                //**************Buttons***************//
                
                JButton btnSearchForAccessory = new JButton("Sök tillbehör");
                btnSearchForAccessory.setBounds(200, 475, 300, 50);
                accessorySearchPanel.add(btnSearchForAccessory);
                btnSearchForAccessory.setVisible(true);
                
                
                JButton btnBackSearchAccessory = new JButton("Tillbaka");
                btnBackSearchAccessory.setBounds(10, 10, 150, 35);
                accessorySearchPanel.add(btnBackSearchAccessory);
                btnBackSearchAccessory.setVisible(true);
                
                final JButton btnChangeAccessory = new JButton("Ändra tillbehör");
                btnChangeAccessory.setVisible(false);
                btnChangeAccessory.setBounds(200, 537, 300, 50);
                accessorySearchPanel.add(btnChangeAccessory);


                final JButton btnSaveChangeForAccessory = new JButton("Spara ändring");             
                btnSaveChangeForAccessory.setBounds(200, 537, 300, 50);
                btnSaveChangeForAccessory.setVisible(false);
                accessorySearchPanel.add(btnSaveChangeForAccessory);

                
                final JButton btnDeleteAccessory = new JButton("Ta bort ");
                btnDeleteAccessory.setBounds(200, 599, 300, 50);
                accessorySearchPanel.add(btnDeleteAccessory);
                btnDeleteAccessory.setVisible(false);
                
              
                
                //*************Actions listeners************//
               
                

                btnSearchForAccessory.addActionListener(new ActionListener() { // When search button is pressed...
                        public void actionPerformed(ActionEvent e) {
                        	
                        	if(fieldEnterProductNbr.getText().equals("")){
                        		JOptionPane.showMessageDialog(null, "Vänligen ange produktnummer");
                        	}
                        		
                        	else{
                        	
                        		btnChangeAccessory.setVisible(true);
                        		btnDeleteAccessory.setVisible(true);
                        		btnSaveChangeForAccessory.setVisible(false);
                        		fieldSearchAccessoryName.setEditable(false);
                        		fieldSearchAccessoryProductNbr.setEditable(false);
                        		fieldSearchAccessoryPrice.setEditable(false);
                        		fieldSearchAccessoryInfo.setEditable(false);

                                int enteredProductNbr = Integer.parseInt(fieldEnterProductNbr.getText()); // Get text from search field...
                                
                                accessory = controller.findAccessory(enteredProductNbr); // ... find the accessory...
                                
                                if (accessory == null){
                                	
                                	JOptionPane.showMessageDialog(null, "Kunde ej hitta tillbehör!");
                          	
                                }
                                else
                                fieldSearchAccessoryName.setText(accessory.getProductName()); // ... and print the text
                                fieldSearchAccessoryProductNbr.setText(Integer.toString(accessory.getProductNbr())); // ... and print the text
                                fieldSearchAccessoryPrice.setText(Integer.toString(accessory.getPrice())); // ... and print the text
                                fieldSearchAccessoryInfo.setText(accessory.getInfoTxt()); // ... and print the text
                                
                        	}
                        }
                }); 
                
                btnChangeAccessory.addActionListener(new ActionListener() { // When change button is pressed...
                    public void actionPerformed(ActionEvent e){
                    	
                    	btnChangeAccessory.setVisible(false);
                		btnDeleteAccessory.setVisible(false);
                		btnSaveChangeForAccessory.setVisible(true);
                		fieldSearchAccessoryName.setEditable(true);
                		fieldSearchAccessoryProductNbr.setEditable(true);
                		fieldSearchAccessoryPrice.setEditable(true);
                		fieldSearchAccessoryInfo.setEditable(true);


                    }
                }); 
                
                
                btnSaveChangeForAccessory.addActionListener(new ActionListener() { // When change button is pressed...
                    public void actionPerformed(ActionEvent e){
                    	
                    	if(fieldSearchAccessoryName.getText().equals("") || fieldSearchAccessoryProductNbr.getText().equals("") || fieldSearchAccessoryPrice.getText().equals("") || fieldSearchAccessoryName.getText().equals("")){
                    		
                    		JOptionPane.showMessageDialog(null, "Alla fält måste var ifyllda");                   	
                    	}
                    	
                    	else{
                    	cardLayout.show(contentPane, "accessoryPanel");
                    	accessory.setProductName(fieldSearchAccessoryName.getText());    // changes the name for an accessory 
                    	accessory.setPrice(Integer.parseInt(fieldSearchAccessoryPrice.getText()));//...price
                    	accessory.setInfoTxt(fieldSearchAccessoryInfo.getText());//...info text
                    	
                    	fieldSearchAccessoryName.setText("");
                        fieldSearchAccessoryProductNbr.setText("");
                        fieldSearchAccessoryPrice.setText("");
                        fieldSearchAccessoryInfo.setText("");
                        fieldEnterProductNbr.setText("");
                        btnSaveChangeForAccessory.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Ändring sparad");
                        fieldSearchAccessoryName.setEditable(false);
                		fieldSearchAccessoryProductNbr.setEditable(false);
                		fieldSearchAccessoryPrice.setEditable(false);
                		fieldSearchAccessoryInfo.setEditable(false);
                    	}                    	
                    }
                });
                
                btnDeleteAccessory.addActionListener(new ActionListener() { // When delete button is pressed...
                    public void actionPerformed(ActionEvent e){
                    	
                    	controller.accessoryRegistry.removeAccessory(accessory);
                    	
                    	cardLayout.show(contentPane, "accessoryPanel");
                    	fieldSearchAccessoryName.setText("");
                        fieldSearchAccessoryProductNbr.setText("");
                        fieldSearchAccessoryPrice.setText("");
                        fieldSearchAccessoryInfo.setText("");
                        fieldEnterProductNbr.setText("");
                        fieldSearchAccessoryName.setEditable(false);
                		fieldSearchAccessoryProductNbr.setEditable(false);
                		fieldSearchAccessoryPrice.setEditable(false);
                		fieldSearchAccessoryInfo.setEditable(false);
                    }
                });
                    
                
                
                btnBackSearchAccessory.addActionListener(new ActionListener() { // When clicked, go back to mainPanel and clear fields...
                    public void actionPerformed(ActionEvent e) {
                            cardLayout.show(contentPane, "accessoryPanel");
                            btnChangeAccessory.setVisible(false);
                    		btnDeleteAccessory.setVisible(false);
                            fieldSearchAccessoryName.setText("");
                            fieldSearchAccessoryProductNbr.setText("");
                            fieldSearchAccessoryPrice.setText("");
                            fieldSearchAccessoryInfo.setText("");
                            fieldEnterProductNbr.setText("");
                            fieldSearchAccessoryName.setEditable(false);
                    		fieldSearchAccessoryProductNbr.setEditable(false);
                    		fieldSearchAccessoryPrice.setEditable(false);
                    		fieldSearchAccessoryInfo.setEditable(false);
             
                    }
                }); 
                
                /* -------------------------------------------------------------------------------------------------------------------- */
                /* --------------------------------------- Creates the NEW ACCESSORY panel! ------------------------------------------- */
                /* -------------------------------------------------------------------------------------------------------------------- */

                final JPanel registerNewAccessoryPanel = new JPanel();
                contentPane.add(registerNewAccessoryPanel, "registerNewAccessoryPanel");
                registerNewAccessoryPanel.setLayout(null);
 
                //*********text fields*********//
                
                final JTextField txtEnterAccessoryName; 
                txtEnterAccessoryName = new JTextField();
                txtEnterAccessoryName.setText("");
                txtEnterAccessoryName.setBounds(225, 74, 250, 30);
                registerNewAccessoryPanel.add(txtEnterAccessoryName);
                txtEnterAccessoryName.setColumns(10);
                
                final JTextField txtEnterAccessoryPrice; 
                txtEnterAccessoryPrice= new JTextField();
                txtEnterAccessoryPrice.setText("");
                txtEnterAccessoryPrice.setBounds(225, 145, 250, 30);               
                txtEnterAccessoryPrice.setColumns(10);
                registerNewAccessoryPanel.add(txtEnterAccessoryPrice);

                final JTextField txtEnterAccessoryInfo; // Creates search field where you input the information about the customer...
                txtEnterAccessoryInfo = new JTextField();
                txtEnterAccessoryInfo.setText("");
                txtEnterAccessoryInfo.setBounds(225, 225, 250, 85);
                registerNewAccessoryPanel.add(txtEnterAccessoryInfo);
                txtEnterAccessoryInfo.setColumns(10);
                
                //*******text areas*******//
                
                JTextArea txtrAccessoryName = new JTextArea();
                txtrAccessoryName.setEditable(false);
                txtrAccessoryName.setBackground(SystemColor.window);
                txtrAccessoryName.setFont(new Font("Tahoma", Font.PLAIN, 13));
                txtrAccessoryName.setText("Namn");
                txtrAccessoryName.setBounds(130, 81, 60, 27);
                registerNewAccessoryPanel.add(txtrAccessoryName);
                
                JTextArea txtrNewAccessoryPrice = new JTextArea();  // Creates the text next to the input field.
                txtrNewAccessoryPrice.setEditable(false);
                txtrNewAccessoryPrice.setBackground(SystemColor.window);
                txtrNewAccessoryPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
                txtrNewAccessoryPrice.setText("Pris");
                txtrNewAccessoryPrice.setBounds(130, 152, 79, 27);
                registerNewAccessoryPanel.add(txtrNewAccessoryPrice);
               
                JTextArea txtrAccessoryInfo = new JTextArea();  // Creates the text next to the input field.
                txtrAccessoryInfo.setEditable(false);
                txtrAccessoryInfo.setBackground(SystemColor.window);
                txtrAccessoryInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
                txtrAccessoryInfo.setText("Beskrivning");
                txtrAccessoryInfo.setBounds(130, 225, 79, 27);
                registerNewAccessoryPanel.add(txtrAccessoryInfo);
                
                
                //*****************Buttons*****************//
                
                JButton btnBackRegisterNewAccessory = new JButton("Tillbaka");
                btnBackRegisterNewAccessory.setBounds(10, 10, 150, 35);
                registerNewAccessoryPanel.add(btnBackRegisterNewAccessory);
                btnBackRegisterNewAccessory.setVisible(true);
                
                JButton btnRegisterNewAccessory = new JButton("Registrera tillbehör");        
                btnRegisterNewAccessory.setBounds(200, 485, 300, 75);
                registerNewAccessoryPanel.add(btnRegisterNewAccessory);
                btnRegisterNewAccessory.setVisible(true);
                
                //**************action listeners*************//           
              
                btnRegisterNewAccessory.addActionListener(new ActionListener() { // When register button is pressed...
                    public void actionPerformed(ActionEvent e){
                    	
                    	if(txtEnterAccessoryName.getText().equals("") || txtEnterAccessoryPrice.getText().equals("") || txtEnterAccessoryInfo.getText().equals("")){
                    	
                    		JOptionPane.showMessageDialog(null, "Alla fält måste var ifyllda");

                    	}
                    	
                    	else {
        				
                    	String inputName = txtEnterAccessoryName.getText();                    	
                    	int inputPrice = Integer.parseInt(txtEnterAccessoryPrice.getText());
                    	String inputInfo = txtEnterAccessoryInfo.getText();
                    	
                    	Controller.createAccessory(inputName, inputPrice, inputInfo);
                    	JOptionPane.showMessageDialog(null, "Tillbehör registrerat");
                    	cardLayout.show(contentPane, "accessoryPanel");
                    	txtEnterAccessoryName.setText("");                   
                        txtEnterAccessoryPrice.setText("");
                        txtEnterAccessoryInfo.setText("");
        				
        				
                    	}               	
                    } 	
                });
                
                
                btnBackRegisterNewAccessory.addActionListener(new ActionListener() { // When clicked, go back to mainPanel and clear fields...
                    public void actionPerformed(ActionEvent e) {
                            cardLayout.show(contentPane, "accessoryPanel");
                            txtEnterAccessoryName.setText("");
                            txtEnterAccessoryPrice.setText("");
                            txtEnterAccessoryInfo.setText("");
                    }
                });
               

               
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
