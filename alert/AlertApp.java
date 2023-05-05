/**
 * Copyright (C), 2015-2022, Envision
 * FileName: AlertApp
 * Author:   xibin.song
 * Date:     1/6/2022 9:21 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.alert;

import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.api.common.constant.request.Sorter;
import com.envisioniot.example.sample.alert.content.*;
import com.envisioniot.example.sample.alert.record.*;
import com.envisioniot.example.sample.alert.record.old.*;
import com.envisioniot.example.sample.alert.record.old.history.CreateHistoryAlert;
import com.envisioniot.example.sample.alert.record.old.history.CreateHistoryAlertBatch;
import com.envisioniot.example.sample.alert.record.old.history.ScrollHistoryAlert;
import com.envisioniot.example.sample.alert.record.old.history.SearchHistoryAlert;
import com.envisioniot.example.sample.alert.record.old.tag.BatchUpdateActiveAlertTags;
import com.envisioniot.example.sample.alert.record.old.tag.UpdateActiveAlertTags;
import com.envisioniot.example.sample.alert.record.old.tag.UpdateHistoryAlertTags;
import com.envisioniot.example.sample.alert.rule.CreateAlertRule;
import com.envisioniot.example.sample.alert.rule.DeleteAlertRule;
import com.envisioniot.example.sample.alert.rule.SearchAlertRule;
import com.envisioniot.example.sample.alert.rule.UpdateAlertRule;
import com.envisioniot.example.sample.alert.severity.CreateAlertSeverity;
import com.envisioniot.example.sample.alert.severity.DeleteAlertSeverity;
import com.envisioniot.example.sample.alert.severity.SearchAlertSeverity;
import com.envisioniot.example.sample.alert.severity.UpdateAlertSeverity;
import com.envisioniot.example.sample.alert.type.CreateAlertType;
import com.envisioniot.example.sample.alert.type.DeleteAlertType;
import com.envisioniot.example.sample.alert.type.SearchAlertType;
import com.envisioniot.example.sample.alert.type.UpdateAlertType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class AlertApp {
    public void alertAppGeneral(String accessKey, String secretKey, String orgId, String url) {

        //1. Severity
        // https://support.envisioniot.com/docs/alert-api/en/2.3.0/index_severity.html
        CreateAlertSeverity createAlertSeverity =  new CreateAlertSeverity();
        createAlertSeverity.createAlertSeverity(accessKey, secretKey, orgId, url);

        DeleteAlertSeverity deleteAlertSeverity =  new DeleteAlertSeverity();
        deleteAlertSeverity.deleteAlertSeverity(accessKey, secretKey, orgId, url);

        SearchAlertSeverity searchAlertSeverity =  new SearchAlertSeverity();
        searchAlertSeverity.searchAlertSeverity(accessKey, secretKey, orgId, url);

        searchAlertSeverity.searchAlertSeveritywithExpressions(accessKey, secretKey, orgId, url, "severityId = '1'");
        searchAlertSeverity.searchAlertSeveritywithExpressions(accessKey, secretKey, orgId, url, "tags.category = 'demo'");
        searchAlertSeverity.searchAlertSeveritywithExpressions(accessKey, secretKey, orgId, url, "severityId in ('1' , 'L1', 'your levelId')");
        searchAlertSeverity.searchAlertSeveritywithExpressions(accessKey, secretKey, orgId, url, "severityId in ('1' , 'L1', 'your levelId') or tags.category = 'demo'" );
        searchAlertSeverity.searchAlertSeveritywithExpressions(accessKey, secretKey, orgId, url, "severityId in ('1' , 'L100', 'your levelId') and tags.category = 'demo'" );

        UpdateAlertSeverity updateAlertSeverity = new UpdateAlertSeverity();
        updateAlertSeverity.updateAlertSeverity(accessKey, secretKey, orgId, url);

        // 2 Alert Type
        // https://support.envisioniot.com/docs/alert-api/en/2.3.0/index_type.html

        CreateAlertType createAlertType = new CreateAlertType();
        createAlertType.createAlertType(accessKey, secretKey, orgId, url);
        createAlertType.createAlertTypeWithParent(accessKey, secretKey, orgId, url);

        UpdateAlertType updateAlertType = new UpdateAlertType();
        updateAlertType.updateAlertType(accessKey, secretKey, orgId, url);
        updateAlertType.updateAlertTypeWithParent(accessKey, secretKey, orgId, url);

        DeleteAlertType deleteAlertType = new DeleteAlertType();
        deleteAlertType.deleteAlertType(accessKey, secretKey, orgId, url);

        SearchAlertType searchAlertType = new SearchAlertType();
        searchAlertType.searchAlertType(accessKey, secretKey, orgId, url);


        // 3. Alert Content
        // https://support.envisioniot.com/docs/alert-api/en/2.3.0/index_content.html

        CreateAlertContent createAlertContent = new CreateAlertContent();
        createAlertContent.createAlertContent(accessKey, secretKey, orgId, url);

        GetAlertContent getAlertContent = new GetAlertContent();
        getAlertContent.getAlertContent(accessKey, secretKey, orgId, url);

        //******  Issue found. setSource is not working.
        DeleteAlertContent deleteAlertContent = new DeleteAlertContent();
        deleteAlertContent.deleteAlertContent(accessKey, secretKey, orgId, url);

        UpdateAlertContent updateAlertContent = new UpdateAlertContent();
        updateAlertContent.updateAlertContent(accessKey, secretKey, orgId, url);
        // Issue found. some part are not working.
        updateAlertContent.updateAlertContentWithExtraConfiguration(accessKey, secretKey, orgId, url);

        SearchAlertContent searchAlertContent = new SearchAlertContent();
        searchAlertContent.searchAlertContent(accessKey, secretKey, orgId, url);
        searchAlertContent.searchAlertContentwithModelId(accessKey, secretKey, orgId, url);
        searchAlertContent.searchAlertContentwithAlertTypeId(accessKey, secretKey, orgId, url);
        searchAlertContent.searchAlertContentwithSubAlertTypeId(accessKey, secretKey, orgId, url);

        // 4. Alert Rule
        // https://support.envisioniot.com/docs/alert-api/en/2.3.0/index_rule.html

        // needs more
        CreateAlertRule createAlertRule = new CreateAlertRule();
        createAlertRule.createAlertRule(accessKey, secretKey, orgId, url);
        createAlertRule.createAlertRuleWithMeasurePointCondition(accessKey, secretKey, orgId, url, "rule1","temp", "(${temp} < 30 )");
        createAlertRule.createAlertRuleWithMeasurePointCondition(accessKey, secretKey, orgId, url, "rule2","temp", "(${temp} < 30 ) and  (${temp} > 26) ");
        createAlertRule.createAlertRuleWithMeasurePointCondition(accessKey, secretKey, orgId, url, "rule3","temp", "(${temp} < 30 ) and  (${temp} > 26)  and (${temp} = 20)");
        createAlertRule.createAlertRuleWithMeasurePointCondition(accessKey, secretKey, orgId, url, "rule4","temp", "(${temp} < 30 ) and  ((${temp} > 26)  and (${temp} = 20))");

        createAlertRule.createAlertRuleWithDeviceCondition(accessKey, secretKey, orgId, url, "rule5");

        // Asset id must be linked to tre id.  This works on the old version of Alert Rule
        createAlertRule.createAlertRuleAssetTreeId(accessKey, secretKey, orgId, url, "rule6","ChahG3d9", "o8x6gHUH");

        SearchAlertRule searchAlertRule = new SearchAlertRule();
        Pagination pagination = new Pagination();
        pagination.setPageNo(1);
        pagination.setPageSize(10);
        List< Sorter > sorterList = new ArrayList< >();
        //can use : ruleId, modelId, measurepointId, deviceStatus, and orgId.
        sorterList.add(new Sorter("ruleId", Sorter.Order.DESC));
        pagination.setSorters(sorterList);
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "your modelId", null, null, null );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "your modelId", "temp", null, null );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "temp", null, null );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "", "deviceStatus = 'offline'", null );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "", "deviceStatus = 'offline'", null );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "", "ruleId  = 'your ruleId'", null );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "", "modelId  = 'your modelId'", null );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "", "ruleId  in ('rule1', 'rule2', 'rule3' )", null );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "", "modelId  in ('demo_lift_model', 'RPi' )", pagination );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "", "modelId  = 'battery-model'", null );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "", "ruleId  in ('rule1', 'rule2', 'rule3' ) or modelId = 'battery-model'", null );

        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "", "ruleId  in ('rule1', 'rule2', 'rule3' ) or modelId = 'battery-model'", null );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "", "measurepointId  is null", null );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "", "deviceStatus  is null", null );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "", "measurepointId  = 'temp' ", null );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "", "measurepointId  in ( 'temp', 'temperature') ", null );
        searchAlertRule.searchAlertRuleWithExpression(accessKey, secretKey, orgId, url, "", "", "tags.yourTagKey = 'yourTagValue'", null );

        UpdateAlertRule updateAlertRule = new UpdateAlertRule();
        updateAlertRule.updateAlertRule(accessKey, secretKey, orgId, url);
        updateAlertRule.updateAlertRule2(accessKey, secretKey, orgId, url);

        try {
            Thread.sleep(600000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DeleteAlertRule alertRule2 = new DeleteAlertRule();
        for(int i = 0; i<7; i++)
            alertRule2.deleteAlertRule(accessKey, secretKey, orgId, url, "rule"+i);

        // New Version
        // https://support.envisioniot.com/docs/alert-api/en/2.3.0/new_version/index_alert_record_new.html

        // https://support.envisioniot.com/docs/alert-api/en/2.3.0/new_version/index_alert_record.html

        CreateAlert createAlert = new CreateAlert();
        createAlert.createActiveAlert(accessKey, secretKey, orgId, url);
        createAlert.createHistoryAlert(accessKey, secretKey, orgId, url);

        BatchCreateAlert batchCreateAlert = new BatchCreateAlert();
        batchCreateAlert.createActiveAlert(accessKey, secretKey, orgId, url);
        batchCreateAlert.createHistoryAlert(accessKey, secretKey, orgId, url);


        SearchAlert searchAlert = new SearchAlert();
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "instanceId = 'ChahG3d9'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "instanceId in ( 'ChahG3d9', 'GW46kFBhkA')");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "instanceId != 'ChahG3d9'");

        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "metricId = 'metricId1'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "metricId in ( 'metricId1', 'temp')");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "metricId != 'metricId1'");

        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "severityId = 'severityId1'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "severityId in ( 'severityId1', 'severityId2')");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "severityId != 'severityId1'");

        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "typeId = 'yourAlertTypeId'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "typeId in ( 'yourAlertTypeId', 'typeId 1')");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "typeId != 'typeId 1'");

        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "parentTypeId = 'parentTypeId'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "parentTypeId in ( 'parentTypeId', 'parentTypeId1')");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "parentTypeId != 'parentTypeId'");

        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "contentId = 'yourContentId'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "contentId in ( 'yourContentId', 'contentId 1')");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "contentId != 'yourContentId'");

        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "ruleId = 'rule4'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "ruleId in ( 'rule4', 'rule1')");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "ruleId != 'rule4'");

        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "eventType = 0");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "eventType in ( 0, 1)");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "eventType != 0");

        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "alertId = '202202072ed675dd62509894db254d062802fcc9'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "alertId in ( '202202072ed675dd62509894db254d062802fcc9', '202202047c5977957ee89919f069bc7862206d1d')");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "alertId != '202202072ed675dd62509894db254d062802fcc9'");

        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "metricTags.yourTagKey = 'Alert Tag'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "metricTags.yourTagKey in ( 'Alert Tag', 'yourTagValue_1')");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "metricTags.yourTagKey != 'Alert Tag'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "metricTags.yourTagKey like 'Tag'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "exists(metricTags.yourTagKey)");

        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "tags.yourTagKey = 'yourTagValue'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "tags.yourTagKey in ( 'yourTagValue', 'yourTagValue_1')");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "tags.yourTagKey != 'Alert Tag'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "tags.yourTagKey like 'Tag'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "exists(tags.yourTagKey)");

        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "ruleTags.en_US = 'yourTagValue'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "ruleTags.en_US in ( 'yourTagValue', 'yourTagValue_1')");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "ruleTags.en_US != 'Alert Tag'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "ruleTags.en_US like 'Tag'");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "exists(ruleTags.en_US)");

        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "inhibited = true");
        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "inhibited != true");

        searchAlert.searchAlert(accessKey, secretKey, orgId, url, "maskedBy = 'test' ");

        searchAlert.searchAlertWithOtherParams(accessKey, secretKey, orgId, url, "");


        ScollAlert scollAlert = new ScollAlert();
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "instanceId = 'ChahG3d9'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "instanceId in ( 'ChahG3d9', 'GW46kFBhkA')");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "instanceId != 'ChahG3d9'");

        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "metricId = 'metricId1'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "metricId in ( 'metricId1', 'temp')");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "metricId != 'metricId1'");

        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "severityId = 'severityId1'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "severityId in ( 'severityId1', 'severityId2')");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "severityId != 'severityId1'");

        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "typeId = 'yourAlertTypeId'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "typeId in ( 'yourAlertTypeId', 'typeId 1')");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "typeId != 'typeId 1'");

        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "parentTypeId = 'parentTypeId'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "parentTypeId in ( 'parentTypeId', 'parentTypeId1')");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "parentTypeId != 'parentTypeId'");

        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "contentId = 'yourContentId'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "contentId in ( 'yourContentId', 'contentId 1')");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "contentId != 'yourContentId'");

        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "ruleId = 'rule4'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "ruleId in ( 'rule4', 'rule1')");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "ruleId != 'rule4'");

        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "eventType = 0");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "eventType in ( 0, 1)");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "eventType != 0");

        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "alertId = 'your alertId'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "alertId in ( 'your alertId', 'your alertId')");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "alertId != 'your alertId'");

        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "metricTags.tags.yourTagKey = 'Alert Tag'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "metricTags.tags.yourTagKey in ( 'Alert Tag', 'yourTagValue_1')");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "metricTags.tags.yourTagKey != 'Alert Tag'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "metricTags.tags.yourTagKey like 'Tag'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "exists(metricTags.yourTagKey)");

        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "tags.yourTagKey = 'yourTagValue'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "tags.yourTagKey in ( 'yourTagValue', 'yourTagValue_1')");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "tags.yourTagKey != 'Alert Tag'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "tags.yourTagKey like 'Tag'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "exists(tags.yourTagKey)");

        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "ruleTags.en_US = 'yourTagValue'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "ruleTags.en_US in ( 'yourTagValue', 'yourTagValue_1')");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "ruleTags.en_US != 'Alert Tag'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "ruleTags.en_US like 'Tag'");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "exists(ruleTags.en_US)");

        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "inhibited = true");
        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "inhibited != true");

        scollAlert.scollAlert(accessKey, secretKey, orgId, url, "maskedBy = 'test' ");

        scollAlert.scollAlertWithOtherParams(accessKey, secretKey, orgId, url, "");

        CloseAlert closeAlert = new CloseAlert();
        closeAlert.closeAlert(accessKey, secretKey, orgId, url, "your alertId");


        // New Alert Tags
        // https://support.envisioniot.com/docs/alert-api/en/2.3.0/new_version/index_alert_tag.html

        UpdateAlertTags updateAlertTags = new UpdateAlertTags();
        updateAlertTags.updateAlertTags(accessKey, secretKey, orgId, url);

        BatchUpdateAlertTags batchUpdateAlertTags = new BatchUpdateAlertTags();
        batchUpdateAlertTags.batchUpdateAlertTags(accessKey, secretKey, orgId, url);

    }
}
