/**
 * Copyright (C), 2015-2021, Envision
 * FileName: CreateAssetTree
 * Author:   xibin.song
 * Date:     12/28/2021 9:00 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.asset.treenode;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.asset_tree_service.v2_1.CreateAssetNodeRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.CreateAssetNodeResponse;
import com.envisioniot.enos.asset_tree_service.vo.AssetCreateVo;
import com.envisioniot.enos.asset_tree_service.vo.I18nVo;

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

public class CreateAssetAssociate {
    // for logic Assets
    public void createAssetAssociate(String accessKey, String secretKey, String orgId, String url) {

        CreateAssetNodeRequest request = new CreateAssetNodeRequest();
        request.setOrgId(orgId);
        request.setTreeId("U22GDyrC");
        request.setParentAssetId("ChahG3d9");

        Map< String, String > i18nValue = new HashMap();
        i18nValue.put("zh_CN", "assetName");
        I18nVo name = new I18nVo();
        name.setDefaultValue("assetDefaultName");
        name.setI18nValue(i18nValue);
        AssetCreateVo asset = new AssetCreateVo();
        asset.setModelId("EnOS_CITY_BUILDING");
        asset.setName(name);
        // asset.setTimezone("Asia/Shanghai");  It works the same way.
        asset.setTimezone("+08:00");

        //Optional
        asset.setDescription("This is a sampled asset");

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("Building_elec_tariff_discount", 12.23);
        attributes.put("maxZoom", 1);
        attributes.put("minZoom", 1);
        attributes.put("zoom", 3);
        attributes.put("Building_has_ct", Boolean.TRUE);
        attributes.put("Building_has_vav", Boolean.TRUE);
        attributes.put("Building_has_ahu", Boolean.TRUE);
        attributes.put("Building_has_chwp", Boolean.TRUE);
        attributes.put("Building_has_chiller", Boolean.TRUE);
        attributes.put("Building_has_cwp", Boolean.TRUE);
        attributes.put("hasChiller", Boolean.TRUE);
        attributes.put("hasStorage", Boolean.TRUE);
        attributes.put("hasSolar", Boolean.TRUE);
        attributes.put("Building_elec_tariff", 10.1);
        attributes.put("buildingDefaultMapRotation", 10);

        attributes.put("Building_renew_energy_ratio", 10);
        // Enum Value
        attributes.put("isGreenMark", 0);
        attributes.put("type", 1);
        attributes.put("Building_grid_frequency", 1);
        attributes.put("Building_elec_tariff_currency", 1);
        attributes.put("HVAC_optimization_service", 0);

        attributes.put("dateJoin", "2021-02-23");
        JSONObject rating = new JSONObject();
        rating.put("bad",3);
        rating.put("medium",3);
        rating.put("good",3);
        attributes.put("EUI_rating",rating);
        attributes.put("floorTotal", 20);


        asset.setAttributes(attributes);

        Map<String, String> tags = new HashMap<>();
        tags.put("key1","value1");
        asset.setTags(tags);

        request.setAsset(asset);
        CreateAssetNodeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(request, CreateAssetNodeResponse.class);
    }
}
