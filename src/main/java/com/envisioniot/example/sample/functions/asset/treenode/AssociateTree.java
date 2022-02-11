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

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.asset_tree_service.v2_1.AssociateAssetNodeRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.AssociateAssetNodeResponse;
import com.envisioniot.enos.asset_tree_service.v2_1.CreateTreeRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.CreateTreeResponse;
import com.envisioniot.enos.asset_tree_service.vo.AssetCreateVo;
import com.envisioniot.enos.asset_tree_service.vo.I18nVo;
import com.envisioniot.enos.asset_tree_service.vo.TreeCreateVo;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 12/28/2021
 * @since 1.0.0
 */

public class AssociateTree {
    public void associateTree(String accessKey, String secretKey, String orgId, String url) {
        AssociateAssetNodeRequest request = new AssociateAssetNodeRequest();
        request.setOrgId(orgId);
        request.setTreeId("U22GDyrC");
        request.setParentAssetId("ChahG3d9");
        request.setAssetId("hfuU7D1H");
        CreateTreeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, CreateTreeResponse.class);
    }
    public void associateTreewithProductDevicekey(String accessKey, String secretKey, String orgId, String url) {
        AssociateAssetNodeRequest request = new AssociateAssetNodeRequest();
        request.setOrgId(orgId);
        request.setTreeId("U22GDyrC");
        request.setParentAssetId("ChahG3d9");
        request.setProductKey("tR1PKmQH");
        request.setDeviceKey("SmpDxF6WHW");
        CreateTreeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, CreateTreeResponse.class);
    }
}
