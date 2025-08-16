package travel.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.LineBorder;

public class Viewpkg extends JFrame implements ActionListener{
    
    JLabel userfield,idfield,phfield,emfield,pkgfield,t,ppfield;
    String username;
    JButton back;
    Viewpkg(String username){
        this.username=username;
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("View Package");
        text.setBounds(300,5,200,35);
        text.setFont(new Font("Tahoma", Font.PLAIN,30));
        add(text);
        
        JLabel usename=new JLabel("Username");
        usename.setBounds(50,80,150,25);
        add(usename);

        userfield=new JLabel();
        userfield.setBounds(200,80,150,25);
        add(userfield);
        
        JLabel uid=new JLabel("ID");
        uid.setBounds(50,120,150,25);
        add(uid);

        idfield=new JLabel();
        idfield.setBounds(200,120,150,25);
        add(idfield);
        
        JLabel pckg=new JLabel("Package Name");
        pckg.setBounds(50,160,150,25);
        add(pckg);
        
        pkgfield=new JLabel();
        pkgfield.setBounds(200,160,150,25);
        add(pkgfield);
        
        JLabel no=new JLabel("Total heads");
        no.setBounds(50,200,150,25);
        add(no);
        
        t=new JLabel();
        t.setBounds(200,200,150,25);
        add(t);
        
        JLabel uph=new JLabel("Phone No");
        uph.setBounds(50,240,150,25);
        add(uph);

        phfield=new JLabel();
        phfield.setBounds(200,240,150,25);
        add(phfield);
        
        JLabel uem=new JLabel("Email");
        uem.setBounds(50,280,150,25);
        add(uem);

        emfield=new JLabel();
        emfield.setBounds(200,280,150,25);
        add(emfield);
        
        JLabel uprice=new JLabel("Total Price");
        uprice.setBounds(50,320,150,25);
        add(uprice);
        
        ppfield=new JLabel();
        ppfield.setBounds(200,320,150,25);
        add(ppfield);
        
        
        back=new JButton("Back");
        back.setBounds(350,400,100,30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(191,148,219)));
        back.addActionListener(this);
        add(back);
        
        ImageIcon ii=new ImageIcon(getClass().getResource("/images/view.jpg"));
        Image i= ii.getImage().getScaledInstance(600, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i); 
        JLabel jb=new JLabel(i3);//put image on frame
        jb.setBounds(0,400, 600,200);
        add(jb);
        
        ImageIcon i4=new ImageIcon(getClass().getResource("/images/view.jpg"));
        Image i5= i4.getImage().getScaledInstance(600, 200,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5); 
        JLabel jb2=new JLabel(i6);//put image on frame
        jb2.setBounds(600,400, 600,200);
        add(jb2);
        
        
        try{
            Connectivity c=new Connectivity();
            ResultSet rs=c.s.executeQuery("Select * from package where username='"+username+"'");
            while(rs.next()){
                userfield.setText(rs.getString("username"));
                idfield.setText(rs.getString("id"));
                phfield.setText(rs.getString("phone"));
                emfield.setText(rs.getString("email"));
                pkgfield.setText(rs.getString("packagetype"));
                t.setText(rs.getString("totalheads"));
                ppfield.setText(rs.getString("price"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Viewpkg("");
    }
    
}
