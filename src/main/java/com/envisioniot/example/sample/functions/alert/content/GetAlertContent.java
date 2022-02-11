/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.alert.content;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.CreateAlertContentRequest;
import com.envisioniot.enos.event_service.v2_1.CreateAlertContentResponse;
import com.envisioniot.enos.event_service.v2_1.GetAlertContentRequest;
import com.envisioniot.enos.event_service.v2_1.GetAlertContentResponse;
import com.envisioniot.enos.event_service.vo.GenerateContent;
import com.envisioniot.enos.event_service.vo.StringI18n;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class GetAlertContent {
    public void getAlertContent(String accessKey, String secretKey, String orgId, String url) {
        GetAlertContentRequest request = new GetAlertContentRequest();
        request.setOrgId(orgId);
        request.setContentId("yourContentId");
        try {
            GetAlertContentResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, GetAlertContentResponse.class);
            if (response.getCode() == 0) {
                System.out.println(response.getData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
