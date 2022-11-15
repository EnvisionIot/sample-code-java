/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetOrganization
 * Author:   arihant.jain
 * Date:     24/3/2022
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.aep.iamservice;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

/**
 * https://www.envisioniot.com/docs/iam-api/en/2.3.0/get_org.html  <br>
 *
 * @author arihant.jain
 * @create 24/3/2022
 * @since --
 */

public class GetOrganization {
    public JSONObject getOrganization(
            String accessKey,
            String secretKey,
            String url,
            String orgId,
            String bearerToken)
    {
        Request request = new Request();
        request.setHeaderParam("Authorization", "Bearer " + bearerToken);
        request.setHeaderParam("Content-Type", "application/json");
        request.setBodyParams("id", orgId);
        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/enos-iam-service/v2.0/organization/info")
                    .getResponse(request, JSONObject.class);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
