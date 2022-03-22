package com.envisioniot.example.sample.edp.tsdbpolicy.v2_1;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;

public class GetStoragePolicyV2_1 {
    public String getStoragePolicyV2_1(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String policyId
    )
    {
        String response =  Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .method("GET")
                .url(url + "/tsdb-policy/v2.1/policies/" + policyId)
                .queryParam("orgId", orgId)
                .sync();

        System.out.println(response);
        return response;
    }
}


