package com.hgj.ssm.test;

import com.hgj.ssm.dao.AccountDao;
import com.hgj.ssm.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDao {
    @Test
    public void run() throws IOException {
        // 1 加载mybatis 配置文件
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);

        SqlSession sqlSession = factory.openSession();
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        List<Account> all = dao.findAll();
        if(all!=null){
            System.out.println("test all.size="+all.size());
        }else{
            System.out.println("test all is null");
        }
        sqlSession.close();
        stream.close();
    }
}
