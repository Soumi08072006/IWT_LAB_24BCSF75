package jdbctest.testpack;

import java.sql.*;
import java.util.Scanner;

public class InsertScanner {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.1.17/cse_db24";
        String username = "24bcsf75";
        String password = "24bcsf75";

        String sql = "INSERT INTO student (roll_no, name, age, department, cgpa) VALUES (?, ?, ?, ?, ?)";

        
        try (Scanner sc = new Scanner(System.in);
             Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter Roll No: ");
            int r = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter Name: ");
            String n = sc.nextLine();

            System.out.print("Enter Age: ");
            int a = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter Department: ");
            String d = sc.nextLine();

            System.out.print("Enter CGPA: ");
            float c = sc.nextFloat();

            
            ps.setInt(1, r);
            ps.setString(2, n);
            ps.setInt(3, a);
            ps.setString(4, d);
            ps.setFloat(5, c);

            ps.executeUpdate();
            System.out.println("Record Inserted Successfully!");

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Input error: " + e.getMessage());
        }
    }
}
