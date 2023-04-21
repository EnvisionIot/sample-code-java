/**
 * Copyright (C), 2015-2022, Envision
 * FileName: UpdateAlertTags
 * Author:   xibin.song
 * Date:     2/7/2022 3:27 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.alert.record;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.alert_service.v2_1.UpdateAlertTagsRequest;
import com.envisioniot.enos.alert_service.v2_1.UpdateAlertTagsResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 2/7/2022
 * @since 1.0.0
 */

public class UpdateAlertTags {
    public void updateAlertTags(String accessKey, String secretKey, String orgId, String url) {
        UpdateAlertTagsRequest request = new UpdateAlertTagsRequest();
        request.setOrgId(orgId);
        request.setAlertId("202202070346ed29d66d075e8eb87f0a4bbd6088");
        Map<String,String> map = new HashMap<>();
        map.put("tag2","ok");
        request.setTags(map);
        request.setIsPatchUpdate(true);
        try {
            UpdateAlertTagsResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, UpdateAlertTagsResponse.class);
            System.out.println(response);
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}
