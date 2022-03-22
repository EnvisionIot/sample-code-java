package com.envisioniot.example.sample.aep.bpm.process;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class GetProcessInstance {
    public JSONObject getProcessInstance(
            String accessKey,
            String secretKey,
            String url,
            String bearerToken,
            String processInstanceId)
    {
        Request request = new Request();
        request.setHeaderParam("Content-Type", "application/json");
        request.setHeaderParam("authorization", "Bearer " + bearerToken);
        request.setQueryParam("processInstanceId", processInstanceId);
        request.setMethod("GET");

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
