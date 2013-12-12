import java.awt.Dimension;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateGUI {
	public static void main(String[] args) {

		final CardLayout cardLayout = new CardLayout();

		/* Creates the frame for the program which has the basic window features.*/
		
		final JFrame frame = new JFrame("CARENTA");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Creates a container that contains the panels. */
		
		final Container contentPane = frame.getContentPane();
		contentPane.setLayout(cardLayout);
		contentPane.setPreferredSize(new Dimension(500, 500));

		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the MAIN panel! -------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */
		
		final JPanel mainPanel = new JPanel(); // Panel...

		mainPanel.setLayout(null); // Standard layout...
		
		contentPane.add(mainPanel, "mainPanel"); // Adds the panel mainPanel to the container where "customerPanel" identifies it!
		
		JButton btnCustomer = new JButton("Kund"); // Buttons...
		JButton btnOrder = new JButton("Order");
		JButton btnVehicle = new JButton("Fordon");
		JButton btnAccessory = new JButton("Tillbehör");
		
		btnCustomer.setBounds(175, 100, 150, 50); // Set locations and set sizes...
		btnOrder.setBounds(175, 175, 150, 50);
		btnVehicle.setBounds(175, 250, 150, 50);
		btnAccessory.setBounds(175, 325, 150, 50);

		mainPanel.add(btnCustomer); // Add them to the panel...
		mainPanel.add(btnOrder);
		mainPanel.add(btnVehicle);
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
		JButton btnNewCustomer = new JButton("Registrera kund");
		JButton btnBackCustomer = new JButton("Tillbaka");
		
		btnSearchCustomer.setBounds(175, 175, 150, 50);
		btnNewCustomer.setBounds(175, 250, 150, 50);
		btnBackCustomer.setBounds(10, 10, 100, 25);
		
		customerPanel.add(btnSearchCustomer);
		customerPanel.add(btnNewCustomer);
		customerPanel.add(btnBackCustomer);
		
		btnBackCustomer.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});
		
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------- Creates the CUSTOMER SEARCH panel! --------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */
		
		
		
		
		
		
		
		
		
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------- Creates the NEW CUSTOMER panel! ------------------------------------------ */
		/* -------------------------------------------------------------------------------------------------------------------- */
		
		
		
		
		
		
		
		
		
		
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the ORDER panel! ------------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */
		
		final JPanel orderPanel = new JPanel();

		orderPanel.setLayout(null);
		
		contentPane.add(orderPanel, "orderPanel");
		
		JButton btnSearchOrder = new JButton("Sök order");
		JButton btnNewOrder = new JButton("Registrera order");
		JButton btnBackOrder = new JButton("Tillbaka");
		
		btnSearchOrder.setBounds(175, 175, 150, 50);
		btnNewOrder.setBounds(175, 250, 150, 50);
		btnBackOrder.setBounds(10, 10, 100, 25);
		
		orderPanel.add(btnSearchOrder);
		orderPanel.add(btnNewOrder);
		orderPanel.add(btnBackOrder);
		
		orderPanel.add(btnBackOrder);
		
		btnBackOrder.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});
		
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------------- Creates the VEHICLE panel! ----------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */
		
		final JPanel vehiclePanel = new JPanel();
		
		vehiclePanel.setLayout(null);
		
		contentPane.add(vehiclePanel, "vehiclePanel");
		
		JButton btnSearchVehicle = new JButton("Sök fordon");
		JButton btnNewVehicle = new JButton("Registrera fordon");
		JButton btnBackVehicle = new JButton("Tillbaka");
		
		btnSearchVehicle.setBounds(175, 175, 150, 50);
		btnNewVehicle.setBounds(175, 250, 150, 50);
		btnBackVehicle.setBounds(10, 10, 100, 25);
		
		vehiclePanel.add(btnSearchVehicle);
		vehiclePanel.add(btnNewVehicle);
		vehiclePanel.add(btnBackVehicle);
		
		btnBackVehicle.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});
		
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ---------------------------------------------- Creates the ACCESSORY panel! ---------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */
		
		final JPanel accessoryPanel = new JPanel();

		accessoryPanel.setLayout(null);
		
		contentPane.add(accessoryPanel, "accessoryPanel");
		
		JButton btnSearchAccessory = new JButton("Sök tillbehör");
		JButton btnNewAccessory = new JButton("Registrera tillbehör");
		JButton btnBackAccessory = new JButton("Tillbaka");
		
		btnSearchAccessory.setBounds(175, 175, 150, 50);
		btnNewAccessory.setBounds(175, 250, 150, 50);
		btnBackAccessory.setBounds(10, 10, 100, 25);
	
		accessoryPanel.add(btnSearchAccessory);
		accessoryPanel.add(btnNewAccessory);
		accessoryPanel.add(btnBackAccessory);
		
		btnBackAccessory.addActionListener(new ActionListener() { // When clicked, go back to mainPanel...
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "mainPanel");
			}
		});
	
		/* -------------------------------------------------------------------------------------------------------------------- */
		/* ----------------------------------------- Creates the CUSTOMER SEARCH panel! --------------------------------------- */
		/* -------------------------------------------------------------------------------------------------------------------- */
		
		

		
		
		
		
		
		
		
		
		/*Standard frame settings. */
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

	}
}
