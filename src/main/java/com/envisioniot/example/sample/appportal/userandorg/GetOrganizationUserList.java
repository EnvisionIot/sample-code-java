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
import com.envision.app.portal.sdk.request.OrganizationUserListRequest;
import com.envision.app.portal.sdk.request.UserOrganizationListRequest;
import com.envision.app.portal.sdk.response.OrganizationUserListResponse;
import com.envision.app.portal.sdk.response.UserOrganizationListResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/8/2022
 * @since 1.0.0
 */

public class GetOrganizationUserList {
    public void getOrganizationUserList(String accessKey, String secretKey, String orgId, String url) {

        OrganizationUserListRequest request = new OrganizationUserListRequest(orgId);
        request.setEdgeEnvironment(false);
        OrganizationUserListResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(request, OrganizationUserListResponse.class);
    }
}
