package travel.system;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Dest extends JFrame implements Runnable{
    
    Thread t1;
    JLabel jb1=null,jb2=null,jb3=null,jb4=null,jb5=null;
    JLabel[] jb=new JLabel[]{jb1,jb2,jb3,jb4,jb5};
    JLabel caption;
    
    public void run(){
        String[] text=new String[]{"Kahmir","Kerela","Manali","Lakshwadeep","Rajasthan"};
        
        try{
            for(int i=0;i<5;i++){
                jb[i].setVisible(true);
                caption.setText(text[i]);
                Thread.sleep(2500);
                jb[i].setVisible(false);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    Dest(){
        setBounds(500,200,800,600);
        
        caption =new JLabel();
        caption.setBounds(50,500,1000,70);
        caption.setFont(new Font("Tahoma",Font.PLAIN,40));
        caption.setForeground(Color.WHITE);
        add(caption);
        
        ImageIcon i1=null,i2=null,i3=null,i4=null,i5=null;
        ImageIcon[] im=new ImageIcon[]{i1,i2,i3,i4,i5};
        
        Image j1=null,j2=null,j3=null,j4=null,j5=null;
        Image[] jm=new Image[]{j1,j2,j3,j4,j5};
        
        ImageIcon k1=null,k2=null,k3=null,k4=null,k5=null;
        ImageIcon[] km=new ImageIcon[]{k1,k2,k3,k4,k5};
        
        
        for(int i=0;i<5;i++){
            im[i]=new ImageIcon(getClass().getResource("/images/dest"+(i+1)+".jpg"));
            jm[i]= im[i].getImage().getScaledInstance(800, 600,Image.SCALE_DEFAULT);
            km[i]=new ImageIcon(jm[i]); 
            jb[i]=new JLabel(km[i]);//put image on frame
            jb[i].setBounds(0,0, 800,600);
            add(jb[i]);
        }
        
        t1=new Thread(this);
        t1.start();
        
        setVisible(true);
    }
    public static void main(String[] args){
        new Dest();
    }    
}
