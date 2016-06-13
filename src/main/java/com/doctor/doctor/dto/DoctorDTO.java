package com.doctor.doctor.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lzc on 2016/5/17.
 */
public class DoctorDTO implements Serializable{
    private Integer id;
    private String name;
    private String identificationId;
    private String phoneNumber;
    private String phyQuaCerCode;
    private String phyPraCerCode;
    private Integer title;
    private Integer practiceType;
    private String description;
    private String specialty;
    private  Integer comHosId;
    private Date createTime;
    private Date modifyTime;

    public DoctorDTO(DoctorDTO doctorDTO) {
        this.comHosId = doctorDTO.comHosId;
        this.createTime = doctorDTO.createTime;
        this.description = doctorDTO.description;
        this.id = doctorDTO.id;
        this.identificationId = doctorDTO.identificationId;
        this.modifyTime = doctorDTO.modifyTime;
        this.name = doctorDTO.name;
        this.phoneNumber = doctorDTO.phoneNumber;
        this.phyPraCerCode = doctorDTO.phyPraCerCode;
        this.phyQuaCerCode = doctorDTO.phyQuaCerCode;
        this.practiceType = doctorDTO.practiceType;
        this.specialty = doctorDTO.specialty;
        this.title = doctorDTO.title;
    }

    public Integer getComHosId() {
        return comHosId;
    }

    public void setComHosId(Integer comHosId) {
        this.comHosId = comHosId;
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

    public String getIdentificationId() {
        return identificationId;
    }

    public void setIdentificationId(String identificationId) {
        this.identificationId = identificationId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhyPraCerCode() {
        return phyPraCerCode;
    }

    public void setPhyPraCerCode(String phyPraCerCode) {
        this.phyPraCerCode = phyPraCerCode;
    }

    public String getPhyQuaCerCode() {
        return phyQuaCerCode;
    }

    public void setPhyQuaCerCode(String phyQuaCerCode) {
        this.phyQuaCerCode = phyQuaCerCode;
    }

    public Integer getPracticeType() {
        return practiceType;
    }

    public void setPracticeType(Integer practiceType) {
        this.practiceType = practiceType;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public enum TitleType{
        YiShi(0,"医师"),ZhuGuanYiShi(1,"主管医师"),FuZhuRenYiShi(2,"副主任医师"),ZhuRenYiShi(3,"主任医师");
        private Integer type;
        private String name;

        TitleType(Integer type, String name){
            this.type = type;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public static String getNameByType(Integer type){
            for (TitleType titleType: TitleType.values()){
                if (titleType.type.equals(type)){
                    return titleType.name;
                }
            }
            return null;
        }
    }

    public DoctorDTO() {
    }

    public enum PracticeType{
        LinChuang(0,"临床"),GongGongWeiSheng(1,"公共卫生"),KouQiang(2,"口腔"),ZhongYi(3,"中医");
        private Integer type;
        private String name;

        PracticeType(Integer type, String name){
            this.type = type;
            this.name = name;
        }

        public static String getNameByType(Integer type){
            for (PracticeType practiceType1: PracticeType.values()){
                if (practiceType1.type.equals(type)){
                    return practiceType1.name;
                }
            }
            return null;
        }
    }
}
