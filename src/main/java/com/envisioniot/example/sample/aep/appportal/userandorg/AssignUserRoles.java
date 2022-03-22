/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetOrganizationList
 * Author:   xibin.song
 * Date:     3/8/2022 9:52 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.aep.appportal.userandorg;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.RolesAppendRequest;
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

public class AssignUserRoles {
    public void assignUserRoles(String accessKey, String secretKey, String orgId, String url) {
        ArrayList<String> roleIds = new ArrayList<>();
        roleIds.add("ro16059397494401");
        roleIds.add("ro16113096236511727");
        RolesAppendRequest rolesAppendRequest = new RolesAppendRequest(orgId, "u16466203656561425",roleIds);
        Response response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(rolesAppendRequest, Response.class);
    }
}
