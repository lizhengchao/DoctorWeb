package com.doctor.message_record.service.Imp;

import com.doctor.common.CommonService;
import com.doctor.common.Result;
import com.doctor.doctor.dao.DoctorDAO;
import com.doctor.doctor.dto.DoctorDTO;
import com.doctor.doctor.dto.DoctorQuery;
import com.doctor.message_record.dao.MessageRecordDAO;
import com.doctor.message_record.dto.MessageRecordQuery;
import com.doctor.message_record.dto.MessageRecordVO;
import com.doctor.message_record.dto.MessageReocrdDTO;
import com.doctor.message_record.service.MessageRecordService;
import com.doctor.resident.dao.ResidentDAO;
import com.doctor.resident.dto.ResidentDTO;
import com.doctor.resident.dto.ResidentQuery;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lzc on 2016/6/7.
 */

@Repository("MessageRecordService")
public class MessageRecordServiceImp extends CommonService<MessageReocrdDTO, MessageRecordQuery, MessageRecordDAO>
        implements MessageRecordService{

    @Resource(name = "MessageRecordDAO")
    private MessageRecordDAO messageRecordDAO;

    @Resource(name = "ResidentDAO")
    private ResidentDAO residentDAO;

    @Resource(name = "DoctorDAO")
    private DoctorDAO doctorDAO;

    @Override
    public MessageRecordDAO getDao() {
        return messageRecordDAO;
    }

    @Override
    public Result findWithVO(MessageRecordQuery messageRecordQuery) {
        Result<List<MessageReocrdDTO>> result = super.find(messageRecordQuery);
        List<MessageRecordVO> list = new LinkedList<MessageRecordVO>();
        if (result.getSuccess()){
            try {
                for (MessageReocrdDTO messageReocrdDTO: result.getData()){
                    MessageRecordVO messageRecordVO = new MessageRecordVO(messageReocrdDTO);
                    //塞入居民姓名
                    ResidentQuery residentQuery = new ResidentQuery();
                    residentQuery.setId(messageReocrdDTO.getResId());
                    ResidentDTO residentDTO = residentDAO.get(residentQuery);
                    if (null != residentDTO){
                        messageRecordVO.setResName(residentDTO.getName());
                    }
                    //塞入医生姓名
                    if (messageReocrdDTO.getIsHandle()==1){
                        DoctorQuery doctorQuery = new DoctorQuery();
                        doctorQuery.setId(messageReocrdDTO.getDocId());
                        DoctorDTO doctorDTO = doctorDAO.get(doctorQuery);
                        if (null != doctorDTO){
                            messageRecordVO.setDocName(doctorDTO.getName());
                        }
                    }
                    messageRecordVO.setAnswerMessageTrim(trimMessage(messageRecordVO.getAnswerMessage()));
                    messageRecordVO.setRequestMessageTrim(trimMessage(messageRecordVO.getRequestMessage()));

                    list.add(messageRecordVO);
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
