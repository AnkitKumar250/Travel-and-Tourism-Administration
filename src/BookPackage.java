import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {

    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice, lblusername, lblid, lblnumber, lblphone, lblprice, lblpackage, lblpersons;
    JTextField tfpersons;
    JButton checkprice, bookpackage, back;
    Choice selectPackage;

    public BookPackage(String username) {
        this.username = username;
        setSize(1100, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("BOOK PACKAGE");
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

        lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(30, 100, 120, 30);
        lblpackage.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblpackage);

        selectPackage = new Choice();
        selectPackage.add("Choose any one");
        selectPackage.add("Gold Package");
        selectPackage.add("Silver Package");
        selectPackage.add("Bronze Package");
        selectPackage.setBackground(Color.WHITE);
        selectPackage.setBounds(200, 100, 200, 30);
        selectPackage.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(selectPackage);


        lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 150, 100, 30);
        lblpersons.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblpersons);

        tfpersons= new JTextField("1");
        tfpersons.setBounds(200, 150, 200, 30);
        tfpersons.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(tfpersons);

        lblid = new JLabel("ID");
        lblid.setBounds(30, 200, 30, 30);
        lblid.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(200, 200, 200, 30);
        labelid.setBackground(Color.WHITE);
        add(labelid);

        lblnumber = new JLabel("ID Number");
        lblnumber.setBounds(30, 250, 100, 30);
        lblnumber.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(200, 250, 200, 30);
        labelnumber.setFont(new Font("Raleway", Font.PLAIN, 12));
        add(labelnumber);

        lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 300, 100, 30);
        lblphone.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(200, 300, 100, 30);
        labelphone.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelphone);

        lblprice = new JLabel("Price");
        lblprice.setBounds(30, 350, 100, 30);
        lblprice.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(200, 350, 200, 30);
        labelprice.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(labelprice);

        checkprice = new JButton("Check Price");
        checkprice.setBounds(60, 400, 100, 30);
        checkprice.setBackground(new Color(131, 193, 233));
        checkprice.setForeground(Color.WHITE);
        checkprice.setBorder(new LineBorder(new Color(133, 193, 233)));
        checkprice.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(180, 400, 100, 30);
        bookpackage.setBackground(new Color(131, 193, 233));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBorder(new LineBorder(new Color(133, 193, 233)));
        bookpackage.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBounds(300, 400, 100, 30);
        back.setBackground(new Color(131, 193, 233));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(133, 193, 233)));
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        back.addActionListener(this);
        add(back);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("idnumber"));
                labelphone.setText(rs.getString("phone"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 10, 500, 400);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            String pack = selectPackage.getSelectedItem();
            int price = 0;
            if(pack.equals("Gold Package")){
                price += 150000;
            }else if(pack.equals("Silver Package")){
                price += 100000;
            }else if(pack.equals("Bronze Package")){
                price += 75000;
            }
            int persons = Integer.parseInt(tfpersons.getText());
            price *= persons;
            labelprice.setText("INR " + price);

        }else if(ae.getSource() == bookpackage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values ('"+labelusername.getText()+"', '"+selectPackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new BookPackage("");
    }
}
