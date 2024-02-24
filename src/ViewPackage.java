import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener {

    String username;
    JLabel labelusername, labelpackage, labelpersons, labelid, labelnumber, labelphone, labelprice, lblusername, lblpackage, lblpersons, lblid, lblnumber, lblphone, lblprice;
    JButton back;

    public ViewPackage(String username) {
        this.username = username;
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("PACKAGE DETAILS");
        heading.setBounds(30, 0, 300, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(heading);

        lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 100, 30);
        lblusername.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(230, 50, 100, 30);
        labelusername.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelusername);

        lblid = new JLabel("id");
        lblid.setBounds(30, 110, 30, 30);
        lblid.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(230, 110, 100, 30);
        labelid.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelid);

        lblnumber = new JLabel("ID Number");
        lblnumber.setBounds(30, 180, 120, 30);
        lblnumber.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(230, 180, 100, 30);
        labelnumber.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelnumber);

        lblpackage = new JLabel("Package");
        lblpackage.setBounds(30, 250, 100, 30);
        lblpackage.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblpackage);

        labelpackage = new JLabel();
        labelpackage.setBounds(230, 250, 100, 30);
        labelpackage.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelpackage);

        lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 320, 100, 30);
        lblpersons.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblpersons);

        labelpersons = new JLabel();
        labelpersons.setBounds(230, 320, 100, 30);
        labelpersons.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelpersons);

        lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 390, 100, 30);
        lblphone.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(230, 390, 100, 30);
        labelphone.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelphone);

        lblprice = new JLabel("Price");
        lblprice.setBounds(30, 460, 100, 30);
        lblprice.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(230, 460, 100, 30);
        labelprice.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelprice);

        back = new JButton("Back");
        back.setBounds(200, 520, 100, 30);
        back.setBackground(new Color(131, 193, 233));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(133, 193, 233)));
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 15));
        back.addActionListener(this);
        add(back);

        try{
            Conn c = new Conn();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelpersons.setText(rs.getString("persons"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("idnumber"));
                labelphone.setText(rs.getString("phone"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 60, 450, 400);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new ViewPackage("jk123");
    }
}
