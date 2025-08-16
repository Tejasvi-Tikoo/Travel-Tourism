package travel.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.sql.*;

public class UpdateDetails extends JFrame implements ActionListener {
    JLabel userfield,namefield;
    JComboBox jc;
    JTextField t,cu,ad,em,ph,genfield;
    JRadioButton rmale,rfemale;
    JButton submit,back;
    
    UpdateDetails(String username){
        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Update Customer Details");
        text.setBounds(300,5,600,35);
        text.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(text);
        
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
        
        JLabel gender=new JLabel("Gender:Male/Female");
        gender.setBounds(30,210,150,25);
        add(gender);
        
        genfield=new JTextField();
        genfield.setBounds(220,210,150,25);
        add(genfield);
        
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
        
        submit=new JButton("Change");
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
        
        ImageIcon ii=new ImageIcon(getClass().getResource("/images/images.png"));
        Image i= ii.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i); 
        JLabel jb=new JLabel(i3);//put image on frame
        jb.setBounds(400,40, 450,420);
        add(jb);
        
        try{
            Connectivity c=new Connectivity();
            ResultSet rs=c.s.executeQuery("Select * from customer where username='"+username+"'");
            while(rs.next()){
                userfield.setText(rs.getString("username"));
                namefield.setText(rs.getString("name"));
                jc.setSelectedItem(rs.getString("id"));
                t.setText(rs.getString("number"));
                genfield.setText(rs.getString("gender"));
                cu.setText(rs.getString("country"));
                ad.setText(rs.getString("address"));
                ph.setText(rs.getString("phone"));
                em.setText(rs.getString("email"));
                
                
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
            String Gen=genfield.getText();
            String Cou=cu.getText();
            String AD=ad.getText();
            String PH=ph.getText();
            String EM=em.getText();
            try{
                Connectivity co=new Connectivity();
                String query="Update customer set username='"+username+"',id='"+ID+"',number='"+NO+"',name='"+NAME+"',gender='"+Gen+"',country='"+Cou+"',address='"+AD+"',phone='"+PH+"',email='"+EM+"'";
                co.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details updated successfully");
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
        new UpdateDetails("");
    }
    
}
