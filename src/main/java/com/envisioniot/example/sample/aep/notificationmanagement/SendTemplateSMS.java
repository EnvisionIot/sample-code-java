/**
 * Copyright (C), 2015-2022, Envision
 * FileName: SendTemplateSMS
 * Author:   arihant.jain
 * Date:     24/3/2022
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.aep.notificationmanagement;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

import java.util.HashMap;

/**
 * https://www.envisioniot.com/docs/notification-mgmt-api/en/2.3.0/api_reference/send_template_sms.html  <br>
 *
 * @author arihant.jain
 * @create 24/3/2022
 * @since --
 */

public class SendTemplateSMS {
    public JSONObject sendTemplateSMS(
            String accessKey,
            String secretKey,
            String url,
            String orgId,
            HashMap<String, Object> paramsMap)
    {
        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setBodyParams(paramsMap);
        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/notification-center-service/v2.0/template/sms")
                    .getResponse(request, JSONObject.class);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
