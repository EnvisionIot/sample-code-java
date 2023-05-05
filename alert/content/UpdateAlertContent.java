/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.alert.content;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.UpdateAlertContentRequest;
import com.envisioniot.enos.event_service.v2_1.UpdateAlertContentResponse;
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

public class UpdateAlertContent {

    public void updateAlertContent(String accessKey, String secretKey, String orgId, String url) {
        UpdateAlertContentRequest request = new UpdateAlertContentRequest();
        request.setOrgId(orgId);
        GenerateContent generateContent = new GenerateContent();
        generateContent.setContentId("yourContentId");
        StringI18n desc = new StringI18n();
        desc.setDefaultValue("default");
        Map < String, String > map = new HashMap < > ();
        map.put("zh_CN", "中文1");
        map.put("en_US", "english1");
        map.put("ja_JP", "アラートコンテンツ1");
        map.put("es_ES", "Contenido de alerta1");
        desc.setI18nValue(map);
        generateContent.setContentDesc(desc);
        //Optional
        Map < String, String > tags = new HashMap < > ();
        tags.put("yourTagKey", "yourTagValue1");
        generateContent.setTags(tags);
        request.setAlertContent(generateContent);
        request.setIsPatchUpdate(true);
        try {
            UpdateAlertContentResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, UpdateAlertContentResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateAlertContentWithExtraConfiguration(String accessKey, String secretKey, String orgId, String url) {
        UpdateAlertContentRequest request = new UpdateAlertContentRequest();
        request.setOrgId(orgId);
        GenerateContent generateContent = new GenerateContent();
        generateContent.setContentId("yourContentId");
        StringI18n desc = new StringI18n();
        desc.setDefaultValue("default");
        Map < String, String > map = new HashMap < > ();
        map.put("zh_CN", "中文1");
        map.put("en_US", "english1");
        map.put("ja_JP", "アラートコンテンツ1");
        map.put("es_ES", "Contenido de alerta1");
        desc.setI18nValue(map);
        generateContent.setContentDesc(desc);
        //Optional
        Map < String, String > tags = new HashMap < > ();
        tags.put("yourTagKey", "yourTagValue1");
        generateContent.setTags(tags);

        // Issue found
        /*
        generateContent.setAlertTypeId();
        generateContent.setModelId();
        generateContent.setSubAlertTypeId();
        */
        request.setAlertContent(generateContent);
        request.setIsPatchUpdate(true);
        try {
            UpdateAlertContentResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, UpdateAlertContentResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
