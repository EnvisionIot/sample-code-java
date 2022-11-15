/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetOrganizationLanguage
 * Author:   xibin.song
 * Date:     3/8/2022 10:12 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.aep.appportal.userandorg;

import com.alibaba.fastjson.JSON;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.OrganizationLanguageRequest;
import com.envision.app.portal.sdk.response.OrganizationLanguageResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/8/2022
 * @since 1.0.0
 */

public class GetOrganizationLanguage {
    public void getOrganizationLanguage(String accessKey, String secretKey, String orgId, String url) {

        OrganizationLanguageRequest organizationLanguageRequest = new OrganizationLanguageRequest(orgId);
        OrganizationLanguageResponse organizationLanguageResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(organizationLanguageRequest, OrganizationLanguageResponse.class);

        System.out.println("Get organization languages res: " + JSON.toJSONString(organizationLanguageResponse));
    }
}
