package travel.system;

import java.awt.*;
import javax.swing.*;

public class Checkpg extends JFrame{
    
    Checkpg(){
        setBounds(450,200,900,600);
        
        String[] package1= {"GOLD PACKAGE","6Days|7Nights", "Local Travel included","All treaks","Boufet all 6 days" ,"All sports included", "Departure from Delhi","Rs 9999/"};
        String[] package2={"SILVER PACKAGE","4Days|5Nights", "Local Travel included","No treaks","Boufet only on 1st day","Sports not included" ,"Departure from Delhi","Rs 7999/-"};
        
        JTabbedPane tab=new JTabbedPane();
        
        JPanel p1=createPackage(package1);
        tab.addTab("Package1",null,p1);
        
        JPanel p2=createPackage(package2);       
        tab.addTab("Package2",null,p2);
        
        add(tab);
        setVisible(true); 
    }
    public JPanel createPackage(String[] pack){
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        
        JLabel gold=new JLabel(pack[0]);
        gold.setBounds(100,5,350,40);
        gold.setForeground(Color.YELLOW);
        gold.setFont(new Font("Tahoma",Font.BOLD,40));
        p1.add(gold);
        
        JLabel l2=new JLabel(pack[1]);
        l2.setBounds(30,90,300,35);
        l2.setForeground(Color.blue);
        l2.setFont(new Font("Tahoma",Font.PLAIN,30));
        p1.add(l2);
        
        JLabel l3=new JLabel(pack[2]);
        l3.setBounds(30,140,300,30);
        l3.setForeground(Color.blue);
        l3.setFont(new Font("Tahoma",Font.PLAIN,25));
        p1.add(l3);
        
        JLabel l4=new JLabel(pack[3]);
        l4.setBounds(30,190,300,30);
        l4.setForeground(Color.blue);
        l4.setFont(new Font("Tahoma",Font.PLAIN,25));
        p1.add(l4);
        
        JLabel l5=new JLabel(pack[4]);
        l5.setBounds(30,240,300,30);
        l5.setForeground(Color.blue);
        l5.setFont(new Font("Tahoma",Font.PLAIN,25));
        p1.add(l5);
        
        JLabel l6=new JLabel(pack[5]);
        l6.setBounds(30,290,300,30);
        l6.setForeground(Color.blue);
        l6.setFont(new Font("Tahoma",Font.PLAIN,25));
        p1.add(l6);
        
        JLabel l7=new JLabel(pack[6]);
        l7.setBounds(30,340,300,30);
        l7.setForeground(Color.blue);
        l7.setFont(new Font("Tahoma",Font.PLAIN,25));
        p1.add(l7);
        
        JLabel l8=new JLabel(pack[7]);
        l8.setBounds(30,390,300,30);
        l8.setForeground(Color.red);
        l8.setFont(new Font("Tahoma",Font.PLAIN,25));
        p1.add(l8);
        
        return p1;
        
    }
    
    public static void main(String[] args){
        new Checkpg();
    }
    
}
