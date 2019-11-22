package com.security.springmvc.service;

import com.security.springmvc.model.AuthenticationRequest;
import com.security.springmvc.model.UserDto;

/**
 * @Auther: wangzhendong
 * @Date: 2019/11/21 15:41
 * @Description: 用户登陆认证
 */
public interface AuthenticationService {
    /**
     * 用户认证
     * @param authenticationRequest 用户认证请求，账号和密码
     * @return 认证成功的用户信息
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
