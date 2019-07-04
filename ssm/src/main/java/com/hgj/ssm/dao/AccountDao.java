package com.hgj.ssm.dao;

import com.hgj.ssm.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mybatis 生成代理对象
 */
@Repository
public interface AccountDao {

    @Select("select * from account")
    public List<Account> findAll();

    @Insert("insert into account (name,money) values (#{name},#{money})")
    public void saveAccount(Account account);
}
