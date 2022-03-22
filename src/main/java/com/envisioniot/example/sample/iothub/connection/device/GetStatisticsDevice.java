/**
 * Copyright (C), 2015-2021, Envision
 * FileName: GetStatistics
 * Author:  Arihant jain
 * Date:    3/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.iothub.connection.device;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.device.GetDeviceStatsRequest;
import com.envisioniot.enos.connect_service.v2_1.device.GetDeviceStatsResponse;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/get_device_stats.html  <br>
 * refer to the resources/ConnectionsServiceModels/Device/model_demo_smartbattery_model.json
 *
 * @author arihantjain97
 * @create 31/12/21
 * @since --
 */

public class GetStatisticsDevice {
    public void getStatisticsDevice(
            String accessKey,
            String secretKey,
            String orgId,
            String url) {

        GetDeviceStatsRequest request = new GetDeviceStatsRequest();
        request.setOrgId(orgId);
        GetDeviceStatsResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, GetDeviceStatsResponse.class);
    }

    public void getStatisticsDevice(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey) {

        GetDeviceStatsRequest request = new GetDeviceStatsRequest();
        request.setOrgId(orgId);
        request.setProductKey(productKey);
        GetDeviceStatsResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, GetDeviceStatsResponse.class);
    }

}
