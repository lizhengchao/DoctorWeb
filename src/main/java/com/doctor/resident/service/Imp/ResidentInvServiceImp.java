package com.doctor.resident.service.Imp;

import com.doctor.common.CommonService;
import com.doctor.resident.dao.ResidentInvDAO;
import com.doctor.resident.dto.ResidentInvDTO;
import com.doctor.resident.dto.ResidentInvQuery;
import com.doctor.resident.service.ResidentInvService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by lzc on 2016/5/19.
 */
@Repository("ResidentInvService")
public class ResidentInvServiceImp extends CommonService<ResidentInvDTO, ResidentInvQuery, ResidentInvDAO>
    implements ResidentInvService{

    @Resource(name = "ResidentInvDAO")
    private ResidentInvDAO residentInvDAO;

    @Override
    public ResidentInvDAO getDao() {
        return residentInvDAO;
    }
}
