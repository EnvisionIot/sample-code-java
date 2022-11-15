package com.envisioniot.example.sample.streamprocessing;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class GetPipelineOffsetLag {
    public JSONObject getPipelineOffsetLag(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String pipelineId)
    {
        Request GetPipelineOffsetLagRequest = new Request();

        JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey)).method("GET")
                .url(url + "/streaming/v2.0/streaming/pipeline/" + pipelineId + "/offset-lag")
                .queryParam("orgId", orgId)
                .getResponse(GetPipelineOffsetLagRequest, JSONObject.class);

        System.out.println(response);
        return response;
    }

}
