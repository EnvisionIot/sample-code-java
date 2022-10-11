package com.envisioniot.example.sample.connection.device;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.common.StringI18n;
import com.envisioniot.enos.connect_service.v2_1.device.BatchCreateDeviceRequest;
import com.envisioniot.enos.connect_service.v2_1.device.CreateDeviceResponse;
import com.envisioniot.enos.connect_service.vo.DeviceCreateResult;
import com.envisioniot.enos.connect_service.vo.DeviceCreateVo;
import com.google.common.collect.Lists;

/**
 * @Author: song.xu
 * @Date: 2022/9/21
 */
public class BatchCreateDevice {
    public DeviceCreateResult createDevices(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        BatchCreateDeviceRequest request = new BatchCreateDeviceRequest();

        // Setting your device's organisational ID and timezone.
        request.setOrgId(orgId);

        DeviceCreateVo deviceCreateVo = new DeviceCreateVo();

        // Setting your device's description.
        deviceCreateVo.setDeviceDesc("yourDeviceDesc");
        deviceCreateVo.setProductKey("productKey"); // input productKey

        // Setting your device's names (can be non-unique)
        StringI18n deviceName = new StringI18n("yourDefaultDeviceName");
        deviceCreateVo.setDeviceName(deviceName);

        deviceCreateVo.setTimezone("+08:00");
        request.setDeviceList(Lists.newArrayList(deviceCreateVo));

        CreateDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, CreateDeviceResponse.class);
        System.out.println(response);
        return response.getData();
    }
}
