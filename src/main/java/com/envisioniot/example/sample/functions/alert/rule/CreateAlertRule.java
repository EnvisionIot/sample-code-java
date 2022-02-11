/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.alert.rule;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.CreateAlertContentRequest;
import com.envisioniot.enos.event_service.v2_1.CreateAlertContentResponse;
import com.envisioniot.enos.event_service.v2_1.CreateAlertRuleRequest;
import com.envisioniot.enos.event_service.v2_1.CreateAlertRuleResponse;
import com.envisioniot.enos.event_service.vo.AssetNode;
import com.envisioniot.enos.event_service.vo.GenerateContent;
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

public class CreateAlertRule {
    public void createAlertRule(String accessKey, String secretKey, String orgId, String url) {
        CreateAlertRuleRequest request = new CreateAlertRuleRequest();
        request.setOrgId(orgId);
        request.setRuleId("yourRuleId");
        request.setSeverityId("yourSeverityId");
        request.setContentId("yourContentId");
        StringI18n desc = new StringI18n();
        desc.setDefaultValue("description data");
        Map < String, String > mapString = new HashMap <> ();
        mapString.put("zh_CN", "警报规则");
        mapString.put("en_US", "Alert Rule");
        mapString.put("ja_JP", "アラートルール");
        mapString.put("es_ES", "Regla de alerta");
        desc.setI18nValue(mapString);
        request.setRuleDesc(desc);
        request.setModelId("demo_lift_model");
        request.setMeasurepointId("temp, humidity");
        request.setCondition("(${temp} < 30 ) and  (${temp} > 26) ");
        AssetNode assetNode = new AssetNode();
        assetNode.setAssetId("all");
        assetNode.setTreeId("all");
        List< AssetNode > list = new LinkedList< >();
        list.add(assetNode);
        request.setScope(list);
        //Optional
        // can not be used with setMeasurepointId
        //request.setDeviceStatus("offline");
        Map < String, String > map = new HashMap < > ();
        map.put("yourTagKey", "yourTagValue");
        request.setTags(map);
        request.setIsEnabled(true);
        request.setIsRoot(false);
        request.setTriggeringDelayTimer(86400);


        try {
            CreateAlertRuleResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, CreateAlertRuleResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }


    public void createAlertRuleWithMeasurePointCondition(String accessKey, String secretKey, String orgId, String url, String ruleId, String measurepointId, String condition) {
        CreateAlertRuleRequest request = new CreateAlertRuleRequest();
        request.setOrgId(orgId);
        request.setRuleId(ruleId);
        request.setSeverityId("yourSeverityId");
        request.setContentId("yourContentId");
        StringI18n desc = new StringI18n();
        desc.setDefaultValue("description data");
        Map < String, String > mapString = new HashMap <> ();
        mapString.put("zh_CN", "警报规则");
        mapString.put("en_US", "Alert Rule");
        mapString.put("ja_JP", "アラートルール");
        mapString.put("es_ES", "Regla de alerta");
        desc.setI18nValue(mapString);
        request.setRuleDesc(desc);
        request.setModelId("demo_lift_model");
        request.setMeasurepointId(measurepointId);
        request.setCondition(condition);
        AssetNode assetNode = new AssetNode();
        assetNode.setAssetId("all");
        assetNode.setTreeId("all");
        List< AssetNode > list = new LinkedList< >();
        list.add(assetNode);
        request.setScope(list);
        //Optional
        // can not be used with setMeasurepointId
        //request.setDeviceStatus("offline");
        Map < String, String > map = new HashMap < > ();
        map.put("yourTagKey", "yourTagValue");
        request.setTags(map);
        request.setIsEnabled(true);
        request.setIsRoot(false);
        request.setTriggeringDelayTimer(86400);


        try {
            CreateAlertRuleResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, CreateAlertRuleResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void createAlertRuleWithDeviceCondition(String accessKey, String secretKey, String orgId, String url, String ruleId) {
        CreateAlertRuleRequest request = new CreateAlertRuleRequest();
        request.setOrgId(orgId);
        request.setRuleId(ruleId);
        request.setSeverityId("yourSeverityId");
        request.setContentId("yourContentId");
        StringI18n desc = new StringI18n();
        desc.setDefaultValue("description data");
        Map < String, String > mapString = new HashMap <> ();
        mapString.put("zh_CN", "警报规则");
        mapString.put("en_US", "Alert Rule");
        mapString.put("ja_JP", "アラートルール");
        mapString.put("es_ES", "Regla de alerta");
        desc.setI18nValue(mapString);
        request.setRuleDesc(desc);
        request.setModelId("demo_lift_model");
        request.setDeviceStatus("offline");
        AssetNode assetNode = new AssetNode();
        assetNode.setAssetId("all");
        assetNode.setTreeId("all");
        List< AssetNode > list = new LinkedList< >();
        list.add(assetNode);
        request.setScope(list);
        //Optional
        // can not be used with setMeasurepointId
        Map < String, String > map = new HashMap < > ();
        map.put("yourTagKey", "yourTagValue");
        request.setTags(map);
        request.setIsEnabled(true);
        request.setIsRoot(false);
        request.setTriggeringDelayTimer(86400);

        try {
            CreateAlertRuleResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, CreateAlertRuleResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void createAlertRuleAssetTreeId(String accessKey, String secretKey, String orgId, String url, String ruleId, String assetId, String treeId) {
        CreateAlertRuleRequest request = new CreateAlertRuleRequest();
        request.setOrgId(orgId);
        request.setRuleId(ruleId);
        request.setSeverityId("yourSeverityId");
        request.setContentId("yourContentId");
        StringI18n desc = new StringI18n();
        desc.setDefaultValue("description data");
        Map < String, String > mapString = new HashMap <> ();
        mapString.put("zh_CN", "警报规则");
        mapString.put("en_US", "Alert Rule");
        mapString.put("ja_JP", "アラートルール");
        mapString.put("es_ES", "Regla de alerta");
        desc.setI18nValue(mapString);
        request.setRuleDesc(desc);
        request.setModelId("demo_lift_model");
        request.setDeviceStatus("offline");
        AssetNode assetNode = new AssetNode();
        assetNode.setAssetId(assetId);
        assetNode.setTreeId(treeId);
        List< AssetNode > list = new LinkedList< >();
        list.add(assetNode);
        request.setScope(list);
        //Optional
        // can not be used with setMeasurepointId
        Map < String, String > map = new HashMap < > ();
        map.put("yourTagKey", "yourTagValue");
        request.setTags(map);
        request.setIsEnabled(true);
        request.setIsRoot(false);
        request.setTriggeringDelayTimer(86400);

        try {
            CreateAlertRuleResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, CreateAlertRuleResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
