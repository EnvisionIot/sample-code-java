/**
 * Copyright (C), 2015-2021, Envision
 * FileName: DeleteDevice
 * Author:  Arihant jain
 * Date:    30/12/21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.connection.device;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.device.DeleteDeviceRequest;
import com.envisioniot.enos.connect_service.v2_1.device.DeleteDeviceResponse;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/delete_device.html  <br>
 * refer to the resources/ConnectionsServiceModels/Device/model_demo_smartbattery_model.json
 *
 * @author arihantjain97
 * @create 30/12/21
 * @since --
 */

public class DeleteDevice {

    //Delete using first method: Include assetId in the request

    public void deleteDevice_assetID(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        DeleteDeviceRequest request = new DeleteDeviceRequest();
        request.setOrgId(orgId);
        request.setAssetId(assetId);
        DeleteDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request,DeleteDeviceResponse.class);
    }

    //Delete using second method: Include productKey + deviceKey in the request
    public void deleteDevice_Keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        DeleteDeviceRequest request = new DeleteDeviceRequest();
        request.setOrgId(orgId);
        request.setProductKey(productKey);
        request.setDeviceKey(deviceKey);
        DeleteDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request,DeleteDeviceResponse.class);
    }
}
