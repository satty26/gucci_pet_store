import java.io.*;
import java.sql.*;
class drop
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
        String ql="DROP TABLE Users ";
        int x = stmt.executeUpdate(ql);
        if(x>0)
        {
           System.out.println("Delete unsuccessful");
        }
       else
       {
         System.out.println("Delete successful");       
 
       
     con.close();
     }
      }
     catch(Exception e)
     { 
        System.out.println(e);
     }
}
}