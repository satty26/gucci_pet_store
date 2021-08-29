import java.io.*;
import java.sql.*;
public class display
{
   public void disp(String ql)
           throws IOException
   {
      try
      {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //registering type4 driver of oracle
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
        Statement stmt=con.createStatement();
//        System.out.println(ql);
        ResultSet rs=stmt.executeQuery(ql);
        for(int i=0;i<91;i++){
            System.out.print("-");
        }
        System.out.println("-");
        System.out.print("| ID          | Type            | Breed            | Age         | Quantity    | Price     |");
        System.out.println(" ");
        for(int i=0;i<91;i++){
            System.out.print("-");
        }
        System.out.println("-");
        int tab1 = 12;
        int tab2 = 16;
        int tab3 = 17;
        int tab4 = 12;
        int tab5 = 12;
        int tab6 = 10;
        
        while(rs.next()){
         //Retrieve by column name
         String id  = rs.getString("pet_id");
         String type = rs.getString("pet_type");
         String breed = rs.getString("pet_breed");
         String age = rs.getString("pet_age");
         String quant = rs.getString("pet_quantity");
         String prce = rs.getString("pet_price");
         if(Integer.parseInt(quant)==0){
             continue;
         }
         //Display values
         System.out.print("| "+id);
         int spaces = tab1 - id.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print("| " + type);
         spaces = tab2 - type.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print("| " + breed);
         spaces = tab3 - breed.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print("| " + age);
         spaces = tab4 - age.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print("| " + quant);
         spaces = tab5 - quant.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print("| " + prce);
         spaces = tab6 - prce.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
        System.out.println("|"); 
      }
        
         for(int i=0;i<91;i++){
            System.out.print("-");
        }
        System.out.println("-");
      rs.close();
      }
     catch(Exception e)
     { 
        System.out.println(e);
     }
}
   public void disp1()
           throws IOException
   {
      try
      {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //registering type4 driver of oracle
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
        Statement stmt=con.createStatement();
//        System.out.println(ql);
        String ql = "SELECT order_id, pet_id, username, quantity, total_price, delivery_add, status FROM Orders ";
        ResultSet rs=stmt.executeQuery(ql);
        System.out.println("");
        for(int i=0;i<=151;i++){
            System.out.print("-");
        }
        System.out.println("-");
        System.out.print("| ID          | Pet ID      | Username        | Quantity         | Price       | Address                                           | Application Status |");
        System.out.println(" ");
        for(int i=0;i<=151;i++){
            System.out.print("-");
        }
        System.out.println("-");
        int tab1 = 12;
        int tabpe = 12;
        int tab2 = 16;
        int tab3 = 14;
        int tab4 = 12;
        int tab5 = 50;
        
        while(rs.next()){
         //Retrieve by column name
         String id  = rs.getString("order_id");
         String pets_id = rs.getString("pet_id");
         String username = rs.getString("username");
         String quantity = rs.getString("quantity");
         String total_price = rs.getString("total_price");
         String del = rs.getString("delivery_add");
//         System.out.println(del);
         String stas = rs.getString("status");
         //Display values
         System.out.print("| "+id);
         int spaces = tab1 - id.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print("| "+pets_id);
         spaces = tabpe - pets_id.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print("| "+username);
         spaces = tab2 - username.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print("|    "+quantity);
         spaces = tab3 - quantity.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print("| "+total_price);
         spaces = tab4 - total_price.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print("| "+del);
         spaces = tab5 - del.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print("| "+stas);
         spaces = 19 - stas.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.println("|");
      }
        for(int i=0;i<=151;i++){
            System.out.print("-");
        }
        System.out.println("-");
      rs.close();
      }
     catch(Exception e)
     { 
        System.out.println(e);
     }
}
   public void disp2()
           throws IOException
   {
      try
      {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //registering type4 driver of oracle
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
        Statement stmt=con.createStatement();
        String ql = "SELECT first_name, last_name, contact_no, email, aadhar, username, password FROM Users ";
//        System.out.println(ql);
        ResultSet rs=stmt.executeQuery(ql);
        System.out.print("First Name    Last Name     Contact No     Email                                   Aadhar Number      Username      Password");
        int tab1 = 14;
        int tab2 = 14;
        int tab3 = 15;
        int tab4 = 40;
        int tab5 = 19;
        int tab6 = 14;
        System.out.println(" ");
        while(rs.next()){
         //Retrieve by column name
         String fname  = rs.getString("first_name");
         String lname = rs.getString("last_name");
         String cno = rs.getString("contact_no");
         String email = rs.getString("email");
         String aadhar = rs.getString("aadhar");
         String username = rs.getString("username");
         String password = rs.getString("password");
         //Display values
         System.out.print(""+fname);
         int spaces = tab1 - fname.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print(lname);
         spaces = tab2 - lname.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print(cno);
         spaces = tab3 - cno.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print(email);
         spaces = tab4 - email.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print(aadhar);
         spaces = tab5 - aadhar.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print(username);
         spaces = tab6 - username.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.println(password);
      }
      rs.close();
      }
     catch(Exception e)
     { 
        System.out.println(e);
     }
}
   public String fcap(String name){
       String firstLetter = name.substring(0, 1);
       String remainingLetters = name.substring(1, name.length());
       firstLetter = firstLetter.toUpperCase();
       remainingLetters = remainingLetters.toLowerCase();
       name = firstLetter + remainingLetters;
       return name;
   }
}