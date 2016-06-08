package com.doctor.resident.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lzc on 2016/5/19.
 */
public class ResidentInvDTO implements Serializable{
    private Integer id;
    private Integer resId;
    private String disease;
    private Integer type;
    private String time1;
    private String time2;
    private Date createTime;
    private Date modifyTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer res_id) {
        this.resId = res_id;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
