package com.doctor.medical_record.dto;

import com.doctor.common.BaseQuery;

import java.util.List;

/**
 * Created by lzc on 2016/5/19.
 * 电子病历Query
 */
public class MedicalRecQuery extends BaseQuery{
    private Integer id;
    private Integer resId;
    private Integer docId;
    private String startTime;
    private String endTime;
    private String resName;
    private List<Integer> resIds;

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

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public List<Integer> getResIds() {
        return resIds;
    }

    public void setResIds(List<Integer> resIds) {
        this.resIds = resIds;
    }
}
