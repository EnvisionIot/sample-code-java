package com.envisioniot.example.sample.connection.firmwareotaupgrademanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.ota.job.StartJobRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.job.StartJobResponse;

public class StartOTAjob {

    public StartJobResponse startOTAjob(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String jobId)
    {
        StartJobRequest request = new StartJobRequest();
        request.setOrgId(orgId);
        request.setJobId(jobId);

        return Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, StartJobResponse.class);
    }

}
