package com.doctor.doctor.dto;

import java.util.Date;

/**
 * Created by lzc on 2016/6/2.
 */
public class DoctorVO extends DoctorDTO{
    private String titleName;
    private String practiceTypeName;
    private String comHosName;

    public String getComHosName() {
        return comHosName;
    }

    public void setComHosName(String comHosName) {
        this.comHosName = comHosName;
    }

    public String getPracticeTypeName() {
        return practiceTypeName;
    }

    public void setPracticeTypeName(String practiceTypeName) {
        this.practiceTypeName = practiceTypeName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public DoctorVO(){}

    public DoctorVO(DoctorDTO doctorDTO) {
        super(doctorDTO);
    }
}
