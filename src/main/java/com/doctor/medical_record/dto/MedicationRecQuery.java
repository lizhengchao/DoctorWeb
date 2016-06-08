package com.doctor.medical_record.dto;

import com.doctor.common.BaseQuery;

/**
 * Created by lzc on 2016/5/19.
 * 用药记录Query
 */
public class MedicationRecQuery extends BaseQuery{
    private Integer id;
    private Integer medicalRecId;
    private Integer medicineId;

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

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }
}
