/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetOrganizationList
 * Author:   xibin.song
 * Date:     3/8/2022 9:52 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.appportal.userandorg;

import com.alibaba.fastjson.JSON;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.UserOrganizationListRequest;
import com.envision.app.portal.sdk.response.UserOrganizationListResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/8/2022
 * @since 1.0.0
 */

public class GetOrganizationList {
    public void getOrganizationList(String accessKey, String secretKey, String orgId, String url, String accessToken) {

        UserOrganizationListRequest userOrganizationListRequest = new UserOrganizationListRequest(accessToken);
        UserOrganizationListResponse userOrganizationListResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(userOrganizationListRequest, UserOrganizationListResponse.class);

        System.out.println("List organization res: " + JSON.toJSONString(userOrganizationListResponse));
    }
}
