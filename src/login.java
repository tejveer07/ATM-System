import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class login extends JFrame implements ActionListener {
    JButton login, clear, signup;
    JTextField cardTF;
    JPasswordField pinTF;

    login() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank_PNG9.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        add(text);
        text.setBounds(250, 40, 500, 100);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setForeground(Color.black);

        JLabel cardNo = new JLabel("Card No.:");
        add(cardNo);
        cardNo.setBounds(250, 150, 200, 50);
        cardNo.setFont(new Font("Osward", Font.BOLD, 25));
        cardNo.setForeground(Color.black);

        JLabel pin = new JLabel("PIN:");
        add(pin);
        pin.setBounds(250, 200, 200, 50);
        pin.setFont(new Font("Osward", Font.BOLD, 25));
        pin.setForeground(Color.black);


        cardTF = new JTextField(20);
        add(cardTF);
        cardTF.setBounds(400, 150, 150, 30);

        pinTF = new JPasswordField(20);
        add(pinTF);
        pinTF.setBounds(400, 200, 150, 30);

        login = new JButton("Login");
        add(login);
        login.setBounds(250, 300, 100, 30);
        login.addActionListener(this);

        clear = new JButton("Clear");
        add(clear);
        clear.setBounds(370, 300, 100, 30);
        clear.addActionListener(this);

        signup = new JButton("Sign Up");
        add(signup);
        signup.setBounds(300, 350, 100, 30);
        signup.addActionListener(this);

        getContentPane().setBackground(Color.gray);
        setTitle("ATM Machine");
        setSize(800, 480);
        setLayout(null);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            conn c = new conn();
            String cardNo = cardTF.getText();
            String pin = pinTF.getText();

            String query = "SELECT *FROM LOGIN WHERE cardno ='" + cardNo + "' and pin = '" + pin + "'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pin);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card No. or PIN");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == clear) {
            cardTF.setText("");
            pinTF.setText("");
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new signupOne();
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
