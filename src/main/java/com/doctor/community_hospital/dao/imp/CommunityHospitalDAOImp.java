package com.doctor.community_hospital.dao.imp;

import com.doctor.common.CommonDAO;
import com.doctor.community_hospital.dao.CommunityHospitalDAO;
import com.doctor.community_hospital.dto.CommunityHospitalDTO;
import com.doctor.community_hospital.dto.CommunityHospitalQuery;
import org.springframework.stereotype.Repository;

/**
 * Created by lzc on 2016/5/12.
 */
@Repository("CommunityHospitalDAO")
public class CommunityHospitalDAOImp extends CommonDAO<CommunityHospitalDTO, CommunityHospitalQuery> implements CommunityHospitalDAO{

    @Override
    public String getPrefix() {
        return "com.doctor.community_hospital.";
    }
}
