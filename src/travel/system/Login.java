
package travel.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton fb,sb,lb;
    JTextField jun,jpa;
    Login(){
        setSize(900,440);
        setLocation(350,200);
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        //to divide frame into 2 parts need Panel and layout
        //left side
        JPanel jp=new JPanel();
        jp.setBackground(new Color(191,148,219));
        jp.setBounds(0,0,450,400);
        jp.setLayout(null); //for setbounds to work
        add(jp);
        
        ImageIcon ii=new ImageIcon(getClass().getResource("/images/login.jpg"));
        Image i= ii.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i); 
        JLabel jb=new JLabel(i3);//put image on frame
        jb.setBounds(100,120, 200,200);
        jp.add(jb);//add image on top of panel not frame
        
        //on the right side
        JPanel j2=new JPanel();
        j2.setLayout(null);
        j2.setBounds(450,10,430,380);
        add(j2);
        
        //for texts you need jlabel
        JLabel juser=new JLabel("Username");
        juser.setBounds(55,20,100,25);
        juser.setFont(new Font("SAN SERIF", Font.PLAIN,19));
        j2.add(juser);
        //TEXTFIELD
        jun=new JTextField();
        jun.setBounds(55,50,300,30);
        jun.setBorder(BorderFactory.createEmptyBorder());
        j2.add(jun);
        //Password field
        JLabel jpass=new JLabel("Password");
        jpass.setBounds(55,100,100,25);
        jpass.setFont(new Font("SAN SERIF", Font.PLAIN,19));
        j2.add(jpass);
        //TEXTFIELD
        jpa=new JTextField();
        jpa.setBounds(55,130,300,30);
        jpa.setBorder(BorderFactory.createEmptyBorder());
        j2.add(jpa);
        
        //Buttons
        lb=new JButton("Login");
        lb.setBounds(100,180,100,30);
        lb.setBackground(new Color(191,148,219));
        lb.setForeground(Color.WHITE);
        lb.setBorder(new LineBorder(new Color(191,148,219)));
        lb.addActionListener(this);
        j2.add(lb);
        
        sb=new JButton("SignUp");
        sb.setBounds(215,180,100,30);
        sb.setBackground(Color.WHITE);
        sb.setForeground(new Color(191,148,219));
        sb.setBorder(new LineBorder(new Color(191,148,219)));
        sb.addActionListener(this);
        j2.add(sb);
        
        fb=new JButton("Forget Password");
        fb.setBounds(150,230,100,30);
        fb.setForeground(new Color(191,148,219));
        fb.setBorder(BorderFactory.createEmptyBorder());
        fb.addActionListener(this);
        j2.add(fb);
        
        JLabel jt=new JLabel("Trouble Logging in..");
        jt.setBounds(150,280,100,30);
        jt.setForeground(Color.RED);
        //jt.setVisible(false);
        j2.add(jt);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fb){
            setVisible(false);
            new forgetpwd();
        }
        else if(ae.getSource()==sb){
            setVisible(false);
            new Signup();
        }
        else if(ae.getSource()==lb){
            try{
                String user=jun.getText();
                String pass=jpa.getText();
                Connectivity con=new Connectivity();
                String query="Select * from account where username = '"+user+"' AND password= '"+pass+"'";
                ResultSet rs=con.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(user);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
    
    
    public static void main(String[] args){
        Login l=new Login();
    }
    
}
