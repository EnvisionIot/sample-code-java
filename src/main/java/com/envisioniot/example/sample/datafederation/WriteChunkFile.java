package com.envisioniot.example.sample.datafederation;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;
import com.google.common.net.HttpHeaders;

public class WriteChunkFile {
    public JSONObject writeChunkFile(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String channelId,
            String dataSourceName,
            String fileName,
            Integer totalSize,
            Integer chunkOffset,
            Integer chunkSize,
            String chunkData)
    {
        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        ).method("POST").header(HttpHeaders.CONTENT_TYPE, "application/json");

        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setQueryParam("dataSourceName", dataSourceName);

        request.setBodyParams("fileName", fileName);
        request.setBodyParams("totalSize", totalSize);
        request.setBodyParams("chunkOffset", chunkOffset);
        request.setBodyParams("chunkSize", chunkSize);
        request.setBodyParams("chunkData", chunkData);


        try {
            JSONObject response = poseidon
                    .url(url + "/data-federation/v2.0/channels/write/" + channelId + "/chunk-file")
                    .getResponse(request, JSONObject.class);
            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
