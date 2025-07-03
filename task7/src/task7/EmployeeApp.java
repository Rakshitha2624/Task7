package task7;

import java.sql.*;
import java.util.Scanner;

public class EmployeeApp {

    static final String DB_URL = "jdbc:mysql://localhost:3306/employee_db";
    static final String DB_USER = "root";
    static final String DB_PASS = "Rakshitha$26"; // 🔁 Replace with your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public static void addEmployee(String name, String email, double salary) {
        String sql = "INSERT INTO employees (name, email, salary) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setDouble(3, salary);
            stmt.executeUpdate();
            System.out.println(" Employee successfully added to the database.");

        } catch (SQLException e) {
            System.out.println(" Failed to add employee. Error: " + e.getMessage());
        }
    }

    public static void viewEmployees() {
        String sql = "SELECT * FROM employees";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println(" Employee Records:");
            System.out.println("--------------------------------------------------");
            while (rs.next()) {
                System.out.printf(" ID: %d |  Name: %s |  Email: %s |  Salary: ₹%.2f\n",
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getDouble("salary"));
            }
            System.out.println("--------------------------------------------------");

        } catch (SQLException e) {
            System.out.println(" Error retrieving employee records: " + e.getMessage());
        }
    }

    public static void updateEmployee(int id, String newEmail) {
        String sql = "UPDATE employees SET email = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newEmail);
            stmt.setInt(2, id);
            int updated = stmt.executeUpdate();
            if (updated > 0) {
                System.out.println(" Employee email updated successfully.");
            } else {
                System.out.println(" No employee found with the given ID.");
            }

        } catch (SQLException e) {
            System.out.println(" Failed to update employee. Error: " + e.getMessage());
        }
    }

    public static void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int deleted = stmt.executeUpdate();
            if (deleted > 0) {
                System.out.println(" Employee deleted successfully.");
            } else {
                System.out.println(" No employee found with the given ID.");
            }

        } catch (SQLException e) {
            System.out.println(" Error deleting employee: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===============================");
            System.out.println(" Employee Management System");
            System.out.println("===============================");
            System.out.println("1️ Add New Employee");
            System.out.println("2️ View All Employees");
            System.out.println("3️ Update Employee Email");
            System.out.println("4️ Delete Employee");
            System.out.println("5️ Exit");
            System.out.print(" Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume leftover newline
                    System.out.print(" Enter name: ");
                    String name = sc.nextLine();
                    System.out.print(" Enter email: ");
                    String email = sc.nextLine();
                    System.out.print(" Enter salary: ");
                    double salary = sc.nextDouble();
                    addEmployee(name, email, salary);
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    System.out.print(" Enter employee ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); // clear newline
                    System.out.print(" Enter new email: ");
                    String newEmail = sc.nextLine();
                    updateEmployee(updateId, newEmail);
                    break;

                case 4:
                    System.out.print(" Enter employee ID to delete: ");
                    int deleteId = sc.nextInt();
                    deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.println(" Exiting... Thank you for using EMS!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid option! Please choose a valid number.");
            }
        }
    }
}
