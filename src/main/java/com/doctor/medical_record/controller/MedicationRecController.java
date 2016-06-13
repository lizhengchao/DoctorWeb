package com.doctor.medical_record.controller;

import com.doctor.common.BootstrapJsonResult;
import com.doctor.common.CommonController;
import com.doctor.common.Result;
import com.doctor.medical_record.dto.MedicalRecDTO;
import com.doctor.medical_record.dto.MedicalRecQuery;
import com.doctor.medical_record.dto.MedicationRecDTO;
import com.doctor.medical_record.dto.MedicationRecQuery;
import com.doctor.medical_record.service.MedicalRecServcie;
import com.doctor.medical_record.service.MedicationRecService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzc on 2016/5/20.
 */
@Controller
@RequestMapping(value = "medicationrecord")
public class MedicationRecController extends CommonController{
    @Resource(name = "MedicationRecService")
    private MedicationRecService medicationRecService;

    @RequestMapping(value = {"insert.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@ModelAttribute MedicationRecDTO medicationRecDTO) {
        return medicationRecService.insert(medicationRecDTO);
    }

    @RequestMapping(value = {"usemidicine.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result usemidicine(@ModelAttribute MedicationRecDTO medicationRecDTO) {
        return medicationRecService.useMedicine(medicationRecDTO);
    }

    @RequestMapping(value = {"find.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result find(@RequestParam(value = "medicalRecId", required = true)Integer medicalRecId){
        MedicationRecQuery medicationRecQuery = new MedicationRecQuery();
        medicationRecQuery.setMedicalRecId(medicalRecId);
        return medicationRecService.findResultVO(medicationRecQuery);
    }

    @RequestMapping(value = {"findwithbs.do"}, method = RequestMethod.GET)
    @ResponseBody
    public BootstrapJsonResult findwithbs(@RequestParam(value = "search", required = false) String search,
                                          @RequestParam(value = "order", required = false) String order,
                                          @RequestParam(value = "sort", required = false) String sort,
                                          @RequestParam(value = "offset", required = false) Integer offset,
                                          @RequestParam(value = "limit", required = false) Integer limit,
                                          @RequestParam(value = "medicalRecId", required = false)Integer medicalRecId) {
        MedicationRecQuery medicationRecQuery = new MedicationRecQuery();
        if (null != offset && null != limit) {
            medicationRecQuery.setPaging(true);
            medicationRecQuery.setPageIndex(offset);
            medicationRecQuery.setPageSize(limit);
        }
        if(null != search){
            medicationRecQuery.setVagueValue(search);
        }
        if(null != order){
            medicationRecQuery.setOrder(order);
        }
        if (null != sort){
            medicationRecQuery.setSort(sort);
        }
        if (null != medicalRecId){
            medicationRecQuery.setMedicalRecId(medicalRecId);
        }
        Result<List> result = medicationRecService.findResultVO(medicationRecQuery);
        if (result.getSuccess()) {
            BootstrapJsonResult bootstrapJsonResult = new BootstrapJsonResult();
            bootstrapJsonResult.setTotal(medicationRecService.count(new MedicationRecQuery()).getData());
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
    public Result update(@ModelAttribute MedicationRecDTO medicationRecDTO) {
        return  medicationRecService.update(medicationRecDTO);
    }

    @RequestMapping(value = {"delete.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam int id) {
        MedicationRecQuery medicationRecQuery = new MedicationRecQuery();
        medicationRecQuery.setId(id);
        return  medicationRecService.delete(medicationRecQuery);
    }
}
