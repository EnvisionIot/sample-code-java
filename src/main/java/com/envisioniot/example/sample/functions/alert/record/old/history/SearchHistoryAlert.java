/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.alert.record.old.history;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.event_service.v2_1.SearchActiveAlertRequest;
import com.envisioniot.enos.event_service.v2_1.SearchActiveAlertResponse;
import com.envisioniot.enos.event_service.v2_1.SearchHistoryAlertRequest;
import com.envisioniot.enos.event_service.v2_1.SearchHistoryAlertResponse;
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

public class SearchHistoryAlert {
    public void searchHistoryAlert(String accessKey, String secretKey, String orgId, String url, String expression) {
        SearchHistoryAlertRequest request = new SearchHistoryAlertRequest ();
        request.setOrgId(orgId);
        request.setExpression(expression);
        Pagination pagination = new Pagination();
        pagination.setPageSize(5);
        pagination.setPageNo(1);
        request.setPagination(pagination);

        request.setStartOccurTime("2022-01-01T00:00:00Z");
        request.setEndOccurTime("2022-02-15T00:00:00Z");

        try {
            SearchHistoryAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchHistoryAlertResponse .class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void searchHistoryAlertWithScope(String accessKey, String secretKey, String orgId, String url, String expression) {
        SearchHistoryAlertRequest request = new SearchHistoryAlertRequest();
        request.setOrgId(orgId);
        request.setExpression(expression);

        // Optional
        request.setModelId("demo_lift_model");
        request.setMeasurepointId("temp");
        request.setAssetId("ChahG3d9");
        request.setIsMasked(false);
//        request.setMaskedBy("ChahG3d9:/DS1qMs91");

        request.setStartOccurTime("2022-01-18 15:31:09");
        request.setEndOccurTime("2022-02-18 15:31:09");

//        request.setRecoverStartTime("2022-01-18 15:31:09");
//        request.setRecoverEndTime("2022-02-18 15:31:09");

        request.setTreeId("YUKIakDo");

        Scope scope = new Scope();
        scope.setTreeId("YUKIakDo");
        scope.setFromAssetId("ChahG3d9");
        scope.setIncludeDerivative(false);
        request.setScope(scope);

        Pagination pagination = new Pagination();
        pagination.setPageSize(20);
        pagination.setPageNo(1);
        request.setPagination(pagination);
        try {
            SearchHistoryAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchHistoryAlertResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    //Not tested.
    public void searchHistoryAlertWithRootAlert(String accessKey, String secretKey, String orgId, String url, String expression) {
        SearchHistoryAlertRequest request = new SearchHistoryAlertRequest();
        request.setOrgId(orgId);
//        request.setExpression(expression);

        // Optional
        request.setModelId("demo_lift_model");
        request.setMeasurepointId("temp");
//        request.setAssetId("ChahG3d9");
//        request.setIsMasked(false);
//        request.setMaskedBy("ChahG3d9:/DS1qMs91");

        request.setStartOccurTime("2022-01-18 15:31:09");
        request.setEndOccurTime("2022-02-18 15:31:09");

        //Query the derivative alerts which are blocked by the specified root alert
        RootAlert rootAlert = new RootAlert();
        rootAlert.setRootAlertId("E8siEyRg");
        rootAlert.setTreeId("YUKIakDo");
        request.setRootAlert(rootAlert);

        Pagination pagination = new Pagination();
        pagination.setPageSize(20);
        pagination.setPageNo(1);
        request.setPagination(pagination);
        try {
            SearchHistoryAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchHistoryAlertResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
