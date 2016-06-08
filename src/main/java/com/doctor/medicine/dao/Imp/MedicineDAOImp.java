package com.doctor.medicine.dao.Imp;

import com.doctor.common.CommonDAO;
import com.doctor.medicine.dao.MedicineDAO;
import com.doctor.medicine.dto.MedicineDTO;
import com.doctor.medicine.dto.MedicineQuery;
import org.springframework.stereotype.Repository;

/**
 * Created by lzc on 2016/5/24.
 */
@Repository("MedicineDAO")
public class MedicineDAOImp extends CommonDAO<MedicineDTO, MedicineQuery> implements MedicineDAO{
    @Override
    public String getPrefix() {
        return "com.doctor.medicine.";
    }
}
