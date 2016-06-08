package com.doctor.user.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lzc on 2016/5/17.
 */
public class UserDTO implements Serializable{
    private Integer id;
    private Integer userType;
    private String identificationId;
    private Integer resDocId;
    private String nickname;
    private String password;
    private Date createTime;
    private Date modifyTime;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getResDocId() {
        return resDocId;
    }

    public void setResDocId(Integer resDocId) {
        this.resDocId = resDocId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public enum UserType{
        manage(new Integer(0),"管理员"), doctor(new Integer(1),"医生"), resident(new Integer(2),"患者");
        Integer type;
        String name;

        UserType(int type, String name){
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
    }
}
