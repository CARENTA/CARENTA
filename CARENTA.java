import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CARENTA extends JFrame {

	JPanel buttonPanel = new JPanel();
	JButton customerButton = new JButton("Kund");

	public CARENTA() {

    buttonPanel.add(customerButton);
    add(buttonPanel);
	customerButton.setLocation(0,0);
    
    
    setSize(400, 400);
    setBackground(Color.BLACK);
    setTitle("CARENTA");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
	}

	public static void main(String[] args) {

    new CARENTA();

	}
}
