import java.io.*;
import java.sql.*;
class createorder
{
   public static void main(String args[])
           throws IOException
   {
      
      
      try
      {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //registering type4 driver of oracle
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
        Statement stmt=con.createStatement();
        String ql="CREATE TABLE Orders " + "(order_id INTEGER NOT NULL , pet_id INTEGER, username VARCHAR(255) ,quantity INTEGER,total_price INTEGER, delivery_add VARCHAR(255), status VARCHAR(255), PRIMARY KEY(order_id))";
        int x = stmt.executeUpdate(ql);
        if(x>0)
        {
           System.out.println("Create success");
       }
       else
       {
         System.out.println("Create success!");       
 
       
     con.close();
     }
      }
     catch(Exception e)
     { 
        System.out.println(e);
     }
}
}