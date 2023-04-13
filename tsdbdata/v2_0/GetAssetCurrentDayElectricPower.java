package com.envisioniot.example.sample.tsdbdata.v2_0;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

/**
 * @author jinghui.zhao
 */
public class GetAssetCurrentDayElectricPower {

    public JSONObject getAssetCurrentDayElectricPower(String gatewayUrl,
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
        request.setFormParam("orgId", orgId);
        request.setFormParam("assetIds", assetIds);
        request.setFormParam("measurepoints", pointIds);

        request.setMethod("POST");

        JSONObject response = poseidon
                .url(gatewayUrl + "/tsdb-service/v2.0/electric-power/current-day")
                .getResponse(request, JSONObject.class);
        System.out.println(response);
        return response;
    }
}
