package com.envisioniot.example.sample.tsdbdata.v2_0;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

/**
 * @author jinghui.zhao
 */
public class GetAssetElectricPowerData {

    public JSONObject getAssetElectricPowerData(String gatewayUrl,
                                                String accessKey,
                                                String secretKey,
                                                String orgId,
                                                String modelId,
                                                String assetIds,
                                                String pointIdsWithLogic,
                                                String startTime,
                                                String endTime,
                                                int interval,
                                                int pageSize) {
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
        request.setQueryParam("measurepointsWithLogic", pointIdsWithLogic);
        request.setQueryParam("startTime", startTime);
        request.setQueryParam("endTime", endTime);
        request.setQueryParam("interval", interval);
        request.setQueryParam("pageSize", pageSize);
        request.setMethod("GET");

        JSONObject response = poseidon
                .url(gatewayUrl + "/tsdb-service/v2.0/electric-power")
                .getResponse(request, JSONObject.class);
        System.out.println(response);
        return response;
    }
}
