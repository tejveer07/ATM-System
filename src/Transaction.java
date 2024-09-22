import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    JButton deposit,withdraw,fastcash,ministmt,pinChange,balance,exit,language,help;
    String pinno;
    Transaction(String pinno){
        this.pinno = pinno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmui.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select your Transaction");
        image.add(text);
        text.setBounds(250,250,500,35);
        text.setFont(new Font("Raleways",Font.BOLD,20));
        text.setForeground(Color.BLACK);

        deposit = new JButton("Deposit");
        deposit.setBounds(87,215+20,90,30);
        deposit.setFont(new Font("Raleways",Font.BOLD,12));
        deposit.setBackground(Color.black);
        deposit.setForeground(Color.white);
        image.add(deposit);
        deposit.addActionListener(this);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(610,215+20,90,30);
        withdraw.setFont(new Font("Raleways",Font.BOLD,12));
        withdraw.setBackground(Color.black);
        withdraw.setForeground(Color.white);
        image.add(withdraw);
        withdraw.addActionListener(this);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(87,255+20,90,30);
        fastcash.setFont(new Font("Raleways",Font.BOLD,12));
        fastcash.setBackground(Color.black);
        fastcash.setForeground(Color.white);
        image.add(fastcash);
        fastcash.addActionListener(this);


        ministmt = new JButton("Mini Statement");
        ministmt.setBounds(610,255+20,90,30);
        ministmt.setFont(new Font("Raleways",Font.BOLD,12));
        ministmt.setBackground(Color.black);
        ministmt.setForeground(Color.white);
        image.add(ministmt);
        ministmt.addActionListener(this);


        pinChange = new JButton("PIN Change");
        pinChange.setBounds(87,300+20,90,30);
        pinChange.setFont(new Font("Raleways",Font.BOLD,12));
        pinChange.setBackground(Color.black);
        pinChange.setForeground(Color.white);
        image.add(pinChange);
        pinChange.addActionListener(this);
        

        
        balance = new JButton("Balance");
        balance.setBounds(610,300+20,90,30);
        balance.setFont(new Font("Raleways",Font.BOLD,12));
        balance.setBackground(Color.black);
        balance.setForeground(Color.white);
        image.add(balance);
        balance.addActionListener(this);

        
        language = new JButton("Language");
        language.setBounds(87,345+20,90,30);
        language.setFont(new Font("Raleways",Font.BOLD,12));
        language.setBackground(Color.black);
        language.setForeground(Color.white);
        image.add(language);
        language.addActionListener(this);

        help = new JButton("Help");
        help.setBounds(610,345+20,90,30);
        help.setFont(new Font("Raleways",Font.BOLD,12));
        help.setBackground(Color.black);
        help.setForeground(Color.white);
        image.add(help);
        help.addActionListener(this);

        exit = new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinno);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdrawl(pinno);
        } else if(ae.getSource() ==fastcash){
            setVisible(false);
            new fastcash(pinno);
        } else if(ae.getSource() ==pinChange){
            setVisible(false);
            new PinChange(pinno);
        }else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinno);
        }else if(ae.getSource()==ministmt){
            new MiniStatement(pinno);
        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
