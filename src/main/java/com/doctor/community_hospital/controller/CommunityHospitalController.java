package com.doctor.community_hospital.controller;

import com.doctor.common.BootstrapJsonResult;
import com.doctor.common.CommonController;
import com.doctor.common.Result;
import com.doctor.community_hospital.dto.CommunityHospitalDTO;
import com.doctor.community_hospital.dto.CommunityHospitalQuery;
import com.doctor.community_hospital.service.CommunityHospitalService;
import com.doctor.test.dto.TestDTO;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzc on 2016/5/12.
 */
@Controller
@RequestMapping(value = "communityhospital")
public class CommunityHospitalController extends CommonController{

    @Resource(name = "CommunityHospitalService")
    private CommunityHospitalService communityHospitalService;

    @RequestMapping(value = {"insert.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@ModelAttribute CommunityHospitalDTO communityHospitalDTO){
        return communityHospitalService.insert(communityHospitalDTO);
    }

    @RequestMapping(value = {"find.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result find() {
        //医院列表直接默认拉取全部
        CommunityHospitalQuery communityHospitalQuery  = new CommunityHospitalQuery();
        return communityHospitalService.find(communityHospitalQuery);
    }

    @RequestMapping(value = {"findwithbs.do"}, method = RequestMethod.GET)
    @ResponseBody
    public BootstrapJsonResult findwithbs(@RequestParam(value = "search", required = false) String search,
                                          @RequestParam(value = "order", required = false) String order,
                                          @RequestParam(value = "sort", required = false) String sort,
                                          @RequestParam(value = "offset", required = false) Integer offset,
                                          @RequestParam(value = "limit", required = false) Integer limit) {
        CommunityHospitalQuery communityHospitalQuery = new CommunityHospitalQuery();
        if (null != offset && null != limit) {
            communityHospitalQuery.setPaging(true);
            communityHospitalQuery.setPageIndex(offset);
            communityHospitalQuery.setPageSize(limit);
        }
        if(null != search){
            communityHospitalQuery.setVagueValue(encodeStr(search));
        }
        if(null != order){
            communityHospitalQuery.setOrder(order);
        }
        if (null != sort){
            communityHospitalQuery.setSort(sort);
        }
        Result<List<CommunityHospitalDTO>> result = communityHospitalService.find(communityHospitalQuery);
        if (result.getSuccess()) {
            BootstrapJsonResult bootstrapJsonResult = new BootstrapJsonResult();
            bootstrapJsonResult.setTotal(communityHospitalService.count(new CommunityHospitalQuery()).getData());
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
    public Result update(@ModelAttribute CommunityHospitalDTO communityHospitalDTO) {
        return communityHospitalService.update(communityHospitalDTO);
    }

    @RequestMapping(value = {"delete.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam int id) {
        CommunityHospitalQuery communityHospitalQuery = new CommunityHospitalQuery();
        communityHospitalQuery.setId(id);
        return communityHospitalService.delete(communityHospitalQuery);
    }
}
