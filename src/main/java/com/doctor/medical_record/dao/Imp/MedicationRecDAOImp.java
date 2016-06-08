package com.doctor.medical_record.dao.Imp;

import com.doctor.common.CommonDAO;
import com.doctor.medical_record.dao.MedicationRecDAO;
import com.doctor.medical_record.dto.MedicationRecDTO;
import com.doctor.medical_record.dto.MedicationRecQuery;
import org.springframework.stereotype.Repository;

/**
 * Created by lzc on 2016/5/19.
 */
@Repository("MedicationRecDAO")
public class MedicationRecDAOImp extends CommonDAO<MedicationRecDTO, MedicationRecQuery> implements MedicationRecDAO{
    @Override
    public String getPrefix() {
        return "com.doctor.medication_record.";
    }
}
