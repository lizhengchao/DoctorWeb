package com.doctor.common;


import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lzc on 2016/5/12.
 */
public abstract class CommonDAO<D,Q> extends SqlSessionDaoSupport implements DAO<D, Q>{
    @Autowired
    public  void setSqlSessionFactory (SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(D dept) {return getSqlSession().insert(getPrefix()+"insert", dept);}

    @Override
    public List<D> find(Q query) {
        return getSqlSession().selectList(getPrefix()+"find", query);
    }

    @Override
    public D get(Q query){
        return getSqlSession().selectOne(getPrefix()+"get", query);
    }

    @Override
    public int count(Q query){
        return getSqlSession().selectOne(getPrefix()+"count", query);
    }

    @Override
    public int update(D dept){
        return getSqlSession().update(getPrefix()+"update", dept);
    }

    @Override
    public int delete(Q dept) {
        return getSqlSession().update(getPrefix()+"delete", dept);
    }

    @Override
    public D insertReturnDO(D tempDO) {
        getSqlSession().insert(getPrefix()+"insert", tempDO);
        return tempDO;
    }

    public abstract String getPrefix();

}
