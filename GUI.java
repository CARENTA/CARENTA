import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
   public static void main(String[] args) {
      
	  final CardLayout cardLayout = new CardLayout();
      
	  final JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      final Container contentPane = frame.getContentPane();
      contentPane.setLayout(cardLayout);

      final JPanel mainPanel = new JPanel();
      final JPanel customerPanel = new JPanel();
      
      JButton btnCustomer = new JButton("Kund");
      JButton btnBack = new JButton("Tillbaka");
      btnCustomer.setBounds(175, 75, 150, 50);
      btnBack.setBounds(10, 10, 100, 25);
      
      
      contentPane.setPreferredSize(new Dimension(500, 500));
      contentPane.add(mainPanel, "Huvudmeny");
      contentPane.add(customerPanel, "Kund");
      
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setVisible(true);
      
      mainPanel.setLayout(null);

      mainPanel.add(btnCustomer);
      customerPanel.setLayout(null);
      customerPanel.add(btnBack);

      ActionListener btnListener = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            cardLayout.next(contentPane);
         }
      };

      btnCustomer.addActionListener(btnListener);
      btnBack.addActionListener(btnListener);

   }
}
