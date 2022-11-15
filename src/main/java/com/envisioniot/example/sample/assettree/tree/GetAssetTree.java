/**
 * Copyright (C), 2015-2021, Envision
 * FileName: CreateAssetTree
 * Author:   xibin.song
 * Date:     12/28/2021 9:00 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.asset.tree;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.asset_tree_service.v2_1.GetAssetTreeRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.GetAssetTreeResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 12/28/2021
 * @since 1.0.0
 */

public class GetAssetTree {
    public void getAssetTree(String accessKey, String secretKey, String orgId, String url) {
        GetAssetTreeRequest request = new GetAssetTreeRequest();
        request.setOrgId(orgId);
        request.setTreeId("y4wNuWEp");
        GetAssetTreeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, GetAssetTreeResponse.class);
    }
}
