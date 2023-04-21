/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.alert.record.old.history;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.BatchCreateHistoryAlertsRequest;
import com.envisioniot.enos.event_service.v2_1.BatchCreateHistoryAlertsResponse;
import com.envisioniot.enos.event_service.vo.GenerateHistoryAlert;
import com.envisioniot.enos.event_service.vo.StringI18n;
import com.google.common.collect.Lists;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
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

public class CreateHistoryAlertBatch {
    public void createHistoryAlertBatch(String accessKey, String secretKey, String orgId, String url) {
        BatchCreateHistoryAlertsRequest request = new BatchCreateHistoryAlertsRequest();
        request.setOrgId(orgId);
        List < GenerateHistoryAlert > list = Lists.newArrayList();
        GenerateHistoryAlert historyAlert1 = buildHistoryAlert();
        historyAlert1.setOccurTime(System.currentTimeMillis() - 24L * 3600 * 1000);
        Map < String, String > tags = new HashMap < > ();
        tags.put("key1", "v1");
        historyAlert1.setTag(tags);
        list.add(historyAlert1);
        GenerateHistoryAlert historyAlert2 = buildHistoryAlert();
        tags = new HashMap < > ();
        tags.put("key2", "v2");
        historyAlert2.setTag(tags);
        list.add(historyAlert2);
        GenerateHistoryAlert historyAlert3 = buildHistoryAlert();
        tags = new HashMap < > ();
        tags.put("key3", "v3");
        historyAlert3.setTag(tags);
        list.add(historyAlert3);
        request.setHistoryAlertList(list);
        try {
            BatchCreateHistoryAlertsResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, BatchCreateHistoryAlertsResponse.class);
            System.out.println(response);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public void createHistoryAlertBatchWithDevice(String accessKey, String secretKey, String orgId, String url) {
        BatchCreateHistoryAlertsRequest request = new BatchCreateHistoryAlertsRequest();
        request.setOrgId(orgId);
        List < GenerateHistoryAlert > list = Lists.newArrayList();
        GenerateHistoryAlert historyAlert1 = buildHistoryAlertWithDevice();
        historyAlert1.setOccurTime(System.currentTimeMillis() - 24L * 3600 * 1000);
        Map < String, String > tags = new HashMap < > ();
        tags.put("key1", "v1");
        historyAlert1.setTag(tags);
        list.add(historyAlert1);
        GenerateHistoryAlert historyAlert2 = buildHistoryAlertWithDevice();
        tags = new HashMap < > ();
        tags.put("key2", "v2");
        historyAlert2.setTag(tags);
        list.add(historyAlert2);
        GenerateHistoryAlert historyAlert3 = buildHistoryAlertWithDevice();
        tags = new HashMap < > ();
        tags.put("key3", "v3");
        historyAlert3.setTag(tags);
        list.add(historyAlert3);
        request.setHistoryAlertList(list);
        try {
            BatchCreateHistoryAlertsResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, BatchCreateHistoryAlertsResponse.class);
            System.out.println(response);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    private GenerateHistoryAlert buildHistoryAlert() {
        GenerateHistoryAlert historyAlert = new GenerateHistoryAlert();
        historyAlert.setAssetId("32CDx7FU");
        historyAlert.setModelId("demo_lift_model");

        //Optional
        historyAlert.setModelIdPath("/demo_lift_model");

        List<String> assetPath = new ArrayList<>();
        assetPath.add("treeId1:/assetId1/assetId2/assetIdx");
        assetPath.add("treeId2:/assetId3/assetIdx");
        historyAlert.setAssetPath(assetPath);

        historyAlert.setMeasurepointId("temp");
        historyAlert.setValue(1);

        long now = System.currentTimeMillis();
        historyAlert.setOccurTime(now);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String localTime = df.format(now);
        historyAlert.setLocalOccurTime(localTime);
        historyAlert.setSeverityId("severityId3");

        StringI18n severityDesc = new StringI18n();
        severityDesc.setDefaultValue("default history Alert3");
        Map < String, String > map = new HashMap < > ();
        map.put("zh_CN", "警报 ");
        map.put("en_US", "history Alert");
        map.put("ja_JP", "アラートタイプ");
        map.put("es_ES", "Alerta");
        severityDesc.setI18nValue(map);
        historyAlert.setSeverityDesc(severityDesc);

        historyAlert.setTypeId("type3");

        StringI18n typeDesc = new StringI18n();
        typeDesc.setDefaultValue("default type3");
        Map < String, String > map1 = new HashMap < > ();
        map1.put("zh_CN", "中文类型");
        map1.put("en_US", "english type");
        map1.put("ja_JP", "アラートタイプ");
        map1.put("es_ES", "Alerta");
        typeDesc.setI18nValue(map1);
        historyAlert.setTypeDesc(typeDesc);

        historyAlert.setContentId("contentId 3");

        StringI18n contentDesc = new StringI18n();
        contentDesc.setDefaultValue("default history Content 3");
        Map < String, String > map2 = new HashMap < > ();
        map2.put("zh_CN", "中文内容");
        map2.put("en_US", "english history content");
        map2.put("ja_JP", "アラートタイプ");
        map2.put("es_ES", "Alerta");
        contentDesc.setI18nValue(map2);
        historyAlert.setContentDesc(contentDesc);

        StringI18n subTypeDesc = new StringI18n();
        subTypeDesc.setDefaultValue("default history sub Type 3");
        Map < String, String > map3 = new HashMap < > ();
        map3.put("zh_CN", "中文子类型");
        map3.put("en_US", "english history sub type");
        map3.put("ja_JP", "アラートタイプ");
        map3.put("es_ES", "Alerta");
        subTypeDesc.setI18nValue(map3);
        historyAlert.setSubTypeDesc(subTypeDesc);
        historyAlert.setSubTypeId("subtype3");


        Map < String, String > tags = new HashMap < > ();
        tags.put("yourTagKey", "yourTagValue");
        historyAlert.setTag(tags);
        historyAlert.setRecoverTime(System.currentTimeMillis());
        historyAlert.setRecoverReason("Reason");
        historyAlert.setHitRuleId("rule2");
        historyAlert.setRecoverLocalTime("2019-11-18 00:00:00");

        return historyAlert;
    }

    private GenerateHistoryAlert buildHistoryAlertWithDevice() {
        GenerateHistoryAlert historyAlert = new GenerateHistoryAlert();
        historyAlert.setAssetId("32CDx7FU");
        historyAlert.setModelId("demo_lift_model");

        //Optional
        historyAlert.setModelIdPath("/demo_lift_model");

        List<String> assetPath = new ArrayList<>();
        assetPath.add("treeId1:/assetId1/assetId2/assetIdx");
        assetPath.add("treeId2:/assetId3/assetIdx");
        historyAlert.setAssetPath(assetPath);

        historyAlert.setDeviceStatus("offline");
        historyAlert.setValue("offline");

        long now = System.currentTimeMillis();
        historyAlert.setOccurTime(now);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String localTime = df.format(now);
        historyAlert.setLocalOccurTime(localTime);
        historyAlert.setSeverityId("severityId1");

        StringI18n severityDesc = new StringI18n();
        severityDesc.setDefaultValue("default Alert");
        Map < String, String > map = new HashMap < > ();
        map.put("zh_CN", "警报 ");
        map.put("en_US", "Alert");
        map.put("ja_JP", "アラートタイプ");
        map.put("es_ES", "Alerta");
        severityDesc.setI18nValue(map);
        historyAlert.setSeverityDesc(severityDesc);

        historyAlert.setTypeId("type");

        StringI18n typeDesc = new StringI18n();
        typeDesc.setDefaultValue("default type");
        Map < String, String > map1 = new HashMap < > ();
        map1.put("zh_CN", "中文类型");
        map1.put("en_US", "english type");
        map1.put("ja_JP", "アラートタイプ");
        map1.put("es_ES", "Alerta");
        typeDesc.setI18nValue(map1);
        historyAlert.setTypeDesc(typeDesc);

        historyAlert.setContentId("contentId 1");

        StringI18n contentDesc = new StringI18n();
        contentDesc.setDefaultValue("default Content");
        Map < String, String > map2 = new HashMap < > ();
        map2.put("zh_CN", "中文内容");
        map2.put("en_US", "english content");
        map2.put("ja_JP", "アラートタイプ");
        map2.put("es_ES", "Alerta");
        contentDesc.setI18nValue(map2);
        historyAlert.setContentDesc(contentDesc);

        StringI18n subTypeDesc = new StringI18n();
        subTypeDesc.setDefaultValue("default sub Type");
        Map < String, String > map3 = new HashMap < > ();
        map3.put("zh_CN", "中文子类型");
        map3.put("en_US", "english sub type");
        map3.put("ja_JP", "アラートタイプ");
        map3.put("es_ES", "Alerta");
        subTypeDesc.setI18nValue(map3);
        historyAlert.setSubTypeDesc(subTypeDesc);
        historyAlert.setSubTypeId("subtype");


        Map < String, String > tags = new HashMap < > ();
        tags.put("yourTagKey", "yourTagValue");
        historyAlert.setTag(tags);
        historyAlert.setRecoverTime(System.currentTimeMillis());
        historyAlert.setRecoverReason("Reason");
        historyAlert.setHitRuleId("rule2");
        historyAlert.setRecoverLocalTime("2019-11-18 00:00:00");

        return historyAlert;
    }
}
