package com.envisioniot.example.sample.edp.streamprocessing;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class StopPipeline {

    public JSONObject stopPipeline(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String pipelineId)
    {
        Request StopPipelineRequest = new Request();

        JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey)).method("POST")
                .url(url + "/streaming/v2.0/streaming/pipeline/" + pipelineId)
                .queryParam("orgId", orgId)
                .queryParam("action", "stop")
                .getResponse(StopPipelineRequest, JSONObject.class);

        System.out.println(response);
        return response;
    }
}
