import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{ 
        JButton back;
        String pin;
    BalanceEnquiry(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmui.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("Back");
        back.setBounds(400,440,100,40);
        back.setFont(new Font("Raleways",Font.BOLD,16));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        image.add(back);
        back.addActionListener(this);

        conn c = new conn();
        int balance = 0;
        try{
            ResultSet rs = c.s.executeQuery("SELECT *FROM BANK WHERE PIN = '"+pin+"'");
           
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }


        JLabel amt = new JLabel("Current Account Balance is: "+balance);
        amt.setBounds(270,350,400,40);
        amt.setFont(new Font("Raleways",Font.BOLD,22));
        amt.setForeground(Color.black);
        image.add(amt);

        setLayout(null);
        setSize(900,900);
        setVisible(true);
        setLocation(300,0);
        setUndecorated(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== back){
            setVisible(false);
            new Transaction(pin);
        }
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
