package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

public class withdraw extends JFrame implements ActionListener {
    JButton backButton, withdrawButton;
    JLabel label;
    String pin;
    JTextField withdrawTextField;

    withdraw(String pinno) {
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
        JLabel tran = new JLabel("Amount You want to withdraw");
        tran.setBounds(150, 290, 500, 40);
        tran.setForeground(Color.WHITE);
        tran.setFont(new Font("Raleway", Font.BOLD, 20));
        label.add(tran);

        withdrawTextField = new JTextField();
        withdrawTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        withdrawTextField.setBounds(150, 350, 200, 30);
        label.add(withdrawTextField);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(310, 415, 150, 30);
        withdrawButton.setBackground(Color.BLACK);
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.addActionListener(this);
        label.add(withdrawButton);

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
        new withdraw("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdrawButton) {
            String number = withdrawTextField.getText();
            Date date = new Date();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount");
            } else {
                try {
                    // Check if the input is a valid number
                    int amount = Integer.parseInt(number);
                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid positive amount");
                        return;
                    }
                    
                    conn con = new conn();
                    String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('" 
                                   + pin + "', '" + date + "', 'withdrawal', '" + amount + "')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdrawn successfully");
                    setVisible(false);
                    new transition(pin).setVisible(true);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a numeric amount");
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
