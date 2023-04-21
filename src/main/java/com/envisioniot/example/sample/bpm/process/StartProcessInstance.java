/**
 * Copyright (C), 2015-2022, Envision
 * FileName: StartProcessInstance
 * Author:   arihant.jain
 * Date:     18/3/2022
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.bpm.process;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

import java.util.Map;

/**
 * https://www.envisioniot.com/docs/bpm-api/en/2.3.0/process/start_process_instance.html  <br>
 *
 * @author arihant.jain
 * @create 18/3/2022
 * @since --
 */

public class StartProcessInstance {
    public JSONObject startProcessInstance(
            String accessKey,
            String secretKey,
            String url,
            String bearerToken,
            Map<String, Object> params)
    {
        Request request = new Request();
        request.setHeaderParam("authorization", "Bearer " + bearerToken);
        request.setBodyParams(params);
        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/enos-bpm-service/v2.0/work/process-instances")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
