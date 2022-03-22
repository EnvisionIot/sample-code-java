/**
 * Copyright (C), 2015-2022, Envision
 * FileName: QueryProcessInstanceByView
 * Author:   arihant.jain
 * Date:     17/3/2022
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.aep.bpm.process;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

import java.util.Map;

/**
 * https://www.envisioniot.com/docs/bpm-api/en/2.3.0/process/query_process_instance_by_view.html  <br>
 *
 * @author arihant.jain
 * @create 17/3/2022
 * @since --
 */

public class QueryProcessInstanceByView {
    public JSONObject queryProcessInstanceByView(
            String accessKey,
            String secretKey,
            String url,
            String bearerToken,
            String displayViewKey,
            Map<String, Object> params)
    {
        Request request = new Request();
        request.setHeaderParam("authorization", "Bearer " + bearerToken);
        request.setBodyParams(params);
        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/enos-bpm-service/v2.0/work/display-view/" + displayViewKey + "/process-instances/query")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
