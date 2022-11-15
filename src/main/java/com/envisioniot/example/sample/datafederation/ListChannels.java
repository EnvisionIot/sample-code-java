package com.envisioniot.example.sample.edp.datafederation;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

//https://www.envisioniot.com/docs/data-federation-api/en/2.3.0/list_channels.html

public class ListChannels {
    public JSONObject listChannels(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String channelType)
    {
        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        ).method("GET").header("Content-Type", "application/json");

        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setQueryParam("channelType", channelType);

        try {
            JSONObject response = poseidon
                    .url(url + "/data-federation/v2.0/channels")
                    .getResponse(request, JSONObject.class);
            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
