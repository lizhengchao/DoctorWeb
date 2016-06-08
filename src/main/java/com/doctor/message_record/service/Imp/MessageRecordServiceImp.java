package com.doctor.message_record.service.Imp;

import com.doctor.common.CommonService;
import com.doctor.message_record.dao.MessageRecordDAO;
import com.doctor.message_record.dto.MessageRecordQuery;
import com.doctor.message_record.dto.MessageReocrdDTO;
import com.doctor.message_record.service.MessageRecordService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by lzc on 2016/6/7.
 */
@Repository("MessageRecordService")
public class MessageRecordServiceImp extends CommonService<MessageReocrdDTO, MessageRecordQuery, MessageRecordDAO> implements MessageRecordService{

    @Resource(name = "MessageRecordDAO")
    private MessageRecordDAO messageRecordDAO;

    @Override
    public MessageRecordDAO getDao() {
        return messageRecordDAO;
    }


}
