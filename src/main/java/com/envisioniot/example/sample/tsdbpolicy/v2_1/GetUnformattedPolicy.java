package com.envisioniot.example.sample.tsdbpolicy.v2_1;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;

public class GetUnformattedPolicy {
    public String getUnformattedPolicy(
            String accessKey,
            String secretKey,
            String url,
            String orgId)
    {
/*        String response =  Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey))
                .method("GET")
                .url(url + "/tsdb-policy/v2.1/policies/unformatted")
                .queryParam("orgId", orgId)
                .sync();

        System.out.println(response);
        return response;*/

        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        ).method("GET");
        String resp = poseidon.url(url + "/tsdb-policy/v2.1/policies/unformatted")
                .queryParam("orgId", orgId)
                .sync();

        System.out.println(resp);
        return null;

    }
}
