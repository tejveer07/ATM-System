import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class fastcash extends JFrame implements ActionListener{
    JButton deposit,withdraw,fastcash,ministmt,pinChange,balance,exit,language,help;
    String pinno;
    fastcash(String pinno){
        this.pinno = pinno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmui.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select Withdrawl Amount");
        image.add(text);
        text.setBounds(250,250,500,35);
        text.setFont(new Font("Raleways",Font.BOLD,20));
        text.setForeground(Color.BLACK);

        deposit = new JButton("100");
        deposit.setBounds(87,215+20,90,30);
        deposit.setFont(new Font("Raleways",Font.BOLD,12));
        deposit.setBackground(Color.black);
        deposit.setForeground(Color.white);
        image.add(deposit);
        deposit.addActionListener(this);

        withdraw = new JButton("200");
        withdraw.setBounds(610,215+20,90,30);
        withdraw.setFont(new Font("Raleways",Font.BOLD,12));
        withdraw.setBackground(Color.black);
        withdraw.setForeground(Color.white);
        image.add(withdraw);
        withdraw.addActionListener(this);

        fastcash = new JButton("500");
        fastcash.setBounds(87,255+20,90,30);
        fastcash.setFont(new Font("Raleways",Font.BOLD,12));
        fastcash.setBackground(Color.black);
        fastcash.setForeground(Color.white);
        image.add(fastcash);
        fastcash.addActionListener(this);


        ministmt = new JButton("1000");
        ministmt.setBounds(610,255+20,90,30);
        ministmt.setFont(new Font("Raleways",Font.BOLD,12));
        ministmt.setBackground(Color.black);
        ministmt.setForeground(Color.white);
        image.add(ministmt);
        ministmt.addActionListener(this);


        pinChange = new JButton("2000");
        pinChange.setBounds(87,300+20,90,30);
        pinChange.setFont(new Font("Raleways",Font.BOLD,12));
        pinChange.setBackground(Color.black);
        pinChange.setForeground(Color.white);
        image.add(pinChange);
        pinChange.addActionListener(this);
        

        
        balance = new JButton("5000");
        balance.setBounds(610,300+20,90,30);
        balance.setFont(new Font("Raleways",Font.BOLD,12));
        balance.setBackground(Color.black);
        balance.setForeground(Color.white);
        image.add(balance);
        balance.addActionListener(this);

        
        language = new JButton("10000");
        language.setBounds(87,345+20,90,30);
        language.setFont(new Font("Raleways",Font.BOLD,12));
        language.setBackground(Color.black);
        language.setForeground(Color.white);
        image.add(language);
        language.addActionListener(this);

        help = new JButton("20000");
        help.setBounds(610,345+20,90,30);
        help.setFont(new Font("Raleways",Font.BOLD,12));
        help.setBackground(Color.black);
        help.setForeground(Color.white);
        image.add(help);
        help.addActionListener(this);

        exit = new JButton("Back");
        exit.setBounds(87,385+20,90,30);
        exit.setFont(new Font("Raleways",Font.BOLD,12));
        exit.setBackground(Color.black);
        exit.setForeground(Color.white);
        image.add(exit);
        exit.addActionListener(this);




        

        setSize(800,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        setLayout(null);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
           new Transaction(pinno);
        }else{
            String amt = ((JButton)ae.getSource()).getText();
            try{
                conn c = new conn();
               ResultSet rs = c.s.executeQuery("SELECT *FROM BANK WHERE PIN = '"+pinno+"'");
               int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource() != exit && balance < Integer.parseInt(amt)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                java.util.Date date = new java.util.Date();
                String query = "INSERT INTO BANK VALUES('" + pinno + "','" + date + "','Withdrawl'," + amt + ")";

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amt+" Withrawl successfully");

            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new fastcash("");
    }
}
