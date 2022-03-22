/**
 * Copyright (C), 2015-2022, Envision
 * FileName: AuthorizeAsset
 * Author:   xibin.song
 * Date:     3/15/2022 8:42 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.aep.appportal.asset;


import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.AssetSynchronizationRequest;
import com.envision.app.portal.sdk.request.PrivilegedUserListToAssetRequest;
import com.envision.app.portal.sdk.response.PrivilegedUserListToAssetResponse;
import com.envision.app.portal.sdk.response.Response;

public class GetUserswithAssetAccess {
    public void getPrivilegedUsersToAsset(String accessKey, String secretKey, String orgId, String url) {
        PrivilegedUserListToAssetRequest request = new PrivilegedUserListToAssetRequest(orgId, "0x19kHPY");
        PrivilegedUserListToAssetResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(request, PrivilegedUserListToAssetResponse.class);
    }
}
