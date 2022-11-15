package com.envisioniot.example.sample.assettree.treenode;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.asset_tree_service.v2_1.MoveAssetNodeRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.MoveAssetNodeResponse;

/**
 * @Author: song.xu
 * @Date: 2022/9/21
 */
public class MoveAssetNode {
    public void moveAssetNode(String accessKey, String secretKey, String orgId, String url) {
        MoveAssetNodeRequest request = new MoveAssetNodeRequest();
        request.setOrgId(orgId);
        request.setTreeId("U22GDyrC"); // input treeId
        request.setParentAssetId("ChahG3d9"); // input parent asset id
        request.setPreAssetId("sdfasdd"); // input pre asset id
        request.setAssetId("hfuU7D1H"); // input asset id
        MoveAssetNodeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, MoveAssetNodeResponse.class);
        System.out.println(response);
    }
}
