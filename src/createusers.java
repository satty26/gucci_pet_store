import java.io.*;
import java.sql.*;
class createsuers
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
        String ql="CREATE TABLE Users " + "(first_name VARCHAR(255), last_name VARCHAR(255), contact_no VARCHAR(255), email VARCHAR(255), aadhar VARCHAR(255), username VARCHAR(255) NOT NULL, password VARCHAR(255), PRIMARY KEY(username))";
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