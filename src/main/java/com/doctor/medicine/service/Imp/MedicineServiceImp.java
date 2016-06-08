package com.doctor.medicine.service.Imp;

import com.doctor.common.CommonService;
import com.doctor.medicine.dao.MedicineDAO;
import com.doctor.medicine.dto.MedicineDTO;
import com.doctor.medicine.dto.MedicineQuery;
import com.doctor.medicine.service.MedicineService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by lzc on 2016/5/24.
 */
@Repository("MedicineService")
public class MedicineServiceImp extends CommonService<MedicineDTO, MedicineQuery, MedicineDAO> implements MedicineService{

    @Resource(name = "MedicineDAO")
    private MedicineDAO medicineDAO;

    @Override
    public MedicineDAO getDao() {
        return medicineDAO;
    }
}
