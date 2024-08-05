import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class DeleteDetails extends JFrame implements ActionListener {

    String username;
    JLabel labelusername, labelname, lblid, lblnumber, lblgender, lbladdress, lblemail, lblphone, lblcountry, lblusername, lblname, labelid, labelnumber;
    JLabel labelgender, labeladdress, labelemail, labelphone, labelcountry;
    JButton delete;

    public DeleteDetails(String username) {
        this.username = username;
        setSize(900, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 100, 30);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(180, 50, 100, 30);
        labelusername.setFont(new Font("Raleway", Font.BOLD, 12));
        add(labelusername);

        lblid = new JLabel("id");
        lblid.setBounds(30, 100, 30, 30);
        lblid.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(180, 100, 100, 30);
        labelid.setFont(new Font("Raleway", Font.BOLD, 12));
        add(labelid);

        lblnumber = new JLabel("ID Number");
        lblnumber.setBounds(30, 150, 120, 30);
        lblnumber.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(180, 150, 100, 30);
        labelnumber.setFont(new Font("Raleway", Font.BOLD, 12));
        add(labelnumber);

        lblname = new JLabel("Name");
        lblname.setBounds(30, 200, 100, 30);
        lblname.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(180, 200, 100, 30);
        labelname.setFont(new Font("Raleway", Font.BOLD, 12));
        add(labelname);

        lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 250, 100, 30);
        lblgender.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblgender);

        labelgender = new JLabel();
        labelgender.setBounds(180, 250, 100, 30);
        labelgender.setFont(new Font("Raleway", Font.BOLD, 12));
        add(labelgender);

        lbladdress = new JLabel("Address");
        lbladdress.setBounds(450, 50, 100, 30);
        lbladdress.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lbladdress);

        labeladdress = new JLabel();
        labeladdress.setBounds(600, 50, 100, 30);
        labeladdress.setFont(new Font("Raleway", Font.BOLD, 12));
        add(labeladdress);

        lblemail = new JLabel("E-mail");
        lblemail.setBounds(450, 100, 100, 30);
        lblemail.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblemail);

        labelemail = new JLabel();
        labelemail.setBounds(600, 100, 100, 30);
        labelemail.setFont(new Font("Raleway", Font.BOLD, 12));
        add(labelemail);

        lblphone = new JLabel("Phone no.");
        lblphone.setBounds(450, 150, 100, 30);
        lblphone.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(600, 150, 100, 30);
        labelphone.setFont(new Font("Raleway", Font.BOLD, 12));
        add(labelphone);

        lblcountry = new JLabel("Country");
        lblcountry.setBounds(450, 200, 100, 30);
        lblcountry.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lblcountry);

        labelcountry = new JLabel();
        labelcountry.setBounds(600, 200, 100, 30);
        labelcountry.setFont(new Font("Raleway", Font.BOLD, 12));
        add(labelcountry);

        delete = new JButton("Delete");
        delete.setBounds(330, 300, 50, 20);
        delete.setBackground((Color.BLACK));
        delete.setForeground(Color.WHITE);
        delete.setBorder(new LineBorder(Color.BLACK));
        delete.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        delete.addActionListener(this);
        add(delete);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30, 400, 600, 200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel dupimage = new JLabel(i6);
        dupimage.setBounds(630, 400, 600, 200);
        add(dupimage);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labeladdress.setText(rs.getString("address"));
                labelcountry.setText(rs.getString("country"));
                labelemail.setText(rs.getString("email"));
                labelgender.setText(rs.getString("gender"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("idnumber"));
                labelname.setText(rs.getString("name"));
                labelphone.setText(rs.getString("phone"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
            try {
                Conn c = new Conn();
                c.s.executeUpdate("delete from account where username = '"+username+"'");
                c.s.executeUpdate("delete from customer where username = '"+username+"'");
                c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
                c.s.executeUpdate("delete from bookHotel where username = '"+username+"'");

                JOptionPane.showMessageDialog(null, "Data deleted successfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new DeleteDetails("");
    }
}

