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
import com.envision.app.portal.sdk.request.AssetStructureRequest;
import com.envision.app.portal.sdk.request.UserAssetListRequest;
import com.envision.app.portal.sdk.response.AssetStructureResponse;
import com.envision.app.portal.sdk.response.UserAssetListResponse;

public class GetAssetsStructure {
    public void getAssetStructure(String accessKey, String secretKey, String orgId, String url, String accessToken) {
        AssetStructureRequest assetStructureRequest = new AssetStructureRequest("0x19kHPY", accessToken);
        AssetStructureResponse assetStructureResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(assetStructureRequest, AssetStructureResponse.class);


    }
}
