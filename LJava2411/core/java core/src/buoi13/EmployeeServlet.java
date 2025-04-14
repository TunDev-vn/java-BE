package buoi13;


import java.lang.reflect.Field;

public class EmployeeServlet {

    private EmployeeService employeeService;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        EmployeeServlet servlet = new EmployeeServlet();
        System.out.println("servlet before: " + servlet.toString());
        Class<?> servletClass = servlet.getClass();

        // lấy ra field muốn khởi tạo
        Field filedEmpService = servletClass.getDeclaredField("employeeService");
        // set value cho filed
        filedEmpService.setAccessible(true);
        EmployeeService service = new EmployeeService();
        filedEmpService.set(servlet,service);
        System.out.println("servlet after: " + servlet.toString());

    }

    @Override
    public String toString() {
        return "EmployeeServlet{" +
                "employeeService=" + employeeService +
                '}';
    }
}
