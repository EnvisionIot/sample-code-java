/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.alert.record.old.tag;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.BatchUpdateActiveAlertTagsRequest;
import com.envisioniot.enos.event_service.v2_1.BatchUpdateActiveAlertTagsResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class BatchUpdateActiveAlertTags {
    public void batchUpdateActiveAlertTags(String accessKey, String secretKey, String orgId, String url, List< String > list) {
        BatchUpdateActiveAlertTagsRequest request = new BatchUpdateActiveAlertTagsRequest  ();
        request.setOrgId(orgId);

        request.setEventIds(list);
        Map<String,String> map = new HashMap<>();
        map.put("yourTagKey-1","yourTagValue-1");
        request.setTags(map);
        request.setIsPatchUpdate(false);
        try {
            BatchUpdateActiveAlertTagsResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, BatchUpdateActiveAlertTagsResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
