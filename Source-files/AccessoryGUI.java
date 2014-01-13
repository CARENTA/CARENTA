package GUI;

import java.awt.CardLayout;

public class AccessoryGUI {

	CardLayout cardLayout;
	Container contentPane;
	Controller controller;

	JPanel accessoryPanel;
	JPanel searchAccessoryPanel;
	JPanel newAccessoryPanel;

	JButton btnSearch;
	JButton btnNew;
	JButton btnEdit;
	JButton btnSave;
	JButton btnDelete;
	JButton btnNewSearch;
	JButton btnBackSearchAccessory;

	JTextField fieldProductNbr;
	JTextField fieldName;
	JTextField fieldPrice;
	JTextField fieldInfo;
	JTextField fieldEnterName;
	JTextField fieldEnterPrice;
	JTextField fieldEnterProductNbr;
	JTextField fieldEnterInfo;

	JTextArea textProductNbr;
	JTextArea textName;
	JTextArea textPrice;
	JTextArea textInfo;
	JTextArea textEnterName;
	JTextArea textEnterPrice;
	JTextArea textEnterInfo;
	JTextArea textEnterProductNbr;
	

	/* ---- GLOBAL VARIABLES! ---- */

	private Accessory accessory;

	public AccessoryGUI( final Container contentPane,  final CardLayout cardLayout,  Controller controller) {

		this.cardLayout = cardLayout;
		this.contentPane = contentPane;
		this.controller = controller;


		/* ----------------------------------------------------------------------------------*/
		/* ------------------------------ Creates the ACCESSORY! ----------------------------*/
		/* ----------------------------------------------------------------------------------*/

		/* ---- PANEL! --- */

		accessoryPanel = new JPanel();
		accessoryPanel.setLayout(null);
		contentPane.add(accessoryPanel, "accessoryPanel");

		/* ---- BUTTONS! ---- */

		btnSearch = new JButton("Sök tillbehör");
		btnSearch.setBounds(200, 225, 300, 75);
		accessoryPanel.add(btnSearch);

		btnNew = new JButton("Registrera tillbehör");
		btnNew.setBounds(200, 350, 300, 75);
		accessoryPanel.add(btnNew);

		JButton btnBackAccessory = new JButton("Tillbaka");
		btnBackAccessory.setBounds(10, 10, 150, 35);
		accessoryPanel.add(btnBackAccessory);

		/* ---- ACTION LISTENERS! --- */

		btnSearch.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				searchAccessory();
			}
		});

		btnNew.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane,"newAccessoryPanel");
			}
		});

		btnBackAccessory.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});

		/* ----------------------------------------------------------------------------------*/
		/* -------------------------- CREATES THE SEARCH ACCESSORY! -------------------------*/
		/* ----------------------------------------------------------------------------------*/

		/* ---- PANEL! ---- */

		searchAccessoryPanel = new JPanel();
		searchAccessoryPanel.setLayout(null);
		contentPane.add(searchAccessoryPanel, "searchAccessoryPanel");

		/* ---- BUTTONS! ---- */

		btnNewSearch = new JButton("Ny sökning");
		btnNewSearch.setBounds(540, 10, 150, 35);
		searchAccessoryPanel.add(btnNewSearch);
		btnNewSearch.setVisible(true);

		btnBackSearchAccessory = new JButton("Tillbaka");
		btnBackSearchAccessory.setBounds(10, 10, 150, 35);
		searchAccessoryPanel.add(btnBackSearchAccessory);
		btnBackSearchAccessory.setVisible(true);

		btnEdit = new JButton("Ändra tillbehör");
		btnEdit.setVisible(false);
		btnEdit.setBounds(200, 365, 300, 75);
		searchAccessoryPanel.add(btnEdit);

		btnSave = new JButton("Spara ändring");
		btnSave.setBounds(200, 365, 300, 75);
		btnSave.setVisible(false);
		searchAccessoryPanel.add(btnSave);

		btnDelete = new JButton("Ta bort ");
		btnDelete.setBounds(200, 465, 300, 75);
		searchAccessoryPanel.add(btnDelete);
		btnDelete.setVisible(false);

		/* ---- TEXT FIELDS! ---- */
		
		fieldName = new JTextField();
		fieldName.setEditable(false);
		fieldName.setBounds(225, 80, 250, 30);
		fieldName.setText("");
		searchAccessoryPanel.add(fieldName);
		
		fieldProductNbr = new JTextField();
		fieldProductNbr.setBounds(225, 150, 250, 30);
		fieldProductNbr.setEditable(false);
		fieldProductNbr.setText("");
		searchAccessoryPanel.add(fieldProductNbr);

		fieldPrice = new JTextField();
		fieldPrice.setEditable(false);
		fieldPrice.setBounds(225, 220, 250, 30);
		fieldPrice.setText("");
		searchAccessoryPanel.add(fieldPrice);

		fieldInfo = new JTextField();
		fieldInfo.setEditable(false);
		fieldInfo.setBounds(225, 290, 250, 30);
		fieldInfo.setText("");
		searchAccessoryPanel.add(fieldInfo);

		/* ---- TEXT AREAS!! ---- */
		
		textName = new JTextArea();
		textName.setEditable(false);
		textName.setText("Namn:");
		textName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textName.setBackground(SystemColor.window);
		textName.setBounds(178, 85, 46, 23);
		searchAccessoryPanel.add(textName);

		textProductNbr = new JTextArea();
		textProductNbr.setEditable(false);
		textProductNbr.setBackground(SystemColor.window);
		textProductNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textProductNbr.setText("Produktnummer:");
		textProductNbr.setBounds(110, 155, 150, 23);
		searchAccessoryPanel.add(textProductNbr);
		
		textPrice = new JTextArea();
		textPrice.setText("Pris:");
		textPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPrice.setEditable(false);
		textPrice.setBackground(SystemColor.window);
		textPrice.setBounds(190, 225, 30, 23);
		searchAccessoryPanel.add(textPrice);

		textInfo = new JTextArea();
		textInfo.setText("Beskrivning:");
		textInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textInfo.setEditable(false);
		textInfo.setBackground(SystemColor.window);
		textInfo.setBounds(140, 295, 80, 23);
		searchAccessoryPanel.add(textInfo);

		/* ---- ACTION LISTENERS! ---- */

		btnNewSearch.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {

				searchAccessory();
			}
		});

		btnEdit.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {

				edit();
			}
		});

		btnSave.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {

				saveEdit();
			}
		});


		btnDelete.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {

				delete();
			}
		});

		btnBackSearchAccessory.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {

				backFromSearch();
			}
		});

		/* -----------------------------------------------------------------------------------------*/
		/*------------------------------- CREATES THE NEW ACCESSORY! -------------------------------*/
		/* -----------------------------------------------------------------------------------------*/

		/* ---- PANEL! ---- */

		newAccessoryPanel = new JPanel();
		contentPane.add(newAccessoryPanel, "newAccessoryPanel");
		newAccessoryPanel.setLayout(null);

		/* ---- TEXT FIELDS! ---- */

		fieldEnterName = new JTextField();
		fieldEnterName.setText("");
		fieldEnterName.setBounds(225, 80, 250, 30);
		newAccessoryPanel.add(fieldEnterName);
		fieldEnterName.setColumns(10);
		
		fieldEnterProductNbr = new JTextField();
		fieldEnterProductNbr.setText("Lämnas blankt om automatiskt!");
		fieldEnterProductNbr.setBounds(225, 150, 250, 30);
		fieldEnterProductNbr.setColumns(10);
		newAccessoryPanel.add(fieldEnterProductNbr);
		
		fieldEnterPrice = new JTextField();
		fieldEnterPrice.setText("");
		fieldEnterPrice.setBounds(225, 220, 250, 30);
		fieldEnterPrice.setColumns(10);
		newAccessoryPanel.add(fieldEnterPrice);
		
		fieldEnterInfo = new JTextField();
		fieldEnterInfo.setText("");
		fieldEnterInfo.setBounds(225, 290, 250, 30);
		newAccessoryPanel.add(fieldEnterInfo);
		fieldEnterInfo.setColumns(10);
		
		/* ---- MOUSE LISTENER! ---- */
		
		fieldEnterProductNbr.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fieldEnterProductNbr.setText("");
			}
		});

		/* ---- TEXT AREAS! ---- */

		textEnterName = new JTextArea();
		textEnterName.setEditable(false);
		textEnterName.setBackground(SystemColor.window);
		textEnterName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEnterName.setText("Namn:");
		textEnterName.setBounds(178, 85, 60, 23);
		newAccessoryPanel.add(textEnterName);

		textEnterProductNbr = new JTextArea();
		textEnterProductNbr.setEditable(false);
		textEnterProductNbr.setBackground(SystemColor.window);
		textEnterProductNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEnterProductNbr.setText("Produktnummer:");
		textEnterProductNbr.setBounds(110, 155, 150, 23);
		newAccessoryPanel.add(textEnterProductNbr);
		
		textEnterPrice = new JTextArea(); 
		textEnterPrice.setEditable(false);
		textEnterPrice.setBackground(SystemColor.window);
		textEnterPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEnterPrice.setText("Pris:");
		textEnterPrice.setBounds(190, 225, 79, 23);
		newAccessoryPanel.add(textEnterPrice);
		
		textEnterInfo = new JTextArea();
		textEnterInfo.setEditable(false);
		textEnterInfo.setBackground(SystemColor.window);
		textEnterInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEnterInfo.setText("Beskrivning:");
		textEnterInfo.setBounds(140, 295, 80, 23);
		newAccessoryPanel.add(textEnterInfo);

		/* -------- BUTTONS! --------- */

		JButton btnBackRegisterNewAccessory = new JButton("Tillbaka");
		btnBackRegisterNewAccessory.setBounds(10, 10, 150, 35);
		newAccessoryPanel.add(btnBackRegisterNewAccessory);
		btnBackRegisterNewAccessory.setVisible(true);

		JButton btnRegisterNewAccessory = new JButton("Registrera tillbehör");
		btnRegisterNewAccessory.setBounds(200, 485, 300, 75);
		newAccessoryPanel.add(btnRegisterNewAccessory);
		btnRegisterNewAccessory.setVisible(true);

		/* --------- ACTION LISTENERS! --------- */

		btnRegisterNewAccessory.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {

				create();
			}
		});

		btnBackRegisterNewAccessory.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {

				backFromRegister();
			}
		});
	}

	/*------------------------------------------------------------------------------------------*/
	/*---------------------------------------- METHODS! ----------------------------------------*/
	/*------------------------------------------------------------------------------------------*/

	/* The following method will perform a search of the accessory
	 * and show it, if it exists! */

	public void searchAccessory() {

		try {

			String userInput = JOptionPane.showInputDialog(null, "Ange produktnummer:");
			int enteredProductNbr = Integer.parseInt(userInput); // Fetch user input...
			accessory = controller.findAccessory(enteredProductNbr); // ... find the accessory!


			if (accessory != null) {

				btnEdit.setVisible(true); // Hide and show relevant elements!
				btnDelete.setVisible(true);
				btnSave.setVisible(false);
				fieldName.setEditable(false);
				fieldProductNbr.setEditable(false);
				fieldPrice.setEditable(false);
				fieldInfo.setEditable(false);

				fieldName.setText(accessory.getProductName()); // Show accessory information!
				fieldProductNbr.setText(Integer.toString(accessory.getProductNbr()));
				fieldPrice.setText(Integer.toString(accessory.getPrice())); 
				fieldInfo.setText(accessory.getInfoTxt());

				cardLayout.show(contentPane,"searchAccessoryPanel");

			}

			else { 

				fieldName.setText("");
				fieldProductNbr.setText("");
				fieldPrice.setText("");
				fieldInfo.setText("");

				btnEdit.setVisible(false);
				btnDelete.setVisible(false);

				JOptionPane.showMessageDialog(null, "Det finns inget tillbehör kopplat till detta produktnummer!");

			}		
		}

		catch (Exception e) { JOptionPane.showMessageDialog(null, "Skriv in ett giltigt produktnummer!");

		btnEdit.setVisible(false); // Hide and show relevant elements!
		btnDelete.setVisible(false);
		btnSave.setVisible(false);
		fieldName.setEditable(false);
		fieldProductNbr.setEditable(false);
		fieldPrice.setEditable(false);
		fieldInfo.setEditable(false);

		fieldName.setText(""); // Reset accessory information!
		fieldProductNbr.setText("");
		fieldPrice.setText("");
		fieldInfo.setText("");

		}
	}

	/*------------------------------------------------------------------------------------------*/

	/* The following method will make editing the information of an accessory possible! */

	public void edit() {

		btnEdit.setVisible(false);
		btnDelete.setVisible(false);
		btnSave.setVisible(true);
		fieldName.setEditable(true);
		fieldProductNbr.setEditable(true);
		fieldPrice.setEditable(true);
		fieldInfo.setEditable(true);
	}

	/*------------------------------------------------------------------------------------------*/

	/* The following method will save an edited accessory information! */

	public void saveEdit() {

		try {

			if (fieldName.getText().equals("") || fieldInfo.getText().equals("")) { 

				JOptionPane.showMessageDialog(null,"Du har inte fyllt i alla fält korrekt!");

			}

			else {

				if ((controller.findAccessory(Integer.parseInt(fieldProductNbr.getText())) == null || 
						accessory.getProductNbr() == Integer.parseInt(fieldProductNbr.getText())) && Integer.parseInt(fieldProductNbr.getText()) > 0) { // Check if product number already exists...

					accessory.setProductName(fieldName.getText());
					accessory.setProductNbr(Integer.parseInt(fieldProductNbr.getText()));
					accessory.setPrice(Integer.parseInt(fieldPrice.getText()));
					accessory.setInfoTxt(fieldInfo.getText());

					fieldName.setText("");
					fieldProductNbr.setText("");
					fieldPrice.setText("");
					fieldInfo.setText("");
					fieldEnterProductNbr.setText("");

					btnSave.setVisible(false);
					fieldName.setEditable(false);
					fieldProductNbr.setEditable(false);
					fieldPrice.setEditable(false);
					fieldInfo.setEditable(false);
					btnEdit.setVisible(false);
					btnDelete.setVisible(false);

					JOptionPane.showMessageDialog(null, "Ändring sparad.");

					cardLayout.show(contentPane, "accessoryPanel");

				}

				else {
					JOptionPane.showMessageDialog(null, "Produktnumret finns redan! Välj ett annat.");

				}
			}
		}

		catch (Exception e) { 

			btnSave.setVisible(false);
			fieldName.setEditable(false);
			fieldProductNbr.setEditable(false);
			fieldPrice.setEditable(false);
			fieldInfo.setEditable(false);
			btnEdit.setVisible(false);
			btnDelete.setVisible(false);
			fieldName.setText("");
			fieldProductNbr.setText("");
			fieldPrice.setText("");
			fieldInfo.setText("");
			fieldEnterProductNbr.setText("");

			JOptionPane.showMessageDialog(null,"Du har inte fyllt i alla fält korrekt!");

		}
	}

	/*------------------------------------------------------------------------------------------*/

	/* The following method will create an accessory! */

	public void create() {

		try {

			if (fieldEnterName.getText().equals("") || fieldEnterInfo.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "Alla fält måste var ifyllda korrekt!");

			}

			else {

				String inputName = fieldEnterName.getText();
				int inputPrice = Integer.parseInt(fieldEnterPrice.getText());
				String inputInfo = fieldEnterInfo.getText();
				int inputProductNbr = Integer.parseInt(fieldEnterProductNbr.getText());

				Accessory accessory = controller.findAccessory(inputProductNbr); // Checking if productNbr already exists...
				
				if(inputProductNbr >= 0 && accessory == null) {
				
					String confirmation = Controller.createAccessory(inputName, inputPrice, inputInfo, inputProductNbr);

					fieldEnterName.setText("");
					fieldEnterPrice.setText("");
					fieldEnterInfo.setText("");
					fieldEnterProductNbr.setText("");

					cardLayout.show(contentPane, "accessoryPanel");
				
					JOptionPane.showMessageDialog(null, confirmation);
					
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "Du måste ange ett tillåtet produktnummer!");
					
				}
				
			}
		}

		catch(Exception e) {

			JOptionPane.showMessageDialog(null, "Alla fält måste var ifyllda korrekt!");

		}
	}

	/*------------------------------------------------------------------------------------------*/

	/* The following method will delete the accessory! */

	public void delete() {

		controller.accessoryRegistry.removeAccessory(accessory);

		fieldName.setText("");
		fieldProductNbr.setText("");
		fieldPrice.setText("");
		fieldInfo.setText("");

		fieldName.setEditable(false);
		fieldProductNbr.setEditable(false);
		fieldPrice.setEditable(false);
		fieldInfo.setEditable(false);

		JOptionPane.showMessageDialog(null, "Tillbehör raderat");

		cardLayout.show(contentPane, "accessoryPanel");

	}

	/*------------------------------------------------------------------------------------------*/

	/* The following methods will edit the accessory information! */

	public void backFromSearch() {

		btnEdit.setVisible(false);
		btnDelete.setVisible(false);
		fieldName.setText("");
		fieldProductNbr.setText("");
		fieldPrice.setText("");
		fieldInfo.setText("");
		fieldEnterProductNbr.setText("");

		fieldName.setEditable(false);
		fieldProductNbr.setEditable(false);
		fieldPrice.setEditable(false);
		fieldInfo.setEditable(false);


		cardLayout.show(contentPane, "accessoryPanel");

	}

	public void backFromRegister(){

		fieldEnterName.setText("");
		fieldEnterPrice.setText("");
		fieldEnterInfo.setText("");
		fieldEnterProductNbr.setText("");

		cardLayout.show(contentPane, "accessoryPanel");

	}

	/*------------------------------------------------------------------------------------------*/
	/*------------------------------------------------------------------------------------------*/
	/*------------------------------------------------------------------------------------------*/

}
