package com.security.springmvc.model;

import lombok.Data;

/**
 * @Auther: wangzhendong
 * @Date: 2019/11/21 15:42
 * @Description: 用户认证请求
 */
@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
