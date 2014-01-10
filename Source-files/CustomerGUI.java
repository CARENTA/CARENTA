package GUI;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.Controller;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import objects.Customer;
import objects.PrivateCustomer;
import objects.CompanyCustomer;

public class CustomerGUI {

	final CardLayout cardLayout;
	final Container contentPane;
	private Controller controller;

	private Customer customer;
	private String customerType; // Used for determine which customer type is being created...

	public CustomerGUI(final Container contentPane, final CardLayout cardLayout, final Controller controller) {

		this.cardLayout = cardLayout;
		this.contentPane = contentPane;
		this.controller = controller;

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

		final JTextArea txtrIdentificationNbr = new JTextArea();
		txtrIdentificationNbr.setBounds(47, 204, 138, 19);
		txtrIdentificationNbr.setText("Org/personnummer:");
		txtrIdentificationNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrIdentificationNbr.setBackground(SystemColor.window);
		txtrIdentificationNbr.setEditable(false);
		customerSearchPanel.add(txtrIdentificationNbr);

		final JTextArea txtrCustomerNbr = new JTextArea();
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

		final JTextField txtEnterPersonalNbr;
		txtEnterPersonalNbr = new JTextField();
		txtEnterPersonalNbr.setText(""); ;
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

					txtEnterPersonalNbr.setText("");
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
	/* -------------------------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------------------------- */

}
