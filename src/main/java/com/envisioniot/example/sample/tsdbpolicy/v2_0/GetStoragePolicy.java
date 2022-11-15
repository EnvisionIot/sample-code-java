package com.envisioniot.example.sample.edp.tsdbpolicy.v2_0;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;

public class GetStoragePolicy {
    public String getStoragePolicy(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String policyId
        )
    {

        String response =  Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .method("GET")
                .url(url + "/tsdb-policy/v2.0/policies/" + policyId)
                .queryParam("orgId", orgId)
                .sync();

        System.out.println(response);
        return response;
    }
}
