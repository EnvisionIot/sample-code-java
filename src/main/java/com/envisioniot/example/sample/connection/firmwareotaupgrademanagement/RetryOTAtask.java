package com.envisioniot.example.sample.connection.firmwareotaupgrademanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.ota.job.task.RetryTaskRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.job.task.RetryTaskResponse;


import java.util.HashSet;

public class RetryOTAtask {

    public void retryOTAtask(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            HashSet<String> deviceKeysHashSet,
            String jobId)
    {
        RetryTaskRequest request = new RetryTaskRequest();
        request.setOrgId(orgId);

        request.setJobId(jobId);
        request.setDeviceKeys(deviceKeysHashSet);

        RetryTaskResponse response = Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, RetryTaskResponse.class);
    }

}
