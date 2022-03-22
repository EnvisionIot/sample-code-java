/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertSeverity
 * Author:   xibin.song
 * Date:     1/3/2022 10:42 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.alert.severity;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.CreateAlertSeverityRequest;
import com.envisioniot.enos.event_service.v2_1.CreateAlertSeverityResponse;
import com.envisioniot.enos.event_service.vo.GenerateSeverity;
import com.envisioniot.enos.event_service.vo.StringI18n;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/3/2022
 * @since 1.0.0
 */

public class CreateAlertSeverity {
    public void createAlertSeverity(String accessKey, String secretKey, String orgId, String url) {

        CreateAlertSeverityRequest request = new CreateAlertSeverityRequest();
        GenerateSeverity generateSeverity = new GenerateSeverity();
        StringI18n desc = new StringI18n();
        desc.setDefaultValue("default");
        Map<String, String> map = new HashMap<>();
        map.put("zh_CN", "中文");
        map.put("en_US", "english");
        map.put("ja_JP", "日本語");
        map.put("es_ES", "española");
        desc.setI18nValue(map);
        generateSeverity.setSeverityDesc(desc);
        generateSeverity.setSeverityId("yourSeverityId");
        Map<String, String> tags = new HashMap<>();
        tags.put("yourTagKey", "yourTagValue");
        generateSeverity.setTags(tags);
        request.setSeverity(generateSeverity);
        request.setOrgId(orgId);
        try {
            CreateAlertSeverityResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, CreateAlertSeverityResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
