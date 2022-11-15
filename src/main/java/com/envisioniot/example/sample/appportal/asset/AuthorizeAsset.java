/**
 * Copyright (C), 2015-2022, Envision
 * FileName: AuthorizeAsset
 * Author:   xibin.song
 * Date:     3/15/2022 8:42 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.appportal.asset;


import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.AppendAssetsRequest;
import com.envision.app.portal.sdk.response.Response;

import java.util.Arrays;

public class AuthorizeAsset {
    public void authorizeAsset(String accessKey, String secretKey, String orgId, String url) {
        AppendAssetsRequest appendAssetsRequest=new AppendAssetsRequest("u16473063753681521",orgId, Arrays.asList("8PfrRtpK","5TFlJNut"));
        appendAssetsRequest.setEdgeEnvironment(false);
        Response response= Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(appendAssetsRequest,Response.class);
    }
}
