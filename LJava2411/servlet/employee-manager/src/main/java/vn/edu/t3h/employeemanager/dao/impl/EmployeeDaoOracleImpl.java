package vn.edu.t3h.employeemanager.dao.impl;

import vn.edu.t3h.employeemanager.dao.EmployeeDao;
import vn.edu.t3h.employeemanager.model.Employee;

import java.util.List;

public class EmployeeDaoOracleImpl implements EmployeeDao {
    @Override
    public List<Employee> getAllEmployee() {
        return null;
    }

    @Override
    public List<Employee> findByCondition(String name, String salary, String fromDate, String toDate, String position) {
        return List.of();
    }
}
