package com.doctor.medical_record.service.Imp;

import com.doctor.common.CommonService;
import com.doctor.common.Result;
import com.doctor.common.StringUtil;
import com.doctor.doctor.dao.DoctorDAO;
import com.doctor.doctor.dto.DoctorDTO;
import com.doctor.doctor.dto.DoctorQuery;
import com.doctor.medical_record.dao.MedicalRecDAO;
import com.doctor.medical_record.dto.MedicalRecDTO;
import com.doctor.medical_record.dto.MedicalRecQuery;
import com.doctor.medical_record.dto.MedicalRecVO;
import com.doctor.medical_record.service.MedicalRecServcie;
import com.doctor.resident.dao.ResidentDAO;
import com.doctor.resident.dto.ResidentDTO;
import com.doctor.resident.dto.ResidentQuery;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzc on 2016/5/19.
 */
@Repository("MedicalRecService")
public class MedicalRecServiceImp extends CommonService<MedicalRecDTO, MedicalRecQuery, MedicalRecDAO>
    implements MedicalRecServcie{

    @Resource(name = "MedicalRecDAO")
    private MedicalRecDAO medicalRecDAO;

    @Resource(name = "ResidentDAO")
    private ResidentDAO residentDAO;

    @Resource(name = "DoctorDAO")
    private DoctorDAO doctorDAO;

    @Override
    public MedicalRecDAO getDao() {
        return medicalRecDAO;
    }

    @Override
    public Result findWithVO(MedicalRecQuery medicalRecQuery) {
        List<Integer> residentDTOIds = new ArrayList<Integer>();
        //取出所有模糊匹配姓名的居民id
        if (StringUtil.isVailtString(medicalRecQuery.getResName())) {
            ResidentQuery residentQuery = new ResidentQuery();
            residentQuery.setNameLike(medicalRecQuery.getResName());
            List<ResidentDTO> residentDTOs = residentDAO.find(residentQuery);
            if (null != residentDTOs && residentDTOs.size()>0){
                for (ResidentDTO residentDTO : residentDTOs){
                    residentDTOIds.add(residentDTO.getId());
                }
            }
        }
        medicalRecQuery.setResIds(residentDTOIds);
        Result<List<MedicalRecDTO>> result = super.find(medicalRecQuery);
        List<MedicalRecVO> recVOs = new ArrayList<MedicalRecVO>();
        //在VO中加入居民姓名和医生姓名
        if (result.getSuccess()){
            for(MedicalRecDTO medicalRecDTO : result.getData()){
                MedicalRecVO medicalRecVO = new MedicalRecVO();
                medicalRecVO.setDTO(medicalRecDTO);
                //查找居民姓名
                ResidentQuery residentQuery = new ResidentQuery();
                residentQuery.setId(medicalRecDTO.getResId());
                ResidentDTO residentDto = residentDAO.get(residentQuery);
                if (null != residentDto){
                    medicalRecVO.setResName(residentDto.getName());
                }
                //查找医生姓名
                DoctorQuery doctorQuery = new DoctorQuery();
                doctorQuery.setId(medicalRecDTO.getDocId());
                DoctorDTO doctorDTO = doctorDAO.get(doctorQuery);
                if (null != doctorDTO){
                    medicalRecVO.setDoctorName(doctorDTO.getName());
                }
                recVOs.add(medicalRecVO);
            }
            return Result.buildSuccessResult(recVOs);
        } else {
            return result;
        }

    }
}
