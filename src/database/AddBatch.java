package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddBatch {

    public static void main(String[] args) {
    
        String name,insertQ;
        int id;
        
        try {
            
            //1. Load the driver
            Class.forName("com.mysql.jdbc.Driver"); 
            System.out.println("Driver loaded successfully");
            
            //2. Established connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/TestDB","root","root"); 
            System.out.println("Connection retrieved");
            
            //3. Creating Statement
            Statement stt = connection.createStatement();
            System.out.println("Statement created");
            
            //4. Create table
            String query = "create table batch4 ("
                    + "id int,"
                    + "name varchar(256),"
                    + "primary key(id));";
            stt.execute(query);
            System.out.println("Table created successfully");
            
            
            //5. Insert values
            String query1 = "insert into batch4 values(1,'Walter');";
            String query2 = "insert into batch4 values(2,'Toby');";
            String query3 = "insert into batch4 values(3,'Sylvaster');";
            String query4 = "insert into batch4 values(4,'Happy');";
            
            stt.addBatch(query1);
            stt.addBatch(query2);
            stt.addBatch(query3);
            stt.addBatch(query4);
            
            stt.executeBatch();
            System.out.println("Insertion completed");

        } 
        catch (ClassNotFoundException cn) { System.out.println("Problem loading driver..."); } 
        catch (SQLException ex) { System.out.println("Problem executing Query..."); }
        
    }
    
}
