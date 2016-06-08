package com.doctor.medicine.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lzc on 2016/5/24.
 */
public class MedicineDTO implements Serializable{
    private Integer id;
    private String name;
    private String spellingName;
    private Integer type;
    private String supplyUnit;
    private String factory;
    private Integer price;
    private Integer number;
    private Date createTime;
    private Date modifyTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSupplyUnit() {
        return supplyUnit;
    }

    public void setSupplyUnit(String supplyUnit) {
        this.supplyUnit = supplyUnit;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSpellingName() {
        return spellingName;
    }

    public void setSpellingName(String spellingName) {
        this.spellingName = spellingName;
    }

    public enum MedicineType{
        CHUFANG(0,"处方"), FEICHUFANG(1,"非处方");
        private Integer type;
        private String name;

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

        MedicineType(Integer type, String name){
            this.type = type;
            this.name = name;
        }

        public static String getNameByType(Integer type){
            if (type.equals(CHUFANG.getType())) return CHUFANG.getName();
            if (type.equals(FEICHUFANG.getType())) return FEICHUFANG.getName();
            else return "";
        }
    }
}
