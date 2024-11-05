package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{  
    JButton login,signup,clear;
    JTextField  cardTextField;
    JPasswordField pinTextField;


    Login(){
        
        setTitle("ATM");
        setLayout(null);
        ImageIcon i1 = new ImageIcon("D:\\Bank Management System\\icon\\logo.jpg");

        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward", Font.BOLD,38));
        text.setBounds(200,40,500,40);;
        add(text);


        JLabel cardno = new JLabel("CARD NO:");
        cardno.setFont(new Font("Raleway", Font.BOLD,26));
        cardno.setBounds(120,150,150,28);;
        add(cardno);
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,250,28);
        cardTextField.setFont(new Font("Arial",Font.BOLD,16));
        add(cardTextField);
        




        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD,26));
        pin.setBounds(120,220,250,28);;
        add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,250,28);
        pinTextField.setFont(new Font("Arial",Font.BOLD,16));
        add(pinTextField);


        login = new JButton("Sign IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign up");
        signup.setBounds(300,350,250 ,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);


        setSize(800,480);// define the length and breadth of the frame 
        setVisible(true);// in
        setLocation(350,200 );// to set the location where the box will open 
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");

        }
        else if(ae.getSource()== login){
            conn con = new conn();
            String cardno = cardTextField.getText();
            String pinnum = pinTextField.getText();
            String query=  "select * from login where cardno ='"+cardno+"'and pin ='"+pinnum+"' ";

            
            try{
                ResultSet rs = con.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transition(pinnum).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "incorrect pin or card no.");
                }

            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource()== signup){
            setVisible(false);
            new signupone().setVisible(true);
        }
    }

    




    public static void main(String[] args) {
        new Login();
       
    }
}





    
