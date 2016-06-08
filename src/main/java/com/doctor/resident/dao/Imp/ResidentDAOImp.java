package com.doctor.resident.dao.Imp;

import com.doctor.common.CommonDAO;
import com.doctor.common.CommonService;
import com.doctor.resident.dao.ResidentDAO;
import com.doctor.resident.dto.ResidentDTO;
import com.doctor.resident.dto.ResidentQuery;
import org.springframework.stereotype.Repository;

/**
 * Created by lzc on 2016/5/19.
 */
@Repository("ResidentDAO")
public class ResidentDAOImp extends CommonDAO<ResidentDTO, ResidentQuery> implements ResidentDAO{
    @Override
    public String getPrefix() {
        return "com.doctor.resident.";
    }
}
