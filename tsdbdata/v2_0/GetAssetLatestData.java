package com.envisioniot.example.sample.tsdbdata.v2_0;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

/**
 * @author jinghui.zhao
 */
public class GetAssetLatestData {

    public JSONObject getAssetLatestData(String gatewayUrl,
                                         String accessKey,
                                         String secretKey,
                                         String orgId,
                                         String assetIds,
                                         String pointIds) {
        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        )
                .method("POST")
                .header("Content-Type", "application/json");

        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setQueryParam("assetIds", assetIds);
        request.setQueryParam("measurepoints", pointIds);
        request.setMethod("GET");

        JSONObject response = poseidon
                .url(gatewayUrl + "/tsdb-service/v2.0/latest")
                .getResponse(request, JSONObject.class);
        System.out.println(response);
        return response;
    }
}
