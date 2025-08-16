package travel.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener{
    JButton b1,b2;
    
    Payment(){
        setBounds(500,200,800,600);
        setLayout(null);
        
        ImageIcon ii=new ImageIcon(getClass().getResource("/images/pay.jpg"));
        Image i= ii.getImage().getScaledInstance(800, 600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i); 
        JLabel jb=new JLabel(i3);
        jb.setBounds(0,0, 800,600);
        add(jb);
        
        b1=new JButton("Pay");
        b1.setBounds(100,50,80,40);
        b1.setBackground(new Color(191,148,219));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1.addActionListener(this);
        jb.add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(200,50,80,40);
        b2.setBackground(new Color(191,148,219));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Tahoma",Font.PLAIN,20));
        b2.addActionListener(this);
        jb.add(b2);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            setVisible(false);
            new Paytm();
        }
        else{
            setVisible(false); 
        }
    }
    public static void main(String[] args){
        new Payment();
    }
    
}
