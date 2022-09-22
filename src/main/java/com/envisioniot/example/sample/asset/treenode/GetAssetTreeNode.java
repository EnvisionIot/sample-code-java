/**
 * Copyright (C), 2015-2021, Envision
 * FileName: CreateAssetTree
 * Author:   xibin.song
 * Date:     12/28/2021 9:00 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.asset.treenode;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Projection;
import com.envisioniot.enos.asset_tree_service.v2_1.SearchAssetTreeByAssetIdsRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.SearchAssetTreeByAssetIdsResponse;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 12/28/2021
 * @since 1.0.0
 */

public class GetAssetTreeNode {
    // for logic Assets
    public void searchAssetTreeByAssetIds(String accessKey, String secretKey, String orgId, String url) {
        SearchAssetTreeByAssetIdsRequest request = new SearchAssetTreeByAssetIdsRequest();
        request.setOrgId(orgId);
        request.setAssetIds(Arrays.asList("L48RzYEF", "QogFxiEg"));
        // Optional
        Projection projection = new Projection();
        //projection.addAll(Arrays.asList("attributes", "assetId", "name"));
        projection.addAll(Arrays.asList("tags", "name"));
        request.setProjection(projection);

        SearchAssetTreeByAssetIdsResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug()).url(url)
                        .getResponse(request, SearchAssetTreeByAssetIdsResponse.class);
    }
}
