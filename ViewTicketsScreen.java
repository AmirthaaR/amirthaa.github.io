package easytrip.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class ViewTicketsScreen {
    public static void main(String[] args) {
        JFrame frame = new JFrame("View All Tickets");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null); 

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea ticketArea = new JTextArea();
        ticketArea.setEditable(false); 
        ticketArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(ticketArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("tickets.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                ticketArea.append(line + "\n");
            }
            reader.close();
        } catch (IOException ex) {
            ticketArea.append("No tickets found.");
        }

        JButton closeButton = new JButton("Close");
        panel.add(closeButton, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);
        
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

    }
}
