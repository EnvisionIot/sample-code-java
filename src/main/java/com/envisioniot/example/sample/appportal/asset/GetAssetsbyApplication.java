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
import com.envision.app.portal.sdk.request.AssetRequest;
import com.envision.app.portal.sdk.response.AssetResponse;

public class GetAssetsbyApplication {
    public void getAssetsByApplication(String accessKey, String secretKey, String orgId, String url, String accessToken) {
        AssetRequest assetRequest = new AssetRequest("c7f5edb8-322e-4e95-bd59-fc606a28d2f1", accessToken);
        AssetResponse assetResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(assetRequest, AssetResponse.class);
    }
}
