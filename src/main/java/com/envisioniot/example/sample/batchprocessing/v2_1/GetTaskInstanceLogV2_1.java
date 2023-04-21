/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetTaskInstanceLogV2_1
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
 https://www.envisioniot.com/docs/batch-processing-api/en/2.3.0/v2.1/get_task_instance_log.html  <br>
 * @author arihant.jain
 * @create 15/3/22
 * @since --
 */

public class GetTaskInstanceLogV2_1 {
    public JSONObject getTaskInstanceLogV2_1(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String userId,
            String taskInstId,
            Integer maxLength)
    {

        Request request = new Request();
        request.setQueryParam("taskInstId",taskInstId);
        request.setQueryParam("userId",userId);
        request.setQueryParam("orgId",orgId);
        if(maxLength != null){ request.setQueryParam("maxLength",maxLength);}
        request.setQueryParam("action", "getLog");
        request.setMethod("GET");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/batch-processing-service/v2.1/taskInstances")
                    .getResponse(request, JSONObject.class);
            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
