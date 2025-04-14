package vn.com.t3h.antino.service;

import vn.com.t3h.antino.model.UserModel;

public interface UserService {

    UserModel findUserByUserAndPassword(String username, String password);
}
