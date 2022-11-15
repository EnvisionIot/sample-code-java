/**
 * Copyright (C), 2015-2022, Envision
 * FileName: SearchSendResult
 * Author:   arihant.jain
 * Date:     25/3/2022
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.notificationmanagement;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

import java.util.HashMap;

/**
 * https://www.envisioniot.com/docs/notification-mgmt-api/en/2.3.0/api_reference/search_send_result.html  <br>
 *
 * @author arihant.jain
 * @create 25/3/2022
 * @since --
 */

public class SearchSendResult {
    public JSONObject searchSendResult(
            String accessKey,
            String secretKey,
            String url,
            String orgId,
            String eventId)
    {
        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setBodyParams("eventId", eventId);
        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/notification-center-service/v2.0/search/message")
                    .getResponse(request, JSONObject.class);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
