package com.envisioniot.example.sample.tsdbdata.v2_1;

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
        request.setBodyParams("modelId", modelId);
        request.setBodyParams("assetIds", assetIds);
        request.setBodyParams("pointIdsWithLogic", pointIdsWithLogic);
        request.setBodyParams("startTime", startTime);
        request.setBodyParams("endTime", endTime);
        request.setBodyParams("interval", interval);
        request.setBodyParams("pageSize", pageSize);

        JSONObject response = poseidon
                .url(gatewayUrl + "/tsdb-service/v2.1/electric-power")
                .queryParam("orgId", orgId)
                .getResponse(request, JSONObject.class);
        System.out.println(response);
        return response;
    }
}
