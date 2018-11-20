package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Database {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String name;
        String insertQ = "insert into batch4 values(?,?)";
        int id;
        int choice;
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
            
            //execute() for: insert, create table, update
            //executeUpdate() for: deletion
            
//4. Create table
//            String query = "create table batch4 ("
//                    + "id int,"
//                    + "name varchar(256),"
//                    + "primary key(id));";
//            stt.execute(query);
//            System.out.println("Table created successfully");
            
//            boolean want = true;
//            while (want) {    
//                System.out.println("Enter id and name for bact4 student: ");
//                System.out.println("ID:");
//                id = scan.nextInt();
//                System.out.println("Name:");
//                name = scan.next();
//                //Inserting values
////                insertQ = "insert into batch4 values ("+id+','+'"'+name+'"'+");";
//                //setInt(placeholder, value)
//                ps.setInt(1, id);
//                ps.setString(2,name);
//                ps.execute();
//                System.out.println("Press 1 to Save & Add more\n"
//                                  +"Press 2 to Save & Exit");
//                choice = scan.nextInt();
//                if(choice == 2) want = false;
//            }

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
