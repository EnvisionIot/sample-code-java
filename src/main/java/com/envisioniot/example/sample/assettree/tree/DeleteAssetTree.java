/**
 * Copyright (C), 2015-2021, Envision
 * FileName: CreateAssetTree
 * Author:   xibin.song
 * Date:     12/28/2021 9:00 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.assettree.tree;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.asset_tree_service.v2_1.DeleteTreeRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.DeleteTreeResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 12/28/2021
 * @since 1.0.0
 */

public class DeleteAssetTree {
    public void deleteAssetTree(String accessKey, String secretKey, String orgId, String url) {
        DeleteTreeRequest request = new DeleteTreeRequest();
        request.setOrgId(orgId);
        request.setTreeId("TreeId");
        DeleteTreeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, DeleteTreeResponse.class);
    }
}
