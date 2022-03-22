/**
 * Copyright (C), 2015-2022, Envision
 * FileName: AddSubDevice
 * Author:  Arihant jain
 * Date:    4/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.connection.gatewayandsubdevice;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.device.topo.AddSubDeviceRequest;
import com.envisioniot.enos.connect_service.v2_1.device.topo.AddSubDeviceResponse;
import com.envisioniot.enos.connect_service.vo.DeviceIdentifier;

import java.util.ArrayList;
import java.util.List;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/add_sub_device.html  <br>
 * refer to the resources/ConnectionsServiceModels/Topo/model_demo_smartbattery_model_15.json
 *
 * @author arihantjain97
 * @create 4/1/22
 * @since --
 */

public class AddSubDevice {

    public void addSubDevice_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String gatewayAssetId,
            ArrayList<String> subDeviceAssetIdList)
    {
        // create request & set the organisation.
        AddSubDeviceRequest request = new AddSubDeviceRequest();
        request.setOrgId(orgId);

        // set the gateway device these sub-device(s) will correspond to.
        // note: Alternatively the gateway device's product key and device key can be used instead.
        request.setGateway(new DeviceIdentifier(gatewayAssetId));

        // arraylist of sub-devices.
        // note: Ensure sub-devices are of type 'Device' and not 'Gateway'.
        List < DeviceIdentifier > deviceList = new ArrayList < > ();
        for(int i = 0; i < subDeviceAssetIdList.size(); i++){
            deviceList.add(new DeviceIdentifier(subDeviceAssetIdList.get(i)));
        }

        request.setSubDevices(deviceList);
        AddSubDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, AddSubDeviceResponse.class);
    }

    public void addSubDevice_keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String gatewayProductKey,
            String gatewayDeviceKey,
            ArrayList<String> subDeviceAssetIdList)
    {
        // create request & set the organisation.
        AddSubDeviceRequest request = new AddSubDeviceRequest();
        request.setOrgId(orgId);

        // set the gateway device these sub-device(s) will correspond to.
        // note: Alternatively the gateway device's product key and device key can be used instead.
         request.setGateway(new DeviceIdentifier(gatewayProductKey,gatewayDeviceKey));

        // arraylist of sub-devices.
        // note: Ensure sub-devices are of type 'Device' and not 'Gateway'.
        List < DeviceIdentifier > deviceList = new ArrayList < > ();
        for(int i = 0; i < subDeviceAssetIdList.size(); i++){
            deviceList.add(new DeviceIdentifier(subDeviceAssetIdList.get(i)));
        }

        request.setSubDevices(deviceList);
        AddSubDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, AddSubDeviceResponse.class);
    }

}
