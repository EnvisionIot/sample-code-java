package com.envisioniot.example.sample.edp.tsdbdata.v2_1;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class FilterLatestAssetData {
    public JSONObject filterLatestAssetData(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String modelId,
            String assetIds,
            String pointId,
            String operator,
            String valueFilter)
    {
        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        ).method("POST").header("Content-Type", "application/json");

        Request request = new Request()
                .setBodyParams("modelId", modelId)
            .setBodyParams("assetIds", assetIds)
            .setBodyParams("pointId", pointId)
            .setBodyParams("operator", operator)
            .setBodyParams("valueFilter", valueFilter)
            .setBodyParams("ifWithLocalTime", true)
            .setBodyParams("localTimeAccuracy", false)
            .setBodyParams("localTimeFormat", 0)
            .setBodyParams("itemFormat", 1);

        JSONObject response =  poseidon
                .url(url + "/tsdb-service/v2.1/latest/filter")
                .queryParam("orgId", orgId)
                .getResponse(request, JSONObject.class);

        System.out.println(response);
        return response;
    }

}
