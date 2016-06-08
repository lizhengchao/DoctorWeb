package com.doctor.community_hospital.dto;

import com.doctor.common.BaseQuery;

/**
 * Created by lzc on 2016/5/12.
 */
public class CommunityHospitalQuery extends BaseQuery{
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
