package com.doctor.medical_record.service;

import com.doctor.common.Result;
import com.doctor.common.Service;
import com.doctor.medical_record.dto.MedicationRecDTO;
import com.doctor.medical_record.dto.MedicationRecQuery;

import java.util.List;

/**
 * Created by lzc on 2016/5/19.
 */
public interface MedicationRecService extends Service<MedicationRecDTO, MedicationRecQuery>{

    public Result<List> findResultVO(MedicationRecQuery medicationRecQuery);
}
