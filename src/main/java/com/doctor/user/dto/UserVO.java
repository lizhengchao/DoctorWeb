package com.doctor.user.dto;

/**
 * Created by lzc on 2016/5/30.
 */
public class UserVO extends UserDTO{
    private Integer comhisid;
    private String comhisname;

    public Integer getComhisid() {
        return comhisid;
    }

    public void setComhisid(Integer comhisid) {
        this.comhisid = comhisid;
    }

    public String getComhisname() {
        return comhisname;
    }

    public void setComhisname(String comhisname) {
        this.comhisname = comhisname;
    }

    public void setDTO(UserDTO userDTO){
        super.setId(userDTO.getId());
        super.setResDocId(userDTO.getResDocId());
        super.setNickname(userDTO.getNickname());
        super.setUserType(userDTO.getUserType());
        super.setCreateTime(userDTO.getCreateTime());
        super.setIdentificationId(userDTO.getIdentificationId());
        super.setModifyTime(userDTO.getModifyTime());
        super.setPassword(userDTO.getPassword());
    }
}
