/**
 * Copyright (C), 2015-2021, Envision
 * FileName: GetDevice
 * Author:  Arihant jain
 * Date:    31/12/21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.connection.device;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.device.GetDeviceRequest;
import com.envisioniot.enos.connect_service.v2_1.device.GetDeviceResponse;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/get_device.html  <br>
 * refer to the resources/ConnectionsServiceModels/Device/model_demo_smartbattery_model.json
 *
 * @author arihantjain97
 * @create 31/12/21
 * @since --
 */

public class GetDevice {

    public GetDeviceResponse getDevice_assetID(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        GetDeviceRequest request = new GetDeviceRequest();
        request.setOrgId(orgId);
        request.setAssetId(assetId);
        return Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, GetDeviceResponse.class);

    }

    public GetDeviceResponse getDevice_Keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        GetDeviceRequest request = new GetDeviceRequest();
        request.setOrgId(orgId);
        request.setProductKey(productKey);
        request.setDeviceKey(deviceKey);
        return Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, GetDeviceResponse.class);

    }
}
