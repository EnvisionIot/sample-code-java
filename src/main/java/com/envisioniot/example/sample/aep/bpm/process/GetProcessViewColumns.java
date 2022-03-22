package com.envisioniot.example.sample.aep.bpm.process;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

public class GetProcessViewColumns {
    public JSONObject getProcessViewColumns(
            String accessKey,
            String secretKey,
            String url,
            String bearerToken,
            String displayViewKey) {

        Request request = new Request();
        request.setHeaderParam("Content-Type", "application/json");
        request.setHeaderParam("Authorization", "Bearer " + bearerToken);
        request.setQueryParam("displayViewKey", displayViewKey);
        request.setMethod("GET");

        try {


/*            Poseidon.config(PConfig.init().appKey("your_access_key")
                            .appSecret("your_secret_key").debug()).url("https://{apigw-address}")
                    .getResponse(request, ProcessInstanceGetResponse.class);*/

            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/enos-bpm-service/v2.0/work/display-view/" + displayViewKey + "/columns")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
