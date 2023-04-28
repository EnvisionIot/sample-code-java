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
import com.envisioniot.enos.alert_service.v2_1.SearchAlertRequest;
import com.envisioniot.enos.alert_service.v2_1.SearchAlertResponse;
import com.envisioniot.enos.api.common.constant.request.Pagination;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class SearchAlert {
    public void searchAlert(String accessKey, String secretKey, String orgId, String url, String expression) {
        SearchAlertRequest request = new SearchAlertRequest ();
        request.setOrgId(orgId);
        request.setExpression(expression);
        Pagination pagination = new Pagination();
        pagination.setPageSize(5);
        pagination.setPageNo(1);
        request.setPagination(pagination);

        request.setStartOccurTime("2021-01-01T00:00:00Z");
        request.setEndOccurTime("2022-02-15T00:00:00Z");

        try {
            SearchAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchAlertResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public void searchAlertWithOtherParams(String accessKey, String secretKey, String orgId, String url, String expression) {
        SearchAlertRequest request = new SearchAlertRequest ();
        request.setOrgId(orgId);
        request.setExpression(expression);
        Pagination pagination = new Pagination();
        pagination.setPageSize(5);
        pagination.setPageNo(1);
        request.setPagination(pagination);

        request.setInstanceId("ChahG3d9");
        request.setMetricId("temp");
//        request.setStartRecoverTime("2022-01-01T00:00:00Z");
//        request.setEndRecoverTime("2022-02-15T00:00:00Z");

        request.setStartOccurTime("2021-01-01T00:00:00Z");
        request.setEndOccurTime("2022-02-15T00:00:00Z");

        request.setActive(true);

        try {
            SearchAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchAlertResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
