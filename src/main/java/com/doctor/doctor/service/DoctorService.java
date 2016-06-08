package com.doctor.doctor.service;

import com.doctor.common.Result;
import com.doctor.common.Service;
import com.doctor.doctor.dto.DoctorDTO;
import com.doctor.doctor.dto.DoctorQuery;
import com.doctor.doctor.dto.DoctorVO;

/**
 * Created by lzc on 2016/5/19.
 */
public interface DoctorService extends Service<DoctorDTO, DoctorQuery> {
    public Result findWithVO(DoctorQuery doctorQuery);
}
