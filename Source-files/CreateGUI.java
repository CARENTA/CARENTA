import java.awt.*;

public class CreateGUI {
	public static void main(String[] args) {

		final CardLayout cardLayout = new CardLayout();

		/* Creates frame for the program and have the basic windows features.*/
		
		final JFrame frame = new JFrame("CARENTA");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Creates a container that contains the panel. */
		
		final Container contentPane = frame.getContentPane();
		contentPane.setLayout(cardLayout);
		contentPane.setPreferredSize(new Dimension(500, 500));

		/* Creates the main panel! */
		
		final JPanel mainPanel = new JPanel(); // Panel...

		mainPanel.setLayout(null); // Standard layout...
		
		contentPane.add(mainPanel, "mainPanel"); // Adds the panel mainPanel to the container where "customerPanel" identifies it!
		
		JButton btnCustomer = new JButton("Kund"); // Buttons...
		JButton btnOrder = new JButton("Order");
		JButton btnVehicle = new JButton("Fordon");
		JButton btnAccessory = new JButton("Tillbehör");
		
		btnCustomer.setBounds(175, 100, 150, 50);
		btnOrder.setBounds(175, 175, 150, 50);
		btnVehicle.setBounds(175, 250, 150, 50);
		btnAccessory.setBounds(175, 325, 150, 50);

		mainPanel.add(btnCustomer);
		mainPanel.add(btnOrder);
		mainPanel.add(btnVehicle);
		mainPanel.add(btnAccessory);
		
		/* Creates the CUSTOMER panel! */
		
		final JPanel customerPanel = new JPanel();
	
		customerPanel.setLayout(null);
		
		contentPane.add(customerPanel, "customerPanel");
			
		JButton btnBackCustomer = new JButton("Tillbaka");
		
		btnBackCustomer.setBounds(10, 10, 100, 25);
		
		customerPanel.add(btnBackCustomer);
		
		/* Creates the ORDER panel! */
		
		final JPanel orderPanel = new JPanel();

		orderPanel.setLayout(null);
		
		contentPane.add(orderPanel, "orderPanel");
		
		JButton btnBackOrder = new JButton("Tillbaka");
		
		btnBackOrder.setBounds(10, 10, 100, 25);
		
		orderPanel.add(btnBackOrder);
		
		/* Creates the VEHICLE panel! */
		
		final JPanel vehiclePanel = new JPanel();
		
		vehiclePanel.setLayout(null);
		
		contentPane.add(vehiclePanel, "vehiclePanel");
		
		JButton btnBackVehicle = new JButton("Tillbaka");
		
		btnBackVehicle.setBounds(10, 10, 100, 25);
		
		vehiclePanel.add(btnBackVehicle);
		
		/* Creates the ACCESSORY panel! */
		
		final JPanel accessoryPanel = new JPanel();

		accessoryPanel.setLayout(null);
		
		contentPane.add(accessoryPanel, "accessoryPanel");
		
		JButton btnBackAccessory = new JButton("Tillbaka");
		
		btnBackAccessory.setBounds(10, 10, 100, 25);
	
		accessoryPanel.add(btnBackAccessory);
		
		/*Standard frame settings. */
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		/* ACTION LISTENERS!!!
		 * ... creates listeners for buttons, when a button is pressed... do this: */
		
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerPanel"); // Switch to customerPanel...
			}
		});

		btnBackCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});

		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "orderPanel");
			}
		});

		btnBackOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});
		btnVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "vehiclePanel");
			}
		});

		btnBackVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});
		btnAccessory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "accessoryPanel");
			}
		});

		btnBackAccessory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});
	}
}
