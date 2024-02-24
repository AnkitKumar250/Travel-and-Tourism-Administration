import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener {
    JButton back;
    public Paytm() {
        setSize(900, 600);
        setLocationRelativeTo(null);

        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        try{
            pane.setPage("https://paytm.com/rent-payment");
        }catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could not find the page</html>");
        }

        JScrollPane scrollbar  = new JScrollPane(pane);
        getContentPane().add(scrollbar);

        back = new JButton("Back");
        back.setBounds(630, 50, 100, 30);
        back.setBackground(new Color(131, 193, 233));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(133, 193, 233)));
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 12));
        back.addActionListener(this);
        pane.add(back);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }

    public static void main(String args[]){
        new Paytm();
    }
}
