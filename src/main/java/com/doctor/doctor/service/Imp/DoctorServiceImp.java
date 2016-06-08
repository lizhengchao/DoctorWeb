package com.doctor.doctor.service.Imp;

import com.doctor.common.CommonService;
import com.doctor.common.Result;
import com.doctor.community_hospital.dao.CommunityHospitalDAO;
import com.doctor.community_hospital.dto.CommunityHospitalDTO;
import com.doctor.community_hospital.dto.CommunityHospitalQuery;
import com.doctor.doctor.dao.DoctorDAO;
import com.doctor.doctor.dto.DoctorDTO;
import com.doctor.doctor.dto.DoctorQuery;
import com.doctor.doctor.dto.DoctorVO;
import com.doctor.doctor.service.DoctorService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzc on 2016/5/19.
 */
@Repository("DoctorService")
public class DoctorServiceImp extends CommonService<DoctorDTO, DoctorQuery,DoctorDAO>
        implements DoctorService{

    @Resource(name = "DoctorDAO")
    private DoctorDAO doctorDAO;

    @Resource(name = "CommunityHospitalDAO")
    private CommunityHospitalDAO communityHospitalDAO;

    @Override
    public DoctorDAO getDao() {
        return doctorDAO;
    }

    @Override
    public Result findWithVO(DoctorQuery doctorQuery) {
        Result<List<DoctorDTO>> result = super.find(doctorQuery);
        if (!result.getSuccess()){
            return result;
        } else {
            List<DoctorVO> doctorVOs = new ArrayList<DoctorVO>();
            for (DoctorDTO doctorDTO : result.getData()){
                DoctorVO doctorVO = new DoctorVO(doctorDTO);
                //塞入职称名和就诊类型名
                doctorVO.setPracticeTypeName(DoctorDTO.PracticeType.getNameByType(doctorVO.getPracticeType()));
                doctorVO.setTitleName(DoctorDTO.TitleType.getNameByType(doctorVO.getTitle()));
                //塞入医院名
                CommunityHospitalQuery communityHospitalQuery = new CommunityHospitalQuery();
                communityHospitalQuery.setId(doctorVO.getComHosId());
                CommunityHospitalDTO communityHospitalDTO = communityHospitalDAO.get(communityHospitalQuery);
                if (null != communityHospitalDTO){
                    doctorVO.setComHosName(communityHospitalDTO.getName());
                }
                doctorVOs.add(doctorVO);
            }
            return Result.buildSuccessResult(doctorVOs);
        }
    }
}
