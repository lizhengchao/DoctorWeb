package com.doctor.home_service.service.Imp;

import com.doctor.common.CommonService;
import com.doctor.home_service.dao.HomeServiceDAO;
import com.doctor.home_service.dto.HomeServiceDTO;
import com.doctor.home_service.dto.HomeServiceQuery;
import com.doctor.home_service.service.HomeServiceService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by lzc on 2016/6/8.
 */
@Repository("HomeServiceService")
public class HomeServiceServiceImp extends CommonService<HomeServiceDTO, HomeServiceQuery, HomeServiceDAO>
    implements HomeServiceService{

    @Resource(name="HomeServiceDAO")
    private HomeServiceDAO homeServiceDAO;

    @Override
    public HomeServiceDAO getDao() {
        return homeServiceDAO;
    }
}
