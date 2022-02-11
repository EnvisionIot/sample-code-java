package com.envisioniot.example.sample.functions.connection.firmwaremanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.ListDeviceCurrentFirmwaresRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.ListDeviceCurrentFirmwaresResponse;

public class ListDeviceCurrentFirmware {

    public ListDeviceCurrentFirmwaresResponse listDeviceCurrentFirmware (
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey)
    {
        ListDeviceCurrentFirmwaresRequest request = new ListDeviceCurrentFirmwaresRequest();
        request.setOrgId(orgId);
        request.setProductKey(productKey);

        ListDeviceCurrentFirmwaresResponse response = Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, ListDeviceCurrentFirmwaresResponse.class);

        return response;
    }

}
