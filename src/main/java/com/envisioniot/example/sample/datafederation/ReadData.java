package com.envisioniot.example.sample.edp.datafederation;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

//https://www.envisioniot.com/docs/data-federation-api/en/2.3.0/read_data.html#

public class ReadData {
    public JSONObject readDataResponse(String accessKey, String secretKey, String url, Request request){
        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        ).method("POST").header("Content-Type", "application/json");
        try {
            JSONObject response = poseidon
                    .url(url)
                    .getResponse(request, JSONObject.class);
            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject readData(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String channelId,
            String sqlQuery)
    {
        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        ).method("POST").header("Content-Type", "application/json");

        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setBodyParams("sqlQuery", sqlQuery);
        request.setBodyParams("source", null);
        request.setBodyParams("queue", null);
        request.setBodyParams("itemFormat", null);
        return readDataResponse(accessKey, secretKey, url + "/data-federation/v2.0/channels/read/" + channelId, request);
    }

    public JSONObject readDataWithSource(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String channelId,
            String source,
            String sqlQuery)
    {
        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setBodyParams("sqlQuery", sqlQuery);
        request.setBodyParams("source", source);
        request.setBodyParams("queue", null);
        request.setBodyParams("itemFormat", null);
        return readDataResponse(accessKey, secretKey, url + "/data-federation/v2.0/channels/read/" + channelId, request);
    }

    public JSONObject readDataWithQueue(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String channelId,
            String queue,
            String sqlQuery)
    {
        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setBodyParams("sqlQuery", sqlQuery);
        request.setBodyParams("source", null);
        request.setBodyParams("queue", queue);
        request.setBodyParams("itemFormat", null);
        return readDataResponse(accessKey, secretKey, url + "/data-federation/v2.0/channels/read/" + channelId, request);
    }

    public JSONObject readDataWithItemFormat(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String channelId,
            String itemFormat,
            String sqlQuery)
    {
        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setBodyParams("sqlQuery", sqlQuery);
        request.setBodyParams("source", null);
        request.setBodyParams("queue", null);
        request.setBodyParams("itemFormat", itemFormat);
        return readDataResponse(accessKey, secretKey, url + "/data-federation/v2.0/channels/read/" + channelId, request);
    }

}
