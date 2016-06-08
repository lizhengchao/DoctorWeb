package com.doctor.medical_record.dao.Imp;

import com.doctor.common.CommonDAO;
import com.doctor.medical_record.dao.ResHeaDataDAO;
import com.doctor.medical_record.dto.ResHeaDataDTO;
import com.doctor.medical_record.dto.ResHeaDataQuery;
import com.doctor.resident.dto.ResidentInvQuery;
import org.springframework.stereotype.Repository;

/**
 * Created by lzc on 2016/5/19.
 */
@Repository("ResHeaDataDAO")
public class ResHeaDataDAOImp extends CommonDAO<ResHeaDataDTO, ResHeaDataQuery> implements ResHeaDataDAO{
    @Override
    public String getPrefix() {
        return "com.doctor.resident_health_data.";
    }
}
