import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{

    Thread t;
    String username;
    JProgressBar bar;

    public Loading(String username) {
        this.username = username; //here we have stored local variable into global variable.
        setLayout(null);
        setSize(700, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text  = new JLabel("Travel and Tourism Application");
        text.setBounds(90, 30, 600, 50);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        text.setForeground(Color.BLUE);
        add(text);

        bar = new JProgressBar();
        bar.setBounds(200, 120, 300, 30);
        bar.setStringPainted(true);
        bar.setForeground(Color.GREEN);
        add(bar);

        JLabel wait  = new JLabel("Loading, please wait... ");
        wait.setBounds(300, 170, 300, 30);
        wait.setFont(new Font("Raleway", Font.BOLD, 10));
        wait.setForeground(Color.BLUE);
        add(wait);

        JLabel welcome  = new JLabel("Welcome " + username); //
        welcome.setBounds(280, 220, 200, 30);
        welcome.setFont(new Font("Raleway", Font.BOLD, 20));
        welcome.setForeground(Color.RED);
        add(welcome);

        t = new Thread(this);
        t.start();

        setVisible(true);
    }

    public void run(){
        try{
            for(int i=1; i<=101; i++){
                int max = bar.getMaximum(); //100
                int value = bar.getValue(); //current value

                if(value < max){
                    bar.setValue(bar.getValue() + 1);
                } else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]){

        new Loading(""); //here we have passed a string because now we don't have a default constructor as we
                                 // have passed a string named username in the constructor.
    }
}
