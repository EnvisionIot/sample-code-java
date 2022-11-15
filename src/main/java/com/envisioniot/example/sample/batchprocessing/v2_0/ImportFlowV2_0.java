/**
 * Copyright (C), 2015-2022, Envision
 * FileName: ImportFlowV2_0
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
import com.google.gson.JsonObject;

import java.util.HashMap;

/**
 * https://www.envisioniot.com/docs/batch-processing-api/en/2.3.0/v2.0/import_flow.html  <br>
 * @author arihant.jain
 * @create 15/3/22
 * @since --
 */

public class ImportFlowV2_0 {
    public JSONObject importFlowV2_0(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String userId,
            String flowId,
            String flowName,
            String desc,
            String dirId,
            HashMap<String, Object> flowHashMapV2_0)
    {
        Request request = new Request();
        request.setQueryParam("userId",userId);
        request.setQueryParam("orgId",orgId);

        if(flowId != null){ request.setBodyParams("flowId", flowId);}
        request.setBodyParams("flowName", flowName);
        request.setBodyParams("desc", desc);
        request.setBodyParams("dirId", dirId);

        JSONObject flowJsonObject = new JSONObject(flowHashMapV2_0);
        System.out.println(flowJsonObject);
        request.setBodyParams("flowJson", flowJsonObject);
        request.setQueryParam("action", "import");
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
