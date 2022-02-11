/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.alert.record.old;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.BatchCreateActiveAlertsRequest;
import com.envisioniot.enos.event_service.v2_1.BatchCreateActiveAlertsResponse;
import com.envisioniot.enos.event_service.v2_1.CreateActiveAlertRequest;
import com.envisioniot.enos.event_service.v2_1.CreateActiveAlertResponse;
import com.envisioniot.enos.event_service.vo.GenerateActiveAlert;
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

public class CreateActiveAlertBatch {
    public void createActiveAlertBatch(String accessKey, String secretKey, String orgId, String url) {
        BatchCreateActiveAlertsRequest request = new BatchCreateActiveAlertsRequest();
        request.setOrgId(orgId);
        List < GenerateActiveAlert > list = Lists.newArrayList();
        GenerateActiveAlert activeAlert1 = buildActiveAlert();
        Map < String, String > tags = new HashMap < > ();
        tags.put("yourTagKey1", "yourTagValue1");
        activeAlert1.setTag(tags);
        list.add(activeAlert1);
        GenerateActiveAlert activeAlert2 = buildActiveAlert();
        tags = new HashMap < > ();
        tags.put("yourTagKey2", "yourTagValue2");
        activeAlert2.setTag(tags);
        list.add(activeAlert2);
        GenerateActiveAlert activeAlert3 = buildActiveAlert();
        tags = new HashMap < > ();
        tags.put("yourTagKey3", "yourTagValue3");
        activeAlert3.setTag(tags);
        list.add(activeAlert3);
        request.setActiveAlertList(list);
        try {
            BatchCreateActiveAlertsResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, BatchCreateActiveAlertsResponse.class);
            System.out.println(response);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public void createActiveAlertWithDevice(String accessKey, String secretKey, String orgId, String url) {
        CreateActiveAlertRequest request = new CreateActiveAlertRequest();
        request.setOrgId(orgId);
        GenerateActiveAlert activeAlert = buildActiveAlertWithDevice();
        Map < String, String > tags = new HashMap < > ();
        tags.put("yourTagKey", "yourTagValue");
        activeAlert.setTag(tags);
        request.setActiveAlert(activeAlert);
        try {
            CreateActiveAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, CreateActiveAlertResponse.class);

            System.out.println(response);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    private GenerateActiveAlert buildActiveAlert() {
        GenerateActiveAlert activeAlert = new GenerateActiveAlert();
        activeAlert.setAssetId("ChahG3d9");
        activeAlert.setModelId("demo_lift_model");

        //Optional
        activeAlert.setModelIdPath("/demo_lift_model");

        List<String> assetPath = new ArrayList<>();
        assetPath.add("treeId1:/assetId1/assetId2/assetIdx");
        assetPath.add("treeId2:/assetId3/assetIdx");
        activeAlert.setAssetPath(assetPath);

        activeAlert.setMeasurepointId("temp");
        activeAlert.setValue(1);

        long now = System.currentTimeMillis();
        activeAlert.setOccurTime(now);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String localTime = df.format(now);
        activeAlert.setLocalOccurTime(localTime);
        activeAlert.setSeverityId("severityId2");

        StringI18n severityDesc = new StringI18n();
        severityDesc.setDefaultValue("default Alert");
        Map < String, String > map = new HashMap < > ();
        map.put("zh_CN", "警报 ");
        map.put("en_US", "Alert");
        map.put("ja_JP", "アラートタイプ");
        map.put("es_ES", "Alerta");
        severityDesc.setI18nValue(map);
        activeAlert.setSeverityDesc(severityDesc);

        activeAlert.setTypeId("type2");

        StringI18n typeDesc = new StringI18n();
        typeDesc.setDefaultValue("default type");
        Map < String, String > map1 = new HashMap < > ();
        map1.put("zh_CN", "中文类型");
        map1.put("en_US", "english type");
        map1.put("ja_JP", "アラートタイプ");
        map1.put("es_ES", "Alerta");
        typeDesc.setI18nValue(map1);
        activeAlert.setTypeDesc(typeDesc);

        activeAlert.setContentId("contentId 2");

        StringI18n contentDesc = new StringI18n();
        contentDesc.setDefaultValue("default Content");
        Map < String, String > map2 = new HashMap < > ();
        map2.put("zh_CN", "中文内容");
        map2.put("en_US", "english content");
        map2.put("ja_JP", "アラートタイプ");
        map2.put("es_ES", "Alerta");
        contentDesc.setI18nValue(map2);
        activeAlert.setContentDesc(contentDesc);

        StringI18n subTypeDesc = new StringI18n();
        subTypeDesc.setDefaultValue("default sub Type");
        Map < String, String > map3 = new HashMap < > ();
        map3.put("zh_CN", "中文子类型");
        map3.put("en_US", "english sub type");
        map3.put("ja_JP", "アラートタイプ");
        map3.put("es_ES", "Alerta");
        subTypeDesc.setI18nValue(map3);
        activeAlert.setSubTypeDesc(subTypeDesc);
        activeAlert.setSubTypeId("subtype2");
        return activeAlert;
    }

    private GenerateActiveAlert buildActiveAlertWithDevice() {
        GenerateActiveAlert activeAlert = new GenerateActiveAlert();
        activeAlert.setAssetId("ChahG3d9");
        activeAlert.setModelId("demo_lift_model");

        //Optional
        activeAlert.setModelIdPath("/demo_lift_model");

        List<String> assetPath = new ArrayList<>();
        assetPath.add("treeId1:/assetId1/assetId2/assetIdx");
        assetPath.add("treeId2:/assetId3/assetIdx");
        activeAlert.setAssetPath(assetPath);

        activeAlert.setDeviceStatus("offline");
        activeAlert.setValue("offline");

        long now = System.currentTimeMillis();
        activeAlert.setOccurTime(now);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String localTime = df.format(now);
        activeAlert.setLocalOccurTime(localTime);
        activeAlert.setSeverityId("severityId1");

        StringI18n severityDesc = new StringI18n();
        severityDesc.setDefaultValue("default Alert");
        Map < String, String > map = new HashMap < > ();
        map.put("zh_CN", "警报 ");
        map.put("en_US", "Alert");
        map.put("ja_JP", "アラートタイプ");
        map.put("es_ES", "Alerta");
        severityDesc.setI18nValue(map);
        activeAlert.setSeverityDesc(severityDesc);

        activeAlert.setTypeId("type");

        StringI18n typeDesc = new StringI18n();
        typeDesc.setDefaultValue("default type");
        Map < String, String > map1 = new HashMap < > ();
        map1.put("zh_CN", "中文类型");
        map1.put("en_US", "english type");
        map1.put("ja_JP", "アラートタイプ");
        map1.put("es_ES", "Alerta");
        typeDesc.setI18nValue(map1);
        activeAlert.setTypeDesc(typeDesc);

        activeAlert.setContentId("contentId 1");

        StringI18n contentDesc = new StringI18n();
        contentDesc.setDefaultValue("default Content");
        Map < String, String > map2 = new HashMap < > ();
        map2.put("zh_CN", "中文内容");
        map2.put("en_US", "english content");
        map2.put("ja_JP", "アラートタイプ");
        map2.put("es_ES", "Alerta");
        contentDesc.setI18nValue(map2);
        activeAlert.setContentDesc(contentDesc);

        StringI18n subTypeDesc = new StringI18n();
        subTypeDesc.setDefaultValue("default sub Type");
        Map < String, String > map3 = new HashMap < > ();
        map3.put("zh_CN", "中文子类型");
        map3.put("en_US", "english sub type");
        map3.put("ja_JP", "アラートタイプ");
        map3.put("es_ES", "Alerta");
        subTypeDesc.setI18nValue(map3);
        activeAlert.setSubTypeDesc(subTypeDesc);
        activeAlert.setSubTypeId("subtype");
        return activeAlert;
    }
}
