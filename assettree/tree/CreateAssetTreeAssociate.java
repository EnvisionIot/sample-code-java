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
import com.envisioniot.enos.asset_tree_service.v2_1.AssociateTreeRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.AssociateTreeResponse;
import com.envisioniot.enos.asset_tree_service.vo.I18nVo;
import com.envisioniot.enos.asset_tree_service.vo.TreeCreateVo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 12/28/2021
 * @since 1.0.0
 */

public class CreateAssetTreeAssociate {
    // for all Assets
    public void createAssetTreewithAssetId(String accessKey, String secretKey, String orgId, String url) {

        AssociateTreeRequest request = new AssociateTreeRequest();
        TreeCreateVo tree = new TreeCreateVo();
        I18nVo treeName = new I18nVo();
        treeName.setDefaultValue("NewTree");
        tree.setName(treeName);
        request.setTree(tree);
        request.setAssetId("4TRNZKao");
        request.setOrgId(orgId);

        AssociateTreeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, AssociateTreeResponse.class);
    }

    // for Device Assets
    public void createAssetTreewithProductandDeviceKey(String accessKey, String secretKey, String orgId, String url) {

        AssociateTreeRequest request = new AssociateTreeRequest();
        TreeCreateVo tree = new TreeCreateVo();
        I18nVo treeName = new I18nVo();
        treeName.setDefaultValue("NewTree");
        tree.setName(treeName);
        request.setTree(tree);
        request.setProductKey("Ihqkw5mx");
        request.setDeviceKey("oUQVWhAkou");
        request.setOrgId(orgId);

        AssociateTreeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, AssociateTreeResponse.class);
    }
}
