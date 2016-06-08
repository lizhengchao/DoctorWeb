package com.doctor.user.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.doctor.common.BootstrapJsonResult;
import com.doctor.common.CommonController;
import com.doctor.common.Result;
import com.doctor.community_hospital.service.CommunityHospitalService;
import com.doctor.doctor.dto.DoctorDTO;
import com.doctor.resident.dto.ResidentDTO;
import com.doctor.user.dto.UserDTO;
import com.doctor.user.dto.UserQuery;
import com.doctor.user.dto.UserVO;
import com.doctor.user.service.UserService;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzc on 2016/5/17.
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends CommonController{

    @Resource(name = "UserService")
    private UserService userService;

    @RequestMapping(value = {"haslogin.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result hasLogin() {
        UserDTO userDTO = new UserDTO();
        HttpSession session = request1.getSession();
        if (null == session.getAttribute("userId")) {
            return new Result(null, false, "用户还未登录", 500);
        } else {
            userDTO.setId((Integer) session.getAttribute("userId"));
            userDTO.setNickname((String) session.getAttribute("nickname"));
            userDTO.setResDocId((Integer)session.getAttribute("residentId"));
            return Result.buildSuccessResult(userDTO);
        }
    }

    @RequestMapping(value = {"login.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result login(@RequestParam(value = "userType", required = true) Integer userType,
                        @RequestParam(value = "nickname", required = true) String nickname,
                        @RequestParam(value = "password", required = true) String password,
                        @RequestParam(value = "isSaveInfo", required = false)boolean isSaveInfo){
        UserQuery userQuery = new UserQuery();
        userQuery.setUserType(userType);
        userQuery.setNickname(nickname);
        userQuery.setPassword(password);
        Result<UserVO> result = userService.login(userQuery);

        //如果登陆成功则将用户id等信息存入session中
        if (result.getSuccess() && isSaveInfo){
            HttpSession session = request1.getSession();
            session.setAttribute("userId", result.getData().getId());
            session.setAttribute("nickname", result.getData().getNickname());
            if (userType.equals(UserDTO.UserType.doctor.getType())){
                session.setAttribute("doctorId", result.getData().getResDocId());
            } else if (userType.equals(UserDTO.UserType.resident.getType())){
                session.setAttribute("residentId", result.getData().getResDocId());
            }
        }
        return  result;
    }

    @RequestMapping(value = {"logout.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result logout(){
        HttpSession session = request1.getSession();
        if (null != session.getAttribute("userId")){
            session.removeAttribute("userId");
        }
        if (null != session.getAttribute("doctorId")){
            session.removeAttribute("doctorId");
        }
        if (null != session.getAttribute("nickname")){
            session.removeAttribute("nickname");
        }
        if (null != session.getAttribute("residentId")){
            session.removeAttribute("residentId");
        }
        return Result.buildSuccessResult(null);
    }

//    //管理员权限
//    @RequestMapping(value = {"insertDoctor.do"}, method = RequestMethod.GET)
//    @ResponseBody
//    public Result insertDoctor(@RequestParam(value = "userType", required = true) Integer userType,
//                       @RequestParam(value = "identificationId", required = true) Integer identificationId,
//                       @RequestParam(value = "nickname", required = true) String nickname,
//                       @RequestParam(value = "password", required = true) String password,
//                       @RequestParam(value = "name", required = true) String name,
//                       @RequestParam(value = "phoneNumber", required = true) Long phoneNumber,
//                       @RequestParam(value = "titleName", required = true) String titleName,
//                       @RequestParam(value = "comHosId", required = true) Integer comHosId) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserType(userType);
//        userDTO.setIdentificationId(identificationId);
//        userDTO.setNickname(nickname);
//        userDTO.setPassword(password);
//
//        DoctorDTO doctorDTO = new DoctorDTO();
//        doctorDTO.setName(name);
//        doctorDTO.setPhoneNumber(phoneNumber);
//        doctorDTO.setTitleName(titleName);
//        doctorDTO.setIdentificationId(identificationId);
//        doctorDTO.setComHosId(comHosId);
//        return userService.registerDoctorUser(userDTO, doctorDTO);
//    }

    //患者注册不一定需要身份证号信息，可作为游客直接注册
    @RequestMapping(value = {"insertResident.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result insertResident(@RequestParam(value = "userType", required = true) Integer userType,
                       @RequestParam(value = "nickname", required = true) String nickname,
                       @RequestParam(value = "password", required = true) String password,
                       @RequestParam(value = "identificationId", required = false) String identificationId
                       ) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserType(userType);
        userDTO.setIdentificationId(identificationId);
        userDTO.setNickname(nickname);
        userDTO.setPassword(password);
        return userService.insert(userDTO);
    }

    //更新密码
    @RequestMapping(value = {"updatePwd.do"}, method = RequestMethod.POST)
    @ResponseBody
    public  Result updatePwd(@RequestParam(value = "oldPassword")String oldPassword,
                             @RequestParam(value = "newPassword")String newPassword){
        HttpSession session = request1.getSession();
        Integer userId = (Integer)session.getAttribute("userId");
        UserQuery userQuery = new UserQuery();
        userQuery.setId(userId);
        Result<UserDTO> result = userService.get(userQuery);
        if (result.getSuccess()){
            if (result.getData().getPassword().equals(oldPassword)){
                UserDTO userDTO = result.getData();
                userDTO.setPassword(newPassword);
                userService.update(userDTO);
                return new Result(null ,true, "更新密码成功", 200);
            } else {
                return new Result(null, false, "原密码错误", 500);
            }
        } else {
            return  result;
        }
    }

    //绑定医院
    @RequestMapping(value = {"bindingComHos.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Result bindingHos(@RequestParam(value = "realName", required = true) String realName,
                             @RequestParam(value = "identification", required = true)String identification,
                             @RequestParam(value = "comHosId", required = true)Integer comHosId){
        HttpSession session = request1.getSession();
        Integer userId = (Integer)session.getAttribute("userId");
        Result<ResidentDTO> result = userService.bingComHos(userId, encodeStr(realName), identification, comHosId);
        //将residentId放入session中
        if (result.getSuccess()){
            session.setAttribute("residentId", result.getData().getId());
        }
        return result;

    }

    @RequestMapping(value = {"find.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result find(@RequestParam(value = "userId", required = false) Integer userId,
                       @RequestParam(value = "userType", required = false) Integer userType,
                       @RequestParam(value = "identificationId", required = false) String identificationId) {
        UserQuery userQuery = new UserQuery();
        userQuery.setId(userId);
        userQuery.setUserType(userType);
        userQuery.setIdentificationId(identificationId);
        return userService.find(userQuery);
    }

    @RequestMapping(value = {"findwithbs.do"}, method = RequestMethod.GET)
    @ResponseBody
    public BootstrapJsonResult findwithbs(@RequestParam(value = "order") String order,
                                          @RequestParam(value = "sort") String sort,
                                          @RequestParam(value = "offset") Integer offset,
                                          @RequestParam(value = "limit") Integer limit,
                                          @RequestParam(value = "userType", required = false) Integer userType,
                                          @RequestParam(value = "identificationId", required = false) String identificationId) {
        UserQuery userQuery = new UserQuery();
        userQuery.setPaging(true);
        userQuery.setPageIndex(offset);
        userQuery.setPageSize(limit);
        userQuery.setUserType(userType);
        userQuery.setIdentificationId(identificationId);
        Result<List<UserDTO>> result = userService.find(userQuery);
        if (result.getSuccess()) {
            BootstrapJsonResult bootstrapJsonResult = new BootstrapJsonResult();
            bootstrapJsonResult.setTotal(userService.count(new UserQuery()).getData());
            bootstrapJsonResult.setRows(result.getData());
            return bootstrapJsonResult;
        }
        return new BootstrapJsonResult();
    }

   /* @RequestMapping(value = {"get.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result get(){
        UserQuery userQuery = new UserQuery();
        return  userService.get(userQuery);
    }*/

    //管理员或自身权限
    @RequestMapping(value = {"update.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result update(@RequestParam(value = "id", required = true) Integer id,
                         @RequestParam(value = "nickname", required = false) String nickname,
                         @RequestParam(value = "password", required = false) String password,
                         @RequestParam(value = "identificationId", required = false) String identificationId) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setNickname(nickname);
        userDTO.setPassword(password);
        userDTO.setIdentificationId(identificationId);
        return userService.update(userDTO);
    }

    //管理员权限
    @RequestMapping(value = {"delete.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam int id) {
        UserQuery userQuery = new UserQuery();
        userQuery.setId(id);
        return userService.delete(userQuery);
    }

}