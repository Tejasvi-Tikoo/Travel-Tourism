package travel.system;
import javax.swing.*;
import java.awt.*;

public class Splashscreen extends JFrame implements Runnable {   //can't extend thread now so gotta implement runnable 
    //Runnable contains an abstract method run so either make our class abstract too or override run() but abstract can't have obj
    Thread thread; //declared
    Splashscreen(){
        setSize(1200,600); //creates a frame
        setLocation(300,150);
        
       ImageIcon im = new ImageIcon(getClass().getResource("/images/splash.jpg")); //getimage
       Image i=im.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT); //dimensions
       ImageIcon i3=new ImageIcon(i);
               
       JLabel j1= new JLabel(i3);//put image on frame need label for that ..label only accepts imageicon not image
       add(j1); //add to frame
       setVisible(true);
       thread=new Thread(this);
       thread.start();  //calls run() using run() won't run it as multithreaded
        
    }
    public void run(){ //overriding
        try{
            Thread.sleep(7000);
            setVisible(false);
            new Login();
        }catch(Exception e){}
        
    }
    
    public static void main(String args[]){
        Splashscreen obj=new Splashscreen(); //calls constructor
        
        
    }
    
}
