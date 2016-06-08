package com.doctor.user.service.imp;

/**
 * Created by lzc on 2016/5/17.
 */

import com.doctor.common.CommonService;
import com.doctor.common.Result;
import com.doctor.community_hospital.dao.CommunityHospitalDAO;
import com.doctor.community_hospital.dto.CommunityHospitalDTO;
import com.doctor.community_hospital.dto.CommunityHospitalQuery;
import com.doctor.community_hospital.service.CommunityHospitalService;
import com.doctor.doctor.dao.DoctorDAO;
import com.doctor.doctor.dto.DoctorDTO;
import com.doctor.doctor.dto.DoctorQuery;
import com.doctor.resident.dao.ResidentDAO;
import com.doctor.resident.dto.ResidentDTO;
import com.doctor.resident.dto.ResidentQuery;
import com.doctor.user.dao.UserDAO;
import com.doctor.user.dto.UserDTO;
import com.doctor.user.dto.UserQuery;
import com.doctor.user.dto.UserVO;
import com.doctor.user.service.UserService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("UserService")
public class UserServiceImp extends CommonService<UserDTO, UserQuery,UserDAO>
        implements UserService {

    @Resource(name = "UserDAO")
    private UserDAO userDAO;

    @Resource(name = "DoctorDAO")
    private DoctorDAO doctorDAO;

    @Resource(name = "ResidentDAO")
    private ResidentDAO residentDAO;

    @Resource(name = "CommunityHospitalDAO")
    private CommunityHospitalDAO communityHospitalDAO;

//    @Override
//    public Result<Integer> registerDoctorUser(UserDTO userDTO, DoctorDTO doctorDTO) {
//        try {
//            /*
//                医生表新增时的判断逻辑，此处做了身份判断则把下面部分的身份判断去掉
//             */
//
//            UserQuery userQuery = new UserQuery();
//            userQuery.setNickname(userDTO.getNickname());
//            if(null != getDao().get(userQuery)){
//                return  new Result<Integer>(null, false, "该用户已存在", 500);
//            }
//            if (null != userDTO.getIdentificationId()){
//                userQuery = new UserQuery();
//                userQuery.setIdentificationId(userDTO.getIdentificationId());
//                userQuery.setUserType(userDTO.getUserType());
//                if(null != getDao().get(userQuery)){
//                    return  new Result<Integer>(null, false, "身份证号码已存在", 500);
//                }
//            }
//            return Result.buildSuccessResult(getDao().insert(userDTO));
//        } catch (Exception e){
//            e.printStackTrace();
//            return  new Result<Integer>(null, false, "服务器错误",500);
//        }
//    }

    @Override
    public Result<Integer> registerResidentUser(UserDTO userDTO) {
        try {
            UserQuery userQuery = new UserQuery();
            userQuery.setNickname(userDTO.getNickname());
            if(null != getDao().get(userQuery)){
                return  new Result<Integer>(null, false, "该用户已存在", 500);
            }
            if (null != userDTO.getIdentificationId()){
                userQuery = new UserQuery();
                userQuery.setIdentificationId(userDTO.getIdentificationId());
                userQuery.setUserType(userDTO.getUserType());
                if(null != getDao().get(userQuery)){
                    return  new Result<Integer>(null, false, "身份证号码已存在", 500);
                }
            }
            return Result.buildSuccessResult(getDao().insert(userDTO));
        } catch (Exception e){
            e.printStackTrace();
            return  new Result<Integer>(null, false, "服务器错误",500);
        }
    }

    @Override
    public Result<UserVO> login(UserQuery userQuery) {
        try {
            UserDTO userDTO = getDao().get(userQuery);
            if(null == userDTO){
                return  new Result<UserVO>(null, false, "用户名或密码错误", 500);
            } else {
                UserVO userVO = new UserVO();
                userVO.setDTO(userDTO);
                //登录类型为医生则从医生表中查找社区机构id，并加入VO
                if (userQuery.getUserType().equals(UserDTO.UserType.doctor.getType())) {
                    DoctorQuery doctorQuery = new DoctorQuery();
                    doctorQuery.setId(userQuery.getResDocId());
                    DoctorDTO doctorDTO = doctorDAO.get(doctorQuery);
                    if (null != doctorDTO){
                        userVO.setComHosId(doctorDTO.getComHosId());
                        //将所属社区医院名字加入VO
                        CommunityHospitalQuery communityHospitalQuery = new CommunityHospitalQuery();
                        communityHospitalQuery.setId(doctorDTO.getComHosId());
                        CommunityHospitalDTO communityHospitalDTO = communityHospitalDAO.get(communityHospitalQuery);
                        if (null != communityHospitalDTO){
                            userVO.setComHosName(communityHospitalDTO.getName());
                        }
                    }
                    //登录类型为居民
                } else if (userQuery.getUserType().equals(UserDTO.UserType.resident.getType())){
                    ResidentQuery residentQuery = new ResidentQuery();
                    residentQuery.setId(userQuery.getResDocId());
                    ResidentDTO residentDTO = residentDAO.get(residentQuery);
                    if (null != residentDTO) {
                        userVO.setComHosId(residentDTO.getComHosId());
                        //将所属社区医院名字加入VO
                        CommunityHospitalQuery communityHospitalQuery = new CommunityHospitalQuery();
                        communityHospitalQuery.setId(residentDTO.getComHosId());
                        CommunityHospitalDTO communityHospitalDTO = communityHospitalDAO.get(communityHospitalQuery);
                        if (null != communityHospitalDTO) {
                            userVO.setComHosName(communityHospitalDTO.getName());
                        }
                    }
                }
                return Result.buildSuccessResult(userVO);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new Result<UserVO>(null, false, "服务器错误", 500);
        }
    }

    @Override
    public Result<ResidentDTO> bingComHos(Integer userId, String realName, String identification, Integer comHosId) {
        ResidentQuery residentQuery = new ResidentQuery();
        residentQuery.setName(realName);
        residentQuery.setIdentificationId(identification.toString());
        residentQuery.setComHosId(comHosId);
        ResidentDTO residentDTO = residentDAO.get(residentQuery);
        if (null != residentDTO){
            //信息正确，则将resident绑定至user上
            //获取当前user
            UserQuery userQuery =new UserQuery();
            userQuery.setId(userId);
            UserDTO userDTO = userDAO.get(userQuery);
            //将resident信息和身份证号加入user
            userDTO.setResDocId(residentDTO.getId());
            userDTO.setIdentificationId(identification);
            userDAO.update(userDTO);
            return Result.buildSuccessResult(residentDTO);
        } else {
            return new Result<ResidentDTO>(null, false, "您不在该社区中或者您的信息填写有误", 500);
        }
    }

    @Override
    public UserDAO getDao() {
        return userDAO;
    }

}
