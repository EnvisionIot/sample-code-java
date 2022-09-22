/**
 * Copyright (C), 2015-2021, Envision
 * FileName: EnableDevice
 * Author:  Arihant jain
 * Date:    30/12/21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.connection.device;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.device.*;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/enable_device.html  <br>
 * refer to the resources/ConnectionsServiceModels/Device/model_demo_smartbattery_model.json
 * @author arihantjain97
 * @create 30/12/21
 * @since --
 */

public class EnableDevice {

    public void enableDevice_assetID(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        EnableDeviceRequest request = new EnableDeviceRequest();
        request.setOrgId(orgId);
        request.setAssetId(assetId);
        EnableDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, EnableDeviceResponse.class);
    }

    public void enableDevice_Keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        EnableDeviceRequest request = new EnableDeviceRequest();
        request.setOrgId(orgId);
        request.setProductKey(productKey);
        request.setDeviceKey(deviceKey);
        EnableDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, EnableDeviceResponse.class);
    }


}
