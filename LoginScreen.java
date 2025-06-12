package easytrip.ui;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class LoginScreen {
	public static void main(String[] args) {
		final JFrame frame = new JFrame("EasyTripBooker - Login");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel,frame);

        frame.setVisible(true);
	}
	private static void placeComponents(JPanel panel , JFrame frame) {
		panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 90, 80, 25);
        panel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(180, 90, 100, 25);
        panel.add(registerButton);
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String pass = new String(passwordText.getPassword());
                boolean loginSuccess = false;

                try {
                    BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length == 2 && parts[0].equals(user) && parts[1].equals(pass)) {
                            loginSuccess = true;
                            break;
                        }
                    }
                    reader.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(panel, "Error reading user file!", "Error", JOptionPane.ERROR_MESSAGE);
                }

                if (loginSuccess) {
                    JOptionPane.showMessageDialog(panel, "Login successful!");
                    frame.dispose();
                    BookingScreen.main(null);
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistrationScreen.main(null); // open registration screen
            }
        });
	}
}
