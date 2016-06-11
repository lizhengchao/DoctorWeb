package com.doctor.home_service.dto;

/**
 * Created by lzc on 2016/6/11.
 */
public class HomeServiceVO extends HomeServiceDTO{
    private String resName;
    private String requestInfoTrim;

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getRequestInfoTrim() {
        return requestInfoTrim;
    }

    public void setRequestInfoTrim(String requestInfoTrim) {
        this.requestInfoTrim = requestInfoTrim;
    }

    public HomeServiceVO(HomeServiceDTO homeServiceDTO){
        super(homeServiceDTO);
    }
}
