import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {
    public CheckPackage() {
        setSize(900, 600);
        setLocationRelativeTo(null);

        JTabbedPane tab = new JTabbedPane();

        String[] package1 = {"GOLD PACKAGE", "- 6 Days and 7 Nights", "- Airport Assistance", "- City Tour Assistance", "- Daily Buffet", "- Free Drinks (Premium)", "- 3 Island Cruises per day", "- Premium Wearables", "- Proper Day and Night Care Solutions","Package Price", "INR 1,50,000/-", "Book Package Now", "package1.jpg"};
        String[] package2 = {"SILVER PACKAGE", "- 5 Days and 6 Nights", "- Railway Station Assistance", "- Half Day City Tour Assistance", "- 3 Days Buffet", "- Free Drinks (Non-Premium)", "- 2 Island Cruises per day", "- Non-Premium Wearables", "- Proper Day Care Solutions", "Package Price", "INR 1,00,000/-", "Book Package Now", "package2.jpg"};
        String[] package3 = {"BRONZE PACKAGE", "- 4 Days and 5 Nights", "- Bus Assistance", "- 3 Hours City Tour Assistance", "- 2 Days Buffet", "- Free Soft-Drinks", "- 1 Island Cruise per day", "- Non-Premium Wearables", "- Proper Day Care Solutions", "Package Price", "INR 75,000/-", "Book Package Now", "package3.jpg"};

        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null, p1);

        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2", null, p2);

        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3", null, p3);

        add(tab);

        setVisible(true);
    }

    public JPanel createPackage(String pack[]){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(0, 0, 500, 50);
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        l1.setForeground(Color.ORANGE);
        p1.add(l1);

        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(0, 70, 500, 50);
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setForeground(Color.GREEN);
        p1.add(l2);

        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(0, 110, 500, 50);
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        l3.setForeground(Color.BLUE);
        p1.add(l3);

        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(0, 150, 500, 50);
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        l4.setForeground(Color.GREEN);
        p1.add(l4);

        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(0, 190, 500, 50);
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        l5.setForeground(Color.BLUE);
        p1.add(l5);

        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(0, 230, 500, 50);
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        l6.setForeground(Color.GREEN);
        p1.add(l6);

        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(0, 270, 500, 50);
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        l7.setForeground(Color.BLUE);
        p1.add(l7);

        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(0, 310, 500, 50);
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        l8.setForeground(Color.GREEN);
        p1.add(l8);

        JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(0, 350, 500, 50);
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        l9.setForeground(Color.BLUE);
        p1.add(l9);

        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(230, 420, 500, 50);
        l10.setFont(new Font("Raleway", Font.BOLD, 25));
        l10.setForeground(Color.BLACK);
        p1.add(l10);

        JLabel l11 = new JLabel(pack[10]);
        l11.setBounds(530, 420, 500, 50);
        l11.setFont(new Font("Raleway", Font.BOLD, 25));
        l11.setForeground(Color.RED);
        p1.add(l11);

        JLabel l12 = new JLabel(pack[11]);
        l12.setBounds(340, 470, 500, 50);
        l12.setFont(new Font("Raleway", Font.BOLD, 25));
        l12.setForeground(Color.ORANGE);
        p1.add(l12);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/" + pack[12]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300, 20, 500, 300);
        p1.add(image);

        return p1;

    }

    public static void main(String args[]){
        new CheckPackage();
    }
}
