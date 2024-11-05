package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signupone extends JFrame implements ActionListener {
    Random random;
    JRadioButton male, female, nmar, omar, mar;
    JTextField namTextField, fnameTextField, dobTextField, emailTextField, cityTextField, stateTextField, addsTextField, pinTextField;

    signupone() {
        setLayout(null);
        random = new Random();
        

        long randomNumber =  Math.abs((random.nextLong() % 9000L) + 1000L);
        JLabel formno = new JLabel("APPLICATION FORM NO " + randomNumber);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personaldet = new JLabel("Page 1: PERSONAL DETAILS ");
        personaldet.setFont(new Font("Raleway", Font.BOLD, 20));
        personaldet.setBounds(260, 75, 400, 40);
        add(personaldet);

        JLabel name = new JLabel("NAME: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 120, 400, 40);
        add(name);
        namTextField = new JTextField();
        namTextField.setBounds(300, 120, 400, 35);
        namTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        add(namTextField);

        JLabel fname = new JLabel("FATHER'S NAME: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 170, 400, 40);
        add(fname);
        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 170, 400, 35);
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        add(fnameTextField);

        JLabel dob = new JLabel("DATE OF BIRTH: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 220, 400, 40);
        add(dob);
        dobTextField = new JTextField();
        dobTextField.setBounds(300, 220, 400, 35);
        dobTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        add(dobTextField);

        JLabel gen = new JLabel("GENDER: ");
        gen.setFont(new Font("Raleway", Font.BOLD, 20));
        gen.setBounds(100, 270, 200, 40);
        add(gen);

        male = new JRadioButton("Male");
        male.setBounds(300, 270, 100, 35);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 270, 150, 35);
        add(female);

        ButtonGroup genGroup = new ButtonGroup();
        genGroup.add(female);
        genGroup.add(male);

        JLabel email = new JLabel("EMAIL: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 320, 400, 40);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(300, 320, 400, 35);
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        add(emailTextField);

        JLabel MS = new JLabel("MARITAL STATUS: ");
        MS.setFont(new Font("Raleway", Font.BOLD, 20));
        MS.setBounds(100, 370, 200, 40);
        add(MS);

        mar = new JRadioButton("Married");
        mar.setBounds(300, 370, 100, 35);
        add(mar);

        nmar = new JRadioButton("Unmarried");
        nmar.setBounds(400, 370, 100, 35);
        add(nmar);

        omar = new JRadioButton("Other");
        omar.setBounds(520, 370, 150, 35);
        add(omar);

        ButtonGroup MSGroup = new ButtonGroup();
        MSGroup.add(nmar);
        MSGroup.add(mar);
        MSGroup.add(omar);

        JLabel adds = new JLabel("ADDRESS: ");
        adds.setFont(new Font("Raleway", Font.BOLD, 20));
        adds.setBounds(100, 420, 400, 40);
        add(adds);
        addsTextField = new JTextField();
        addsTextField.setBounds(300, 420, 400, 35);
        addsTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        add(addsTextField);

        JLabel city = new JLabel("CITY: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 470, 400, 40);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setBounds(300, 470, 400, 35);
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        add(cityTextField);

        JLabel state = new JLabel("STATE: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 520, 400, 40);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setBounds(300, 520, 400, 35);
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        add(stateTextField);

        JLabel pin = new JLabel("PIN CODE: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 570, 400, 40);
        add(pin);
        pinTextField = new JTextField();
        pinTextField.setBounds(300, 570, 400, 35);
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pinTextField);

        JButton next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(620, 620, 80, 30);
        next.addActionListener(this);
        add(next);

        setBackground(Color.WHITE);
        setSize(800, 700);
        setUndecorated(true);
        setVisible(true);
        setLocation(350, 100);
    }

    public void actionPerformed(ActionEvent e) {
        String formno = "" + Math.abs((random.nextLong() % 9000L) + 1000);
        String name = namTextField.getText();
        String fname = fnameTextField.getText();
        String dob = dobTextField.getText();
        String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : null;
        String email = emailTextField.getText();
        String maritalStatus = mar.isSelected() ? "Married" : nmar.isSelected() ? "Unmarried" : omar.isSelected() ? "Other" : null;
        String pin = pinTextField.getText();
        String address = addsTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                conn c = new conn();
                String query = "INSERT INTO signup VALUES ('" + formno + "', '" + name + "',  '" + dob + "', '" + gender + "', '" + email + "', '" + maritalStatus + "', '" + address + "', '" + city + "', '" + pin + "', '" + state + "')";
                c.s.executeUpdate(query);


                setVisible(false);
                new signup2(formno).setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new signupone();
    }
}
