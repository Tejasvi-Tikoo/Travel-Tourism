
package travel.system;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener{
    
    JButton cb,b;
    JTextField jun,jna,jpa,ans;
    Choice c;
    Signup(){
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
        juser.setBounds(50,20,120,25);
        juser.setFont(new Font("SAN SERIF", Font.PLAIN,19));
        j2.add(juser);
        //TEXTFIELD
        jun=new JTextField();
        jun.setBounds(190,20,180,25);
        jun.setBorder(BorderFactory.createEmptyBorder());
        j2.add(jun);
        JLabel jname=new JLabel("Name");
        jname.setBounds(50,60,125,25);
        jname.setFont(new Font("SAN SERIF", Font.PLAIN,19));
        j2.add(jname);
        //TEXTFIELD
        jna=new JTextField();
        jna.setBounds(190,60,180,25);
        jna.setBorder(BorderFactory.createEmptyBorder());
        j2.add(jna);
        //Password field
        JLabel jpass=new JLabel("Set Password");
        jpass.setBounds(50,100,125,25);
        jpass.setFont(new Font("SAN SERIF", Font.PLAIN,19));
        j2.add(jpass);
        //TEXTFIELD
        jpa=new JTextField();
        jpa.setBounds(190,100,180,25);
        jpa.setBorder(BorderFactory.createEmptyBorder());
        j2.add(jpa);
        //security Q
        JLabel jsec=new JLabel("Security Question");
        jsec.setBounds(50,140,125,25);
        jsec.setFont(new Font("SAN SERIF", Font.PLAIN,19));
        j2.add(jsec);
        //dropdown
        c= new Choice();
        c.add("Your fav day");
        c.add("Your fav color");
        c.setBounds(190,140, 180, 25);
        j2.add(c);
        //answer
        JLabel jans=new JLabel("Answer");
        jans.setBounds(50,180,125,25);
        jans.setFont(new Font("SAN SERIF", Font.PLAIN,19));
        j2.add(jans);
        //TEXTFIELD
        ans=new JTextField();
        ans.setBounds(190,180,180,25);
        ans.setBorder(BorderFactory.createEmptyBorder());
        j2.add(ans);
        
        //Buttons
        cb=new JButton("Create");
        cb.setBounds(80,250,100,30);
        cb.setBackground(new Color(191,148,219));
        cb.setForeground(Color.WHITE);
        cb.setBorder(new LineBorder(new Color(191,148,219)));
        cb.addActionListener(this);
        j2.add(cb);
        
        b=new JButton("Back");
        b.setBounds(250,250,100,30);
        b.setBackground(new Color(191,148,219));
        b.setForeground(Color.WHITE);
        b.setBorder(new LineBorder(new Color(191,148,219)));
        b.addActionListener(this);
        j2.add(b);
        
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cb){
            String user=jun.getText();
            String name=jna.getText();
            String pwd=jpa.getText();
            String answer=ans.getText();
            String Question = c.getSelectedItem();
            
            String query= "Insert into account values('"+user+"' , '"+name+"' , '"+pwd+"' , '"+Question+"' ,'"+answer+"')";
            try{
                Connectivity c=new Connectivity();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Account created Successfully");
                setVisible(false);
                new Login();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()==b){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args){
        new Signup();
    }
    
}
