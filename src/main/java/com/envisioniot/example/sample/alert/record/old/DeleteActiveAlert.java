/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.alert.record.old;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.DeleteActiveAlertRequest;
import com.envisioniot.enos.event_service.v2_1.DeleteActiveAlertResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class DeleteActiveAlert {
    public void deleteActiveAlert(String accessKey, String secretKey, String orgId, String url) {
        DeleteActiveAlertRequest request = new DeleteActiveAlertRequest();
        request.setOrgId(orgId);
        // Only in Active list
        request.setEventId("2022011816edb3328bddf687394830462b48ef0a");
        try {
            DeleteActiveAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, DeleteActiveAlertResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }

    }
}
