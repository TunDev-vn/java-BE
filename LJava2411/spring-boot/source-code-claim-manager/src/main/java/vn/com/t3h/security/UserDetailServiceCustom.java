package vn.com.t3h.security;

import ch.qos.logback.core.util.StringUtil;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.com.t3h.entity.RoleEntity;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.repository.RoleRepository;
import vn.com.t3h.repository.UserRepository;
import vn.com.t3h.utils.Constant;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceCustom implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (StringUtils.isEmpty(username)){
            throw new UsernameNotFoundException("username is empty");
        }

        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null){
            throw new UsernameNotFoundException("username not found");
        }

//        Set<RoleEntity> roles = userEntity.getRoles();

        Set<RoleEntity> roles = roleRepository.findByUserName(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>(); //Quyền của spring security
        for (RoleEntity role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(Constant.PREFIX_ROLE + role.getCode()));
        }

        UserDetails userDetails = new User(userEntity.getUsername(), userEntity.getPassword(), grantedAuthorities);

        return userDetails;
    }
}
