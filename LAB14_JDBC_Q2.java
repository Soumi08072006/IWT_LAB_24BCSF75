package jdbctest.testpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTable {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.1.17/cse_db24";
        String username = "24bcsf75";
        String password = "24bcsf75";

        
        String sql = "CREATE TABLE IF NOT EXISTS student (" +
                     "roll_no INT PRIMARY KEY, " +
                     "name VARCHAR(30), " +
                     "age INT, " +
                     "department VARCHAR(20), " +
                     "cgpa FLOAT" +
                     ")";

       
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement st = con.createStatement()) {
            
            st.executeUpdate(sql);
            System.out.println("Table 'student' created or verified successfully.");
            
        } catch (SQLException e) {
            System.err.println("Database error occurred:");
            e.printStackTrace();
        }
    }
}
