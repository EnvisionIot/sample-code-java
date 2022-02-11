package com.envisioniot.example.sample.functions.connection.firmwaremanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.DeleteFirmwareFileRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.DeleteFirmwareFileResponse;


public class DeleteFirmware {
    public void deleteFirmware(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String firmwareId){

        DeleteFirmwareFileRequest request = new DeleteFirmwareFileRequest();
        request.setOrgId(orgId);
        request.setFirmwareId(firmwareId);

        DeleteFirmwareFileResponse response = Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, DeleteFirmwareFileResponse.class);
    }
}
