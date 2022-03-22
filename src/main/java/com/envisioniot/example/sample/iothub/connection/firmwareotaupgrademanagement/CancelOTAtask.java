package com.envisioniot.example.sample.iothub.connection.firmwareotaupgrademanagement;


import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.ota.job.task.CancelTaskRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.job.task.CancelTaskResponse;

import java.util.HashSet;

public class CancelOTAtask {

    public CancelTaskResponse cancelOTAtask(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            HashSet<String> deviceKeysHashSet,
            String jobId){
        CancelTaskRequest request = new CancelTaskRequest();
        request.setOrgId(orgId);

        request.setJobId(jobId);
        request.setDeviceKeys(deviceKeysHashSet);

        return Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, CancelTaskResponse.class);
    }
}
