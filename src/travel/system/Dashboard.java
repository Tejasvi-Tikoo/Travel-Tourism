package travel.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
    Dashboard(String user){
        this.username=user;
        //setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(191,148,219));
        p1.setBounds(0,0,Toolkit.getDefaultToolkit().getScreenSize().width,75);
        add(p1);
        
        ImageIcon ii=new ImageIcon(getClass().getResource("/images/logo.jpg"));
        Image i= ii.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i); 
        JLabel jb=new JLabel(i3);//put image on frame
        jb.setBounds(0,0, 70,70);
        p1.add(jb);//add image on top of panel not frame
        
        JLabel heading=new JLabel("Dashboard");
        heading.setBounds(85,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        p1.add(heading);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(191,148,219));
        p2.setBounds(0,75,400,Toolkit.getDefaultToolkit().getScreenSize().height-65);
        add(p2);
        
        b1=new JButton("Add Personal Details");
        b1.setBounds(0,0,400,50);
        b1.setBackground(new Color(191,148,219));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1.setMargin(new Insets(0,0,0,60));
        b1.addActionListener(this);
        p2.add(b1);
        
        b2=new JButton("Update Personal Details");
        b2.setBounds(0,60,400,50);
        b2.setBackground(new Color(191,148,219));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Tahoma",Font.PLAIN,20));
        b2.setMargin(new Insets(0,0,0,30));
        b2.addActionListener(this);
        p2.add(b2);
        
        b3=new JButton("View Details");
        b3.setBounds(0,120,400,50);
        b3.setBackground(new Color(191,148,219));
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Tahoma",Font.PLAIN,20));
        b3.setMargin(new Insets(0,0,0,130));
        b3.addActionListener(this);
        p2.add(b3);
        
        b4=new JButton("Delete Details");
        b4.setBounds(0,180,400,50);
        b4.setBackground(new Color(191,148,219));
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("Tahoma",Font.PLAIN,20));
        b4.setMargin(new Insets(0,0,0,110));
        b4.addActionListener(this);
        p2.add(b4);
        
        b5=new JButton("Check Packages");
        b5.setBounds(0,240,400,50);
        b5.setBackground(new Color(191,148,219));
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("Tahoma",Font.PLAIN,20));
        b5.setMargin(new Insets(0,0,0,120));
        b5.addActionListener(this);
        p2.add(b5);
        
        b6=new JButton("Book Package");
        b6.setBounds(0,300,400,50);
        b6.setBackground(new Color(191,148,219));
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("Tahoma",Font.PLAIN,20));
        b6.setMargin(new Insets(0,0,0,120));
        b6.addActionListener(this);
        p2.add(b6);
        
        b7=new JButton("View Package");
        b7.setBounds(0,360,400,50);
        b7.setBackground(new Color(191,148,219));
        b7.setForeground(Color.WHITE);
        b7.setFont(new Font("Tahoma",Font.PLAIN,20));
        b7.setMargin(new Insets(0,0,0,120));
        b7.addActionListener(this);
        p2.add(b7);
        
        b8=new JButton("View Hotels");
        b8.setBounds(0,420,400,50);
        b8.setBackground(new Color(191,148,219));
        b8.setForeground(Color.WHITE);
        b8.setFont(new Font("Tahoma",Font.PLAIN,20));
        b8.setMargin(new Insets(0,0,0,130));
        b8.addActionListener(this);
        p2.add(b8);
        
        b9=new JButton("Book Hotels");
        b9.setBounds(0,480,400,50);
        b9.setBackground(new Color(191,148,219));
        b9.setForeground(Color.WHITE);
        b9.setFont(new Font("Tahoma",Font.PLAIN,20));
        b9.setMargin(new Insets(0,0,0,130));
        b9.addActionListener(this);
        p2.add(b9);
        
        b10=new JButton("View Booked Hotel");
        b10.setBounds(0,540,400,50);
        b10.setBackground(new Color(191,148,219));
        b10.setForeground(Color.WHITE);
        b10.setFont(new Font("Tahoma",Font.PLAIN,20));
        b10.setMargin(new Insets(0,0,0,60));
        b10.addActionListener(this);
        p2.add(b10);
        
        b11=new JButton("Destinations");
        b11.setBounds(0,600,400,50);
        b11.setBackground(new Color(191,148,219));
        b11.setForeground(Color.WHITE);
        b11.setFont(new Font("Tahoma",Font.PLAIN,20));
        b11.setMargin(new Insets(0,0,0,120));
        b11.addActionListener(this);
        p2.add(b11);
        
        b12=new JButton("Payments");
        b12.setBounds(0,660,400,50);
        b12.setBackground(new Color(191,148,219));
        b12.setForeground(Color.WHITE);
        b12.setFont(new Font("Tahoma",Font.PLAIN,20));
        b12.setMargin(new Insets(0,0,0,140));
        b12.addActionListener(this);
        p2.add(b12);
        
        b13=new JButton("Calculator");
        b13.setBounds(0,720,400,50);
        b13.setBackground(new Color(191,148,219));
        b13.setForeground(Color.WHITE);
        b13.setFont(new Font("Tahoma",Font.PLAIN,20));
        b13.setMargin(new Insets(0,0,0,130));
        b13.addActionListener(this);
        p2.add(b13);
        
        b14=new JButton("Notepad");
        b14.setBounds(0,780,400,50);
        b14.setBackground(new Color(191,148,219));
        b14.setForeground(Color.WHITE);
        b14.setFont(new Font("Tahoma",Font.PLAIN,20));
        b14.setMargin(new Insets(0,0,0,130));
        b14.addActionListener(this);
        p2.add(b14);
        
        b15=new JButton("About");
        b15.setBounds(0,840,400,50);
        b15.setBackground(new Color(191,148,219));
        b15.setForeground(Color.WHITE);
        b15.setFont(new Font("Tahoma",Font.PLAIN,20));
        b15.setMargin(new Insets(0,0,0,180));
        b15.addActionListener(this);
        p2.add(b15);
        
        ImageIcon I=new ImageIcon(getClass().getResource("/images/dash.jpg"));
        Image i2= I.getImage().getScaledInstance(Toolkit.getDefaultToolkit().getScreenSize().width-400,Toolkit.getDefaultToolkit().getScreenSize().height-65,Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(i2); 
        JLabel ji=new JLabel(I3);//put image on frame
        ji.setBounds(400,65,Toolkit.getDefaultToolkit().getScreenSize().width-400 ,Toolkit.getDefaultToolkit().getScreenSize().height-65);
        add(ji);//add image on top of panel not frame
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new AddCustomer(username);
        }
        else if(ae.getSource()==b2){
            new UpdateDetails(username);
        }
        else if(ae.getSource()==b3){
            new ViewDetails(username);
        }
        else if(ae.getSource()==b5){
            new Checkpg();
        }
        else if(ae.getSource()==b6){
            new Bookpg(username);
        }
        else if(ae.getSource()==b7){
            new Viewpkg(username);
        }
        else if(ae.getSource()==b8){
            new Hotels();
        }
        else if(ae.getSource()==b11){
            new Dest();
        }
        else if(ae.getSource()==b9){
            new BookHotel(username);
        }
        else if(ae.getSource()==b10){
            new ViewHotel(username);
        }
        else if(ae.getSource()==b12){
            new Payment();
        }
        else if(ae.getSource()==b13){
            try{
               Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==b14){
            try{
               Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==b4){
            new Deletedetails(username);
        }
    }
    public static void main(String[] args){
        new Dashboard("");
    }
    
}
