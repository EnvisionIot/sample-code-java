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

public class CreateAlertType {
    public void createAlertType(String accessKey, String secretKey, String orgId, String url) {
        CreateAlertTypeRequest request = new CreateAlertTypeRequest();
        request.setOrgId(orgId);
        GenerateType type = new GenerateType();
        type.setTypeId("yourAlertTypeId1");
        StringI18n desc = new StringI18n();
        desc.setDefaultValue("default");
        Map< String, String > map = new HashMap< >();
        map.put("zh_CN", "警报类型");
        map.put("en_US", "english");
        map.put("ja_JP", "アラートタイプ");
        map.put("es_ES", "Tipo de alerta");
        desc.setI18nValue(map);
        type.setTypeDesc(desc);
        Map < String, String > tags = new HashMap < > ();
        tags.put("yourTagKey", "yourTagValue");
        type.setTags(tags);
        request.setType(type);
        try {
            CreateAlertTypeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, CreateAlertTypeResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAlertTypeWithParent(String accessKey, String secretKey, String orgId, String url) {
        CreateAlertTypeRequest request = new CreateAlertTypeRequest();
        request.setOrgId(orgId);
        GenerateType type = new GenerateType();
        type.setTypeId("yourAlertTypeId2");
        //Optional
        type.setParentTypeId("yourAlertTypeId1");

        StringI18n desc = new StringI18n();
        desc.setDefaultValue("default");
        Map< String, String > map = new HashMap< >();
        map.put("zh_CN", "警报类型2");
        map.put("en_US", "AlertType2");
        map.put("ja_JP", "アラートタイプ2");
        map.put("es_ES", "Tipo de alerta2");
        desc.setI18nValue(map);
        type.setTypeDesc(desc);
        Map < String, String > tags = new HashMap < > ();
        tags.put("yourTagKey", "yourTagValue");
        type.setTags(tags);
        request.setType(type);
        try {
            CreateAlertTypeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, CreateAlertTypeResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
