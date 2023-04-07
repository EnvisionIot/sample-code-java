/**
 * Copyright (C), 2015-2022, Envision
 * FileName: TriggerFlowFromTask
 * Author:   arihant.jain
 * Date:     15/3/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.batchprocessing.v2_1;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

/**
 https://www.envisioniot.com/docs/batch-processing-api/en/2.3.0/v2.1/trigger_flow_from_task.html  <br>
 * @author arihant.jain
 * @create 15/3/22
 * @since --
 */

public class TriggerFlowFromTask {
    public JSONObject triggerFlowFromTask(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String userId,
            Integer flowId,
            Integer taskId,
            Long triggerTime)
    {
        Request request = new Request();
        request.setQueryParam("userId",userId);
        request.setQueryParam("orgId",orgId);
        request.setQueryParam("action", "triggerFromTask");

        request.setBodyParams("flowId", flowId);
        request.setBodyParams("taskId", taskId);
        request.setBodyParams("triggerTime", triggerTime);
        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/batch-processing-service/v2.1/flows")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;

    }
}
