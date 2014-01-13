package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import objects.Vehicle;
import controller.Controller;

public class VehicleGUI {

	CardLayout cardLayout;
	Container contentPane;
	Controller controller;

	JPanel vehiclePanel;
	JPanel searchVehiclePanel;
	JPanel newVehiclePanel;

	JButton btnSearch;
	JButton btnNew; 
	JButton btnEdit; 
	JButton btnDelete; 
	JButton btnSaveEdit;
	JButton btnCreateVehicle;
	JButton btnBackVehicle; 
	JButton btnBackSearchVehicle;
	JButton btnBackNewVehicle;
	JButton btnNewSearch;
	JTextField fieldRegNbr;
	JTextField fieldModel;
	JTextField fieldType; 
	JTextField fieldLicenseReq;
	JTextField fieldPrice; 
	JTextField fieldInfo;
	JTextField fieldHasHook; 
	JTextField fieldExpiryDate;
	JTextField fieldWarehouse; 
	JTextField fieldNewRegNbr;
	JTextField fieldNewModel; 
	JTextField fieldNewType;
	JTextField fieldNewLicenseReq;
	JTextField fieldNewPrice; 
	JTextField fieldNewInfo;
	JTextField fieldNewHasHook;
	JTextField fieldNewExpiryDate;               
	JTextField fieldNewWarehouse;

	JTextArea textRegNbr;
	JTextArea textModel;
	JTextArea textType;
	JTextArea textLicenseReq;
	JTextArea textPrice; 
	JTextArea textInfo;
	JTextArea textHasHook;
	JTextArea textExpiryDate;
	JTextArea textWarehouse;
	JTextArea textNewRegNbr;
	JTextArea textNewModel;
	JTextArea textNewType;
	JTextArea textNewLicenseReq; 
	JTextArea textNewPrice;
	JTextArea textNewInfo;            
	JTextArea textNewHasHook; 
	JTextArea textNewExpiryDate;    
	JTextArea textNewWarehouse; 

	/* ---- GLOBAL VARIABLES! ---- */

	private Vehicle vehicle;

