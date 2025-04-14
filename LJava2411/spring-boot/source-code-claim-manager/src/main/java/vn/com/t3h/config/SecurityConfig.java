package vn.com.t3h.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import vn.com.t3h.utils.Constant;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(data -> data.disable())
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("/cms/**").hasAnyRole(Constant.ROLE_ADMIN_CODE) // có thể truy cập tất cả các đường dẫn bắt đầu /cms/
                            .requestMatchers("/", "/home", "/login", "/logout", "/process-login").permitAll() // tất cả các đường dẫn này có thể truy cập mà ko cần login
                            .requestMatchers(
                                    "/assets/**", "/fonts/**", "/homeguest_files/**",
                                    "/js/**", "/libs/**", "/loginmetlife/**",
                                    "/page404/**", "/scss/**", "/tasks/**", "/css/**", "/images/**","/cms-rs/**","/file/**").permitAll()
                            .anyRequest().authenticated();
                })
                .formLogin(
                        formLogin ->
                                formLogin.loginPage("/login")
                                        .loginProcessingUrl("/process-login")
                                        .defaultSuccessUrl("/process-after-login-success", true) //url được điều hướng đến khi login thành công
                                        .failureUrl("/login?error=true")
                )
                // khi nhấn logout thì điều hướng về trang logout và xóa session của user hiện tại
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"));


        return http.build();
    }

//    public static void main(String[] args) {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        System.out.println("password admin: " + passwordEncoder.encode("admin"));
//        System.out.println("password user: " + passwordEncoder.encode("user"));
//    }
}
