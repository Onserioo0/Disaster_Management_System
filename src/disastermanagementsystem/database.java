package disastermanagementsystem;

import java.sql.*;
/**
 *
 * @author Oj
 */
public class database {
    
    public static Connection connectDB() {
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/rescueteam", "root", "");
        
            return connect;
            
        } catch (ClassNotFoundException | SQLException e){
        }
    
        return null;
    }

    
}
