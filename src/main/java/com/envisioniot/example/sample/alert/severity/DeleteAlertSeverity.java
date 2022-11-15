/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertSeverity
 * Author:   xibin.song
 * Date:     1/3/2022 10:42 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.alert.severity;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.DeleteAlertSeverityRequest;
import com.envisioniot.enos.event_service.v2_1.DeleteAlertSeverityResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/3/2022
 * @since 1.0.0
 */

public class DeleteAlertSeverity {
    public void deleteAlertSeverity(String accessKey, String secretKey, String orgId, String url) {
        DeleteAlertSeverityRequest request = new DeleteAlertSeverityRequest();
        request.setOrgId(orgId);
        request.setSeverityId("yourSeverityId");
        request.setOrgId(orgId);
        try {
            DeleteAlertSeverityResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, DeleteAlertSeverityResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
