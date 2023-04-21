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
import com.envision.app.portal.sdk.dto.MessageUpdateDTO;
import com.envision.app.portal.sdk.request.MessageUpdateRequest;
import com.envision.app.portal.sdk.request.UnresolvedMessageListRequest;
import com.envision.app.portal.sdk.response.MessageUpdateResponse;
import com.envision.app.portal.sdk.response.UnresolvedMessageListResponse;

import java.util.ArrayList;
import java.util.List;

public class GetUnresolvedMessages {
    public void getUnresolvedMessages(String accessKey, String secretKey, String orgId, String url, String accessToken) {
        UnresolvedMessageListRequest request=new UnresolvedMessageListRequest(accessKey,orgId);
        UnresolvedMessageListResponse response= Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(request,UnresolvedMessageListResponse.class);
    }
}
