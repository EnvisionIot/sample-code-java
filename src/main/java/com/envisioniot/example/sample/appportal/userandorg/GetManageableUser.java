/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetManageableUser
 * Author:   xibin.song
 * Date:     3/8/2022 9:07 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.aep.appportal.userandorg;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.AdminUserListRequest;
import com.envision.app.portal.sdk.response.AdminUserListResponse;
import com.envisioniot.enos.api.common.constant.request.Pagination;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/8/2022
 * @since 1.0.0
 */

public class GetManageableUser {
    public void getManageableUserTest(String accessKey, String secretKey, String orgId, String url, String accessToken) {
        AdminUserListRequest adminUserListRequest = new AdminUserListRequest(accessToken);
        AdminUserListResponse adminUserListResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(adminUserListRequest, AdminUserListResponse.class);
    }
}
