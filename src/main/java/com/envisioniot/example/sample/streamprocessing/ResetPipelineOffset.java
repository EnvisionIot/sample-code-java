package com.envisioniot.example.sample.streamprocessing;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class ResetPipelineOffset {
    public JSONObject resetPipelineOffset(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String pipelineId)
    {
        Request ResetPipelineOffsetRequest = new Request();

        JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey)).method("POST")
                .url(url + "/streaming/v2.0/streaming/pipeline/" + pipelineId + "/offset")
                .queryParam("orgId", orgId)
                .getResponse(ResetPipelineOffsetRequest, JSONObject.class);

        System.out.println(response);
        return response;
    }
}
