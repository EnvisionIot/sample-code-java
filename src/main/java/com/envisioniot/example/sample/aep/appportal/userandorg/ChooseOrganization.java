/**
 * Copyright (C), 2015-2022, Envision
 * FileName: ChooseOrganization
 * Author:   xibin.song
 * Date:     3/7/2022 10:53 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.aep.appportal.userandorg;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.ChooseOrganizationRequest;
import com.envision.app.portal.sdk.response.ChooseOrganizationResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/7/2022
 * @since 1.0.0
 */

public class ChooseOrganization {

    public String chooseOrganization(String accessKey, String secretKey, String orgId, String url, String accessToken) {
        String organizationId = orgId;
        ChooseOrganizationRequest chooseOrganizationRequest = new ChooseOrganizationRequest(organizationId, accessToken);
        ChooseOrganizationResponse chooseOrganizationResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(chooseOrganizationRequest, ChooseOrganizationResponse.class);
        String refreshToken = chooseOrganizationResponse.data.refreshToken;
        return refreshToken;
    }
}
