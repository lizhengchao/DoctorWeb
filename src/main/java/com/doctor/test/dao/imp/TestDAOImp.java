package com.doctor.test.dao.imp;

import com.doctor.test.dao.TestDAO;
import com.doctor.test.dto.TestDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by lzc on 2016/4/24.
 */
@Repository("TestDAO")
public class TestDAOImp extends SqlSessionDaoSupport implements TestDAO{

    @Autowired
    public  void setSqlSessionFactory (SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(TestDTO testDTO) {
        return getSqlSession().insert(getPrefix()+"insert", testDTO);
    }

    public String getPrefix(){
        return "Test.";
    }
}
