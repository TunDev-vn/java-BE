package vn.com.t3h.antino.dao;

import vn.com.t3h.antino.model.DepartmentModel;

public interface DepartmentDAO {

    DepartmentModel getDepartmentByName(String departmentName);
}
