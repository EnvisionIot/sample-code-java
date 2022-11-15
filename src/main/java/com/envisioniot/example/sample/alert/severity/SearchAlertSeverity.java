/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertSeverity
 * Author:   xibin.song
 * Date:     1/3/2022 10:42 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.alert.severity;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.api.common.constant.request.Sorter;
import com.envisioniot.enos.event_service.v2_1.SearchAlertSeverityRequest;
import com.envisioniot.enos.event_service.v2_1.SearchAlertSeverityResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/3/2022
 * @since 1.0.0
 */

public class SearchAlertSeverity {
    public void searchAlertSeverity(String accessKey, String secretKey, String orgId, String url) {
        SearchAlertSeverityRequest request = new SearchAlertSeverityRequest();
        request.setOrgId(orgId);

        //request.setExpression();

        Pagination pagination = new Pagination();
        pagination.setPageSize(10);
        pagination.setPageNo(1);
        Sorter sorter = new Sorter("severityId", Sorter.Order.ASC);
        List< Sorter > sorterList = new ArrayList< >();
        sorterList.add(sorter);
        pagination.setSorters(sorterList);
        request.setPagination(pagination);
        try {
            SearchAlertSeverityResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchAlertSeverityResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public void searchAlertSeveritywithExpressions(String accessKey, String secretKey, String orgId, String url, String expression) {
        SearchAlertSeverityRequest request = new SearchAlertSeverityRequest();
        request.setOrgId(orgId);
        request.setExpression(expression);
        Pagination pagination = new Pagination();
        pagination.setPageSize(10);
        pagination.setPageNo(1);
        Sorter sorter = new Sorter("severityId", Sorter.Order.ASC);
        List< Sorter > sorterList = new ArrayList< >();
        sorterList.add(sorter);
        pagination.setSorters(sorterList);
        request.setPagination(pagination);
        try {
            SearchAlertSeverityResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchAlertSeverityResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
