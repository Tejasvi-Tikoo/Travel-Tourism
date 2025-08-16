package travel.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class forgetpwd extends JFrame implements ActionListener{
    JTextField jun,jna,jpa,ans,jp;
    JButton b,retrieve,back;
     
    forgetpwd(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon ii=new ImageIcon(getClass().getResource("/images/pwd.jpg"));
        Image i= ii.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i);
        JLabel jb=new JLabel(i3);//put image on frame
        jb.setBounds(580,70, 200,200);
        add(jb);//add image
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);
        
        JLabel juser=new JLabel("Username");
        juser.setBounds(40,20,100,25);
        juser.setFont(new Font("SAN SERIF", Font.PLAIN,19));
        p1.add(juser);
        //TEXTFIELD
        jun=new JTextField();
        jun.setBounds(220,20,150,25);
        jun.setBorder(BorderFactory.createEmptyBorder());
        p1.add(jun);
        
        b=new JButton("Find");
        b.setBackground(new Color(191,148,219));
        b.setForeground(Color.WHITE);
        b.setBounds(380, 20, 100, 25);
        b.addActionListener(this);
        p1.add(b); 
        
        JLabel jname=new JLabel("Name");
        jname.setBounds(40,60,100,25);
        jname.setFont(new Font("SAN SERIF", Font.PLAIN,19));
        p1.add(jname);
        //TEXTFIELD
        jna=new JTextField();
        jna.setBounds(220,60,150,25);
        jna.setBorder(BorderFactory.createEmptyBorder());
        p1.add(jna);
        
        //Q field
        JLabel jpass=new JLabel("Security Q");
        jpass.setBounds(40,100,100,25);
        jpass.setFont(new Font("SAN SERIF", Font.PLAIN,19));
        p1.add(jpass);
        //TEXTFIELD
        jpa=new JTextField();
        jpa.setBounds(220,100,150,25);
        jpa.setBorder(BorderFactory.createEmptyBorder());
        p1.add(jpa);
        
        //answer
        JLabel jans=new JLabel("Answer");
        jans.setBounds(40,140,150,25);
        jans.setFont(new Font("SAN SERIF", Font.PLAIN,19));
        p1.add(jans);
        //TEXTFIELD
        ans=new JTextField();
        ans.setBounds(220,140,150,25);
        ans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(ans);
        
        retrieve=new JButton("Retrieve");
        retrieve.setBounds(380,140,100,25);
        retrieve.setBackground(new Color(191,148,219));
        retrieve.setForeground(Color.WHITE);
        retrieve.setBorder(new LineBorder(new Color(191,148,219)));
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        //Password field
        JLabel pass=new JLabel("Password");
        pass.setBounds(40,180,150,25);
        pass.setFont(new Font("SAN SERIF", Font.PLAIN,19));
        p1.add(pass);
        //TEXTFIELD
        jp=new JTextField();
        jp.setBounds(220,180,150,25);
        jp.setBorder(BorderFactory.createEmptyBorder());
        p1.add(jp);
        
        back=new JButton("Return");
        back.setBounds(150,230,100,25);
        back.setBackground(new Color(191,148,219));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(191,148,219)));
        back.addActionListener(this);
        p1.add(back);
        
        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Login();
        }
        else if(ae.getSource()==b){
            try{
                String query="select * from account where username='"+jun.getText()+"' ";
                Connectivity c=new Connectivity();
                ResultSet rs= c.s.executeQuery(query);
                while(rs.next()){
                    jna.setText(rs.getString("name"));
                    jpa.setText(rs.getString("securityQ"));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==retrieve){
            try{
                String query="select * from account where answer='"+ans.getText()+"' AND username= '"+jun.getText()+"' ";
                Connectivity c=new Connectivity();
                ResultSet rs= c.s.executeQuery(query);
                while(rs.next()){
                    jp.setText(rs.getString("password"));
                    
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
    }
    
    
    
    public static void main(String[] args){
        new forgetpwd();
    }
    
}
