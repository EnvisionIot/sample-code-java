/**
 * Copyright (C), 2015-2022, Envision
 * FileName: Login
 * Author:   xibin.song
 * Date:     3/7/2022 10:14 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.aep.appportal.auth;

import com.alibaba.fastjson.JSON;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.LoginRequest;
import com.envision.app.portal.sdk.response.LoginResponse;
import com.envisioniot.enos.api.common.constant.request.Pagination;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/7/2022
 * @since 1.0.0
 */

public class Login {
    public String login(String accessKey, String secretKey, String orgId, String url) {
        LoginRequest loginRequest = new LoginRequest("songxibin2013", "Password1");
//        LoginRequest loginRequest = new LoginRequest("cat01.enos", "Cat@2020");

        LoginResponse loginResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(loginRequest, LoginResponse.class);
        System.out.println("Login res: " + JSON.toJSONString(loginResponse));
        return loginResponse.data.accessToken;
    }
}
