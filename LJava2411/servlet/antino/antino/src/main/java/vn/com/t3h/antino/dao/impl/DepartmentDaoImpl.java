package vn.com.t3h.antino.dao.impl;

import vn.com.t3h.antino.dao.DepartmentDAO;
import vn.com.t3h.antino.model.DepartmentModel;
import vn.com.t3h.antino.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDaoImpl implements DepartmentDAO {

    // Phương thức để lấy department theo tên
    public DepartmentModel getDepartmentByName(String departmentName) {
        if (departmentName == null || departmentName.trim().isEmpty()){
            return null;
        }
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DepartmentModel department = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            connection = DatabaseConnection.getConnection();

            // SQL query để tìm department theo tên
            String sql = "SELECT * FROM departments WHERE department_name = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, departmentName);

            // Thực thi câu lệnh và lấy kết quả
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Tạo đối tượng department từ dữ liệu trong database
                department = new DepartmentModel();
                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                department.setLocation(resultSet.getString("location"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return department;
    }
}
