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
import com.envisioniot.enos.logic_asset_service.v2_1.DeleteLogicAssetRequest;
import com.envisioniot.enos.logic_asset_service.v2_1.DeleteLogicAssetResponse;

/**
 * 〈〉
 *
 * @author xibin.song
 * @create 12/6/2021
 * @since 1.0.0
 */

public class DeleteLogicAsset {
    public void deleteAsset(String accessKey, String secretKey, String orgId, String url) {
        DeleteLogicAssetRequest request = new DeleteLogicAssetRequest();
        request.setOrgId(orgId);
        request.setAssetId("assetId"); //The logic asset ID to be deleted. Using a device asset ID will fail.
        DeleteLogicAssetResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(request, DeleteLogicAssetResponse.class);
    }
}
