/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.alert.content;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.CreateAlertContentRequest;
import com.envisioniot.enos.event_service.v2_1.CreateAlertContentResponse;
import com.envisioniot.enos.event_service.vo.GenerateContent;
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

public class CreateAlertContent {
    public void createAlertContent(String accessKey, String secretKey, String orgId, String url) {
        CreateAlertContentRequest request = new CreateAlertContentRequest();
        request.setOrgId(orgId);
        GenerateContent alertContent = new GenerateContent();
        alertContent.setContentId("yourContentId");
        alertContent.setAlertTypeId("yourAlertTypeId");

        StringI18n desc = new StringI18n();
        desc.setDefaultValue("default");
        Map < String, String > map = new HashMap < > ();
        map.put("zh_CN", "警报内容");
        map.put("en_US", "english");
        map.put("ja_JP", "アラートコンテンツ");
        map.put("es_ES", "Contenido de alerta");
        desc.setI18nValue(map);
        alertContent.setContentDesc(desc);
        Map < String, String > tags = new HashMap < > ();
        tags.put("yourTagKey", "yourTagValue");
        alertContent.setTags(tags);
        alertContent.setModelId("demo_lift_model");
        request.setAlertContent(alertContent);
        try {
            CreateAlertContentResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, CreateAlertContentResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
