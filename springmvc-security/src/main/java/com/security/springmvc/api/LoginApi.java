package com.security.springmvc.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wangzhendong
 * @Date: 2019/11/22 15:32
 * @Description:
 */
@RestController
public class LoginApi {

    //登陆成功跳转页面
    @PostMapping(value = "/login-success",produces = "text/plain;charset=UTF-8")
    public String loginSuccess(){
        return "登陆成功";
    }

    /**
     * 测试资源1
     * @return
     */
    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
    public String r1(){
        return " 访问资源1";
    }

    /**
     * 测试资源2
     * @return
     */
    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
    public String r2(){
        return " 访问资源2";
    }
}
