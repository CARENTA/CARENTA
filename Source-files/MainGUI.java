package GUI;

import java.awt.Dimension;

public class MainGUI {
	
	private JFrame mainFrame = new JFrame("CARENTA");
	private CardLayout cardLayout = new CardLayout(); // Layout used for switching panels!
	private Container contentPane = mainFrame.getContentPane(); // Container containing panels!
	
	private Controller controller = new Controller();

	private CustomerGUI customerGUI; // Separate GUIs!
	private OrderGUI orderGUI;
	private VehicleGUI vehicleGUI;
	private AccessoryGUI accessoryGUI;
	
	public MainGUI() {

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		mainFrame.setSize(700, 650);

		contentPane.setLayout(cardLayout); // Set panel switching method to card layout!
		contentPane.setPreferredSize(new Dimension(mainFrame.getWidth(), mainFrame.getHeight())); // Dimension settings!
		
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the MAIN panel! -------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/* ---- PANEL! ---- */

		final JPanel mainPanel = new JPanel(); // Create a panel!
		mainPanel.setLayout(null); // User specified layout, we'll create our own settings!
		contentPane.add(mainPanel, "mainPanel"); // Adds the panel mainPanel to the container where "mainPanel" identifies it!

		/* ---- BUTTONS! ---- */

		JButton btnCustomer = new JButton("Kund"); // Create a button!
		btnCustomer.setBounds(200, 100, 300, 75); // Set locations and sizes!
		mainPanel.add(btnCustomer); // ... and add the button to the window!

		JButton btnOrder = new JButton("Order");
		btnOrder.setBounds(200, 225, 300, 75);
		mainPanel.add(btnOrder);

		JButton btnVehicle = new JButton("Fordon");
		btnVehicle.setBounds(200, 350, 300, 75);
		mainPanel.add(btnVehicle);

		JButton btnAccessory = new JButton("Tillbehör");
		btnAccessory.setBounds(200, 475, 300, 75);
		mainPanel.add(btnAccessory);

		/* ---- ACTION LISTENERS! ---- */

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
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */
		
		/* Create separate GUIs! */
		
		this.customerGUI = new CustomerGUI(contentPane, cardLayout, controller);
		this.orderGUI = new OrderGUI(contentPane, cardLayout, controller);
		this.vehicleGUI = new VehicleGUI(contentPane, cardLayout, controller);
		this.accessoryGUI = new AccessoryGUI(contentPane, cardLayout, controller);
		
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */

		/*Standard frame settings! */
		
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);

	}

	/* -------------------------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------------------------- */
	/* -------------------------------------------------------------------------------------------------------------------- */

}
