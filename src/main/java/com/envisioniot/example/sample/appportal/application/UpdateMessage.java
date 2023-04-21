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
import com.envision.app.portal.sdk.dto.MessageUpdateDTO;
import com.envision.app.portal.sdk.enums.MessageType;
import com.envision.app.portal.sdk.request.MessageProduceRequest;
import com.envision.app.portal.sdk.request.MessageUpdateRequest;
import com.envision.app.portal.sdk.response.MessageProduceResponse;
import com.envision.app.portal.sdk.response.MessageUpdateResponse;
import com.envisioniot.example.sample.utility.DateTimeUtil;

import java.util.ArrayList;
import java.util.List;

public class UpdateMessage {
    public void updateAlertMessage(String accessKey, String secretKey, String orgId, String url) {
        List<MessageUpdateDTO> messages=new ArrayList<>();
        MessageUpdateDTO messageUpdateDTO = new MessageUpdateDTO();
        messageUpdateDTO.setAccessKey(accessKey);
        messageUpdateDTO.setMessageId("message_id");
        messageUpdateDTO.setState(1);
        messages.add(messageUpdateDTO);
        MessageUpdateRequest messageUpdateRequest = new MessageUpdateRequest();
        messageUpdateRequest.setMessages(messages);
        MessageUpdateResponse messageUpdateResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(messageUpdateRequest, MessageUpdateResponse.class);
    }
}
