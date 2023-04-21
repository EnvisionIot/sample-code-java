package com.envisioniot.example.sample.streamprocessing.operatepipeline;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class ReleasePipeline {
    public JSONObject releasePipeline(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String pipelineId)
    {
        Request ReleasePipelineRequest = new Request();

        JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey)).method("POST")
                .url(url + "/streaming/v2.0/streaming/pipeline/" + pipelineId)
                .queryParam("orgId", orgId)
                .queryParam("action", "release")
                .getResponse(ReleasePipelineRequest, JSONObject.class);

        System.out.println(response);
        return response;
    }
}

