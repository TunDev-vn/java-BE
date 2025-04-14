package vn.com.t3h.antino.service.impl;

import vn.com.t3h.antino.dao.UserDao;
import vn.com.t3h.antino.model.UserModel;
import vn.com.t3h.antino.service.UserService;
import vn.com.t3h.antino.util.PasswordUtils;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserModel findUserByUserAndPassword(String username, String password) {
        String passwordEncrypt = PasswordUtils.encrypt(password);
        return userDao.findUserByUserNameAndPassword(username, passwordEncrypt);
    }
}
