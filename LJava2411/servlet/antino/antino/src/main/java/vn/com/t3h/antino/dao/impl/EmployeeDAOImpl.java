package vn.com.t3h.antino.dao.impl;


import vn.com.t3h.antino.dao.EmployeeDAO;
import vn.com.t3h.antino.model.EmployeeModel;
import vn.com.t3h.antino.service.EmployeeService;
import vn.com.t3h.antino.service.impl.EmployeeServiceImpl;
import vn.com.t3h.antino.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeModel> employeeModels = new ArrayList<>();
        String query = "SELECT e.employee_id, e.name, e.position, e.salary, e.hire_date, d.department_name " +
                "FROM employees e " +
                "LEFT JOIN departments d ON e.department_id = d.department_id";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                EmployeeModel employeeModel = new EmployeeModel();
                employeeModel.setEmployeeId(resultSet.getInt("employee_id"));
                employeeModel.setName(resultSet.getString("name"));
                employeeModel.setPosition(resultSet.getString("position"));
                employeeModel.setSalary(resultSet.getDouble("salary"));
                employeeModel.setHireDate(resultSet.getString("hire_date"));
                employeeModel.setDepartmentName(resultSet.getString("department_name"));

                employeeModels.add(employeeModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeModels;
    }

    @Override
    public List<EmployeeModel> getAllEmployees2(String name, Long salary, String fromDate, String toDate, String position) {
        List<EmployeeModel> employees = new ArrayList<>();

        // SQL query with placeholders for parameters
        String sql = "SELECT emp.employee_id, emp.name, emp.position, emp.salary, dept.department_name, emp.hire_date " +
                "FROM employees emp " +
                "LEFT JOIN departments dept ON emp.department_id = dept.department_id " +
                "WHERE (? IS NULL OR ? = emp.name) " +
                "AND (? IS NULL OR ? = emp.salary) " +
                "AND (? IS NULL OR emp.hire_date >= ?) " +
                "AND (? IS NULL OR emp.hire_date <= ?) " +
                "AND (? IS NULL OR emp.position = ?)";

        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Check if 'name' is null, if so, set NULL for both placeholders
            if (name == null) {
                pstmt.setNull(1, java.sql.Types.VARCHAR);
                pstmt.setNull(2, java.sql.Types.VARCHAR);
            } else {
                pstmt.setString(1, name);
                pstmt.setString(2, name);
            }

            // Check if 'salary' is null, if so, set NULL for both placeholders
            if (salary == null) {
                pstmt.setNull(3, Types.DECIMAL);
                pstmt.setNull(4, Types.DECIMAL);
            } else {
                pstmt.setLong(3, salary);
                pstmt.setLong(4, salary);
            }

            // Check if 'fromDate' is null, if so, set NULL for both placeholders
            if (fromDate == null) {
                pstmt.setNull(5, java.sql.Types.VARCHAR);
                pstmt.setNull(6, java.sql.Types.VARCHAR);
            } else {
                pstmt.setString(5, fromDate);
                pstmt.setString(6, fromDate);
            }

            // Check if 'toDate' is null, if so, set NULL for both placeholders
            if (toDate == null) {
                pstmt.setNull(7, java.sql.Types.VARCHAR);
                pstmt.setNull(8, java.sql.Types.VARCHAR);
            } else {
                pstmt.setString(7, toDate);
                pstmt.setString(8, toDate);
            }

            // Check if 'position' is null, if so, set NULL for both placeholders
            if (position == null) {
                pstmt.setNull(9, java.sql.Types.VARCHAR);
                pstmt.setNull(10, java.sql.Types.VARCHAR);
            } else {
                pstmt.setString(9, position);
                pstmt.setString(10, position);
            }

            /*
            ORM: object relation mapping
                auto convert data table sql -> class object java
             */
            try (ResultSet rs = pstmt.executeQuery()) {
                // Process the result set and map to EmployeeModel
                while (rs.next()) {
                    EmployeeModel employee = new EmployeeModel();
                    employee.setEmployeeId(rs.getInt("employee_id"));
                    employee.setName(rs.getString("name"));
                    employee.setPosition(rs.getString("position"));
                    employee.setSalary(rs.getDouble("salary"));
                    employee.setDepartmentName(rs.getString("department_name"));
                    employee.setHireDate(rs.getString("hire_date"));
                    employees.add(employee);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(conn);
        }

        return employees;
    }



    private static void closeConnection(Connection conn) {
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public int addEmployee(EmployeeModel employee) {
        Connection connection = null;
        PreparedStatement statement = null;
        int rowsInserted = 0;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);
            // Thêm mới nhân viên
            String sql = "INSERT INTO employees (name, position, salary, department_id, hire_date) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getPosition());
            statement.setDouble(3, employee.getSalary());
            statement.setInt(4, Integer.parseInt(employee.getDepartmentName()));
            statement.setString(5, employee.getHireDate());

            // Thực thi câu lệnh
            rowsInserted = statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return rowsInserted;
    }

    public int deleteEmployee(int employeeId) {
        Connection connection = null;
        PreparedStatement statement = null;
        int rowsDeleted = 0;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            // Xóa nhân viên theo employeeId
            String sql = "DELETE FROM employees WHERE employee_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, employeeId);  // Sử dụng employeeId để xác định bản ghi cần xóa

            // Thực thi câu lệnh
            rowsDeleted = statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return rowsDeleted;
    }


    public int updateEmployee(EmployeeModel employee) {
        Connection connection = null;
        PreparedStatement statement = null;
        int rowsUpdated = 0;
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            // Cập nhật thông tin nhân viên
            String sql = "UPDATE employees SET name = ?, position = ?, salary = ?, department_id = ?, hire_date = ? WHERE employee_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getPosition());
            statement.setDouble(3, employee.getSalary());
            statement.setInt(4, Integer.parseInt(employee.getDepartmentName()));
            statement.setString(5, employee.getHireDate());
            statement.setInt(6, employee.getEmployeeId());  // Dùng ID của nhân viên để xác định bản ghi cần cập nhật

            // Thực thi câu lệnh
            rowsUpdated = statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return rowsUpdated;
    }


    public EmployeeModel getEmployeeById(Integer id) {
        EmployeeModel employeeModel = new EmployeeModel();
        String query = "SELECT e.employee_id, e.name, e.position, e.salary, e.hire_date, d.department_name " +
                "FROM employees e " +
                "LEFT JOIN departments d ON e.department_id = d.department_id WHERE e.employee_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                employeeModel.setEmployeeId(resultSet.getInt("employee_id"));
                employeeModel.setName(resultSet.getString("name"));
                employeeModel.setPosition(resultSet.getString("position"));
                employeeModel.setSalary(resultSet.getDouble("salary"));
                employeeModel.setHireDate(resultSet.getString("hire_date"));
                employeeModel.setDepartmentName(resultSet.getString("department_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employeeModel;
    }

}

