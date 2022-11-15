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
import com.envision.app.portal.sdk.request.UserGetBaseInfoRequest;
import com.envision.app.portal.sdk.request.UserInfoRequest;
import com.envision.app.portal.sdk.response.UserGetBaseInfoResponse;
import com.envision.app.portal.sdk.response.UserInfoResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/8/2022
 * @since 1.0.0
 */

public class GetUserBasicInfo {
    public void getUserBasicInfo(String accessKey, String secretKey, String orgId, String url) {
        UserGetBaseInfoRequest userGetBaseInfoRequest = new UserGetBaseInfoRequest(orgId, "songxibin2013@gmail.com", null, null, null, null);
        UserGetBaseInfoResponse userGetBaseInfoResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(userGetBaseInfoRequest, UserGetBaseInfoResponse.class);
    }
    public void getUserBasicInfoBaseOnDomain(String accessKey, String secretKey, String orgId, String url) {
        UserGetBaseInfoRequest userGetBaseInfoRequest = new UserGetBaseInfoRequest(orgId, null, null, "enosBFCustomer2", null, null);
        UserGetBaseInfoResponse userGetBaseInfoResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(userGetBaseInfoRequest, UserGetBaseInfoResponse.class);
    }
    public void getUserBasicInfoBaseOnPhoneArea(String accessKey, String secretKey, String orgId, String url) {
        UserGetBaseInfoRequest userGetBaseInfoRequest = new UserGetBaseInfoRequest(orgId, null, null, null, "86", null);
        UserGetBaseInfoResponse userGetBaseInfoResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(userGetBaseInfoRequest, UserGetBaseInfoResponse.class);
    }
    public void getUserBasicInfoBaseOnPhone(String accessKey, String secretKey, String orgId, String url) {
        UserGetBaseInfoRequest userGetBaseInfoRequest = new UserGetBaseInfoRequest(orgId, null, null, null, null, "1231234");
        UserGetBaseInfoResponse userGetBaseInfoResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(userGetBaseInfoRequest, UserGetBaseInfoResponse.class);
    }

    public void getUserBasicInfoBaseOnName(String accessKey, String secretKey, String orgId, String url) {
        UserGetBaseInfoRequest userGetBaseInfoRequest = new UserGetBaseInfoRequest(orgId, null, "songxibin", null, null, null);
        UserGetBaseInfoResponse userGetBaseInfoResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(userGetBaseInfoRequest, UserGetBaseInfoResponse.class);
    }
}
