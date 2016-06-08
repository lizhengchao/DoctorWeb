package com.doctor.medical_record.service;

import com.doctor.common.Result;
import com.doctor.common.Service;
import com.doctor.medical_record.dto.MedicalRecDTO;
import com.doctor.medical_record.dto.MedicalRecQuery;

/**
 * Created by lzc on 2016/5/19.
 */
public interface MedicalRecServcie extends Service<MedicalRecDTO, MedicalRecQuery>{
    /*
    * 根据患者模糊姓名以及就诊开始时间和结束时间查询就诊记录
    */
    public Result findWithVO(MedicalRecQuery medicalRecQuery);
}
