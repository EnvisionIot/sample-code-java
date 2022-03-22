/**
 * Copyright (C), 2015-2022, Envision
 * FileName: DeleteFirmware
 * Author:  Arihant jain
 * Date:    10/2/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.connection.firmwaremanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.DeleteFirmwareFileRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.DeleteFirmwareFileResponse;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/delete_firmware.html  <br>
 * refer to the resources/ConnectionsServiceModels/FirmwareManagement/model_demo_smartbattery_model_15.json
 *
 * @author arihantjain97
 * @create 10/2/22
 * @since --
 */


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
