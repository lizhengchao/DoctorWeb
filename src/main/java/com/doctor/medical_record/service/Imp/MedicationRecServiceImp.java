package com.doctor.medical_record.service.Imp;

import com.doctor.common.CommonService;
import com.doctor.common.Result;
import com.doctor.medical_record.dao.MedicationRecDAO;
import com.doctor.medical_record.dto.MedicationRecDTO;
import com.doctor.medical_record.dto.MedicationRecQuery;
import com.doctor.medical_record.dto.MedicationRecVO;
import com.doctor.medical_record.service.MedicationRecService;
import com.doctor.medicine.dao.MedicineDAO;
import com.doctor.medicine.dto.MedicineDTO;
import com.doctor.medicine.dto.MedicineQuery;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzc on 2016/5/19.
 */
@Repository("MedicationRecService")
public class MedicationRecServiceImp extends CommonService<MedicationRecDTO, MedicationRecQuery, MedicationRecDAO>
    implements MedicationRecService{

    @Resource(name = "MedicationRecDAO")
    private MedicationRecDAO medicationRecDAO;

    @Resource(name = "MedicineDAO")
    private MedicineDAO medicineDAO;

    @Override
    public MedicationRecDAO getDao() {
        return medicationRecDAO;
    }

    @Override
    public Result findResultVO(MedicationRecQuery medicationRecQuery) {
        Result<List<MedicationRecDTO>> result = super.find(medicationRecQuery);
        List<MedicationRecVO> voList = new ArrayList<MedicationRecVO>();
        if (result.getSuccess()){
            for (MedicationRecDTO medicationRecDTO : result.getData()){
                MedicationRecVO medicationRecVO = new MedicationRecVO();
                medicationRecVO.setMedicationRecDTO(medicationRecDTO);

                MedicineQuery medicineQuery = new MedicineQuery();
                medicineQuery.setId(medicationRecDTO.getMedicineId());
                MedicineDTO medicineDTO = medicineDAO.get(medicineQuery);

                medicationRecVO.setMedicationName(medicineDTO.getName());
                medicationRecVO.setType(MedicineDTO.MedicineType.getNameByType(medicineDTO.getType()));
                voList.add(medicationRecVO);
            }
            return Result.buildSuccessResult(voList);
        } else {
            return result;
        }
    }
}
