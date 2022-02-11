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
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.event_service.v2_1.*;
import com.envisioniot.enos.event_service.vo.RootAlert;
import com.envisioniot.enos.event_service.vo.Scope;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class AggregateActiveAlert {
    public void aggregateActiveAlert(String accessKey, String secretKey, String orgId, String url, String expression) {
        AggregateActiveAlertRequest request = new AggregateActiveAlertRequest ();
        request.setOrgId(orgId);
        request.setExpression(expression);
        request.setGroupByField("assetId");
        //
//        request.setGroupByField("");

        try {
            AggregateActiveAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, AggregateActiveAlertResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void aggregateActiveAlertWithTimeRange(String accessKey, String secretKey, String orgId, String url, String expression) {
        AggregateActiveAlertRequest request = new AggregateActiveAlertRequest ();
        request.setOrgId(orgId);
        request.setExpression(expression);
        request.setGroupByField("assetId");

        request.setStartOccurTime("2021-01-18 15:31:09");
        request.setEndOccurTime("2022-02-18 15:31:09");

        try {
            AggregateActiveAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, AggregateActiveAlertResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

}
