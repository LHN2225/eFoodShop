package com.example.userservice.config;

import com.example.userservice.service.CustomUserDetails;
import com.example.userservice.service.CustomUserDetailsService;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // Get AuthenticationManager bean
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users/**").authenticated()
                .antMatchers("/test/**").hasAuthority("Customer")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .permitAll()
                .loginPage("/")
                .usernameParameter("email")
                .passwordParameter("password")
                //.defaultSuccessUrl("http://localhost:8765/manager-info/get-all-food")
                .successHandler((request, response, authentication) -> {
                    CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
                    Long roleId = customUserDetails.getUser().getRoleId();
                    Long userID = customUserDetails.getUser().getId();

                    String url = "";

                    if (roleId == 1) {
                        url = "http://localhost:8765/food/view-food";
                    } else if (roleId == 2) {
                        response.setHeader("Authorization", "Bearer " + "123456789");
                        url = "http://localhost:8765/shipper/home/redirect/" + userID;
                    } else if (roleId == 3) {
                        url = "http://localhost:8765/manager-info/get-all-food";
                    } else {
                        System.out.println("http://localhost:8765/403");
                    }

                    response.sendRedirect(url);

                })
                .and()
                .logout().logoutSuccessUrl("/").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/api/**");
    }
}