package com.envisioniot.example.sample.tsdbpolicy.v2_1;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;

public class GetUnformattedPolicy {
    public JSONObject getUnformattedPolicy(
            String accessKey,
            String secretKey,
            String url,
            String orgId)
    {
        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        ).method("GET");
        String resp = poseidon.url(url + "/tsdb-policy/v2.1/policies/unformatted/detail")
                .queryParam("orgId", orgId)
                .sync();

        System.out.println(resp);
        return JSONObject.parseObject(resp);

    }
}
