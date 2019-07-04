package com.hgj.ssm.service.impl;

import com.hgj.ssm.dao.AccountDao;
import com.hgj.ssm.domain.Account;
import com.hgj.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("AccountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    public List<Account> findAll() {
        System.out.println("service finaAll");

        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("service saveAccount");
        accountDao.saveAccount(account);

    }
}
