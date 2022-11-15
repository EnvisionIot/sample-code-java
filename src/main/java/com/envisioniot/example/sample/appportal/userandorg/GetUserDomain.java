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
import com.envision.app.portal.sdk.request.UserInfoRequest;
import com.envision.app.portal.sdk.response.UserDomainResponse;
import com.envision.app.portal.sdk.response.UserInfoResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/8/2022
 * @since 1.0.0
 */

public class GetUserDomain {
    public void getUserDomain(String accessKey, String secretKey, String orgId, String url) {

        UserDomainRequest request=new UserDomainRequest("songxibin2013@gmail.com");
        UserDomainResponse response=Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(request,UserDomainResponse.class);
    }
}
