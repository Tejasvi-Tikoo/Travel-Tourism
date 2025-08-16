package travel.system;
import java.sql.*;

public class Connectivity {       //only made for using in other classes
    Connection c;    //step2: obj of sql connection
    Statement s;  //step3 statements
    Connectivity(){
        
        //BASICS OF jdbc connectivity
        //steps: 1)Register driver(mysql driver) and initialise it
        
        try{  //because sql is external
            Class.forName("com.mysql.cj.jdbc.Driver");     //mysql needs its jar file too for the driver this line is basically address of jarfile in mysql
            c=DriverManager.getConnection("jdbc:mysql:///traveldb","root","mysqlpwd");
            s=c.createStatement();
            //step4 executing mysql queries in java using jdbc
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
