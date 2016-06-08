package com.doctor.resident.dao.Imp;

import com.doctor.common.CommonDAO;
import com.doctor.resident.dao.ResidentInvDAO;
import com.doctor.resident.dto.ResidentInvDTO;
import com.doctor.resident.dto.ResidentInvQuery;
import org.springframework.stereotype.Repository;

/**
 * Created by lzc on 2016/5/19.
 */
@Repository("ResidentInvDAO")
public class ResidentInvDAOImp extends CommonDAO<ResidentInvDTO, ResidentInvQuery> implements ResidentInvDAO{
    @Override
    public String getPrefix() {
        return "com.doctor.resident_inv.";
    }
}
