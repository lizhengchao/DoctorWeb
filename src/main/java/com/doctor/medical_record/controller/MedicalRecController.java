package com.doctor.medical_record.controller;

import com.doctor.common.BootstrapJsonResult;
import com.doctor.common.CommonController;
import com.doctor.common.Result;
import com.doctor.medical_record.dto.MedicalRecDTO;
import com.doctor.medical_record.dto.MedicalRecQuery;
import com.doctor.medical_record.service.MedicalRecServcie;
import com.doctor.resident.dto.ResidentDTO;
import com.doctor.resident.dto.ResidentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import static com.doctor.common.StringUtil.isVailtString;

/**
 * Created by lzc on 2016/5/20.
 */
@Controller
@RequestMapping(value = "medicalrecord")
public class MedicalRecController extends CommonController{

    @Resource(name = "MedicalRecService")
    private MedicalRecServcie medicalRecServcie;

    @RequestMapping(value = {"insert.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@ModelAttribute MedicalRecDTO medicalRecDTO) {
        return medicalRecServcie.insertResultDO(medicalRecDTO);
    }

  /*  @RequestMapping(value = {"find.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result find(@RequestParam(value = "resId", required = false)Integer resId,
                       @RequestParam(value = "docId", required = false)Integer docId,
                       ) {
        //医院列表直接默认拉取全部
        MedicalRecQuery medicalRecQuery = new MedicalRecQuery();
        medicalRecQuery.setResId(resId);
        medicalRecQuery.setDocId(docId);
        return medicalRecServcie.find(medicalRecQuery);
    }*/

    @RequestMapping(value = {"findwithbs.do"}, method = RequestMethod.GET)
    @ResponseBody
    public BootstrapJsonResult findwithbs(@RequestParam(value = "search", required = false) String search,
                                          @RequestParam(value = "order", required = false) String order,
                                          @RequestParam(value = "sort", required = false) String sort,
                                          @RequestParam(value = "offset", required = false) Integer offset,
                                          @RequestParam(value = "limit", required = false) Integer limit,
                                          @RequestParam(value = "resId", required = false) Integer resId,
                                          @RequestParam(value = "resName", required = false) String resName,
                                          @RequestParam(value = "startTime", required = false)String startTime,
                                          @RequestParam(value = "endTime", required = false) String endTime) {
        MedicalRecQuery medicalRecQuery = new MedicalRecQuery();
        if (null != offset && null != limit) {
            medicalRecQuery.setPaging(true);
            medicalRecQuery.setPageIndex(offset);
            medicalRecQuery.setPageSize(limit);
        }
        if(null != search){
            medicalRecQuery.setVagueValue(encodeStr(search));
        }
        if(null != order){
            medicalRecQuery.setOrder(order);
        }
        if (null != sort){
            medicalRecQuery.setSort(sort);
        }
        if (null != resId){
            medicalRecQuery.setResId(resId);
        }
        if (isVailtString(resName)){
            medicalRecQuery.setResName(resName);
        }
        if (isVailtString(startTime)){
            medicalRecQuery.setStartTime(startTime);
        }
        if (isVailtString(endTime)){
            medicalRecQuery.setEndTime(endTime);
        }

        Result<List> result = medicalRecServcie.findWithVO(medicalRecQuery);
        if (result.getSuccess()) {
            BootstrapJsonResult bootstrapJsonResult = new BootstrapJsonResult();
            bootstrapJsonResult.setTotal(medicalRecServcie.count(new MedicalRecQuery()).getData());
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

    @RequestMapping(value = {"update.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result update(@RequestParam(value = "id", required = true) Integer id,
                         @RequestParam(value = "resHeaDatId", required = false) Integer resHeaDatId,
                         @RequestParam(value = "chiefComplaint", required = false) String chiefComplaint,
                         @RequestParam(value = "suggest", required = false) String suggest,
                         @RequestParam(value = "medicationRecIds", required = false) String medicationRecIds) {
        MedicalRecDTO medicalRecDTO = new MedicalRecDTO();
        medicalRecDTO.setId(id);
        medicalRecDTO.setResHeaDatId(resHeaDatId);
        medicalRecDTO.setChiefComplaint(chiefComplaint);
        medicalRecDTO.setSuggest(suggest);
        medicalRecDTO.setMedicationRecIds(medicationRecIds);
        return medicalRecServcie.update(medicalRecDTO);
    }

    @RequestMapping(value = {"delete.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam int id) {
        MedicalRecQuery medicalRecQuery = new MedicalRecQuery();
        medicalRecQuery.setId(id);
        return  medicalRecServcie.delete(medicalRecQuery);
    }
}
