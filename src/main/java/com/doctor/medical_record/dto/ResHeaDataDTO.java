package com.doctor.medical_record.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lzc on 2016/5/19.
 * 体检记录DTO
 */
public class ResHeaDataDTO implements Serializable{
    private Integer id;
    private Integer medicalRecId;
    private Integer statutre;
    private Integer weight;
    private Integer temperature;
    private Integer systolic;
    private Integer diastolic;
    private Integer oxygen;
    private Integer sphygmus;
    private Integer breath;
    private Integer boold;
    private String comment;
    private String reporPtictureURL;
    private Date createTime;
    private Date modifyTime;

    public Integer getBoold() {
        return boold;
    }

    public void setBoold(Integer boold) {
        this.boold = boold;
    }

    public Integer getBreath() {
        return breath;
    }

    public void setBreath(Integer breath) {
        this.breath = breath;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(Integer diastolic) {
        this.diastolic = diastolic;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getOxygen() {
        return oxygen;
    }

    public void setOxygen(Integer oxygen) {
        this.oxygen = oxygen;
    }

    public String getReporPtictureURL() {
        return reporPtictureURL;
    }

    public void setReporPtictureURL(String reporPtictureURL) {
        this.reporPtictureURL = reporPtictureURL;
    }

    public Integer getSphygmus() {
        return sphygmus;
    }

    public void setSphygmus(Integer sphygmus) {
        this.sphygmus = sphygmus;
    }

    public Integer getStatutre() {
        return statutre;
    }

    public void setStatutre(Integer statutre) {
        this.statutre = statutre;
    }

    public Integer getSystolic() {
        return systolic;
    }

    public void setSystolic(Integer systolic) {
        this.systolic = systolic;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
