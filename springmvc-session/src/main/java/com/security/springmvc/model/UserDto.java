package com.security.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @Auther: wangzhendong
 * @Date: 2019/11/21 15:42
 * @Description: 用户信息
 */
@Data
@AllArgsConstructor
public class UserDto {
    // session 中用户信息的key
    public static final String SESSION_USER_KEY = "_user";
    //用户身份信息
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;

    private Set<String> authorities;


}
