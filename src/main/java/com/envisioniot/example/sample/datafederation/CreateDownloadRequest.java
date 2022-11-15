package com.envisioniot.example.sample.datafederation;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

import java.util.Map;

public class CreateDownloadRequest {
    public JSONObject createDownloadRequest(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String channelId,
            String taskName,
            String sourceName,
            String querySql,
            String filePackageName)
    {
        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setBodyParams("taskName", taskName);
        request.setBodyParams("sourceName", sourceName);
        request.setBodyParams("querySql", querySql);
        request.setBodyParams("filePackageName", filePackageName);
        request.setMethod("POST");
        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey))
                    .url(url + "/data-federation/v2.0/channels/read/" + channelId + "/download-request")
                    .getResponse(request, JSONObject.class);
            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public JSONObject createDownloadRequestWithFileStruct(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String channelId,
            String taskName,
            String sourceName,
            String querySql,
            String filePackageName,
            Map<String, Object> files)
    {
        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setBodyParams("taskName", taskName);
        request.setBodyParams("sourceName", sourceName);
        request.setBodyParams("querySql", querySql);
        request.setBodyParams("filePackageName", filePackageName);
        if(files != null){request.setBodyParams("files", files);}
        request.setMethod("POST");
        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey))
                    .url(url + "/data-federation/v2.0/channels/read/" + channelId + "/download-request")
                    .getResponse(request, JSONObject.class);
            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject createDownloadRequestWithCallbackURL(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String channelId,
            String taskName,
            String sourceName,
            String querySql,
            String filePackageName,
            Map<String, Object> files,
            String callbackURL)
    {
        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setBodyParams("taskName", taskName);
        request.setBodyParams("sourceName", sourceName);
        request.setBodyParams("querySql", querySql);
        request.setBodyParams("filePackageName", filePackageName);
        if(files != null){request.setBodyParams("files", files);}
        request.setBodyParams("callbackURL", callbackURL);
        request.setMethod("POST");
        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey))
                    .url(url + "/data-federation/v2.0/channels/read/" + channelId + "/download-request")
                    .getResponse(request, JSONObject.class);
            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public JSONObject createDownloadRequestWithSelfDefineQueuePara(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String channelId,
            String taskName,
            String sourceName,
            String querySql,
            String filePackageName,
            Map<String, Object> files,
            String callbackURL,
            String selfDefineQueuePara)
    {
        Request request = new Request();
        request.setQueryParam("orgId", orgId);
        request.setBodyParams("taskName", taskName);
        request.setBodyParams("sourceName", sourceName);
        request.setBodyParams("querySql", querySql);
        request.setBodyParams("filePackageName", filePackageName);
        if(files != null){request.setBodyParams("files", files);}
        request.setBodyParams("callbackURL", callbackURL);
        request.setBodyParams("selfDefineQueuePara", selfDefineQueuePara);
        request.setMethod("POST");
        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey))
                    .url(url + "/data-federation/v2.0/channels/read/" + channelId + "/download-request")
                    .getResponse(request, JSONObject.class);
            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


}
