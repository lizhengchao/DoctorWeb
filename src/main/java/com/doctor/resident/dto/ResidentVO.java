package com.doctor.resident.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lzc on 2016/5/22.
 */
public class ResidentVO extends ResidentDTO implements Serializable{
    private String familMembersName;
    private String comHosName;
    private String sexName;

    public String getComHosName() {
        return comHosName;
    }

    public void setComHosName(String comHosName) {
        this.comHosName = comHosName;
    }

    public String getFamilMembersName() {
        return familMembersName;
    }

    public void setFamilMembersName(String familMembersName) {
        this.familMembersName = familMembersName;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public void setResidentDTO(ResidentDTO residentDTO){
        super.setId(residentDTO.getId());
        super.setName(residentDTO.getName());
        super.setIdentificationId(residentDTO.getIdentificationId());
        super.setCreateTime(residentDTO.getCreateTime());
        super.setBirthday(residentDTO.getBirthday());
        super.setComHosId(residentDTO.getComHosId());
        super.setFamilyMembers(residentDTO.getFamilyMembers());
        super.setHomeAddress(residentDTO.getHomeAddress());
        super.setModifyTime(residentDTO.getModifyTime());
        super.setPhoneNumber(residentDTO.getPhoneNumber());
        super.setSex(residentDTO.getSex());

    }
}
