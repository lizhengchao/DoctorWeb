package com.doctor.home_service.dto;

import java.util.Date;

/**
 * Created by lzc on 2016/6/8.
 */
public class HomeServiceDTO {
    private Integer id;
    private Integer resId;
    private Integer docId;
    private String requestInfo;
    private Integer phoneNumber;
    private String homeAddress;
    private Integer medicalRecId;
    private Date requestTime;
    private Date solveTime;

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(String requestInfo) {
        this.requestInfo = requestInfo;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Date getSolveTime() {
        return solveTime;
    }

    public void setSolveTime(Date solveTime) {
        this.solveTime = solveTime;
    }
}
