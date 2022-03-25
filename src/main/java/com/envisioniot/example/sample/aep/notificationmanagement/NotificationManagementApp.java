/**
 * Copyright (C), 2015-2022, Envision
 * FileName: NotificationManagementApp
 * Author:   arihant.jain
 * Date:     24/3/2022
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.aep.notificationmanagement;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://www.envisioniot.com/docs/notification-mgmt-api/en/2.3.0/overview.html  <br>
 *
 * @author arihant.jain
 * @create 24/3/2022
 * @since --
 */

public class NotificationManagementApp {
    public void notificationManagementApp(String accessKey, String secretKey, String orgId, String url) {
        //  Send Template Mail
        SendTemplateMail sendtemplatemail = new SendTemplateMail();
        //  Send Template Mail - Parameters Map
        HashMap<String, Object> sendTemplateMailParams = new HashMap<>();
        //  Send Template Mail - Parameters Map: Setting mandatory parameters
        sendTemplateMailParams.put("templateCode", "AMC_MAIL_CN_STEP_NOTIFI");
        List<String> addressList = new ArrayList<>();
        addressList.add("arihant.jain@envision-digital.com");
        sendTemplateMailParams.put("toAddresses", addressList);
        sendTemplateMailParams.put("senderCode", "EnOS_Cloud");
        HashMap<String, String> sendTemplateMailVariables  = new HashMap<>();
        // $(USER);$(CURRENT_STEP);$(NEXT_STEP);$(URL_LINK);$(ORGANIZATION);$(SITE);$(REMARK)
        sendTemplateMailVariables.put("USER", "yourVariableValueHere");
        sendTemplateMailVariables.put("CURRENT_STEP", "yourVariableValueHere");
        sendTemplateMailVariables.put("NEXT_STEP", "yourVariableValueHere");
        sendTemplateMailVariables.put("URL_LINK", "yourVariableValueHere");
        sendTemplateMailVariables.put("ORGANIZATION", "yourVariableValueHere");
        sendTemplateMailVariables.put("SITE", "yourVariableValueHere");
        sendTemplateMailVariables.put("REMARK", "yourVariableValueHere");

        sendTemplateMailParams.put("variables", sendTemplateMailVariables);

        sendtemplatemail.sendTemplateMail(accessKey, secretKey, url, orgId, sendTemplateMailParams);



        //  Send Template SMS
        SendTemplateSMS sendtemplatesms = new SendTemplateSMS();

        HashMap<String, Object> sendTemplateSMSParams = new HashMap<>();
        sendTemplateSMSParams.put("templateCode", "AXS_SMS_CN_DAILY_REPORT");
        //List<String> phoneList = new ArrayList<>();
        JSONArray phoneJSONArray = new JSONArray();
        JSONObject phoneJSONObject = new JSONObject();
        phoneJSONObject.put("area", "65");
        phoneJSONObject.put("number", "97695597");
        phoneJSONArray.add(phoneJSONObject);

        sendTemplateSMSParams.put("phones", phoneJSONArray);
        sendTemplateSMSParams.put("tunnelCode", "NOTICE_NEXMO");

        HashMap<String, String> sendTemplateSMSVariables = new HashMap<>();
        //$(SUMMARY);$(START_TIME);$(STATUS);$(DETAIL)
        sendTemplateSMSVariables.put("SUMMARY", "TEST");
        sendTemplateSMSVariables.put("START_TIME", "TEST");
        sendTemplateSMSVariables.put("STATUS", "TEST");
        sendTemplateSMSVariables.put("DETAIL", "TEST");

        sendTemplateSMSParams.put("variables", sendTemplateSMSVariables);

        //sendtemplatesms.sendTemplateSMS(accessKey, secretKey, url, orgId,sendTemplateSMSParams);

        //  Search Send Result
        SearchSendResult searchsendresult = new SearchSendResult();
        searchsendresult.searchSendResult(accessKey, secretKey, url, orgId, "evt16481721517651563");



    }
}
