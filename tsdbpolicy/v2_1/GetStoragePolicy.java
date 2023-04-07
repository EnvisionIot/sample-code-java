package com.envisioniot.example.sample.tsdbpolicy.v2_1;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;

public class GetStoragePolicy {
    public JSONObject getStoragePolicy(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String policyId
    )
    {
        String response =  Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey))
                .method("GET")
                .url(url + "/tsdb-policy/v2.1/policies/" + policyId)
                .queryParam("orgId", orgId)
                .sync();

        System.out.println(response);
        return JSONObject.parseObject(response);
    }
}


