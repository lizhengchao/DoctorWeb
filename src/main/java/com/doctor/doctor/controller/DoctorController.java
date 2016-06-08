package com.doctor.doctor.controller;

import com.doctor.common.BootstrapJsonResult;
import com.doctor.common.CommonController;
import com.doctor.common.Result;
import com.doctor.doctor.dto.DoctorDTO;
import com.doctor.doctor.dto.DoctorQuery;
import com.doctor.doctor.service.DoctorService;
import com.doctor.user.dto.UserDTO;
import com.doctor.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzc on 2016/5/19.
 */
@Controller
@RequestMapping(value = "doctor")
public class DoctorController extends CommonController{

    @Resource(name = "DoctorService")
    private DoctorService DoctorService;

    @Resource(name = "UserService")
    private UserService userService;

//    //此处包括了添加信息至user表
//    @RequestMapping(value = {"insert.do"}, method = RequestMethod.POST)
//    @ResponseBody
//    public Result insert(@RequestParam(value = "name", required = true) String name,
//                         @RequestParam(value = "password", required = true) String password,
//                         @RequestParam(value = "identificationId", required = true) Long identificationId,
//                         @RequestParam(value = "phoneNumber", required = true) Long phoneNumber,
//                         @RequestParam(value = "phyQuaCerCode", required = true) String phyQuaCerCode,
//                         @RequestParam(value = "phyPraCerCode", required = true) String phyPraCerCode,
//                         @RequestParam(value = "title", required = true) Integer title,
//                         @RequestParam(value = "practiceType", required = true) Integer practiceType,
//                         @RequestParam(value = "description", required = true) String description,
//                         @RequestParam(value = "specialty", required = true) String specialty,
//                         @RequestParam(value = "comHosId", required = true) Integer comHosId) {
//        DoctorDTO doctorDTO = new DoctorDTO();
//        UserDTO userDTO = new UserDTO();
//        try {
//            doctorDTO.setName(java.net.URLDecoder.decode(name,"UTF-8"));
//            doctorDTO.setIdentificationId(identificationId);
//            doctorDTO.setPhoneNumber(phoneNumber);
//            doctorDTO.setPhyPraCerCode(java.net.URLDecoder.decode(phyPraCerCode,"UTF-8"));
//            doctorDTO.setPhyQuaCerCode(java.net.URLDecoder.decode(phyQuaCerCode,"UTF-8"));
//            doctorDTO.setTitle(title);
//            doctorDTO.setPracticeType(practiceType);
//            doctorDTO.setDescription(java.net.URLDecoder.decode(description,"UTF-8"));
//            doctorDTO.setSpecialty(java.net.URLDecoder.decode(specialty,"UTF-8"));
//            doctorDTO.setComHosId(comHosId);
//
//            userDTO.setPassword(java.net.URLDecoder.decode(password, "UTF-8"));
//            userDTO.setUserType(1);
//            userDTO.setNickname(java.net.URLDecoder.decode(name,"UTF-8"));
//            userDTO.setIdentificationId(identificationId);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            return new Result(null, false, "参数转码错误", 500);
//        }
//        Result<Integer> result = DoctorService.insert(doctorDTO);
//        if (!result.getSuccess()){
//            //插入Doctor未成功则直接返回错误原因
//            return  result;
//        } else {
//            //插入Doctor成功则再插入user表中
//            userDTO.setResDocId(result.getData());
//            Result<Integer> result1 = userService.insert(userDTO);
//            if (!result1.getSuccess()){
//                //向user表中插入失败则撤回对doctor表的插入
//                DoctorQuery doctorQuery = new DoctorQuery();
//                doctorQuery.setId(result.getData());
//                DoctorService.delete(doctorQuery);
//                return  result1;
//            } else {
//                return  Result.buildSuccessResult(null);
//            }
//        }
//    }

