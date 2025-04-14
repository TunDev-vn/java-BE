package buoi13.jdbc;

import java.sql.*;

public class Main {

    // Thông tin kết nối đến cơ sở dữ liệu
    public static final String url = "jdbc:mysql://localhost:3306/quanlynhansu";
    public static final String userName = "root";
    public static final String password = "root";

    public static void main(String[] args) {
        // Tạo connection đến database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,userName,password);
            System.out.println("Kết nối cơ sở dữ liệu thành công");
            showAllDepartment(connection);
            System.out.println("Bắt đầu thêm dữ liệu mới");
            String sqlInsert = "INSERT INTO departments (department_id, department_name, location) value (?, ?, ?)";
            System.out.println("Tạo ra câu sql thực thi trong database: " + sqlInsert);
            PreparedStatement preparedStatementInsert = connection.prepareStatement(sqlInsert);
            System.out.println("Bắt đầu set các dữ liệu vào các tham số ? theo thứ tự từ trái qua phải, bắt đầu từ 1 ");
            preparedStatementInsert.setInt(1,5); // parameterIndex: index thứ tự tương ứng department_id, 5: value truyền vào
            preparedStatementInsert.setString(2,"AI"); // 2: index tương ứng department_name, "AI" value truyền vào
            preparedStatementInsert.setString(3,"Hồ Chí Minh");

            int numberRowInsert = preparedStatementInsert.executeUpdate(); // thực thi câu query
            System.out.println("Số lượng data vừa thêm là: " + numberRowInsert);

            showAllDepartment(connection);
        } catch (SQLException e) {
            System.out.println("Connection error");
            throw new RuntimeException(e);
        }finally {
            // đóng connection sau khi thực thi thành công, quan trọng!
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    private static void showAllDepartment(Connection connection) throws SQLException {
        System.out.println("Tạo ra câu query");
        String sql = "select * from departments";
        System.out.println("Biến string " + sql + " thành câu sql");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("thực hiện query trong database");
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("Query tới database thành công, đã nhận đưược kết quả, thực hiện duyệt kết quả");
        while (resultSet.next()){
            System.out.println("---------------------------------------");
            int depId = resultSet.getInt("department_id");
            System.out.println("department_id: " + depId);
            String depName = resultSet.getString("department_name");
            System.out.println("department_name: " + depName);
            String location = resultSet.getString("location");
            System.out.println("location: " + location);
        }
    }
}
