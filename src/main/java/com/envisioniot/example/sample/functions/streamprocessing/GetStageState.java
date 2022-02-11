/**
 * Copyright (C), 2015-2021, Envision
 * FileName: GetStageState
 * Author:  Arihant jain
 * Date:    7/2/2022
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.streamprocessing;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;

public class GetStageState {

public JSONObject getStageState(
        String accessKey,
        String secretKey,
        String orgId,
        String url,
        String pipelineId,
        String stageInstanceName,
        String assetIds,
        String pointIds)


{
    StreamRequest GetStageStateRequest = new StreamRequest();
    GetStageStateRequest
            .setBodyParams("pipelineId", pipelineId);
    GetStageStateRequest
            .setBodyParams("stageInstanceName", stageInstanceName);
    GetStageStateRequest
            .setBodyParams("assetIds", assetIds);
    GetStageStateRequest
            .setBodyParams("pointIds", pointIds);

    Poseidon poseidon = Poseidon.config(
            PConfig.init()
                    .appKey(accessKey)
                    .appSecret(secretKey)
    ).method("POST");

    JSONObject response =  poseidon
            .url(url + "/streaming/v2.0/stage-state")
            .queryParam("orgId", orgId)
            .queryParam("action", "get")
            .getResponse(GetStageStateRequest, JSONObject.class);


/*    JSONObject response =  Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey)).method("POST")
                            .url(url + "/streaming/v2.0/stage-state")
                            .queryParam("orgId", orgId)
                            .queryParam("action", "get")
                            .getResponse(GetStageStateRequest, JSONObject.class);*/

    System.out.println(response);
    return response;
}
}
