/**
 * Copyright (C), 2015-2022, Envision
 * FileName: ListFlowInstancesV2_0
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

public class ListFlowInstancesV2_0 {
    public JSONObject listFlowInstancesV2_0(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String userId,
            HashMap<String, Object> listflowInstanceParamMap)
    {
        Request request = new Request();
        request.setQueryParam("userId",userId);
        request.setQueryParam("orgId",orgId);
        request.setQueryParam("action", "search");

        request.setBodyParams(listflowInstanceParamMap);
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
