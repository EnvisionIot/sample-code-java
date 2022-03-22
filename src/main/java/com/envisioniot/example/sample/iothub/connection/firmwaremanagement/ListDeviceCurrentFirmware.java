/**
 * Copyright (C), 2015-2022, Envision
 * FileName: ListDeviceCurrentFirmware
 * Author:  Arihant jain
 * Date:    10/2/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.connection.firmwaremanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.ListDeviceCurrentFirmwaresRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.ListDeviceCurrentFirmwaresResponse;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/list_firmware_version.html  <br>
 * refer to the resources/ConnectionsServiceModels/FirmwareManagement/model_demo_smartbattery_model_15.json
 *
 * @author arihantjain97
 * @create 10/2/22
 * @since --
 */

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
