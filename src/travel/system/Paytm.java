package travel.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Paytm extends JFrame implements ActionListener{
    JButton b1;
    Paytm(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //Jtextarea/jeditorpane for text area
        JEditorPane pane=new JEditorPane();
        pane.setEditable(false);
        
        try{
            pane.setPage("https://paytm.com/rent-payment");
        }
        catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html>");
        }
        
        JScrollPane sp=new JScrollPane(pane);
        getContentPane().add(sp);
        
        b1=new JButton("Back");
        b1.setBounds(610,20,80,40);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1.addActionListener(this);
        pane.add(b1);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            setVisible(false);
            new Payment();
            
        }
    }
    public static void main(String[] args){
        new Paytm();
    }
    
}
