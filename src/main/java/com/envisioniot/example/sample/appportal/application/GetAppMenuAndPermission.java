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
import com.envision.app.portal.sdk.request.AppResourceRequest;
import com.envision.app.portal.sdk.request.AppendAssetsRequest;
import com.envision.app.portal.sdk.response.AppResourceResponse;
import com.envision.app.portal.sdk.response.Response;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/15/2022
 * @since 1.0.0
 */

public class GetAppMenuAndPermission {
    public void getAppMenuAndPermission(String accessKey, String secretKey, String orgId, String url, String accessToken) {
        AppResourceRequest appResourceRequest = new AppResourceRequest("c7f5edb8-322e-4e95-bd59-fc606a28d2f1", accessToken);
        AppResourceResponse appResourceResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(appResourceRequest, AppResourceResponse.class);
    }
}
