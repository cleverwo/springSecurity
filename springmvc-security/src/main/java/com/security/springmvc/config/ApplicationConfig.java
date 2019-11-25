package com.security.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Auther: wangzhendong
 * @Date: 2019/11/21 14:32
 * @Description: 相当于applicationContext.xml spring容器配置
 */
@Configuration
@ComponentScan(basePackages = "com.security.springmvc",
excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value = Controller.class)})
public class ApplicationConfig{
    //在此配置除了Controller的其它bean，比如：数据库链接池、事务管理器、业务bean等。
}
