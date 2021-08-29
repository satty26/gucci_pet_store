import java.io.*;
import java.sql.*;
import java.util.Scanner;
public class book {
   public int booking(String username, String pet_type, String pet_breed, int n, int price, int pet_id)
           throws IOException
   {
        DataInputStream ds=new DataInputStream(System.in);
        Scanner myObj = new Scanner(System.in);
        idgen getid = new idgen();
        System.out.println("Enter your delivery address: ");
        String delivery_add = ds.readLine();
        String status = "Received";
        int id = getid.generateid(); 
        try
        {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          //registering type4 driver of oracle
          Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
          Statement stmt1=con.createStatement();
          String q1="INSERT INTO Orders values('"+id+"','"+pet_id+"','"+username+"','"+n+"','"+n*price+"','" + delivery_add +"','" + status + "' )";
          int x=stmt1.executeUpdate(q1);
          if(x>0)
          {
             System.out.println();
             System.out.println("Thank You for trusting us!!!!");
             System.out.println();
             System.out.println("Your booking is received! ");
             System.out.println("--------------------------------------------------");
             System.out.println("Your order ID is: " + id);
             System.out.println("--------------------------------------------------");
             System.out.println("Our team is verifying your documents. We will change the status of your order within 1-3 days. ");
             System.out.println();
             return 0;
         }
         else
         {
           System.out.println("Issue!");       

        con.close();
        }  
        }
        catch(Exception e2)
        { 
          System.out.println(e2);
        }
        return 2;
   }
   
}
