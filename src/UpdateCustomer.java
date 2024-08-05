import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener{

    String username;
    JLabel labelusername, labelname, lblid, lblnumber, lblgender, lbladdress, lblemail, lblphone, lblcountry, lblusername, lblname;
    JTextField tfnumber, tfaddress, tfemail, tfphone, tfcountry, tfid, tfgender;
    JButton update, back;


    public UpdateCustomer(String username) {
        this.username = username;
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Update user details");
        heading.setBounds(330, 0, 500, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(heading);

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

        tfid = new JTextField();
        tfid.setBounds(180, 100, 200, 30);
        tfid.setBackground(Color.WHITE);
        add(tfid);

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

        tfgender = new JTextField();
        tfgender.setBounds(180, 250, 200, 30);
        tfgender.setFont(new Font("Raleway", Font.PLAIN, 12));
        add(tfgender);

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

        update = new JButton("Update");
        update.setBounds(180, 500, 50, 20);
        update.setBackground((Color.BLACK));
        update.setForeground(Color.WHITE);
        update.setBorder(new LineBorder(Color.BLACK));
        update.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(330, 500, 50, 20);
        back.setBackground((Color.BLACK));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(Color.BLACK));
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(370, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370, 80, 450, 350);
        add(image);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfgender.setText(rs.getString("gender"));
                tfnumber.setText(rs.getString("idnumber"));
                tfemail.setText(rs.getString("email"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfid.setText(rs.getString("id"));
            }
        } catch (Exception e) {

        }


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String username = labelusername.getText();
            String name = labelname.getText();
            String userid = (String) tfid.getText();
            String idnumber = tfnumber.getText();
            String gender = tfgender.getText();
            String address = tfaddress.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            String country = tfcountry.getText();

            try{
                Conn c = new Conn();
                String query = "update customer set username ='"+username+"', name =  '"+name+"', id =  '"+userid+"', idnumber =  '"+idnumber+"', gender = '"+gender+"', address =  '"+address+"', email =  '"+email+"', phone =  '"+phone+"', country = '"+country+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Details updated successfully !");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }

   public static void main(String args[]){
        new UpdateCustomer("");
   }
}

