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
import com.envision.app.portal.sdk.request.AssetSynchronizationRequest;
import com.envision.app.portal.sdk.request.GetStructuresAssetsRequest;
import com.envision.app.portal.sdk.response.Response;
import com.envision.app.portal.sdk.response.StructureAssetsListResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SyncAsset {
    public void syncAsset(String accessKey, String secretKey, String orgId, String url) {
        AssetSynchronizationRequest request=new AssetSynchronizationRequest(orgId);
        Response response=Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(request, Response.class);
    }
}
