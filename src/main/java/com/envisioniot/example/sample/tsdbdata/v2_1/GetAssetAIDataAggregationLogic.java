package com.envisioniot.example.sample.edp.tsdbdata.v2_1;
import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;


public class GetAssetAIDataAggregationLogic {
    public JSONObject getAssetAIDataAggregationLogic(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetIds,
            String pointIdsWithLogic,
            Integer interval,
            String startTime,
            String endTime)
    {
    Poseidon poseidon = Poseidon.config(
            PConfig.init()
                    .appKey(accessKey)
                    .appSecret(secretKey)
    ).method("POST").header("Content-Type", "application/json");

    Request request = new Request();
          request.setBodyParams("assetIds", assetIds);
          request.setBodyParams("pointIdsWithLogic", pointIdsWithLogic);
          request.setBodyParams("startTime", "2022-02-17 00:00:00");
          request.setBodyParams("endTime", "2022-02-17 23:59:00");
          request.setBodyParams("interval", 10);
          request.setBodyParams("pageSize", 10);
          request.setBodyParams("localTimeAccuracy", false);
          request.setBodyParams("localTimeFormat", 0);
          request.setBodyParams("itemFormat", 0);

    JSONObject response = poseidon
            .url(url + "/tsdb-service/v2.1/ai-normalized")
            .queryParam("orgId", orgId)
            .getResponse(request, JSONObject.class);
          System.out.println(response);

          return null;
}
}
