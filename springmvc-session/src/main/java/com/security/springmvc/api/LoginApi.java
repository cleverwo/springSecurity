package com.security.springmvc.api;

import com.security.springmvc.model.AuthenticationRequest;
import com.security.springmvc.model.UserDto;
import com.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Auther: wangzhendong
 * @Date: 2019/11/21 14:53
 * @Description:
 */
@RestController
public class LoginApi {
    @Autowired
    AuthenticationService authenticationService;
    //登陆
    @PostMapping(value = "/login", produces = "application/json;charset=Utf-8")
    public String login(AuthenticationRequest authenticationRequest, HttpSession session){
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        //存储session
        session.setAttribute(UserDto.SESSION_USER_KEY,userDto);
        return userDto.getUsername() +"登录成功";
    }

    //退出
    @GetMapping(value = "/logout", produces = "application/json;charset=Utf-8")
    public String logout(HttpSession session){
        session.invalidate();
        return "推出成功";
    }

    //测试session认证方式
    @GetMapping(value = "/r/r1", produces = "application/json;charset=Utf-8")
    public String test1(HttpSession session){
        String fullname = null;
        Object object = session.getAttribute(UserDto.SESSION_USER_KEY);
        if(object == null){
            fullname = "匿名";
        }else{
            UserDto userDto = (UserDto) object;
            fullname = userDto.getFullname();
        }
        return fullname+"访问资源r1";
    }

    //测试用户权限
    @GetMapping(value = "/r/r2", produces = "application/json;charset=Utf-8")
    public String test2(HttpSession session){
        String fullname = null;
        Object userObj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if(userObj != null){
            fullname = ((UserDto)userObj).getFullname();
        }else{
            fullname = "匿名";
        }
        return fullname + " 访问资源2";
    }
}
