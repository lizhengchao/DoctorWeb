package com.doctor.medicine.dto;

import com.doctor.common.BaseQuery;

/**
 * Created by lzc on 2016/5/24.
 */
public class MedicineQuery extends BaseQuery{
    private Integer id;
    private String nameLike;
    private Integer type;
    private String factoryLike;

    public String getFactoryLike() {
        return factoryLike;
    }

    public void setFactoryLike(String factoryLike) {
        this.factoryLike = factoryLike;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameLike() {
        return nameLike;
    }

    public void setNameLike(String nameLike) {
        this.nameLike = nameLike;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
