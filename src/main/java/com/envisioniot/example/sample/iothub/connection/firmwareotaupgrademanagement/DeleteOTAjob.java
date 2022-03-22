package com.envisioniot.example.sample.iothub.connection.firmwareotaupgrademanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.ota.job.DeleteJobRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.job.DeleteJobResponse;

public class DeleteOTAjob {

    public DeleteJobResponse deleteOTAjob(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String jobId)
    {
        DeleteJobRequest request = new DeleteJobRequest();
        request.setOrgId(orgId);
        request.setJobId(jobId);

        return Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, DeleteJobResponse.class);
    }

}
