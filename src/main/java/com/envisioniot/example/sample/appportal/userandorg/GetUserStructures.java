/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetOrganizationList
 * Author:   xibin.song
 * Date:     3/8/2022 9:52 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.appportal.userandorg;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.UserInfoRequest;
import com.envision.app.portal.sdk.request.UserStructuresRequest;
import com.envision.app.portal.sdk.response.UserInfoResponse;
import com.envision.app.portal.sdk.response.UserStructuresResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/8/2022
 * @since 1.0.0
 */

public class GetUserStructures {
    public void getUserStructures(String accessKey, String secretKey, String orgId, String url, String accessToken) {
        UserStructuresRequest request=new UserStructuresRequest(accessToken);
        UserStructuresResponse response=Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(request,UserStructuresResponse.class);
    }
}
