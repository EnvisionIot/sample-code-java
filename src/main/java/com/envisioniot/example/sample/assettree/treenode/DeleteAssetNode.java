/**
 * Copyright (C), 2015-2021, Envision
 * FileName: CreateAssetTree
 * Author:   xibin.song
 * Date:     12/28/2021 9:00 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.assettree.treenode;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.asset_tree_service.v2_1.DeleteAssetNodeRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.DeleteAssetNodeResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 12/28/2021
 * @since 1.0.0
 */

public class DeleteAssetNode {
    // for logic Assets
    public void deleteAssetNode(String accessKey, String secretKey, String orgId, String url) {
        DeleteAssetNodeRequest request = new DeleteAssetNodeRequest();
        request.setOrgId(orgId);
        request.setTreeId("treeId");
        request.setAssetId("assetId");
        DeleteAssetNodeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(request, DeleteAssetNodeResponse.class);
    }
}
