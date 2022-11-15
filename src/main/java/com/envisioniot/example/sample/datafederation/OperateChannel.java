package com.envisioniot.example.sample.datafederation;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

import java.util.Map;

//https://www.envisioniot.com/docs/data-federation-api/en/2.3.0/operate_channel.html

public class OperateChannel {
    public JSONObject operateChannel(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String channelId,
            Map<String, Object> resource,
            String action)
    {
        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        ).method("POST");

        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setQueryParam("action", action);

        if(resource != null){
            request.setBodyParams("resource", resource);
        }

        try {
            JSONObject response = poseidon
                    .url(url + "/data-federation/v2.0/channels/" + channelId)
                    .getResponse(request, JSONObject.class);
            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
