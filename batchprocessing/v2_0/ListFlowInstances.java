/**
 * Copyright (C), 2015-2022, Envision
 * FileName: ListFlowInstances
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

import java.util.HashMap;

/**
 * https://www.envisioniot.com/docs/batch-processing-api/en/2.3.0/v2.0/list_flow_instances.html  <br>
 * @author arihant.jain
 * @create 15/3/22
 * @since --
 */

public class ListFlowInstances {
    public JSONObject listFlowInstances(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String userId,
            HashMap<String, Object> listFlowInstanceParamMap)
    {
        Request request = new Request();
        request.setQueryParam("userId",userId);
        request.setQueryParam("orgId",orgId);
        request.setQueryParam("action", "search");

        request.setBodyParams(listFlowInstanceParamMap);
        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/dataflow-batch-service/v2.0/flowInstances")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
