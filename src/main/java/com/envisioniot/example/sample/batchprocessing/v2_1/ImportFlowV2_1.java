/**
 * Copyright (C), 2015-2022, Envision
 * FileName: ImportFlowV2_1
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

import java.util.HashMap;

/**
 https://www.envisioniot.com/docs/batch-processing-api/en/2.3.0/v2.1/import_flow.html  <br>
 * @author arihant.jain
 * @create 15/3/22
 * @since --
 */

public class ImportFlowV2_1 {
    public JSONObject importFlowV2_1(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String userId,
            String flowId,
            String flowName,
            String desc,
            String dirId,
            HashMap<String, Object> flowJsonHashMap)
    {
        Request request = new Request();
        request.setQueryParam("userId",userId);
        request.setQueryParam("orgId",orgId);

        if(flowId != null){ request.setBodyParams("flowId", flowId);}
        request.setBodyParams("flowName", flowName);
        request.setBodyParams("desc", desc);
        request.setBodyParams("dirId", dirId);

        JSONObject flowJsonObject = new JSONObject(flowJsonHashMap);
        request.setBodyParams("flowJson", flowJsonObject);
        request.setQueryParam("action", "import");
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
