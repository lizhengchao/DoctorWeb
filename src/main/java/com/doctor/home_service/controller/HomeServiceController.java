package com.doctor.home_service.controller;

import com.doctor.common.BootstrapJsonResult;
import com.doctor.common.CommonController;
import com.doctor.common.Result;
import com.doctor.home_service.dto.HomeServiceDTO;
import com.doctor.home_service.dto.HomeServiceQuery;
import com.doctor.home_service.service.HomeServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lzc on 2016/6/8.
 */
@Controller
@RequestMapping(value = "homeservice")
public class HomeServiceController extends CommonController{

    @Resource(name = "HomeServiceService")
    private HomeServiceService homeServiceService;

    @RequestMapping(value = {"insert.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@ModelAttribute HomeServiceDTO homeServiceDTO){
        return homeServiceService.insert(homeServiceDTO);
    }

    @RequestMapping(value = {"find.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result find(@RequestParam(value = "comHosId", required = false)Integer comHosId,
                       @RequestParam(value = "docId", required = false)Integer docId,
                       @RequestParam(value = "resId", required = false)Integer resId) {
        HomeServiceQuery homeServiceQuery = new HomeServiceQuery();
        homeServiceQuery.setComHosId(comHosId);
        homeServiceQuery.setDocId(docId);
        homeServiceQuery.setResId(resId);
        return homeServiceService.find(homeServiceQuery);
    }

    @RequestMapping(value = {"findwithbs.do"}, method = RequestMethod.GET)
    @ResponseBody
    public BootstrapJsonResult findwithbs(@RequestParam(value = "search", required = false) String search,
                                          @RequestParam(value = "order", required = false) String order,
                                          @RequestParam(value = "sort", required = false) String sort,
                                          @RequestParam(value = "offset", required = false) Integer offset,
                                          @RequestParam(value = "limit", required = false) Integer limit,
                                          @RequestParam(value = "isHandle", required = false) Integer isHandle,
                                          @RequestParam(value = "comHosId", required = false) Integer comHosId,
                                          @RequestParam(value = "docIdAndNull", required = false) Integer docIdAndNull) {
        HomeServiceQuery homeServiceQuery = new HomeServiceQuery();
        if (null != offset && null != limit) {
            homeServiceQuery.setPaging(true);
            homeServiceQuery.setPageIndex(offset);
            homeServiceQuery.setPageSize(limit);
        }
        if(null != search){
            homeServiceQuery.setVagueValue(search);
        }
        if(null != order){
            homeServiceQuery.setOrder(order);
        }
        if (null != sort){
            homeServiceQuery.setSort(sort);
        }
        if (null != comHosId){
            homeServiceQuery.setComHosId(comHosId);
        }
        if (null != docIdAndNull){
            homeServiceQuery.setDocIdAndNull(docIdAndNull);
        }
        if (null != isHandle){
            homeServiceQuery.setIsHandle(isHandle);
        }
        Result<List> result = homeServiceService.findWithVO(homeServiceQuery);
        if (result.getSuccess()) {
            BootstrapJsonResult bootstrapJsonResult = new BootstrapJsonResult();
            bootstrapJsonResult.setTotal(homeServiceService.count(new HomeServiceQuery()).getData());
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
    public Result update(@ModelAttribute HomeServiceDTO homeServiceDTO) {
        return homeServiceService.update(homeServiceDTO);
    }

    @RequestMapping(value = {"handle.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result handle(@ModelAttribute HomeServiceDTO homeServiceDTO) {
        Integer doctorId = (Integer)request1.getSession().getAttribute("doctorId");
        homeServiceDTO.setDocId(doctorId);
        homeServiceDTO.setSolveTime(new Date());
        homeServiceDTO.setIsHandle(1);
        return homeServiceService.update(homeServiceDTO);
    }

    @RequestMapping(value = {"delete.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam int id) {
        HomeServiceQuery homeServiceQuery = new HomeServiceQuery();
        homeServiceQuery.setId(id);
        return homeServiceService.delete(homeServiceQuery);
    }
}
