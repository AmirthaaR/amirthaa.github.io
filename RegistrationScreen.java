package easytrip.ui;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class RegistrationScreen {
	public static void main(String[] args) {
		 JFrame frame = new JFrame("EasyTripBooker - Registration");
	     frame.setSize(350, 250);
	     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     frame.setLocationRelativeTo(null);
	     JPanel panel = new JPanel();
	     frame.add(panel);
	     placeComponents(panel);
	     frame.setVisible(true);
	}
	private static void placeComponents(JPanel panel) {
		panel.setLayout(null);

        JLabel userLabel = new JLabel("New Username:");
        userLabel.setBounds(10, 20, 120, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(140, 20, 160, 25);
        panel.add(userText);

        JLabel passLabel = new JLabel("New Password:");
        passLabel.setBounds(10, 60, 120, 25);
        panel.add(passLabel);

        JPasswordField passText = new JPasswordField(20);
        passText.setBounds(140, 60, 160, 25);
        panel.add(passText);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 110, 120, 30);
        panel.add(registerButton);
  
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newUser = userText.getText();
                String newPass = new String(passText.getPassword());

                if (!newUser.isEmpty() && !newPass.isEmpty()) {
                    try {
                        FileWriter fw = new FileWriter("users.txt", true); // append mode
                        fw.write(newUser + "," + newPass + "\n");
                        fw.close();
                        JOptionPane.showMessageDialog(panel, "Registered successfully!");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(panel, "Error saving user!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
	}
}
