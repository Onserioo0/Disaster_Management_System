package disastermanagementsystem;

import java.sql.*;
/**
 *
 * @author Oj
 */
public class Database {
    
    /**
     *
     * @return
     */
    public static Connection connectDB() {
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            return DriverManager.getConnection("jdbc:mysql://localhost/rescueteam", "root", "");
            
        }
        catch (ClassNotFoundException | SQLException e){e.printStackTrace();}
    
        return null;
    }

  
}