    //此处包括了添加信息至user表
    @RequestMapping(value = {"insert.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@ModelAttribute DoctorDTO doctorDTO, @ModelAttribute UserDTO userDTO) {
        Result<DoctorDTO> result = DoctorService.insertResultDO(doctorDTO);
        if (!result.getSuccess()){
            //插入Doctor未成功则直接返回错误原因
            return  result;
        } else {
            //插入Doctor成功则再插入user表中
            userDTO.setResDocId(result.getData().getId());
            userDTO.setUserType(UserDTO.UserType.doctor.getType());
            userDTO.setNickname(result.getData().getName());
            Result<Integer> result1 = userService.insert(userDTO);
            if (!result1.getSuccess()){
                //向user表中插入失败则撤回对doctor表的插入
                DoctorQuery doctorQuery = new DoctorQuery();
                doctorQuery.setId(result.getData().getId());
                DoctorService.delete(doctorQuery);
                return  result1;
            } else {
                return  Result.buildSuccessResult(null);
            }
        }
    }

    @RequestMapping(value = {"find.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result find(@RequestParam(value = "comHosId")Integer comHosId) {
        DoctorQuery doctorQuery = new DoctorQuery();
        doctorQuery.setComHosId(comHosId);
        return DoctorService.find(doctorQuery);
    }

    @RequestMapping(value = {"findwithbs.do"}, method = RequestMethod.GET)
    @ResponseBody
    public BootstrapJsonResult findwithbs(@RequestParam(value = "search", required = false) String search,
                                          @RequestParam(value = "order", required = false) String order,
                                          @RequestParam(value = "sort", required = false) String sort,
                                          @RequestParam(value = "limit", required = false) Integer limit,
                                          @RequestParam(value = "offset", required = false) Integer offset,
                                          @RequestParam(value = "title", required = false) Integer title,
                                          @RequestParam(value = "practiceType", required = false) Integer practiceType,
                                          @RequestParam(value = "comHosId", required = false) Integer comHosId) {
        DoctorQuery doctorQuery = new DoctorQuery();
        if (null != offset && null != limit) {
            doctorQuery.setPaging(true);
            doctorQuery.setPageIndex(offset);
            doctorQuery.setPageSize(limit);
        }
        if(null != search){
            doctorQuery.setVagueValue(search);
        }
        if(null != order){
            doctorQuery.setOrder(order);
        }
        if (null != sort){
            doctorQuery.setSort(sort);
        }
        if (null != title){
            doctorQuery.setTitle(title);
        }
        if (null != practiceType){
            doctorQuery.setPracticeType(practiceType);
        }
        if (null != comHosId){
            doctorQuery.setComHosId(comHosId);
        }
        Result<List> result = DoctorService.findWithVO(doctorQuery);
        if (result.getSuccess()) {
            BootstrapJsonResult bootstrapJsonResult = new BootstrapJsonResult();
            bootstrapJsonResult.setTotal(DoctorService.count(new DoctorQuery()).getData());
            bootstrapJsonResult.setRows(result.getData());
            return bootstrapJsonResult;
        }
        return new BootstrapJsonResult(0,new ArrayList());
    }

   /* @RequestMapping(value = {"get.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result get(){
        CommunityHospitalQuery doctorQuery = new CommunityHospitalQuery();
        return  doctorService.get(doctorQuery);
    }*/

    //此处包括了更新user表
    @RequestMapping(value = {"update.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result update(@ModelAttribute DoctorDTO doctorDTO, @ModelAttribute UserDTO userDTO) {
        //备份该医生doctor表中的状态
        DoctorQuery doctorQuery = new DoctorQuery();
        doctorQuery.setId(doctorDTO.getId());
        Result<DoctorDTO> doctorDTO1 = DoctorService.get(doctorQuery);
        //更新doctor表
        Result<Integer> result = DoctorService.update(doctorDTO);
            //若doctor更新失败则直接返回错误
        if (!result.getSuccess()){
            return  result;
        }
        //更新user表
            //用户名在doctorDTO中，且本方法不能修改密码
        userDTO.setNickname(doctorDTO.getName());
        userDTO.setPassword(null);
        Result<Integer> result1 = userService.update(userDTO);
            //若user表更新失败则对doctor做回档
        if (!result1.getSuccess()){
            DoctorService.update(doctorDTO1.getData());
            return result1;
        }
        return  result1;
    }

    @RequestMapping(value = {"delete.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam int id) {
        DoctorQuery doctorQuery = new DoctorQuery();
        doctorQuery.setId(id);
        return DoctorService.delete(doctorQuery);
    }
}
