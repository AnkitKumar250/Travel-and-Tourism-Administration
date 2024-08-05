import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField tfusername, tfname, tfQuestion, tfanswer, tfpassword;
    JButton search, retrieve, back;

    public ForgetPassword() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(900, 400);
        setLocationRelativeTo(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 300);
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

        search = new JButton("Search");
        search.setBounds(150, 60, 100, 20);
        search.setBackground((Color.GRAY));
        search.setForeground(Color.BLACK);
        search.setBorder(new LineBorder(Color.BLACK));
        search.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        search.addActionListener(this);
        p1.add(search);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 100, 100, 20);
        lblname.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(150, 100, 300, 20);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        tfname.setFont(new Font("SAN SERIF", Font.PLAIN, 10));
        p1.add(tfname);

        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setBounds(30, 140, 110, 20);
        lblsecurity.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        p1.add(lblsecurity);

        tfQuestion = new JTextField();
        tfQuestion.setBounds(150, 140, 300, 20);
        tfQuestion.setBorder(BorderFactory.createEmptyBorder());
        tfQuestion.setFont(new Font("SAN SERIF", Font.PLAIN, 10));
        p1.add(tfQuestion);

        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(30, 180, 100, 20);
        lblanswer.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(150, 180, 300, 20);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        tfanswer.setFont(new Font("SAN SERIF", Font.PLAIN, 10));
        p1.add(tfanswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBounds(150, 210, 100, 20);
        retrieve.setBackground((Color.GRAY));
        retrieve.setForeground(Color.BLACK);
        retrieve.setBorder(new LineBorder(Color.BLACK));
        retrieve.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(30, 240, 100, 20);
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(150, 240, 300, 20);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        tfpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 10));
        p1.add(tfpassword);

        back = new JButton("Back");
        back.setBounds(250, 275, 100, 20);
        back.setBackground((Color.GRAY));
        back.setForeground(Color.BLACK);
        back.setBorder(new LineBorder(Color.BLACK));
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        back.addActionListener(this);
        p1.add(back);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(560, 50, 250, 250);
        add(image);



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String query = "Select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query); // the above query is a DDL command, from which we are retrieving the data, so,
                                         // we have used executeQuery(), unlike the one in signup command, where we used
                                         // executeUpdate(), which we used DML command where we were updating the table.
                                       // -> The retrieved data need to be stored somewhere, so, ResultSet is use.
                while(rs.next()){ //loop is used because we have to move around the whole table of the database to check for records.
                    tfname.setText(rs.getString("name"));
                    tfQuestion.setText(rs.getString("question")); //The column names here are the names that are set in the database.
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == retrieve){
            try {
                String query = "Select * from account where answer = '" + tfanswer.getText() + "' AND username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfpassword.setText(rs.getString("password"));
                }
            } catch(Exception e){
                e.printStackTrace();
            }

        } else if(ae.getSource() == back){
            new Login();
        }
    }

    public static void main(String args[]){
        new ForgetPassword();
    }
}
