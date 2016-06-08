package com.doctor.user.service;

import com.doctor.common.Result;
import com.doctor.common.Service;
import com.doctor.doctor.dto.DoctorDTO;
import com.doctor.resident.dto.ResidentDTO;
import com.doctor.user.dto.UserDTO;
import com.doctor.user.dto.UserQuery;
import com.doctor.user.dto.UserVO;

/**
 * Created by lzc on 2016/5/17.
 */
public interface UserService extends Service<UserDTO, UserQuery> {
//    //注册医生用户
//    public Result<Integer> registerDoctorUser(UserDTO userDTO, DoctorDTO doctorDTO);

    //注册患者用户
    public Result<Integer> registerResidentUser(UserDTO userDTO);

    //登陆
    public Result<UserVO> login(UserQuery userQuery);

    //居民绑定社区医院信息
    public Result<ResidentDTO> bingComHos(Integer userId, String realName, String identification, Integer comHosId);
}
