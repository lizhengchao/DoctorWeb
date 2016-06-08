package com.doctor.doctor.dao.Imp;

import com.doctor.common.CommonDAO;
import com.doctor.doctor.dao.DoctorDAO;
import com.doctor.doctor.dto.DoctorDTO;
import com.doctor.doctor.dto.DoctorQuery;
import org.springframework.stereotype.Repository;

/**
 * Created by lzc on 2016/5/19.
 */
@Repository("DoctorDAO")
public class DoctorDAOImp extends CommonDAO<DoctorDTO, DoctorQuery> implements DoctorDAO{
    @Override
    public String getPrefix() {
        return "com.doctor.doctor.";
    }
}
