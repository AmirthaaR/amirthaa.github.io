package easytrip.ui;
import javax.swing.*;
import java.awt.event.*;
public class MainWindow {
	public static void main(String[] args) {
		JFrame frame = new JFrame("EasyTripBooker - Main Window");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, frame);
        frame.setVisible(true);
	}
	private static void placeComponents(JPanel panel, JFrame frame) {
	    panel.setLayout(null);
	    JLabel label = new JLabel("Welcome to EasyTripBooker!");
	    label.setBounds(90, 30, 250, 25);
	    panel.add(label);
	    
	    JButton loginButton = new JButton("Login");
	    loginButton.setBounds(140, 80, 100, 30);
	    panel.add(loginButton);

	    // Open Login Screen
	    loginButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		frame.dispose(); // Close main window
	            LoginScreen.main(null); // Open login screen
	        }
	    });
	}
}
