/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.alert.record;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.alert_service.v2_1.ScrollAlertRequest;
import com.envisioniot.enos.alert_service.v2_1.ScrollAlertResponse;
import com.envisioniot.enos.alert_service.vo.AlertVo;
import com.envisioniot.enos.api.common.constant.request.Scroll;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class ScollAlert {
    public void scollAlert(String accessKey, String secretKey, String orgId, String url, String expression) {
        ScrollAlertRequest request = new ScrollAlertRequest();
        request.setOrgId(orgId);
        request.setStartOccurTime("2022-01-01T00:00:00Z");
        request.setEndOccurTime("2022-02-15T00:00:00Z");
        request.setExpression(expression);
        Scroll scroll = new Scroll(3, null,null);
        request.setScroll(scroll);

        try {
            ScrollAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, ScrollAlertResponse.class);

            for (AlertVo datum : response.getData().getItems()) {
                System.out.println(datum.getAlertId() + " " + datum.getLocalOccurTime());
            }

            ScrollAlertRequest request1 = new ScrollAlertRequest();
            request1.setOrgId(orgId);
            scroll = new Scroll(0, response.getData().getPageToken(),null);
            request1.setScroll(scroll);
            request1.setStartOccurTime("2022-01-01T00:00:00Z");
            request1.setEndOccurTime("2022-02-15T00:00:00Z");
            try {
                ScrollAlertResponse response1 = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                        .url(url)
                        .getResponse(request1, ScrollAlertResponse.class);
                for (AlertVo datum : response1.getData().getItems()) {
                    System.out.println(datum.getAlertId() + " " + datum.getLocalOccurTime());
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }

    public void scollAlertWithOtherParams(String accessKey, String secretKey, String orgId, String url, String expression) {
        ScrollAlertRequest request = new ScrollAlertRequest();
        request.setOrgId(orgId);
        request.setStartOccurTime("2022-01-01T00:00:00Z");
        request.setEndOccurTime("2022-02-15T00:00:00Z");
        request.setExpression(expression);
        request.setActive(true);
//        request.setStartRecoverTime("2022-01-01T00:00:00Z");
//        request.setEndRecoverTime("2022-02-15T00:00:00Z");
        request.setInstanceId("ChahG3d9");
        request.setMetricId("temp");
        Scroll scroll = new Scroll(1, null,null);
        request.setScroll(scroll);

        try {
            ScrollAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, ScrollAlertResponse.class);

            for (AlertVo datum : response.getData().getItems()) {
                System.out.println(datum.getAlertId() + " " + datum.getLocalOccurTime());
            }

            ScrollAlertRequest request1 = new ScrollAlertRequest();
            request1.setOrgId(orgId);
            request1.setStartOccurTime("2022-01-01T00:00:00Z");
            request1.setEndOccurTime("2022-02-15T00:00:00Z");
            scroll = new Scroll(0, response.getData().getPageToken(),null);
            request1.setScroll(scroll);
            try {
                ScrollAlertResponse response1 = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                        .url(url)
                        .getResponse(request1, ScrollAlertResponse.class);

                for (AlertVo datum : response1.getData().getItems()) {
                    System.out.println(datum.getAlertId() + " " + datum.getLocalOccurTime());
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }

}
