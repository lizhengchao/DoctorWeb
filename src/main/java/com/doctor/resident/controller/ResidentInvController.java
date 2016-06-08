package com.doctor.resident.controller;

import com.doctor.common.CommonController;
import com.doctor.common.Result;
import com.doctor.resident.dto.ResidentInvDTO;
import com.doctor.resident.dto.ResidentInvQuery;
import com.doctor.resident.service.ResidentInvService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by lzc on 2016/5/19.
 */
@Controller
@RequestMapping(name = "residentInv")
public class ResidentInvController extends CommonController{

    @Resource(name = "ResidentInvService")
    private ResidentInvService residentInvService;

    @RequestMapping(value = {"insert.do"}, method = RequestMethod.POST)
    @ResponseBody
    private Result insert(@RequestParam(value = "resId", required = true) Integer resId,
                          @RequestParam(value = "disease", required = true) String disease,
                          @RequestParam(value = "type", required = true) Integer type,
                          @RequestParam(value = "time1", required = true) String time1,
                          @RequestParam(value = "time2", required = true) String time2) {
        ResidentInvDTO residentInvDTO = new ResidentInvDTO();
        try {
            residentInvDTO.setResId(resId);
            residentInvDTO.setDisease(URLDecoder.decode(disease, "UTF-8"));
            residentInvDTO.setType(type);
            residentInvDTO.setTime1(time1);
            residentInvDTO.setTime2(time2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new Result(null, false, "参数转码错误", 500);
        }
        return  residentInvService.insert(residentInvDTO);
    }

    @RequestMapping(value = {"find.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result find(@RequestParam(value = "resId",required = true)Integer resId) {
        ResidentInvQuery residentInvQuery = new ResidentInvQuery();
        residentInvQuery.setResId(resId);
        return residentInvService.find(residentInvQuery);
    }


   /* @RequestMapping(value = {"get.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result get(){
        CommunityHospitalQuery communityHospitalQuery = new CommunityHospitalQuery();
        return  communityHospitalService.get(communityHospitalQuery);
    }*/

    @RequestMapping(value = {"update.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestParam(value = "id", required = true) Integer id,
                         @RequestParam(value = "disease", required = false) String disease,
                         @RequestParam(value = "type", required = false) Integer type,
                         @RequestParam(value = "time1", required = false) String time1,
                         @RequestParam(value = "time2", required = false) String time2) {
        ResidentInvDTO residentInvDTO = new ResidentInvDTO();
        residentInvDTO.setId(id);
        residentInvDTO.setDisease(disease);
        residentInvDTO.setType(type);
        residentInvDTO.setTime1(time1);
        residentInvDTO.setTime2(time2);
        return residentInvService.update(residentInvDTO);
    }

    @RequestMapping(value = {"delete.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam int id) {
        ResidentInvQuery residentInvQuery = new ResidentInvQuery();
        residentInvQuery.setId(id);
        return  residentInvService.delete(residentInvQuery);
    }
}
