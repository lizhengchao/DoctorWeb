package com.doctor.home_service.dto;

import com.doctor.common.BaseQuery;

/**
 * Created by lzc on 2016/6/8.
 */
public class HomeServiceQuery extends BaseQuery{
    private Integer id;
    private Integer comHosId;
    private Integer resId;
    private Integer docId;
    private Integer isHandle;
    private Integer docIdAndNull;

    public Integer getDocIdAndNull() {
        return docIdAndNull;
    }

    public void setDocIdAndNull(Integer docIdAndNull) {
        this.docIdAndNull = docIdAndNull;
    }

    public Integer getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(Integer isHandle) {
        this.isHandle = isHandle;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Integer getComHosId() {
        return comHosId;
    }

    public void setComHosId(Integer comHosId) {
        this.comHosId = comHosId;
    }

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
