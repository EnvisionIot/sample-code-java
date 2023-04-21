/**
 * Copyright (C), 2015-2022, Envision
 * FileName: RefreshAccessToken
 * Author:   xibin.song
 * Date:     3/7/2022 10:46 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.appportal.auth;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.RefreshTokenRequest;
import com.envision.app.portal.sdk.response.RefreshTokenResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/7/2022
 * @since 1.0.0
 */

public class RefreshAccessToken {
    public String refreshAccessToken(String accessKey, String secretKey, String orgId, String url, String refreshToken) {
        RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest(refreshToken);
        RefreshTokenResponse refreshTokenResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(refreshTokenRequest, RefreshTokenResponse.class);

        String newAccessToken = refreshTokenResponse.data.accessToken;
        return newAccessToken;

    }
}
