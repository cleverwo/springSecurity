package com.security.springmvc.service;

import com.security.springmvc.model.AuthenticationRequest;
import com.security.springmvc.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: wangzhendong
 * @Date: 2019/11/21 15:49
 * @Description: 用户登陆认证iml
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    //用户信息
    private Map<String,UserDto> userMap = new HashMap<>();
    {
        //配置权限资源
        Set<String> authorities1 = new HashSet<>();
        authorities1.add("p1");//这个p1我们人为让它和/r/r1对应
        Set<String> authorities2 = new HashSet<>();
        authorities2.add("p2");//这个p2我们人为让它和/r/r2对应
        //初始化用户信息，分配权限
        userMap.put("guest",new UserDto("1010","guest","123","guest","133443",authorities1));
        userMap.put("admin",new UserDto("1011","admin","admin","admin","144553",authorities2));
    }

    /**
     * 登陆认证的过程，校验用户名和密码
     * @param authenticationRequest 用户认证请求，账号和密码
     * @return
     */
    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        //1.判空：校验参数是否为空
        if(authenticationRequest == null
                || StringUtils.isEmpty(authenticationRequest.getUsername())
                || StringUtils.isEmpty(authenticationRequest.getPassword())){
            throw new RuntimeException("账号和密码为空");
        }
        //2.获取用户信息：根据账号去查询数据库,这里测试程序采用模拟方法
        UserDto user = getUserDto(authenticationRequest.getUsername());
        //3.校验用户信息：判断用户是否为空
        if(user == null){
            throw new RuntimeException("查询不到该用户");
        }
        //校验密码
        if(!authenticationRequest.getPassword().equals(user.getPassword())){
            throw new RuntimeException("账号或密码错误");
        }
        //认证通过，返回用户身份信息
        return user;
    }

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    private UserDto getUserDto(String username) {
        return userMap.get(username);
    }
}
