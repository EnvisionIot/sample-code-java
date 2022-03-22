/**
 * Copyright (C), 2015-2021, Envision
 * FileName: getThings
 * Author:   xibin.song
 * Date:     12/6/2021 10:04 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.asset;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.asset_service.v2_1.UpdateAssetRequest;
import com.envisioniot.enos.asset_service.v2_1.UpdateAssetResponse;
import com.envisioniot.enos.asset_service.vo.AssetUpdateVo;
import com.envisioniot.enos.asset_tree_service.vo.I18nVo;

import java.util.HashMap;
import java.util.Map;

/**
 * AssetId can be found from the DevPortal in Device Assets.
 * 〈〉
 *
 * @author xibin.song
 * @create 12/6/2021
 * @since 1.0.0
 */

public class UpdateAsset {
    public void updateAsset(String accessKey, String secretKey, String orgId, String url) {
        UpdateAssetRequest request = new UpdateAssetRequest();
        request.setOrgId(orgId);
        AssetUpdateVo asset = new AssetUpdateVo();
        asset.setAssetId("QogFxiEg");

        Map<String, Object> newAttrs = new HashMap<>();
        newAttrs.put("altitude",123.45);
        asset.setAttributes(newAttrs);
        //Optional
        I18nVo name = new I18nVo();
        name.setDefaultValue("updated Device 1");
        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("zh_CN","电池_设备_CN");
        nameMap.put("en_US","Battery_Device_US");
        nameMap.put("ja_JP", "バッテリー機器");
        nameMap.put("es_ES", "Equipo de batería");
        name.setI18nValue(nameMap);
        asset.setName(name);
        asset.setDescription("new descriptions");
        asset.setTimezone("Asia/Shanghai");
        Map<String, String> tag = new HashMap<>();
        tag.put("key", "data1");
        asset.setTags(tag);

        request.setAsset(asset);
        request.setIsPatchUpdate(true);
        UpdateAssetResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
    }

    public void updateAsset_Timezone(String accessKey, String secretKey, String orgId, String url) {
        UpdateAssetRequest request = new UpdateAssetRequest();
        request.setOrgId(orgId);
        AssetUpdateVo asset = new AssetUpdateVo();
        asset.setAssetId("QogFxiEg");

        Map<String, Object> newAttrs = new HashMap<>();
        newAttrs.put("altitude",123.45);
        asset.setAttributes(newAttrs);
        //Optional
        I18nVo name = new I18nVo();
        name.setDefaultValue("updated Device 1");
        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("zh_CN","电池_设备_CN");
        nameMap.put("en_US","Battery_Device_US");
        nameMap.put("ja_JP", "バッテリー機器");
        nameMap.put("es_ES", "Equipo de batería");
        name.setI18nValue(nameMap);
        asset.setName(name);
        asset.setDescription("new descriptions");
        asset.setTimezone("+06:00");
        Map<String, String> tag = new HashMap<>();
        tag.put("key", "data1");
        asset.setTags(tag);

        request.setAsset(asset);
        request.setIsPatchUpdate(true);
        UpdateAssetResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
    }
}
