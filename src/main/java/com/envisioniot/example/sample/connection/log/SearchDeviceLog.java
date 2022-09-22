package com.envisioniot.example.sample.connection.log;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.device.log.SearchDeviceLogRequest;
import com.envisioniot.enos.connect_service.v2_1.device.log.SearchDeviceLogResponse;

/**
 * @Author: song.xu
 * @Date: 2022/9/21
 */
public class SearchDeviceLog {
    public void searchDeviceLog(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String expr) {
        SearchDeviceLogRequest request = new SearchDeviceLogRequest();

        // Setting your device's organisational ID and timezone.
        request.setOrgId(orgId);
        request.setExpression(expr);

        SearchDeviceLogResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchDeviceLogResponse.class);
        System.out.println(response);
    }
}
