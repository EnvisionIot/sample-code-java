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
import com.envision.app.portal.sdk.request.UserAssetListRequest;
import com.envision.app.portal.sdk.response.AssetResponse;
import com.envision.app.portal.sdk.response.UserAssetListResponse;

public class GetAssetsbyOrganization {
    public void getAssetsByOrganization(String accessKey, String secretKey, String orgId, String url) {
        UserAssetListRequest userAssetListRequest=new UserAssetListRequest("u16473063753681521",orgId);
        UserAssetListResponse response=Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(userAssetListRequest,UserAssetListResponse.class);

    }
}
