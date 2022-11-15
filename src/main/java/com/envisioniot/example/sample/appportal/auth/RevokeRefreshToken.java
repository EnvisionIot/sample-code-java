/**
 * Copyright (C), 2015-2022, Envision
 * FileName: RevokeRefreshToken
 * Author:   xibin.song
 * Date:     3/7/2022 11:02 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.appportal.auth;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.RefreshTokenRequest;
import com.envision.app.portal.sdk.request.RevokeRefreshTokenRequest;
import com.envision.app.portal.sdk.response.RefreshTokenResponse;
import com.envision.app.portal.sdk.response.RevokeRefreshTokenResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/7/2022
 * @since 1.0.0
 */

public class RevokeRefreshToken {

    public void revokeRefreshToken(String accessKey, String secretKey, String orgId, String url, String accessToken, String refreshToken) {
        RevokeRefreshTokenRequest revokeRefreshTokenRequest = new RevokeRefreshTokenRequest(accessToken, refreshToken);
        RevokeRefreshTokenResponse refreshTokenResponse = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(revokeRefreshTokenRequest, RevokeRefreshTokenResponse.class);
    }
}
