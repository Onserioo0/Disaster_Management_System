
package disastermanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    
    public static Connection connectDB() {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/rescueteam", "admin", "0794768781@Oj");
            return connect;
            
        } catch (ClassNotFoundException | SQLException e){
        }
        return null;
    }
    
}

