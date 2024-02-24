import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewBookedHotel extends JFrame implements ActionListener {

    String username;
    JLabel lblusername, labelusername, lblhotel, lblpersons, lbldays, lblAC, lblfood, lblid, labelid, lblnumber, labelnumber, lblphone, labelphone, lblprice, labelprice, labelpersons, labeldays, labelAC, labelfood, labelhotel;
    JButton back;

    public ViewBookedHotel(String username) {
        this.username = username;
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("VIEW BOOKED HOTEL");
        heading.setBounds(30, 0, 300, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(heading);

        lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 100, 30);
        lblusername.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(200, 50, 200, 30);
        labelusername.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelusername);

        lblhotel = new JLabel("Hotel");
        lblhotel.setBounds(30, 100, 120, 30);
        lblhotel.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblhotel);

        labelhotel = new JLabel();
        labelhotel.setBounds(200, 100, 200, 30);
        labelhotel.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelhotel);

        lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 150, 100, 30);
        lblpersons.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblpersons);

        labelpersons= new JLabel();
        labelpersons.setBounds(200, 150, 200, 30);
        labelpersons.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelpersons);

        lbldays = new JLabel("No. of Days");
        lbldays.setBounds(30, 200, 100, 30);
        lbldays.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lbldays);

        labeldays= new JLabel();
        labeldays.setBounds(200, 200, 200, 30);
        labeldays.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labeldays);

        lblAC = new JLabel("AC/Non-AC");
        lblAC.setBounds(30, 250, 100, 30);
        lblAC.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblAC);

        labelAC = new JLabel();
        labelAC.setBounds(200, 250, 200, 30);
        labelAC.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelAC);

        lblfood = new JLabel("Food Included");
        lblfood.setBounds(30, 300, 100, 30);
        lblfood.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblfood);

        labelfood = new JLabel();
        labelfood.setBounds(200, 300, 200, 30);
        labelfood.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelfood);

        lblid = new JLabel("ID");
        lblid.setBounds(30, 350, 30, 30);
        lblid.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(200, 350, 200, 30);
        labelid.setBackground(Color.WHITE);
        add(labelid);

        lblnumber = new JLabel("ID Number");
        lblnumber.setBounds(30, 400, 100, 30);
        lblnumber.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(200, 400, 200, 30);
        labelnumber.setFont(new Font("Raleway", Font.PLAIN, 12));
        add(labelnumber);

        lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 450, 100, 30);
        lblphone.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(200, 450, 100, 30);
        labelphone.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelphone);

        lblprice = new JLabel("Price");
        lblprice.setBounds(30, 500, 100, 30);
        lblprice.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(200, 500, 200, 30);
        labelprice.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelprice);

        back = new JButton("Back");
        back.setBounds(150, 550, 100, 30);
        back.setBackground(new Color(131, 193, 233));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(133, 193, 233)));
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        back.addActionListener(this);
        add(back);

        try{
            Conn c = new Conn();
            String query = "select * from bookHotel where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelfood.setText(rs.getString("food"));
                labelhotel.setText(rs.getString("hotel"));
                labeldays.setText(rs.getString("days"));
                labelAC.setText(rs.getString("acfacility"));
                labelprice.setText(rs.getString("totalprice"));
                labelpersons.setText(rs.getString("persons"));
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("idnumber"));
                labelphone.setText(rs.getString("phone"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 70, 500, 400);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new ViewBookedHotel("jk123");
    }
}

