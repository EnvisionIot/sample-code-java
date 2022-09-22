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
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.api.common.constant.request.Projection;
import com.envisioniot.enos.asset_tree_service.v2_1.SearchAssetTreeRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.SearchAssetTreeResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 12/28/2021
 * @since 1.0.0
 */

public class SearchAssetTree {

    public void searchAssetTree(String accessKey, String secretKey, String orgId, String url) {
        /*String expression_tag =  "tags.EnosCDS ='true'";
        searchAssetTreewithExpression(accessKey, secretKey, orgId, url, expression_tag);

        // can not use Not exists
        String expression_tag_exists =  "exists(tags.EnosCDS)";
        searchAssetTreewithExpression(accessKey, secretKey, orgId, url, expression_tag_exists);*/

        String expression_treeId =  "treeId = 'y4wNuWEp' ";
        searchAssetTreewithExpression(accessKey, secretKey, orgId, url, expression_treeId);

        String expression_name_default =  "name.default = 'Lightsource_bp'";
        searchAssetTreewithExpression(accessKey, secretKey, orgId, url, expression_name_default);

        String expression_name_like =  "name.default like 'Lightsource_bp'";
        searchAssetTreewithExpression(accessKey, secretKey, orgId, url, expression_name_like);

        // not ready, waiting for product team to fix and response
        String expression_name_like2 =  "name.default like 'light'";
        searchAssetTreewithExpression(accessKey, secretKey, orgId, url, expression_name_like2);


    }

    public void searchAssetTreewithExpression(String accessKey, String secretKey, String orgId, String url, String expression) {
        SearchAssetTreeRequest request = new SearchAssetTreeRequest();
        request.setExpression(expression);
        Pagination pagination = new Pagination(5, 1, null);
        Projection projection = new Projection();
        projection.add("asset");
        request.setPagination(pagination);
        request.setProjection(projection);
        request.setOrgId(orgId);
        SearchAssetTreeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchAssetTreeResponse.class);
    }
    /*public void searchAssetTreewithFilter(String accessKey, String secretKey, String orgId, String url, String filter) {
        SearchAssetTreeRequest request = new SearchAssetTreeRequest();
        request.setFilter();
        Pagination pagination = new Pagination(3, 1, null);
        Projection projection = new Projection();
        projection.add("asset");
        request.setPagination(pagination);
        request.setProjection(projection);
        request.setOrgId(orgId);
        SearchAssetTreeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchAssetTreeResponse.class);
    }*/
}
