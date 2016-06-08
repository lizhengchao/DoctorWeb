package com.doctor.user.dto;

import com.doctor.common.BaseQuery;

/**
 * Created by lzc on 2016/5/17.
 */
public class UserQuery extends BaseQuery{
    private Integer id;

    private Integer userType;

    private String identificationId;

    private Integer resDocId;

    private  String nickname;

    private  String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getIdentificationId() {
        return identificationId;
    }

    public void setIdentificationId(String identificationId) {
        this.identificationId = identificationId;
    }

    public Integer getResDocId() {
        return resDocId;
    }

    public void setResDocId(Integer resDocId) {
        this.resDocId = resDocId;
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
}
