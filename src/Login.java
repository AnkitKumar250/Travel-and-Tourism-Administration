import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, password;
    JTextField tfusername, tfpassword;

    public Login() {
        setSize(900, 400);
        setLocationRelativeTo(null);
        setLayout(null); //2. Layout is used to work with how I want to place my components on the window/panel. Here I want to use my own layout, so,
         //setLayout, i.e., the default layout is set NULL.
        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel(); // 1. we have to divide the window into no. of  panels, so we use the JPanel.
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);//3. Here I will set my own layout of the panel.
        p1.setLayout(null); //4. Here to place my components over the panel and handle them, I will set the Layout value as 0;
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 100, 200,200); //5. To handle the bounds of the image on the panel, first, I set the panel Layout to 0.
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 20);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.setFont(new Font("SAN SERIF", Font.PLAIN, 15));
        p2.add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 95, 100, 25);
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(60, 135, 300, 20);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        tfpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 15));
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60, 170, 100, 30);
        login.setBackground(new Color(131, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.setFont(new Font("SAN SERIF", Font.PLAIN, 15));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(260, 170, 100, 30);
        signup.setBackground(new Color(131, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.setFont(new Font("SAN SERIF", Font.PLAIN, 15));
        signup.addActionListener(this);
        p2.add(signup);

        password = new JButton("Forgot Password ?");
        password.setBounds(110, 220, 200, 30);
        password.setBackground(new Color(131, 193, 233));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        password.setFont(new Font("SAN SERIF", Font.PLAIN, 15));
        password.addActionListener(this);
        p2.add(password);

        JLabel text = new JLabel("Trouble Signing in ?");
        text.setBounds(150, 265, 300, 20);
        text.setForeground(Color.RED);
        p2.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == password){
            try{
                new ForgetPassword();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == signup){
            try{
                new Signup();
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == login){
                try {
                    String username = tfusername.getText();
                    String pass = tfpassword.getText();
                    if(username.equals("") || pass.equals("")){
                        JOptionPane.showMessageDialog(null, "All fields are mandatory!");
                    }else {
                        String query = "Select * from account where username = '" + username + "' AND password = '" + pass + "'";
                        Conn c = new Conn();
                        ResultSet rs = c.s.executeQuery(query);
                        if (rs.next()) {
                            setVisible(false);
                            new Loading(username); //here username is passed as an argument, for the loading class, where we will see the name as
                            // welcome -> username.
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong Username or Password!");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    public static void main(String args[]){
        new Login();
    }
}
