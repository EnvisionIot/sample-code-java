/**
 * Copyright (C), 2015-2021, Envision
 * FileName: getThings
 * Author:   xibin.song
 * Date:     12/6/2021 10:04 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.asset;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.asset_tree_service.vo.AssetCreateVo;
import com.envisioniot.enos.asset_tree_service.vo.I18nVo;
import com.envisioniot.enos.logic_asset_service.v2_1.CreateLogicAssetRequest;
import com.envisioniot.enos.logic_asset_service.v2_1.CreateLogicAssetResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * https://support.envisioniot.com/docs/model-api/en/2.2.0/getmodel   <br>
 * refer to the resources/GetThings/model_EPB_Battery_Socket.json file
 * 〈〉
 *
 * @author xibin.song
 * @create 12/6/2021
 * @since 1.0.0
 */

public class CreateLogicalAsset {
    public void createLogicalAsset(String accessKey, String secretKey, String orgId, String url) {
        CreateLogicAssetRequest request = new CreateLogicAssetRequest();
        request.setOrgId(orgId);
        String modelId = "demo_lift_model";//enter the model ID
        Map< String, String > i18nValue = new HashMap();
        i18nValue.put("zh_CN", "中文");
        i18nValue.put("en_US", "english");
        i18nValue.put("ja_JP", "日本語");
        i18nValue.put("es_ES", "española");
        I18nVo name = new I18nVo();
        name.setI18nValue(i18nValue);
        name.setDefaultValue("instanceName");
        AssetCreateVo asset = new AssetCreateVo();
        asset.setModelId(modelId);
        asset.setName(name);
        asset.setTimezone("+08:00");

        // Optional
        asset.setDescription("description");


        // Depends on the model attribute definition
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("building", "Singapore");
        asset.setAttributes(attributes);

        // Optional
        Map<String, String> tags = new HashMap<>();
        tags.put("yourTagKey", "yourTagValue");

        asset.setTags(tags);
        request.setAsset(asset);
        CreateLogicAssetResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(request, CreateLogicAssetResponse.class);
    }
}
