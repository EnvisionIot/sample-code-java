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
import com.envision.app.portal.sdk.request.MessageRingingRequest;
import com.envision.app.portal.sdk.request.UserAppListRequest;
import com.envision.app.portal.sdk.response.MessageRingingResponse;
import com.envision.app.portal.sdk.response.UserAppListResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/15/2022
 * @since 1.0.0
 */

public class GetUserApplications {
    public void getUserApplications(String accessKey, String secretKey, String orgId, String url, String accessToken) {
        UserAppListRequest userAppListRequest=new UserAppListRequest(accessToken);
        UserAppListResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(userAppListRequest, UserAppListResponse.class);
    }
}
