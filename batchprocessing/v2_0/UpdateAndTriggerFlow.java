/**
 * Copyright (C), 2015-2022, Envision
 * FileName: UpdateAndTriggerFlow
 * Author:   arihant.jain
 * Date:     15/3/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.batchprocessing.v2_0;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

/**
 * https:///www.envisioniot.com/docs/batch-processing-api/en/2.3.0/v2.0/update_and_trigger_flow.html  <br>
 * @author arihant.jain
 * @create 15/3/22
 * @since --
 */

public class UpdateAndTriggerFlow {
    public JSONObject updateAndTriggerFlow(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String userId,
            Integer flowId,
            Long triggerTime,
            Object parameters)
    {
        Request request = new Request();
        request.setQueryParam("userId",userId);
        request.setQueryParam("orgId",orgId);
        request.setQueryParam("action", "updateAndTrigger");

        request.setBodyParams("flowId", flowId);
        request.setBodyParams("triggerTime", triggerTime);
        request.setBodyParams("parameters", parameters);

        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/dataflow-batch-service/v2.0/flows")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;


    }

}
