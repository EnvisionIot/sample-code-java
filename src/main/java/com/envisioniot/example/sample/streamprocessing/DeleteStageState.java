package com.envisioniot.example.sample.streamprocessing;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;

public class DeleteStageState {
    /*public JSONObject deleteStageState(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String pipelineId,
            String stageInstanceName,
            String assetIds,
            String pointIds)


    {
        StreamRequest DeleteStageStateRequest = new StreamRequest()
                .setBodyParams("pipelineId", pipelineId)
                .setBodyParams("stageInstanceName", stageInstanceName)
                .setBodyParams("assetIds", assetIds)
                .setBodyParams("pointIds", pointIds);

        JSONObject response =  Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .method("POST")
                .url(url + "/streaming/v2.0/stage-state")
                .queryParam("orgId", orgId)
                .queryParam("action", "delete")
                .getResponse(DeleteStageStateRequest, JSONObject.class);

        System.out.println(response);
        return response;
    }*/
}
