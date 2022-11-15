package com.envisioniot.example.sample.streamprocessing;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

import java.util.HashMap;
import java.util.Map;

public class StartPipeline {
    public JSONObject startPipeline(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String pipelineId)
    {
        Request SavePipelineRequest = new Request()
        .setBodyParams("executionMode", "0")
        .setBodyParams("kafkaRate", "1000");

        Map<String, String> resourceConfig=new HashMap<>();
        resourceConfig.put("server","1");

        JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey)).method("POST")
                .url(url + "/streaming/v2.0/streaming/pipeline/" + pipelineId)
                .queryParam("orgId", orgId)
                .queryParam("action", "start")
                .getResponse(SavePipelineRequest, JSONObject.class);

        System.out.println(response);
        return response;
    }
}
