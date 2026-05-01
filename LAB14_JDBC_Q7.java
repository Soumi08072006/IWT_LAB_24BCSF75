package jdbctest.testpack;

import java.sql.*;
import java.util.Scanner;

public class DeleteRecord {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.1.17/cse_db24";
        String username = "24bcsf75";
        String password = "24bcsf75";

        try (Scanner sc = new Scanner(System.in);
             Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE roll_no=?")) {

            System.out.print("Enter Roll No to Delete: ");
            int r = sc.nextInt();

            ps.setInt(1, r);
            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Record Deleted Successfully!");
            } else {
                System.out.println("No record found with Roll No: " + r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
