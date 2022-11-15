/**
 * Copyright (C), 2015-2022, Envision
 * FileName: LogIn
 * Author:   arihant.jain
 * Date:     23/3/2022
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.aep.iamservice;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

import java.util.HashMap;

/**
 * https://www.envisioniot.com/docs/iam-api/en/2.3.0/login.html  <br>
 *
 * @author arihant.jain
 * @create 23/3/2022
 * @since --
 */

public class LogIn {
    public JSONObject logIn(
            String accessKey,
            String secretKey,
            String url,
            Object authType,
            String linkName,
            String principal,
            String credentials,
            HashMap<String, Object> logInOptionalParams)
    {

        Request request = new Request();
        request.setBodyParams("principal", principal);
        request.setBodyParams("credentials", credentials);
        request.setBodyParams("authType", authType);
        if(linkName != null){ request.setBodyParams("linkName", linkName); }
        if(logInOptionalParams != null){ request.setBodyParams(logInOptionalParams); }

        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/enos-iam-service/v2.0/login")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
