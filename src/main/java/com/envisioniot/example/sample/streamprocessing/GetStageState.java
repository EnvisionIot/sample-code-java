/**
 * Copyright (C), 2015-2021, Envision
 * FileName: GetStageState
 * Author:  Arihant jain
 * Date:    7/2/2022
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.streamprocessing;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class GetStageState {
    private static final String API_Gateway_URL = "https://apim-ppe1.envisioniot.com";
    private Poseidon poseidon;

    public void getStageState(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String pipelineId,
            String stageInstanceName,
            String assetIds,
            String pointIds)
    {

        Request request = new Request()
                .setBodyParams("pipelineId", pipelineId)
                .setBodyParams("stageInstanceName", stageInstanceName)
                .setBodyParams("assetIds", assetIds)
                .setBodyParams("pointIds", pointIds);

        JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey)).method("POST")
                .url(url + "/streaming/v2.0/stage-state")
                .queryParam("orgId", orgId)
                .queryParam("action", "get")
                .getResponse(request, JSONObject.class);
        System.out.println(response);
    }
}
