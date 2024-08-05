import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    JButton back;

    public About() {
        setSize(600, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(250, 20, 100, 30);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        add(l1);

        String s = "Hello everyone, this is Ankit Kumar. I have successfully completed this Travel and Tourism Management System Project, " +
                "which helped me a lot in learning various core java concepts along with object oriented programming and database management basics" +
                "using MySQL. I went through many challenged while completing this project along with the one who helped me in this, i.e. Code for Interview.";

        TextArea text = new TextArea(s, 10,  40, Scrollbar.VERTICAL);
        text.setEditable(false);
        text.setBounds(30, 80, 500, 300);
        add(text);

        back = new JButton("Back");
        back.setBounds(240, 400, 100, 30);
        back.setBackground(new Color(131, 193, 233));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(133, 193, 233)));
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new About();
    }
}
