package com.envisioniot.example.sample.streamprocessing.operatepipeline;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

import java.util.Map;

public class StartPipeline {
    public JSONObject startPipeline(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String pipelineId,
            int executionMode,
            int kafkaRate,
            Map<String, Object> resourceConfig)
    {
        Request SavePipelineRequest = new Request()
                .setBodyParams("executionMode", executionMode)
                .setBodyParams("kafkaRate", kafkaRate)
                .setBodyParams("resourceConfig", resourceConfig);

        JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey)).method("POST")
                .url(url + "/streaming/v2.0/streaming/pipeline/" + pipelineId)
                .queryParam("orgId", orgId)
                .queryParam("action", "start")
                .getResponse(SavePipelineRequest, JSONObject.class);

        System.out.println(response);
        return response;
    }
}
