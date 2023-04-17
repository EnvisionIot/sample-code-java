/**
 * Copyright (C), 2015-2021, Envision
 * FileName: ReplaceDevice
 * Author:  Arihant jain
 * Date:    30/12/21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.connection.device;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.device.ReplaceDeviceRequest;
import com.envisioniot.enos.connect_service.v2_1.device.ReplaceDeviceResponse;
import com.envisioniot.enos.connect_service.vo.DeviceReplaceResult;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/replace_device.html  <br>
 * refer to the resources/ConnectionsServiceModels/Device/model_demo_smartbattery_model.json
 *
 * @author arihantjain97
 * @create 30/12/21
 * @since --
 */

public class ReplaceDevice {
    private static int keyVal;

    public ReplaceDevice(){
        keyVal = 0;
    }
    private DeviceReplaceResult replaceResponse(
            String accessKey,
            String secretKey,
            String url,
            ReplaceDeviceRequest request)
    {

        ReplaceDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, ReplaceDeviceResponse.class);
        System.out.println("AssetId: " + response.getData().getAssetId() + ", has a new deviceKey: " +
                response.getData().getDeviceKey() + ", and new device secret: " +
                response.getData().getDeviceSecret());
        return response.getData();
    }

    public DeviceReplaceResult replaceDevice_assetID(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        //Setting a new key for your existing device
        String newDeviceKey = "yourNewDeviceKey_assetID_" + String.valueOf(keyVal++);

        ReplaceDeviceRequest request = new ReplaceDeviceRequest();
        request.setOrgId(orgId);
        request.setAssetId(assetId);
        request.setNewDeviceKey(newDeviceKey);

        //Note that a new device secret will be generated
        return replaceResponse(accessKey, secretKey, url, request);
    }


    public DeviceReplaceResult replaceDevice_Keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        //Setting a new key for your existing device
        String newDeviceKey = "yourNewDeviceKey_Keys_" + String.valueOf(keyVal++);

        ReplaceDeviceRequest request = new ReplaceDeviceRequest();
        request.setOrgId(orgId);
        request.setProductKey(productKey);
        request.setDeviceKey(deviceKey);
        request.setNewDeviceKey(newDeviceKey);

        //Note that a new device secret will be generated
        return replaceResponse(accessKey, secretKey, url, request);
    }

}
