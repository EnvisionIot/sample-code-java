/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetAppMenuAndPermission
 * Author:   xibin.song
 * Date:     3/15/2022 4:57 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.aep.appportal.application;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.MessageColorRequest;
import com.envision.app.portal.sdk.request.MessageRingingRequest;
import com.envision.app.portal.sdk.response.MessageColorResponse;
import com.envision.app.portal.sdk.response.MessageRingingResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/15/2022
 * @since 1.0.0
 */

public class GetMessageRingtones {
    public void getMessageRingtones(String accessKey, String secretKey, String orgId, String url) {
        MessageRingingRequest messageColorRequest=new MessageRingingRequest();
        MessageRingingResponse response=Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(messageColorRequest,MessageRingingResponse.class);
    }
}
