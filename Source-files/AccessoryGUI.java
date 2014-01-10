
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
import objects.Accessory;

public class AccessoryGUI {

	final CardLayout cardLayout;
	final Container contentPane;
	final Controller controller;

	final JPanel accessoryPanel;
	final JPanel accessorySearchPanel;
	
	JButton btnSearchAccessory;
	JButton btnNewAccessory;
	final JButton btnEdit;
	final JButton btnSave;
	final JButton btnDelete;
	
	final JTextField fieldSearch;
	final JTextField fieldProductNbr;
	final JTextField fieldName;
	final JTextField fieldPrice;
	final JTextField fieldInfo;
	final JTextField fieldEnterName;
	final JTextField fieldEnterPrice;
	final JTextField fieldEnterInfo;

	JTextArea txtrProductNbr;
	JTextArea txtrSearchField;
	JTextArea txtrName;
	JTextArea txtrPrice;
	JTextArea txtrInfo;
	JTextArea txtrAccessoryName;
	
	private Accessory accessory;

	public AccessoryGUI(final Container contentPane,
			final CardLayout cardLayout, final Controller controller) {

		this.cardLayout = cardLayout;
		this.contentPane = contentPane;
		this.controller = controller;


		/* ----------------------------------------------------------------------------------*/
		/* -------------------------------- Creates the ACCESSORY----------------------------*/
		/* ----------------------------------------------------------------------------------*/

		/* ---- PANEL! --- */

		accessoryPanel = new JPanel();
		accessoryPanel.setLayout(null);
		contentPane.add(accessoryPanel, "accessoryPanel");

		/* ---- BUTTONS! ---- */

		btnSearchAccessory = new JButton("Sök tillbehör");
		btnSearchAccessory.setBounds(200, 225, 300, 75);
		accessoryPanel.add(btnSearchAccessory);

		btnNewAccessory = new JButton("Registrera tillbehör");
		btnNewAccessory.setBounds(200, 350, 300, 75);
		accessoryPanel.add(btnNewAccessory);

		JButton btnBackAccessory = new JButton("Tillbaka");
		btnBackAccessory.setBounds(10, 10, 150, 35);
		accessoryPanel.add(btnBackAccessory);

		/* ---- ACTION LISTENERS! --- */

		btnBackAccessory.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});

		btnSearchAccessory.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "accessorySearchPanel");
			}
		});

		btnNewAccessory.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane,"registerNewAccessoryPanel");
			}
		});

		/* ----------------------------------------------------------------------------------*/
		/* -----------------------CREATES THE SEARCH ACCESSORY-------------------------------*/
		/* ----------------------------------------------------------------------------------*/
		
		/* ---- PANEL! ---- */

		accessorySearchPanel = new JPanel();
		accessorySearchPanel.setLayout(null);
		contentPane.add(accessorySearchPanel, "accessorySearchPanel");

		/* ---- BUTTONS! ---- */

		JButton btnSearch = new JButton("Sök tillbehör");
		btnSearch.setBounds(200, 475, 300, 50);
		accessorySearchPanel.add(btnSearch);
		btnSearch.setVisible(true);

		JButton btnBackSearchAccessory = new JButton("Tillbaka");
		btnBackSearchAccessory.setBounds(10, 10, 150, 35);
		accessorySearchPanel.add(btnBackSearchAccessory);
		btnBackSearchAccessory.setVisible(true);

		btnEdit = new JButton("Ändra tillbehör");
		btnEdit.setVisible(false);
		btnEdit.setBounds(200, 537, 300, 50);
		accessorySearchPanel.add(btnEdit);

		btnSave = new JButton("Spara ändring");
		btnSave.setBounds(200, 537, 300, 50);
		btnSave.setVisible(false);
		accessorySearchPanel.add(btnSave);

		btnDelete = new JButton("Ta bort ");
		btnDelete.setBounds(200, 599, 300, 50);
		accessorySearchPanel.add(btnDelete);
		btnDelete.setVisible(false);

		/* ---- TEXT FIELDS! ---- */

		fieldSearch = new JTextField();
		fieldSearch.setBounds(225, 421, 250, 30);
		accessorySearchPanel.add(fieldSearch);

		fieldProductNbr = new JTextField();
		fieldProductNbr.setBounds(225, 150, 250, 30);
		fieldProductNbr.setEditable(false);
		fieldProductNbr.setText("");
		accessorySearchPanel.add(fieldProductNbr);

		fieldName = new JTextField();
		fieldName.setEditable(false);
		fieldName.setBounds(225, 83, 250, 30);
		fieldName.setText("");
		accessorySearchPanel.add(fieldName);

		fieldPrice = new JTextField();
		fieldPrice.setEditable(false);
		fieldPrice.setBounds(225, 215, 250, 30);
		fieldPrice.setText("");
		accessorySearchPanel.add(fieldPrice);

		fieldInfo = new JTextField();
		fieldInfo.setEditable(false);
		fieldInfo.setBounds(225, 283, 250, 50);
		fieldInfo.setText("");
		accessorySearchPanel.add(fieldInfo);

		/* ---- TEXT AREAS!! ---- */

		txtrProductNbr = new JTextArea();
		txtrProductNbr.setText("Ange produktnummer");
		txtrProductNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrProductNbr.setEditable(false);
		txtrProductNbr.setBackground(SystemColor.window);
		txtrProductNbr.setBounds(43, 428, 145, 23);
		accessorySearchPanel.add(txtrProductNbr);

		txtrSearchField = new JTextArea();
		txtrSearchField.setText("Produktnummer");
		txtrSearchField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrSearchField.setEditable(false);
		txtrSearchField.setBackground(SystemColor.window);
		txtrSearchField.setBounds(100, 157, 113, 23);
		accessorySearchPanel.add(txtrSearchField);

		txtrName = new JTextArea();
		txtrName.setEditable(false);
		txtrName.setText("Namn");
		txtrName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrName.setBackground(SystemColor.window);
		txtrName.setBounds(100, 90, 113, 23);
		accessorySearchPanel.add(txtrName);

		txtrPrice = new JTextArea();
		txtrPrice.setText("Pris");
		txtrPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrPrice.setEditable(false);
		txtrPrice.setBackground(SystemColor.window);
		txtrPrice.setBounds(100, 222, 113, 23);
		accessorySearchPanel.add(txtrPrice);

		txtrInfo = new JTextArea();
		txtrInfo.setText("Beskrivning");
		txtrInfo.setFont(new Font("Lucida Grande", Font.PLAIN,13));
		txtrInfo.setEditable(false);
		txtrInfo.setBackground(SystemColor.window);
		txtrInfo.setBounds(100, 283, 103, 23);
		accessorySearchPanel.add(txtrInfo);

		/* ---- ACTION LISTENERS! ---- */

		btnSearch.addActionListener(new ActionListener() { 
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
		/*--------------------------------- CREATES THE NEW ACCESSORY-------------------------------*/
		/* -----------------------------------------------------------------------------------------*/

		final JPanel registerNewAccessoryPanel = new JPanel();
		contentPane.add(registerNewAccessoryPanel, "registerNewAccessoryPanel");
		registerNewAccessoryPanel.setLayout(null);

		/* ---- TEXT FIELDS! ---- */


		fieldEnterName = new JTextField();
		fieldEnterName.setText("");
		fieldEnterName.setBounds(225, 74, 250, 30);
		registerNewAccessoryPanel.add(fieldEnterName);
		fieldEnterName.setColumns(10);

		fieldEnterPrice = new JTextField();
		fieldEnterPrice.setText("");
		fieldEnterPrice.setBounds(225, 145, 250, 30);
		fieldEnterPrice.setColumns(10);
		registerNewAccessoryPanel.add(fieldEnterPrice);

		fieldEnterInfo = new JTextField();
		fieldEnterInfo.setText("");
		fieldEnterInfo.setBounds(225, 225, 250, 85);
		registerNewAccessoryPanel.add(fieldEnterInfo);
		fieldEnterInfo.setColumns(10);

		/* ---- TEXT AREAS! ---- */

		txtrAccessoryName = new JTextArea();
		txtrAccessoryName.setEditable(false);
		txtrAccessoryName.setBackground(SystemColor.window);
		txtrAccessoryName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrAccessoryName.setText("Namn");
		txtrAccessoryName.setBounds(130, 81, 60, 27);
		registerNewAccessoryPanel.add(txtrAccessoryName);

		JTextArea txtrEnterPrice = new JTextArea(); 
		txtrEnterPrice.setEditable(false);
		txtrEnterPrice.setBackground(SystemColor.window);
		txtrEnterPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrEnterPrice.setText("Pris");
		txtrEnterPrice.setBounds(130, 152, 79, 27);
		registerNewAccessoryPanel.add(txtrEnterPrice);

		JTextArea txtrEnterInfo = new JTextArea(); 
		txtrEnterInfo.setEditable(false);
		txtrEnterInfo.setBackground(SystemColor.window);
		txtrEnterInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrEnterInfo.setText("Beskrivning");
		txtrEnterInfo.setBounds(130, 225, 79, 27);
		registerNewAccessoryPanel.add(txtrEnterInfo);

		/* -------- BUTTONS! --------- */

		JButton btnBackRegisterNewAccessory = new JButton("Tillbaka");
		btnBackRegisterNewAccessory.setBounds(10, 10, 150, 35);
		registerNewAccessoryPanel.add(btnBackRegisterNewAccessory);
		btnBackRegisterNewAccessory.setVisible(true);

		JButton btnRegisterNewAccessory = new JButton("Registrera tillbehör");
		btnRegisterNewAccessory.setBounds(200, 485, 300, 75);
		registerNewAccessoryPanel.add(btnRegisterNewAccessory);
		btnRegisterNewAccessory.setVisible(true);

		/* --------- ACTION LISTENERS! --------- */

		btnRegisterNewAccessory.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
				register();
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
	
	
	
	public void searchAccessory() {

		if (fieldSearch.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Vänligen ange produktnummer!");
		}

		else {

			btnEdit.setVisible(true);
			btnDelete.setVisible(true);
			btnSave.setVisible(false);
			fieldName.setEditable(false);
			fieldProductNbr.setEditable(false);
			fieldPrice.setEditable(false);
			fieldInfo.setEditable(false);

			int enteredProductNbr = Integer.parseInt(fieldSearch.getText()); 
			accessory = controller.findAccessory(enteredProductNbr); 
			
			if (accessory == null) {
				JOptionPane.showMessageDialog(null,
						"Kunde ej hitta tillbehör!");
			}

			else {

				fieldName.setText(accessory.getProductName()); 
				fieldProductNbr.setText(Integer.toString(accessory.getProductNbr()));
				fieldPrice.setText(Integer.toString(accessory.getPrice())); 
				fieldInfo.setText(accessory.getInfoTxt()); 

			}
		}
	}

	public void edit() {

		btnEdit.setVisible(false);
		btnDelete.setVisible(false);
		btnSave.setVisible(true);
		fieldName.setEditable(true);
		fieldProductNbr.setEditable(true);
		fieldPrice.setEditable(true);
		fieldInfo.setEditable(true);
	}

	public void saveEdit() {

		if (fieldName.getText().equals("") || fieldProductNbr.getText().equals("") || fieldPrice.getText().equals("")|| fieldName.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Du har inte fyllt i alla fält!");
		}

		else {

			cardLayout.show(contentPane, "accessoryPanel");
			accessory.setProductName(fieldName.getText());
			accessory.setPrice(Integer.parseInt(fieldPrice.getText()));
			accessory.setInfoTxt(fieldInfo.getText());

			fieldName.setText("");
			fieldProductNbr.setText("");
			fieldPrice.setText("");
			fieldInfo.setText("");
			fieldSearch.setText("");

			btnSave.setVisible(false);
			fieldName.setEditable(false);
			fieldProductNbr.setEditable(false);
			fieldPrice.setEditable(false);
			fieldInfo.setEditable(false);

			JOptionPane.showMessageDialog(null, "Ändring sparad.");
		}
	}
	
	public void delete() {
		controller.accessoryRegistry.removeAccessory(accessory);

		cardLayout.show(contentPane, "accessoryPanel");

		fieldName.setText("");
		fieldProductNbr.setText("");
		fieldPrice.setText("");
		fieldInfo.setText("");
		fieldSearch.setText("");

		fieldName.setEditable(false);
		fieldProductNbr.setEditable(false);
		fieldPrice.setEditable(false);
		fieldInfo.setEditable(false);
		JOptionPane.showMessageDialog(null, "Tillbehör raderat");
	}

	public void backFromSearch(){
		cardLayout.show(contentPane, "accessoryPanel");

		btnEdit.setVisible(false);
		btnDelete.setVisible(false);
		fieldName.setText("");
		fieldProductNbr.setText("");
		fieldPrice.setText("");
		fieldInfo.setText("");
		fieldSearch.setText("");

		fieldName.setEditable(false);
		fieldProductNbr.setEditable(false);
		fieldPrice.setEditable(false);
		fieldInfo.setEditable(false);
	}

	public void register(){
		if (fieldEnterName.getText().equals("")
				|| fieldEnterPrice.getText().equals("")
				|| fieldEnterInfo.getText().equals("")) {

			JOptionPane.showMessageDialog(null,
					"Alla fält måste var ifyllda");	
		}
		
		else {

			String inputName = fieldEnterName.getText();
			int inputPrice = Integer.parseInt(fieldEnterPrice.getText());
			String inputInfo = fieldEnterInfo.getText();

			Controller.createAccessory(inputName, inputPrice,inputInfo);
			JOptionPane.showMessageDialog(null,
					"Tillbehör registrerat");
			cardLayout.show(contentPane, "accessoryPanel");
			fieldEnterName.setText("");
			fieldEnterPrice.setText("");
			fieldEnterInfo.setText("");
		}
	}
	public void backFromRegister(){
		cardLayout.show(contentPane, "accessoryPanel");
		fieldEnterName.setText("");
		fieldEnterPrice.setText("");
		fieldEnterInfo.setText("");
	}
}
