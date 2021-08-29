import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class login {
    
   public int getin(String username, String password)
           throws IOException
   {
       
        Scanner myObj = new Scanner(System.in);
        
        try
      {  
        int done = 0;
        int gohead=0;
        while(done==0){
            
            int proceed=0;
            if(gohead==1){
                System.out.println("1. If you want to try again to login.");
                System.out.println("2. Return to the shop.");
                int ent = myObj.nextInt();
                if(ent==1){
                    proceed = 1;
                    System.out.println("Re-enter the username: ");
                    username = myObj.next();
                    System.out.println("Re-enter the password: ");
                    password = myObj.next();
                }
                else{
                    return 2;
                }
            }
            if(gohead==0 || proceed==1){
                gohead=1;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //registering type4 driver of oracle
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
        Statement stmt=con.createStatement();
//        System.out.println(ql);
        String ql = "SELECT username, password FROM Users WHERE username='" + username + "'";
        ResultSet rs=stmt.executeQuery(ql);
        int findout=0;
        int pmatch = 0;
        while(rs.next()){
            findout=1;
            String dbusername  = rs.getString("username");
            String dbpassword = rs.getString("password");
            if(dbpassword.equals(password)){
                pmatch = 1;
            }
        }
        if(findout==0){
            System.out.println("Username does not exist!");
            System.out.println("Try Again!");
        }
        else if(pmatch == 0){
            System.out.println("Passwords do not match!");
            System.out.println("Try Again!");
        }
        else{
            done = 1;
            return 0;
        }
      rs.close();
      }
        }
      }
     catch(Exception e)
     { 
        System.out.println(e);
     }
      return 1;
   }
   public int signup()
           throws IOException
   {
       Scanner myObj = new Scanner(System.in);
      try
      {
          int done = 0;
        while(done==0){
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //registering type4 driver of oracle
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
        Statement stmt=con.createStatement();
        System.out.println("Welcome to Gucci Pet Booking App Signup Section!");
        System.out.println();
        System.out.println("Please add the following details");
        System.out.println("Enter your First Name: ");
        String Fname = myObj.next();
        System.out.println("Enter your Last Name: ");
        String Lname = myObj.next();
        System.out.println("Enter your Mobile Number: ");
        String Cno = myObj.next();
        System.out.println("Enter your E-Mail: ");
        String Email = myObj.next();
        System.out.println("Enter your username: ");
        String username = myObj.next();
        System.out.println("Enter your password: ");
        String password = myObj.next();
        System.out.println("Re-enter to confirm your password: ");
        String confirm_password = myObj.next();
        while(!confirm_password.equals(password)){
            System.out.println("Passwords do not match! Please Try Again!");
            System.out.println("Enter your password: ");
            password = myObj.next();
            System.out.println("Re-enter to confirm your password: ");
            confirm_password = myObj.next();
        }
        System.out.println("Enter your Aadhar card number for verification! ");
        String aadhar = myObj.next();
        
        String ql = "INSERT INTO Users values('"+Fname+"','"+Lname+"','"+Cno+"','"+Email+"','"+aadhar+"','" + username +"','" + password + "' )";
        int x=stmt.executeUpdate(ql);
        if(x>0){
            System.out.println("Sign Up complete! Please remember your details!");
            return 0;
        }
        else{
            System.out.println("Please try other username!");
            System.out.println("1. If you want continue!");
            System.out.println("2. If you want return!");
            int opt = myObj.nextInt();
            if(opt==1){
                continue;
            }
            else{
                return 2;
            }
        }
        }
      }
     catch(Exception e){
         System.out.println(e);
     }
    return 1;  
   }
}

