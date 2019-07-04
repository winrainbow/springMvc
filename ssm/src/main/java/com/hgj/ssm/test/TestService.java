package com.hgj.ssm.test;

import com.hgj.ssm.service.AccountService;
import com.hgj.ssm.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
    @Test
    public void run(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService accountService = (AccountService) ac.getBean("AccountService");
        accountService.findAll();
        // 加载配置文件
        // 执行方法
    }
}
