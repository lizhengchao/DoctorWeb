package com.doctor.medical_record.service.Imp;

import com.doctor.common.CommonService;
import com.doctor.medical_record.dao.ResHeaDataDAO;
import com.doctor.medical_record.dto.ResHeaDataDTO;
import com.doctor.medical_record.dto.ResHeaDataQuery;
import com.doctor.medical_record.service.ResHeaDataService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by lzc on 2016/5/19.
 */
@Repository("ResHeaDataService")
public class ResHeaDataServiceImp extends CommonService<ResHeaDataDTO, ResHeaDataQuery, ResHeaDataDAO>
    implements ResHeaDataService{

    @Resource(name = "ResHeaDataDAO")
    private ResHeaDataDAO resHeaDataDAO;

    @Override
    public ResHeaDataDAO getDao() {
        return resHeaDataDAO;
    }
}
