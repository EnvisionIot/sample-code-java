package com.envisioniot.example.sample.datafederation;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;
import com.google.common.net.HttpHeaders;

public class WriteMessage {
    public JSONObject writeMessage(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String channelId,
            String dataSourceName,
            String data,
            boolean sync)
    {
        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        ).method("POST").header(HttpHeaders.CONTENT_TYPE, "application/json");

        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setBodyParams("data", data);
        request.setBodyParams("dataSourceName", dataSourceName);
        request.setBodyParams("sync", sync);


        try {
            JSONObject response = poseidon
                    .url(url + "/data-federation/v2.0/channels/write/" + channelId + "/msg")
                    .getResponse(request, JSONObject.class);
            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