	public VehicleGUI (final Container contentPane, final CardLayout cardLayout, final Controller controller) {

		this.cardLayout = cardLayout;
		this.contentPane = contentPane;
		this.controller = controller;

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the VEHICLE panel! ----------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/*------------- PANEL-------------*/

		vehiclePanel = new JPanel();
		vehiclePanel.setLayout(null);
		contentPane.add(vehiclePanel, "vehiclePanel");

		/*------------- BUTTONS-------------*/

		btnSearch = new JButton("Sök fordon");
		btnSearch.setBounds(200, 225, 300, 75);
		vehiclePanel.add(btnSearch);

		btnNew = new JButton("Registrera fordon");
		btnNew.setBounds(200, 350, 300, 75);
		vehiclePanel.add(btnNew);

		btnBackVehicle = new JButton("Tillbaka");
		btnBackVehicle.setBounds(10, 10, 150, 35);
		vehiclePanel.add(btnBackVehicle);

		/*------------- ACTION LISTENER-------------*/

		btnBackVehicle.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});

		btnSearch.addActionListener(new ActionListener() { // To come in to the search button
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});

		btnNew.addActionListener(new ActionListener() { // To come in to the registerVehicle button
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "newVehiclePanel");
			}
		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ---------------------------------------- Creates the SEARCH VEHICLE panel! ----------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/* ---- PANEL!---- */

		searchVehiclePanel = new JPanel();
		searchVehiclePanel.setLayout(null);
		contentPane.add(searchVehiclePanel, "searchVehiclePanel");

		/* ---- BUTTONS! ---- */

		btnBackSearchVehicle = new JButton("Tillbaka");
		btnBackSearchVehicle.setBounds(10, 10, 100, 25);
		searchVehiclePanel.add(btnBackSearchVehicle);
		btnBackSearchVehicle.setVisible(true);

		btnEdit = new JButton ("Ändra fordon");
		btnEdit.setBounds (225, 430, 250, 75);
		searchVehiclePanel.add(btnEdit);
		btnEdit.setVisible(true);

		btnDelete = new JButton ("Ta bort fordon");
		btnDelete.setBounds (225, 534, 250, 75);
		searchVehiclePanel.add(btnDelete);
		btnDelete.setVisible(true);

		btnSaveEdit = new JButton("Spara ändring");             
		btnSaveEdit.setBounds(225, 430, 250, 75);
		btnSaveEdit.setVisible(false);
		searchVehiclePanel.add(btnSaveEdit);
		btnSaveEdit.setVisible(false);
		
		btnNewSearch = new JButton("Ny sökning");
		btnNewSearch.setBounds(577, 10, 117, 25);
		searchVehiclePanel.add(btnNewSearch);

		/* ---- TEXT FIELDS! ---- */

		fieldRegNbr = new JTextField();
		fieldRegNbr.setText("");
		fieldRegNbr.setBounds(225, 50, 250, 30);
		searchVehiclePanel.add(fieldRegNbr);
		fieldRegNbr.setColumns(10);
		fieldRegNbr.setEditable(false);

		fieldModel = new JTextField();
		fieldModel.setText("");
		fieldModel.setBounds(225, 90, 250, 30);
		searchVehiclePanel.add(fieldModel);
		fieldModel.setColumns(10);
		fieldModel.setEditable(false);

		fieldType = new JTextField();
		fieldType.setText("");
		fieldType.setBounds(225, 130, 250, 30);
		searchVehiclePanel.add(fieldType);
		fieldType.setColumns(10);
		fieldType.setEditable(false);

		fieldLicenseReq = new JTextField();
		fieldLicenseReq.setText("");
		fieldLicenseReq.setBounds(225, 170, 250, 30);
		searchVehiclePanel.add(fieldLicenseReq);
		fieldLicenseReq.setColumns(10);
		fieldLicenseReq.setEditable(false);

		fieldPrice = new JTextField();
		fieldPrice.setText("");
		fieldPrice.setColumns(10);
		fieldPrice.setBounds(225, 210, 250, 30);
		searchVehiclePanel.add(fieldPrice);
		fieldPrice.setEditable(false);

		fieldInfo = new JTextField();
		fieldInfo.setText("");
		fieldInfo.setColumns(10);
		fieldInfo.setBounds(225, 250, 250, 30);
		searchVehiclePanel.add(fieldInfo);
		fieldInfo.setEditable(false);

		fieldHasHook = new JTextField();
		fieldHasHook.setText("");
		fieldHasHook.setColumns(10);
		fieldHasHook.setBounds(225, 290, 250, 30);
		searchVehiclePanel.add(fieldHasHook);
		fieldHasHook.setEditable(false);

		fieldExpiryDate = new JTextField();
		fieldExpiryDate.setText("");
		fieldExpiryDate.setColumns(10);
		fieldExpiryDate.setBounds(225, 330, 249, 30);
		searchVehiclePanel.add(fieldExpiryDate);
		fieldExpiryDate.setEditable(false);

		fieldWarehouse = new JTextField();
		fieldWarehouse.setText("");
		fieldWarehouse.setColumns(10);
		fieldWarehouse.setBounds(225, 370, 250, 30);
		searchVehiclePanel.add(fieldWarehouse);
		fieldWarehouse.setEditable(false);

		/* ---- TEXT AREAS! ---- */

		textRegNbr = new JTextArea();
		textRegNbr.setText ("Registreringsnummer:");
		textRegNbr.setBounds(58, 55, 164, 22);
		searchVehiclePanel.add(textRegNbr);
		textRegNbr.setFont(new Font("Tahama", Font.PLAIN,15));
		textRegNbr.setBackground(SystemColor.window);
		textRegNbr.setEditable(false);

		textModel = new JTextArea();
		textModel.setText ("Modell:");
		textModel.setBounds(163, 95, 59, 22);
		searchVehiclePanel.add(textModel);
		textModel.setFont(new Font("Tahama", Font.PLAIN,15));
		textModel.setBackground(SystemColor.window);
		textModel.setEditable(false);

		textType = new JTextArea();
		textType.setText ("Fordonstyp:");
		textType.setBounds(129, 135, 93, 22);
		searchVehiclePanel.add(textType);
		textType.setFont(new Font("Tahama", Font.PLAIN,15));
		textType.setBackground(SystemColor.window);
		textType.setEditable(false);

		textLicenseReq = new JTextArea();
		textLicenseReq.setText ("Körkortskrav:");
		textLicenseReq.setBounds(115, 175, 107, 22);
		searchVehiclePanel.add(textLicenseReq);
		textLicenseReq.setFont(new Font("Tahama", Font.PLAIN,15));
		textLicenseReq.setBackground(SystemColor.window);
		textLicenseReq.setEditable(false);

		textPrice = new JTextArea();
		textPrice.setSelectedTextColor(Color.WHITE);
		textPrice.setText ("Pris:");
		textPrice.setBounds(183, 215, 39, 22);
		searchVehiclePanel.add(textPrice);
		textPrice.setFont(new Font("Tahama", Font.PLAIN,15));
		textPrice.setBackground(SystemColor.window);
		textPrice.setEditable(false);

		textInfo = new JTextArea();
		textInfo.setText ("Beskrivning:");
		textInfo.setBounds(129, 255, 93, 22);
		searchVehiclePanel.add(textInfo);
		textInfo.setFont(new Font("Tahama", Font.PLAIN,15));
		textInfo.setBackground(SystemColor.window);
		textInfo.setEditable(false);

		textHasHook = new JTextArea();
		textHasHook.setText ("Dragkrok:");
		textHasHook.setBounds(143, 295, 79, 22);
		searchVehiclePanel.add(textHasHook);
		textHasHook.setFont(new Font("Tahama", Font.PLAIN,15));
		textHasHook.setBackground(SystemColor.window);
		textHasHook.setEditable(false);

		textExpiryDate = new JTextArea();
		textExpiryDate.setText ("Utgångsdatum:");
		textExpiryDate.setBounds(105, 335, 117, 22);
		searchVehiclePanel.add(textExpiryDate);
		textExpiryDate.setFont(new Font("Dialog", Font.PLAIN, 15));
		textExpiryDate.setBackground(SystemColor.window);
		textExpiryDate.setEditable(false);

		textWarehouse = new JTextArea();
		textWarehouse.setText ("Garage:");
		textWarehouse.setBounds(158, 375, 64, 22);
		searchVehiclePanel.add(textWarehouse);
		textWarehouse.setFont(new Font("Dialog", Font.PLAIN, 15));
		textWarehouse.setBackground(SystemColor.window);
		textWarehouse.setEditable(false);

		/* ---- ACTION LISTENER! ---- */

		btnEdit.addActionListener(new ActionListener() { // When change button is pressed...
			public void actionPerformed(ActionEvent e) {
				edit();
			}
		}); 

		btnSaveEdit.addActionListener(new ActionListener() { // When change button is pressed...
			public void actionPerformed(ActionEvent e){
				saveEdit();
			}
		});

		btnDelete.addActionListener(new ActionListener() { // When delete button is pressed...
			public void actionPerformed(ActionEvent e){
				delete();
			}
		});

		btnBackSearchVehicle.addActionListener(new ActionListener() { // When clicked, go back to vehiclePanel...
			public void actionPerformed(ActionEvent e) {
				backSearchVehicle();
			}

		});
		
		btnNewSearch.addActionListener(new ActionListener() { // When clicked, go back to vehiclePanel...
			public void actionPerformed(ActionEvent e) {
				search();
			}

		});

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ------------------------------------------- Creates the NEW VEHICLE panel! ----------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		newVehiclePanel = new JPanel();
		contentPane.add(newVehiclePanel, "newVehiclePanel");
		newVehiclePanel.setLayout(null);


		/* ---- BUTTONS! ---- */

		btnBackNewVehicle = new JButton("Tillbaka");
		btnBackNewVehicle.setBounds(10, 10, 150, 35);
		newVehiclePanel.add(btnBackNewVehicle);
		btnBackNewVehicle.setVisible(true);

		btnCreateVehicle = new JButton("Registrera fordon");
		btnCreateVehicle.setBounds(225, 492, 250, 75);
		newVehiclePanel.add(btnCreateVehicle);
		btnCreateVehicle.setVisible(true);

		/* ---- TEXT FIELDS! ---- */

		fieldNewRegNbr = new JTextField();
		fieldNewRegNbr.setBounds(225, 79, 250, 30);
		newVehiclePanel.add(fieldNewRegNbr);
		fieldNewRegNbr.setColumns(10);
		fieldNewRegNbr.setEditable(true);

		fieldNewModel = new JTextField(); 
		fieldNewModel.setText("");
		fieldNewModel.setBounds(225, 119, 250, 30);
		newVehiclePanel.add(fieldNewModel);
		fieldNewModel.setColumns(10);
		fieldNewModel.setEditable(true);

		fieldNewType = new JTextField();
		fieldNewType.setText("");
		fieldNewType.setBounds(225, 159, 250, 30);
		newVehiclePanel.add(fieldNewType);
		fieldNewType.setColumns(10);
		fieldNewType.setEditable(true);

		fieldNewLicenseReq = new JTextField(); 
		fieldNewLicenseReq.setText("");
		fieldNewLicenseReq.setBounds(225, 199, 250, 30);
		newVehiclePanel.add(fieldNewLicenseReq);
		fieldNewLicenseReq.setColumns(10);
		fieldNewLicenseReq.setEditable(true);

		fieldNewPrice = new JTextField(); 
		fieldNewPrice.setText("");
		fieldNewPrice.setBounds(225, 239, 250, 30);
		newVehiclePanel.add(fieldNewPrice);
		fieldNewPrice.setColumns(10);
		fieldNewPrice.setEditable(true);

		fieldNewInfo = new JTextField(); 
		fieldNewInfo.setText("");
		fieldNewInfo.setBounds(225, 279, 250, 30);
		newVehiclePanel.add(fieldNewInfo);
		fieldNewInfo.setColumns(10);
		fieldNewInfo.setEditable(true);

		fieldNewHasHook = new JTextField();
		fieldNewHasHook.setText("");
		fieldNewHasHook.setBounds(225, 319, 250, 30);
		newVehiclePanel.add(fieldNewHasHook);
		fieldNewHasHook.setColumns(10);
		fieldNewHasHook.setEditable(true);

		fieldNewExpiryDate = new JTextField(); 
		fieldNewExpiryDate.setText("");
		fieldNewExpiryDate.setBounds(225, 359, 250, 30);
		newVehiclePanel.add(fieldNewExpiryDate);
		fieldNewExpiryDate.setColumns(10);
		fieldNewExpiryDate.setEditable(true);                

		fieldNewWarehouse = new JTextField();
		fieldNewWarehouse.setText("");
		fieldNewWarehouse.setBounds(225, 399, 250, 30);
		newVehiclePanel.add(fieldNewWarehouse);
		fieldNewWarehouse.setColumns(10);
		fieldNewWarehouse.setEditable(true);

		/* ---- TEXT AREAS! ---- */

		textNewRegNbr = new JTextArea();
		textNewRegNbr.setEditable(false);
		textNewRegNbr.setBackground(SystemColor.window);
		textNewRegNbr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNewRegNbr.setText("Registreringsnummer:");
		textNewRegNbr.setBounds(74, 84, 150, 19);
		newVehiclePanel.add(textNewRegNbr);

		textNewModel = new JTextArea();
		textNewModel.setEditable(false);
		textNewModel.setBackground(SystemColor.window);
		textNewModel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNewModel.setText("Modell:");
		textNewModel.setBounds(169, 124, 55, 19);
		newVehiclePanel.add(textNewModel);

		textNewType = new JTextArea();
		textNewType.setEditable(false);
		textNewType.setBackground(SystemColor.window);
		textNewType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNewType.setText("Fordonstyp:");
		textNewType.setBounds(140, 164, 84, 19);
		newVehiclePanel.add(textNewType);

		textNewLicenseReq = new JTextArea();  
		textNewLicenseReq.setEditable(false);
		textNewLicenseReq.setBackground(SystemColor.window);
		textNewLicenseReq.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNewLicenseReq.setText("Körkortskrav:");
		textNewLicenseReq.setBounds(130, 204, 94, 19);
		newVehiclePanel.add(textNewLicenseReq);

		textNewPrice = new JTextArea();
		textNewPrice.setEditable(false);
		textNewPrice.setBackground(SystemColor.window);
		textNewPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNewPrice.setText("Pris:");
		textNewPrice.setBounds(187, 244, 37, 19);
		newVehiclePanel.add(textNewPrice);

		textNewInfo = new JTextArea();
		textNewInfo.setEditable(false);
		textNewInfo.setBackground(SystemColor.window);
		textNewInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNewInfo.setText("Beskrivning:");
		textNewInfo.setBounds(140, 281, 84, 25);
		newVehiclePanel.add(textNewInfo);             

		textNewHasHook = new JTextArea();
		textNewHasHook.setEditable(false);
		textNewHasHook.setBackground(SystemColor.window);
		textNewHasHook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNewHasHook.setText("Dragkrok:");
		textNewHasHook.setBounds(154, 324, 70, 19);
		newVehiclePanel.add(textNewHasHook);

		textNewExpiryDate = new JTextArea();
		textNewExpiryDate.setEditable(false);
		textNewExpiryDate.setBackground(SystemColor.window);
		textNewExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNewExpiryDate.setText("Utgångsdatum:");
		textNewExpiryDate.setBounds(116, 361, 108, 19);
		newVehiclePanel.add(textNewExpiryDate);     

		textNewWarehouse = new JTextArea();
		textNewWarehouse.setEditable(false);
		textNewWarehouse.setBackground(SystemColor.window);
		textNewWarehouse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNewWarehouse.setText("Garage:");
		textNewWarehouse.setBounds(162, 401, 62, 19);
		newVehiclePanel.add(textNewWarehouse);

		/* ---- ACTION LISTENERS! ---- */

		btnCreateVehicle.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});

		btnBackNewVehicle.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "vehiclePanel");
			}
		});		
	}

	/* -------------------------------------------------------------------------------------------------------------------- */

	public void search() {
		
		String enteredRegNbr = JOptionPane.showInputDialog(null, "Ange regestreringsnummer:");
		vehicle = controller.findVehicle(enteredRegNbr);
		
		fieldRegNbr.setText(vehicle.getRegNbr());         // Prints the correct information to the fields
		fieldModel.setText(vehicle.getProductName());        
		fieldType.setText(vehicle.getType());        
		fieldLicenseReq.setText(vehicle.getLicenseReq());        
		fieldPrice.setText(Integer.toString(vehicle.getPrice()));        
		fieldInfo.setText(vehicle.getInfoTxt());        
		fieldExpiryDate.setText(vehicle.getExpiryDate());
		fieldWarehouse.setText(vehicle.getWarehouse().getCity());

		/* We need to print the hasHook-argument in a more sensible way which is why we do this... */

		String hasHook;
		
		if(vehicle.hasHook()) {
			hasHook = "Ja";
		}
		else { 
			hasHook = "Nej";
		}

		fieldHasHook.setText(hasHook);
		
		cardLayout.show(contentPane, "searchVehiclePanel");

	}
	
	/* -------------------------------------------------------------------------------------------------------------------- */

	public void edit() {

		btnEdit.setVisible(false);
		btnDelete.setVisible(false);
		btnSaveEdit.setVisible(true);            
		fieldRegNbr.setEditable(true);
		fieldModel.setEditable(true);
		fieldType.setEditable(true);
		fieldLicenseReq.setEditable(true);
		fieldPrice.setEditable(true);
		fieldInfo.setEditable(true);
		fieldExpiryDate.setEditable(true);
		fieldWarehouse.setEditable(true);
		fieldHasHook.setEditable(true);

	}

	/* -------------------------------------------------------------------------------------------------------------------- */

	public void saveEdit() {

		if(fieldRegNbr.getText().equals("") || 
				fieldModel.getText().equals("") || 
				fieldType.getText().equals("") || 
				fieldLicenseReq.getText().equals("") ||
				fieldPrice.getText().equals("") ||
				fieldInfo.getText().equals("") ||
				fieldExpiryDate.getText().equals("") ||
				fieldWarehouse.getText().equals("") ||
				fieldHasHook.getText().equals("")){

			JOptionPane.showMessageDialog(null, "Alla fält måste var ifyllda");                           
		}

		else {

			cardLayout.show(contentPane, "Panel");
			vehicle.setRegNbr(fieldRegNbr.getText());
			vehicle.setProductName(fieldModel.getText());
			vehicle.setType(fieldType.getText());
			vehicle.setLicenseReq(fieldLicenseReq.getText());
			vehicle.setPrice(Integer.parseInt(fieldPrice.getText()));
			vehicle.setInfoTxt(fieldInfo.getText());
			vehicle.setExpiryDate(fieldExpiryDate.getText());

			//                    vehicle.setWarehouse.setCity(fieldWarehouse.getText());
			/*  vehicle.setHasHook (fieldHasHook.getText());//...info text                                        */

			JOptionPane.showMessageDialog(null, "Ändring sparad");

			cardLayout.show(contentPane, "vehiclePanel");

			fieldRegNbr.setText("");
			fieldModel.setText("");
			fieldType.setText("");
			fieldLicenseReq.setText("");
			fieldPrice.setText("");
			fieldInfo.setText("");
			fieldExpiryDate.setText("");
			fieldWarehouse.setText("");
			fieldHasHook.setText("");
			fieldRegNbr.setText("");

			fieldRegNbr.setEditable(false);
			fieldModel.setEditable(false);
			fieldType.setEditable(false);
			fieldLicenseReq.setEditable(false);
			fieldPrice.setEditable(false);
			fieldInfo.setEditable(false);
			fieldExpiryDate.setEditable(false);
			fieldWarehouse.setEditable(false);
			fieldHasHook.setEditable(false);

			btnEdit.setVisible(true);
			btnDelete.setVisible(true);
			btnSaveEdit.setVisible(false);

			fieldRegNbr.setVisible(true);

		}     
	}

	/* -------------------------------------------------------------------------------------------------------------------- */

	public void delete() {


		controller.vehicleRegistry.removeVehicle(vehicle);

		JOptionPane.showMessageDialog(null, "Borttaget");

		cardLayout.show(contentPane, "vehiclePanel");

		fieldRegNbr.setText("");
		fieldModel.setText("");
		fieldType.setText("");
		fieldLicenseReq.setText("");
		fieldPrice.setText("");
		fieldInfo.setText("");
		fieldExpiryDate.setText("");
		fieldWarehouse.setText("");
		fieldHasHook.setText("");
		fieldRegNbr.setText("");

		fieldRegNbr.setEditable(false);
		fieldModel.setEditable(false);
		fieldType.setEditable(false);
		fieldLicenseReq.setEditable(false);
		fieldPrice.setEditable(false);
		fieldInfo.setEditable(false);
		fieldExpiryDate.setEditable(false);
		fieldWarehouse.setEditable(false);
		fieldHasHook.setEditable(false);





	}


	/* -------------------------------------------------------------------------------------------------------------------- */

	public void backSearchVehicle() {

		cardLayout.show(contentPane, "vehiclePanel");

		fieldRegNbr.setText("");
		fieldModel.setText("");
		fieldType.setText("");
		fieldLicenseReq.setText("");
		fieldPrice.setText("");
		fieldInfo.setText("");
		fieldExpiryDate.setText("");
		fieldWarehouse.setText("");
		fieldHasHook.setText("");
		fieldRegNbr.setText("");

	}

	/* -------------------------------------------------------------------------------------------------------------------- */

	public void create() {

		cardLayout.show(contentPane, "vehiclePanel");

		String regNbr = fieldNewRegNbr.getText();
		String model = fieldNewModel.getText();
		String type = fieldNewType.getText();
		String licenseReq = fieldNewLicenseReq.getText();	
		int price = Integer.parseInt(fieldNewPrice.getText());
		String info = fieldNewInfo.getText();
		String expiryDate = fieldNewExpiryDate.getText();
		String warehouse = fieldNewWarehouse.getText();
		String hasHook = fieldNewHasHook.getText();

		controller.createVehicle(regNbr, model, type, licenseReq, price, info, expiryDate, warehouse, hasHook);

		cardLayout.show(contentPane, "vehiclePanel");

		JOptionPane.showMessageDialog(null, "Bilen är registrerad!");

	}
}

