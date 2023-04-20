package com.envisioniot.example.sample.streamprocessing;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class GetPipelineDetails {

    public JSONObject getPipelineDetails(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String pipelineId,
            boolean ifReleased)
    {
        Request GetPipelineDetailsRequest = new Request();

        JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey)).method("GET")
                .url(url + "/streaming/v2.0/streaming/pipeline/" + pipelineId)
                .queryParam("orgId", orgId)
                .queryParam("ifReleased", String.valueOf(ifReleased))
                .getResponse(GetPipelineDetailsRequest, JSONObject.class);

        System.out.println(response);
        return response;
    }

}
