package com.hgj.ssm.service;

import com.hgj.ssm.domain.Account;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();

    public void saveAccount(Account account);
}
