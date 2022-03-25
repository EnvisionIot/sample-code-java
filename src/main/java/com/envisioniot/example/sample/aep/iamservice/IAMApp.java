/**
 * Copyright (C), 2015-2022, Envision
 * FileName: IAMApp
 * Author:   arihant.jain
 * Date:     23/3/2022
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.aep.iamservice;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * https://www.envisioniot.com/docs/iam-api/en/2.3.0/overview.html  <br>
 *
 * @author arihant.jain
 * @create 23/3/2022
 * @since --
 */

public class IAMApp {
    public void IAMAppGeneral(String accessKey, String secretKey, String orgId, String url) {

        //  Log In
        LogIn login = new LogIn();
        //  Log In: Declaring optional parameters
        HashMap<String, Object> logInOptionalParameters = new HashMap<>();
        logInOptionalParameters.put("clientIp", "10.81.2.169");
        logInOptionalParameters.put("expireInterval", 950);
        logInOptionalParameters.put("captcha", "yourCaptcha");
        //logInOptionalParameters.put("keyId", "yourKeyID");
        JSONObject data = login.logIn
                (accessKey, secretKey, url, 0, null, "yourPrincipal", "yourCredentials", logInOptionalParameters);
        String bearerToken = (String) data.get("sessionId");

        // Get Session Information
        GetSessionInformation getSessionInformation = new GetSessionInformation();
        getSessionInformation.getSessionInformation(accessKey, secretKey, url, bearerToken);
        //getSessionInformation.getSessionInformation(accessKey, secretKey, url, " ");

        // Get Organization
        GetOrganization getOrganization = new GetOrganization();
        getOrganization.getOrganization(accessKey, secretKey, url, orgId, bearerToken);

        // List User Organization
        ListUserOrganization listuserorganization = new ListUserOrganization();
        listuserorganization.listUserOrganization(accessKey, secretKey, url, bearerToken);

    }
}
