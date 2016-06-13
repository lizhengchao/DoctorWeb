package com.doctor.home_service.dto;

import java.util.Date;

/**
 * Created by lzc on 2016/6/8.
 */
public class HomeServiceDTO {
    private Integer id;
    private Integer comHosId;
    private Integer resId;
    private Integer docId;
    private Integer isHandle;
    private String requestInfo;
    private String phoneNumber;
    private String homeAddress;
    private Integer medicalRecId;
    private Date requestTime;
    private Date solveTime;
    private String appointment;

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public Integer getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(Integer isHandle) {
        this.isHandle = isHandle;
    }

    public Integer getComHosId() {
        return comHosId;
    }

    public void setComHosId(Integer comHosId) {
        this.comHosId = comHosId;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

    public HomeServiceDTO(){}

    public HomeServiceDTO(HomeServiceDTO homeServiceDTO) {
        this.id = homeServiceDTO.id;
        this.comHosId = homeServiceDTO.comHosId;
        this.resId = homeServiceDTO.resId;
        this.docId = homeServiceDTO.docId;
        this.isHandle = homeServiceDTO.isHandle;
        this.requestInfo = homeServiceDTO.requestInfo;
        this.phoneNumber = homeServiceDTO.phoneNumber;
        this.homeAddress = homeServiceDTO.homeAddress;
        this.medicalRecId = homeServiceDTO.medicalRecId;
        this.requestTime = homeServiceDTO.requestTime;
        this.solveTime = homeServiceDTO.solveTime;
        this.appointment = homeServiceDTO.appointment;
    }
}
