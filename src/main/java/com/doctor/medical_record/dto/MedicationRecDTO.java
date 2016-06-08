package com.doctor.medical_record.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lzc on 2016/5/19.
 * 用药记录DTO
 */
public class MedicationRecDTO implements Serializable{
    private Integer id;
    private Integer medicalRecId;
    private Integer medicineId;
    private Integer amount;
    private String medicationRule;
    private Date createTime;
    private Date modifyTime;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

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

    public String getMedicationRule() {
        return medicationRule;
    }

    public void setMedicationRule(String medicationRule) {
        this.medicationRule = medicationRule;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
