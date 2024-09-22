import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{

    JPasswordField pintf,rpintf;
    JButton change,back;
    String pin;

    PinChange(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmui.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel jpin = new JLabel("CHANGE YOUR PIN");
        jpin.setForeground(Color.BLACK);
        jpin.setBounds(340,320,200,30);
        jpin.setFont(new Font("System",Font.BOLD,18));
        image.add(jpin);

        JLabel epin = new JLabel("ENTER YOUR PIN");
        epin.setForeground(Color.BLACK);
        epin.setBounds(280,380,200,30);
        epin.setFont(new Font("System",Font.BOLD,16));
        image.add(epin);

        pintf = new JPasswordField();
        pintf.setFont(new Font("Raleways",Font.BOLD,16));
        pintf.setBounds(440,380,150,30);
        image.add(pintf);

        JLabel rpin = new JLabel("RE-ENTER YOUR PIN");
        rpin.setForeground(Color.BLACK);
        rpin.setBounds(280,420,150,30);
        rpin.setFont(new Font("System",Font.BOLD,16));
        image.add(rpin);

        rpintf = new JPasswordField();
        rpintf.setFont(new Font("Raleways",Font.BOLD,16));
        rpintf.setBounds(440,420,150,30);
        image.add(rpintf);

        change = new JButton("Change");
        change.setFont(new Font("Raleways",Font.BOLD,16));
        change.setBounds(440,470,100,30);
        change.setBackground(Color.BLACK);
        change.setForeground(Color.white);
        image.add(change);
        change.addActionListener(this);

        back = new JButton("Back");
        back.setFont(new Font("Raleways",Font.BOLD,16));
        back.setBounds(550,470,85,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        image.add(back);
        back.addActionListener(this);
        
        setLayout(null);
        setVisible(true);
        setSize(900,900);
        setLocation(300,0);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{

                String npin = pintf.getText();
                String rpin = rpintf.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN not Matched");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Plese Enter PIN");
                    return;
                }
                
                conn c = new conn();
                String query1 = "UPDATE BANK SET PIN = '"+rpin+"' where pin = '"+pin+"'";
                String query2 = "UPDATE login SET PIN = '"+rpin+"' where pin = '"+pin+"'";
                String query3 = "UPDATE signupthree SET PIN = '"+rpin+"' where pin = '"+pin+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new Transaction(rpin);

            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pin);
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}
