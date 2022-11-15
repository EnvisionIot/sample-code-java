/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.alert.record.old.history;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Scroll;
import com.envisioniot.enos.event_service.v2_1.AggregateActiveAlertRequest;
import com.envisioniot.enos.event_service.v2_1.AggregateActiveAlertResponse;
import com.envisioniot.enos.event_service.v2_1.ScrollHistoryAlertRequest;
import com.envisioniot.enos.event_service.v2_1.ScrollHistoryAlertResponse;
import com.envisioniot.enos.event_service.vo.HistoryAlert;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class ScrollHistoryAlert {
    public void scrollHistoryAlert(String accessKey, String secretKey, String orgId, String url, String expression) {
        ScrollHistoryAlertRequest request = new ScrollHistoryAlertRequest  ();
        request.setOrgId(orgId);
        request.setStartOccurTime("2022-01-10T00:00:00Z");
        request.setEndOccurTime("2022-02-15T00:00:00Z");
        request.setExpression(expression);
        Scroll scroll = new Scroll();
        scroll.setPageSize(5);
        request.setScroll(scroll);
        //
//        request.setGroupByField("");

        try {
            ScrollHistoryAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, ScrollHistoryAlertResponse.class);
            for (HistoryAlert datum : response.getData().getItems()) {
                System.out.println(datum.getEventId() + " " + datum.getLocalOccurTime());
            }

            ScrollHistoryAlertRequest request1 = new ScrollHistoryAlertRequest();
            request1.setOrgId(orgId);

            scroll = new Scroll(5, response.getData().getPageToken(),null);
            request1.setStartOccurTime("2022-01-10T00:00:00Z");
            request1.setEndOccurTime("2022-02-15T00:00:00Z");
            request1.setScroll(scroll);
            try {
                ScrollHistoryAlertResponse response1 = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                        .url(url)
                        .getResponse(request1, ScrollHistoryAlertResponse.class);

                for (HistoryAlert datum : response1.getData().getItems()) {
                    System.out.println(datum.getEventId() + " " + datum.getLocalOccurTime());
                }
            }catch(Exception e){
                System.out.print(e);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void scrollActiveAlertWithTimeRange(String accessKey, String secretKey, String orgId, String url, String expression) {
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
