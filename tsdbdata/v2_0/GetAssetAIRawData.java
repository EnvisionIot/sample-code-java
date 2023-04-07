package com.envisioniot.example.sample.tsdbdata.v2_0;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

/**
 * @author zjh
 */
public class GetAssetAIRawData {
    public JSONObject getAssetAIRawData(String accessKey,
                                        String secretKey,
                                        String orgId,
                                        String url,
                                        String modelId,
                                        String assetIds,
                                        String pointIds,
                                        String startTime,
                                        String endTime,
                                        Integer pageSize) {
        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        )
                .method("POST")
                .header("Content-Type", "application/json");

        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setQueryParam("modelId", modelId);
        request.setQueryParam("assetIds", assetIds);
        request.setQueryParam("measurepoints", pointIds);
        request.setQueryParam("startTime", startTime);
        request.setQueryParam("endTime", endTime);
        request.setQueryParam("pageSize", pageSize);
        request.setQueryParam("localTimeAccuracy", false);
        request.setQueryParam("localTimeFormat", 0);
        request.setQueryParam("itemFormat", 0);
        request.setQueryParam("withQuality", true);
        request.setMethod("GET");

        JSONObject response = poseidon
                .url(url + "/tsdb-service/v2.0/ai")
                .getResponse(request, JSONObject.class);
        System.out.println(response);

        return response;
    }
}
