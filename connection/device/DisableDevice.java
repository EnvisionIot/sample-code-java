/**
 * Copyright (C), 2015-2021, Envision
 * FileName: CreateDevice
 * Author:  Arihant jain
 * Date:    30/12/21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.connection.device;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.device.DisableDeviceRequest;
import com.envisioniot.enos.connect_service.v2_1.device.DisableDeviceResponse;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/disable_device.html  <br>
 * refer to the resources/ConnectionsServiceModels/Device/model_demo_smartbattery_model.json
 * @author arihantjain97
 * @create 30/12/21
 * @since --
 */

public class DisableDevice {
    public void disableDevice_assetID(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        DisableDeviceRequest request = new DisableDeviceRequest();
        request.setOrgId(orgId);
        request.setAssetId(assetId);
        DisableDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, DisableDeviceResponse.class);
    }

    public void disableDevice_Keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        DisableDeviceRequest request = new DisableDeviceRequest();
        request.setOrgId(orgId);
        request.setProductKey(productKey);
        request.setDeviceKey(deviceKey);
        DisableDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, DisableDeviceResponse.class);
    }
}
