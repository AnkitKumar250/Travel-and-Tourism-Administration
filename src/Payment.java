import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener {

    JButton pay, back;

    public Payment() {
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 600);
        add(image);

        pay = new JButton("Pay Now");
        pay.setBounds(500, 0, 100, 30);
        pay.setBackground(new Color(131, 193, 233));
        pay.setForeground(Color.WHITE);
        pay.setBorder(new LineBorder(new Color(133, 193, 233)));
        pay.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        pay.addActionListener(this);
        image.add(pay);

        back = new JButton("Back");
        back.setBounds(630, 0, 100, 30);
        back.setBackground(new Color(131, 193, 233));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(133, 193, 233)));
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == pay){
            setVisible(false);
            new Paytm();
        }else{
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new Payment();
    }
}
