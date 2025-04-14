package buoi13;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/quanlynhansu";
        String dbUsername = "root";
        String dbPassword = "root";

        // JDBC connection
        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword)) {
            System.out.println("Connected to the database!");

            // Insert a record into the employees table
            String insertSQL = "INSERT INTO employees (name, position, salary, department_id, hire_date) " +
                    "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setString(1, "John Doe"); // name
                preparedStatement.setString(2, "Software Engineer"); // position
                preparedStatement.setBigDecimal(3, new java.math.BigDecimal("75000.00")); // salary
                preparedStatement.setInt(4, 1); // department_id
                preparedStatement.setDate(5, Date.valueOf("2024-01-01")); // hire_date

                int rowsInserted = preparedStatement.executeUpdate();
                System.out.println("Inserted " + rowsInserted + " row(s) into the employees table.");
            }

            // Retrieve and display records from the employees table
            String selectSQL = "SELECT employee_id, name, position, salary, department_id, hire_date FROM employees";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(selectSQL);

                System.out.println("Employees table records:");
                while (resultSet.next()) {
                    int employeeId = resultSet.getInt("employee_id");
                    String name = resultSet.getString("name");
                    String position = resultSet.getString("position");
                    double salary = resultSet.getDouble("salary");
                    int departmentId = resultSet.getInt("department_id");
                    Date hireDate = resultSet.getDate("hire_date");

                    System.out.printf("ID: %d, Name: %s, Position: %s, Salary: %.2f, Department ID: %d, Hire Date: %s%n",
                            employeeId, name, position, salary, departmentId, hireDate);
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error:");
            e.printStackTrace();
        }
    }
}
