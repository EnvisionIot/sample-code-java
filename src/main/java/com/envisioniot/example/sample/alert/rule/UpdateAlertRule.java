/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.alert.rule;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.UpdateAlertRuleRequest;
import com.envisioniot.enos.event_service.v2_1.UpdateAlertRuleResponse;
import com.envisioniot.enos.event_service.vo.AssetNode;
import com.envisioniot.enos.event_service.vo.StringI18n;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class UpdateAlertRule {
    public void updateAlertRule(String accessKey, String secretKey, String orgId, String url) {
        UpdateAlertRuleRequest request = new UpdateAlertRuleRequest();
        request.setOrgId(orgId);
        request.setRuleId("rule1");

        StringI18n desc = new StringI18n();
        desc.setDefaultValue("description data");
        Map < String, String > mapString = new HashMap <> ();
        mapString.put("zh_CN", "警报规则_1");
        mapString.put("en_US", "Alert Rule_1");
        mapString.put("ja_JP", "アラートルール_1");
        mapString.put("es_ES", "Regla de alerta_1");
        desc.setI18nValue(mapString);
        request.setRuleDesc(desc);

        request.setSeverityId("yourSeverityId");
        request.setContentId("yourContentId");
        request.setModelId("demo_lift_model");
        request.setMeasurepointId("humidity");
        request.setCondition("(${humidity} < 30 ) and  (${humidity} > 26) ");
        AssetNode assetNode = new AssetNode();
        assetNode.setAssetId("all");
        assetNode.setTreeId("all");
        List< AssetNode > list = new LinkedList< >();
        list.add(assetNode);
        request.setScope(list);


        Map < String, String > map = new HashMap < > ();
        map.put("yourTagKey_1", "yourTagValue_!");
        request.setTags(map);
        request.setIsPatchUpdate(true);
        request.setIsEnabled(true);
        request.setIsRoot(false);
        request.setTriggeringDelayTimer(86400);

        try {
            UpdateAlertRuleResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, UpdateAlertRuleResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void updateAlertRule2(String accessKey, String secretKey, String orgId, String url) {
        UpdateAlertRuleRequest request = new UpdateAlertRuleRequest();
        request.setOrgId(orgId);
        request.setRuleId("rule1");

        StringI18n desc = new StringI18n();
        desc.setDefaultValue("description data");
        Map < String, String > mapString = new HashMap <> ();
        mapString.put("zh_CN", "警报规则_1");
        mapString.put("en_US", "Alert Rule_1");
        mapString.put("ja_JP", "アラートルール_1");
        mapString.put("es_ES", "Regla de alerta_1");
        desc.setI18nValue(mapString);
        request.setRuleDesc(desc);

        request.setSeverityId("yourSeverityId");
        request.setContentId("yourContentId");
        request.setModelId("demo_lift_model");
        request.setDeviceStatus("offline");
        AssetNode assetNode = new AssetNode();
        assetNode.setAssetId("all");
        assetNode.setTreeId("all");
        List< AssetNode > list = new LinkedList< >();
        list.add(assetNode);
        request.setScope(list);


        Map < String, String > map = new HashMap < > ();
        map.put("yourTagKey_1", "yourTagValue_!");
        request.setTags(map);
        request.setIsPatchUpdate(true);
        request.setIsEnabled(true);
        request.setIsRoot(false);
        request.setTriggeringDelayTimer(86400);

        try {
            UpdateAlertRuleResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, UpdateAlertRuleResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
