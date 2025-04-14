package vn.com.t3h.antino.dao;

import vn.com.t3h.antino.model.UserModel;

public interface UserDao {

    UserModel findUserByUserNameAndPassword(String username, String password);
}
