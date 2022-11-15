/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CompleteTask
 * Author:   arihant.jain
 * Date:     21/3/2022
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.bpm.task;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

import java.util.HashMap;

/**
 * https://www.envisioniot.com/docs/bpm-api/en/2.3.0/task/complete_task.html  <br>
 *
 * @author arihant.jain
 * @create 21/3/2022
 * @since --
 */

public class CompleteTask {
    public JSONObject completeTask(
            String accessKey,
            String secretKey,
            String url,
            String bearerToken,
            String taskId,
            HashMap<String, Object> completeTaskParams)
    {
        Request request = new Request();
        request.setHeaderParam("Authorization", "Bearer " + bearerToken);
        request.setQueryParam("taskId", taskId);
        request.setBodyParams(completeTaskParams);
        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/enos-bpm-service/v2.0/work/tasks/complete")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
