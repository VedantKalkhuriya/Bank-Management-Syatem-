package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

public class deposit extends JFrame implements ActionListener {
    JButton backButton, depositButton;
    JLabel label;
    String pin;
    JTextField depositTextField;

    deposit(String pinno) {
        this.pin = pinno;

        setLayout(null);

        // Set up the background image
        ImageIcon i1 = new ImageIcon("D:\\Bank Management System\\icon\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(0, 0, 800, 800);
        add(label);

        // Set up the transaction label
        JLabel tran = new JLabel("Amount You want to deposit");
        tran.setBounds(150, 290, 500, 40);
        tran.setForeground(Color.WHITE);
        tran.setFont(new Font("Raleway", Font.BOLD, 20));
        label.add(tran);

        depositTextField = new JTextField();
        depositTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        depositTextField.setBounds(150, 350, 200, 30);
        label.add(depositTextField);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(310, 415, 150, 30);
        depositButton.setBackground(Color.BLACK);
        depositButton.setForeground(Color.WHITE);
        depositButton.addActionListener(this);
        label.add(depositButton);

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
        new deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            String number = depositTextField.getText();
            Date date = new Date();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount");
            } else {
                try {
                    conn con = new conn();
                    String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('" 
                                   + pin + "', '" + date + "', 'Deposit', '" + number + "')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " deposited successfully");
                    setVisible(false);
                    new transition(pin).setVisible(true);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        } else if (e.getSource() == backButton) {
            setVisible(false);
            new transition(pin).setVisible(true);
        }
    }
}
