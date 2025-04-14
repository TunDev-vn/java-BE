package vn.edu.t3h.employeemanager.service;

import vn.edu.t3h.employeemanager.model.Employee;

import java.util.List;

/*
áp dụng trong servlet, spring mvc, spring boot
- Tại sao trong mỗi package như service hoặc dao luôn tồn lại
các interface để khai báo các method, và class Impl của interface đấy để triển khai các method đấy ?
đây cũng là 1 pattern được sử dụng trong Collection
vd:
Interface List có các class Impl ArrayList, ArrayQueue...
 */
public interface EmployeeService {

    List<Employee> getAllEmployee();

    List<Employee> findByFilter(String name,String salary,String fromDate,String toDate,String position);
}
