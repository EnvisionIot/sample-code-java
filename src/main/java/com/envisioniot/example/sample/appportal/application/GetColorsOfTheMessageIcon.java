/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetAppMenuAndPermission
 * Author:   xibin.song
 * Date:     3/15/2022 4:57 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.appportal.application;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.AppResourceRequest;
import com.envision.app.portal.sdk.request.MessageColorRequest;
import com.envision.app.portal.sdk.response.AppResourceResponse;
import com.envision.app.portal.sdk.response.MessageColorResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/15/2022
 * @since 1.0.0
 */

public class GetColorsOfTheMessageIcon {
    public void getColorsOfTheMessageIcon(String accessKey, String secretKey, String orgId, String url) {
        MessageColorRequest messageColorRequest = new MessageColorRequest();
        MessageColorResponse messageColorResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(messageColorRequest, MessageColorResponse.class);
    }
}
