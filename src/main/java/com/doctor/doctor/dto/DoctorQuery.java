package com.doctor.doctor.dto;

import com.doctor.common.BaseQuery;

/**
 * Created by lzc on 2016/5/18.
 */
public class DoctorQuery extends BaseQuery{
    private Integer id;
    private String name;
    private Long identificationId;
    private Integer title;
    private Integer practiceType;
    private String phoneNumber;
    private  Integer comHosId;

    public Integer getComHosId() {
        return comHosId;
    }

    public void setComHosId(Integer comHosId) {
        this.comHosId = comHosId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIdentificationId() {
        return identificationId;
    }

    public void setIdentificationId(Long identificationId) {
        this.identificationId = identificationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPracticeType() {
        return practiceType;
    }

    public void setPracticeType(Integer practiceType) {
        this.practiceType = practiceType;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }
}
