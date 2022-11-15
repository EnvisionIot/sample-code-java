/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.alert.content;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.DeleteAlertContentRequest;
import com.envisioniot.enos.event_service.v2_1.DeleteAlertContentResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class DeleteAlertContent {

    public void deleteAlertContent(String accessKey, String secretKey, String orgId, String url) {
        DeleteAlertContentRequest request = new DeleteAlertContentRequest();
        request.setOrgId(orgId);
        request.setAlertContentId("yourContentId");

        // issue found, under testing and investigation.
        //request.setSource("box1");

        try {
            DeleteAlertContentResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, DeleteAlertContentResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
