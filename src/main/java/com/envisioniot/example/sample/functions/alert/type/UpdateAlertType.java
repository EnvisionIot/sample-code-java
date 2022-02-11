/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.alert.type;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.CreateAlertTypeRequest;
import com.envisioniot.enos.event_service.v2_1.CreateAlertTypeResponse;
import com.envisioniot.enos.event_service.v2_1.UpdateAlertTypeRequest;
import com.envisioniot.enos.event_service.v2_1.UpdateAlertTypeResponse;
import com.envisioniot.enos.event_service.vo.GenerateType;
import com.envisioniot.enos.event_service.vo.StringI18n;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class UpdateAlertType {
    public void updateAlertType(String accessKey, String secretKey, String orgId, String url) {
        UpdateAlertTypeRequest request = new UpdateAlertTypeRequest();
        request.setOrgId(orgId);
        GenerateType type = new GenerateType();
        type.setTypeId("yourAlertTypeId1");
        StringI18n desc = new StringI18n();
        desc.setDefaultValue("default1");
        Map< String, String > map = new HashMap< >();
        map.put("zh_CN", "警报类型1");
        map.put("en_US", "english1");
        map.put("ja_JP", "アラートタイプ1");
        map.put("es_ES", "Tipo de alerta1");
        desc.setI18nValue(map);
        type.setTypeDesc(desc);
        Map < String, String > tags = new HashMap < > ();
        tags.put("yourTagKey1", "yourTagValue1");
        type.setTags(tags);
        request.setType(type);
        request.setIsPatchUpdate(true);
        try {
            UpdateAlertTypeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, UpdateAlertTypeResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAlertTypeWithParent(String accessKey, String secretKey, String orgId, String url) {
        UpdateAlertTypeRequest request = new UpdateAlertTypeRequest();
        request.setOrgId(orgId);
        GenerateType type = new GenerateType();
        type.setTypeId("yourAlertTypeId2");
        //Optional   //If the alert has a parent alert type, the parent alert type cannot be changed.
        type.setParentTypeId("yourAlertTypeId1");

        StringI18n desc = new StringI18n();
        desc.setDefaultValue("default3");
        Map< String, String > map = new HashMap< >();
        map.put("zh_CN", "警报类型3");
        map.put("en_US", "AlertType3");
        map.put("ja_JP", "アラートタイプ3");
        map.put("es_ES", "Tipo de alerta3");
        desc.setI18nValue(map);
        type.setTypeDesc(desc);
        Map < String, String > tags = new HashMap < > ();
        tags.put("yourTagKey3", "yourTagValue3");
        type.setTags(tags);
        request.setType(type);
        request.setIsPatchUpdate(true);
        try {
            UpdateAlertTypeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, UpdateAlertTypeResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
