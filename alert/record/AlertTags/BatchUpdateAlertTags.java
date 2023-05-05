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
import com.envisioniot.enos.alert_service.v2_1.BatchUpdateAlertTagsRequest;
import com.envisioniot.enos.alert_service.v2_1.BatchUpdateAlertTagsResponse;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 2/7/2022
 * @since 1.0.0
 */

public class BatchUpdateAlertTags {
    public void batchUpdateAlertTags(String accessKey, String secretKey, String orgId, String url) {
        BatchUpdateAlertTagsRequest request = new BatchUpdateAlertTagsRequest();
        request.setOrgId(orgId);
        List<String> list=new LinkedList<>();
        list.add("your alertId");
        list.add("your alertId");
        request.setAlertIds(list);

        Map<String,String> map = new HashMap<>();
        map.put("Tag999","88");
        request.setTags(map);
        request.setIsPatchUpdate(false);
        try {
            BatchUpdateAlertTagsResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, BatchUpdateAlertTagsResponse.class);
            System.out.println(response);
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}
