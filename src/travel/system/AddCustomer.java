package travel.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel userfield,namefield;
    JComboBox jc;
    JTextField t,cu,ad,em,ph;
    JRadioButton rmale,rfemale;
    JButton submit,back;
    
    AddCustomer(String username){
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel uname=new JLabel("Username");
        uname.setBounds(30,50,150,25);
        add(uname);
        
        userfield=new JLabel();
        userfield.setBounds(220,50,150,25);
        add(userfield);
        
        JLabel Lid=new JLabel("ID");
        Lid.setBounds(30,90,150,25);
        add(Lid);
        
        jc=new JComboBox(new String[]{"Passport No", "Aadhar No", "PanCard ID"}); 
        jc.setBounds(220,90,150,25);
        jc.setBackground(Color.WHITE);
        add(jc);
        
        JLabel no=new JLabel("ID Number");
        no.setBounds(30,130,150,25);
        add(no);
        
        t=new JTextField();
        t.setBounds(220,130,150,25);
        add(t);
        
        JLabel Name=new JLabel("Name");
        Name.setBounds(30,170,150,25);
        add(Name);
        
        namefield=new JLabel();
        namefield.setBounds(220,170,150,25);
        add(namefield);
        
        JLabel gender=new JLabel("Gender");
        gender.setBounds(30,210,150,25);
        add(gender);
        
        rmale=new JRadioButton("Male");
        rmale.setBounds(220,210,80,25);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale=new JRadioButton("Female");
        rfemale.setBounds(305,210,100,25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel cunt=new JLabel("Country");
        cunt.setBounds(30,250,150,25);
        add(cunt);
        
        cu=new JTextField();
        cu.setBounds(220,250,150,25);
        add(cu);
        
        JLabel add=new JLabel("Address");
        add.setBounds(30,290,150,25);
        add(add);
        
        ad=new JTextField();
        ad.setBounds(220,290,150,25);
        add(ad);
        
        JLabel phone=new JLabel("Phone No");
        phone.setBounds(30,330,150,25);
        add(phone);
        
        ph=new JTextField();
        ph.setBounds(220,330,150,25);
        add(ph);
        
        JLabel email=new JLabel("Email");
        email.setBounds(30,370,150,25);
        add(email);
        
        em=new JTextField();
        em.setBounds(220,370,150,25);
        add(em);
        
        submit=new JButton("Add Details");
        submit.setBounds(70,430,100,30);
        submit.setBackground(new Color(191,148,219));
        submit.setForeground(Color.WHITE);
        submit.setBorder(new LineBorder(new Color(191,148,219)));
        submit.addActionListener(this);
        add(submit);
        
        back=new JButton("Back");
        back.setBounds(220,430,100,30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(191,148,219)));
        back.addActionListener(this);
        add(back);
        
        ImageIcon ii=new ImageIcon(getClass().getResource("/images/add.jpg"));
        Image i= ii.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i); 
        JLabel jb=new JLabel(i3);//put image on frame
        jb.setBounds(400,40, 450,420);
        add(jb);
        
        try{
            Connectivity c=new Connectivity();
            ResultSet rs=c.s.executeQuery("Select * from account where username='"+username+"'");
            while(rs.next()){
                userfield.setText(rs.getString("username"));
                namefield.setText(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String username=userfield.getText();
            String ID=(String)jc.getSelectedItem();
            String NO=t.getText();
            String NAME=namefield.getText();
            String Gen=null;
            if(rmale.isSelected()){
                Gen="Male";
            }else{
                Gen="Female";
            }
            String Cou=cu.getText();
            String AD=ad.getText();
            String PH=ph.getText();
            String EM=em.getText();
            try{
                Connectivity co=new Connectivity();
                String query="Insert into customer values('"+username+"','"+ID+"','"+NO+"','"+NAME+"','"+Gen+"','"+Cou+"','"+AD+"','"+PH+"','"+EM+"')";
                co.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details added successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddCustomer("");
    }
    
}
