package com.envisioniot.example.sample.tsdbdata.v2_0;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

/**
 * @author zjh
 */
public class FilterLatestAssetData {
    public JSONObject filterLatestAssetData(String accessKey,
                                            String secretKey,
                                            String orgId,
                                            String url,
                                            String modelId,
                                            String assetIds,
                                            String pointId,
                                            String operator,
                                            String valueFilter) {
        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        )
                .method("POST")
                .header("Content-Type", "application/json");

        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setQueryParam("operator", operator);
        request.setQueryParam("modelId", modelId);
        request.setQueryParam("valueFilter", valueFilter);
        request.setQueryParam("assetIds", assetIds);
        request.setQueryParam("measurepoint", pointId);
        request.setMethod("GET");

        JSONObject response = poseidon
                .url(url + "/tsdb-service/v2.0/latest/filter")
                .getResponse(request, JSONObject.class);

        System.out.println(response);
        return response;
    }

}
