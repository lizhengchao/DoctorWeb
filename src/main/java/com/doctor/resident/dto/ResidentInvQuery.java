package com.doctor.resident.dto;

import com.doctor.common.BaseQuery;

/**
 * Created by lzc on 2016/5/19.
 */
public class ResidentInvQuery extends BaseQuery{
    private Integer id;
    private Integer resId;

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
}
