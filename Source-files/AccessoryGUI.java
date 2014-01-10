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

	private Accessory accessory;

	public AccessoryGUI(final Container contentPane, final CardLayout cardLayout, final Controller controller) {

		this.cardLayout = cardLayout;
		this.contentPane = contentPane;
		this.controller = controller;

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ---------------------------------------------- Creates the ACCESSORY panel! ---------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/* ---- PANEL! --- */

		final JPanel accessoryPanel = new JPanel();
		accessoryPanel.setLayout(null);
		contentPane.add(accessoryPanel, "accessoryPanel");

		/* ---- BUTTONS! ---- */

		JButton btnSearchAccessory = new JButton("Sök tillbehör");
		btnSearchAccessory.setBounds(200, 225, 300, 75);
		accessoryPanel.add(btnSearchAccessory);

		JButton btnNewAccessory = new JButton("Registrera tillbehör");
		btnNewAccessory.setBounds(200, 350, 300, 75);
		accessoryPanel.add(btnNewAccessory);

		JButton btnBackAccessory = new JButton("Tillbaka");
		btnBackAccessory.setBounds(10, 10, 150, 35);
		accessoryPanel.add(btnBackAccessory);

		/* ---- ACTION LISTENERS! --- */

		btnBackAccessory.addActionListener(new ActionListener() { // When clicked, go back to mainPanel!
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});

		btnSearchAccessory.addActionListener(new ActionListener() { // When clicked, go to accessorySearchPanel!
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "accessorySearchPanel");
			}
		});

		btnNewAccessory.addActionListener(new ActionListener() { // When clicked, go to registerNewAccessoryPanel!
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "registerNewAccessoryPanel");
			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ---------------------------------------- Creates the SEARCH ACCESSORY panel! --------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/* ---- PANEL! ---- */
		
		final JPanel accessorySearchPanel = new JPanel();
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

		final JButton btnEdit = new JButton("Ändra tillbehör");
		btnEdit.setVisible(false);
		btnEdit.setBounds(200, 537, 300, 50);
		accessorySearchPanel.add(btnEdit);

		final JButton btnSave = new JButton("Spara ändring");             
		btnSave.setBounds(200, 537, 300, 50);
		btnSave.setVisible(false);
		accessorySearchPanel.add(btnSave);

		final JButton btnDelete = new JButton("Ta bort ");
		btnDelete.setBounds(200, 599, 300, 50);
		accessorySearchPanel.add(btnDelete);
		btnDelete.setVisible(false);
		
		/* ---- TEXT FIELDS! ---- */

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

		/* ---- TEXT AREAS!! ---- */

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

		/* ---- ACTION LISTENERS! ---- */

		btnSearch.addActionListener(new ActionListener() { // When search button is pressed...
			public void actionPerformed(ActionEvent e) {

				if(fieldEnterProductNbr.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Vänligen ange produktnummer!");
				}

				else {

					btnEdit.setVisible(true);
					btnDelete.setVisible(true);
					btnSave.setVisible(false);
					fieldSearchAccessoryName.setEditable(false);
					fieldSearchAccessoryProductNbr.setEditable(false);
					fieldSearchAccessoryPrice.setEditable(false);
					fieldSearchAccessoryInfo.setEditable(false);

					int enteredProductNbr = Integer.parseInt(fieldEnterProductNbr.getText()); // Get text from search field...

					accessory = controller.findAccessory(enteredProductNbr); // ... find the accessory...

					if (accessory == null){

						JOptionPane.showMessageDialog(null, "Kunde ej hitta tillbehör!");

					}

					else {

						fieldSearchAccessoryName.setText(accessory.getProductName()); // ... and print the text
						fieldSearchAccessoryProductNbr.setText(Integer.toString(accessory.getProductNbr())); // ... and print the text
						fieldSearchAccessoryPrice.setText(Integer.toString(accessory.getPrice())); // ... and print the text
						fieldSearchAccessoryInfo.setText(accessory.getInfoTxt()); // ... and print the text

					}
				}
			}
		}); 

		btnEdit.addActionListener(new ActionListener() { // When change button is pressed...
			public void actionPerformed(ActionEvent e){

				btnEdit.setVisible(false);
				btnDelete.setVisible(false);

				btnSave.setVisible(true);
				fieldSearchAccessoryName.setEditable(true);
				fieldSearchAccessoryProductNbr.setEditable(true);
				fieldSearchAccessoryPrice.setEditable(true);
				fieldSearchAccessoryInfo.setEditable(true);

			}
		}); 


		btnSave.addActionListener(new ActionListener() { // When change button is pressed...
			public void actionPerformed(ActionEvent e){

				if(fieldSearchAccessoryName.getText().equals("") || fieldSearchAccessoryProductNbr.getText().equals("") || fieldSearchAccessoryPrice.getText().equals("") || fieldSearchAccessoryName.getText().equals("")){

					JOptionPane.showMessageDialog(null, "Du har inte fyllt i alla fält!");                           
				}

				else {

					cardLayout.show(contentPane, "accessoryPanel");
					accessory.setProductName(fieldSearchAccessoryName.getText());    // changes the name for an accessory 
					accessory.setPrice(Integer.parseInt(fieldSearchAccessoryPrice.getText()));//...price
					accessory.setInfoTxt(fieldSearchAccessoryInfo.getText());//...info text

					fieldSearchAccessoryName.setText("");
					fieldSearchAccessoryProductNbr.setText("");
					fieldSearchAccessoryPrice.setText("");
					fieldSearchAccessoryInfo.setText("");
					fieldEnterProductNbr.setText("");

					btnSave.setVisible(false);
					fieldSearchAccessoryName.setEditable(false);
					fieldSearchAccessoryProductNbr.setEditable(false);
					fieldSearchAccessoryPrice.setEditable(false);
					fieldSearchAccessoryInfo.setEditable(false);

					JOptionPane.showMessageDialog(null, "Ändring sparad.");

				}                            
			}
		});

		btnDelete.addActionListener(new ActionListener() { // When delete button is pressed...
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

				btnEdit.setVisible(false);
				btnDelete.setVisible(false);
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

		/* ---- TEXT FIELDS! ---- */

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

		/* ---- TEXT AREAS! ---- */

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

		/* ---- BUTTONS! ---- */

		JButton btnBackRegisterNewAccessory = new JButton("Tillbaka");
		btnBackRegisterNewAccessory.setBounds(10, 10, 150, 35);
		registerNewAccessoryPanel.add(btnBackRegisterNewAccessory);
		btnBackRegisterNewAccessory.setVisible(true);

		JButton btnRegisterNewAccessory = new JButton("Registrera tillbehör");        
		btnRegisterNewAccessory.setBounds(200, 485, 300, 75);
		registerNewAccessoryPanel.add(btnRegisterNewAccessory);
		btnRegisterNewAccessory.setVisible(true);

		/* ---- ACTION LISTENERS! ---- */        

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

	}

	/* -------------------------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------------------------- */

}
