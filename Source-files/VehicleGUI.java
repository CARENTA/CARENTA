package GUI;

import java.awt.CardLayout;
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
import controller.Controller;

public class VehicleGUI {

	final CardLayout cardLayout;
	final Container contentPane;
	final Controller controller;

	public VehicleGUI(final Container contentPane, final CardLayout cardLayout, final Controller controller) {

		this.cardLayout = cardLayout;
		this.contentPane = contentPane;
		this.controller = controller;

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the VEHICLE panel! ----------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel vehiclePanel = new JPanel();
		vehiclePanel.setLayout(null);
		contentPane.add(vehiclePanel, "vehiclePanel");

		JButton btnSearchVehicle = new JButton("Sök fordon");
		btnSearchVehicle.setBounds(200, 225, 300, 75);
		vehiclePanel.add(btnSearchVehicle);
		
		JButton btnNewVehicle = new JButton("Registrera fordon");
		btnNewVehicle.setBounds(200, 350, 300, 75);
		vehiclePanel.add(btnNewVehicle);

		JButton btnBackVehicle = new JButton("Tillbaka");
		btnBackVehicle.setBounds(10, 10, 150, 35);
		vehiclePanel.add(btnBackVehicle);

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

		final JPanel vehicleSearchPanel = new JPanel();

		vehicleSearchPanel.setLayout(null);

		contentPane.add(vehicleSearchPanel, "vehicleSearchPanel");

		JButton btnSearchForVehicle = new JButton("Sök fordon");
		JButton btnBackSearchVehicle = new JButton("Tillbaka");

		btnSearchForVehicle.setBounds(200, 485, 300, 75);
		btnBackSearchVehicle.setBounds(10, 10, 100, 25);

		vehicleSearchPanel.add(btnSearchForVehicle);
		vehicleSearchPanel.add(btnBackSearchVehicle);

		final JTextField txtEnterRegNbr; // Creates search field where you input the customer number...
		txtEnterRegNbr = new JTextField();
		txtEnterRegNbr.setText("");
		txtEnterRegNbr.setBounds(200, 420, 300, 30);
		vehicleSearchPanel.add(txtEnterRegNbr);
		txtEnterRegNbr.setColumns(10);

		final JTextPane paneVehicleResult = new JTextPane();
		paneVehicleResult.setBounds(158, 55, 400, 335);
		vehicleSearchPanel.add(paneVehicleResult);

		btnSearchForVehicle.addActionListener(new ActionListener() { // When search button is pressed...

			public void actionPerformed(ActionEvent e) {

			}

		});

		btnBackSearchVehicle.addActionListener(new ActionListener() { // When clicked, go back to vehiclePanel...

			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "vehiclePanel");

			}

		});


		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ------------------------------------------- Creates the NEW VEHICLE panel! ----------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		final JPanel registerNewVehiclePanel = new JPanel();
		contentPane.add(registerNewVehiclePanel, "registerNewVehiclePanel");
		registerNewVehiclePanel.setLayout(null);


		JButton btnBackRegisterNewVehicle = new JButton("Tillbaka");
		JButton btnRegisterNewVehicle = new JButton("Registrera fordon");

		btnBackRegisterNewVehicle.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "vehiclePanel");
			}
		});

		btnBackRegisterNewVehicle.setBounds(10, 10, 150, 35);
		btnRegisterNewVehicle.setBounds(200, 485, 300, 75);

		registerNewVehiclePanel.add(btnBackRegisterNewVehicle);
		registerNewVehiclePanel.add(btnRegisterNewVehicle);

		final JTextField txtEnterVehicleRegNbr; // Creates search field where you input the information about the vehicle...
		txtEnterVehicleRegNbr = new JTextField();
		txtEnterVehicleRegNbr.setText("");
		txtEnterVehicleRegNbr.setBounds(225, 74, 250, 30);
		registerNewVehiclePanel.add(txtEnterVehicleRegNbr);
		txtEnterVehicleRegNbr.setColumns(10);

		final JTextArea txtrVehicleRegNbr = new JTextArea();
		txtrVehicleRegNbr.setEditable(false);
		txtrVehicleRegNbr.setBackground(SystemColor.window);
		txtrVehicleRegNbr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrVehicleRegNbr.setText("Registreringsnummer");
		txtrVehicleRegNbr.setBounds(90, 81, 130, 27);
		registerNewVehiclePanel.add(txtrVehicleRegNbr);

		final JTextField txtEnterVehicleModel; // Creates search field where you input the information about the vehicle...
		txtEnterVehicleModel = new JTextField();
		txtEnterVehicleModel.setText("");
		txtEnterVehicleModel.setBounds(225, 120, 250, 30);
		registerNewVehiclePanel.add(txtEnterVehicleModel);
		txtEnterVehicleModel.setColumns(10);

		final JTextArea txtrVehicleModel = new JTextArea();
		txtrVehicleModel.setEditable(false);
		txtrVehicleModel.setBackground(SystemColor.window);
		txtrVehicleModel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrVehicleModel.setText("Modell");
		txtrVehicleModel.setBounds(130, 123, 100, 27);
		registerNewVehiclePanel.add(txtrVehicleModel);

		final JTextField txtEnterVehicleType; // Creates search field where you input the information about the vehicle...
		txtEnterVehicleType = new JTextField();
		txtEnterVehicleType.setText("");
		txtEnterVehicleType.setBounds(225, 166, 250, 30);
		registerNewVehiclePanel.add(txtEnterVehicleType);
		txtEnterVehicleType.setColumns(10);

		final JTextArea txtrVehicleType = new JTextArea();
		txtrVehicleType.setEditable(false);
		txtrVehicleType.setBackground(SystemColor.window);
		txtrVehicleType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrVehicleType.setText("Fordonstyp");
		txtrVehicleType.setBounds(130, 165, 100, 27);
		registerNewVehiclePanel.add(txtrVehicleType);


		final JTextField txtEnterNewVehicleLicenseReq; // Creates search field where you input the information about the vehicle...
		txtEnterNewVehicleLicenseReq= new JTextField();
		txtEnterNewVehicleLicenseReq.setText("");
		txtEnterNewVehicleLicenseReq.setBounds(225, 212, 250, 30);
		registerNewVehiclePanel.add(txtEnterNewVehicleLicenseReq);
		txtEnterNewVehicleLicenseReq.setColumns(10);

		final JTextArea txtrNewVehicleLicenseReq = new JTextArea();  // Creates the text next to the input field.
		txtrNewVehicleLicenseReq.setEditable(false);
		txtrNewVehicleLicenseReq.setBackground(SystemColor.window);
		txtrNewVehicleLicenseReq.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrNewVehicleLicenseReq.setText("Körkortskrav");
		txtrNewVehicleLicenseReq.setBounds(130, 207, 100, 27);
		registerNewVehiclePanel.add(txtrNewVehicleLicenseReq);

		final JTextField txtEnterNewVehiclePrice; // Creates search field where you input the information about the vehicle...
		txtEnterNewVehiclePrice= new JTextField();
		txtEnterNewVehiclePrice.setText("");
		txtEnterNewVehiclePrice.setBounds(225, 258, 250, 30);
		registerNewVehiclePanel.add(txtEnterNewVehiclePrice);
		txtEnterNewVehiclePrice.setColumns(10);

		final JTextArea txtrNewVehiclePrice = new JTextArea();  // Creates the text next to the input field.
		txtrNewVehiclePrice.setEditable(false);
		txtrNewVehiclePrice.setBackground(SystemColor.window);
		txtrNewVehiclePrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrNewVehiclePrice.setText("Pris");
		txtrNewVehiclePrice.setBounds(130, 249, 100, 27);
		registerNewVehiclePanel.add(txtrNewVehiclePrice);

		final JTextField txtEnterNewVehicleInfo; // Creates search field where you input the information about the vehicle...
		txtEnterNewVehicleInfo= new JTextField();
		txtEnterNewVehicleInfo.setText("");
		txtEnterNewVehicleInfo.setBounds(225, 304, 250, 30);
		registerNewVehiclePanel.add(txtEnterNewVehicleInfo);
		txtEnterNewVehicleInfo.setColumns(10);

		final JTextArea txtrNewVehicleInfo = new JTextArea();  // Creates the text next to the input field.
		txtrNewVehicleInfo.setEditable(false);
		txtrNewVehicleInfo.setBackground(SystemColor.window);
		txtrNewVehicleInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrNewVehicleInfo.setText("Beskrivning");
		txtrNewVehicleInfo.setBounds(130, 291, 100, 27);
		registerNewVehiclePanel.add(txtrNewVehicleInfo);

		final JTextField txtEnterNewVehicleHasHook; // Creates search field where you input the information about the vehicle...
		txtEnterNewVehicleHasHook= new JTextField();
		txtEnterNewVehicleHasHook.setText("");
		txtEnterNewVehicleHasHook.setBounds(225, 350, 250, 30);
		registerNewVehiclePanel.add(txtEnterNewVehicleHasHook);
		txtEnterNewVehicleHasHook.setColumns(10);


		final JTextArea txtrNewVehicleHasHook = new JTextArea();  // Creates the text next to the input field.
		txtrNewVehicleHasHook.setEditable(false);
		txtrNewVehicleHasHook.setBackground(SystemColor.window);
		txtrNewVehicleHasHook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrNewVehicleHasHook.setText("Dragkrok");
		txtrNewVehicleHasHook.setBounds(130, 333, 100, 27);
		registerNewVehiclePanel.add(txtrNewVehicleHasHook);

		final JTextField txtEnterNewVehicleExpiryDate; // Creates search field where you input the information about the vehicle...
		txtEnterNewVehicleExpiryDate= new JTextField();
		txtEnterNewVehicleExpiryDate.setText("");
		txtEnterNewVehicleExpiryDate.setBounds(225, 396, 250, 30);
		registerNewVehiclePanel.add(txtEnterNewVehicleExpiryDate);
		txtEnterNewVehicleExpiryDate.setColumns(10);


		final JTextArea txtrNewVehicleExpiryDate = new JTextArea();  // Creates the text next to the input field.
		txtrNewVehicleExpiryDate.setEditable(false);
		txtrNewVehicleExpiryDate.setBackground(SystemColor.window);
		txtrNewVehicleExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrNewVehicleExpiryDate.setText("Utgångsdatum");
		txtrNewVehicleExpiryDate.setBounds(130, 375, 100, 27);
		registerNewVehiclePanel.add(txtrNewVehicleExpiryDate);

		final JTextField txtEnterNewVehicleWarehouse; // Creates search field where you input the information about the vehicle...
		txtEnterNewVehicleWarehouse= new JTextField();
		txtEnterNewVehicleWarehouse.setText("");
		txtEnterNewVehicleWarehouse.setBounds(225, 442, 250, 30);
		registerNewVehiclePanel.add(txtEnterNewVehicleWarehouse);
		txtEnterNewVehicleWarehouse.setColumns(10);

		final JTextArea txtrNewVehicleWarehouse = new JTextArea();  // Creates the text next to the input field.
		txtrNewVehicleWarehouse.setEditable(false);
		txtrNewVehicleWarehouse.setBackground(SystemColor.window);
		txtrNewVehicleWarehouse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrNewVehicleWarehouse.setText("Filial/lager");
		txtrNewVehicleWarehouse.setBounds(130, 417, 100, 27);
		registerNewVehiclePanel.add(txtrNewVehicleWarehouse);

	}
}
