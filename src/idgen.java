import java.io.*;
import java.sql.*;
public class idgen {
    public int generateid(){
        int id = 0;
        try
        {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          //registering type4 driver of oracle
          Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
          Statement stmt1=con.createStatement();
          String ql="SELECT MAX(order_id) as order_id FROM Orders";
          ResultSet rs=stmt1.executeQuery(ql);
          while(rs.next()){
         //Retrieve by column name
            id   = Integer.parseInt(rs.getString("order_id")) + 1;
          }
        }
        catch(Exception e2)
        { 
//          System.out.println(e2);
        }
        return id;
    }
}
