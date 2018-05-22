package ie.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

// To execute with Maven: mvn exec:java -D"exec.mainClass"="ie.examples.App"
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Attempting to connect to the database...");
        String connectionString = "jdbc:sqlserver://{your server here}.database.windows.net:1433;" + 
                                  "database={your database};" + 
                                  "user={your server admin login}@{your server name};" + 
                                  "password={your password};" + 
                                  "encrypt=true;" + 
                                  "trustServerCertificate=false;" + 
                                  "hostNameInCertificate=*.database.windows.net;" +
                                  "loginTimeout=30;";
        Connection connection = null;  

        try 
        {  
            connection = DriverManager.getConnection(connectionString);  
            // Execute a query against the database and return rows (if any) to the ResultSet
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM customerTable");
            // The ResultSet places the current row directly before the first row. Calling next() moves it to the next row, and returns true if there is a row. False if there is no row there.
            while(rs.next())
            {              
                if(rs.getBoolean("paid") == true) // If the current row has true for the boolean column 'paid'
                {  
                    // Print out a message made up from the columns in the database 
                    System.out.println(rs.getString("first_name") + " " + rs.getString("last_name") + " has paid " + rs.getDouble("amount"));
                }
                else
                {
                    System.out.println(rs.getString("first_name") + " " + rs.getString("last_name") + " has not paid " + rs.getDouble("amount"));
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
