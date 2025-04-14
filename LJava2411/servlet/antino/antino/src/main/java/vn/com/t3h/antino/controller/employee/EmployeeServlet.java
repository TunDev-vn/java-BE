package vn.com.t3h.antino.controller.employee;


import com.oracle.wls.shaded.org.apache.bcel.classfile.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.t3h.antino.dao.impl.DepartmentDaoImpl;
import vn.com.t3h.antino.dao.impl.EmployeeDAOImpl;
import vn.com.t3h.antino.model.EmployeeModel;
import vn.com.t3h.antino.service.EmployeeService;
import vn.com.t3h.antino.service.impl.EmployeeServiceImpl;
import vn.com.t3h.antino.util.Constants;

import java.io.IOException;
import java.util.List;

@WebServlet("/cms/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService;

//    public EmployeeServlet() {
//        employeeService = new EmployeeServiceImpl(new EmployeeDAOImpl(),new DepartmentDaoImpl());
//    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String salary = request.getParameter("salary");
        String fromDate = request.getParameter("fromDate");
        String toDate = request.getParameter("toDate");
        String position = request.getParameter("position");
        List<EmployeeModel> employeeModels = employeeService.getAllEmployees(name,salary,fromDate,toDate,position);
        // Gửi dữ liệu nhân viên vào JSP
        request.setAttribute("employeeModels", employeeModels);
        request.getRequestDispatcher("/cms/employees.jsp").forward(request, response);
    }
}