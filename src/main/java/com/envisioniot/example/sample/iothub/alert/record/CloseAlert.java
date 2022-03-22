/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.alert.record;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.alert_service.v2_1.CloseAlertRequest;
import com.envisioniot.enos.alert_service.v2_1.CloseAlertResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class CloseAlert {
    public void closeAlert(String accessKey, String secretKey, String orgId, String url, String eventId) {
        CloseAlertRequest request = new CloseAlertRequest();
        request.setAlertId(eventId);
        request.setLocalRecoverTime("2022-08-19 00:00:00");
        request.setRecoverTime(System.currentTimeMillis());
        request.setOrgId(orgId);
        request.setRecoverReason("yourRecoverReason");
        try {
            CloseAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, CloseAlertResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
