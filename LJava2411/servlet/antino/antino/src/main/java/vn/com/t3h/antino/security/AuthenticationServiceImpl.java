package vn.com.t3h.antino.security;


import jakarta.servlet.http.HttpServletRequest;
import vn.com.t3h.antino.dao.impl.RoleDaoImpl;
import vn.com.t3h.antino.dao.impl.UserDaoImpl;
import vn.com.t3h.antino.model.RoleModel;
import vn.com.t3h.antino.model.UserModel;
import vn.com.t3h.antino.service.RoleService;
import vn.com.t3h.antino.service.UserService;
import vn.com.t3h.antino.service.impl.RoleServiceImpl;
import vn.com.t3h.antino.service.impl.UserServiceImpl;
import vn.com.t3h.antino.util.Constants;
import vn.com.t3h.antino.util.SessionUtil;

public class AuthenticationServiceImpl implements AuthenticationService {
    private UserService userService;
    private RoleService roleService;
    public AuthenticationServiceImpl() {
        this.userService = new UserServiceImpl(new UserDaoImpl());
        this.roleService = new RoleServiceImpl(new RoleDaoImpl());
    }
    @Override
    public String login(String username, String password,HttpServletRequest request) {
        //Authentication: Kiểm tra username, password có tồn tại trong database không
        UserModel userModel = userService.findUserByUserAndPassword(username, password);
        if (userModel == null) {
            return "/login?message=loginError";
        }
        request.getSession().setAttribute(SessionUtil.SESSION_ID_CURRENT_USER, userModel);
        // Authorization: Kiểm tra user nếu có quyền Admin sẽ cho phép truy cập vào trang quản lý employee
        RoleModel roleModel = roleService.getRoleById(userModel.getRoleId());
        String urlRedirect = "";
        if (Constants.ROLE.ROLE_ADMIN.name().equalsIgnoreCase(roleModel.getCode())) {
            urlRedirect = "/cms/employees";
        } else if (Constants.ROLE.ROLE_USER.name().equalsIgnoreCase(roleModel.getCode())) {
            urlRedirect = "/home";
        }
        return urlRedirect;
    }
}

