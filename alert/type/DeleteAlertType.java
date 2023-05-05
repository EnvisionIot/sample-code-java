/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.alert.type;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.DeleteAlertTypeRequest;
import com.envisioniot.enos.event_service.v2_1.DeleteAlertTypeResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class DeleteAlertType {
    public void deleteAlertType(String accessKey, String secretKey, String orgId, String url) {

        DeleteAlertTypeRequest request = new DeleteAlertTypeRequest();
        request.setOrgId(orgId);
        request.setAlertTypeId("yourAlertTypeId2");
        try {
            DeleteAlertTypeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, DeleteAlertTypeResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
