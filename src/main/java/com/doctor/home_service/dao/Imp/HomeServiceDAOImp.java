package com.doctor.home_service.dao.Imp;

import com.doctor.common.CommonDAO;
import com.doctor.home_service.dao.HomeServiceDAO;
import com.doctor.home_service.dto.HomeServiceDTO;
import com.doctor.home_service.dto.HomeServiceQuery;
import org.springframework.stereotype.Repository;

/**
 * Created by lzc on 2016/6/8.
 */
@Repository("HomeServiceDAO")
public class HomeServiceDAOImp extends CommonDAO<HomeServiceDTO, HomeServiceQuery> implements HomeServiceDAO{
    @Override
    public String getPrefix() {
        return "com.doctor.home_service";
    }
}
