import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomerDetails extends JFrame implements ActionListener {

    String username;
    JLabel labelusername, labelname, lblid, lblnumber, lblgender, lbladdress, lblemail, lblphone, lblcountry, lblusername, lblname;
    JTextField tfnumber, tfaddress, tfemail, tfphone, tfcountry ;
    JRadioButton male, female;
    JComboBox id;
    JButton add, back;


    public AddCustomerDetails(String username) {
        this.username = username;
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 100, 30);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(180, 50, 100, 30);
        labelusername.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelusername);

        lblid = new JLabel("id");
        lblid.setBounds(30, 100, 30, 30);
        lblid.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblid);

        id = new JComboBox(new String[]{"Choose id type", "Passport", "Aadhar Card", "Pan Card", "Student id"});
        id.setBounds(180, 100, 200, 30);
        id.setBackground(Color.WHITE);
        add(id);

        lblnumber = new JLabel("ID Number");
        lblnumber.setBounds(30, 150, 120, 30);
        lblnumber.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(180, 150, 200, 30);
        tfnumber.setFont(new Font("Raleway", Font.PLAIN, 12));
        add(tfnumber);

        lblname = new JLabel("Name");
        lblname.setBounds(30, 200, 100, 30);
        lblname.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(180, 200, 100, 30);
        labelname.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelname);

        lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 250, 100, 30);
        lblgender.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblgender);

        male = new JRadioButton("Male");
        male.setBounds(180, 240, 100, 50);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(280, 240, 100, 50);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 300, 100, 30);
        lbladdress.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(180, 300, 200, 30);
        tfaddress.setFont(new Font("Raleway", Font.PLAIN, 12));
        add(tfaddress);

        lblemail = new JLabel("E-mail");
        lblemail.setBounds(30, 350, 100, 30);
        lblemail.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(180, 350, 200, 30);
        tfemail.setFont(new Font("Raleway", Font.PLAIN, 12));
        add(tfemail);

        lblphone = new JLabel("Phone no.");
        lblphone.setBounds(30, 400, 100, 30);
        lblphone.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(180, 400, 200, 30);
        tfphone.setFont(new Font("Raleway", Font.PLAIN, 12));
        add(tfphone);

        lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 450, 100, 30);
        lblcountry.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(180, 450, 200, 30);
        tfcountry.setFont(new Font("Raleway", Font.PLAIN, 12));
        add(tfcountry);

        add = new JButton("Add");
        add.setBounds(180, 500, 50, 20);
        add.setBackground((Color.BLACK));
        add.setForeground(Color.WHITE);
        add.setBorder(new LineBorder(Color.BLACK));
        add.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(330, 500, 50, 20);
        back.setBackground((Color.BLACK));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(Color.BLACK));
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420, 40, 450, 420);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
                String username = labelusername.getText();
                String name = labelname.getText();
                String userid = (String) id.getSelectedItem();
                String idnumber = tfnumber.getText();
                String gender = null;
                if(male.isSelected()){
                    gender = "male";
                }else{
                    gender = "female";
                }
                String address = tfaddress.getText();
                String email = tfemail.getText();
                String phone = tfphone.getText();
                String country = tfcountry.getText();

                try{
                    if(username.equals("")||name.equals("")||userid.equals("")||idnumber.equals("")||gender.equals("")||address.equals("")||email.equals("")||phone.equals("")||country.equals("")){
                        JOptionPane.showMessageDialog(null, "All fields are mandatory!");
                    }else {
                        Conn c = new Conn();
                        String query = "Insert into customer values('" + username + "', '" + name + "', '" + userid + "', '" + idnumber + "', '" + gender + "', '" + address + "', '" + email + "', '" + phone + "', '" + country + "')";
                        c.s.executeUpdate(query);

                        JOptionPane.showMessageDialog(null, "Details added successfully !");
                        setVisible(false);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

        }else{
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new AddCustomerDetails("");
    }
}
