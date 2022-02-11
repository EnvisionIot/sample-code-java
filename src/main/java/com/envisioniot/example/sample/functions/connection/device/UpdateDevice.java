/**
 * Copyright (C), 2015-2021, Envision
 * FileName: UpdateDevice
 * Author:  Arihant Jain
 * Date:    3/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.functions.connection.device;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.common.StringI18n;
import com.envisioniot.enos.connect_service.v2_1.device.UpdateDeviceRequest;
import com.envisioniot.enos.connect_service.v2_1.device.UpdateDeviceResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * https:// support.envisioniot.com/docs/connection-api/en/2.3.0/update_device.html  <br>
 * refer to the resources/ConnectionsServiceModels/Product/GetProduct/model_demo_smartbattery_model.json
 *
 * @author arihantjain97
 * @create 3/1/22
 * @since --
 */

public class UpdateDevice {

    public void updateDevice_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        UpdateDeviceRequest request = new UpdateDeviceRequest();
        request.setOrgId(orgId);
        request.setAssetId(assetId);

        // Update device's timezone
        request.setTimezone("+07:00");

        // Update device's deviceName
        StringI18n deviceName = new StringI18n("UpdatedDeviceName");
        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("zh_CN","更新的设备名称");
        nameMap.put("en_US","updated_en_device_name");
        nameMap.put("ja_JP", "更新されたデバイス名");
        nameMap.put("es_ES", "Nombre de dispositivo actualizado");
        deviceName.setI18nValue(nameMap);
        request.setDeviceName(deviceName);

        // Update device's deviceAttributes
        Map<String, Object> deviceAttributes = new HashMap<>();
        deviceAttributes.put("brand", "UpdatedAttributeValue");
        request.setDeviceAttributes(deviceAttributes);

        // Update device's deviceTags
        Map <String, String> deviceTags = new HashMap<>();
        deviceTags.put("UpdatedTag1", "UpdatedValue1");
        deviceTags.put("UpdatedTag2", "UpdatedValue2");

        request.setDeviceTags(deviceTags);
        // Update device's deviceDesc
        request.setDeviceDesc("UpdatedDeviceDesc");

        request.setIsPatchUpdate(true);
        UpdateDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, UpdateDeviceResponse.class);

    }

    // Alternative method
    public void updateDevice_Keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        UpdateDeviceRequest request = new UpdateDeviceRequest();
        request.setOrgId(orgId);
        request.setProductKey(productKey);
        request.setDeviceKey(deviceKey);

        // Update device's timezone
        request.setTimezone("+07:00");

        // Update device's deviceName
        StringI18n deviceName = new StringI18n("UpdatedDeviceName_1");
        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("zh_CN","更新的设备名称_1");
        nameMap.put("en_US","updated_en_device_name_1");
        nameMap.put("ja_JP", "更新されたデバイス名_1");
        nameMap.put("es_ES", "Nombre de dispositivo actualizado_1");
        deviceName.setI18nValue(nameMap);
        request.setDeviceName(deviceName);

        // Update device's deviceAttributes
        Map<String, Object> deviceAttributes = new HashMap<>();
        deviceAttributes.put("brand", "UpdatedAttributeValue");
        request.setDeviceAttributes(deviceAttributes);

        // Update device's deviceTags
        Map <String, String> deviceTags = new HashMap<>();
        deviceTags.put("UpdatedTag1", "UpdatedValue1");
        deviceTags.put("UpdatedTag2", "UpdatedValue2");
        request.setDeviceTags(deviceTags);

        // Update device's deviceDesc
        request.setDeviceDesc("UpdatedDeviceDesc");

        request.setIsPatchUpdate(true);
        UpdateDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, UpdateDeviceResponse.class);
    }

    public void updateDevice_assetId_NotPatchUpdate(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        UpdateDeviceRequest request = new UpdateDeviceRequest();
        request.setOrgId(orgId);
        request.setAssetId(assetId);

        // Only device's deviceName and timezone, rest deleted
        StringI18n deviceName = new StringI18n("UpdatedDeviceName_2");
        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("zh_CN","更新的设备名称_2");
        nameMap.put("en_US","updated_en_device_name_2");
        nameMap.put("ja_JP", "更新されたデバイス名_2");
        nameMap.put("es_ES", "Nombre de dispositivo actualizado_2");
        deviceName.setI18nValue(nameMap);
        request.setDeviceName(deviceName);
        request.setTimezone("+07:00");

        request.setIsPatchUpdate(false);
        UpdateDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, UpdateDeviceResponse.class);

    }

    // Alternative method
    public void updateDevice_Keys_NotPatchUpdate(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        UpdateDeviceRequest request = new UpdateDeviceRequest();
        request.setOrgId(orgId);
        request.setProductKey(productKey);
        request.setDeviceKey(deviceKey);

        // Only device's deviceName and timezone, rest deleted
        StringI18n deviceName = new StringI18n("UpdatedDeviceName_3");
        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("zh_CN","更新的设备名称_3");
        nameMap.put("en_US","updated_en_device_name_3");
        nameMap.put("ja_JP", "更新されたデバイス名_3");
        nameMap.put("es_ES", "Nombre de dispositivo actualizado_3");
        deviceName.setI18nValue(nameMap);
        request.setDeviceName(deviceName);
        request.setTimezone("+07:00");

        request.setIsPatchUpdate(false);
        UpdateDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, UpdateDeviceResponse.class);
    }

}
