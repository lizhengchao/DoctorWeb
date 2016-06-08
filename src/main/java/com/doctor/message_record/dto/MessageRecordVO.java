package com.doctor.message_record.dto;

/**
 * Created by lzc on 2016/6/8.
 */
public class MessageRecordVO extends MessageReocrdDTO{
    private String resName;
    private String requestMessageTrim;
    private String answerMessageTrim;

    public String getAnswerMessageTrim() {
        return answerMessageTrim;
    }

    public void setAnswerMessageTrim(String answerMessageTrim) {
        this.answerMessageTrim = answerMessageTrim;
    }

    public String getRequestMessageTrim() {
        return requestMessageTrim;
    }

    public void setRequestMessageTrim(String requestMessageTrim) {
        this.requestMessageTrim = requestMessageTrim;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public MessageRecordVO(MessageReocrdDTO messageReocrdDTO) {
        super(messageReocrdDTO);
    }
}
