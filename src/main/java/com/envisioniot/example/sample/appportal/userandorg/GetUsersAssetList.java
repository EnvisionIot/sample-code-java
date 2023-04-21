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
import com.envision.app.portal.sdk.request.UserDomainRequest;
import com.envision.app.portal.sdk.request.UsersAssetListRequest;
import com.envision.app.portal.sdk.response.UserDomainResponse;
import com.envision.app.portal.sdk.response.UsersAssetListResponse;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/8/2022
 * @since 1.0.0
 */

public class GetUsersAssetList {
    public void getUsersAssetList(String accessKey, String secretKey, String orgId, String url) {
        ArrayList<String> userIds = new ArrayList<>();
//        userIds.add("u16466203656561425");
        userIds.add("u15839808375371");
        userIds.add("u15707653548961");
        userIds.add("u16238383442701531");
        UsersAssetListRequest usersAssetListRequest = new UsersAssetListRequest(userIds,orgId);
        UsersAssetListResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(usersAssetListRequest, UsersAssetListResponse.class);

    }
}