package com.doctor.resident.service.Imp;

import com.doctor.common.CommonService;
import com.doctor.common.Result;
import com.doctor.community_hospital.dao.CommunityHospitalDAO;
import com.doctor.community_hospital.dto.CommunityHospitalDTO;
import com.doctor.community_hospital.dto.CommunityHospitalQuery;
import com.doctor.resident.dao.ResidentDAO;
import com.doctor.resident.dto.ResidentDTO;
import com.doctor.resident.dto.ResidentQuery;
import com.doctor.resident.dto.ResidentVO;
import com.doctor.resident.service.ResidentService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lzc on 2016/5/19.
 */
@Repository("ResidentService")
public class ResidentServiceImp extends CommonService<ResidentDTO, ResidentQuery, ResidentDAO>
    implements ResidentService{

    @Resource(name = "ResidentDAO")
    private ResidentDAO residentDAO;

    @Resource(name = "CommunityHospitalDAO")
    private CommunityHospitalDAO communityHospitalDAO;

    @Override
    public ResidentDAO getDao() {
        return residentDAO;
    }

    @Override
    public Result findWithVO(ResidentQuery residentQuery) {
        try {
            Result<List<ResidentDTO>> result = super.find(residentQuery);
            List<ResidentVO> voList = new ArrayList<ResidentVO>();
            if (result.getSuccess()) {
                for (ResidentDTO residentDTO : result.getData()) {
                    ResidentVO residentVO = new ResidentVO();
                    residentVO.setResidentDTO(residentDTO);
                    //修改性别属性
                    if (residentDTO.getSex() == 0) {
                        residentVO.setSexName("男");
                    } else {
                        residentVO.setSexName("女");
                    }

                    //添加家庭成员名字
                    if (null != residentDTO.getFamilyMembers()) {
                        String[] familyNumbers = residentDTO.getFamilyMembers().split(",");
                        StringBuilder familyNumbersName = new StringBuilder();
                        ResidentQuery residentQuery1 = new ResidentQuery();
                        for (String familyNumber : familyNumbers) {
                            try {
                                residentQuery1.setId(Integer.valueOf(familyNumber));
                            } catch (NumberFormatException e){
                                break;
                            }
                            ResidentDTO residentDTO1 = residentDAO.get(residentQuery1);
                            if (null != residentDTO1 && null != residentDTO1.getName()) {
                                familyNumbersName.append(residentDTO1.getName());
                                familyNumbersName.append(",");
                            }
                        }
                        residentVO.setFamilMembersName(familyNumbersName.toString());
                    }

                    //添加所属社区名字
                    if (null != residentDTO.getComHosId()){
                        CommunityHospitalQuery communityHospitalQuery = new CommunityHospitalQuery();
                        communityHospitalQuery.setId(residentDTO.getComHosId());
                        CommunityHospitalDTO communityHospitalDTO = communityHospitalDAO.get(communityHospitalQuery);
                        if (null != communityHospitalDTO && null != communityHospitalDTO.getName()){
                            residentVO.setComHosName(communityHospitalDTO.getName());
                        }
                    }
                    voList.add(residentVO);
                }
                return Result.buildSuccessResult(voList);
            } else {
                return result;
            }
        } catch (Exception e){
            e.printStackTrace();
            return new Result(null, false, "服务器异常", 500);
        }
    }
}
