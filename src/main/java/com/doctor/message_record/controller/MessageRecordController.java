package com.doctor.message_record.controller;

import com.doctor.common.BootstrapJsonResult;
import com.doctor.common.CommonController;
import com.doctor.common.Result;
import com.doctor.message_record.dto.MessageRecordQuery;
import com.doctor.message_record.dto.MessageRecordVO;
import com.doctor.message_record.dto.MessageReocrdDTO;
import com.doctor.message_record.service.MessageRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lzc on 2016/6/7.
 */
@Controller
@RequestMapping(value = "messagerecord")
public class MessageRecordController extends CommonController{

    @Resource(name = "MessageRecordService")
    private MessageRecordService messageRecordService;

    @RequestMapping(value = {"insert.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@ModelAttribute MessageReocrdDTO messageReocrdDTO){
        return messageRecordService.insert(messageReocrdDTO);
    }

    @RequestMapping(value = {"find.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result find(@RequestParam(value = "comHosId", required = false)Integer comHosId,
                       @RequestParam(value = "docId", required = false)Integer docId,
                       @RequestParam(value = "resId", required = false)Integer resId) {
        MessageRecordQuery messageRecordQuery = new MessageRecordQuery();
        messageRecordQuery.setComHosId(comHosId);
        messageRecordQuery.setDocId(docId);
        messageRecordQuery.setResId(resId);
        return messageRecordService.find(messageRecordQuery);
    }

    @RequestMapping(value = {"findwithbs.do"}, method = RequestMethod.GET)
    @ResponseBody
    public BootstrapJsonResult findwithbs(@RequestParam(value = "search", required = false) String search,
                                          @RequestParam(value = "order", required = false) String order,
                                          @RequestParam(value = "sort", required = false) String sort,
                                          @RequestParam(value = "offset", required = false) Integer offset,
                                          @RequestParam(value = "limit", required = false) Integer limit,
                                          @RequestParam(value = "isHandle", required = false) Integer isHandle,
                                          @RequestParam(value = "docId", required = false) Integer docId,
                                          @RequestParam(value = "docIdAndNull", required = false) Integer docIdAndNull,
                                          @RequestParam(value = "comHosId", required = false) Integer comHosId) {
        MessageRecordQuery messageRecordQuery = new MessageRecordQuery();
        if (null != offset && null != limit) {
            messageRecordQuery.setPaging(true);
            messageRecordQuery.setPageIndex(offset);
            messageRecordQuery.setPageSize(limit);
        }
        if(null != search){
            messageRecordQuery.setVagueValue(search);
        }
        if(null != order){
            messageRecordQuery.setOrder(order);
        }
        if (null != sort){
            messageRecordQuery.setSort(sort);
        }
        if (null != docId){
            messageRecordQuery.setDocId(docId);
        }
        if (null != docIdAndNull){
            messageRecordQuery.setDocIdAndNull(docIdAndNull);
        }
        if (null != comHosId){
            messageRecordQuery.setComHosId(comHosId);
        }
        if (null != isHandle){
            messageRecordQuery.setIsHandle(isHandle);
        }
        Result<List> result = messageRecordService.findWithVO(messageRecordQuery);
        if (result.getSuccess()) {
            BootstrapJsonResult bootstrapJsonResult = new BootstrapJsonResult();
            bootstrapJsonResult.setTotal(messageRecordService.count(new MessageRecordQuery()).getData());
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
    public Result update(@ModelAttribute MessageReocrdDTO messageReocrdDTO) {
        return messageRecordService.update(messageReocrdDTO);
    }

    @RequestMapping(value = {"answer.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result answer(@ModelAttribute MessageReocrdDTO messageReocrdDTO) {
        Integer doctorId = (Integer)request1.getSession().getAttribute("doctorId");
        //将当前医生id存入
        messageReocrdDTO.setDocId(doctorId);
        //存入回复时间
        messageReocrdDTO.setAnswerTime(new Date());
        messageReocrdDTO.setIsHandle(1);
        return messageRecordService.update(messageReocrdDTO);
    }

    @RequestMapping(value = {"delete.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam int id) {
        MessageRecordQuery messageRecordQuery = new MessageRecordQuery();
        messageRecordQuery.setId(id);
        return messageRecordService.delete(messageRecordQuery);
    }
}
