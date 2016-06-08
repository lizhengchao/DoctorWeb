package com.doctor.message_record.dao.Imp;

import com.doctor.common.CommonDAO;
import com.doctor.message_record.dao.MessageRecordDAO;
import com.doctor.message_record.dto.MessageRecordQuery;
import com.doctor.message_record.dto.MessageReocrdDTO;
import org.springframework.stereotype.Repository;

/**
 * Created by lzc on 2016/6/7.
 */
@Repository("MessageRecordDAO")
public class MessageRecordDAOImp extends CommonDAO<MessageReocrdDTO, MessageRecordQuery> implements MessageRecordDAO{
    @Override
    public String getPrefix() {
        return "com.doctor.message_record.";
    }
}
