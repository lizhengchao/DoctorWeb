package com.doctor.home_service.service;

import com.doctor.common.Result;
import com.doctor.common.Service;
import com.doctor.home_service.dto.HomeServiceDTO;
import com.doctor.home_service.dto.HomeServiceQuery;

import java.util.List;

/**
 * Created by lzc on 2016/6/8.
 */
public interface HomeServiceService extends Service<HomeServiceDTO, HomeServiceQuery>{

    public Result<List> findWithVO(HomeServiceQuery homeServiceQuery);
}
