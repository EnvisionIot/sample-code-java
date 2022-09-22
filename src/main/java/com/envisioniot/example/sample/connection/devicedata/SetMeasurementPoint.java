/**
 * Copyright (C), 2015-2022, Envision
 * FileName: SetMeasurementPoint
 * Author:  Arihant jain
 * Date:    5/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.connection.devicedata;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.service.*;
import com.google.gson.GsonBuilder;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/set_measurepoint.html  <br>
 * refer to the resources/ConnectionsServiceModels/DeviceData/model_demo_smartbattery_model_15.json
 * @author arihantjain97
 * @create 5/1/22
 * @since --
 */

public class SetMeasurementPoint {

    public String SetMeasurementCommandResponse(
            String accessKey,
            String secretKey,
            String url,
            SetMeasruepointRequest request)
    {
        SetMeasruepointResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SetMeasruepointResponse.class);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response));
        return response.getData().commandId;
    }

    public String SetMeasurementPoint_Keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        // Create the command request.
        SetMeasruepointRequest request = new SetMeasruepointRequest();

        // Set organisation
        request.setOrgId(orgId);

        // Set the device (to which the command will be sent to) via its productKey and deviceKey.
        // note: Optional, this is an alternative to setting via assetId.
        request.setProductKey(productKey);
        request.setDeviceKey(deviceKey);

        // Set the measurepointId and its value.
        request.setMeasurepointId("temperature");
        request.setValue((double) 7);

        // Set the cache storage time, its range being [0 - 172800] seconds.
        // note: Optional (default is 0).
        request.setPendingTtl((long) 300);

        // Set the timeout period, its range being [1-60] seconds.
        // note: Optional (default is 30).
        request.setTimeout(10);

        return SetMeasurementCommandResponse(accessKey, secretKey, url, request);
    }

    public String SetMeasurementPoint_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        // Create the command request.
        SetMeasruepointRequest request = new SetMeasruepointRequest();


        // Set organisation
        request.setOrgId(orgId);

        // Set the device (to which the command will be sent to) via its assetId.
        request.setAssetId(assetId);

        // Set the measurepointId and its value.
        request.setMeasurepointId("temperature");
        request.setValue((double) 7);

        // Set the cache storage time, its range being [0 - 172800] seconds.
        // note: Optional (default is 0).
        request.setPendingTtl((long) 300);

        // Set the timeout period, its range being [1-60] seconds.
        // note: Optional (default is 30).
        request.setTimeout(10);

        return SetMeasurementCommandResponse(accessKey, secretKey, url, request);
    }


}
