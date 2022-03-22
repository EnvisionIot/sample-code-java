/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetGateway
 * Author:  Arihant jain
 * Date:    4/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.connection.gatewayandsubdevice;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.device.topo.GetGatewayRequest;
import com.envisioniot.enos.connect_service.v2_1.device.topo.GetGatewayResponse;
import com.envisioniot.enos.connect_service.vo.DeviceIdentifier;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/get_gateway.html  <br>
 * refer to the resources/ConnectionsServiceModels/Topo/model_demo_smartbattery_model_15.json
 *
 * @author arihantjain97
 * @create 4/1/22
 * @since --
 */

public class GetGateway {

    public GetGatewayResponse getGateway_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        // create request & set the organisation.
        GetGatewayRequest request = new GetGatewayRequest();
        request.setOrgId(orgId);

        // set the sub-device whose gateway information will be retrieved.
        // note: Alternatively you can use the sub-device's product and device key instead.
        request.setSubDevice(new DeviceIdentifier(assetId));

        return Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, GetGatewayResponse.class);
    }

    public GetGatewayResponse getGateway_keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        // create request & set the organisation.
        GetGatewayRequest request = new GetGatewayRequest();
        request.setOrgId(orgId);

        // set the sub-device whose gateway information will be retrieved.
        // note: Alternatively you can use the sub-device's assetId.
        request.setSubDevice(new DeviceIdentifier(productKey, deviceKey));

        return Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, GetGatewayResponse.class);
    }


}
