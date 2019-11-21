package com.security.springmvc.service;

import com.security.springmvc.model.AuthenticationRequest;
import com.security.springmvc.model.UserDto;
import org.springframework.stereotype.Service;

/**
 * @Auther: wangzhendong
 * @Date: 2019/11/21 15:49
 * @Description:
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        return null;
    }
}
