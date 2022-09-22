package com.envisioniot.example.sample.connection.log;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.device.log.SearchCloudLogRequest;
import com.envisioniot.enos.connect_service.v2_1.device.log.SearchCloudLogResponse;

/**
 * @Author: song.xu
 * @Date: 2022/9/21
 */
public class SearchCloudLog {
    public void searchCloudLog(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String expr) {
        SearchCloudLogRequest request = new SearchCloudLogRequest();

        // Setting your device's organisational ID and timezone.
        request.setOrgId(orgId);
        request.setExpression(expr);

        SearchCloudLogResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchCloudLogResponse.class);
        System.out.println(response);
    }
}
