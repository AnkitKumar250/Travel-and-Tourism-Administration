import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {

    String username;
    JLabel lblusername, labelusername, lblhotel, lblpersons, lbldays, lblAC, lblfood, lblid, labelid, lblnumber, labelnumber, lblphone, labelphone, lblprice, labelprice;
    JTextField tfpersons, tfdays;
    JButton checkprice, book, back;
    Choice selectPackage, choiceAC, choicefood, selectHotel;

    public BookHotel(String username) {
        this.username = username;
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("BOOK HOTEL");
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

        lblhotel = new JLabel("Select Hotel");
        lblhotel.setBounds(30, 100, 120, 30);
        lblhotel.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblhotel);

        selectHotel = new Choice();
        selectHotel.add("Select Hotel");
        selectHotel.setBounds(200, 100, 200, 30);
        add(selectHotel);
        //Here we have already created a table in the database with name, 'hotel', so we will add from the database to this file;
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                selectHotel.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 150, 100, 30);
        lblpersons.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblpersons);

        tfpersons= new JTextField("1");
        tfpersons.setBounds(200, 150, 200, 30);
        tfpersons.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(tfpersons);

        lbldays = new JLabel("No. of Days");
        lbldays.setBounds(30, 200, 100, 30);
        lbldays.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lbldays);

        tfdays= new JTextField("1");
        tfdays.setBounds(200, 200, 200, 30);
        tfdays.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(tfdays);

        lblAC = new JLabel("AC/Non-AC");
        lblAC.setBounds(30, 250, 100, 30);
        lblAC.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblAC);

        choiceAC = new Choice();
        choiceAC.add("Select");
        choiceAC.add("AC");
        choiceAC.add("Non-AC");
        choiceAC.setBounds(200, 250, 200, 30);
        choiceAC.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(choiceAC);

        lblfood = new JLabel("Food Included");
        lblfood.setBounds(30, 300, 100, 30);
        lblfood.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(lblfood);

        choicefood = new Choice();
        choicefood.add("Select");
        choicefood.add("Yes");
        choicefood.add("No");
        choicefood.setBounds(200, 300, 200, 30);
        choicefood.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(choicefood);

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

        checkprice = new JButton("Check Price");
        checkprice.setBounds(60, 550, 100, 30);
        checkprice.setBackground(new Color(131, 193, 233));
        checkprice.setForeground(Color.WHITE);
        checkprice.setBorder(new LineBorder(new Color(133, 193, 233)));
        checkprice.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        checkprice.addActionListener(this);
        add(checkprice);

        book = new JButton("Book Hotel");
        book.setBounds(180, 550, 100, 30);
        book.setBackground(new Color(131, 193, 233));
        book.setForeground(Color.WHITE);
        book.setBorder(new LineBorder(new Color(133, 193, 233)));
        book.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        book.addActionListener(this);
        add(book);

        back = new JButton("Back");
        back.setBounds(300, 550, 100, 30);
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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 70, 500, 400);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+selectHotel.getSelectedItem()+"'");
                while(rs.next()){
                    //database will return String value, so we have used Integer.parseInt() to handle that, because we need int value
                    int cost = Integer.parseInt(rs.getString("costperperson")); //this cost is per person per day.
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt((tfdays.getText()));

                    String acSelected = choiceAC.getSelectedItem();
                    String foodSelected = choicefood.getSelectedItem();

                    if(persons * days > 0){
                        int total = 0;
                        total += acSelected.equals("AC") ? ac : 0;
                        total += foodSelected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days ;
                        labelprice.setText("INR " + total);
                    }else{
                        JOptionPane.showMessageDialog(null, "Please enter a valid number!");
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == book){
            try{
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into bookHotel values ('" + labelusername.getText() + "', '" + selectHotel.getSelectedItem() + "', '" + tfpersons.getText() + "', '" + tfdays.getText() + "', '" + choiceAC.getSelectedItem() + "', '" + choicefood.getSelectedItem() + "', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labelprice.getText() + "')");
                    JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                    setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new BookHotel("");
    }
}

