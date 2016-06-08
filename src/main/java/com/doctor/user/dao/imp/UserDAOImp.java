package com.doctor.user.dao.imp;

import com.doctor.common.CommonDAO;
import com.doctor.user.dao.UserDAO;
import com.doctor.user.dto.UserDTO;
import com.doctor.user.dto.UserQuery;
import com.doctor.user.dto.UserVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by lzc on 2016/5/17.
 */
@Repository("UserDAO")
public class UserDAOImp extends CommonDAO<UserDTO, UserQuery> implements UserDAO {

    @Override
    public String getPrefix() {
        return "com.doctor.user.";
    }

}