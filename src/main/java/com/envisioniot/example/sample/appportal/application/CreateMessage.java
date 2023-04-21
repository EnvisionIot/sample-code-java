/**
 * Copyright (C), 2015-2022, Envision
 * FileName: AuthorizeAsset
 * Author:   xibin.song
 * Date:     3/15/2022 8:42 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.appportal.application;


import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.common.I18nString;
import com.envision.app.portal.sdk.dto.MessageProduceDTO;
import com.envision.app.portal.sdk.enums.MessageType;
import com.envision.app.portal.sdk.request.MessageProduceRequest;
import com.envision.app.portal.sdk.response.MessageProduceResponse;
import com.envisioniot.example.sample.utility.DateTimeUtil;

import java.util.ArrayList;
import java.util.List;

public class CreateMessage {
    public void createAlertMessage(String accessKey, String secretKey, String orgId, String url) {
        MessageProduceRequest messageProduceRequest = new MessageProduceRequest();
        List<MessageProduceDTO> messages = new ArrayList<MessageProduceDTO>();
        MessageProduceDTO messageProduceDTO = new MessageProduceDTO();
        messageProduceDTO.setType(MessageType.ALARM.getValue());
        messageProduceDTO.setMessageId("id_alert");
        messageProduceDTO.setAccessKey(accessKey);
        messageProduceDTO.setOrgId(orgId);
        messageProduceDTO.setBody(new I18nString());
        messageProduceDTO.setProduceTime(DateTimeUtil.getDateTime());
        messageProduceDTO.setZoneOffset("+08:00");
        messageProduceDTO.setLinkedAppId(accessKey);
        messageProduceDTO.setLinkedMenuCode("menu");
        messageProduceDTO.setLinkedStates("");
        messageProduceDTO.setAssetId("ChahG3d9");
        messageProduceDTO.setAuthUnitId("ChahG3d9");
        messageProduceDTO.setBody(new I18nString("alert body"));
        messageProduceDTO.setFeature(new I18nString("alert feature"));
        messageProduceDTO.setColor(1);
        messageProduceDTO.setRing(0);
        messageProduceDTO.setCallbackUrl("/");
        I18nString actionName=new I18nString();
        actionName.put("zh_CN","确认");
        actionName.put("en_US","ACK");
        messageProduceDTO.setActionName(actionName);
        messages.add(messageProduceDTO);
        messageProduceRequest.setMessages(messages);
        MessageProduceResponse messageProduceResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(messageProduceRequest, MessageProduceResponse.class);
    }

    public void createNormalMessage(String accessKey, String secretKey, String orgId, String url) {
        MessageProduceRequest messageProduceRequest = new MessageProduceRequest();
        List<MessageProduceDTO> messages = new ArrayList<MessageProduceDTO>();
        MessageProduceDTO messageProduceDTO = new MessageProduceDTO();
        messageProduceDTO.setType(MessageType.NOTICE.getValue());
        messageProduceDTO.setMessageId("normal_id");
        messageProduceDTO.setAccessKey(accessKey);
        messageProduceDTO.setOrgId(orgId);
        messageProduceDTO.setBody(new I18nString("normal body"));
        messageProduceDTO.setProduceTime(DateTimeUtil.getDateTime());
        messageProduceDTO.setZoneOffset("+08:00");
        messageProduceDTO.setFeature(new I18nString("normal feature"));
//        messageProduceDTO.setLinkedAppId("a4ba942c-ca4a-4b898ea0cf8c-0398-41a9");
//        messageProduceDTO.setLinkedMenuCode("menu");
//        messageProduceDTO.setLinkedStates("");
//        messageProduceDTO.setAssetId("ChahG3d9");
        messageProduceDTO.setAuthUnitId("ChahG3d9");
        messageProduceDTO.setColor(1);
        messageProduceDTO.setRing(0);
        messageProduceDTO.setCallbackUrl("/");
        I18nString actionName=new I18nString();
        actionName.put("zh_CN","确认");
        actionName.put("en_US","ACK");
        messageProduceDTO.setActionName(actionName);
        messages.add(messageProduceDTO);
        messageProduceRequest.setMessages(messages);
        MessageProduceResponse messageProduceResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(messageProduceRequest, MessageProduceResponse.class);
    }
}
