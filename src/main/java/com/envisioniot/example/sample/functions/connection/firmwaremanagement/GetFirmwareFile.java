package com.envisioniot.example.sample.functions.connection.firmwaremanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.GetFirmwareFileRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.GetFirmwareFileResponse;

public class GetFirmwareFile {

    public GetFirmwareFileResponse getFirmwareFile(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String firmwareId)
    {
        GetFirmwareFileRequest request = new GetFirmwareFileRequest();
        request.setOrgId(orgId);
        request.setFirmwareId(firmwareId);

        GetFirmwareFileResponse response = Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, GetFirmwareFileResponse.class);

        return response;
    }

}
