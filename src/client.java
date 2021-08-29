import java.io.*;
import java.sql.*;
import java.util.Scanner;

class client
{
   public static void main(String args[])
           throws IOException
   {
       login loggedin = new login();
       display show = new display();
       book booked = new book();
       update tup = new update();
       String dstring = "SELECT pet_id, pet_type, pet_breed, pet_age, pet_quantity, pet_price FROM Pets ORDER BY pet_id";
       Scanner myObj = new Scanner(System.in); // to take input
       System.out.println();
       System.out.println("----------------WELCOME TO GUCCI PET BOOKING APP------------------");
       System.out.println();
       System.out.println("We offer wide variety of pets in affordable prices");
       System.out.println();
       System.out.println("Press 1 to enter into the shop and book some pets.");
       System.out.println("Press 0 if you wish to see us next time.");
       int acti = myObj.nextInt();
       String temp = myObj.nextLine();
       
       System.out.println();
       if(acti==1){
           System.out.println("Let's jump straight to our little pets: ");
           System.out.println();
           System.out.println("Getting you into our little world of pets......");
           
           System.out.println();
           show.disp(dstring);
           System.out.println();
           System.out.println("Choose the action you wish to take: ");
           System.out.println();
           int done = 0;
           while(done==0){
           System.out.println("1. Filter the pet search");
           System.out.println("2. Buy a pet using pet id");
           System.out.println("3. Delete the filter");
           System.out.println("4. Check my order status");
           System.out.println("5. Exit the shop");
           int action = myObj.nextInt();
           String temp1 = myObj.nextLine();
           if(action == 1){
               dstring = "SELECT pet_id, pet_type, pet_breed, pet_age, pet_quantity, pet_price FROM Pets WHERE ";
               System.out.println("Do you want to filter on the basis of type of pet? (y/n) : ");
               char wantsTo = myObj.nextLine().charAt(0);
               int ran = 0;
               if(wantsTo == 'Y' || wantsTo=='y'){
                   System.out.println("Enter the type of pet: ");
                   String inp = myObj.next();
                   
                   ran = 1;
                   dstring = dstring + "pet_type = '" + show.fcap(inp) + "'";
               }
               int ran1 = 0;
               String temp13 = myObj.nextLine();
               System.out.println("Do you want to filter on the basis of breed of pet? (y/n) : ");
               char wantsTo1 = myObj.nextLine().charAt(0);
               if(wantsTo1 == 'Y' || wantsTo1=='y'){
                   System.out.println("Enter the breed name: ");
                   String inp = myObj.next();
                   ran1 = 1;
                   if(ran == 0){
                      dstring = dstring + "pet_breed = '" + show.fcap(inp) + "'";
                   }
                   else{
                      dstring = dstring + " AND pet_breed = '" + show.fcap(inp) + "'"; 
                   }
                }
               if(ran==1 || ran1==1){
                   dstring = dstring + " ORDER BY pet_id";
               }
               try
               {
                   Class.forName("oracle.jdbc.driver.OracleDriver");
        //registering type4 driver of oracle
                   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
                   Statement stmt=con.createStatement();
                   if(ran1==0 && ran==0){
                       dstring = "SELECT pet_id, pet_type, pet_breed, pet_age, pet_quantity, pet_price FROM Pets ORDER BY pet_id";
                   }
                   int x=stmt.executeUpdate(dstring);
                   if(x>0)
                   {
                      System.out.println("Filter Successful!");
                      System.out.println();
                      show.disp(dstring);
                  }
                  else
                  {
                    System.out.println("Error! Please try again!");       
                con.close();
                }  
                }
                catch(Exception e2)
                { 
                   System.out.println(e2);
                }
           }
           else if(action == 2){
               
               int inside_done = 0;
               while(inside_done==0){
                    System.out.println("1. Buy pet using its pet id! ");
                    System.out.println("2. Get back to the shop! ");
                    System.out.println("3. Display the records I have filtered! ");
                    int chopt = myObj.nextInt();
                    if(chopt == 1){
                        System.out.println("Enter the id of the pet! ");
                        int id = myObj.nextInt();
                        System.out.println("The pet you have selected is as follows: ");
                        String tempstring = "SELECT pet_id, pet_type, pet_breed, pet_age, pet_quantity, pet_price FROM Pets WHERE pet_id = '" + id + "'";
                        show.disp(tempstring);
                        System.out.println();
                        System.out.println("1. If you want to continue your purchase! ");
                        System.out.println("2. If you want to get back! ");
                        int opt = myObj.nextInt();
                        if(opt == 1){
                            System.out.println("Enter the quantity of pet you would like to purchase: ");
                            int n = myObj.nextInt();
                            try{
                            Class.forName("oracle.jdbc.driver.OracleDriver");
        //registering type4 driver of oracle
                            Connection con11=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
                            Statement stmt=con11.createStatement();
//        System.out.println(ql);
                            ResultSet rs=stmt.executeQuery(tempstring);
                            int quant=0,p_id=0,pe_age=0,price_one=0;
                            String pe_breed="",pe_type="";
                            while(rs.next()){
                            quant = Integer.parseInt(rs.getString("pet_quantity"));
                            p_id  = Integer.parseInt(rs.getString("pet_id"));
                            pe_type = rs.getString("pet_type");
                            pe_breed = rs.getString("pet_breed");
                            pe_age = Integer.parseInt(rs.getString("pet_age"));
                            price_one = Integer.parseInt(rs.getString("pet_price"));
                            }
                            if(n<=quant && n>0){
                                System.out.println("1. If you want to continue your purchase: ");
                                System.out.println("2. If you want to get back: ");
                                int fopt = myObj.nextInt();
                                if(fopt == 1){
                                    System.out.println("Your purchase details are as follows: ");
                                    System.out.println("ID: " + p_id);
                                    System.out.println("TYPE: " + pe_type);
                                    System.out.println("BREED: " + pe_breed);
                                    System.out.println("AGE: " + pe_age + " months");
                                    System.out.println("QUANTITY: " + n);
                                    System.out.println("Total amount to be paid is: " + n*price_one);
                                    System.out.println("1. If you want to book the pet: ");
                                    System.out.println("2. If you want to get back: ");
                                    int fopt1 = myObj.nextInt();
                                    if(fopt1 == 1){
                                        System.out.println("1. Signup");
                                        System.out.println("2. Login via Unique Gucci Username!");
                                        int fopt2 = myObj.nextInt();
                                        if(fopt2 == 1){
                                            //purchase
                                            int rval = loggedin.signup();
                                            if(rval==0){
                                                fopt2 = 2;
                                            }
                                        }
                                            
                                        if(fopt2 == 2){ 
                                            System.out.println("Enter your username: ");
                                            String username = myObj.next();
//                                            String tmp = myObj.nextLine();
                                            System.out.println("Enter your password: ");
                                            String password = myObj.next();
//                                            String tmp1 = myObj.nextLine();
                                            int rval1 = loggedin.getin(username, password);
                                            if(rval1 == 0){
                                                int status = booked.booking(username,pe_type,pe_breed,n,price_one,p_id);
                                                if(status==0){
                                                    tup.updatetable("Pets", "pet_quantity", Integer.toString(quant-n), "pet_id", Integer.toString(p_id));
                                                    
                                                    inside_done = 1;
                                                    done = 1;
                                                }
                                            }
                                        }
                                        
                                    }
                                    else{
                                        continue;
                                    }
                                }
                                else{
                                    continue;
                                }
                            }
                            else{
                                System.out.println("Requested quantity is not available!");
                                System.out.println("Re-directing to the shop......");
                                continue;
                            }
                            }
                            catch(Exception e4){
                                System.out.println(e4);
                            }
                        }
                        else{
                            continue;
                        }
                    }
                    else if(chopt==2){
                        break;
                    }
                    else{
                        show.disp(dstring);
                    }
               }
           }
           else if(action==3){
               dstring = "SELECT pet_id, pet_type, pet_breed, pet_age, pet_quantity,pet_price FROM Pets ORDER BY pet_id";
               System.out.println("Filter removed successfully.");
               show.disp(dstring);
           }
           else if(action==4){
             System.out.println("Enter your username: ");
            String username = myObj.next();
//                                            String tmp = myObj.nextLine();
            System.out.println("Enter your password: ");
            String password = myObj.next();
//                                            String tmp1 = myObj.nextLine();
            int rval1 = loggedin.getin(username, password);
            if(rval1==0){
                System.out.println("Enter your order id: ");
                int id = myObj.nextInt();
                try
      {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //registering type4 driver of oracle
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
        Statement stmt=con.createStatement();
//        System.out.println(ql);
        String ql = "SELECT order_id, pet_id, username, quantity, total_price, delivery_add, status FROM Orders WHERE order_id = '" + id + "' ";
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
         String id1  = rs.getString("order_id");
         String pets_id = rs.getString("pet_id");
         String username1 = rs.getString("username");
         String quantity = rs.getString("quantity");
         String total_price = rs.getString("total_price");
         String del = rs.getString("delivery_add");
//         System.out.println(del);
         String stas = rs.getString("status");
         //Display values
         System.out.print("| "+id1);
         int spaces = tab1 - id1.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print("| "+pets_id);
         spaces = tabpe - pets_id.length();
         for(int i=0;i<spaces;i++){
             System.out.print(" ");
         }
         System.out.print("| "+username1);
         spaces = tab2 - username1.length();
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
           }
           else{
               done = 1;
           }
       }
       }
       System.out.println("See You Again!!.");
   }
}