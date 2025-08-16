package travel.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.LineBorder;

public class BookHotel extends JFrame implements ActionListener{
    JLabel userfield,phfield,emfield,idfield,ppfield;
    String username;
    JTextField t, d;
    JButton back,check,submit;
    JComboBox jc,Ac;
    
    BookHotel(String username){
        this.username=username;
        setBounds(350,200,1100,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Book Hotel");
        text.setBounds(300,5,200,30);
        text.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(text);
        
        JLabel usename=new JLabel("Username");
        usename.setBounds(30,50,150,25);
        add(usename);

        userfield=new JLabel();
        userfield.setBounds(200,50,150,25);
        add(userfield);
        
        JLabel pckg=new JLabel("Select Hotel");
        pckg.setBounds(30,90,150,25);
        add(pckg);
        
        jc=new JComboBox(new String[]{"JWMarriot","Raddison Blue","Chilly","Classio","The SeaView"}); 
        jc.setBounds(200,90,150,25);
        jc.setBackground(Color.WHITE);
        add(jc);
        
        JLabel no=new JLabel("Total Rooms");
        no.setBounds(30,130,150,25);
        add(no);
        
        t=new JTextField("1");
        t.setBounds(200,130,150,25);
        add(t);
        
        JLabel nod=new JLabel("No. of Days");
        nod.setBounds(30,170,150,25);
        add(nod);
        
        d=new JTextField("1");
        d.setBounds(200,170,150,25);
        add(d);
        
        JLabel ac=new JLabel("AC/Non-AC");
        ac.setBounds(30,210,150,25);
        add(ac);
        
        Ac=new JComboBox(new String[]{"Yes","No"}); 
        Ac.setBounds(200,210,150,25);
        Ac.setBackground(Color.WHITE);
        add(Ac);
        
        JLabel uid=new JLabel("ID");
        uid.setBounds(30,250,150,25);
        add(uid);

        idfield=new JLabel();
        idfield.setBounds(200,250,150,25);
        add(idfield);
        
        JLabel uph=new JLabel("Phone No");
        uph.setBounds(30,290,150,25);
        add(uph);

        phfield=new JLabel();
        phfield.setBounds(200,290,150,25);
        add(phfield);
        
        JLabel uem=new JLabel("Email");
        uem.setBounds(30,330,150,25);
        add(uem);

        emfield=new JLabel();
        emfield.setBounds(200,330,150,25);
        add(emfield);
        
        JLabel uprice=new JLabel("Total Price");
        uprice.setBounds(30,370,150,25);
        add(uprice);

        ppfield=new JLabel();
        ppfield.setBounds(200,370,150,25);
        add(ppfield);
        
        back=new JButton("Back");
        back.setBounds(330,410,100,30);
        back.setBackground(new Color(191,148,219));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(191,148,219)));
        back.addActionListener(this);
        add(back);
        
        check=new JButton("Check Price");
        check.setBounds(70,410,100,30);
        check.setBackground(new Color(191,148,219));
        check.setForeground(Color.WHITE);
        check.setBorder(new LineBorder(new Color(191,148,219)));
        check.addActionListener(this);
        add(check);
        
        submit=new JButton("Book Hotel");
        submit.setBounds(200,410,100,30);
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
                c.s.executeUpdate("insert into hotel values('"+userfield.getText()+"','"+jc.getSelectedItem()+"','"+t.getText()+"','"+d.getText()+"','"+Ac.getSelectedItem()+"','"+idfield.getText()+"','"+emfield.getText()+"','"+phfield.getText()+"','"+ppfield.getText()+"')");
                JOptionPane.showMessageDialog(null,"Hotel Booked successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        
        }
        else if(ae.getSource()==check){
            try{
                int costperperson=0;
                int accost=0;
                String htl=(String)jc.getSelectedItem();
                Connectivity cc=new Connectivity();
                ResultSet rs=cc.s.executeQuery("select * from hotelinfo where hotelname='"+htl+"'");
                while(rs.next()){
                    costperperson =Integer.parseInt(rs.getString("costpp"));
                    accost=Integer.parseInt(rs.getString("acroom"));
                }
                int persons=Integer.parseInt(t.getText());
                int days=Integer.parseInt(d.getText());
                String acselected=(String)Ac.getSelectedItem();
                int cost=0;
                
                if((persons*days)>0){
                    if(acselected.equals("Yes")){
                        cost=cost+costperperson+accost;
                    }
                    else{
                        cost=cost+costperperson;
                        
                    }
                }

                cost=cost*persons*days;
                ppfield.setText("Rs" + cost);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
    
    public static void main(String[] args){
        new BookHotel("");
    }
    
}
