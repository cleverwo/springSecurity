package com.security.springmvc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @Auther: wangzhendong
 * @Date: 2019/11/22 15:03
 * @Description: spring security 配置类
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //定义用户信息服务（查询用户信息）
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("guest").password("guest").authorities("p1").build());
        manager.createUser(User.withUsername("admin").password("admin").authorities("p2").build());
        return manager;
    }
    //密码编码器 用户密码的比对方式，当前为直接比对字符串
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    //安全拦截机制（最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .antMatchers("/r/r1").hasAnyAuthority("p1")
               .antMatchers("/r/r2").hasAnyAuthority("p2")
               .antMatchers("/r/**").authenticated()
               .anyRequest().permitAll()
               .and()
               .formLogin()
               .successForwardUrl("/login-success");
    }
}
