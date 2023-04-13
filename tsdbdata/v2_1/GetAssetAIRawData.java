package com.envisioniot.example.sample.tsdbdata.v2_1;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

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
        request.setBodyParams("modelId", modelId);
        request.setBodyParams("assetIds", assetIds);
        request.setBodyParams("pointIds", pointIds);
        request.setBodyParams("startTime", startTime);
        request.setBodyParams("endTime", endTime);
        request.setBodyParams("pageSize", pageSize);
        request.setBodyParams("localTimeAccuracy", false);
        request.setBodyParams("localTimeFormat", 0);
        request.setBodyParams("itemFormat", 0);
        request.setBodyParams("withQuality", true);
        request.setBodyParams("boundaryType", "outside");

        JSONObject response = poseidon
                .url(url + "/tsdb-service/v2.1/ai")
                .queryParam("orgId", orgId)
                .getResponse(request, JSONObject.class);
        System.out.println(response);
        return response;
    }
}
