import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener { //just like we override the run() method in splash class,
                                                          // we need to override actionPerformed() method in this class.

    JButton create, back;
    JTextField tfusername, tfname, tfpassword, tfanswer;
    Choice security;

    public Signup() {
        setSize(900, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        add(p1);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 30, 100, 20);
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        p1.add(lblusername);

         tfusername = new JTextField();
        tfusername.setBounds(150, 30, 300, 20);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.setFont(new Font("SAN SERIF", Font.PLAIN, 10));
        p1.add(tfusername);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 70, 100, 20);
        lblname.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        p1.add(lblname);

         tfname = new JTextField();
        tfname.setBounds(150, 70, 300, 20);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        tfname.setFont(new Font("SAN SERIF", Font.PLAIN, 10));
        p1.add(tfname);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(30, 110, 100, 20);
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        p1.add(lblpassword);

         tfpassword = new JTextField();
        tfpassword.setBounds(150, 110, 300, 20);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        tfpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 10));
        p1.add(tfpassword);

        JLabel lblsecurity = new JLabel("Security Questions");
        lblsecurity.setBounds(30, 150, 110, 20);
        lblsecurity.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        p1.add(lblsecurity);

         security = new Choice();
        security.add("Please Choose your security question!");
        security.add("Name of your first school");
        security.add("Name of your current pet");
        security.add("Name of your favourite Movie");
        security.add("Name of your first friend");
        security.setBounds(150, 150, 300, 20);
        p1.add(security);

        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(30, 190, 100, 20);
        lblanswer.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        p1.add(lblanswer);

         tfanswer = new JTextField();
        tfanswer.setBounds(150, 190, 300, 20);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        tfanswer.setFont(new Font("SAN SERIF", Font.PLAIN, 10));
        p1.add(tfanswer);

        create = new JButton("Create");
        create.setBounds(150, 240, 100, 30);
        create.setBackground((Color.WHITE));
        create.setForeground(new Color(131, 193, 233));
        create.setBorder(new LineBorder(Color.BLACK));
        create.setFont(new Font("SAN SERIF", Font.PLAIN, 15));
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBounds(350, 240, 100, 30);
        back.setBackground((Color.WHITE));
        back.setForeground(new Color(131, 193, 233));
        back.setBorder(new LineBorder(Color.BLACK));
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 15));
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 250, 250);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        // create and back buttons are locally defined inside the constructor, so we need to define them globally, as there is no access to them inside
        // the constructor, and same we need to do with other fields like JTextField.
        if(ae.getSource() == create){

                    String username = tfusername.getText();
                    String name = tfname.getText();
                    String password = tfpassword.getText();
                    String question = security.getSelectedItem();
                    String answer = tfanswer.getText(); //after extracting the values from all fields, we need to save them in a table in the database.
                    // So, we now need to go to the database to create a table. Name of table - account.

                    try {
                        if(username.equals("") || name.equals("") || password.equals("") || question.equals("Please Choose your security question!") || answer.equals("")){
                            JOptionPane.showMessageDialog(null, "All fields are mandatory!");
                        }else {
                            String query = "Insert into account values('" + username + "', '" + name + "', '" + password + "', '" + question + "', '" + answer + "')";
                            //to execute this mySQL query ->
                            Conn c = new Conn();
                            c.s.executeUpdate(query);// the above query is a DML command, by which we are updating the data in the
                            // table, so we have used executeUpdate().

                            JOptionPane.showMessageDialog(null, "Account created successfully");
                            setVisible(false);
                            new Login();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
        } else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String args[]){

         new Signup();
    }
}
