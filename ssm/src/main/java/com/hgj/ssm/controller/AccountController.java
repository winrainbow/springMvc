package com.hgj.ssm.controller;

import com.hgj.ssm.domain.Account;
import com.hgj.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("AccountController findAll");
        List<Account> list = accountService.findAll();

        model.addAttribute("list",list);

        return "list";
    }

}
