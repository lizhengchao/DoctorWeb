package com.doctor.test.controller;

import com.doctor.test.dto.TestDTO;
import com.doctor.test.service.imp.TestServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by lzc on 2016/4/21.
 */
@Controller
@RequestMapping(value =  "test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource(name = "TestService")
    TestServiceImp testServiceImp;

    @RequestMapping(value = {"insert.do"}, method = RequestMethod.GET)
    public void test(@RequestParam int id, @RequestParam String name){
        logger.debug("111");
        TestDTO testDTO = new TestDTO();
        testDTO.setId(id);
        testDTO.setName(name);
        System.out.println(testServiceImp.add(testDTO));
    }

}
