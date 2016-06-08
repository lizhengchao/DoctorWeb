package com.doctor.medical_record.dto;

import com.doctor.common.BaseQuery;

/**
 * Created by lzc on 2016/5/19.
 * 体检记录Query
 */
public class ResHeaDataQuery extends BaseQuery{
    private Integer id;
    private Integer medicalRecId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedicalRecId() {
        return medicalRecId;
    }

    public void setMedicalRecId(Integer medicalRecId) {
        this.medicalRecId = medicalRecId;
    }
}
