package com.doctor.resident.controller;

import com.doctor.common.BootstrapJsonResult;
import com.doctor.common.CommonController;
import com.doctor.common.Result;
import com.doctor.resident.dto.ResidentDTO;
import com.doctor.resident.dto.ResidentQuery;
import com.doctor.resident.service.ResidentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzc on 2016/5/19.
 */
@Controller
@RequestMapping(value = "resident")
public class ResidentController extends CommonController{
    @Resource(name = "ResidentService")
    private ResidentService residentService;

    @RequestMapping(value = {"insert.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@ModelAttribute ResidentDTO residentDTO) {
        return  residentService.insert(residentDTO);
    }

    @RequestMapping(value = {"find.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result find(@RequestParam(value = "id")Integer id) {
        ResidentQuery residentQuery = new ResidentQuery();
        residentQuery.setId(id);
        return residentService.find(residentQuery);
    }

    @RequestMapping(value = {"findwithbs.do"}, method = RequestMethod.GET)
    @ResponseBody
    public BootstrapJsonResult findwithbs(@RequestParam(value = "search", required = false) String search,
                                          @RequestParam(value = "order", required = false) String order,
                                          @RequestParam(value = "sort", required = false) String sort,
                                          @RequestParam(value = "offset", required = false) Integer offset,
                                          @RequestParam(value = "limit", required = false) Integer limit,
                                          @RequestParam(value = "name", required = false) String name,
                                          @RequestParam(value = "nameLike", required = false)String nameLike,
                                          @RequestParam(value = "sex", required = false) Integer sex,
                                          @RequestParam(value = "identificationId", required = false) String identificationId,
                                          @RequestParam(value = "birthday", required = false) String birthday,
                                          @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
                                          @RequestParam(value = "comHosId", required = false) Integer comHosId,
                                          @RequestParam(value = "homeAddress", required = false) String homeAddress ) {
        ResidentQuery residentQuery = new ResidentQuery();
        if (null != offset && null != limit) {
            residentQuery.setPaging(true);
            residentQuery.setPageIndex(offset);
            residentQuery.setPageSize(limit);
        }
        if(null != search){
            residentQuery.setVagueValue(encodeStr(search));
        }
        if(null != order){
            residentQuery.setOrder(order);
        }
        if (null != sort){
            residentQuery.setSort(sort);
        }
        if(null != name){
            residentQuery.setName(name);
        }
        if (null != nameLike){
            residentQuery.setNameLike(encodeStr(nameLike));
        }
        if (null != sex){
            residentQuery.setSex(sex);
        }
        if(null != identificationId){
            residentQuery.setIdentificationId(identificationId);
        }
        if (null != birthday){
            residentQuery.setBirthday(birthday);
        }
        if (null != phoneNumber){
            residentQuery.setPhoneNumber(phoneNumber);
        }
        if (null != homeAddress){
            residentQuery.setHomeAddress(homeAddress);
        }
        if (null != comHosId){
            residentQuery.setComHosId(comHosId);
        }
        Result<List> result = residentService.findWithVO(residentQuery);
        if (result.getSuccess()) {
            BootstrapJsonResult bootstrapJsonResult = new BootstrapJsonResult();
            bootstrapJsonResult.setTotal(residentService.count(new ResidentQuery()).getData());
            bootstrapJsonResult.setRows(result.getData());
            return bootstrapJsonResult;
        }
        return new BootstrapJsonResult(0,new ArrayList());
    }

   /* @RequestMapping(value = {"get.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result get(){
        CommunityHospitalQuery communityHospitalQuery = new CommunityHospitalQuery();
        return  communityHospitalService.get(communityHospitalQuery);
    }*/

    @RequestMapping(value = {"update.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result update(@ModelAttribute ResidentDTO residentDTO) {
        return  residentService.update(residentDTO);
    }

    @RequestMapping(value = {"delete.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam int id) {
        ResidentQuery residentQuery = new ResidentQuery();
        residentQuery.setId(id);
        return  residentService.delete(residentQuery);
    }

}
