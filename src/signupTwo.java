import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signupTwo extends JFrame implements ActionListener {

    JTextField adhartf, pantf;
    JRadioButton sns, sys, ens, eys;
    JComboBox relegiontf, categorytf, incometf, education, occupationtf;
    JButton next;
    String formno;

    signupTwo(String formno) {

        this.formno = formno;
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(220, 70, 400, 25);
        add(additionalDetails);

        JLabel relegion = new JLabel("Relegion");
        relegion.setFont(new Font("Raleway", Font.BOLD, 20));
        relegion.setBounds(150, 130, 200, 25);
        add(relegion);

        relegiontf = new JComboBox<String>(new String[] { "Hindu", "Muslim", "Sikh", "Christian", "Others" });
        relegiontf.setFont(new Font("Raleway", Font.BOLD, 14));
        relegiontf.setBounds(320, 130, 300, 25);
        add(relegiontf);
        relegiontf.setBackground(Color.white);

        JLabel category = new JLabel("Category");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(150, 175, 200, 25);
        add(category);

        categorytf = new JComboBox<String>(new String[] { "General", "OBC", "ST/SC", "EWS", "Pwd" });
        categorytf.setFont(new Font("Raleway", Font.BOLD, 14));
        categorytf.setBounds(320, 175, 300, 25);
        add(categorytf);
        categorytf.setBackground(Color.white);

        JLabel income = new JLabel("Income");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(150, 220, 200, 25);
        add(income);

        // incometf = new JTextField();
        // incometf.setFont(new Font("Raleways", Font.BOLD, 14));
        // incometf.setBounds(320, 220, 300, 35);
        // add(incometf);

        incometf = new JComboBox<String>(
                new String[] { "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000" });
        incometf.setFont(new Font("Raleway", Font.BOLD, 14));
        incometf.setBounds(320, 220, 300, 25);
        add(incometf);
        incometf.setBackground(Color.white);

        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(150, 280, 200, 25);
        add(educational);
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(150, 310, 200, 25);
        add(qualification);

        education = new JComboBox<String>(new String[] { "Illiterate", "High School", "Higher Seconadary",
                "Under Graduate", "PostGraduate", "Masters" });
        education.setFont(new Font("Raleway", Font.BOLD, 14));
        education.setBounds(320, 300, 300, 25);
        add(education);
        education.setBackground(Color.white);

        JLabel occupation = new JLabel("Occupation");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(150, 355, 200, 25);
        add(occupation);

        occupationtf = new JComboBox<String>(
                new String[] { "Salaried", "Self-Employed", "Business", "Student", "Retired", "Others" });
        occupationtf.setFont(new Font("Raleway", Font.BOLD, 14));
        occupationtf.setBounds(320, 355, 300, 25);
        add(occupationtf);
        occupationtf.setBackground(Color.white);

        JLabel panNo = new JLabel("PAN no.");
        panNo.setFont(new Font("Raleway", Font.BOLD, 20));
        panNo.setBounds(150, 400, 200, 25);
        add(panNo);

        pantf = new JTextField();
        pantf.setFont(new Font("Raleway", Font.BOLD, 14));
        pantf.setBounds(320, 400, 300, 25);
        add(pantf);

        JLabel adhaarNo = new JLabel("Adhaar No.");
        adhaarNo.setFont(new Font("Raleway", Font.BOLD, 20));
        adhaarNo.setBounds(150, 445, 200, 25);
        add(adhaarNo);

        adhartf = new JTextField();
        adhartf.setFont(new Font("Raleway", Font.BOLD, 14));
        adhartf.setBounds(320, 445, 300, 25);
        add(adhartf);

        JLabel senior = new JLabel("Senior Citizen");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(150, 490, 200, 25);
        add(senior);

        sys = new JRadioButton("Yes");
        sys.setFont(new Font("Raleway", Font.BOLD, 14));
        sys.setBounds(320, 490, 150, 25);
        add(sys);
        sns = new JRadioButton("No");
        sns.setFont(new Font("Raleway", Font.BOLD, 14));
        sns.setBounds(470, 490, 150, 25);
        add(sns);

        ButtonGroup bg = new ButtonGroup();
        bg.add(sys);
        bg.add(sns);

        JLabel existac = new JLabel("Exisitg account");
        existac.setFont(new Font("Raleway", Font.BOLD, 20));
        existac.setBounds(150, 535, 200, 25);
        add(existac);

        eys = new JRadioButton("Yes");
        eys.setFont(new Font("Raleway", Font.BOLD, 14));
        eys.setBounds(320, 535, 150, 25);
        add(eys);
        ens = new JRadioButton("No");
        ens.setFont(new Font("Raleway", Font.BOLD, 14));
        ens.setBounds(470, 535, 150, 25);
        add(ens);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(eys);
        bg2.add(ens);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(400, 580, 150, 35);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setTitle("NEW ACCOUNT APPLICATION - PAGE : 02");
        setSize(800, 750);
        setLocation(350, 10);
        setLayout(null);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae) {
        String relegion = ""+relegiontf.getSelectedItem();
        String category = ""+categorytf.getSelectedItem();
        String income = ""+incometf.getSelectedItem();
        String educationQ = ""+education.getSelectedItem();
        String occupation = ""+occupationtf.getSelectedItem();
        String senior = null;
        if(sys.isSelected()) senior = "Yes";
        else if(sns.isSelected()) senior = "No";
        String existac = null;
        if(eys.isSelected()) existac = "Yes";
        else if(ens.isSelected()) existac = "No";
        String pan = pantf.getText();
        String adhaar = adhartf.getText();

        try{
        conn c = new conn();
        String query = "INSERT INTO SIGNUPTWO VALUES('" + formno + "','" + relegion + "','"
        + category + "','" + income + "','" + educationQ + "','" + occupation + "','" + pan +
        "','" + adhaar + "','" + senior + "','" + existac + "')";

        c.s.executeUpdate(query);
        setVisible(false);
        new signupThree(formno);
        }catch(Exception e){
        System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new signupTwo("");
    }

}