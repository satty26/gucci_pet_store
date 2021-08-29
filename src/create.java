import java.io.*;
import java.sql.*;
class create
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
        String ql="CREATE TABLE Pets " + "(pet_id INTEGER NOT NULL, pet_type VARCHAR(255), pet_breed VARCHAR(255), pet_age INTEGER, pet_quantity INTEGER,pet_price INTEGER, PRIMARY KEY(pet_id))";
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