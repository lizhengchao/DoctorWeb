package com.doctor.message_record.dto;

import com.doctor.common.BaseQuery;

/**
 * Created by lzc on 2016/6/7.
 */
public class MessageRecordQuery extends BaseQuery{
    private Integer id;
    private Integer resId;
    private Integer comHosId;
    private Integer docId;
    private Integer docIdAndNull; //此字段塞入docId时查询的结果还包括doctorId字段为空的数据
    private Integer isHandle; //删选处理或未处理

    public Integer getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(Integer isHandle) {
        this.isHandle = isHandle;
    }

    public Integer getDocIdAndNull() {
        return docIdAndNull;
    }

    public void setDocIdAndNull(Integer docIdAndNull) {
        this.docIdAndNull = docIdAndNull;
    }

    public Integer getComHosId() {
        return comHosId;
    }

    public void setComHosId(Integer comHosId) {
        this.comHosId = comHosId;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
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
