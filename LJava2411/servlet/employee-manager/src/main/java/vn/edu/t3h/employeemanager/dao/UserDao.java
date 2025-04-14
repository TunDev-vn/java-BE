package vn.edu.t3h.employeemanager.dao;


import vn.edu.t3h.employeemanager.model.UserModel;

public interface UserDao {

    UserModel findUserByUserNameAndPassword(String username, String password);
}
