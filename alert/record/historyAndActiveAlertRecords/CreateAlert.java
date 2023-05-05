/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.alert.record;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.alert_service.v2_1.CreateAlertRequest;
import com.envisioniot.enos.alert_service.v2_1.CreateAlertResponse;
import com.envisioniot.enos.alert_service.vo.AlertVo;
import com.envisioniot.enos.api.common.constant.common.StringI18n;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

public class CreateAlert {
    public void createActiveAlert(String accessKey, String secretKey, String orgId, String url) {
        createAlert(accessKey, secretKey, orgId, url, 3);

    }
    public void createHistoryAlert(String accessKey, String secretKey, String orgId, String url) {
        createAlert(accessKey, secretKey, orgId, url, 2);

    }
    // API can only accept eventId = 2 /3
    public void createAlert(String accessKey, String secretKey, String orgId, String url, int eventId) {
        CreateAlertRequest request = new CreateAlertRequest();
        request.setOrgId(orgId);
        request.setAlertVo(buildAlert(eventId));
        try {
            CreateAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, CreateAlertResponse.class);
            Gson gson = new Gson();
            System.out.println(gson.toJson(response));
        }catch(Exception e){
            System.out.print(e);
        }
    }
    /*public void createActiveAlertWithDevice(String accessKey, String secretKey, String orgId, String url) {
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
    }*/

    private AlertVo buildAlert(int type) {
        AlertVo alertVo = new AlertVo();
        alertVo.setEventType(type);
        alertVo.setInstanceId("instanceId2");
        alertVo.setMetricId("metricId1");
        //Optional

        long now = System.currentTimeMillis();
        alertVo.setOccurTime(now);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String localTime = df.format(now);
        alertVo.setLocalOccurTime(localTime);

        alertVo.setRecoverTime(now);
        alertVo.setLocalRecoverTime(localTime);

        alertVo.setRecoverReason("yes");

        alertVo.setValue("value");

        Map < String, String > map = new HashMap < > ();
        map.put("zh_CN", "警报tag ");
        map.put("en_US", "Alert Tag");
        map.put("ja_JP", "アラートタイプ Tag");
        map.put("es_ES", "Alerta Tag");
        alertVo.setMetricTags(map);

        alertVo.setSeverityId("serverity Id1");

        StringI18n severityDesc = new StringI18n();
        severityDesc.setDefaultValue("default Alert");
        severityDesc.setI18nValue(map);
        alertVo.setSeverityDesc(severityDesc);

        alertVo.setTypeId("typeId 1");

        StringI18n typeDesc = new StringI18n();
        typeDesc.setDefaultValue("default type");
        Map < String, String > map1 = new HashMap < > ();
        map1.put("zh_CN", "中文类型");
        map1.put("en_US", "english type");
        map1.put("ja_JP", "アラートタイプ");
        map1.put("es_ES", "Alerta");
        typeDesc.setI18nValue(map1);
        alertVo.setTypeDesc(typeDesc);


        //
        alertVo.setParentTypeId("Parent Type Id 1");
        StringI18n parentTypeDesc = new StringI18n();
        parentTypeDesc.setDefaultValue("default Content");
        Map < String, String > map2 = new HashMap < > ();
        map2.put("zh_CN", "中文内容");
        map2.put("en_US", "english content");
        map2.put("ja_JP", "アラートタイプ");
        map2.put("es_ES", "Alerta");
        parentTypeDesc.setI18nValue(map2);
        alertVo.setParentTypeDesc(parentTypeDesc);

        StringI18n content = new StringI18n();
        content.setDefaultValue("default Content");
        Map < String, String > content_map = new HashMap < > ();
        content_map.put("zh_CN", "中文内容");
        content_map.put("en_US", "english content");
        content_map.put("ja_JP", "アラートタイプ");
        content_map.put("es_ES", "Alerta");
        content.setI18nValue(content_map);
        alertVo.setContent(content);

        alertVo.setRuleId("Rule Id 1");
        StringI18n ruleDesc = new StringI18n();
        ruleDesc.setDefaultValue("default sub Type");
        Map < String, String > map3 = new HashMap < > ();
        map3.put("zh_CN", "中文子类型");
        map3.put("en_US", "english sub type");
        map3.put("ja_JP", "アラートタイプ");
        map3.put("es_ES", "Alerta");
        ruleDesc.setI18nValue(map3);
        alertVo.setRuleDesc(ruleDesc);

        Map < String, String > ruletag = new HashMap < > ();
        ruletag.put("zh_CN", "中文内容");
        ruletag.put("en_US", "english content");
        ruletag.put("ja_JP", "アラートタイプ");
        ruletag.put("es_ES", "Alerta");
        alertVo.setRuleTags(ruletag);



        Map < String, String > tag = new HashMap < > ();
        tag.put("zh_CN", "中文内容");
        tag.put("en_US", "english content");
        tag.put("ja_JP", "アラートタイプ");
        tag.put("es_ES", "Alerta");
        alertVo.setTags(tag);

        alertVo.setInhibited(false);

        return alertVo;
    }
}
