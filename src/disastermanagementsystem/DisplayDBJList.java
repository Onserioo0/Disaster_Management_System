package disastermanagementsystem;
/**
 *
 * @author Oj
 */
import java.sql.*;
import javax.swing.*;

public class DisplayDBJList extends JFrame {
    private JList<String> list;
    private DefaultListModel<String> model;
    private Connection conn;
    private Statement stmt;

    @SuppressWarnings({"CallToPrintStackTrace", "OverridableMethodCallInConstructor"})
    public DisplayDBJList() {
        model = new DefaultListModel<>();
        list = new JList<>(model);

        try {
            // Connect to the MySQL database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rescueteam", "root", "");

            // Create a Statement object
            stmt = conn.createStatement();

            // Execute the query to retrieve data from the table
            ResultSet rs = stmt.executeQuery("SELECT * FROM chukatown ORDER BY `road_length` ASC");

            // Iterate over the ResultSet and add each item to the model
            while (rs.next()) {
                String id = rs.getString("road_id");
                String name = rs.getString("road_name");
                String length = rs.getString("road_length");
                String traffic = rs.getString("road_traffic");
                String condition = rs.getString("road_condition");

                //model.addElement(id);
                model.addElement(name);
                //model.addElement(length);
                //model.addElement(traffic);
                //model.addElement(condition);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        add(new JScrollPane(list));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
                /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        SwingUtilities.invokeLater(DisplayDBJList::new);
    }
}

