/**
 * Copyright (C), 2015-2021, Envision
 * FileName: CreateAssetTree
 * Author:   xibin.song
 * Date:     12/28/2021 9:00 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.asset.treenode;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Projection;
import com.envisioniot.enos.asset_tree_service.v2_1.DeleteAssetNodeRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.DeleteAssetNodeResponse;
import com.envisioniot.enos.asset_tree_service.v2_1.SearchAssetNodeRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.SearchAssetNodeResponse;

import java.util.Arrays;

/**
 *
 * refer to AssetTree/AssetTreeExample.png for the tree structure.
 * 〈〉
 *
 * @author xibin.song
 * @create 12/28/2021
 * @since 1.0.0
 */

public class SearchAssetNode {
    // for logic Assets
    public void searchAssetNodeAll(String accessKey, String secretKey, String orgId, String url) {

        String expression_assetId = "assetId = 'L48RzYEF'";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_assetId);

        String expression_assetIdor = "assetId = 'L48RzYEF' or  assetId = 'hfuU7D1H'";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_assetIdor);

        String expression_assetIdsin = "assetIds in ('L48RzYEF', 'hfuU7D1H')";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_assetIdsin);

        String expression_rootModelId = "rootModelId =  'EnOS_CITY_BUILDING'";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_rootModelId);

        String expression_rootModelIds = "rootModelIds in  ('EnOS_CITY_BUILDING', 'NULLMODEL')";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_rootModelIds);

        String expression_ModelId = "modelId = 'EnOS_CITY_BUILDING'";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_ModelId);

        String expression_ModelIds = "modelIds in  ('EnOS_CITY_BUILDING', 'EnOS_Edge_Standard_Model')";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_ModelIds);
        String expression_treeId = "treeId = 'U22GDyrC'";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_treeId);

        String expression_treeIdand = "treeId = 'U22GDyrC' and modelId = 'EnOS_CITY_BUILDING'";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_treeIdand);

        String expression_deviceProduct = "deviceKey = 'oUQVWhAkou' and productKey = 'Ihqkw5mx'";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_deviceProduct);

        String expression_deviceProduct_like = "deviceKey like 'oUQVWh' and productKey like 'Ihq'";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_deviceProduct_like);

        String expression_tags = "tags.key1  = 'value1'";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_tags);
        String expression_tags_exists = "exists(tags.key1)";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_tags_exists);
        String expression_tags2 = "tags.key1  in  ('value1', 'value')";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_tags2);

        String expression_createTime1 = "createTime = 1640684761334";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_createTime1);
        String expression_createTime2 = "createTime <= 1639645258000";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_createTime2);
        String expression_createTime3 = "createTime >= 1639645258000";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_createTime3);


        String expression_namedefaultlike = "name.default like 'asset'";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_namedefaultlike);
        String expression_namelike = "name like 'asset'";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_namelike);
        String expression_namelikeen_US = "name.en_US  like 'asset'";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_namelikeen_US);
        String expression_namelikezh_CN = "name.zh_CN like 'asset'";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_namelikezh_CN);

        String expression_attributes1 = "attributes.floorTotal = 20";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_attributes1);

        String expression_attributes2 = "attributes.client_version = 'edge-client-go'";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_attributes2);
        //Enum
        String expression_attributes3 = "attributes.edge_type = 0";
        searchAssetNode(accessKey, secretKey, orgId, url, expression_attributes3);


    }

    public void searchAssetNode(String accessKey, String secretKey, String orgId, String url, String expression) {
        SearchAssetNodeRequest request = new SearchAssetNodeRequest();
        request.setOrgId(orgId);
        request.setExpression(expression);
        Projection projection = new Projection();
        //projection.addAll(Arrays.asList("attributes", "assetId", "name"));
        projection.addAll(Arrays.asList("name","createTime"));
        request.setProjection(projection);
        SearchAssetNodeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(request, SearchAssetNodeResponse.class);
    }
}
