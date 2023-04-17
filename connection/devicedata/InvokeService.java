/**
 * Copyright (C), 2015-2022, Envision
 * FileName: InvokeService
 * Author:  Arihant jain
 * Date:    5/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.connection.devicedata;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.service.InvokeServiceRequest;
import com.envisioniot.enos.connect_service.v2_1.service.InvokeServiceResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/invoke_service.html  <br>
 * refer to the resources/ConnectionsServiceModels/DeviceData/model_demo_smartbattery_model_15.json
 * @author arihantjain97
 * @create 5/1/22
 * @since --
 */

public class InvokeService {

    public void invokeService_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        InvokeServiceRequest request = new InvokeServiceRequest();
        request.setOrgId(orgId);
        request.setAssetId(assetId);
        request.setServiceId("s1");
        Map<String, Object> serviceInputParamMap = new HashMap<>();
        serviceInputParamMap.put("i1", new Random().nextInt(500));
//        serviceInputParamMap.put("YourParameterHere2", 2);
        request.setInputData(serviceInputParamMap);
        request.setPendingTtl(3600L);   // e.g. pending TTL is 1 hour
        request.setTimeout(30);         // timeout is 30 seconds

        InvokeServiceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, InvokeServiceResponse.class);

    }

    public void invokeService_Keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        InvokeServiceRequest request = new InvokeServiceRequest();
        request.setOrgId(orgId);
        request.setProductKey(productKey);
        request.setDeviceKey(deviceKey);
        request.setServiceId("s1");
        Map<String, Object> serviceInputParamMap = new HashMap<>();
        serviceInputParamMap.put("i1",  new Random().nextInt(500));
//        serviceInputParamMap.put("YourParameterHere2", 2);
        request.setInputData(serviceInputParamMap);
        request.setPendingTtl(3600L);   // e.g. pending TTL is 1 hour
        request.setTimeout(30);         // timeout is 30 seconds

        InvokeServiceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, InvokeServiceResponse.class);

    }

}
