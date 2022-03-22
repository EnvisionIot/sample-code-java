package com.envisioniot.example.sample.edp.tsdbpolicy.v2_1;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class SaveStoragePolicyV2_1 {
    public JSONObject saveStoragePolicyV2_1(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String policyId,
            JSONArray models)
    {
        Request request = new Request()
                .setBodyParams("models", models)
                .setBodyParams("retention", "6M");

        JSONObject response =  Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey))
                .method("POST")
                .header("Content-Type", "application/json")
                .url(url + "/tsdb-policy/v2.1/policies/" + policyId)
                .queryParam("orgId", orgId)
                .getResponse(request, JSONObject.class);

        System.out.println(response);
        return response;
    }
}
