/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.alert.record.old;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.CloseActiveAlertRequest;
import com.envisioniot.enos.event_service.v2_1.CloseActiveAlertResponse;
import com.envisioniot.enos.event_service.v2_1.CreateActiveAlertRequest;
import com.envisioniot.enos.event_service.v2_1.CreateActiveAlertResponse;
import com.envisioniot.enos.event_service.vo.GenerateActiveAlert;
import com.envisioniot.enos.event_service.vo.StringI18n;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

public class CloseActiveAlert {
    public void closeActiveAlert(String accessKey, String secretKey, String orgId, String url, String eventId) {
        CloseActiveAlertRequest request = new CloseActiveAlertRequest();
        request.setEventId(eventId);
        request.setLocalRecoverTime("2021-08-19 00:00:00");
        request.setRecoverTime(System.currentTimeMillis());
        request.setOrgId(orgId);
        request.setRecoverReason("yourRecoverReason");
        try {
            CloseActiveAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, CloseActiveAlertResponse.class);
            System.out.println(response);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
