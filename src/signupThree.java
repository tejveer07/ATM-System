import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class signupThree extends JFrame implements ActionListener {
    JRadioButton saving, current, fd, rc;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel,login;
    String formno;

    signupThree(String formno) {

        this.formno = formno;
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l1.setBounds(300, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 16));
        type.setBounds(100, 100, 200, 30);
        add(type);

        saving = new JRadioButton("Savings Account");
        saving.setFont(new Font("Raleway", Font.BOLD, 14));
        saving.setBounds(100, 150, 200, 30);
        add(saving);

        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 14));
        current.setBounds(350, 150, 200, 30);
        add(current);

        fd = new JRadioButton("fixed Deposit");
        fd.setFont(new Font("Raleway", Font.BOLD, 14));
        fd.setBounds(100, 200, 200, 30);
        add(fd);

        rc = new JRadioButton("Reccurring Account");
        rc.setFont(new Font("Raleway", Font.BOLD, 14));
        rc.setBounds(350, 200, 200, 30);
        add(rc);

        ButtonGroup bg = new ButtonGroup();
        bg.add(saving);
        bg.add(current);
        bg.add(fd);
        bg.add(rc);

        JLabel card = new JLabel("Card Number: ");
        card.setFont(new Font("Raleway", Font.BOLD, 16));
        card.setBounds(100, 250, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-6143");
        number.setFont(new Font("Raleway", Font.BOLD, 16));
        number.setBounds(250, 250, 300, 30);
        add(number);

        JLabel pins = new JLabel("PIN Number: ");
        pins.setFont(new Font("Raleway", Font.BOLD, 16));
        pins.setBounds(100, 280, 200, 30);
        add(pins);

        JLabel pin = new JLabel("XXXX");
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(250, 280, 300, 30);
        add(pin);

        JLabel service = new JLabel("Servies Required");
        service.setFont(new Font("Raleway", Font.BOLD, 16));
        service.setBounds(100, 330, 300, 30);
        add(service);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        c1.setBounds(100, 360, 150, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        c2.setBounds(250, 360, 150, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        c3.setBounds(100, 390, 150, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS alert");
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        c4.setBounds(250, 390, 150, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
        c5.setBounds(100, 420, 150, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 14));
        c6.setBounds(250, 420, 150, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declared that the above entred details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway", Font.BOLD, 14));
        c7.setBounds(100, 470, 800, 60);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD, 20));
        submit.setBounds(220, 550, 120, 50);
        add(submit);
        submit.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 18));
        cancel.setBounds(420, 550, 120, 50);
        add(cancel);
        cancel.addActionListener(this);

        login = new JButton("Go to login");
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setFont(new Font("Raleway", Font.BOLD, 16));
        login.setBounds(600, 550, 150, 50);
        add(login);
        login.addActionListener(this);


        // getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(800, 750);
        setVisible(true);
        setLocation(350, 0);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (saving.isSelected())
                accountType = "Savings Account";
            else if (current.isSelected())
                accountType = "Current Accunt";
            else if (fd.isSelected())
                accountType = "Fixed Deposit";
            else if (rc.isSelected())
                accountType = "Reccurring Deposit";

            Random rand = new Random();
            String cardNo = "" + rand.nextInt(1000, 9999) + "" + rand.nextInt(1000, 9999) + ""
                    + rand.nextInt(1000, 9999) + "" + rand.nextInt(1000, 9999);

            String pinno = "" + rand.nextInt(1000, 9999);
            String services = "";
            if (c1.isSelected()) {
                services += "ATM Card";
            }
            if (c2.isSelected()) {
                services += " Internet Banking";
            }
            if (c3.isSelected()) {
                services += " Mobile Banking";
            }
            if (c4.isSelected()) {
                services += " Email & SMS Alert";
            }
            if (c5.isSelected()) {
                services += " Cheque Book";
            }
            if (c6.isSelected()) {
                services += " E-Statement";
            }

            try {
                conn c = new conn();
                String query = "INSERT INTO SIGNUPTHREE VALUES('" + formno + "','" + accountType + "','" + cardNo
                        + "','" + pinno + "','" + services + "')";
                String query2 = "INSERT INTO LOGIN VALUES('"+formno+"','"+cardNo+"','"+pinno+"')";    
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Card Number: "+cardNo+"\n PIN: "+pinno);

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
        else if(ae.getSource()==login){
            setVisible(false);
            new login();
        }
    }

    public static void main(String[] args) {
        new signupThree("");
    }
}
