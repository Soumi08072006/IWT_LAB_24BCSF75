package jdbctest.testpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecord {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.1.17/cse_db24";
        String username = "24bcsf75";
        String password = "24bcsf75";

        String sql = "INSERT INTO student (roll_no, name, age, department, cgpa) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            // Insert First Record
            pstmt.setInt(1, 1);
            pstmt.setString(2, "Rahul");
            pstmt.setInt(3, 20);
            pstmt.setString(4, "IT");
            pstmt.setDouble(5, 8.5);
            pstmt.executeUpdate();

            // Insert Second Record
            pstmt.setInt(1, 2);
            pstmt.setString(2, "Priya");
            pstmt.setInt(3, 21);
            pstmt.setString(4, "CSE");
            pstmt.setDouble(5, 9.1);
            pstmt.executeUpdate();

            System.out.println("Records Inserted Successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
