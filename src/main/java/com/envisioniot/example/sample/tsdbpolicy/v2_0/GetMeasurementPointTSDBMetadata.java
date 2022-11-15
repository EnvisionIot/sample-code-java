package com.envisioniot.example.sample.edp.tsdbpolicy.v2_0;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class GetMeasurementPointTSDBMetadata {
    public JSONObject getMeasurementPointTSDBMetadata(
                String accessKey,
                String secretKey,
                String orgId,
                String url,
                String modelIds,
                String pointIds)
        {
            Request request = new Request()
                    .setQueryParam("modelIds", modelIds)
                    .setQueryParam("measurepoints", pointIds)
                    .setQueryParam("orgId", orgId);

            JSONObject response =  Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .method("GET")
                    .url(url + "/tsdb-policy/v2.0/policies")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        }
}
