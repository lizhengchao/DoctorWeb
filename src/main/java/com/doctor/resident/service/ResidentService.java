package com.doctor.resident.service;

import com.doctor.common.Result;
import com.doctor.common.Service;
import com.doctor.resident.dto.ResidentDTO;
import com.doctor.resident.dto.ResidentQuery;

/**
 * Created by lzc on 2016/5/19.
 */
public interface ResidentService extends Service<ResidentDTO, ResidentQuery>{
    public Result findWithVO(ResidentQuery residentQuery);
}
