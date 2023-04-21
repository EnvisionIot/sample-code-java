package com.envisioniot.example.sample.streamprocessing.operatepipeline;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class SavePipeline {
    public JSONObject savePipeline(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String pipelineId,
            String version,
            String name,
            int templateType,
            String templateName,
            int messageChannel,
            String pipelineJson)
    {

        Request SavePipelineRequest = new Request()
        .setBodyParams("version", version)
        .setBodyParams("name", name)
        .setBodyParams("templateType", templateType)
        .setBodyParams("templateName", templateName)
        .setBodyParams("messageChannel", messageChannel)
        .setBodyParams("pipelineJson", pipelineJson);

        JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey)).method("POST")
                .url(url + "/streaming/v2.0/streaming/pipeline/" + pipelineId)
                .queryParam("orgId", orgId)
                .queryParam("action", "save")
                .getResponse(SavePipelineRequest, JSONObject.class);

        System.out.println(response);
        return response;
    }
}
