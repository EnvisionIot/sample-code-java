package com.envisioniot.example.sample.edp.streamprocessing;

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
            String pipelineId)
    {

        Request SavePipelineRequest = new Request()
        .setBodyParams("version", "0.1.0")
        .setBodyParams("name", "pipelineTestSP")
        .setBodyParams("desc", "")
        .setBodyParams("templateType", 5)
        .setBodyParams("templateName", "Time Window Aggregation")
        .setBodyParams("messageChannel", "0")
        .setBodyParams("piDetail", false)
        .setBodyParams("points", JSONObject.parseArray("[\n" +
                "\t\t{\n" +
                "\t\t\t\"inputPointId\":\"test_raw\",\n" +
                "\t\t\t\"outputPointId\":\"test_5min\",\n" +
                "\t\t\t\"detailOutputPointId\":\"test_5min\",\n" +
                "\t\t\t\"minValue\":\"0\",\n" +
                "\t\t\t\"maxValue\":\"\",\n" +
                "\t\t\t\"maxValueInclude\":false,\n" +
                "\t\t\t\"minValueInclude\":false,\n" +
                "\t\t\t\"piDetailWindowSize\":\"5m\",\n" +
                "\t\t\t\"exceptionPolicy\":\"1\"\n" +
                "\t\t}\n" +
                "\t]"));

        JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey)).method("POST")
                .url(url + "/streaming/v2.0/streaming/pipeline/" + pipelineId)
                .queryParam("orgId", orgId)
                .queryParam("action", "save")
                .getResponse(SavePipelineRequest, JSONObject.class);

        System.out.println(response);
        return response;
    }
}
