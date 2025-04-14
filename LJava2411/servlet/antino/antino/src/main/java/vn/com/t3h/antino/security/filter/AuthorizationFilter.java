package vn.com.t3h.antino.security.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.t3h.antino.dao.impl.RoleDaoImpl;
import vn.com.t3h.antino.model.RoleModel;
import vn.com.t3h.antino.model.UserModel;
import vn.com.t3h.antino.service.RoleService;
import vn.com.t3h.antino.service.impl.RoleServiceImpl;
import vn.com.t3h.antino.util.Constants;
import vn.com.t3h.antino.util.SessionUtil;

import java.io.IOException;
@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private RoleService roleService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        roleService = new RoleServiceImpl(new RoleDaoImpl());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        UserModel currentUser = (UserModel) request.getSession().getAttribute(SessionUtil.SESSION_ID_CURRENT_USER);

        String uri = request.getRequestURI();
        if (uri.startsWith("/cms")){
            if (currentUser != null){
                RoleModel roleCurrentUser = roleService.getRoleById(currentUser.getRoleId());
                if (roleCurrentUser != null && roleCurrentUser.getCode().equalsIgnoreCase(Constants.ROLE.ROLE_ADMIN.name())){
                    filterChain.doFilter(request, response);
                }else {
                    response.sendRedirect("/login?message="+ Constants.PERMISSION_DENIED);
                }
            }else {
                response.sendRedirect("/login?message="+Constants.DONT_LOGIN);
            }
        }else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
