import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Deposit extends JFrame implements ActionListener{
        JTextField amount;
        JButton deposit,back;
        String pin;

    Deposit(String pin){
        
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmui.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount to deposit");
        text.setFont(new Font("System",Font.BOLD,18));
        text.setBounds(320,320,380,40);
        text.setForeground(Color.BLACK);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(315,380,300,40);
        amount.setFont(new Font("System",Font.BOLD,20));
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(390,440,120,40);
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.white);
        deposit.setFont(new Font("System",Font.BOLD,16));
        image.add(deposit);
        deposit.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(530,440,90,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFont(new Font("System",Font.BOLD,16));
        image.add(back);
        back.addActionListener(this);

        setSize(900,900);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setLocation(300,0);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String amt = amount.getText();
            java.util.Date date = new java.util.Date();

            if(amt.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter amount");
            }else{
                try{
                    conn c = new conn();
                    String query = "INSERT INTO BANK VALUES('"+pin+"','"+date.toString()+"', 'Deposit' ,'"+amt+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+amt+" Deposited Successfully");

                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pin);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
