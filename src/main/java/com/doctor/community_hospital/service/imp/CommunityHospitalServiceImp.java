package com.doctor.community_hospital.service.imp;

import com.doctor.common.CommonService;
import com.doctor.common.Result;
import com.doctor.community_hospital.dao.CommunityHospitalDAO;
import com.doctor.community_hospital.dto.CommunityHospitalDTO;
import com.doctor.community_hospital.dto.CommunityHospitalQuery;
import com.doctor.community_hospital.service.CommunityHospitalService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lzc on 2016/5/12.
 */
@Repository("CommunityHospitalService")
public class CommunityHospitalServiceImp extends CommonService<CommunityHospitalDTO, CommunityHospitalQuery,CommunityHospitalDAO>
        implements CommunityHospitalService{

    @Resource(name = "CommunityHospitalDAO")
    private CommunityHospitalDAO communityHospitalDAO;

    @Override
    public CommunityHospitalDAO getDao() {
        return communityHospitalDAO;
    }

    @Override
    public Result<Integer> insert(CommunityHospitalDTO temp) {
        try {
            //不能有同名医院
            CommunityHospitalQuery communityHospitalQuery = new CommunityHospitalQuery();
            communityHospitalQuery.setName(temp.getName());
            if (null != getDao().get(communityHospitalQuery)){
                return new Result<Integer>(null, false, "该医院名已存在", 500);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<Integer>(null, false, "服务器内部错误", 500);
        }
        return super.insert(temp);
    }
}
