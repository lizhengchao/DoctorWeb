package com.doctor.user.dto;

/**
 * Created by lzc on 2016/5/30.
 */
public class UserVO extends UserDTO{
    private Integer comHosId;
    private String comHosName;

    public Integer getComHosId() {
        return comHosId;
    }

    public void setComHosId(Integer comHosId) {
        this.comHosId = comHosId;
    }

    public String getComHosName() {
        return comHosName;
    }

    public void setComHosName(String comHosName) {
        this.comHosName = comHosName;
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
