package com.doctor.test.dto;

import java.io.Serializable;

/**
 * Created by lzc on 2016/4/21.
 */
public class TestDTO implements Serializable{

    private int id;

    private String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
