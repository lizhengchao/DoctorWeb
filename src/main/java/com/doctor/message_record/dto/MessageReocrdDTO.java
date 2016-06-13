package com.doctor.message_record.dto;

import java.util.Date;

/**
 * Created by lzc on 2016/6/7.
 */
public class MessageReocrdDTO {
    private Integer id;
    private Integer resId;
    private Integer comHosId;
    private Integer docId;
    private String requestMessage;
    private String answerMessage;
    private Date requestTime;
    private Date answerTime;
    private Integer isHandle; //删选处理或未处理

    public Integer getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(Integer isHandle) {
        this.isHandle = isHandle;
    }

    public String getAnswerMessage() {
        return answerMessage;
    }

    public void setAnswerMessage(String answerMessage) {
        this.answerMessage = answerMessage;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public Integer getComHosId() {
        return comHosId;
    }

    public void setComHosId(Integer comHosId) {
        this.comHosId = comHosId;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public MessageReocrdDTO() {
    }

    public MessageReocrdDTO(MessageReocrdDTO messageReocrdDTO) {
        this.id = messageReocrdDTO.id;
        this.resId = messageReocrdDTO.resId;
        this.comHosId = messageReocrdDTO.comHosId;
        this.docId = messageReocrdDTO.docId;
        this.requestMessage = messageReocrdDTO.requestMessage;
        this.answerMessage = messageReocrdDTO.answerMessage;
        this.requestTime = messageReocrdDTO.requestTime;
        this.answerTime = messageReocrdDTO.answerTime;
        this.isHandle = messageReocrdDTO.isHandle;
    }
}
