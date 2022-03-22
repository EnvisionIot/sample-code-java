package com.envisioniot.example.sample.iothub.connection.firmwareotaupgrademanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.ota.job.StopJobRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.job.StopJobResponse;

public class StopOTAjob {

    public StopJobResponse stopOTAjob(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String jobId)
    {
        StopJobRequest request = new StopJobRequest();
        request.setOrgId(orgId);
        request.setJobId(jobId);

        return Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, StopJobResponse.class);
    }

}
