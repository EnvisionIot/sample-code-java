package com.envisioniot.example.sample.functions.connection.firmwareotaupgrademanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.ota.job.GetJobRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.job.GetJobResponse;

public class GetOTAjob {

    public GetJobResponse getOTAjob(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String jobId)
    {
        GetJobRequest request = new GetJobRequest();
        request.setOrgId(orgId);
        request.setJobId(jobId);

        return Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, GetJobResponse.class);
    }
}
