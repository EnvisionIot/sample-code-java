/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.alert.record.old.tag;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.UpdateActiveAlertTagsRequest;
import com.envisioniot.enos.event_service.v2_1.UpdateActiveAlertTagsResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class UpdateActiveAlertTags {
    public void updateActiveAlertTags(String accessKey, String secretKey, String orgId, String url, String eventId) {
        UpdateActiveAlertTagsRequest request = new UpdateActiveAlertTagsRequest ();
        request.setOrgId(orgId);
        request.setEventId(eventId);
        Map<String,String> map = new HashMap<>();
        map.put("yourTagKey-1","yourTagValue-1");
        request.setTags(map);
        request.setIsPatchUpdate(false);
        try {
            UpdateActiveAlertTagsResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, UpdateActiveAlertTagsResponse .class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
