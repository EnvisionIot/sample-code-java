/**
 * Copyright (C), 2015-2021, Envision
 * FileName: CreateDevice
 * Author:  Arihant jain
 * Date:    30/12/21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.connection.device;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.common.StringI18n;
import com.envisioniot.enos.connect_service.v2_1.device.CreateDeviceRequest;
import com.envisioniot.enos.connect_service.v2_1.device.CreateDeviceResponse;
import com.envisioniot.enos.connect_service.vo.DeviceCreateResult;


import java.util.HashMap;
import java.util.Map;

/**
 * https:// support.envisioniot.com/docs/connection-api/en/2.3.0/create_device.html  <br>
 * refer to the resources/ConnectionsServiceModels/Device/model_demo_smartbattery_model.json
 *
 * @author arihantjain97
 * @create 30/12/21
 * @since --
 */

public class CreateDevice {
    private DeviceCreateResult deviceResponse(
            String accessKey,
            String secretKey,
            String url,
            CreateDeviceRequest request)
    {
        CreateDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, CreateDeviceResponse.class);
        return response.getData();
    }

    public DeviceCreateResult createDevice(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey)
    {
        CreateDeviceRequest request = new CreateDeviceRequest();

        // Setting your device's organisational ID and timezone.
        request.setOrgId(orgId);
        request.setTimezone("+08:00");

        // Setting your device's description.
        request.setDeviceDesc("yourDeviceDesc");
        request.setProductKey(productKey);
        
        // Setting your device's names (can be non-unique)
        StringI18n deviceName = new StringI18n("yourDefaultDeviceName");
        request.setDeviceName(deviceName);
        
        return deviceResponse(accessKey, secretKey, url, request);

    }

    public DeviceCreateResult createDevice_optionalParameters(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey)
    {
        CreateDeviceRequest request = new CreateDeviceRequest();

        // Setting your device's organisational ID and timezone.
        request.setOrgId(orgId);
        request.setTimezone("+08:00");

        // Setting your device's description.
        request.setDeviceDesc("yourDeviceDesc_optionalParameters");
        request.setProductKey(productKey);

        // Setting your device's key (unique)
        // Note: This is optional. If undefined, enOS will automatically set a unique identifier for your device.
        // request.setDeviceKey("yourUniqueDeviceKey");

        // Setting your device's names (can be non-unique)
        StringI18n deviceName = new StringI18n("yourDefaultDeviceName_optionalParameters");
        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("zh_CN","设备名称");
        nameMap.put("en_US","english device name");
        nameMap.put("ja_JP", "装置名");
        nameMap.put("es_ES", "nombre del dispositivo");
        deviceName.setI18nValue(nameMap);
        request.setDeviceName(deviceName);

        // Setting your device's attributes
        // Note: Attribute IDs are defined in the model associated with the device.
        Map<String, Object> deviceAttributes = new HashMap<>();
        deviceAttributes.put("brand", "yourAttributeValue");
        request.setDeviceAttributes(deviceAttributes);

        // Setting your device's tags
        Map<String, String> deviceTags = new HashMap<>();
        deviceTags.put("tag1", "value1");
        deviceTags.put("tag2", "value2");
        request.setDeviceTags(deviceTags);

        return deviceResponse(accessKey, secretKey, url, request);
    }

    public DeviceCreateResult createDevice_optionalParameters(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            Map<String, String> deviceTags)
    {
        CreateDeviceRequest request = new CreateDeviceRequest();

        // Setting your device's organisational ID and timezone.
        request.setOrgId(orgId);
        request.setTimezone("+08:00");

        // Setting your device's description.
        request.setDeviceDesc("yourDeviceDesc_optionalParameters");
        request.setProductKey(productKey);

        // Setting your device's key (unique)
        // Note: This is optional. If undefined, enOS will automatically set a unique identifier for your device.
        // request.setDeviceKey("yourUniqueDeviceKey");

        // Setting your device's names (can be non-unique)
        StringI18n deviceName = new StringI18n("yourDefaultDeviceName_optionalParameters");
        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("zh_CN","设备名称");
        nameMap.put("en_US","english device name");
        nameMap.put("ja_JP", "装置名");
        nameMap.put("es_ES", "nombre del dispositivo");
        deviceName.setI18nValue(nameMap);
        request.setDeviceName(deviceName);

        // Setting your device's attributes
        // Note: Attribute IDs are defined in the model associated with the device.
        Map<String, Object> deviceAttributes = new HashMap<>();
        deviceAttributes.put("brand", "yourAttributeValue");
        request.setDeviceAttributes(deviceAttributes);

        // Setting your device's tags
        request.setDeviceTags(deviceTags);

        return deviceResponse(accessKey, secretKey, url, request);
    }

}
