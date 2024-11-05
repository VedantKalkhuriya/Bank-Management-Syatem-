package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class showamount extends JFrame implements ActionListener {
    JButton backButton;
    JLabel label, tran;
    String pin;

    showamount(String pinno) {
        this.pin = pinno;
        setLayout(null);

        // Set up the background image
        ImageIcon i1 = new ImageIcon("D:\\Bank Management System\\icon\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(0, 0, 800, 800);
        add(label);

        //Initialize and calculate the balance
        conn c = new conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            while (rs.next()) {
                String type = rs.getString("type");
                int amount = Integer.parseInt(rs.getString("amount"));

                if (type.equalsIgnoreCase("deposit")) {
                    balance += amount;
                } else if (type.equalsIgnoreCase("withdrawal")) {
                    balance -= amount;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // Set up the transaction label with the current balance
        tran = new JLabel("Current Amount Is Rs: " + balance);
        tran.setBounds(150, 290, 500, 40);
        tran.setForeground(Color.WHITE);
        tran.setFont(new Font("Raleway", Font.BOLD, 20));
        label.add(tran);
 
        // Set up the Back button
        backButton = new JButton("Back");
        backButton.setBounds(310, 445, 150, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        label.add(backButton);

        setSize(800, 800);
        setLocation(350, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new showamount("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new transition(pin).setVisible(true); // Ensure 'transition' is a defined class
    }
}
