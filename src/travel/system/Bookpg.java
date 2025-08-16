package travel.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.LineBorder;

public class Bookpg extends JFrame implements ActionListener{
    JLabel userfield,phfield,emfield,idfield,ppfield;
    String username;
    JTextField t;
    JButton back,check,submit;
    JComboBox jc;
    Bookpg(String username){
        this.username=username;
        setBounds(350,200,1100,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Book Package");
        text.setBounds(300,5,200,30);
        text.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(text);
        
        JLabel usename=new JLabel("Username");
        usename.setBounds(30,50,150,25);
        add(usename);

        userfield=new JLabel();
        userfield.setBounds(200,50,150,25);
        add(userfield);
        
        JLabel pckg=new JLabel("Package Name");
        pckg.setBounds(30,90,150,25);
        add(pckg);
        
        jc=new JComboBox(new String[]{"Gold Package", "Silver Package"}); 
        jc.setBounds(200,90,150,25);
        jc.setBackground(Color.WHITE);
        add(jc);
        
        JLabel no=new JLabel("Total heads");
        no.setBounds(30,130,150,25);
        add(no);
        
        t=new JTextField("1");
        t.setBounds(200,130,150,25);
        add(t);
        
        JLabel uid=new JLabel("ID");
        uid.setBounds(30,170,150,25);
        add(uid);

        idfield=new JLabel();
        idfield.setBounds(200,170,150,25);
        add(idfield);
        
        JLabel uph=new JLabel("Phone No");
        uph.setBounds(30,210,150,25);
        add(uph);

        phfield=new JLabel();
        phfield.setBounds(200,210,150,25);
        add(phfield);
        
        JLabel uem=new JLabel("Email");
        uem.setBounds(30,250,150,25);
        add(uem);

        emfield=new JLabel();
        emfield.setBounds(200,250,150,25);
        add(emfield);
        
        JLabel uprice=new JLabel("Total Price");
        uprice.setBounds(30,290,150,25);
        add(uprice);

        ppfield=new JLabel();
        ppfield.setBounds(200,290,150,25);
        add(ppfield);
        
        back=new JButton("Back");
        back.setBounds(330,380,100,30);
        back.setBackground(new Color(191,148,219));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(191,148,219)));
        back.addActionListener(this);
        add(back);
        
        check=new JButton("Check Price");
        check.setBounds(70,380,100,30);
        check.setBackground(new Color(191,148,219));
        check.setForeground(Color.WHITE);
        check.setBorder(new LineBorder(new Color(191,148,219)));
        check.addActionListener(this);
        add(check);
        
        submit=new JButton("Book Package");
        submit.setBounds(200,380,100,30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(new Color(191,148,219));
        submit.setBorder(new LineBorder(new Color(191,148,219)));
        submit.addActionListener(this);
        add(submit);
        
        try{
            Connectivity c=new Connectivity();
            ResultSet rs=c.s.executeQuery("Select * from customer where username='"+username+"'");
            while(rs.next()){
                userfield.setText(rs.getString("username"));
                idfield.setText(rs.getString("number"));
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
        else if(ae.getSource()==submit){
            try{
                Connectivity c=new Connectivity();
                c.s.executeUpdate("insert into package values('"+userfield.getText()+"','"+jc.getSelectedItem()+"','"+t.getText()+"','"+idfield.getText()+"','"+emfield.getText()+"','"+phfield.getText()+"','"+ppfield.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        
        }
        else if(ae.getSource()==check){
            String pck=(String)jc.getSelectedItem();
            int cost=0;
            if(pck.equals("Gold Package")){
                cost+=10000;    
            }
            else{
                cost+=8000;
            }
            int persons=Integer.parseInt(t.getText());
            cost*=persons;
            ppfield.setText("Rs" + cost);
            
        }
    }
    
    public static void main(String[] args){
        new Bookpg("");
    }
    
}
