package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Manual {

    public static void main(String[] args) {
    
        String name,insertQ;
        int id;
        
        Scanner scan = new Scanner(System.in);
        
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
            System.out.println("Enter id and name for bact4 student: ");
            System.out.println("ID:");
            id = scan.nextInt();
            System.out.println("Name:");
            name = scan.next();
            insertQ = "insert into batch4 values ("+id+','+'"'+name+'"'+");";
            stt.execute(insertQ);
            
            
            System.out.println("Insertion completed");

        } 
        catch (ClassNotFoundException cn) { System.out.println("Problem loading driver..."); } 
        catch (SQLException ex) { System.out.println("Problem executing Query..."); }
        
    }
    
}
