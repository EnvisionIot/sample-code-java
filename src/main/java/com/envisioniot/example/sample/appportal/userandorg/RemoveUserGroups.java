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

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.UserGroupsAppendRequest;
import com.envision.app.portal.sdk.request.UserGroupsRemoveRequest;
import com.envision.app.portal.sdk.response.Response;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/8/2022
 * @since 1.0.0
 */

public class RemoveUserGroups {
    public void removeUserGroups(String accessKey, String secretKey, String orgId, String url) {
        ArrayList<String> userGroups = new ArrayList<>();
        userGroups.add("ug16110406799521691");
        userGroups.add("ug16124463904521679");
        UserGroupsRemoveRequest userGroupsRemoveRequest  = new UserGroupsRemoveRequest(orgId, "u16466203656561425",userGroups);
        Response response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(userGroupsRemoveRequest, Response.class);
    }
}
