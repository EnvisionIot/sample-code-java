/**
 * Copyright (C), 2015-2022, Envision
 * FileName: AuthorizeAsset
 * Author:   xibin.song
 * Date:     3/15/2022 8:42 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.aep.appportal.asset;


import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.AppendAssetsRequest;
import com.envision.app.portal.sdk.request.AssetPermissionCheckRequest;
import com.envision.app.portal.sdk.response.AssetPermissionCheckResponse;
import com.envision.app.portal.sdk.response.Response;

import java.util.Arrays;

public class CheckAssetPermission {
    public void checkAssetPermission(String accessKey, String secretKey, String orgId, String url, String accessToken) {
        AssetPermissionCheckRequest assetPermissionCheckRequest = new AssetPermissionCheckRequest(Arrays.asList("8PfrRtpK","5TFlJNut", "q6ZxogVg","aWnBYiMz"), accessToken);
        AssetPermissionCheckResponse assetPermissionCheckResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(assetPermissionCheckRequest, AssetPermissionCheckResponse.class);
    }
}
