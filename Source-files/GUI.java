import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	public static void main(String[] args) {

		final CardLayout cardLayout = new CardLayout();

		final JFrame frame = new JFrame("CARENTA");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final Container contentPane = frame.getContentPane();
		contentPane.setLayout(cardLayout);

		final JPanel mainPanel = new JPanel();
		final JPanel customerPanel = new JPanel();
		final JPanel orderPanel = new JPanel();
		final JPanel vehiclePanel = new JPanel();
		final JPanel accessoryPanel = new JPanel();

		JButton btnCustomer = new JButton("Kund");
		btnCustomer.setBounds(175, 100, 150, 50);

		JButton btnOrder = new JButton("Order");
		btnOrder.setBounds(175, 175, 150, 50);

		JButton btnVehicle = new JButton("Fordon");
		btnVehicle.setBounds(175, 250, 150, 50);

		JButton btnAccessory = new JButton("Tillbehör");
		btnAccessory.setBounds(175, 325, 150, 50);



		JButton btnBackCustomer = new JButton("Tillbaka");
		btnBackCustomer.setBounds(10, 10, 100, 25);
		JButton btnBackOrder = new JButton("Tillbaka");
		btnBackOrder.setBounds(10, 10, 100, 25);
		JButton btnBackVehicle = new JButton("Tillbaka");
		btnBackVehicle.setBounds(10, 10, 100, 25);
		JButton btnBackAccessory = new JButton("Tillbaka");
		btnBackAccessory.setBounds(10, 10, 100, 25);




		/* **************************************************************************************************************************** */

		contentPane.setPreferredSize(new Dimension(500, 500));
		contentPane.add(mainPanel, "mainPanel");
		contentPane.add(customerPanel, "customerPanel");
		contentPane.add(orderPanel, "orderPanel");
		contentPane.add(vehiclePanel, "vehiclePanel");
		contentPane.add(accessoryPanel, "accessoryPanel");

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		mainPanel.setLayout(null);

		mainPanel.add(btnCustomer);
		mainPanel.add(btnOrder);
		mainPanel.add(btnVehicle);
		mainPanel.add(btnAccessory);


		/* **************************************************************************************************************************** */


		customerPanel.setLayout(null);
		orderPanel.setLayout(null);
		vehiclePanel.setLayout(null);
		accessoryPanel.setLayout(null);





		customerPanel.add(btnBackCustomer);
		orderPanel.add(btnBackOrder);
		vehiclePanel.add(btnBackVehicle);
		accessoryPanel.add(btnBackAccessory);


		/* ACTION LISTENERS!!! */

		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "customerPanel");
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
