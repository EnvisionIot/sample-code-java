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
import com.envision.app.portal.sdk.request.GetStructuresAssetsRequest;
import com.envision.app.portal.sdk.response.AssetStructureResponse;
import com.envision.app.portal.sdk.response.StructureAssetsListResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GetStructureAsset {
    public void getStructureAsset(String accessKey, String secretKey, String orgId, String url, String accessToken) {
        List<String> structureIds = new ArrayList<>();
        structureIds.add("sg15780327471491");
        structureIds.add("sg16110406447781763");
        GetStructuresAssetsRequest getStructuresAssetsRequest = new GetStructuresAssetsRequest(accessToken, structureIds, Locale.ENGLISH);
        StructureAssetsListResponse structureAssetsListResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(getStructuresAssetsRequest, StructureAssetsListResponse.class);
    }
}
