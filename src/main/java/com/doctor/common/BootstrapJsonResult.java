package com.doctor.common;

import java.util.List;

/**
 * Created by lzc on 2016/5/17.
 */
public class BootstrapJsonResult {
    private Integer total;

    private List rows;

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public BootstrapJsonResult(){}

    public BootstrapJsonResult(Integer total, List rows){
        this.total = total;
        this.rows = rows;
    }
}
