package com.doctor.message_record.service;

import com.doctor.common.Result;
import com.doctor.common.Service;
import com.doctor.message_record.dto.MessageRecordQuery;
import com.doctor.message_record.dto.MessageReocrdDTO;

/**
 * Created by lzc on 2016/6/7.
 */
public interface MessageRecordService extends Service<MessageReocrdDTO, MessageRecordQuery>{

    public Result findWithVO();
}
