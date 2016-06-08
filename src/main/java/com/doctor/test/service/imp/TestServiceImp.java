package com.doctor.test.service.imp;

import com.doctor.test.dao.TestDAO;
import com.doctor.test.dao.imp.TestDAOImp;
import com.doctor.test.dto.TestDTO;
import com.doctor.test.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lzc on 2016/4/21.
 */
@Service(value="TestService")
public class TestServiceImp implements TestService{

    @Resource(name = "TestDAO")
    private TestDAOImp testDAO;

    @Override

    public int add(TestDTO testDTO) {
        return  testDAO.insert(testDTO);
    }
}
