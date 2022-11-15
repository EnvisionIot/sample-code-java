package com.envisioniot.example.sample.edp.datafederation;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class GetDownloadStatus {
    public JSONObject getDownloadStatus(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String channelId,
            String taskId)
    {
        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setMethod("GET");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey))
                    .url(url + "/data-federation/v2.0/channels/read/" + channelId + "/download/" + taskId + "/status")
                    .getResponse(request, JSONObject.class);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
