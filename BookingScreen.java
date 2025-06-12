package easytrip.ui;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
public class BookingScreen {
    public static void main(String[] args) {
        JFrame frame = new JFrame("EasyTripBooker - Booking");
        frame.setSize(450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // center window

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel modeLabel = new JLabel("Travel Mode:");
        modeLabel.setBounds(10, 20, 120, 25);
        panel.add(modeLabel);

        String[] options = {"Cab", "Bus", "Train", "Airline"};
        JComboBox<String> modeCombo = new JComboBox<>(options);
        modeCombo.setBounds(160, 20, 200, 25);
        panel.add(modeCombo);

        JLabel peopleLabel = new JLabel("No. of People:");
        peopleLabel.setBounds(10, 60, 120, 25);
        panel.add(peopleLabel);

        JTextField peopleField = new JTextField("1");
        peopleField.setBounds(160, 60, 50, 25);
        panel.add(peopleField);

        JLabel fromLabel = new JLabel("Starting Place:");
        fromLabel.setBounds(10, 100, 120, 25);
        panel.add(fromLabel);

        JTextField fromField = new JTextField();
        fromField.setBounds(160, 100, 200, 25);
        panel.add(fromField);

        JLabel toLabel = new JLabel("Ending Place:");
        toLabel.setBounds(10, 140, 120, 25);
        panel.add(toLabel);

        JTextField toField = new JTextField();
        toField.setBounds(160, 140, 200, 25);
        panel.add(toField);

        JLabel dateLabel = new JLabel("Booking Date:");
        dateLabel.setBounds(10, 180, 120, 25);
        panel.add(dateLabel);

        JTextField dateField = new JTextField(new SimpleDateFormat("dd-MM-yyyy").format(new Date())); // today's date
        dateField.setBounds(160, 180, 200, 25);
        panel.add(dateField);

        JButton calcButton = new JButton("Calculate Price");
        calcButton.setBounds(10, 220, 150, 25);
        panel.add(calcButton);

        JLabel priceLabel = new JLabel("Total Price: ₹0");
        priceLabel.setBounds(180, 220, 200, 25);
        panel.add(priceLabel);

        JButton bookButton = new JButton("Book Now");
        bookButton.setBounds(130, 270, 150, 35);
        panel.add(bookButton);

        // Price calculator
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mode = (String) modeCombo.getSelectedItem();
                int people = Integer.parseInt(peopleField.getText());
                int pricePerPerson = 0;

                switch (mode) {
                    case "Cab": pricePerPerson = 200; break;
                    case "Bus": pricePerPerson = 150; break;
                    case "Train": pricePerPerson = 100; break;
                    case "Airline": pricePerPerson = 500; break;
                }

                int totalPrice = pricePerPerson * people;
                priceLabel.setText("Total Price: ₹" + totalPrice);
            }
        });

        // Booking button
        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int ticketNo = 100000 + (int)(Math.random() * 900000);
                    String mode = (String) modeCombo.getSelectedItem();
                    String from = fromField.getText();
                    String to = toField.getText();
                    String date = dateField.getText();
                    int people = Integer.parseInt(peopleField.getText());
                    String priceText = priceLabel.getText().replace("Total Price: ₹", "");
                    int totalPrice = Integer.parseInt(priceText);

                    // Save ticket to file
                    FileWriter fw = new FileWriter("tickets.txt", true); // append mode
                    fw.write("Ticket No: " + ticketNo + "\n");
                    fw.write("Mode: " + mode + "\n");
                    fw.write("From: " + from + " ➜ To: " + to + "\n");
                    fw.write("Date: " + date + "\n");
                    fw.write("No. of People: " + people + "\n");
                    fw.write("Total Price: ₹" + totalPrice + "\n");
                    fw.write("----------------------------------\n");
                    fw.close();

                    // Show confirmation
                    JOptionPane.showMessageDialog(panel,
                        "Booking Confirmed!" +
                        "\nTicket No: " + ticketNo +
                        "\nMode: " + mode +
                        "\nFrom: " + from + " ➜ To: " + to +
                        "\nDate: " + date +
                        "\nTotal Price: ₹" + totalPrice +
                        "\n\nTicket saved to file 🎟️");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Booking failed. Please check inputs.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton viewTicketsButton = new JButton("View All Tickets");
        viewTicketsButton.setBounds(130, 320, 150, 30);
        panel.add(viewTicketsButton);

        // View Tickets Action
        viewTicketsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewTicketsScreen.main(null); 
            }
        });

    }
}
