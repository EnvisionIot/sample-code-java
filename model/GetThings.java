/**
 * Copyright (C), 2015-2021, Envision
 * FileName: getThings
 * Author:   xibin.song
 * Date:     12/6/2021 10:04 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.model;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.model_service.v2_1.GetThingModelRequest;
import com.envisioniot.enos.model_service.v2_1.GetThingModelResponse;

/**
 * https://support.envisioniot.com/docs/model-api/en/2.2.0/getmodel   <br>
 * refer to the resources/GetThings/model_EPB_Battery_Socket.json file
 * 〈〉
 *
 * @author xibin.song
 * @create 12/6/2021
 * @since 1.0.0
 */

public class GetThings {
    public void getThings(String accessKey, String secretKey, String orgId, String url) {
        GetThingModelRequest request = new GetThingModelRequest();
        request.setOrgId(orgId);
        request.setModelId("epb_battery_socket");
        request.setScope(1);
        GetThingModelResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
    }
}
