package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PrepStatement {

    public static void main(String[] args) {
    
        String name;
        String insertQ = "insert into batch4 values(?,?)";
        int id,choice;
        boolean want=true;
        
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
            PreparedStatement ps = connection.prepareStatement(insertQ);
            System.out.println("Statement created");
            
            //4. Create table
            String query = "create table batch4 ("
                    + "id int,"
                    + "name varchar(256),"
                    + "primary key(id));";
            stt.execute(query);
            System.out.println("Table created successfully");
            
            
            //5. Insert values
            while(want) {
                System.out.println("Enter id and name for bact4 student: ");
                System.out.println("ID:");
                id = scan.nextInt();
                System.out.println("Name:");
                name = scan.next();
                ps.setInt(1, id);
                ps.setString(2,name);
                
                System.out.println("Press 1 to Save & Add more\n"
                                  +"Press 2 to Save & Exit");
                choice = scan.nextInt();
                if(choice == 2) want = false;
            }
            System.out.println("Insertion completed");

        } 
        catch (ClassNotFoundException cn) { System.out.println("Problem loading driver..."); } 
        catch (SQLException ex) { System.out.println("Problem executing Query..."); }
        
    }
    
}
