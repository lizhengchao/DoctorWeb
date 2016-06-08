package com.doctor.medical_record.dao.Imp;

import com.doctor.common.CommonDAO;
import com.doctor.medical_record.dao.MedicalRecDAO;
import com.doctor.medical_record.dto.MedicalRecDTO;
import com.doctor.medical_record.dto.MedicalRecQuery;
import org.springframework.stereotype.Repository;

/**
 * Created by lzc on 2016/5/19.
 */
@Repository("MedicalRecDAO")
public class MedicalRecDAOImp extends CommonDAO<MedicalRecDTO, MedicalRecQuery> implements MedicalRecDAO{
    @Override
    public String getPrefix() {
        return "com.doctor.medical_record.";
    }
}
