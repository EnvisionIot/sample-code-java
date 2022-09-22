package com.envisioniot.example.sample.asset.treenode;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.asset_tree_service.v2_1.AssociateAssetNodeBatchRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.AssociateAssetNodeBatchResponse;
import com.envisioniot.enos.asset_tree_service.vo.AssetIdentifierVo;
import com.google.common.collect.Lists;

/**
 * @Author: song.xu
 * @Date: 2022/9/21
 */
public class AssociateAssetNodeBatch {
    public void associateAssetNodeBatch(String accessKey, String secretKey, String orgId, String url) {
        AssociateAssetNodeBatchRequest request = new AssociateAssetNodeBatchRequest();
        request.setOrgId(orgId);
        request.setTreeId("U22GDyrC"); // input treeId
        request.setParentAssetId("ChahG3d9"); // input parent assetId
        request.setAssetIdentifiers(Lists.newArrayList(new AssetIdentifierVo("hfuU7D1H")));
        AssociateAssetNodeBatchResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, AssociateAssetNodeBatchResponse.class);
        System.out.println(response);
    }
}
