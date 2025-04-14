package vn.com.t3h.service.impl;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.repository.UserRepository;
import vn.com.t3h.service.LoginService;
import vn.com.t3h.utils.Constant;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String processAfterLoginSuccess(Model model, HttpSession session){
        // lấy ra thông tin user hiện tại đang thực hiện request vừa login xong
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // nếu authentication == null hoặc chưa authen(chưa login)
        if(authentication == null || !authentication.isAuthenticated()){
            // trả ra lỗi
            throw new AuthenticationServiceException("Authentication required");
        }
        // thông tin user hiện tại
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println(String.format("User %s logged in", userDetails.getUsername()));

        // lấy thông tin user từ database
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername());
        // lấy ra danh sách quyền của user
        List<String> roleCode = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        System.out.println(String.format("Role code: %s", roleCode));

        if (userEntity != null) {
            // Lưu vào session
            session.setAttribute("currentUser", userEntity);
        }

        // kiểm tra xem có phải admin không
        boolean isAdmin = roleCode.contains(Constant.PREFIX_ROLE + Constant.ROLE_ADMIN_CODE);
        if(isAdmin){
            return "redirect:/cms/dashboard"; // role admin
        }
        return "redirect:/home"; // role user
    }
}
