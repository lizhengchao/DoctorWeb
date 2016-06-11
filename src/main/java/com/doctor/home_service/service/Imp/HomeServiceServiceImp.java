package com.doctor.home_service.service.Imp;

import com.doctor.common.CommonService;
import com.doctor.common.Result;
import com.doctor.home_service.dao.HomeServiceDAO;
import com.doctor.home_service.dto.HomeServiceDTO;
import com.doctor.home_service.dto.HomeServiceQuery;
import com.doctor.home_service.dto.HomeServiceVO;
import com.doctor.home_service.service.HomeServiceService;
import com.doctor.resident.dao.ResidentDAO;
import com.doctor.resident.dto.ResidentDTO;
import com.doctor.resident.dto.ResidentQuery;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lzc on 2016/6/8.
 */
@Repository("HomeServiceService")
public class HomeServiceServiceImp extends CommonService<HomeServiceDTO, HomeServiceQuery, HomeServiceDAO>
    implements HomeServiceService{

    @Resource(name="HomeServiceDAO")
    private HomeServiceDAO homeServiceDAO;

    @Resource(name = "ResidentDAO")
    private ResidentDAO residentDAO;

    @Override
    public HomeServiceDAO getDao() {
        return homeServiceDAO;
    }

    @Override
    public Result findWithVO(HomeServiceQuery homeServiceQuery) {
        Result<List<HomeServiceDTO>> result = super.find(homeServiceQuery);
        List<HomeServiceVO> list = new LinkedList<HomeServiceVO>();
        if (result.getSuccess()){
            try {
                for (HomeServiceDTO homeServiceDTO: result.getData()){
                    HomeServiceVO homeServiceVO = new HomeServiceVO(homeServiceDTO);
                    //取出居民姓名
                    ResidentQuery residentQuery = new ResidentQuery();
                    residentQuery.setId(homeServiceDTO.getResId());
                    ResidentDTO residentDTO = residentDAO.get(residentQuery);
                    if (null != residentDTO){
                        homeServiceVO.setResName(residentDTO.getName());
                    }
                    homeServiceVO.setRequestInfoTrim(trimMessage(homeServiceVO.getRequestInfo()));

                    list.add(homeServiceVO);
                }
                return Result.buildSuccessResult(list);
            } catch (Exception e){
                e.printStackTrace();
                return new Result(null, false, "服务器异常",500);
            }
        } else {
            return  result;
        }
    }

    //为了前端展示时不会过长
    public String trimMessage(String message){
        if (null != message) {
            if (message.length() >= 10) {
                return message.substring(0, 10) + "...";
            } else {
                return message;
            }
        } else {
            return message;
        }
    }
}
