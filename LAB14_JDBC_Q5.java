package jdbctest.testpack;

import java.sql.*;

public class DisplayRecord {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.1.17/cse_db24";
        String username = "24bcsf75";
        String password = "24bcsf75";

        String sql = "SELECT * FROM student";

        // try-with-resources automatically closes Connection, Statement, and ResultSet
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("Roll | Name           | Age | Dept | CGPA");
            System.out.println("------------------------------------------");

            while (rs.next()) {
                // Using printf to format the output into clean columns
                System.out.printf("%-4d | %-14s | %-3d | %-4s | %.2f%n",
                        rs.getInt("roll_no"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getFloat("cgpa"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
