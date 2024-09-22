import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class MiniStatement extends JFrame{
        String pin;
    MiniStatement(String pin){
        this.pin = pin;

        JLabel mini = new JLabel();
        mini.setBounds(50,100,200,400);
        add(mini);


        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(120,20,200,20);
        bank.setFont(new Font("System",Font.BOLD,20));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(40,80,800,20);
        card.setFont(new Font("System",Font.BOLD,16));
        add(card);


        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM LOGIN WHERE PIN = '"+pin+"'");
            while(rs.next()){
                card.setText("Card Number XXXX-XXXX-XXXX-"+rs.getString("cardno").substring(12));
            }

            rs = c.s.executeQuery("SELECT *FROM BANK WHERE PIN = '"+pin+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
            }

        }catch(Exception e){
            System.out.println(e);
        }


        setSize(400,600);
        setLayout(null);
        setVisible(true);
        setLocation(50,50);
        setTitle("Mini Statement");

    }
    public static void main(String[] args) {
        new MiniStatement("2316");
    }
    
}
