import java.io.*;
import java.sql.*;
import java.util.Scanner;  
class server
{
   public static void main(String args[])
           throws IOException
   {
       String dstring = "SELECT pet_id, pet_type, pet_breed, pet_age, pet_quantity, pet_price FROM Pets ORDER BY pet_id ";
       display show = new display();
       update uptable = new update();
       update tup = new update();
       Scanner myObj = new Scanner(System.in); // to take input
       // Display Record Before Adding
       System.out.println("Before addition the database looks like: ");
       System.out.println();
       System.out.println("----------------GUCCI PET BOOKING APP: BACKEND------------------");
       System.out.println();
       show.disp(dstring);
    DataInputStream ds=new DataInputStream(System.in);//Keyboard input
    int done = 0;
    while(done==0){
    System.out.println();
    System.out.println();
    System.out.println("Following functionalities are avaiable: ");
    System.out.println();
    System.out.println("1. Add new pet to the store.");
    System.out.println("2. Update the information of a pet.");
    System.out.println("3. Remove a pet from the store.");
    System.out.println("4. View Orders Table.");
    System.out.println("5. View Users Database.");
    System.out.println("6. Update Order Status.");
    System.out.println("0. Close the shop.");
    System.out.println("Enter the value corresponding to the action you want to perform: ");
    int action = myObj.nextInt();
    String temp = myObj.nextLine();
    if(action == 1){
    System.out.print("Do You Wish To Add More Records? (y/n): ");
    char plus_rec = myObj.nextLine().charAt(0);
    if(plus_rec == 'y' || plus_rec=='Y'){
      System.out.println();
      System.out.println("Enter the details of the pet");
      System.out.println();
      System.out.println("Enter pet id");
      int pid=Integer.parseInt(ds.readLine());    
      
      System.out.println("Enter the type of pet");
      String ptype=ds.readLine();
      
      System.out.println("Enter the breed of pet");
      String pbreed=ds.readLine();
      
      System.out.println("Enter the age of pet");
      int page=Integer.parseInt(ds.readLine());
      
      System.out.println("Enter the available quantity of pet");
      int pquant=Integer.parseInt(ds.readLine());
      
      System.out.println("Enter the price of one pet");
      int pprice=Integer.parseInt(ds.readLine());
      try
      {
          Class.forName("oracle.jdbc.driver.OracleDriver");
        //registering type4 driver of oracle
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
        Statement stmt=con.createStatement();
        String q1="INSERT INTO Pets values('"+pid+"','"+ptype+"','"+pbreed+"','"+page+"','"+pquant+"','" + pprice + "' )";
        int x=stmt.executeUpdate(q1);
        if(x>0)
        {
           System.out.println("Insert success");
           System.out.println("After insertion, the database is as follows: ");
           show.disp(dstring);
       }
       else
       {
         System.out.println("Insert unsuccess");       
 
       
     con.close();
     }  
     }
     catch(Exception e2)
     { 
        System.out.println(e2);
     }
    }
    }
    else if(action == 2){
      System.out.println("Enter the pet id of the pet whose details you wish to update: ");
      String enter_id=ds.readLine();
      String pid = enter_id;
      System.out.println("Enter the type of record you wish to update.");
      String type_name=ds.readLine();
      System.out.println("Enter the value of updated record.");
      String no=ds.readLine();
      String column_name = "";
      if("Type".equals(type_name)){
          column_name = "pet_type";
      }
      if("Breed".equals(type_name)){
          column_name = "pet_breed";
      }
      if("Age".equals(type_name)){
          column_name = "pet_age";
      }
      if("Quantity".equals(type_name)){
          column_name = "pet_quantity";
      }
      if("Price".equals(type_name)){
          column_name = "pet_price";
      }
      uptable.updatetable("Pets", column_name, no, "pet_id", pid);
      System.out.println();
      System.out.println("Entry updated successfully");
    }
    else if(action == 3){
        //delete entry
      System.out.println("Enter the pet id of the pet whose details you wish to delete: ");
      String enter_id=ds.readLine();
      int pid = Integer.parseInt(enter_id);
      try
      {
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
        Statement stmt3=con.createStatement();
        
        String q1="DELETE FROM Pets WHERE pet_id='"+pid+"'";
        
        int x=stmt3.executeUpdate(q1);
        if(x>0)
        {
           System.out.println("Entry deleted successfully.");
           System.out.println("After deletion, the database is as follows: ");
           show.disp(dstring);
       }
       else
       {
         System.out.println("update unsuccess");
       }
     con.close();
     }
     catch(Exception e6)
     {  
        System.out.println(e6);
     }
    }
    else if(action == 4){
        show.disp1();
    }
    else if(action == 5){
        show.disp2();
    }
    else if(action == 6){
        System.out.println("1. If you want to approve the order");
        System.out.println("2. If you want to cancel order");
        System.out.println("3. If you want to add order to the waitlist");
        System.out.println("4. If you wish to get back!");
        int custopt = myObj.nextInt();
        if(custopt!=4){
            System.out.println("Enter the order id: ");
            String id = Integer.toString(myObj.nextInt());
            if(custopt == 1){
                uptable.updatetable("Orders", "status", "Approved", "order_id", id);
                System.out.println("The order with order id "+ id + " is confirmed");
                
            }
            else if(custopt == 2){
                uptable.updatetable("Orders", "status", "Not Approved", "order_id", id);
                System.out.println("The application request of order with order id "+ id + " is cancelled.");
                
                //Changing back the quantity deducted earlier
                try
                {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                  //registering type4 driver of oracle
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
                  Statement stmt=con.createStatement();
                  String ql = "SELECT order_id, pet_id, username, quantity, total_price, delivery_add, status FROM Orders WHERE order_id = '" + id + "'";
                  ResultSet rs=stmt.executeQuery(ql);
                  
                  while(rs.next()){
                        String ord_id  = rs.getString("order_id");
                        String pets_id = rs.getString("pet_id");
                        String quantity = rs.getString("quantity");
                        tup.updatetable("Pets", "pet_quantity", quantity, "pet_id", pets_id);
                  }
                  rs.close();
                  
                }
                catch(Exception e6){
                    System.out.println(e6);
                }
               
            }
            else {
                uptable.updatetable("Orders", "status", "In Waitlist", "order_id", id);
                System.out.println("The order with order id "+ id + " is in waitlist");
            }
        }
        
        
    }
    else{
        done = 1;
    }
    }
    System.out.println();
    System.out.println("Until Next Time!!");
    System.out.println();
}
}