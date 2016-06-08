package com.doctor.common;

/**
 * Created by lzc on 2016/5/12.
 */
public class BaseQuery {

    private final static Integer defaultPageSize = new Integer(20);
    private final static Integer defaultPageIndex = new Integer(0);

    private Integer pageSize;
    private Integer pageIndex;

    //模糊查找字段
    private String vagueValue;

    //排序字段,默认create_time字段
    private String sort = "createTime";

    //排序方式,默认降序
    private String order = "DESC";

    private Boolean paging = false;

    public int getPageIndex() {
        if (null == pageIndex){
            return  defaultPageIndex;
        }
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        if (null == pageSize){
            return defaultPageSize;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getVagueValue() {
        return vagueValue;
    }

    public void setVagueValue(String vagueValue) {
        this.vagueValue = vagueValue;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setPaging(Boolean paging){ this.paging = paging; }

    public Boolean getPaging(){ return  paging; }
}
