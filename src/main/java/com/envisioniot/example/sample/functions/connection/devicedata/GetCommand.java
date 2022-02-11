/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetCommand
 * Author:  Arihant jain
 * Date:    6/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.functions.connection.devicedata;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.service.GetCommandRequest;
import com.envisioniot.enos.connect_service.v2_1.service.GetCommandResponse;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/get_command.html  <br>
 * refer to the resources/ConnectionsServiceModels/DeviceData/model_demo_smartbattery_model_15.json
 * @author arihantjain97
 * @create 6/1/22
 * @since --
 */

public class GetCommand {
    public void getCommand_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId,
            String commandId)
    {
        // Create get command request.
        GetCommandRequest request = new GetCommandRequest();

        // Set the organisation.
        request.setOrgId(orgId);

        // Set the assetId of the device where the command to revoke is sent to via assetId.
        request.setAssetId(assetId);

        // Set the device where the command is sent to via its productKey and deviceKey
        // note: This is an alternative method to setting via assetId.
        //request.setProductKey(productKey);
        //request.setDeviceKey(deviceKey);

        // Setting the commandId corresponding to the command to be revoked.
        request.setCommandId(commandId);

        GetCommandResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, GetCommandResponse.class);
    }

    public void getCommand_Keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey,
            String commandId)
    {
        // Create get command request.
        GetCommandRequest request = new GetCommandRequest();

        // Set the organisation.
        request.setOrgId(orgId);

        // Set the device where the command is sent to via its productKey and deviceKey
        // note: This is an alternative method to setting via assetId.
        request.setProductKey(productKey);
        request.setDeviceKey(deviceKey);

        // Setting the commandId corresponding to the command to be revoked.
        request.setCommandId(commandId);

        GetCommandResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, GetCommandResponse.class);
    }

}
