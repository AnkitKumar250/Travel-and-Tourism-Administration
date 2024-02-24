import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{ //3. if we have implemented an interface in our class and
    //in that interface, there is an abstract method(in our case, run() is an abstract method in Runnable interface),
    //then, we need to override that abstract method in our class. So we will override run() in Splash class.
    Thread thread; //5. We have created a Thread using the Runnable interface. Thread is basically used in applications
    //which need concurrent execution of its parts of code.
    public Splash() {
        //setSize(1200, 600);
        //setLocation(100,100);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        setVisible(true);
        thread = new Thread(this); //thread object is created here.
        thread.start(); //6. .start is used to call run() method, we may directly call run(), but, that will
        //not work as multi-threaded function.
    }

    public void run(){ //4. run() method is overridden here.
        try{
            Thread.sleep(3000);
            setVisible(false);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String args[]){

        Splash frame = new Splash();
        int x = 1;

        for(int i=1; i<=500; x+=7, i+=6){
            //frame.setLocation(750-x, 400-(i/2));
            frame.setLocationRelativeTo(null); //1. this will open the frame at centre
            frame.setSize(x+i, i);
            try{
                Thread.sleep(25); //2. a pause of 25 ms in the continuous transition of screen opening.
            } catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
