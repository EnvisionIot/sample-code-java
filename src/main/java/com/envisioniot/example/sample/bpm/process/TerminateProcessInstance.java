/**
 * Copyright (C), 2015-2022, Envision
 * FileName: TerminateProcessInstance
 * Author:   arihant.jain
 * Date:     18/3/2022
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.aep.bpm.process;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

import java.util.Map;

/**
 * https://www.envisioniot.com/docs/bpm-api/en/2.3.0/process/terminate_process_instance.html <br>
 *
 * @author arihant.jain
 * @create 18/3/2022
 * @since --
 */

public class TerminateProcessInstance {
    public JSONObject terminateProcessInstance(
            String accessKey,
            String secretKey,
            String url,
            String bearerToken,
            String processInstanceId,
            String deleteReason,
            String processDefinitionId)
    {
        Request request = new Request();
        request.setHeaderParam("authorization", "Bearer " + bearerToken);
        request.setQueryParam( "processInstanceId", processInstanceId);
        request.setBodyParams("processDefinitionId", processDefinitionId);
        request.setBodyParams("deleteReason", deleteReason);
        request.setQueryParam("action", "delete");
        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/enos-bpm-service/v2.0/work/process-instances")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
