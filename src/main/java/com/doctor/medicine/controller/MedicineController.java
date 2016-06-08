package com.doctor.medicine.controller;

import com.doctor.common.BootstrapJsonResult;
import com.doctor.common.CommonController;
import com.doctor.common.Result;
import com.doctor.medicine.dto.MedicineDTO;
import com.doctor.medicine.dto.MedicineQuery;
import com.doctor.medicine.service.MedicineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzc on 2016/5/24.
 */
@Controller
@RequestMapping("medicine")
public class MedicineController extends CommonController{

    @Resource(name = "MedicineService")
    private MedicineService medicineService;

    @RequestMapping(value = {"insert.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@ModelAttribute MedicineDTO medicineDTO){
        return  medicineService.insert(medicineDTO);
    }

    @RequestMapping(value = {"findwithbs.do"}, method = RequestMethod.GET)
    @ResponseBody
    public BootstrapJsonResult findwithbs(@RequestParam(value = "search", required = false) String search,
                                          @RequestParam(value = "order", required = false) String order,
                                          @RequestParam(value = "sort", required = false) String sort,
                                          @RequestParam(value = "offset", required = false) Integer offset,
                                          @RequestParam(value = "limit", required = false) Integer limit,
                                          @RequestParam(value = "nameLike", required = false)String nameLike,
                                          @RequestParam(value = "type", required = false)Integer type,
                                          @RequestParam(value = "factoryLike", required = false)String factoryLike) {
        MedicineQuery medicineQuery = new MedicineQuery();
        if (null != offset && null != limit) {
            medicineQuery.setPaging(true);
            medicineQuery.setPageIndex(offset);
            medicineQuery.setPageSize(limit);
        }
        if(null != search){
            medicineQuery.setVagueValue(search);
        }
        if(null != order){
            medicineQuery.setOrder(order);
        }
        if (null != sort){
            medicineQuery.setSort(sort);
        }
        if (null != nameLike){
            medicineQuery.setNameLike(encodeStr(nameLike));
        }
        if (null != type){
            medicineQuery.setType(type);
        }
        if(null != factoryLike){
            medicineQuery.setFactoryLike(factoryLike);
        }
        Result<List<MedicineDTO>> result = medicineService.find(medicineQuery);
        if (result.getSuccess()) {
            BootstrapJsonResult bootstrapJsonResult = new BootstrapJsonResult();
            bootstrapJsonResult.setTotal(medicineService.count(new MedicineQuery()).getData());
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
    public Result update(@ModelAttribute MedicineDTO medicineDTO) {
        return medicineService.update(medicineDTO);
    }

    @RequestMapping(value = {"delete.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam int id) {
        MedicineQuery medicineQuery = new MedicineQuery();
        medicineQuery.setId(id);
        return medicineService.delete(medicineQuery);
    }
}
