package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signup2 extends JFrame implements ActionListener {
    JComboBox<String> income, religion, education;
    JTextField occupationTextField, panTextField, aadharTextField;
    JButton summit , cancel;
    String formno;
    
    signup2(String formno) {
        this.formno= formno;
        setLayout(null);

        JLabel personalDetails = new JLabel("Page 2: PERSONAL DETAILS");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBounds(260, 0, 400, 40);
        add(personalDetails);

        JLabel religionLabel = new JLabel("Religion:");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100, 100, 200, 40);
        add(religionLabel);

        String[] valReligion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBackground(Color.white);
        religion.setBounds(300, 100, 200, 40);
        add(religion);

        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 180, 200, 40);
        add(incomeLabel);

        String[] incomeCategories = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "upto 1000000"};
        income = new JComboBox<>(incomeCategories);
        income.setBackground(Color.white);
        income.setBounds(300, 180, 200, 40);
        add(income);

        JLabel educationLabel = new JLabel("Education:");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationLabel.setBounds(100, 260, 200, 40);
        add(educationLabel);

        String[] educationCategories = {"Non Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        education = new JComboBox<>(educationCategories);
        education.setBackground(Color.white);
        education.setBounds(300, 260, 200, 40);
        add(education);

        JLabel occupationLabel = new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationLabel.setBounds(100, 340, 200, 40);
        add(occupationLabel);

        occupationTextField = new JTextField();
        occupationTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationTextField.setBounds(300, 340, 400, 35);
        add(occupationTextField);

        JLabel aadharLabel = new JLabel("Aadhar:");
        aadharLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharLabel.setBounds(100, 420, 200, 40);
        add(aadharLabel);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharTextField.setBounds(300, 420, 400, 35);
        add(aadharTextField);

        JLabel panLabel = new JLabel("PAN No.:");
        panLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        panLabel.setBounds(100, 500, 200, 40);
        add(panLabel);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        panTextField.setBounds(300, 500, 400, 35);
        add(panTextField);

        summit = new JButton("Summit");
        summit.setBackground(Color.black);
        summit.setForeground(Color.white);
        summit.setBounds(300, 620, 80, 30);
        summit.addActionListener(this);
        add(summit);
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(400, 620, 80, 30);
        cancel.addActionListener(this);
        add(cancel);

        setBackground(Color.WHITE);
        setSize(800, 700);
        setVisible(true);
        setLocation(350, 100);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== summit) {
        String selectedReligion = (String) religion.getSelectedItem();
        String selectedIncome = (String) income.getSelectedItem();
        String selectedEducation = (String) education.getSelectedItem();
        String occupation = occupationTextField.getText();
        String aadhar = aadharTextField.getText();
        String pan = panTextField.getText();
        Random random = new Random();
        String cardno = "" + Math.abs((random.nextLong() % 90000000L) + 504093600000000L);
        String pinno = "" + Math.abs((random.nextLong() % 9000L) + 10000L);
       

        
        try {
            if (aadhar.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Aadhar number is required");
            } else {
                conn c = new conn();
                String query1 = "INSERT INTO signup2 (formno, religion, income, education, occupation, aadhar, pan) VALUES ('"
                                + formno + "', '" + selectedReligion + "', '" + selectedIncome + "', '" + selectedEducation + "', '"
                                + occupation + "', '" + aadhar + "', '" + pan + "')";
                c.s.executeUpdate(query1);
                String query2 = "INSERT INTO login (formno, cardno, pin) VALUES ('"
                + formno + "', '" + cardno + "', '" + pinno + "')";

                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\nPIN: " + pinno);
                setVisible(false);
                new deposit(pinno).setVisible(true);;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        
        } }else if(e.getSource()== cancel) {

        }
    }
        
        

    public static void main(String[] args) {
        new signup2("");
    }
}
