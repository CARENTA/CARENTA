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
		/* ----------------------------------------- Creates the CUSTOMER panel! ---------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/* ---- PANEL! ---- */

		final JPanel customerPanel = new JPanel();
		customerPanel.setLayout(null);
		contentPane.add(customerPanel, "customerPanel");

		/* ---- BUTTONS! ---- */

		JButton btnSearch = new JButton("Sök kund");
		btnSearch.setBounds(200, 225, 300, 75);
		customerPanel.add(btnSearch);

		JButton btnNew = new JButton("Registrera kund");
		btnNew.setBounds(200, 350, 300, 75);
		customerPanel.add(btnNew);

		JButton btnBack = new JButton("Tillbaka");
		btnBack.setBounds(10, 10, 150, 35);
		customerPanel.add(btnBack);

		/* ---- ACTION LISTENERS! ---- */

		btnSearch.addActionListener(new ActionListener() { // When clicked, go to customerSearchPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerSearchPanel");
			}
		});

		btnNew.addActionListener(new ActionListener() { // When clicked, go to customerSearchPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "choosePanel");
			}
		});

		btnBack.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------- Creates the EDIT CUSTOMER panel! ------------------------------------------ */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/* ---- PANEL! ---- */

		final JPanel editCustomerPanel = new JPanel();
		editCustomerPanel.setLayout(null);
		contentPane.add(editCustomerPanel, "editCustomerPanel");

		/* ---- BUTTONS! ---- */

		final JButton btnBackEditCustomer = new JButton("Tillbaka");
		btnBackEditCustomer.setBounds(10, 10, 100, 25);
		editCustomerPanel.add(btnBackEditCustomer);

		final JButton btnEditCustomer = new JButton("Ändra kund");
		btnEditCustomer.setBounds(230, 470, 270, 60);
		editCustomerPanel.add(btnEditCustomer);

		final JButton btnDeleteCustomer = new JButton("Ta bort kund");
		btnDeleteCustomer.setBounds(230, 560, 270, 60);
		editCustomerPanel.add(btnDeleteCustomer);

		final JButton btnSaveCustomer = new JButton("Spara kund");
		btnSaveCustomer.setBounds(230, 470, 270, 60);
		editCustomerPanel.add(btnSaveCustomer);
		btnSaveCustomer.setVisible(false);

		/* ---- TEXT FIELDS! ---- */

		final JTextField fieldEditIDNbr;
		fieldEditIDNbr= new JTextField();
		fieldEditIDNbr.setText("");
		fieldEditIDNbr.setBounds(246, 146, 250, 30);
		editCustomerPanel.add(fieldEditIDNbr);
		fieldEditIDNbr.setColumns(10);
		fieldEditIDNbr.setVisible(false);
		fieldEditIDNbr.setEditable(false);

		final JTextField fieldEditFirstName; 
		fieldEditFirstName = new JTextField();
		fieldEditFirstName.setText("");
		fieldEditFirstName.setBounds(246, 54, 250, 30);
		editCustomerPanel.add(fieldEditFirstName);
		fieldEditFirstName.setColumns(10);
		fieldEditFirstName.setVisible(false);
		fieldEditFirstName.setEditable(false);

		final JTextField fieldEditLastName;
		fieldEditLastName = new JTextField();
		fieldEditLastName.setText("");
		fieldEditLastName.setBounds(246, 100, 250, 30);
		editCustomerPanel.add(fieldEditLastName);
		fieldEditLastName.setColumns(10);
		fieldEditLastName.setVisible(false);
		fieldEditLastName.setEditable(false);

		final JTextField fieldEditAddress; 
		fieldEditAddress = new JTextField();
		fieldEditAddress.setText("");
		fieldEditAddress.setBounds(246, 199, 250, 30);
		editCustomerPanel.add(fieldEditAddress);
		fieldEditFirstName.setColumns(10);
		fieldEditAddress.setEditable(false);

		final JTextField fieldEditCity; 
		fieldEditCity = new JTextField();
		fieldEditCity.setText("");
		fieldEditCity.setBounds(246, 250, 250, 30);
		editCustomerPanel.add(fieldEditCity);
		fieldEditCity.setColumns(10);
		fieldEditCity.setEditable(false);

		final JTextField fieldEditAreaCode;
		fieldEditAreaCode = new JTextField();
		fieldEditAreaCode.setText("");
		fieldEditAreaCode.setBounds(246, 299, 250, 30);
		editCustomerPanel.add(fieldEditAreaCode);
		fieldEditAreaCode.setColumns(10);
		fieldEditAreaCode.setEditable(false);

		final JTextField fieldEditPhoneNbr;
		fieldEditPhoneNbr = new JTextField();
		fieldEditPhoneNbr.setText("");
		fieldEditPhoneNbr.setBounds(246, 349, 250, 30);
		editCustomerPanel.add(fieldEditPhoneNbr);
		fieldEditPhoneNbr.setColumns(10);
		fieldEditPhoneNbr.setEditable(false);

		final JTextField fieldEditEMail;
		fieldEditEMail = new JTextField();
		fieldEditEMail.setText("");
		fieldEditEMail.setBounds(246, 395, 250, 30);
		editCustomerPanel.add(fieldEditEMail);
		fieldEditEMail.setColumns(10);
		fieldEditEMail.setEditable(false);

		final JTextField fieldEditOrgNbr;
		fieldEditOrgNbr = new JTextField();
		fieldEditOrgNbr.setText("");
		fieldEditOrgNbr.setBounds(246, 146, 250, 30);
		editCustomerPanel.add(fieldEditOrgNbr);
		fieldEditOrgNbr.setColumns(10);
		fieldEditOrgNbr.setVisible(false);
		fieldEditOrgNbr.setEditable(false);

		final JTextField fieldEnterCompanyNameEdit;
		fieldEnterCompanyNameEdit = new JTextField();
		fieldEnterCompanyNameEdit.setText("");
		fieldEnterCompanyNameEdit.setBounds(246, 100, 250, 30);
		editCustomerPanel.add(fieldEnterCompanyNameEdit);
		fieldEnterCompanyNameEdit.setColumns(10);
		fieldEnterCompanyNameEdit.setVisible(false);
		fieldEnterCompanyNameEdit.setEditable(false);

		/* ---- TEXT AREAS! ---- */

		final JTextArea textEnterOrgNbr = new JTextArea();
		textEnterOrgNbr.setBackground(SystemColor.menu);
		textEnterOrgNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEnterOrgNbr.setText("Organisationsnummer");
		textEnterOrgNbr.setBounds(93, 152, 138, 27);
		editCustomerPanel.add(textEnterOrgNbr);
		textEnterOrgNbr.setEditable(false);
		textEnterOrgNbr.setVisible(false);

		final JTextArea textEnterCompanyName = new JTextArea();
		textEnterCompanyName.setBackground(SystemColor.menu);
		textEnterCompanyName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEnterCompanyName.setText("Företagsnamn");
		textEnterCompanyName.setBounds(145, 106, 86, 27);
		editCustomerPanel.add(textEnterCompanyName);
		textEnterCompanyName.setEditable(false);
		textEnterCompanyName.setVisible(false);

		final JTextArea textEditPersonNbr = new JTextArea();  
		textEditPersonNbr.setBackground(SystemColor.menu);
		textEditPersonNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEditPersonNbr.setText("Personnummer");
		textEditPersonNbr.setBounds(128, 152, 100, 27);
		editCustomerPanel.add(textEditPersonNbr);
		textEditPersonNbr.setEditable(false);     
		textEditPersonNbr.setVisible(false);

		final JTextArea textEditFirstName = new JTextArea();  
		textEditFirstName.setBackground(SystemColor.menu);
		textEditFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEditFirstName.setText("Förnamn");
		textEditFirstName.setBounds(157, 60, 74, 27);
		editCustomerPanel.add(textEditFirstName);
		textEditFirstName.setEditable(false);    
		textEditFirstName.setVisible(false);

		final JTextArea textEditLastName = new JTextArea();  
		textEditLastName.setBackground(SystemColor.menu);
		textEditLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEditLastName.setText("Efternamn");
		textEditLastName.setBounds(157, 106, 74, 27);
		editCustomerPanel.add(textEditLastName);
		textEditLastName.setEditable(false);    
		textEditLastName.setVisible(false);

		JTextArea textEditAddress = new JTextArea();  
		textEditAddress.setBackground(SystemColor.menu);
		textEditAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEditAddress.setText("Gatuadress");
		textEditAddress.setBounds(157, 205, 74, 27);
		editCustomerPanel.add(textEditAddress);
		textEditAddress.setEditable(false);    

		JTextArea textEditCity = new JTextArea();  
		textEditCity.setBackground(SystemColor.menu);
		textEditCity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEditCity.setText("Stad");
		textEditCity.setBounds(181, 256, 47, 27);
		editCustomerPanel.add(textEditCity);
		textEditCity.setEditable(false);     

		JTextArea textEditAreaCode = new JTextArea();  
		textEditAreaCode.setBackground(SystemColor.menu);
		textEditAreaCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEditAreaCode.setText("Postnummer");
		textEditAreaCode.setBounds(145, 305, 86, 27);
		editCustomerPanel.add(textEditAreaCode);
		textEditAreaCode.setEditable(false);    

		JTextArea textEditPhoneNbr = new JTextArea();  
		textEditPhoneNbr.setBackground(SystemColor.menu);
		textEditPhoneNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEditPhoneNbr.setText("Telefonnummer");
		textEditPhoneNbr.setBounds(128, 355, 100, 27);
		editCustomerPanel.add(textEditPhoneNbr);
		textEditPhoneNbr.setEditable(false);  

		JTextArea textEditEMail = new JTextArea(); 
		textEditEMail.setBackground(SystemColor.menu);
		textEditEMail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEditEMail.setText("E-mail");
		textEditEMail.setBounds(184, 401, 47, 27);
		editCustomerPanel.add(textEditEMail);
		textEditEMail.setEditable(false);   

		/* ---- ACTION LISTENERS! ---- */

		btnEditCustomer.addActionListener(new ActionListener() { // When clicked, makes the TextFields editable!
			public void actionPerformed(ActionEvent e) {

				btnSaveCustomer.setVisible(true);
				btnEditCustomer.setVisible(false);

				fieldEditIDNbr.setEditable(true);
				fieldEditFirstName.setEditable(true);
				fieldEditLastName.setEditable(true);
				fieldEditAddress.setEditable(true);
				fieldEditCity.setEditable(true);
				fieldEditAreaCode.setEditable(true);
				fieldEditPhoneNbr.setEditable(true);
				fieldEditEMail.setEditable(true);
				fieldEditOrgNbr.setEditable(true);
				fieldEnterCompanyNameEdit.setEditable(true);

			}
		});


		btnSaveCustomer.addActionListener(new ActionListener() { // When clicked,  saves the customer!
			public void actionPerformed(ActionEvent e) {

				if (customer instanceof PrivateCustomer){

					PrivateCustomer privateCustomer = (PrivateCustomer)customer;

					privateCustomer.setIDNbr(fieldEditIDNbr.getText());
					privateCustomer.setFirstName(fieldEditFirstName.getText());
					privateCustomer.setLastName(fieldEditLastName.getText());
					privateCustomer.setAdress(fieldEditAddress.getText());
					privateCustomer.setCity(fieldEditCity.getText());
					privateCustomer.setAreaCode(fieldEditAreaCode.getText());
					privateCustomer.setPhoneNbr(fieldEditPhoneNbr.getText());
					privateCustomer.setMailAdress(fieldEditEMail.getText());

				}

				if (customer instanceof CompanyCustomer){

					CompanyCustomer companyCustomer = (CompanyCustomer)customer;

					companyCustomer.setIDNbr(fieldEditOrgNbr.getText());
					companyCustomer.setCompanyName(fieldEnterCompanyNameEdit.getText());
					companyCustomer.setAdress(fieldEditAddress.getText());
					companyCustomer.setCity(fieldEditCity.getText());
					companyCustomer.setAreaCode(fieldEditAreaCode.getText());
					companyCustomer.setPhoneNbr(fieldEditPhoneNbr.getText());
					companyCustomer.setMailAdress(fieldEditEMail.getText());
				}

				fieldEditIDNbr.setEditable(false);
				fieldEditFirstName.setEditable(false);
				fieldEditLastName.setEditable(false);
				fieldEditAddress.setEditable(false);
				fieldEditCity.setEditable(false);
				fieldEditAreaCode.setEditable(false);
				fieldEditPhoneNbr.setEditable(false);
				fieldEditEMail.setEditable(false);
				fieldEditOrgNbr.setEditable(false);
				fieldEnterCompanyNameEdit.setEditable(false);

				btnEditCustomer.setVisible(true);
				btnSaveCustomer.setVisible(false);

				JOptionPane.showMessageDialog(null, "Ändringarna är sparande"); // Tell the user that the changes have been saved.

				cardLayout.show(contentPane, "customerPanel");

			}
		});

		btnDeleteCustomer.addActionListener(new ActionListener() { // When delete button is pressed...
			public void actionPerformed(ActionEvent e){

				controller.customerRegistry.removeCustomer(customer);
				cardLayout.show(contentPane, "customerPanel");

				fieldEditIDNbr.setText("");
				fieldEditFirstName.setText("");
				fieldEditLastName.setText("");
				fieldEditAddress.setText("");
				fieldEditCity.setText("");
				fieldEditAreaCode.setText("");
				fieldEditPhoneNbr.setText("");
				fieldEditEMail.setText("");
				fieldEditOrgNbr.setText("");
				fieldEnterCompanyNameEdit.setText("");

				JOptionPane.showMessageDialog(null, "Kunden är borttagen"); // Tell the user that the customer has been removed.

			}
		});

		btnBackEditCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerPanel");

				btnSaveCustomer.setVisible(false);

				fieldEditIDNbr.setText("");
				fieldEditFirstName.setText("");
				fieldEditLastName.setText("");
				fieldEditAddress.setText("");
				fieldEditCity.setText("");
				fieldEditAreaCode.setText("");
				fieldEditPhoneNbr.setText("");
				fieldEditEMail.setText("");
				fieldEditOrgNbr.setText("");
				fieldEnterCompanyNameEdit.setText("");

				fieldEditIDNbr.setEditable(false);
				fieldEditFirstName.setEditable(false);
				fieldEditLastName.setEditable(false);
				fieldEditAddress.setEditable(false);
				fieldEditCity.setEditable(false);
				fieldEditAreaCode.setEditable(false);
				fieldEditPhoneNbr.setEditable(false);
				fieldEditEMail.setEditable(false);
				fieldEditOrgNbr.setEditable(false);
				fieldEnterCompanyNameEdit.setEditable(false);

			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------- Creates the CUSTOMER SEARCH panel! --------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/* ---- PANEL! ---- */

		final JPanel customerSearchPanel = new JPanel();
		customerSearchPanel.setLayout(null);
		contentPane.add(customerSearchPanel, "customerSearchPanel");

		/* ----BUTTONS! ---- */

		JButton btnSearchForCustomer = new JButton("Sök kund");
		btnSearchForCustomer.setBounds(200, 475, 300, 75);
		customerSearchPanel.add(btnSearchForCustomer);

		JButton btnBackSearchCustomer = new JButton("Tillbaka");
		btnBackSearchCustomer.setBounds(10, 10, 150, 35);
		customerSearchPanel.add(btnBackSearchCustomer);

		/* ---- TEXT FIELDS! ---- */

		final JTextField fieldEnterCustomerNbr;
		fieldEnterCustomerNbr = new JTextField();
		fieldEnterCustomerNbr.setText("");
		fieldEnterCustomerNbr.setBounds(200, 285, 300, 30);
		customerSearchPanel.add(fieldEnterCustomerNbr);
		fieldEnterCustomerNbr.setColumns(10);

		final JTextField textEnterIdentificationNbr; 
		textEnterIdentificationNbr = new JTextField();
		textEnterIdentificationNbr.setText("");
		textEnterIdentificationNbr.setBounds(200, 200, 300, 30);
		customerSearchPanel.add(textEnterIdentificationNbr);
		textEnterIdentificationNbr.setColumns(10);

		/* ---- TEXT AREAS! ---- */

		JTextArea textIdentificationNbr = new JTextArea();
		textIdentificationNbr.setBounds(47, 204, 138, 19);
		textIdentificationNbr.setText("Org/personnummer:");
		textIdentificationNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textIdentificationNbr.setBackground(SystemColor.window);
		textIdentificationNbr.setEditable(false);
		customerSearchPanel.add(textIdentificationNbr);

		JTextArea textCustomerNbr = new JTextArea();
		textCustomerNbr.setBounds(93, 290, 110, 19);
		textCustomerNbr.setText("Kundnummer:");
		textCustomerNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCustomerNbr.setBackground(SystemColor.window);
		textCustomerNbr.setEditable(false);
		customerSearchPanel.add(textCustomerNbr);

		/* ---- ACTION LISTENERS! ---- */

		btnSearchForCustomer.addActionListener(new ActionListener() { // When search button is pressed...
			public void actionPerformed(ActionEvent e) {

				String enteredIdentificationNbr = textEnterIdentificationNbr.getText(); // Get text from search field...
				String enteredCustomerNbr = fieldEnterCustomerNbr.getText();

				customer = controller.findCustomer(enteredCustomerNbr, enteredIdentificationNbr);

				if (customer instanceof PrivateCustomer){

					PrivateCustomer privateCustomer = (PrivateCustomer)customer;

					fieldEditIDNbr.setText(privateCustomer.getIDNbr());
					fieldEditFirstName.setText(privateCustomer.getFirstName());
					fieldEditLastName.setText(privateCustomer.getLastName());
					fieldEditIDNbr.setVisible(true);
					fieldEditFirstName.setVisible(true);
					fieldEditLastName.setVisible(true);
					textEditPersonNbr.setVisible(true);
					textEditFirstName.setVisible(true);
					textEditLastName.setVisible(true);

					fieldEditAddress.setText(privateCustomer.getAdress());
					fieldEditCity.setText(privateCustomer.getCity());
					fieldEditAreaCode.setText(privateCustomer.getAreaCode());
					fieldEditPhoneNbr.setText(privateCustomer.getPhoneNbr());
					fieldEditEMail.setText(privateCustomer.getMailAdress());

					fieldEditOrgNbr.setVisible(false);
					fieldEnterCompanyNameEdit.setVisible(false);
					textEnterOrgNbr.setVisible(false);
					textEnterCompanyName.setVisible(false);

				}

				if (customer instanceof CompanyCustomer){

					CompanyCustomer companyCustomer = (CompanyCustomer)customer;

					fieldEditOrgNbr.setText(companyCustomer.getIDNbr()); 
					fieldEnterCompanyNameEdit.setText(companyCustomer.getCompanyName());
					fieldEditOrgNbr.setVisible(true);
					fieldEnterCompanyNameEdit.setVisible(true);
					textEnterOrgNbr.setVisible(true);
					textEnterCompanyName.setVisible(true);

					fieldEditAddress.setText(companyCustomer.getAdress());
					fieldEditCity.setText(companyCustomer.getCity());
					fieldEditAreaCode.setText(companyCustomer.getAreaCode());
					fieldEditPhoneNbr.setText(companyCustomer.getPhoneNbr());
					fieldEditEMail.setText(companyCustomer.getMailAdress());


					fieldEditIDNbr.setVisible(false);
					fieldEditFirstName.setVisible(false);
					fieldEditLastName.setVisible(false);
					textEditPersonNbr.setVisible(false);
					textEditFirstName.setVisible(false);
					textEditLastName.setVisible(false);
				}

				fieldEnterCustomerNbr.setText("");   // Resets the JTextField to be empty for the next registration.        
				textEnterIdentificationNbr.setText("");
				btnEditCustomer.setVisible(true);

				cardLayout.show(contentPane, "editCustomerPanel");

			}
		});

		btnBackSearchCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {

				fieldEnterCustomerNbr.setText("");  // Resets the JTextField to be empty for the next registration.
				textEnterIdentificationNbr.setText("");

				cardLayout.show(contentPane, "customerPanel");

			}
		});

		/* -------------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------- Creates the CHOOSE CUSTOMER panel! --------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------------- */

		final JPanel choosePanel = new JPanel();

		choosePanel.setLayout(null);

		contentPane.add(choosePanel, "choosePanel");

		JButton btnBackChooseCustomer = new JButton("Tillbaka");
		btnBackChooseCustomer.setBounds(10, 10, 150, 35);
		choosePanel.add(btnBackChooseCustomer);

		JButton btnPrivateCustomer = new JButton("Privatkund");
		btnPrivateCustomer.setBounds(200, 225, 300, 75);
		choosePanel.add(btnPrivateCustomer);

		JButton btnCompanyCustomer = new JButton("Företagskund");
		btnCompanyCustomer.setBounds(200, 350, 300, 75);
		choosePanel.add(btnCompanyCustomer);

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
		/* ------------------------------------- Creates the NEW PRIVATE CUSTOMER panel! -------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/* ---- PANEL! ---- */

		final JPanel newPrivateCustomerPanel = new JPanel();
		contentPane.add(newPrivateCustomerPanel, "newPrivateCustomerPanel");
		newPrivateCustomerPanel.setLayout(null);

		/* ---- BUTTONS! ---- */

		JButton btnBackNewPrivateCustomer = new JButton("Tillbaka");
		newPrivateCustomerPanel.add(btnBackNewPrivateCustomer);
		btnBackNewPrivateCustomer.setBounds(10, 10, 150, 35);

		JButton btnRegisterPrivateNewCustomer = new JButton("Registrera kund");
		newPrivateCustomerPanel.add(btnRegisterPrivateNewCustomer);
		btnRegisterPrivateNewCustomer.setBounds(200, 555, 300, 75);

		/* ---- TEXT FIELDS! ---- */

		final JTextField fieldEnterPersonalNbr;
		fieldEnterPersonalNbr = new JTextField();
		fieldEnterPersonalNbr.setText(fieldEnterPersonalNbr.getText()); ;
		fieldEnterPersonalNbr.setBounds(200, 95, 300, 30);
		newPrivateCustomerPanel.add(fieldEnterPersonalNbr);
		fieldEnterPersonalNbr.setColumns(10);

		final JTextField fieldEnterFirstName;
		fieldEnterFirstName = new JTextField();
		fieldEnterFirstName.setText("");
		fieldEnterFirstName.setBounds(200, 145, 300, 30);
		newPrivateCustomerPanel.add(fieldEnterFirstName);
		fieldEnterFirstName.setColumns(10);

		final JTextField fieldEnterLastName; 
		fieldEnterLastName= new JTextField();
		fieldEnterLastName.setText("");
		fieldEnterLastName.setBounds(200, 195, 300, 30);
		newPrivateCustomerPanel.add(fieldEnterLastName);
		fieldEnterLastName.setColumns(10);

		final JTextField fieldEnterAddress; 
		fieldEnterAddress = new JTextField();
		fieldEnterAddress.setText("");
		fieldEnterAddress.setBounds(200, 245, 300, 30);
		newPrivateCustomerPanel.add(fieldEnterAddress);
		fieldEnterPersonalNbr.setColumns(10);

		final JTextField fieldEnterCity; 
		fieldEnterCity = new JTextField();
		fieldEnterCity.setText("");
		fieldEnterCity.setBounds(200, 295, 300, 30);
		newPrivateCustomerPanel.add(fieldEnterCity);
		fieldEnterCity.setColumns(10);

		final JTextField fieldEnterAreaCode;
		fieldEnterAreaCode = new JTextField();
		fieldEnterAreaCode.setText("");
		fieldEnterAreaCode.setBounds(200, 345, 300, 30);
		newPrivateCustomerPanel.add(fieldEnterAreaCode);
		fieldEnterAreaCode.setColumns(10);

		final JTextField fieldEnterTelephoneNbr;
		fieldEnterTelephoneNbr = new JTextField();
		fieldEnterTelephoneNbr.setText("");
		fieldEnterTelephoneNbr.setBounds(200, 395, 300, 30);
		newPrivateCustomerPanel.add(fieldEnterTelephoneNbr);
		fieldEnterTelephoneNbr.setColumns(10);

		final JTextField fieldEnterMail; 
		fieldEnterMail = new JTextField();
		fieldEnterMail.setText("");
		fieldEnterMail.setBounds(200, 445, 300, 30);
		newPrivateCustomerPanel.add(fieldEnterMail);
		fieldEnterMail.setColumns(10);

		final JTextField fieldEnterDiscountLevel; 
		fieldEnterDiscountLevel = new JTextField();
		fieldEnterDiscountLevel.setText("");
		fieldEnterDiscountLevel.setBounds(200, 495, 300, 30);
		newPrivateCustomerPanel.add(fieldEnterDiscountLevel);
		fieldEnterDiscountLevel.setColumns(10);

		/* ---- TEXT AREA! ---- */

		JTextArea textPersonNbr = new JTextArea();  
		textPersonNbr.setBackground(SystemColor.window);
		textPersonNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPersonNbr.setText("Personnummer:");
		textPersonNbr.setBounds(90, 100, 113, 19);
		newPrivateCustomerPanel.add(textPersonNbr);
		textPersonNbr.setEditable(false);

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

		JTextArea textCity = new JTextArea();
		textCity.setText("Stad:");
		textCity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCity.setEditable(false);
		textCity.setBackground(SystemColor.window);
		textCity.setBounds(158, 300, 45, 16);
		newPrivateCustomerPanel.add(textCity);

		JTextArea textAreaCode = new JTextArea();
		textAreaCode.setText("Postkod:");
		textAreaCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAreaCode.setEditable(false);
		textAreaCode.setBackground(SystemColor.window);
		textAreaCode.setBounds(137, 350, 66, 16);
		newPrivateCustomerPanel.add(textAreaCode);

		JTextArea textTelephoneNbr = new JTextArea();
		textTelephoneNbr.setText("Telefonnummer:");
		textTelephoneNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTelephoneNbr.setEditable(false);
		textTelephoneNbr.setBackground(SystemColor.window);
		textTelephoneNbr.setBounds(82, 400, 121, 16);
		newPrivateCustomerPanel.add(textTelephoneNbr);

		JTextArea textMail = new JTextArea();
		textMail.setText("E-mail-adress:");
		textMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textMail.setEditable(false);
		textMail.setBackground(SystemColor.window);
		textMail.setBounds(90, 450, 113, 16);
		newPrivateCustomerPanel.add(textMail);

		JTextArea textDiscountLevel = new JTextArea();
		textDiscountLevel.setText("Rabatt:");
		textDiscountLevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDiscountLevel.setEditable(false);
		textDiscountLevel.setBackground(SystemColor.window);
		textDiscountLevel.setBounds(137, 499, 66, 16);
		newPrivateCustomerPanel.add(textDiscountLevel);

		/* ---- ACTION LISTENERS! ---- */

		btnBackNewPrivateCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "choosePanel");

				fieldEnterPersonalNbr.setText("");  // Resets the JTextField to be empty for the next registration.
				fieldEnterFirstName.setText("");
				fieldEnterLastName.setText("");
				fieldEnterAddress.setText("");
				fieldEnterCity.setText("");
				fieldEnterAreaCode.setText("");
				fieldEnterTelephoneNbr.setText("");
				fieldEnterMail.setText("");
				fieldEnterDiscountLevel.setText("");

			}
		});

		btnRegisterPrivateNewCustomer.addActionListener(new ActionListener() { // When clicked, new customer i registered!
			public void actionPerformed(ActionEvent e) {

				if(fieldEnterPersonalNbr.getText().equals("") 		|| 
						fieldEnterFirstName.getText().equals("")	||
						fieldEnterLastName.getText().equals("") 	||
						fieldEnterAddress.getText().equals("") 		||
						fieldEnterCity.getText().equals("") 		||
						fieldEnterAreaCode.getText().equals("") 	||
						fieldEnterTelephoneNbr.getText().equals("") || 
						fieldEnterMail.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Vänligen fyll i alla fält!");

				}

				else {

					String fieldEnteredPersonalNbr = fieldEnterPersonalNbr.getText();
					String fieldEnteredFirstName = fieldEnterFirstName.getText();
					String fieldEnteredLastName = fieldEnterLastName.getText();
					String fieldEnteredAddress = fieldEnterAddress.getText();
					String fieldEnteredCity = fieldEnterCity.getText();
					String fieldEnteredAreaCode = fieldEnterAreaCode.getText();
					String fieldEnteredTelephoneNbr = fieldEnterTelephoneNbr.getText();
					String fieldEnteredMail = fieldEnterMail.getText();

					controller.createPrivateCustomer(fieldEnteredPersonalNbr, fieldEnteredFirstName, fieldEnteredLastName, 
							fieldEnteredAddress, fieldEnteredCity, fieldEnteredAreaCode, fieldEnteredTelephoneNbr, fieldEnteredMail);

					fieldEnterPersonalNbr.setText("");// Resets the JTextField to be empty for the next registration.
					fieldEnterFirstName.setText("");
					fieldEnterLastName.setText("");
					fieldEnterAddress.setText("");
					fieldEnterCity.setText("");
					fieldEnterAreaCode.setText("");
					fieldEnterTelephoneNbr.setText("");
					fieldEnterMail.setText("");
					fieldEnterDiscountLevel.setText("");

					cardLayout.show(contentPane, "customerPanel"); // ... and return to the customer menu!

					JOptionPane.showMessageDialog(null, "Kunden är registrerad!"); // Tell the user that the customer has been registered!

				}
			}
		});

		/* ------------------------------------------------------------------------------------------------------------------------ */
		/* ----------------------------------------- Creates the NEW COMPANY CUSTOMER panel! -------------------------------------- */
		/* ------------------------------------------------------------------------------------------------------------------------ */

		/* ---- PANEL! --- */

		final JPanel newCompanyCustomerPanel = new JPanel();
		newCompanyCustomerPanel.setLayout(null);
		contentPane.add(newCompanyCustomerPanel, "newCompanyCustomerPanel");

		/* ---- BUTTONS! --- */

		JButton btnBackNewCompanyCustomer = new JButton("Tillbaka");
		btnBackNewCompanyCustomer.setBounds(10, 10, 150, 35);
		newCompanyCustomerPanel.add(btnBackNewCompanyCustomer);

		JButton btnRegisterNewCompanyCustomer = new JButton("Registrera kund");
		btnRegisterNewCompanyCustomer.setBounds(200, 550, 300, 75);
		newCompanyCustomerPanel.add(btnRegisterNewCompanyCustomer);

		/* ---- TEXT FIELDS! --- */

		final JTextField fieldEnterCompanyOrgNbr; 
		fieldEnterCompanyOrgNbr = new JTextField();
		fieldEnterCompanyOrgNbr.setText("");
		fieldEnterCompanyOrgNbr.setBounds(200, 95, 300, 30);
		newCompanyCustomerPanel.add(fieldEnterCompanyOrgNbr);
		fieldEnterCompanyOrgNbr.setColumns(10);

		final JTextField fieldEnterCompanyName; 
		fieldEnterCompanyName = new JTextField();
		fieldEnterCompanyName.setText("");
		fieldEnterCompanyName.setBounds(200, 145, 300, 30);
		newCompanyCustomerPanel.add(fieldEnterCompanyName);
		fieldEnterCompanyName.setColumns(10);

		final JTextField fieldEnterCompanyAdress; 
		fieldEnterCompanyAdress = new JTextField();
		fieldEnterCompanyAdress.setText("");
		fieldEnterCompanyAdress.setBounds(200, 195, 300, 30);
		newCompanyCustomerPanel.add(fieldEnterCompanyAdress);
		fieldEnterCompanyAdress.setColumns(10);

		final JTextField fieldEnterCompanyCity; 
		fieldEnterCompanyCity = new JTextField();
		fieldEnterCompanyCity.setText("");
		fieldEnterCompanyCity.setBounds(200, 245, 300, 30);
		newCompanyCustomerPanel.add(fieldEnterCompanyCity);
		fieldEnterCompanyCity.setColumns(10);

		final JTextField fieldEnterCompanyAreaCode; 
		fieldEnterCompanyAreaCode = new JTextField();
		fieldEnterCompanyAreaCode.setText("");
		fieldEnterCompanyAreaCode.setBounds(200, 295, 300, 30);
		newCompanyCustomerPanel.add(fieldEnterCompanyAreaCode);
		fieldEnterCompanyAreaCode.setColumns(10);

		final JTextField fieldEnterCompanyPhoneNbr; 
		fieldEnterCompanyPhoneNbr = new JTextField();
		fieldEnterCompanyPhoneNbr.setText("");
		fieldEnterCompanyPhoneNbr.setBounds(200, 345, 300, 30);
		newCompanyCustomerPanel.add(fieldEnterCompanyPhoneNbr);
		fieldEnterCompanyPhoneNbr.setColumns(10);

		final JTextField fieldEnterCompanyMailAdress; 
		fieldEnterCompanyMailAdress = new JTextField();
		fieldEnterCompanyMailAdress.setText("");
		fieldEnterCompanyMailAdress.setBounds(200, 395, 300, 30);
		newCompanyCustomerPanel.add(fieldEnterCompanyMailAdress);
		fieldEnterCompanyMailAdress.setColumns(10);

		/* ---- TEXT AREAS! --- */

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

		/* ---- ACTION LISTENERS! --- */

		btnRegisterNewCompanyCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				if(fieldEnterCompanyOrgNbr.getText().equals("") || fieldEnterCompanyName.getText().equals("") || fieldEnterCompanyAdress.getText().equals("") 
						|| fieldEnterCompanyCity.getText().equals("") || fieldEnterCompanyAreaCode.getText().equals("") ||
						fieldEnterCompanyPhoneNbr.getText().equals("") || fieldEnterCompanyMailAdress.getText().equals("")){

					JOptionPane.showMessageDialog(null, "Vänligen fyll i alla fält för registrering");

				}

				else {

					String fieldEnteredCompanyOrgNbr = fieldEnterCompanyOrgNbr.getText();
					String fieldEnteredCompanyName = fieldEnterCompanyName.getText();
					String fieldEnteredCompanyAdress = fieldEnterCompanyAdress.getText();
					String fieldEnteredCompanyCity = fieldEnterCompanyCity.getText();
					String fieldEnteredCompanyAreaCode = fieldEnterCompanyAreaCode.getText();
					String fieldEnteredCompanyPhoneNbr = fieldEnterCompanyPhoneNbr.getText();
					String fieldEnteredCompanyMailAdress = fieldEnterCompanyMailAdress.getText();

					controller.createCompanyCustomer(fieldEnteredCompanyOrgNbr, fieldEnteredCompanyName, fieldEnteredCompanyAdress, fieldEnteredCompanyCity,
							fieldEnteredCompanyAreaCode, fieldEnteredCompanyPhoneNbr, fieldEnteredCompanyMailAdress);

					cardLayout.show(contentPane, "customerPanel");
					JOptionPane.showMessageDialog(null, "Kunden är registrerad!"); // Tell the user that the customer has been registered!

					fieldEnterCompanyOrgNbr.setText(""); // Resets the JTextField to be empty for the next registration.
					fieldEnterCompanyName.setText("");
					fieldEnterCompanyAdress.setText("");
					fieldEnterCompanyCity.setText("");
					fieldEnterCompanyAreaCode.setText(""); 
					fieldEnterCompanyPhoneNbr.setText("");
					fieldEnterCompanyMailAdress.setText("");

				}
			}
		});

		btnBackNewCompanyCustomer.addActionListener(new ActionListener() { // When clicked, go back to customerPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "choosePanel");

				fieldEnterCompanyOrgNbr.setText(""); // Resets the JTextField to be empty for the next registration.
				fieldEnterCompanyName.setText("");
				fieldEnterCompanyAdress.setText("");
				fieldEnterCompanyCity.setText("");
				fieldEnterCompanyAreaCode.setText(""); 
				fieldEnterCompanyPhoneNbr.setText("");
				fieldEnterCompanyMailAdress.setText("");

			}
		});

	}

	/* -------------------------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------------------------- */

}
