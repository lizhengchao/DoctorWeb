package com.doctor.medical_record.controller;

import com.doctor.common.Result;
import com.doctor.medical_record.dto.MedicalRecDTO;
import com.doctor.medical_record.dto.MedicalRecQuery;
import com.doctor.medical_record.dto.ResHeaDataDTO;
import com.doctor.medical_record.dto.ResHeaDataQuery;
import com.doctor.medical_record.service.MedicalRecServcie;
import com.doctor.medical_record.service.ResHeaDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by lzc on 2016/5/20.
 */
@Controller
@RequestMapping(value = "residenthealthdata")
public class ResHeaDataController {

    @Resource(name = "ResHeaDataService")
    private ResHeaDataService resHeaDataService;

    @RequestMapping(value = {"insert.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@ModelAttribute ResHeaDataDTO resHeaDataDTO){
        return resHeaDataService.insert(resHeaDataDTO);
    }

    @RequestMapping(value = {"find.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result find(@RequestParam(value = "medicalRecId", required = true)Integer medicalRecId) {
        ResHeaDataQuery resHeaDataQuery = new ResHeaDataQuery();
        resHeaDataQuery.setMedicalRecId(medicalRecId);
        return  resHeaDataService.find(resHeaDataQuery);
    }

    @RequestMapping(value = {"update.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result update(@ModelAttribute ResHeaDataDTO resHeaDataDTO) {
        return  resHeaDataService.update(resHeaDataDTO);
    }

    @RequestMapping(value = {"delete.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam int id) {
        ResHeaDataQuery resHeaDataQuery = new ResHeaDataQuery();
        resHeaDataQuery.setId(id);
        return  resHeaDataService.delete(resHeaDataQuery);
    }
}
