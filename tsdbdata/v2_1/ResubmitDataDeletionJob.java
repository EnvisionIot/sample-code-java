package com.envisioniot.example.sample.tsdbdata.v2_1;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

/**
 * @author jinghui.zhao
 */
public class ResubmitDataDeletionJob {

    public JSONObject resubmitDataDeletionJob(String gatewayUrl,
                                              String accessKey,
                                              String secretKey,
                                              String orgId,
                                              String jobId) {
        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        )
                .method("PUT")
                .header("Content-Type", "application/json");

        Request request = new Request();
        JSONObject response = poseidon
                .url(gatewayUrl + "/tsdb-service/v2.1/data/resubmit")
                .queryParam("orgId", orgId)
                .queryParam("JobId", jobId)
                .getResponse(request, JSONObject.class);
        System.out.println(response);
        return response;
    }
}
