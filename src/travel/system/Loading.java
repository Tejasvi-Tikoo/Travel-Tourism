package travel.system;
import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
    
    public void run(){
        try{
            for(int i=1;i<=101;i++){
                int max=bar.getMaximum();  //100
                int value=bar.getValue();   //LIKE 44
                if(value<max){
                    bar.setValue(bar.getValue() + 1);
                }
                else{
                    setVisible(false);
                    new Dashboard(username);
                    //new class
                }
                Thread.sleep(50);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    Loading(String user){
        this.username=user;
        
        t=new Thread(this);
        
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Travel and Tourism");
        text.setBounds(100,20,600,40);
        text.setForeground(Color.DARK_GRAY);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);
        
        bar=new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading=new JLabel("loading..");
        loading.setBounds(200,140,600,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway",Font.BOLD,15));
        add(loading);
        
        JLabel wel=new JLabel("Welcome " + username);
        wel.setBounds(100,200,600,30);
        wel.setForeground(Color.green);
        wel.setFont(new Font("Raleway",Font.BOLD,35));
        add(wel);
        
        t.start();
        setVisible(true);
        
    }
    public static void main(String[] args){
        new Loading("");
    }
    
}
