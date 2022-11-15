/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAndJoinUser
 * Author:   xibin.song
 * Date:     3/7/2022 4:32 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.appportal.userandorg;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.UserCreateAndJoinRequest;
import com.envision.app.portal.sdk.response.UserCreateAndJoinResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/7/2022
 * @since 1.0.0
 */

public class CreateAndJoinUser {
    public void createAndJoinUser(String accessKey, String secretKey, String orgId, String url) {
        UserCreateAndJoinRequest userCreateAndJoinRequest = new UserCreateAndJoinRequest("songxibin2013", "iotsoft", "songxibin2013@gmail.com", orgId, "zh_CN", "songxibin2021");
        //
//        UserCreateAndJoinRequest userCreateAndJoinRequest = new UserCreateAndJoinRequest("songxibin2021", "", "songxibin2021@gmail.com", orgId, "zh_CN", "songxibin2021");
        UserCreateAndJoinResponse userCreateAndJoinResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(userCreateAndJoinRequest, UserCreateAndJoinResponse.class);
    }
}
