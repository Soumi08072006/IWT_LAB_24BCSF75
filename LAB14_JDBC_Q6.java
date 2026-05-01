package jdbctest.testpack;

import java.sql.*;
import java.util.Scanner;

public class UpdateRecord {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.1.17/cse_db24";
        String username = "24bcsf75";
        String password = "24bcsf75";

        try (Scanner sc = new Scanner(System.in);
             Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = con.prepareStatement("UPDATE student SET cgpa=? WHERE roll_no=?")) {

            System.out.print("Enter Roll No to update: ");
            int r = sc.nextInt();
            System.out.print("Enter New CGPA: ");
            float c = sc.nextFloat();

            ps.setFloat(1, c);
            ps.setInt(2, r);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record Updated Successfully!");
            } else {
                System.out.println("No student found with Roll No: " + r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
