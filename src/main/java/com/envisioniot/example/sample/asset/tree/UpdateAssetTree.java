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
import com.envisioniot.enos.asset_tree_service.v2_1.UpdateTreeRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.UpdateTreeResponse;
import com.envisioniot.enos.asset_tree_service.vo.I18nVo;
import com.envisioniot.enos.asset_tree_service.vo.TreeUpdateVo;

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

public class UpdateAssetTree {
    public void updateAssetTree(String accessKey, String secretKey, String orgId, String url) {
        TreeUpdateVo treeUpdateVo = new TreeUpdateVo();
        I18nVo treeName = new I18nVo();
        treeName.setDefaultValue("NewTree1");
        treeUpdateVo.setName(treeName);
        treeUpdateVo.setTreeId("U22GDyrC");
        UpdateTreeRequest request = new UpdateTreeRequest ();
        Map< String, String > i18nValue = new HashMap();
        i18nValue.put("zh_CN", "assetName1");
        i18nValue.put("en_US", "english1");
        i18nValue.put("ja_JP", "日本語1");
        i18nValue.put("es_ES", "española1");
        I18nVo name = new I18nVo();
        name.setDefaultValue("assetDefaultName1");
        name.setI18nValue(i18nValue);

        Map<String, String> tags = new HashMap<>();
        tags.put("key2","value2");
        treeUpdateVo.setTags(tags);
        request.setTreeUpdateInfo(treeUpdateVo);
        request.setOrgId(orgId);
        UpdateTreeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, UpdateTreeResponse.class);
    }
}
