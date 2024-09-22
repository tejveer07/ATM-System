import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class signupOne extends JFrame implements ActionListener{
    int random;
    JLabel formno, personalDetails, name, fname, dob, gender,marital, email, address, city, state, pincode;
    JTextField nametf, fnametf, emailtf,addresstf, citytf, statetf, pincodetf;
    JRadioButton male, female, married, unmarried, others;
    ButtonGroup bg, bg2;
    DateTextField dtf;
    JButton next;
    signupOne() {

        Random rand = new Random();

        random = rand.nextInt(1000,9999);
        formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(220, 70, 400, 25);
        add(personalDetails);

        name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(150, 130, 200, 25);
        add(name);

        nametf = new JTextField();
        nametf.setFont(new Font("Raleway", Font.BOLD, 14));
        nametf.setBounds(320, 130, 300, 25);
        add(nametf);

        fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(150, 175, 200, 25);

        add(fname);

        fnametf = new JTextField();
        fnametf.setFont(new Font("Raleway", Font.BOLD, 14));
        fnametf.setBounds(320, 175, 300, 25);
        add(fnametf);

        dob = new JLabel("D.O.B");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(150, 220, 200, 25);
        add(dob);

        // JCalendar dateChooser = new JCalendar();
        // dateChooser.setBounds(320, 220, 300, 35);
        // dateChooser.setFont(new Font("Raleways", Font.BOLD, 14));
        // add(dateChooser);

        dtf = new DateTextField();
        dtf.setFont(new Font("Raleways", Font.BOLD, 14));
        dtf.setBounds(320, 220, 300, 35);
        add(dtf);

        //YOU HAVE  USED DATETEXTFIELD REMEMBER IT

        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(150, 265, 200, 25);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Raleways", Font.BOLD, 14));
        male.setBounds(320, 265, 150, 40);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Raleways", Font.BOLD, 14));
        female.setBounds(470, 265, 150, 40);
        add(female);

        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(150, 310, 200, 25);
        add(email);

        emailtf = new JTextField();
        emailtf.setFont(new Font("Raleway", Font.BOLD, 14));
        emailtf.setBounds(320, 310, 300, 25);
        add(emailtf);

        marital = new JLabel("Marital");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(150, 355, 200, 25);
        add(marital);

        married = new JRadioButton("Married");
        married.setFont(new Font("Raleways", Font.BOLD, 14));
        married.setBounds(320, 355, 100, 40);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleways", Font.BOLD, 14));
        unmarried.setBounds(420, 355, 100, 40);
        add(unmarried);

        others = new JRadioButton("Others");
        others.setFont(new Font("Raleways", Font.BOLD, 14));
        others.setBounds(520, 355, 100, 40);
        add(others);

        bg2 = new ButtonGroup();
        bg2.add(married);
        bg2.add(unmarried);
        bg2.add(others);

        address = new JLabel("Address");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(150, 400, 200, 25);
        add(address);

        addresstf = new JTextField();
        addresstf.setFont(new Font("Raleway", Font.BOLD, 14));
        addresstf.setBounds(320, 400, 300, 25);
        add(addresstf);

        city = new JLabel("City");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(150, 445, 200, 25);
        add(city);

        citytf = new JTextField();
        citytf.setFont(new Font("Raleway", Font.BOLD, 14));
        citytf.setBounds(320, 445, 300, 25);
        add(citytf);

        state = new JLabel("State");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(150, 490, 200, 25);
        add(state);

        statetf = new JTextField();
        statetf.setFont(new Font("Raleway", Font.BOLD, 14));
        statetf.setBounds(320, 490, 300, 25);
        add(statetf);

        pincode = new JLabel("Pin Code");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(150, 535, 200, 25);
        add(pincode);

        pincodetf = new JTextField();
        pincodetf.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodetf.setBounds(320, 535, 300, 25);
        add(pincodetf);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(400,580,150,35);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(800, 750);
        setLocation(350, 10);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nametf.getText();
        String fname = fnametf.getText();

        // DOB is not considering it is already solved by chatgpt
        
        String gender = null;
        if(male.isSelected()) gender = "male";
        else if(female.isSelected()) gender = "female";
        
        String email = emailtf.getText();
        String marital = null;
        if(married.isSelected()) marital = "Married";
        else if(unmarried.isSelected()) marital = "unmarried";
        else if(others.isSelected()) marital = "Others";
        String address = addresstf.getText();
        String city = citytf.getText();
        String state = statetf.getText();
        String pincode = pincodetf.getText();
        Date db = dtf.getDate();
        String dob = ""+db;

        try{
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null,"Name is required");
                }else{
                    conn c = new conn();
                    String query = "INSERT INTO SIGNUP VALUES('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";

                    c.s.executeUpdate(query);
                    setVisible(false);
                    new signupTwo(formno);
                }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
         new signupOne();
    }
}
