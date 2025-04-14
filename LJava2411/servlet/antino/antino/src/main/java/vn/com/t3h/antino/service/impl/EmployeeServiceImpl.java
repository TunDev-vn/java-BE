package vn.com.t3h.antino.service.impl;


import jakarta.servlet.http.HttpServletRequest;
import vn.com.t3h.antino.dao.DepartmentDAO;
import vn.com.t3h.antino.dao.EmployeeDAO;
import vn.com.t3h.antino.dao.impl.DepartmentDaoImpl;
import vn.com.t3h.antino.dao.impl.EmployeeDAOImpl;
import vn.com.t3h.antino.model.DepartmentModel;
import vn.com.t3h.antino.model.EmployeeModel;
import vn.com.t3h.antino.service.EmployeeService;
import vn.com.t3h.antino.util.MapClientToSeverUtil;
import vn.com.t3h.antino.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public final DepartmentDAO departmentDAO;
    public EmployeeServiceImpl(EmployeeDAO employeeDAO, DepartmentDAO departmentDAO) {
        this.employeeDAO = employeeDAO;
        this.departmentDAO = departmentDAO;
    }

    public static void main(String[] args) {
        // khi khởi tạo bean
        EmployeeDAO beanEmpDao = new EmployeeDAOImpl();
        DepartmentDAO beanDeptDao = new DepartmentDaoImpl();
        // sử dụng DI để tiêm bean vào trong bean EmployeeService
        EmployeeService empService = new EmployeeServiceImpl(beanEmpDao,beanDeptDao);

        // cả qua trình trên gọi là IOC, bản chất và IOC sử dụng DI để tạo ra được các bean
        // sau khi tất cả các bean đã được khởi tạo => spring container bean sẽ quản lý các bean( object) đó

    }

    @Override
    public List<EmployeeModel> getAllEmployees(String name, String salary, String fromDate, String toDate, String position) {

        if (StringUtils.isBlank(name)){
            name = null;
        }
        Long salaryData = StringUtils.toLong(salary);
        if (StringUtils.isBlank(fromDate)){
            fromDate = null;
        }
        if (StringUtils.isBlank(toDate)){
            toDate = null;
        }
        if (StringUtils.isBlank(position)){
            position = null;
        }

        List<EmployeeModel> employeeModels = employeeDAO.getAllEmployees2(name,salaryData,fromDate,toDate,position);
        return employeeModels;

    }

    @Override
    public int saveEmployee(HttpServletRequest request) {
        // convert data từ param sang model class EmployeeModel
        EmployeeModel model = MapClientToSeverUtil.toModel(EmployeeModel.class,request);
        int numberRowExecute = 0;
        if (model.getEmployeeId() != null && model.getEmployeeId() != 0){
            numberRowExecute = employeeDAO.updateEmployee(model);
        }else {
            numberRowExecute = employeeDAO.addEmployee(model);
        }
        return numberRowExecute;
    }

    public int deletedById(Integer id){
        int numberRowDeleted = employeeDAO.deleteEmployee(id);
        return numberRowDeleted;
    }

    public EmployeeModel findById(String id){
        if (id == null || id.equals("")){
            return new EmployeeModel();
        }
        return employeeDAO.getEmployeeById(Integer.parseInt(id));
    }
}