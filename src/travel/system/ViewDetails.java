 package travel.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class ViewDetails extends JFrame implements ActionListener{
    JLabel userfield,idfield,nofield,namefield,genfield,counfield,addfield,phfield,emfield;
    String username;
    JButton back;
    ViewDetails(String username){
        this.username=username;
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel usename=new JLabel("Username");
        usename.setBounds(30,50,150,25);
        add(usename);

        userfield=new JLabel();
        userfield.setBounds(220,50,150,25);
        add(userfield);
        
        JLabel uid=new JLabel("ID");
        uid.setBounds(30,110,150,25);
        add(uid);

        idfield=new JLabel();
        idfield.setBounds(220,110,150,25);
        add(idfield);
        
        JLabel uno=new JLabel("Number");
        uno.setBounds(30,170,150,25);
        add(uno);

        nofield=new JLabel();
        nofield.setBounds(220,170,150,25);
        add(nofield);
        
        JLabel uname=new JLabel("Name");
        uname.setBounds(30,230,150,25);
        add(uname);

        namefield=new JLabel();
        namefield.setBounds(220,230,150,25);
        add(namefield);
        
        JLabel ugen=new JLabel("Gender");
        ugen.setBounds(30,290,150,25);
        add(ugen);

        genfield=new JLabel();
        genfield.setBounds(220,290,150,25);
        add(genfield);
        
        JLabel ucountry=new JLabel("Country");
        ucountry.setBounds(500,50,150,25);
        add(ucountry);

        counfield=new JLabel();
        counfield.setBounds(690,50,150,25);
        add(counfield);
        
        JLabel uadd=new JLabel("Address");
        uadd.setBounds(500,110,150,25);
        add(uadd);

        addfield=new JLabel();
        addfield.setBounds(690,110,150,25);
        add(addfield);
        
        JLabel uph=new JLabel("Phone No");
        uph.setBounds(500,170,150,25);
        add(uph);

        phfield=new JLabel();
        phfield.setBounds(690,170,150,25);
        add(phfield);
        
        JLabel uem=new JLabel("Email");
        uem.setBounds(500,230,150,25);
        add(uem);

        emfield=new JLabel();
        emfield.setBounds(690,230,150,25);
        add(emfield);
        
        back=new JButton("Back");
        back.setBounds(350,350,100,30);
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
            ResultSet rs=c.s.executeQuery("Select * from customer where username='"+username+"'");
            while(rs.next()){
                userfield.setText(rs.getString("username"));
                idfield.setText(rs.getString("id"));
                nofield.setText(rs.getString("number"));
                namefield.setText(rs.getString("name"));
                genfield.setText(rs.getString("gender"));
                counfield.setText(rs.getString("country"));
                addfield.setText(rs.getString("address"));
                phfield.setText(rs.getString("phone"));
                emfield.setText(rs.getString("email"));
                
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
    
    public static void main(String args[]){
        new ViewDetails("");
    
    }
    
}
