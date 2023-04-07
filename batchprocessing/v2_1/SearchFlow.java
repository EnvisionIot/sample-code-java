/**
 * Copyright (C), 2015-2022, Envision
 * FileName: SearchFlow
 * Author:   arihant.jain
 * Date:     15/3/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.batchprocessing.v2_1;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

/**
 https://www.envisioniot.com/docs/batch-processing-api/en/2.3.0/v2.1/search_flow.html  <br>
 * @author arihant.jain
 * @create 15/3/22
 * @since --
 */

public class SearchFlow {
    public JSONObject searchFlow(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String userId,
            String expression,
            JSONObject pagination)
    {
        Request request = new Request();
        request.setQueryParam("userId",userId);
        request.setQueryParam("orgId",orgId);
        request.setQueryParam("action", "search");

        if(expression != null){
            request.setBodyParams("expression", expression);
        }
        request.setBodyParams("pagination", pagination);

        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/batch-processing-service/v2.1/flows")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
