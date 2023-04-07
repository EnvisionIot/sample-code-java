package com.envisioniot.example.sample.tsdbpolicy.v2_1;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class UpdateUnformattedPolicy {
    public JSONObject UpdateUnformattedPolicy(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String retention)
    {
        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        ).method("GET") .header("Content-Type", "application/json");
        Request request = new Request();
        JSONObject resp = poseidon.url(url + "/tsdb-policy/v2.1/policies/unformatted/update")
                .queryParam("orgId", orgId)
                .queryParam("retention", retention)
                .getResponse(request, JSONObject.class);

        System.out.println(resp);
        return resp;
    }
}
