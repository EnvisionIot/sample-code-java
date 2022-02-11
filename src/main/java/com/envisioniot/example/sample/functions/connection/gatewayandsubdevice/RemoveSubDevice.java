/**
 * Copyright (C), 2015-2022, Envision
 * FileName: RemoveSubDevice
 * Author:  Arihant jain
 * Date:    4/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.connection.gatewayandsubdevice;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.device.topo.RemoveSubDeviceRequest;
import com.envisioniot.enos.connect_service.v2_1.device.topo.RemoveSubDeviceResponse;
import com.envisioniot.enos.connect_service.vo.DeviceIdentifier;

import java.util.ArrayList;
import java.util.List;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/remove_sub_device.html  <br>
 * refer to the resources/ConnectionsServiceModels/Topo/model_demo_smartbattery_model_15.json
 *
 * @author arihantjain97
 * @create 4/1/22
 * @since --
 */

public class RemoveSubDevice {

    public void RemoveSubDevice_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String gatewayAssetId,
            ArrayList<String> subDeviceAssetIdList)
    {
        // create request & set the organisation.
        RemoveSubDeviceRequest request = new RemoveSubDeviceRequest();
        request.setOrgId(orgId);

        // set the gateway device from which sub-devices would be removed.
        // note: Alternatively you can use the gateway's product and device key instead.
        request.setGateway(new DeviceIdentifier(gatewayAssetId));

        // set the sub-devices which would be removed.
        List < DeviceIdentifier > deviceList = new ArrayList < > ();
        for(int i = 0; i < subDeviceAssetIdList.size(); i++){
            deviceList.add(new DeviceIdentifier(subDeviceAssetIdList.get(i)));
        }
        request.setSubDevices(deviceList);
        RemoveSubDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, RemoveSubDeviceResponse.class);
    }

    public void RemoveSubDevice_keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String gatewayProductKey,
            String gatewayDeviceKey,
            ArrayList<String> subDeviceAssetIdList)
    {
        // create request & set the organisation.
        RemoveSubDeviceRequest request = new RemoveSubDeviceRequest();
        request.setOrgId(orgId);

        // set the gateway device from which sub-devices would be removed.
        // note: Alternatively you can use the gateway device's assetId.
        request.setGateway(new DeviceIdentifier(gatewayProductKey, gatewayDeviceKey));

        // arraylist of sub-devices.
        // note: Ensure sub-devices are of type 'Device' and not 'Gateway'.
        List < DeviceIdentifier > deviceList = new ArrayList < > ();
        for(int i = 0; i < subDeviceAssetIdList.size(); i++){
            deviceList.add(new DeviceIdentifier(subDeviceAssetIdList.get(i)));
        }
        request.setSubDevices(deviceList);
        RemoveSubDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, RemoveSubDeviceResponse.class);
    }


}
