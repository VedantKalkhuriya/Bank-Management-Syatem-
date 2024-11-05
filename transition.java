package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class transition extends JFrame implements ActionListener { 
    JButton exit,balance,deposit,withdraw;
    JLabel label;
    String pin;
    // Extend JFrame
    transition(String pinno) {
        this.pin=pinno;
        setLayout(null);

// Set up the background image
        ImageIcon i1 = new ImageIcon("D:\\Bank Management System\\icon\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(0, 0, 800, 800);
        add(label);

        // Set up the transaction label
        JLabel tran = new JLabel("Please select your transaction"); // Corrected text to "transaction"
        tran.setBounds(150, 290, 500, 40); // Adjust position if needed
        tran.setForeground(Color.WHITE);
        tran.setFont(new Font("Raleway", Font.BOLD, 20)); // Slightly larger font size for visibility
        label.add(tran); // Add `tran` to the image label


        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.white);
        deposit.addActionListener(this);
        label.add(deposit);
        balance = new JButton("Balance");
        balance.setBounds(170,450,150,30);
        balance.setBackground(Color.BLACK);
        balance.setForeground(Color.white);
        balance.addActionListener(this);
        label.add(balance);
        withdraw = new JButton("withdraw");
        withdraw.setBounds(355,415,100,30);
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.white);
        withdraw.addActionListener(this);
        label.add(withdraw);
        exit = new JButton("Exit");
        exit.setBounds(355,450,100,30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        label.add(exit);

        setSize(800, 800); // Set the dimensions of the frame
         // Make the frame visible
        setLocation(350, 0); 
        setUndecorated(true);//
        setVisible(true);
    
    
    }

    public static void main(String[] args) {
        new transition(""); // Instantiate the frame
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==exit){
            System.exit(0);     
          }else if (e.getSource()==deposit){
            setVisible(false);
            new deposit(pin).setVisible(true);
          }else if (e.getSource()==withdraw){
            setVisible(false);
            new withdraw(pin).setVisible(true);
          }else if (e.getSource()==balance){
            setVisible(false);
            new showamount(pin).setVisible(true);
    }
}
}
