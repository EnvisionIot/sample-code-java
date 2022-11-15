/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetTokenInfomation
 * Author:   xibin.song
 * Date:     3/7/2022 9:10 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.aep.appportal.auth;

import com.alibaba.fastjson.JSON;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.TokenInfoRequest;
import com.envision.app.portal.sdk.response.TokenInfoResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/7/2022
 * @since 1.0.0
 */

public class GetTokenInfomation {
    public void getTokenInfomation(String accessKey, String secretKey, String orgId, String url, String accessToken) {
        TokenInfoRequest tokenInfoRequest = new TokenInfoRequest(accessToken);
//        tokenInfoRequest.queryParams().put("orgId",orgId);
        TokenInfoResponse tokenInfoResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(tokenInfoRequest, TokenInfoResponse.class);
        System.out.println("Get token info res: " + JSON.toJSONString(tokenInfoResponse));
    }
}
