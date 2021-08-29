import java.io.*;
import java.sql.*;

class update
{
    public void updatetable(String table_name, String column_change_name, String columnn_change_value,String to_change_name, String to_change_val){
   try
      {
        display show = new display();
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
        Statement stmt3=con.createStatement();
        String q1 = "";
        if("pet_age".equals(column_change_name) || "pet_quantity".equals(column_change_name) || "pet_price".equals(column_change_name) || "order_id".equals(column_change_name)){
            q1="UPDATE Pets SET " + column_change_name + "='"+Integer.parseInt(columnn_change_value)+"' WHERE " + to_change_name + "='"+to_change_val+"'";
//            System.out.println(q1);
        }
        else{
            q1="UPDATE "+table_name+ " SET " + column_change_name + "='"+columnn_change_value+"' WHERE " + to_change_name + "='"+to_change_val+"'";
        }
        int x=stmt3.executeUpdate(q1);
        if(x>0)
        {
//           System.out.println("Entry updated successfully");
       }
       else
       {
         System.out.println("update unsuccessful");
       }
     con.close();
     }
     catch(Exception e4)
     {  
        System.out.println(e4);
     }
    }
}