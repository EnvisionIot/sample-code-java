package com.envisioniot.example.sample.streamprocessing;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class ListPipelines {

    public JSONObject listPipelines(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            int pageSize,
            int pageNo,
            boolean isSystem,
            boolean ifReleased)
    {
        Request ListPipelinesRequest = new Request();

        JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey)).method("GET")
                .url(url + "/streaming/v2.0/streaming/pipelines")
                .queryParam("orgId", orgId)
                .queryParam("pageSize", String.valueOf(pageSize))
                .queryParam("pageNo", String.valueOf(pageNo))
                .queryParam("isSystem", String.valueOf(isSystem))
                .queryParam("ifReleased", String.valueOf(ifReleased))
                .getResponse(ListPipelinesRequest, JSONObject.class);

        System.out.println(response);
        return response;
    }
}
