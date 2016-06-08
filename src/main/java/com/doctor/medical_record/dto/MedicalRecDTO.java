package com.doctor.medical_record.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lzc on 2016/5/19.
 * 电子病历DTO
 **/

public class MedicalRecDTO implements Serializable{
    private Integer id;
    private Integer resId;
    private Integer docId;
    private Integer resHeaDatId; //体检记录ID
    private String chiefComplaint; //病人主诉
    private String suggest; //医生建议
    private String medicationRecIds; //用药记录ID组，以 , 分割
    private Date createTime;
    private Date modifyTime;

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicationRecIds() {
        return medicationRecIds;
    }

    public void setMedicationRecIds(String medicationRecIds) {
        this.medicationRecIds = medicationRecIds;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getResHeaDatId() {
        return resHeaDatId;
    }

    public void setResHeaDatId(Integer resHeaDatId) {
        this.resHeaDatId = resHeaDatId;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }
}
