/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetTask
 * Author:   arihant.jain
 * Date:     21/3/2022
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.aep.bpm.task;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

/**
 * https://www.envisioniot.com/docs/bpm-api/en/2.3.0/task/get_task.html  <br>
 *
 * @author arihant.jain
 * @create 21/3/2022
 * @since --
 */

public class GetTask {
    public JSONObject getTask(
            String accessKey,
            String secretKey,
            String url,
            String bearerToken,
            String taskId)
    {
        Request request = new Request();
        request.setHeaderParam("authorization", "Bearer " + bearerToken);
        request.setQueryParam("taskId", taskId);
        request.setMethod("GET");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/enos-bpm-service/v2.0/work/tasks")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
