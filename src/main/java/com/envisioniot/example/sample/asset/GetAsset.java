/**
 * Copyright (C), 2015-2021, Envision
 * FileName: getThings
 * Author:   xibin.song
 * Date:     12/6/2021 10:04 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.asset;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.asset_service.v2_1.GetAssetRequest;
import com.envisioniot.enos.asset_service.v2_1.GetAssetResponse;

/**
 * https://support.envisioniot.com/docs/model-api/en/2.2.0/getmodel   <br>
 * refer to the resources/GetThings/model_EPB_Battery_Socket.json file
 * 〈〉
 *
 * @author xibin.song
 * @create 12/6/2021
 * @since 1.0.0
 */

public class GetAsset {
    public void getAsset(String accessKey, String secretKey, String orgId, String url) {
        GetAssetRequest request = new GetAssetRequest();
        request.setOrgId(orgId);
        request.setAssetId("assetId");
        GetAssetResponse response = Poseidon.config(PConfig.init().appKey(accessKey)
                        .appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
    }
}
