package com.envisioniot.example.sample.edp.tsdbpolicy.v2_1;

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
            String policyId)
    {
/*        StreamRequest request = new StreamRequest();


        //Adding policy
        JSONObject response =  Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey))
                .method("POST")
                .header("Content-Type", "application/json")
                //.url(url + "/tsdb-policy/v2.1/policies/unformatted")
                .url(url + "/tsdb-policy/v2.1/policies/unformatted/" + policyId)
                .queryParam("retention", "1M")
                //.queryParam("orgId", orgId)
                .getResponse(request, JSONObject.class);

        System.out.println(response);
        return response;*/


        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        ).method("POST") .header("Content-Type", "application/json");
        Request request = new Request();
        //request.setQueryParam("policyId", "a8555efe-a608-4dcd-945e-57aeffc10bf3");
        //request.setBodyParams("policyId", "a8555efe-a608-4dcd-945e-57aeffc10bf3");

        JSONObject resp = poseidon.url(url + "/tsdb-policy/v2.1/policies/unformatted")
                .queryParam("orgId", orgId)
                .queryParam("retention", "3M")
                .getResponse(request, JSONObject.class);

        System.out.println(resp);
        return null;
    }
}
