/**
 * Copyright (C), 2015-2022, Envision
 * FileName: JoinUsers
 * Author:   xibin.song
 * Date:     3/8/2022 8:28 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.appportal.userandorg;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.UsersJoinRequest;
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

public class JoinUsers {
    public void joinUsers(String accessKey, String secretKey, String orgId, String url) {
        ArrayList<String> userIds = new ArrayList<>();
        userIds.add("tingting.jinS");
//        userIds.add("songxibin2013");
        UsersJoinRequest usersJoinRequest = new UsersJoinRequest(userIds, orgId);
        Response response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(usersJoinRequest, Response.class);
    }

}
