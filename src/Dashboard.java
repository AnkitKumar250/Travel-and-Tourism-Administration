import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    JButton addPersonalDetails, updatePersonalDetails, viewDetails, deletePersonalDetails, checkPackage, bookPackage, viewPackage, viewHotels;
    JButton bookHotel, viewBookedHotel, destinations, payments, calculator, notepad, about;
    String username;
    public Dashboard(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 1600, 70);
        p1.setBackground(new Color(0, 0, 102));
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 60, 60);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(90, 18, 300, 30);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 65, 300, 800);
        p2.setBackground(new Color(0, 0, 102));
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 500, 43);
        addPersonalDetails.setBackground(new Color(0, 0, 102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Raleway", Font.PLAIN, 20));
        addPersonalDetails.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 43, 500, 43);
        updatePersonalDetails.setBackground(new Color(0, 0, 102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Raleway", Font.PLAIN, 20));
        updatePersonalDetails.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewDetails = new JButton("View Details");
        viewDetails.setBounds(0, 86, 500, 43);
        viewDetails.setBackground(new Color(0, 0, 102));
        viewDetails.setForeground(Color.WHITE);
        viewDetails.setFont(new Font("Raleway", Font.PLAIN, 20));
        viewDetails.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        viewDetails.addActionListener(this);
        p2.add(viewDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 129, 500, 43);
        deletePersonalDetails.setBackground(new Color(0, 0, 102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Raleway", Font.PLAIN, 20));
        deletePersonalDetails.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkPackage = new JButton("Check Package");
        checkPackage.setBounds(0, 172, 500, 43);
        checkPackage.setBackground(new Color(0, 0, 102));
        checkPackage.setForeground(Color.WHITE);
        checkPackage.setFont(new Font("Raleway", Font.PLAIN, 20));
        checkPackage.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        checkPackage.addActionListener(this);
        p2.add(checkPackage);

        bookPackage = new JButton("Book Package");
        bookPackage.setBounds(0, 215, 500, 45);
        bookPackage.setBackground(new Color(0, 0, 102));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setFont(new Font("Raleway", Font.PLAIN, 20));
        bookPackage.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage = new JButton("View Package");
        viewPackage.setBounds(0, 258, 500, 43);
        viewPackage.setBackground(new Color(0, 0, 102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Raleway", Font.PLAIN, 20));
        viewPackage.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0, 301, 500, 43);
        viewHotels.setBackground(new Color(0, 0, 102));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("Raleway", Font.PLAIN, 20));
        viewHotels.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(0, 344, 500, 43);
        bookHotel.setBackground(new Color(0, 0, 102));
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setFont(new Font("Raleway", Font.PLAIN, 20));
        bookHotel.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        bookHotel.addActionListener(this);
        p2.add(bookHotel);

        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0, 387, 500, 43);
        viewBookedHotel.setBackground(new Color(0, 0, 102));
        viewBookedHotel.setForeground(Color.WHITE);
        viewBookedHotel.setFont(new Font("Raleway", Font.PLAIN, 20));
        viewBookedHotel.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);

        destinations = new JButton("Destinations");
        destinations.setBounds(0, 430, 500, 43);
        destinations.setBackground(new Color(0, 0, 102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Raleway", Font.PLAIN, 20));
        destinations.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        destinations.addActionListener(this);
        p2.add(destinations);

        payments = new JButton("Payments");
        payments.setBounds(0, 473, 500, 43);
        payments.setBackground(new Color(0, 0, 102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Raleway", Font.PLAIN, 20));
        payments.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        payments.addActionListener(this);
        p2.add(payments);

        calculator = new JButton("Calculator");
        calculator.setBounds(0, 516, 500, 43);
        calculator.setBackground(new Color(0, 0, 102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Raleway", Font.PLAIN, 20));
        calculator.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        calculator.addActionListener(this);
        p2.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setBounds(0, 559, 500, 43);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Raleway", Font.PLAIN, 20));
        notepad.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0, 602, 500, 43);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Raleway", Font.PLAIN, 20));
        about.setMargin((new Insets(0, 0, 0, 200))); // This function is used to set margin of the object.
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1600, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1600, 1000);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(430, 60, 1600, 100);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma", Font.BOLD, 40));
        image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == addPersonalDetails){
                new AddCustomerDetails(username);
            } else if(ae.getSource() == viewDetails){
                new ViewCustomer(username);
            } else if(ae.getSource() == updatePersonalDetails){
                new UpdateCustomer(username);
            }else if(ae.getSource() == checkPackage){
                new CheckPackage();
            }else if(ae.getSource() == bookPackage){
                new BookPackage(username);
            }else if(ae.getSource() == viewPackage){
                new ViewPackage(username);
            }else if(ae.getSource() == viewHotels){
                new CheckHotels();
            }else if(ae.getSource() == destinations){
                new Destinations();
            }else if(ae.getSource() == bookHotel){
                new BookHotel(username);
            }else if(ae.getSource() == viewBookedHotel){
                new ViewBookedHotel(username);
            }else if(ae.getSource() == payments){
                new Payment();
            }else if(ae.getSource() == calculator){
                try{
                    Runtime.getRuntime().exec("calc.exe");
                }catch(Exception e){
                    e.printStackTrace();
                }
            } else if(ae.getSource() == notepad){
                try{
                    Runtime.getRuntime().exec("notepad.exe");
                }catch(Exception e){
                    e.printStackTrace();
                }
            } else if(ae.getSource() == about){
                new About();
            } else if(ae.getSource() == deletePersonalDetails){
                new DeleteDetails(username);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        new Dashboard("");
    }
}
